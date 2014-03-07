/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bangnaopd;

import bangnanurse.objdb.OpdTMedicalCertCompanyDB;
import java.sql.*;
import bangnaLibrary.*;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author root
 */
public class TVisitVitalSignDB1 {
    TVisitVitalSign1 tvvs = new TVisitVitalSign1();
    private Config1 config1 ;
    
    public TVisitVitalSignDB1(){
        config1 = new Config1();
    }
    public TVisitVitalSignDB1(Config1 cf){
        config1 = cf;
    }
    public TVisitVitalSign1 getTVisitVitalSignByPK(String branch_id, String t_visit_vital_sign_id) {
        Connection conn;
        String sql="";
        try {
                conn = config1.getConnectionHospital(branch_id);
                Statement stbangna = conn.createStatement();

            sql="Select * "
                +"From "+tvvs.getTVisitVitalSign()+" "
                +"Where "+tvvs.getFTVisitVitalSignId()+"='"+t_visit_vital_sign_id+"'";
                //+"Order By "+admintbilllab.getFBillLabId()+" desc";
            ResultSet rs = stbangna.executeQuery(sql);
            while(rs.next()) {
                tvvs = new TVisitVitalSign1();
                tvvs.setFVisitNutritionLevelId(config1.StringNull(rs.getString(tvvs.getFFVisitNutritionLevelId())));
                tvvs.setRecordDate(config1.StringNull(rs.getString(tvvs.getFRecordDate())));
                tvvs.setRecordTime(config1.StringNull(rs.getString(tvvs.getFRecordTime())));
                tvvs.setTPatientId(config1.StringNull(rs.getString(tvvs.getFTPatientId())));
                tvvs.setTVisitId(config1.StringNull(rs.getString(tvvs.getFTVisitId())));

                tvvs.setTVisitVitalSignId(config1.StringNull(rs.getString(tvvs.getFTVisitVitalSignId())));
                tvvs.setVisitVitalSignActive(config1.StringNull(rs.getString(tvvs.getFVisitVitalSignActive())));
                tvvs.setVisitVitalSignBloodPresure(config1.StringNull(rs.getString(tvvs.getFVisitVitalSignBloodPresure())));
                tvvs.setVisitVitalSignBmi(config1.StringNull(rs.getString(tvvs.getFVisitVitalSignBmi())));
                tvvs.setVisitVitalSignCheckDate(config1.StringNull(rs.getString(tvvs.getFVisitVitalSignCheckDate())));

                tvvs.setVisitVitalSignCheckTime(config1.StringNull(rs.getString(tvvs.getFVisitVitalSignCheckTime())));
                tvvs.setVisitVitalSignCurrentIllnessSymptom(config1.StringNull(rs.getString(tvvs.getFVisitVitalSignCurrentIllnessSymptom())));
                tvvs.setVisitVitalSignGeneralSymptom(config1.StringNull(rs.getString(tvvs.getFVisitVitalSignGeneralSymptom())));
                tvvs.setVisitVitalSignHeartRate(config1.StringNull(rs.getString(tvvs.getFVisitVitalSignHeartRate())));
                tvvs.setVisitVitalSignHeight(config1.StringNull(rs.getString(tvvs.getFVisitVitalSignHeight())));

                tvvs.setVisitVitalSignModifyDateTime(config1.StringNull(rs.getString(tvvs.getFVisitVitalSignModifyDateTime())));
                tvvs.setVisitVitalSignNote(config1.StringNull(rs.getString(tvvs.getFVisitVitalSignNote())));
                tvvs.setVisitVitalSignRespiratoryRate(config1.StringNull(rs.getString(tvvs.getFVisitVitalSignRespiratoryRate())));
                tvvs.setVisitVitalSignStaffModify(config1.StringNull(rs.getString(tvvs.getFVisitVitalSignStaffModify())));
                tvvs.setVisitVitalSignStaffRecord(config1.StringNull(rs.getString(tvvs.getFVisitVitalSignStaffRecord())));

                tvvs.setVisitVitalSignTemperature(config1.StringNull(rs.getString(tvvs.getFVisitVitalSignTemperature())));
                tvvs.setVisitVitalSignWeight(config1.StringNull(rs.getString(tvvs.getFVisitVitalSignWeight())));

                }
            rs.close();
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(OpdTMedicalCertCompanyDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tvvs;
    }
    public Vector getTVisitVitalSign(String branch_id, String visit_id, String flag) {
        Connection conn;
        String sql="";
        Vector vtvvs = new Vector();
        try {
            conn = config1.getConnectionHospital(branch_id);
            Statement stbangna = conn.createStatement();

            if(flag.equals("visit")){
                sql="Select * "
                    +"From "+tvvs.getTVisitVitalSign()+" "
                    +"Where "+tvvs.getFTVisitId()+"='"+visit_id+"' and "+tvvs.getFVisitVitalSignActive()+"='1'";
            }else{
                
            }
                //+"Order By "+admintbilllab.getFBillLabId()+" desc";
            ResultSet rs = stbangna.executeQuery(sql);
            while(rs.next()) {
                tvvs = new TVisitVitalSign1();
                tvvs.setFVisitNutritionLevelId(config1.StringNull(rs.getString(tvvs.getFFVisitNutritionLevelId())));
                tvvs.setRecordDate(config1.StringNull(rs.getString(tvvs.getFRecordDate())));
                tvvs.setRecordTime(config1.StringNull(rs.getString(tvvs.getFRecordTime())));
                tvvs.setTPatientId(config1.StringNull(rs.getString(tvvs.getFTPatientId())));
                tvvs.setTVisitId(config1.StringNull(rs.getString(tvvs.getFTVisitId())));

                tvvs.setTVisitVitalSignId(config1.StringNull(rs.getString(tvvs.getFTVisitVitalSignId())));
                tvvs.setVisitVitalSignActive(config1.StringNull(rs.getString(tvvs.getFVisitVitalSignActive())));
                tvvs.setVisitVitalSignBloodPresure(config1.StringNull(rs.getString(tvvs.getFVisitVitalSignBloodPresure())));
                tvvs.setVisitVitalSignBmi(config1.StringNull(rs.getString(tvvs.getFVisitVitalSignBmi())));
                tvvs.setVisitVitalSignCheckDate(config1.StringNull(rs.getString(tvvs.getFVisitVitalSignCheckDate())));

                tvvs.setVisitVitalSignCheckTime(config1.StringNull(rs.getString(tvvs.getFVisitVitalSignCheckTime())));
                tvvs.setVisitVitalSignCurrentIllnessSymptom(config1.StringNull(rs.getString(tvvs.getFVisitVitalSignCurrentIllnessSymptom())));
                tvvs.setVisitVitalSignGeneralSymptom(config1.StringNull(rs.getString(tvvs.getFVisitVitalSignGeneralSymptom())));
                tvvs.setVisitVitalSignHeartRate(config1.StringNull(rs.getString(tvvs.getFVisitVitalSignHeartRate())));
                tvvs.setVisitVitalSignHeight(config1.StringNull(rs.getString(tvvs.getFVisitVitalSignHeight())));

                tvvs.setVisitVitalSignModifyDateTime(config1.StringNull(rs.getString(tvvs.getFVisitVitalSignModifyDateTime())));
                tvvs.setVisitVitalSignNote(config1.StringNull(rs.getString(tvvs.getFVisitVitalSignNote())));
                tvvs.setVisitVitalSignRespiratoryRate(config1.StringNull(rs.getString(tvvs.getFVisitVitalSignRespiratoryRate())));
                tvvs.setVisitVitalSignStaffModify(config1.StringNull(rs.getString(tvvs.getFVisitVitalSignStaffModify())));
                tvvs.setVisitVitalSignStaffRecord(config1.StringNull(rs.getString(tvvs.getFVisitVitalSignStaffRecord())));

                tvvs.setVisitVitalSignTemperature(config1.StringNull(rs.getString(tvvs.getFVisitVitalSignTemperature())));
                tvvs.setVisitVitalSignWeight(config1.StringNull(rs.getString(tvvs.getFVisitVitalSignWeight())));
                tvvs.setVisitVitalSignBmi(config1.StringNull(rs.getString(tvvs.getFVisitVitalSignBmi())));

                vtvvs.add(tvvs);

                }
            rs.close();
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(OpdTMedicalCertCompanyDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vtvvs;
    }
    public String getPatientVisitVitalSign(String branch_id, String visit_id){
        String text="";
        Vector v_vital_sign = new Vector();
        v_vital_sign = getTVisitVitalSign(branch_id, visit_id, "visit");
        for(int i=0;i<=v_vital_sign.size()-1;i++){
            tvvs = (TVisitVitalSign1)v_vital_sign.get(i);
            text+="H.Rate="+tvvs.getVisitVitalSignHeartRate()+"����/min"+
                    "; R.Rate="+tvvs.getVisitVitalSignRespiratoryRate()+"����/min"+
                    ";BP="+tvvs.getVisitVitalSignBloodPresure()+"mmHg";
        }
        return text;
    }
    public String getPatientVisitWidthHeight(String branch_id, String visit_id){
        String text="";
        Vector v_vital_sign = new Vector();
        v_vital_sign = getTVisitVitalSign(branch_id, visit_id, "visit");
        for(int i=0;i<=v_vital_sign.size()-1;i++){
            tvvs = (TVisitVitalSign1)v_vital_sign.get(i);
//            text+="Weight="+t_visit_vital_sign.getVisitVitalSignWeight()+"Kgs"+
//                    "; Height="+t_visit_vital_sign.getVisitVitalSignHeight()+"Cms";
            text+= "Height="+tvvs.getVisitVitalSignHeight()+"Cms"+
                    "; Weight="+tvvs.getVisitVitalSignWeight()+"Kgs";
        }
        return text;
    }
    public String getPatientVisitBMI(String branch_id, String visit_id){
        String text="";
        Vector v_vital_sign = new Vector();
        v_vital_sign = getTVisitVitalSign(branch_id, visit_id, "visit");
        for(int i=0;i<=v_vital_sign.size()-1;i++){
            tvvs = (TVisitVitalSign1)v_vital_sign.get(i);
//            text+="Weight="+t_visit_vital_sign.getVisitVitalSignWeight()+"Kgs"+
//                    "; Height="+t_visit_vital_sign.getVisitVitalSignHeight()+"Cms";
            text+= "BMI = "+tvvs.getVisitVitalSignBmi();
        }
        return text;
    }

}
