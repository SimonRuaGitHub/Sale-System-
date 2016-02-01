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
public class Data_Products extends DataBase_Connection
{  
       public String  id_product = "" , product_name = "", type , mark , value , quantity , supplier_ID;
       ArrayList<Data_Products> data_pro =new ArrayList<>();
       
       public void insert_products(String name , String type , String mark , String quantity , String value , String supplier_ID)
       {
             ctc = false;
           if(name.isEmpty() || type.isEmpty() || mark.isEmpty() || value.isEmpty() || quantity.isEmpty() || supplier_ID.isEmpty() ) //|| Supplier_ID.isEmpty()
              JOptionPane.showMessageDialog(null,"fill the all data please","ERROR", JOptionPane.ERROR_MESSAGE);
           else
           {
               sql_i = "INSERT INTO productos(nombre , tipo , marca , cantidad_disponible ,valor , proveedores_ID)"
                       + "VALUES ('"+name.trim()+"', '"+type.toLowerCase().trim()+"', '"+mark.toLowerCase().trim()+"', '"+quantity.trim()+"', '"+value.trim()+"','"+supplier_ID.trim()+"')";
            
               if(Confirm_numericFields(value.trim() , quantity.trim() , supplier_ID.trim())) // supplier_ID.trim()
               {
                  try 
                  {
                     st = conect.createStatement();
                     st.executeUpdate(sql_i); 
                     JOptionPane.showMessageDialog(null,"The product has been inserted successfully","DONE",JOptionPane.INFORMATION_MESSAGE);
                     ctc = true;
                  } 
                  catch (SQLException ex) 
                  {
                       System.err.println(ex.getMessage());
                       JOptionPane.showMessageDialog(null,ex.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
                       Logger.getLogger(Data_Products.class.getName()).log(Level.SEVERE, null, ex);
                       ctc = false;
                  }
               }
           }
       }
       
       public void search_product(String Name)
       {
              ctc = false;
              
              if(Name.isEmpty())
                  JOptionPane.showMessageDialog(null,"Please type the product's name to search the product" ,"  ERROR  ", JOptionPane.ERROR_MESSAGE);
              else
              {
                    sql_i = "select * from PRODUCTOS"
                            + " where nombre = '"+Name.trim()+"'";
                            
                   try 
                   {
                      st = conect.createStatement();
                      rs = st.executeQuery(sql_i);
                      
                      if(rs.next())
                      {
                          id_product =  String.valueOf(rs.getObject(1));
                          product_name = (String) rs.getObject(2);
                          type = (String) rs.getObject(3);
                          mark = (String) rs.getObject(4);
                          quantity = String.valueOf(rs.getObject(5));
                          value = String.valueOf(rs.getObject(6));
                          supplier_ID = String.valueOf(rs.getObject(7));      
                          ctc = true;
                      }
                      else 
                      {
                          JOptionPane.showMessageDialog(null,"THIS PRODUCT DOESN'T EXIST","ERROR", JOptionPane.ERROR_MESSAGE);
                          ctc = false;
                      }
                      
                   } catch (SQLException ex) {
                      ctc = false;
                      Logger.getLogger(Data_Products.class.getName()).log(Level.SEVERE, null, ex);
                     JOptionPane.showMessageDialog(null,ex.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
                   }                
              }
       }
       
       public void update_product(String Name , String Type , String Mark , String Quantity , String Value , String Supplier_ID)
       {    
            if(Name.isEmpty()|| Type.isEmpty() || Mark.isEmpty() || Value.isEmpty() || Quantity.isEmpty() || Supplier_ID.isEmpty() )
               JOptionPane.showMessageDialog(null,"you must deep all the data","ERROR DEEPING DATA", JOptionPane.WARNING_MESSAGE);
            else
            {
                if(Confirm_numericFields(Value.trim() , Quantity.trim() , Supplier_ID.trim())) //Supplier_ID.trim()
                {
                   sql_i = "update PRODUCTOS "
                        + "set nombre = '"+Name.trim()+"' , tipo = '"+Type.toLowerCase().trim()+"' "
                        + ", marca = '"+Mark.toLowerCase().trim()+"' , valor = '"+Value.trim()+"' "
                        + ", cantidad_disponible = '"+Quantity.trim()+"' , Proveedores_ID = '"+Supplier_ID.trim()+"'  "
                        + "where nombre = '"+product_name.trim()+"'";
                 
                   try 
                   {
                      st = conect.createStatement();
                      
                      if(st.executeUpdate(sql_i) == 0)
                          JOptionPane.showMessageDialog(null,"the product has not been found" , "ERROR SEARCHING PRODUCT" ,JOptionPane.ERROR_MESSAGE);
                      else 
                          JOptionPane.showMessageDialog(null,"the product has been modificated successfully");
                      
                    } 
                   catch (SQLException ex) 
                    {
                      Logger.getLogger(Data_Products.class.getName()).log(Level.SEVERE, null, ex);
                      JOptionPane.showMessageDialog(null, ex.getMessage() , "ERROR" ,JOptionPane.ERROR_MESSAGE);            
                    } 
                }     
           }            
       }
   
    public void update_aviable_quantity(String ID_product , String quantity)
    {
           sql_i = "UPDATE productos SET cantidad_disponible = '"+quantity+"' "
                 + "WHERE codigo = '"+ID_product+"'";
           
           try 
           {
               st = conect.createStatement();
               st.executeUpdate(sql_i);
           } catch (SQLException ex) {
               Logger.getLogger(Data_Products.class.getName()).log(Level.SEVERE, null, ex);
               JOptionPane.showMessageDialog(null, ex.getMessage() , "ERROR" ,JOptionPane.ERROR_MESSAGE); 
           }
           
           
    }
    

    public void delete_product(String Name)
    {
           sql_i = "delete from PRODUCTOS where nombre = '"+Name.trim()+"'";

           try 
           {
               st = conect.createStatement();
               
               if(st.executeUpdate(sql_i) == 0)
                  JOptionPane.showMessageDialog(null,"the product has not been found" , "ERROR SEARCHING PRODUCT" ,JOptionPane.ERROR_MESSAGE);
               else
                  JOptionPane.showMessageDialog(null,"the product has been deleted" , "DONE"  , JOptionPane.INFORMATION_MESSAGE);
               
           } catch (SQLException ex) {
               JOptionPane.showMessageDialog(null, ex.getMessage() , "ERROR" ,JOptionPane.ERROR_MESSAGE);
               Logger.getLogger(Data_Products.class.getName()).log(Level.SEVERE, null, ex);
           }           
    }
    
    public void setproduct_name(String product_name)
    {
           this.product_name = product_name;
    }
    
    public int count_products()
    {
           int num = 0;
           
           sql_i = "SELECT count(codigo) FROM productos";
           
           try {
                st = conect.createStatement();
                rs = st.executeQuery(sql_i);
                
                if(rs.next())
                   num = rs.getInt(1);
                
           } catch (SQLException ex) {
               Logger.getLogger(Data_Products.class.getName()).log(Level.SEVERE, null, ex);
           }
      
           return num;        
    }
    
    public void investigate_products(JTable tbl_products)
    {
           short i = 0 , n_rows;
           DTM_tbl= (DefaultTableModel) tbl_products.getModel();
        
           sql_i = "SELECT * FROM productos";
           n_rows = (short) DTM_tbl.getRowCount();
           
           try 
           {
               st = conect.createStatement();
               rs = st.executeQuery(sql_i);
                            
               if(rs.next())
               {
                  rs.previous();
                  remove_rowsOnTable(n_rows);
                  data_pro = get_Data();
                  System.out.println(data_pro.size());               
                  put_DataTable();
               }
               else
               {
                    remove_rowsOnTable(n_rows);
                    JOptionPane.showMessageDialog(null ,"There are not products","ERROR",JOptionPane.WARNING_MESSAGE);
               }   
           } catch (SQLException ex) {
               JOptionPane.showMessageDialog(null ,ex.getMessage(),"ERROR", JOptionPane.ERROR_MESSAGE);
                Logger.getLogger(Data_Products.class.getName()).log(Level.SEVERE, null, ex);
           }       
    }
    
    private ArrayList get_Data() throws SQLException 
    {
          ArrayList<Data_Products> data_products = new ArrayList<>();
          
          while(rs.next())
          {           
               Data_Products d =  new Data_Products();
               d.id_product = String.valueOf(rs.getObject(1));
               d.product_name = (String) rs.getObject(2);
               d.type = (String) rs.getObject(3);
               d.mark = (String) rs.getObject(4);
               d.quantity = String.valueOf(rs.getObject(5));
               d.value = String.valueOf(rs.getObject(6));  
               d.supplier_ID = String.valueOf(rs.getObject(7)); 
               data_products.add(d);
          }                
             
          return data_products;
    }

    private void put_DataTable()
    {
            short i;
              
            for(i=0; i < data_pro.size() ;i++)
            {
                DTM_tbl.addRow(new Object[1]);
                DTM_tbl.setValueAt(data_pro.get(i).id_product, i , 0);
                DTM_tbl.setValueAt(data_pro.get(i).product_name, i , 1);
                DTM_tbl.setValueAt(data_pro.get(i).type, i , 2);
                DTM_tbl.setValueAt(data_pro.get(i).mark, i , 3);
                DTM_tbl.setValueAt(data_pro.get(i).quantity, i , 4);
                DTM_tbl.setValueAt(data_pro.get(i).value, i , 5);
                DTM_tbl.setValueAt(data_pro.get(i).supplier_ID, i , 6);
            }     
    }
    
     public void investigate_products_shopping(JTable tbl_products)
    {
           short i = 0 , n_rows;
           DTM_tbl= (DefaultTableModel) tbl_products.getModel();
        
           sql_i = "SELECT * FROM productos WHERE cantidad_disponible > 0";
           n_rows = (short) DTM_tbl.getRowCount();
           
           try 
           {
               st = conect.createStatement();
               rs = st.executeQuery(sql_i);
                            
               if(rs.next())
               {
                  rs.previous();
                  remove_rowsOnTable(n_rows);
                  data_pro = get_Data_shopping();
                  System.out.println(data_pro.size());               
                  put_DataTable_shopping();
               }
               else
               {
                    remove_rowsOnTable(n_rows);
                    JOptionPane.showMessageDialog(null ,"There are not products","ERROR",JOptionPane.WARNING_MESSAGE);
               }   
           } catch (SQLException ex) {
               JOptionPane.showMessageDialog(null ,ex.getMessage(),"ERROR", JOptionPane.ERROR_MESSAGE);
                Logger.getLogger(Data_Products.class.getName()).log(Level.SEVERE, null, ex);
           }       
    }
    
    private void remove_rowsOnTable(short n_rows)
    {
            short i;
              
            for(i = 0; i < n_rows ;i++)  
                DTM_tbl.removeRow(DTM_tbl.getRowCount() - 1);
    }
   
    private ArrayList get_Data_shopping() throws SQLException 
    {
          ArrayList<Data_Products> data_products = new ArrayList<>();
          
          while(rs.next())
          {           
               Data_Products d =  new Data_Products();
               d.id_product = String.valueOf(rs.getObject(1));
               d.product_name = (String) rs.getObject(2);
               d.type = (String) rs.getObject(3);
               d.mark = (String) rs.getObject(4);
               d.quantity = String.valueOf(rs.getObject(5));
               d.value = String.valueOf(rs.getObject(6));  
               data_products.add(d);
          }                
             
          return data_products;
    }

    private void put_DataTable_shopping()
    {
            short i;
              
            for(i=0; i < data_pro.size() ;i++)
            {
                DTM_tbl.addRow(new Object[1]);
                DTM_tbl.setValueAt(data_pro.get(i).id_product , i , 0);
                DTM_tbl.setValueAt(data_pro.get(i).product_name, i , 1);
                DTM_tbl.setValueAt(data_pro.get(i).type, i , 2);
                DTM_tbl.setValueAt(data_pro.get(i).mark, i , 3);
                DTM_tbl.setValueAt(data_pro.get(i).quantity, i , 4);
                DTM_tbl.setValueAt(data_pro.get(i).value, i , 5);
            }     
    }
}
