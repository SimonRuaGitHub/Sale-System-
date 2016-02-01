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
public class Data_Sellers extends DataBase_Connection
{      
//      DefaultTableModel DTM_tblsellers;
      
      public void insert_seller(String Id , String Names , String Fln , String Sln , String Phone , String Cellphone) 
      {    
         ctc = false;
             
         if(Id.isEmpty() || Names.isEmpty() || Fln.isEmpty() || Phone.isEmpty()|| Cellphone.isEmpty())
            JOptionPane.showMessageDialog(null,"Seriouly bro fill all datas (except by the the second last name , it is only if you want)","ERROR",JOptionPane.INFORMATION_MESSAGE);
         else
         {
            if(Confirm_numericFields(Id.trim() , Phone.trim() , Cellphone.trim()) && Confirm_letterFields(Sln.trim()+Fln.trim()+Names.trim()))
            {
               sql_i = "insert into VENDEDORES(cedula,nombres,primer_apellido,segundo_apellido,telefono,celular) \n"
                      + " values("+Id.trim()+",'"+Names.trim()+"','"+Fln.trim()+"','"+Sln.trim()+"','"+Phone.trim()+"','"+Cellphone.trim()+"')";
           
               try //primero pasa por el try para verficar , si hay algun error se va al catch 
              { 
                  st = conect.createStatement();
                  st.executeUpdate(sql_i);
                  ctc = true;          
                  JOptionPane.showMessageDialog(null,"The seller has been inserted successfully","DONE",JOptionPane.INFORMATION_MESSAGE);
               }
               catch (SQLException ex)
               {           
                      ctc = false;
                      JOptionPane.showMessageDialog(null,ex.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
                      Logger.getLogger(DataBase_Connection.class.getName()).log(Level.SEVERE, null, ex);
                      System.out.println(ex.getMessage());
               }
            }
         }  
      }
         
      //!!!RECORDA cedula = id!!!
      public void delete_seller(String ID)
      {
          sql_i = "delete from vendedores WHERE cedula='"+ID.trim()+"'";            
          
          if(ID.isEmpty())         
             JOptionPane.showMessageDialog(null,"Seriously bro I wont find nobody without the ID","ERROR",JOptionPane.ERROR_MESSAGE);        
          else 
          {
             try 
             {
                st = conect.createStatement();
               
                if(st.executeUpdate(sql_i) == 0)  // retorna un 0 cuando no encuentra al vendedor
                   JOptionPane.showMessageDialog(null,"Sorry man this seller doesn't exist","ERROR",JOptionPane.ERROR_MESSAGE);
                else 
                    JOptionPane.showMessageDialog(null,"The seller has been deleted","DONE",JOptionPane.INFORMATION_MESSAGE);
              
             } catch (SQLException ex) {            
                    JOptionPane.showMessageDialog(null,ex.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
                    Logger.getLogger(DataBase_Connection.class.getName()).log(Level.SEVERE, null, ex);
                    System.out.println(ex.getMessage());
             }
          }
      }
    
      public void investigate_seller_ID(String ID) //recordar la forma por como se seleccionan las columnas en consulta y consiguen en getObject , es por numero nombre de la columna en la base de datos respectiva
      {         
              ctc = false;
              sql_i = "select * from vendedores where cedula = '"+ID.trim()+"'";
             
              
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
                        JOptionPane.showMessageDialog(null,"Sorry man this seller doesn't exist","ERROR",JOptionPane.ERROR_MESSAGE);
                    }
                       
                } 
                catch (SQLException ex) 
                {
                       Logger.getLogger(DataBase_Connection.class.getName()).log(Level.SEVERE, null, ex);
                       JOptionPane.showMessageDialog(null,ex.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
                       System.out.println(ex.getMessage());
                       ctc = false;
                }
      }

      public void setId(String id) {
        this.id = id;
      }    
 
      public void update_seller(String ID , String Names,String Fln , String Sln , String Phone , String Cellphone)
      {
             sql_i = "UPDATE vendedores SET cedula ='"+ID.trim()+"' , nombres ='"+Names.trim()+"' , "
                      + " primer_apellido ='"+Fln.trim()+"' , segundo_apellido = '"+Sln.trim()+"' , "
                      + " telefono = '"+Phone.trim()+"' ,celular = '"+Cellphone.trim()+"'"
                      + " WHERE cedula='"+id.trim()+"'";
             
         try 
         {        
              st = conect.createStatement();
              if(st.executeUpdate(sql_i) == 0)   
                 JOptionPane.showMessageDialog(null,"The seller has been not found or \n"
                                               + "you just didn't modificate it properly from the table","fail",JOptionPane.ERROR_MESSAGE);
              else
                  JOptionPane.showMessageDialog(null,"The seller's data has been modificated ","DONE",JOptionPane.INFORMATION_MESSAGE);
              
          } catch (SQLException ex) {
                 JOptionPane.showMessageDialog(null, ex.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
                 Logger.getLogger(DataBase_Connection.class.getName()).log(Level.SEVERE, null, ex);
          }
      }
      
      public int count_sellers() 
      {
             int num = 0;
              
             sql_i = "SELECT count(cedula) FROM vendedores";
             
         try 
         {      
              st = conect.createStatement();
              rs = st.executeQuery(sql_i);              
              
              if(rs.next())
                 num = rs.getInt(1);
                      
          } catch (SQLException ex) {
              Logger.getLogger(Data_Sellers.class.getName()).log(Level.SEVERE, null, ex);
              System.out.println(ex.getMessage());
          }
         
          return num;
      }
      
      public void investigate_sellers(JTable tbl_sellers) //recordar la forma por como se seleccionan las columnas en consulta y consiguen en getObject , es por numero nombre de la columna en la base de datos respectiva
      {     
           short i = 0 , n_rows;
           DTM_tbl= (DefaultTableModel) tbl_sellers.getModel();
           
           sql_i = "select * from vendedores";        
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
                        remove_rowsOnTable(n_rows);  
                        JOptionPane.showMessageDialog(null,"There are not sellers","ADVERTECIMENT",JOptionPane.WARNING_MESSAGE);
                    } 
                }
                catch(SQLException ex) 
                {
                  Logger.getLogger(DataBase_Connection.class.getName()).log(Level.SEVERE, null, ex);
                  JOptionPane.showMessageDialog(null,ex.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
                  System.out.println(ex.getMessage());
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
             ArrayList<Data_Sellers> data_sellers = new ArrayList<>();
            
             while(rs.next())
             {           
                   Data_Sellers d =  new Data_Sellers();
                   d.id = String.valueOf(rs.getObject(1));
                   d.names = (String) rs.getObject(2);
                   d.fln = (String) rs.getObject(3);
                   d.sln = (String) rs.getObject(4);
                   d.phone = (String) rs.getObject(5);
                   d.cellphone = (String) rs.getObject(6);                      
                   data_sellers.add(d);
             }                
             
             return  data_sellers;
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

/* void insert_seller() throws SQLException 
      {   
          //SE RECOMIENDA USAR este codigo por razones de seguridad pero ,se debe probar con el otro
           sql_i = "insert into VENDEDORES(cedula,nombres,primer_apellido,segundo_apellido,telefono,celular) \n"
                        +" values(?,?,?,?,?,?)" ;//  + " values("+(int)1123999398+",'Carlos','Gaviria','Gutierrez','498 78 98','323 456 789')";
          
           TRY//hacer consulta antes de insersion para validar 
          { 
             
             pst = conect.prepareStatement(sql_i);
             pst.setInt(1 , 1123999398);  1
             pst.setString(2 , "Camila");
             pst.setString(3 , "Valencia");
             pst.setString(4 , "Mesa");
             pst.setString(5 , "438 78 80");
             pst.setString(6 , "320 489 756");
             pst.executeUpdate();
          } 
          catch (SQLException ex) 
          {
                 JOptionPane.showMessageDialog(null,"error in the datas");
                 System.out.println(ex.getMessage());//JOptionPane.showMessageDialog(null,"","ERROR",JOptionPane.ERROR_MESSAGE); // ex.printStackTrace();
          }
          finally
          {
                 if (pst != null) 
		     pst.close();
                 
 
                 if (conect != null) 
                     conect.close();			
          }
          
          
      }*/