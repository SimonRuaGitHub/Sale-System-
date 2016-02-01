/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Data;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Simon Felipe Rua Vargas
 */
public class Data_Detail_Bill extends DataBase_Connection
{
       public void insert_detail_bill(String c_bill , String c_prod , int rquantity , long val_rq)
       {
              sql_i = "INSERT INTO det_pedidos(codigo_factura,codigo_producto,cantidad_producto,valor_por_cantidad) "
                      + "VALUES('"+c_bill+"','"+c_prod+"','"+rquantity+"','"+val_rq+"')";///////
              
             try
             {
                st = conect.createStatement();
                st.executeUpdate(sql_i);
             } 
             catch (SQLException ex)
             {
                   Logger.getLogger(Data_Detail_Bill.class.getName()).log(Level.SEVERE, null, ex);
                   JOptionPane.showMessageDialog(null,"you already buy the product"," ERROR ", JOptionPane.ERROR_MESSAGE);
             }
              
       }

    public void search_detail_bill(String cod_bill , JTable table_detail) 
    {
           short n_rows;
           DTM_tbl= (DefaultTableModel) table_detail.getModel();
           
           sql_i = "SELECT distinct codigo_producto , nombre , cantidad_producto , valor_por_cantidad " +
                   "FROM  det_pedidos INNER JOIN productos ON codigo_producto = codigo " +
                   "WHERE codigo_factura = '"+cod_bill+"'";
           
           n_rows = (short) DTM_tbl.getRowCount();
           
           try 
           {
               st = conect.createStatement();
               rs = st.executeQuery(sql_i);
               
               if(rs.next())
               {
                  rs.previous();
                  remove_rowsOnTable(n_rows);
                  data = get_Data();
                  put_DataTable();
               }
               
           } catch (SQLException ex) {
               Logger.getLogger(Data_Detail_Bill.class.getName()).log(Level.SEVERE, null, ex);
           }   
    }
    
    private void remove_rowsOnTable(short n_rows) 
    {
            short i;
              
            for(i = 0; i < n_rows ;i++)  
                DTM_tbl.removeRow(DTM_tbl.getRowCount() - 1);
    }

    private ArrayList get_Data() throws SQLException 
    {
            ArrayList<Data_Detail_Bill> data_Dbills = new ArrayList<>();
            
            while(rs.next())
            {
                Data_Detail_Bill d = new Data_Detail_Bill();
                d.code_product = String.valueOf(rs.getObject(1));
                d.names = String.valueOf(rs.getObject(2));
                d.req_quantity = String.valueOf(rs.getObject(3));
                d.val_rq = String.valueOf(rs.getObject(4));
                data_Dbills.add(d);
            }
           
            return data_Dbills;
    }

    private void put_DataTable() 
    {
            short i;
            int rq;
            Double val;
           
              
            for(i=0; i < data.size() ;i++)
            {
                DTM_tbl.addRow(new Object[1]);
                DTM_tbl.setValueAt(data.get(i).code_product, i , 0);
                DTM_tbl.setValueAt(data.get(i).names, i , 1);
                DTM_tbl.setValueAt(data.get(i).req_quantity, i , 2);
                DTM_tbl.setValueAt(data.get(i).val_rq ,i , 3);
            }     
    }
    
    public int sum_total_products(String c_bill)
    {
           int total_prod = 0;
           
           sql_i = "SELECT SUM(cantidad_producto) as total " +
                   "FROM det_pedidos " +
                   "WHERE codigo_factura = '"+c_bill+"'";
           
           try 
           {
               st = conect.createStatement();
               rs = st.executeQuery(sql_i);
               
               if(rs.next())
                   total_prod = rs.getInt("total"); // or --> rs.getInt(1);
                  
           } catch (SQLException ex) {
               Logger.getLogger(Data_Detail_Bill.class.getName()).log(Level.SEVERE, null, ex);
           }
           
           return total_prod;
    }

    public double sum_total_payable(String cod_bill) 
    {
           double total = 0;
           int rq; //-->rq: require quantity
           
           sql_i = "SELECT distinct codigo_producto , valor , cantidad_producto " +
                   "FROM det_pedidos inner join productos on codigo_producto = codigo " +
                   "WHERE codigo_factura = '"+cod_bill+"'";
           
           /*SELECT distinct codigo_factura , codigo_producto , nombre , cantidad_producto , valor 
             FROM  det_pedidos INNER JOIN productos ON codigo_producto = codigo
             WHERE codigo_factura = 12*/
           
          try {
               st = conect.createStatement();
               rs = st.executeQuery(sql_i);
               
               while(rs.next())
               {
                     rq = rs.getInt(3);
                     total += rs.getDouble(2)*rq;
               }
               
           } catch (SQLException ex) {
               Logger.getLogger(Data_Detail_Bill.class.getName()).log(Level.SEVERE, null, ex);
           }
           
           
           return total;
    }
}
