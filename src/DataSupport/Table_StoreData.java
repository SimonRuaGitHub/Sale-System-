/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataSupport;

import javax.swing.table.TableModel;

/**
 *
 * @author simon
 */
public class Table_StoreData 
{   
       private TableModel table;
       private String[] array_ID;
       private int num_rows;
       private short col_ref;
       
       public Table_StoreData(TableModel table , short col_ref)
       {
              this.table = table;
              num_rows = table.getRowCount();
              array_ID = new String[table.getRowCount()];
              this.col_ref = col_ref;
              
       }
       
       public void setDataOn_ArrayData()
       {
             int i;
             array_ID = new String[num_rows];
                       
             for(i=0; i < num_rows ;i++)
                 array_ID[i] = String.valueOf(table.getValueAt(i , col_ref));
       }  
       
       public String getDataOn_ArrayData(int selected_row)
       {
              return array_ID[selected_row];
       }
}
