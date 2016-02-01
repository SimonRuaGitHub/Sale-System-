/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Data;


import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Simon Felipe Rua Vargas
 */
public class Data_Bill extends DataBase_Connection
{
    Date purchase_date;
     
    public void insert_order_forAC(String id_seller, String id_client) 
    {
        
            SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd"); //df : date formarter
            purchase_date = new Date();
            
            sql_i = "INSERT INTO pedidos_facturas(fecha_compra , vendedor_cedula , cliente_ID) " +
                    " VALUES('"+df.format(purchase_date)+"','"+id_seller+"','"+id_client+"')";
        try 
        {      
            st = conect.createStatement();
            st.executeUpdate(sql_i);
            System.out.println("order created with success");
        } catch (SQLException ex) {
            Logger.getLogger(Data_Bill.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void insert_order()
    {
          SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd"); //df : date formarter
          purchase_date = new Date();
          
          sql_i = "INSERT INTO pedidos_facturas(fecha_compra) VALUES('"+df.format(purchase_date)+"')";
          
          try
          {
              st = conect.createStatement();
              st.executeUpdate(sql_i);
              System.out.println("order presented");
          }
          catch(SQLException ex)
          {
                System.out.println(ex.getMessage());
          }
    }
    
    @SuppressWarnings("empty-statement")
    public String get_code_bill() 
    {          
          sql_i = "SELECT max(codigo) FROM pedidos_facturas";
           
          try 
          {
             st = conect.createStatement();
             rs = st.executeQuery(sql_i);
            
             rs.next();           
             System.err.println("code bill: "+ rs.getObject(1));
                       
             return String.valueOf(rs.getObject(1));   
          }
          catch (SQLException ex)
          {
             Logger.getLogger(Data_Bill.class.getName()).log(Level.SEVERE, null, ex);
             System.out.println(ex.getMessage());
             
             return "";
          }
           
    }

}
