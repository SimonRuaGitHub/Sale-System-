/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Simon Felipe Rua Vargas
 */
public class DataBase_Connection
{
              PreparedStatement pst;
              Statement st;
       public Connection conect;
              String sql_i;
              ResultSet rs;
              int rows = 0;
       public String id  ,names, fln , sln , phone ,cellphone;
       public boolean ctc = false;
              ArrayList<DataBase_Connection> data =new ArrayList<>();       
              DefaultTableModel DTM_tbl;
      String code_bill , code_product , req_quantity , value , val_rq;
   
      public void connect_DB()
      {
           try 
           {
               System.out.println("Conectando");
               Class.forName("com.mysql.jdbc.Driver");
               conect = DriverManager.getConnection("jdbc:mysql://localhost:3306/db-sellers","root","balkiria2gm");
               System.out.println("Conexion exitosa");
           }
           catch(ClassNotFoundException | SQLException e)
           {
                 JOptionPane.showMessageDialog(null,"it has been happent an error in the bd conection","ERROR",JOptionPane.ERROR_MESSAGE);
                 System.err.println(e.getMessage());
           }
      }
      
   public void disconnect_DB()
   {
            
         try {
            conect.close();
            System.out.println("cierro");
            return;
        } catch (SQLException ex) {
            Logger.getLogger(DataBase_Connection.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("no cierro bien");
        }
    }
   
    protected boolean Confirm_numericFields(String data1 , String data2  , String data3) //improve validation, find another way
    {
            double num_proof1 = 0 , num_proof2  = 0 , num_proof3 = 0;  //long is not so useful for decimal values, it throws a exception
            
            try 
            {
                num_proof1 = Double.parseDouble(data1);
                num_proof2 = Double.parseDouble(data2);
                num_proof3 = Double.parseDouble(data3);
                return true;
            }
            catch(NumberFormatException ex) 
            {
                  System.err.println(ex.getMessage());
                  JOptionPane.showMessageDialog(null ,"Please insert numbers correctly, in the respective fields","BAD DATA INPUT",JOptionPane.ERROR_MESSAGE);
                  return false;
            }
      }
   
    protected boolean Confirm_letterFields(String stringToConfirm) 
    {
            short i , j;
            String numberproof = "0123456789";
            

            for(i=0; i < numberproof.length() ;i++)
            {
                for(j=0; j < stringToConfirm.length() ;j++)
                {
                    if(numberproof.charAt(i) == stringToConfirm.charAt(j))
                    {
                       JOptionPane.showMessageDialog(null,"THE NAMES AND LAST NAMES MUST NO HAVE NUMBERS" ,"ERROR" , JOptionPane.ERROR_MESSAGE);
                       return false;
                    }
                }
            } 
            
            return true;
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
     