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
public class Report_bill extends Master_reports
{    
      public Report_bill (String url, Connection con)
      {
             super(url , con);
      }
      
      public void createParameter(String code_bill)
      {
             parameter = new HashMap();
             parameter.put("param_code_bill", code_bill);
      }
}
