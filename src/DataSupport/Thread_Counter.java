/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DataSupport;

import Data.Data_Clients;
import Data.Data_Products;
import Data.Data_Sellers;
import Data.Data_Suppliers;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

/**
 *
 * @author Simon Felipe Rua Vargas
 */
public final class Thread_Counter extends Thread 
{
       private JLabel lbl_sellers , lbl_suppliers , lbl_products , lbl_clients;
       private final JLabel lbl;
       private final Data_Sellers db_seller = new Data_Sellers();
       private final Data_Products db_prod = new Data_Products();
       private final Data_Suppliers db_supp = new Data_Suppliers();
       private final Data_Clients db_cl = new Data_Clients();
       private int sellers_quan , prod_quan , supp_quan , cl_quan;
              
       public Thread_Counter(String name , JLabel lbl)
       {
              this.lbl = lbl;
              setName(name);
       }
       
       @Override
       public void run()
       {
              switch(getName())
              {
                  case "c_sellers": lbl_sellers = lbl;
                                    count_sellers_quantity();
                  break;
                      
                  case "c_prods":  lbl_products = lbl;
                                   count_products_quantity();
                  break;
                         
                  case "c_supps":  lbl_suppliers = lbl;
                                   count_suppliers_quantity();
                  break;
                      
                  case "c_cl":  lbl_clients = lbl;
                                count_clients_quantity();
                  break;
              }
       }
       
      
       private void count_sellers_quantity()
       {
             while(true)
             {
                       db_seller.connect_DB();
                       sellers_quan = db_seller.count_sellers();
                       db_seller.disconnect_DB();  
                       lbl_sellers.setText(String.valueOf(sellers_quan));
                       
                     try {
                         sleep(1000);
                     } catch (InterruptedException ex) {
                         Logger.getLogger(Thread_Counter.class.getName()).log(Level.SEVERE, null, ex);
                     }
              }
       }
       
       private void count_products_quantity()
       {
             while(true)
             {
                   db_prod.connect_DB();
                   prod_quan = db_prod.count_products();
                   db_prod.disconnect_DB();  
                   lbl_products.setText(String.valueOf(prod_quan));
                       
                     try {
                         sleep(1000);
                     } catch (InterruptedException ex) {
                         Logger.getLogger(Thread_Counter.class.getName()).log(Level.SEVERE, null, ex);
                     }
              }
       }
       
       private void count_suppliers_quantity()
       {
             while(true)
             {
                   db_supp.connect_DB();
                   supp_quan = db_supp.count_suppliers();
                   db_supp.disconnect_DB();  
                   lbl_suppliers.setText(String.valueOf(supp_quan));
                       
                     try 
                     {
                         sleep(1000);
                     } catch (InterruptedException ex) {
                         Logger.getLogger(Thread_Counter.class.getName()).log(Level.SEVERE, null, ex);
                     }
              }
       }
       
       private void count_clients_quantity()
       {
             while(true)
             {
                 
                     db_cl.connect_DB();
                     cl_quan = db_cl.count_clients();
                     db_cl.disconnect_DB();
                     lbl_clients.setText(String.valueOf(cl_quan));
                     
                 try 
                 {      
                     sleep(1000);
                 } catch (InterruptedException ex) {
                     Logger.getLogger(Thread_Counter.class.getName()).log(Level.SEVERE, null, ex);
                 }
                  
             }
       }
}
