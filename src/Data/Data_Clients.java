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
public class Data_Clients extends DataBase_Connection
{
      public void insert_client(String Id , String Names , String Fln , String Sln , String Phone , String Cellphone) 
      {    
          ctc = false;
             
         if(Id.isEmpty() || Names.isEmpty() || Phone.isEmpty()|| Cellphone.isEmpty())
            JOptionPane.showMessageDialog(null,"seriouly bro fill all datas (except by the the second last name and first last name"
                    + "                         , it is only if you want)","ERROR INSERTING",JOptionPane.ERROR_MESSAGE);
         else
         {
            if(Confirm_numericFields(Id.trim() , Phone.trim() , Cellphone.trim()) && Confirm_letterFields(Sln.trim()+Fln.trim()+Names.trim()))
            {
               sql_i = "INSERT INTO clientes(ID,nombres,primer_apellido,segundo_apellido,telefono,celular) \n"
                      + " values("+Id.trim()+",'"+Names.trim()+"','"+Fln.trim()+"','"+Sln.trim()+"','"+Phone.trim()+"','"+Cellphone.trim()+"')";
           
               try //primero pasa por el try para verficar , si hay algun error se va al catch 
              { 
                  st = conect.createStatement();
                  st.executeUpdate(sql_i);
                  ctc = true;          
                  JOptionPane.showMessageDialog(null,"The client has been inserted successfully","DONE",JOptionPane.INFORMATION_MESSAGE);
               }
               catch (SQLException ex)
               {           
                      ctc = false;
                      JOptionPane.showMessageDialog(null,"sorry dude the ID or cellphone of this person exist already " +
                      "or you just insert the ID bad (dont insert it the ID with spaces or letters)","ERROR",JOptionPane.ERROR_MESSAGE);
                      System.out.println(ex.getMessage());
               }
            }
            else 
                ctc = false;
         }  
      }
      
      public void delete_client(String Id)
      {
             if(Id.isEmpty())
                JOptionPane.showMessageDialog(null,"Please deep the ID client","ERROR",JOptionPane.ERROR_MESSAGE);
             else 
             {
                 if( Confirm_numericFields( Id , String.valueOf(0) , String.valueOf(0) ) )
                 {   
                     sql_i = "DELETE FROM clientes WHERE ID = '"+Id+"'";
                 
                    try 
                   {
                       st = conect.createStatement();
                    
                      if(st.executeUpdate(sql_i) == 0)
                         JOptionPane.showMessageDialog(null,"The client has been not found","ERROR SEARCHING",JOptionPane.WARNING_MESSAGE);
                      else
                          JOptionPane.showMessageDialog(null,"The client has been deleted","DONE",JOptionPane.INFORMATION_MESSAGE);
                             
                   } catch (SQLException ex) {
                     System.out.println(ex.getMessage());
                      JOptionPane.showMessageDialog(null,ex.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
                   } 
                }
            }
      }
      
      public void search_client(String Id)
      {
             ctc = false;
             
            if(Id.isEmpty())
                JOptionPane.showMessageDialog(null,"Please deep the ID client","ERROR",JOptionPane.ERROR_MESSAGE);
            else
             {
                if(Confirm_numericFields( Id.trim() , String.valueOf(0) , String.valueOf(0) ))
                {
                   sql_i = "SELECT * FROM clientes WHERE ID = '"+Id.trim()+"'";
              
                   try 
                   {
                      st = conect.createStatement();
                      rs = st.executeQuery(sql_i);
                      
                      if(rs.next())
                      {
                         id = String.valueOf(rs.getObject(1));
                         names = String.valueOf(rs.getObject(2)); 
                         fln = String.valueOf(rs.getObject(3));
                         sln = String.valueOf(rs.getObject(4));
                         phone = String.valueOf(rs.getObject(5));
                         cellphone = String.valueOf(rs.getObject(6));
                         ctc = true;
                      }
                      else 
                      {
                          ctc = false;
                          JOptionPane.showMessageDialog(null,"the client has been not found","ERROR SEARCHING",JOptionPane.ERROR_MESSAGE);
                      }
                   }
                   catch (SQLException ex) 
                   {
                       System.out.println(ex.getMessage());
                       Logger.getLogger(Data_Clients.class.getName()).log(Level.SEVERE, null, ex);
                       ctc = false;
                   }
                }
             }
      }
      
      public void set_ID(String Id)
      {
             id = Id;
      }
      
      public void update_client(String ID , String Names,String Fln , String Sln , String Phone , String Cellphone)
      {

         if(Confirm_numericFields(ID.trim() , Phone.trim() , Cellphone.trim()) && Confirm_letterFields(Sln.trim()+Fln.trim()+Names.trim()))
         {
             sql_i = "UPDATE clientes SET ID ='"+ID.trim()+"' , nombres ='"+Names+"' , "
                      + " primer_apellido ='"+Fln+"' , segundo_apellido = '"+Sln+"' , "
                      + " telefono = '"+Phone.trim()+"' ,celular = '"+Cellphone.trim()+"'"
                      + " WHERE ID='"+id+"'";
         
              try 
              {
                  st = conect.createStatement();
                  if(st.executeUpdate(sql_i) == 0)
                      JOptionPane.showMessageDialog(null,"the client has been not found or you forgot search the client","fail",JOptionPane.ERROR_MESSAGE);             
                  else 
                      JOptionPane.showMessageDialog(null,"the client has been update","DONE",JOptionPane.INFORMATION_MESSAGE);
                  
              } catch (SQLException ex) {
                  System.out.println(ex.getMessage());
                  Logger.getLogger(Data_Clients.class.getName()).log(Level.SEVERE, null, ex);
                  JOptionPane.showMessageDialog(null, ex.getMessage(),"UPDATING ERROR",JOptionPane.ERROR_MESSAGE);
               }
         }  
      }
      
      public int count_clients()
      {
          int num = 0;
          
          sql_i = "SELECT count(ID) FROM clientes";
          
          try 
          {
              st = conect.createStatement();
              rs = st.executeQuery(sql_i);
              
              if(rs.next())
                 num = rs.getInt(1);
                 
          } catch (SQLException ex) {
              Logger.getLogger(Data_Clients.class.getName()).log(Level.SEVERE, null, ex);
          }
          
          return num;
      }
      
      public void searchAll_clients(JTable tbl_Clients)
      {
             short n_rows;
             DTM_tbl= (DefaultTableModel) tbl_Clients.getModel();
             
             sql_i = "SELECT * FROM clientes";
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
                    JOptionPane.showMessageDialog(null,"There are not clients","ADVERTECIMENT",JOptionPane.WARNING_MESSAGE);
            } catch (SQLException ex) {
              Logger.getLogger(Data_Clients.class.getName()).log(Level.SEVERE, null, ex);
           }
             
      }

    private void remove_rowsOnTable(short n_rows) 
    {
            short i;
              
            for(i = 0; i < n_rows ;i++)  
                DTM_tbl.removeRow(DTM_tbl.getRowCount() - 1);
    }

    private ArrayList get_data() throws SQLException
    {
            ArrayList<Data_Clients> data_clients = new ArrayList<>();
            
            while(rs.next())
            {
                   Data_Clients d = new Data_Clients();
                   d.id = String.valueOf(rs.getObject(1));
                   d.names = (String) rs.getObject(2);
                   d.fln = (String) rs.getObject(3);
                   d.sln = (String) rs.getObject(4);
                   d.phone = (String) rs.getObject(5);
                   d.cellphone = (String) rs.getObject(6);                      
                   data_clients.add(d);
            }
            
            return data_clients;
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
}
 