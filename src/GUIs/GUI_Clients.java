/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUIs;

import Data.Data_Bill;
import Data.Data_Clients;
import Data.Data_Sellers;
import DataSupport.Thread_Counter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;

/**
 *
 * @author Simon Felipe Rua Vargas
 */
public class GUI_Clients extends javax.swing.JFrame 
{
     private final Data_Clients d_client;
     private int click_tblclients = 0 , auxrow = -1;
     private String ID = ""; 
       
    
    public GUI_Clients()
    {       
        setIconImage(new ImageIcon(getClass().getResource("/images/clients.png")).getImage());
        initComponents();
        d_client = new Data_Clients();
        clients_counter();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PppMenuClient = new javax.swing.JPopupMenu();
        Menu_EditClient = new javax.swing.JMenuItem();
        Menu_DeleteClient = new javax.swing.JMenuItem();
        Menu_Buy = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        txt_ID = new javax.swing.JTextField();
        txt_Phone = new javax.swing.JTextField();
        txt_Cellphone = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txt_FLN = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txt_SLN = new javax.swing.JTextField();
        btn_InsertClient = new javax.swing.JButton();
        btn_Delete = new javax.swing.JButton();
        btn_Search = new javax.swing.JButton();
        btn_Update = new javax.swing.JButton();
        txt_Names = new javax.swing.JTextField();
        btn_Clear = new javax.swing.JButton();
        btn_SearchAll = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tbl_Clients = new javax.swing.JTable();
        btn_buy = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lbl_clients = new javax.swing.JLabel();

        Menu_EditClient.setText("Put data client");
        Menu_EditClient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Menu_EditClientActionPerformed(evt);
            }
        });
        PppMenuClient.add(Menu_EditClient);

        Menu_DeleteClient.setText("Delete Client");
        Menu_DeleteClient.setToolTipText("");
        Menu_DeleteClient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Menu_DeleteClientActionPerformed(evt);
            }
        });
        PppMenuClient.add(Menu_DeleteClient);

        Menu_Buy.setText("Buy");
        Menu_Buy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Menu_BuyActionPerformed(evt);
            }
        });
        PppMenuClient.add(Menu_Buy);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Form Clients");
        setMinimumSize(new java.awt.Dimension(909, 689));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.setMinimumSize(new java.awt.Dimension(900, 1000));
        jPanel1.setPreferredSize(new java.awt.Dimension(900, 1000));
        jPanel1.setRequestFocusEnabled(false);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "PERSONAL DATA OF THE CLIENT", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Copperplate Gothic Bold", 0, 14), new java.awt.Color(255, 102, 0))); // NOI18N
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_ID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_IDActionPerformed(evt);
            }
        });
        txt_ID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_IDKeyTyped(evt);
            }
        });
        jPanel2.add(txt_ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 30, 160, -1));

        txt_Phone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_PhoneKeyTyped(evt);
            }
        });
        jPanel2.add(txt_Phone, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 150, 160, -1));

        txt_Cellphone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_CellphoneKeyTyped(evt);
            }
        });
        jPanel2.add(txt_Cellphone, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 180, 160, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("Name(s):");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 60, 60, 20));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setText(" Phone:");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 150, 60, 20));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setText("Cellphone:");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 180, 80, 20));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setText("ID:");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 30, 30, 20));

        txt_FLN.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_FLNKeyTyped(evt);
            }
        });
        jPanel2.add(txt_FLN, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 90, 160, -1));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel15.setText("First last name:");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, 110, 20));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel16.setText("Second last name:");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 120, 130, 20));

        txt_SLN.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_SLNKeyTyped(evt);
            }
        });
        jPanel2.add(txt_SLN, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 120, 160, -1));

        btn_InsertClient.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Add_person.png"))); // NOI18N
        btn_InsertClient.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_InsertClient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_InsertClientActionPerformed(evt);
            }
        });
        jPanel2.add(btn_InsertClient, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 80, 80));

        btn_Delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/delete.png"))); // NOI18N
        btn_Delete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_DeleteActionPerformed(evt);
            }
        });
        jPanel2.add(btn_Delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 220, 80, 80));

        btn_Search.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/search.png"))); // NOI18N
        btn_Search.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_Search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SearchActionPerformed(evt);
            }
        });
        jPanel2.add(btn_Search, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 220, 80, 80));

        btn_Update.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/update.png"))); // NOI18N
        btn_Update.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_Update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_UpdateActionPerformed(evt);
            }
        });
        jPanel2.add(btn_Update, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 220, 80, 80));

        txt_Names.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_NamesKeyTyped(evt);
            }
        });
        jPanel2.add(txt_Names, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 60, 160, -1));

        btn_Clear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/new_file.png"))); // NOI18N
        btn_Clear.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_Clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ClearActionPerformed(evt);
            }
        });
        jPanel2.add(btn_Clear, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 220, 80, 80));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 620, 320));

        btn_SearchAll.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/search_all_3.png"))); // NOI18N
        btn_SearchAll.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_SearchAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SearchAllActionPerformed(evt);
            }
        });
        jPanel1.add(btn_SearchAll, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 360, 100, 110));

        Tbl_Clients.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Names", "First Last Name", "Second Last Name", "Phone", "Cellphone"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Tbl_Clients.setComponentPopupMenu(PppMenuClient);
        Tbl_Clients.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Tbl_ClientsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Tbl_Clients);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, 760, 290));

        btn_buy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Click-and-Buy_2.png"))); // NOI18N
        btn_buy.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_buy.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_buy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buyActionPerformed(evt);
            }
        });
        jPanel1.add(btn_buy, new org.netbeans.lib.awtextra.AbsoluteConstraints(735, 250, -1, 80));

        jLabel1.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 153, 0));
        jLabel1.setText("number of clients: ");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 220, 160, -1));

        lbl_clients.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 14)); // NOI18N
        lbl_clients.setForeground(new java.awt.Color(255, 153, 0));
        lbl_clients.setText("....");
        jPanel1.add(lbl_clients, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 220, 70, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 910, 690));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_DeleteActionPerformed
        String ID = JOptionPane.showInputDialog(null,"Deep the ID client please");
        int op_c;
        
        if(ID != null)
        {
           op_c = JOptionPane.showConfirmDialog(null,"Are you sure you want to delete this client ?","CONFIRM QUESTION",JOptionPane.YES_NO_CANCEL_OPTION);
           
           if(op_c == 0) 
           {
              d_client.connect_DB();
              d_client.delete_client(ID);
              d_client.disconnect_DB();
           }
        }
    }//GEN-LAST:event_btn_DeleteActionPerformed

    private void btn_InsertClientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_InsertClientActionPerformed
            d_client.connect_DB();
            d_client.insert_client( txt_ID.getText(),txt_Names.getText(),txt_FLN.getText(),txt_SLN.getText(),txt_Phone.getText()
                                   ,txt_Cellphone.getText() );
            
            d_client.disconnect_DB();
            
            if(d_client.ctc)
               clear_fields();
    }//GEN-LAST:event_btn_InsertClientActionPerformed

    private void btn_ClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ClearActionPerformed
            clear_fields();
    }//GEN-LAST:event_btn_ClearActionPerformed

    private void btn_SearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SearchActionPerformed
        String ID = JOptionPane.showInputDialog(null,"Deep the ID client please");
        
        if(ID != null)
        {
            d_client.connect_DB();
            d_client.search_client(ID);
            d_client.disconnect_DB();
        }
        
          if(d_client.ctc)
          {
             Data_onFields();
             d_client.set_ID(ID);
          }
    }//GEN-LAST:event_btn_SearchActionPerformed

    private void btn_UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_UpdateActionPerformed
            d_client.connect_DB();
            d_client.update_client(txt_ID.getText() , txt_Names.getText() ,txt_FLN.getText() , txt_SLN.getText(),
                                  txt_Phone.getText() , txt_Cellphone.getText());
            d_client.disconnect_DB();   
            
            clear_fields();
    }//GEN-LAST:event_btn_UpdateActionPerformed

    private void btn_SearchAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SearchAllActionPerformed
           d_client.connect_DB();
           d_client.searchAll_clients(Tbl_Clients);      
           d_client.disconnect_DB();
    }//GEN-LAST:event_btn_SearchAllActionPerformed

    private void Tbl_ClientsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tbl_ClientsMouseClicked
            if(Tbl_Clients.getSelectedRow() != -1)
            {
               click_tblclients++;                   
               if(click_tblclients == 1 || auxrow != Tbl_Clients.getSelectedRow())
               {
                  ID = String.valueOf(Tbl_Clients.getValueAt(Tbl_Clients.getSelectedRow() , 0));  
                  if(auxrow != Tbl_Clients.getSelectedRow())
                     auxrow = Tbl_Clients.getSelectedRow();
               }
            }
               
            if(evt.isPopupTrigger())
            {
               System.err.println("Right click");
               PppMenuClient.setLocation(evt.getX()+100 , evt.getY()+540);
               PppMenuClient.setVisible(true); 
            }
    }//GEN-LAST:event_Tbl_ClientsMouseClicked

    private void Menu_EditClientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Menu_EditClientActionPerformed
            System.out.println("MENU 1");
            TableModel table = Tbl_Clients.getModel();
            click_tblclients = 0;
            
            if(Tbl_Clients.getSelectedRow() != -1)
            {
               d_client.set_ID(ID);
               txt_ID.setText(String.valueOf(table.getValueAt(Tbl_Clients.getSelectedRow() , 0) ));
               txt_Names.setText((String) table.getValueAt(Tbl_Clients.getSelectedRow() , 1));
               txt_FLN.setText((String) table.getValueAt(Tbl_Clients.getSelectedRow() , 2) );
               txt_SLN.setText((String) table.getValueAt(Tbl_Clients.getSelectedRow() , 3) );
               txt_Phone.setText((String) table.getValueAt(Tbl_Clients.getSelectedRow() , 4) );
               txt_Cellphone.setText((String) table.getValueAt(Tbl_Clients.getSelectedRow() , 5));
            }    
    }//GEN-LAST:event_Menu_EditClientActionPerformed

    private void Menu_DeleteClientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Menu_DeleteClientActionPerformed
            System.out.println("MENU 1");
            TableModel table = Tbl_Clients.getModel();
            click_tblclients = 0;
            
            if(Tbl_Clients.getSelectedRow() != -1)
               eliminate_client(String.valueOf(table.getValueAt(Tbl_Clients.getSelectedRow() , 0)));
    }//GEN-LAST:event_Menu_DeleteClientActionPerformed

    private void btn_buyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buyActionPerformed
            String id_seller = JOptionPane.showInputDialog(null,"Deep the seller's ID");    
            String id_client = txt_ID.getText() , code_bill;
            boolean exist_seller , exist_client;
            Data_Bill d_bill = new Data_Bill();
                         
            
             if(id_seller != null)
             {
                if(!id_seller.isEmpty() && !id_client.isEmpty())
                {
                   //Check if the seller exist in the database
                   exist_seller =  investigate_seller(id_seller);                  
                   //Check if the client exist in the database
                   exist_client = investigate_client(id_client);
                
                   if(exist_seller && exist_client)
                   {
                      d_bill.connect_DB();
                      d_bill.insert_order_forAC(id_seller , id_client);
                      code_bill = d_bill.get_code_bill();
                      d_bill.disconnect_DB();
                      
                      new GUI_Shopping(id_seller , id_client , code_bill).setVisible(true);
                   }
                }
                else
                    JOptionPane.showMessageDialog(null,"Deep the seller's ID and search client in the database to execute purchase","PLEASE", JOptionPane.ERROR_MESSAGE);
             }
    }//GEN-LAST:event_btn_buyActionPerformed

    private void txt_IDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_IDActionPerformed
        
    }//GEN-LAST:event_txt_IDActionPerformed

    private void Menu_BuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Menu_BuyActionPerformed
            String id_seller = JOptionPane.showInputDialog(null,"Deep the seller's ID");    
            String id_client = "" , code_bill;
            boolean exist_seller , exist_client;
            Data_Bill d_bill = new Data_Bill();
            
            if(Tbl_Clients.getSelectedRow() != -1)
               id_client = String.valueOf(Tbl_Clients.getValueAt(Tbl_Clients.getSelectedRow() , 0));
                                
             if(id_seller != null)
             {
                if(!id_seller.isEmpty() && !id_client.isEmpty())
                {
                   //Check if the seller exist in the database
                   exist_seller =  investigate_seller(id_seller);                  
                   //Check if the client exist in the database
                   exist_client = investigate_client(id_client);
                
                   if(exist_seller && exist_client)
                   {
                      d_bill.connect_DB();
                      d_bill.insert_order_forAC(id_seller , id_client);
                      code_bill = d_bill.get_code_bill();
                      d_bill.disconnect_DB();
                      
                      new GUI_Shopping(id_seller , id_client , code_bill).setVisible(true);
                   }
                }
                else
                    JOptionPane.showMessageDialog(null,"Deep the seller's ID and search client in the database to execute purchase","PLEASE", JOptionPane.ERROR_MESSAGE);
             }
    }//GEN-LAST:event_Menu_BuyActionPerformed

    private void txt_IDKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_IDKeyTyped
        if(evt.getKeyChar() == KeyEvent.VK_ENTER)
               txt_ID.transferFocus();
    }//GEN-LAST:event_txt_IDKeyTyped

    private void txt_NamesKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_NamesKeyTyped
            if(evt.getKeyChar() == KeyEvent.VK_ENTER)
               txt_Names.transferFocus();
    }//GEN-LAST:event_txt_NamesKeyTyped

    private void txt_FLNKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_FLNKeyTyped
            if(evt.getKeyChar() == KeyEvent.VK_ENTER)
               txt_FLN.transferFocus();
    }//GEN-LAST:event_txt_FLNKeyTyped

    private void txt_SLNKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_SLNKeyTyped
            if(evt.getKeyChar() == KeyEvent.VK_ENTER)
               txt_SLN.transferFocus();
    }//GEN-LAST:event_txt_SLNKeyTyped

    private void txt_PhoneKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_PhoneKeyTyped
            if(evt.getKeyChar() == KeyEvent.VK_ENTER)
               txt_Phone.transferFocus();
    }//GEN-LAST:event_txt_PhoneKeyTyped

    private void txt_CellphoneKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_CellphoneKeyTyped
            if(evt.getKeyChar() == KeyEvent.VK_ENTER)
               txt_ID.requestFocus();
    }//GEN-LAST:event_txt_CellphoneKeyTyped

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) 
//    {
//        /* Set the Nimbus look and feel */
//        <editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(GUI_Clients.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(GUI_Clients.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(GUI_Clients.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(GUI_Clients.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        </editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            @Override
//            public void run()
//            {
//                new GUI_Clients().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Menu_Buy;
    private javax.swing.JMenuItem Menu_DeleteClient;
    private javax.swing.JMenuItem Menu_EditClient;
    private javax.swing.JPopupMenu PppMenuClient;
    private javax.swing.JTable Tbl_Clients;
    private javax.swing.JButton btn_Clear;
    private javax.swing.JButton btn_Delete;
    private javax.swing.JButton btn_InsertClient;
    private javax.swing.JButton btn_Search;
    private javax.swing.JButton btn_SearchAll;
    private javax.swing.JButton btn_Update;
    private javax.swing.JButton btn_buy;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_clients;
    private javax.swing.JTextField txt_Cellphone;
    private javax.swing.JTextField txt_FLN;
    private javax.swing.JTextField txt_ID;
    private javax.swing.JTextField txt_Names;
    private javax.swing.JTextField txt_Phone;
    private javax.swing.JTextField txt_SLN;
    // End of variables declaration//GEN-END:variables

    private void clear_fields() 
    {
            txt_ID.setText("");
            txt_Names.setText("");
            txt_FLN.setText("");
            txt_SLN.setText("");
            txt_Phone.setText("");
            txt_Cellphone.setText("");
    }

    private void Data_onFields() 
    {
            txt_ID.setText(d_client.id);
            txt_Names.setText(d_client.names);
            txt_FLN.setText(d_client.fln);
            txt_SLN.setText(d_client.sln);
            txt_Phone.setText(d_client.phone);
            txt_Cellphone.setText(d_client.cellphone);
    }

    private void eliminate_client(String ID) 
    {
            int op = JOptionPane.showConfirmDialog(null,"Are you sure you want to delete this client ?","CONFIRMING DELETE OPTION",JOptionPane.YES_NO_OPTION);
                     
            if(op == 0)
            {
               d_client.connect_DB();
               d_client.delete_client(ID);
               d_client.searchAll_clients(Tbl_Clients);
               d_client.disconnect_DB();
            }
    }

    private boolean investigate_seller(String id) 
    {
            Data_Sellers s =  new Data_Sellers();
            
            s.connect_DB(); 
            s.investigate_seller_ID(id);
            s.disconnect_DB();
            
            return s.ctc;
    }

    private boolean investigate_client(String id) 
    {
             Data_Clients c =  new Data_Clients();
             
             c.connect_DB();
             c.search_client(id);
             c.disconnect_DB();
             
             return c.ctc;
    }

    private void clients_counter() 
    {
            Thread_Counter thrd_cl = new Thread_Counter("c_cl",lbl_clients);
            thrd_cl.start();
    }
}
