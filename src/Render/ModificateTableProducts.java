/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Render;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Simon Felipe Rua Vargas
 */
public class ModificateTableProducts extends DefaultTableCellRenderer 
{
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) 
    {          
           Component cellComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            
           System.out.println("__");
           System.out.println("|"+row+"|"+column +"|:"+value);
           System.out.println("__");
           
           if(Double.parseDouble(value.toString()) == 0)
              cellComponent.setBackground(Color.red);
           else
           {
               //repaint all the column
              if((row+1)%2 == 0)
              {
                   cellComponent.setBackground(table.getBackground());//due to the look and feel color for each cell of the tables, I used the background given bu
                                                                      //by the look and feel
                   if(isSelected)                 
                      cellComponent.setBackground(table.getSelectionBackground());
              }
               else
               {
                   cellComponent.setBackground(table.getBackground());
                   //cellComponent.setForeground(table.getForeground());
                   if(isSelected)
                      cellComponent.setBackground(table.getSelectionBackground());
               }
             
           }     
           
           //I HAVE TO STOP THIS METHOD
           return cellComponent;
    } 

}
