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
public class Data_Suppliers extends DataBase_Connection
{    
//       DefaultTableModel DTM_tblSupplier;
       
      public void insert_supplier(String Id , String Names , String Fln , String Sln , String Phone , String Cellphone) 
      {          
           ctc = false;
               
           if(Id.isEmpty() || Names.isEmpty() || Phone.isEmpty()|| Cellphone.isEmpty())
              JOptionPane.showMessageDialog(null,"seriouly bro fill all datas (except by the the second last name , it is only if you want)","ERROR",JOptionPane.INFORMATION_MESSAGE);
           else
           {
               if(Confirm_numericFields(Id , Phone , Cellphone) && Confirm_letterFields(Sln.trim()+Fln.trim()+Names.trim()))
               {
                  sql_i = "insert into PROVEEDORES(ID,nombres,primer_apellido,segundo_apellido,telefono,celular) \n"
                      + " values("+Id.trim()+",'"+Names.trim()+"','"+Fln.trim()+"','"+Sln.trim()+"','"+Phone.trim()+"','"+Cellphone.trim()+"')";
           
                  try //primero pasa por el try para verficar , si hay algun error se va al catch 
                  { 
                     st = conect.createStatement();
                     st.executeUpdate(sql_i);
                     ctc = true;          
                     JOptionPane.showMessageDialog(null,"The supplier has been inserted successfully","DONE",JOptionPane.INFORMATION_MESSAGE);              
                  } 
                  catch(SQLException ex)
                  {            
                        ctc = false;
                        JOptionPane.showMessageDialog(null,ex.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
                        Logger.getLogger(DataBase_Connection.class.getName()).log(Level.SEVERE, null, ex);
                        System.out.println(ex.getMessage());
                  }
               } 
               else ctc = false;
            } 
      }
      
      public void delete_supplier(String ID)
      {
          sql_i = "delete from proveedores WHERE ID ='"+ID.trim()+"'";            
          
          if(ID.isEmpty())         
             JOptionPane.showMessageDialog(null,"seriously bro I wont find nobody without the ID","ERROR",JOptionPane.ERROR_MESSAGE);        
          else 
          {
             try 
             {
                st = conect.createStatement();
               
                if(st.executeUpdate(sql_i) == 0)  // retorna un 0 cuando no encuentra al vendedor
                   JOptionPane.showMessageDialog(null,"sorry man this supplier doesn't exist","ERROR",JOptionPane.ERROR_MESSAGE);
                else 
                    JOptionPane.showMessageDialog(null,"The supplier has been deleted","DONE",JOptionPane.INFORMATION_MESSAGE);
              
             } catch (SQLException ex) {            
                    Logger.getLogger(DataBase_Connection.class.getName()).log(Level.SEVERE, null, ex);
                    System.out.println(ex.getMessage());
                    JOptionPane.showMessageDialog(null,ex.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
             }
          }
      }
      
      public void investigate_supplier_ID(String ID) //recordar la forma por como se seleccionan las columnas en consulta y consiguen en getObject , es por numero nombre de la columna en la base de datos respectiva
      {          
           sql_i = "select * from proveedores where ID = '"+ID.trim()+"'";
           ctc = false;
           
                try 
                {
                    st = conect.createStatement();
                    rs = st.executeQuery(sql_i);
                    if(rs.next())
                    {
                        id = String.valueOf(rs.getObject(1));
                        names = (String) rs.getObject(2);
                        fln = (String) rs.getObject(3);
                        sln = (String) rs.getObject(4);
                        phone = (String) rs.getObject(5);
                        cellphone = (String) rs.getObject(6);
                        ctc = true;
                    }
                    else
                    {
                        ctc = false;
                        JOptionPane.showMessageDialog(null,"sorry man this seller doesn't exist","ERROR",JOptionPane.ERROR_MESSAGE);
                    }
                       
                } catch (SQLException ex) {
                  JOptionPane.showMessageDialog(null,ex.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
                  Logger.getLogger(DataBase_Connection.class.getName()).log(Level.SEVERE, null, ex);
                }
      }
    
      public void update_supplier(String ID , String Names, String Fln , String Sln , String Phone , String Cellphone)
      {
           sql_i = "UPDATE proveedores SET ID ='"+ID.trim()+"' , nombres ='"+Names.trim()+"' , "
                      + " primer_apellido ='"+Fln.trim()+"' , segundo_apellido = '"+Sln.trim()+"' , "
                      + " telefono = '"+Phone.trim()+"' ,celular = '"+Cellphone.trim()+"'"
                      + " WHERE ID ='"+id.trim()+"'";
             
           try 
           {
              
              st = conect.createStatement();
              if(st.executeUpdate(sql_i) == 0) //retorna 0 cuando no encuentra al proveedor
                  JOptionPane.showMessageDialog(null,"Supplier has been not found", "ERROR", JOptionPane.ERROR_MESSAGE);
              else
                  JOptionPane.showMessageDialog(null,"The supplier's data has been modificated ","DONE",JOptionPane.INFORMATION_MESSAGE);
                
            } catch (SQLException ex) {
   //unblock it in case of error   Logger.getLogger(DataBase_Connection.class.getName()).log(Level.SEVERE, null, ex);
              JOptionPane.showMessageDialog(null,ex.getMessage(),"ERROR ",JOptionPane.ERROR_MESSAGE);
              System.out.println(ex.getMessage());
            }
      }
                            
      public void investigate_supplier(JTable tbl_supplier) //recordar la forma por como se seleccionan las columnas en consulta y consiguen en getObject , es por numero nombre de la columna en la base de datos respectiva
      {     
           short i , n_rows = 0;
           DTM_tbl= (DefaultTableModel) tbl_supplier.getModel();
          
           sql_i = "select * from proveedores WHERE ID != 0";   // "select * from proveedores" 
           n_rows = (short) DTM_tbl.getRowCount();
                   
                try 
                {
                    st = conect.createStatement();
                    rs = st.executeQuery(sql_i);  
                    
                    if(rs.next())
                    {     
                        rs.previous();
                        remove_rowsOnTable(n_rows);                     
                        data = get_data();  
                        System.out.println(data.size());
                        put_DataTable();
                    }
                    else
                    {
                        ctc = false;
                        remove_rowsOnTable(n_rows); 
                        JOptionPane.showMessageDialog(null,"There are not suppliers","ERROR",JOptionPane.ERROR_MESSAGE);
                    } 
                }
                catch(SQLException ex) 
                {
                  //    Logger.getLogger(DataBase_Connection.class.getName()).log(Level.SEVERE, null, ex);
                      JOptionPane.showMessageDialog(null,ex.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
                      System.err.println(ex.getMessage());
                }           
      }    
      
      public int count_suppliers()
      {
             int num = 0;
             
             sql_i = "SELECT count(ID) FROM proveedores";
             
          try 
          {
              st = conect.createStatement();
              rs = st.executeQuery(sql_i);
              
              if(rs.next())
                 num = rs.getInt(1);
          } catch (SQLException ex) {
              Logger.getLogger(Data_Suppliers.class.getName()).log(Level.SEVERE, null, ex);
          }
             
            return num;      
      }
      
      private ArrayList get_data() throws SQLException
      {
             ArrayList<Data_Suppliers> data_suppliers = new ArrayList<>();
            
             while(rs.next())
             {           
                   Data_Suppliers d =  new Data_Suppliers();
                   d.id = String.valueOf(rs.getObject(1));
                   d.names = (String) rs.getObject(2);
                   d.fln = (String) rs.getObject(3);
                   d.sln = (String) rs.getObject(4);
                   d.phone = (String) rs.getObject(5);
                   d.cellphone = (String) rs.getObject(6);                      
                   data_suppliers.add(d);                        
             }                
             
             return  data_suppliers;
      }

      private void put_DataTable()
      {
              short i;
              
              for(i=0; i < data.size() ;i++)
              {
                  DTM_tbl.addRow(new Object[1]);
                  DTM_tbl.setValueAt(data.get(i).id, i , 0);
                  DTM_tbl.setValueAt(data.get(i).names, i , 1);
                  DTM_tbl.setValueAt(data.get(i).fln, i , 2);
                  DTM_tbl.setValueAt(data.get(i).sln, i , 3);
                  DTM_tbl.setValueAt(data.get(i).phone, i , 4);
                  DTM_tbl.setValueAt(data.get(i).cellphone, i , 5);
               }     
      }
      
      private void remove_rowsOnTable(short n_rows)
      {
              short i;
              
              for(i = 0; i < n_rows ;i++)  
                  DTM_tbl.removeRow(DTM_tbl.getRowCount() - 1);
      }
      
      
     public void setId(String id) {
        this.id = id;
     }
     
    
         
}


    

