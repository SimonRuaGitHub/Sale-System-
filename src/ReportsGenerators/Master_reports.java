/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ReportsGenerators;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author simon
 */
class Master_reports
{
       String url;
       Map parameter;
       Connection con;
       
      public Master_reports (String url, Connection con)
      {
            this.url = url;
            this.con = con;
      }
      
      public void showReport_ByParameter() throws FileNotFoundException
      {
           try 
           {
              JasperReport jr =(JasperReport) JRLoader.loadObjectFromFile(url);
              JasperPrint jp = JasperFillManager.fillReport(jr,parameter, con);
              JasperViewer viewer = new JasperViewer(jp,false);
              viewer.setVisible(true);
           } catch (JRException ex) {
               Logger.getLogger(Report_bill.class.getName()).log(Level.SEVERE, null, ex);
               System.out.println(ex.getMessage());
          }
       }
      
      public void showReport()
      {
           try 
           {
             //JasperReport jr =(JasperReport) JRLoader.loadObjectFromFile(url);
              JasperReport jr =(JasperReport) JRLoader.loadObject(new File(url));//Relative paths
              JasperPrint jp = JasperFillManager.fillReport(jr,null, con);
              JasperViewer viewer = new JasperViewer(jp,false);
              viewer.setVisible(true);
           } 
           catch (JRException ex)
           {
               Logger.getLogger(Report_bill.class.getName()).log(Level.SEVERE, null, ex);
               System.out.println(ex.getMessage());
          }
       }
}
