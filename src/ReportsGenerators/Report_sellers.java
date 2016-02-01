/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ReportsGenerators;

import java.sql.Connection;
/**
 *
 * @author simon
 */
public class Report_sellers extends Master_reports
{  
      public Report_sellers (String url, Connection con)
      {
             super(url , con);
      }    
}
