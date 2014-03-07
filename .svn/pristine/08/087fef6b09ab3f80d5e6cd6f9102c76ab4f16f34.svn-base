/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bangnanurse.objdb;

import bangnaLibrary.Config1;
import bangnanurse.object.ResultLab;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author root
 */
public class ResultLabDB {
    ResultLab rlab = new ResultLab();
    Config1 config1 ;
    public ResultLabDB(Config1 cf){
        config1 = new Config1();
    }
    public String getResultLab(String branchId,String visitId, String labNumber){
        String result = "", sql = "";
        try {
            Connection conn = config1.getConnectionHospital(branchId);
            Statement st = conn.createStatement();
            ResultSet rs;
            sql  = "Select trl.* "
                    + "From t_result_lab trl "
                    + "left join b_item bi on bi.b_item_id = trl.b_item_id "
                    + "Where trl.t_visit_id = '"+visitId
                    +"' and trl.result_lab_active = '1' and bi.item_number = '"+labNumber+"' ";
            rs = st.executeQuery(sql);
            while (rs.next()){
                result += rs.getString("result_lab_value").toLowerCase();
            }
            rs.close();
            conn.close();
            conn = config1.getConnectionBangna();
            st = conn.createStatement();
            sql = "Select * From lab_b_result_interpreter where lab_number = '"+labNumber+"' and result_value = '"+result+"'";
            rs = st.executeQuery(sql);
            while(rs.next()){
                result = rs.getString("interpreted");
            }
            rs.close();
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(ResultLabDB.class.getName()).log(Level.SEVERE, null, ex);
        }//¡
        return result;
    }
}
