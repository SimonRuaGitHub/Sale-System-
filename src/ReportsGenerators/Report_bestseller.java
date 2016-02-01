/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ReportsGenerators;

import java.sql.Connection;
import java.util.HashMap;

/**
 *
 * @author simon
 */
public class Report_bestseller extends Master_reports
{   
    
      public Report_bestseller (String url, Connection con)
      {
             super(url , con);
      }
      
      public void createParameter(Object[] namesparameters , Object[] datas)
      {
             short i;            
             parameter = new HashMap();
             
             for(i=0; i < datas.length ;i++)
                  parameter.put(namesparameters[i] , datas[i]);
      }
}
