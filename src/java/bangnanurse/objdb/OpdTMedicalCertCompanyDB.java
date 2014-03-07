package bangnanurse.objdb;

import bangnanurse.objdb.ResultLabDB;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import bangnaLibrary.*;
import bangnanurse.object.OpdBMedicalCertCompanyOrder;
import bangnanurse.object.OpdBMedicalCertCompanyResult;
import bangnanurse.object.OpdTMedicalCertCompany;
import bangnanurse.object.OpdTMedicalCertCompanyDetail;
import bangnaopd.TVisitVitalSignDB1;
import java.util.Vector;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author root
 */
public class OpdTMedicalCertCompanyDB {
    private OpdTMedicalCertCompanyDetail mccD = new OpdTMedicalCertCompanyDetail();
    private OpdTMedicalCertCompany mcc = new OpdTMedicalCertCompany();
    private OpdBMedicalCertCompanyResult medical_cert_company_result = new OpdBMedicalCertCompanyResult();
    private OpdBMedicalCertCompanyOrder mcco = new OpdBMedicalCertCompanyOrder();
    private Config1 config1 ;
    private ResultLabDB rLabDB;
    public OpdTMedicalCertCompanyDB(){
        config1 = new Config1();
        rLabDB = new ResultLabDB(config1);
    }
    public OpdTMedicalCertCompanyDB(Config1 cf){
        config1 = cf;
        rLabDB = new ResultLabDB(cf);
    }
    public String getMaxRowOpdTMedicalCertCompany(Connection conn){
        String sql="", max="";
        try {
            
            Statement st;
            ResultSet rs;
            st = conn.createStatement();

            sql="Select max("+mcc.getFMedicalCertCompanyId()+") as cnt From "+mcc.getOpdTMedicalCertCompany();
            rs = st.executeQuery(sql);
            while(rs.next()) {
                max = rs.getString("cnt");
            }
            rs.close();
            if(max!=null && !max.equals("")) {
                max =  String.valueOf(Integer.parseInt(max)+1);
            }
            else{
                max = "17200001";
            }
        } catch (Exception ex) {
            Logger.getLogger(OpdTMedicalCertCompanyDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return max;
    }
    public String getMaxRowOpdTMedicalCertCompanyDetail(Connection conn){
        String sql="", max="";
        try {
            Statement st;
            ResultSet rs;
            st = conn.createStatement();

            sql="Select max("+mccD.getFMedicalCertCompanyDetailId()+") as cnt From "+mccD.getOpdTMedicalCertCompanyDetail();
            rs = st.executeQuery(sql);
            while(rs.next()) {
                max = rs.getString("cnt");
            }
            rs.close();
            if(max!=null && !max.equals("")) {
                max =  String.valueOf(Integer.parseInt(max)+1);
            }
            else{
                max = "17300001";
            }
        } catch (Exception ex) {
            Logger.getLogger(OpdTMedicalCertCompanyDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return max;
    }
    public String getMaxRowOpdBMedicalCertCompanyOrder(Connection conn){
        String sql="", max="";
        try {
            Statement st;
            ResultSet rs;
            st = conn.createStatement();

            sql="Select max("+mcco.getFBOpdBMedicalCertCompanyOrderId()+") as cnt From "+mcco.getOpdBMedicalCertCompanyOrder();
            rs = st.executeQuery(sql);
            while(rs.next()) {
                max = rs.getString("cnt");
            }
            rs.close();
            if(max!=null && !max.equals("")) {
                max =  String.valueOf(Integer.parseInt(max)+1);
            }
            else{
                max = "17400001";
            }
        } catch (Exception ex) {
            Logger.getLogger(OpdTMedicalCertCompanyDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return max;
    }
    public String getMaxRowOpdBMedicalCertCompanyResult(Connection conn) {
        String sql="", max="";
        try {
            Statement st;
            ResultSet rs;
            st = conn.createStatement();

            sql="Select max("+medical_cert_company_result.getFBMedicalCertCompanyResultId()+") as cnt From "+medical_cert_company_result.getOpdBMedicalCertCompanyResult();
            rs = st.executeQuery(sql);
            while(rs.next()) {
                max = rs.getString("cnt");
            }
            rs.close();
            if(max!=null && !max.equals("")) {
                max =  String.valueOf(Integer.parseInt(max)+1);
            }
            else{
                max = "17500001";
            }
        } catch (Exception ex) {
            Logger.getLogger(OpdTMedicalCertCompanyDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return max;
    }
    public OpdTMedicalCertCompany getOpdTMedicalCertCompanyByPK(String branch_id, String medical_cert_company_id) {
        Connection conn;
        String sql="";
        try {
                conn = config1.getConnectionBangna();
                Statement stbangna = conn.createStatement();

            sql="Select * "
                +"From "+mcc.getOpdTMedicalCertCompany()+" "
                +"Where "+mcc.getFMedicalCertCompanyId()+"='"+medical_cert_company_id+"'";
                //+"Order By "+admintbilllab.getFBillLabId()+" desc";
            ResultSet rs = stbangna.executeQuery(sql);
            while(rs.next()) {
                mcc = new OpdTMedicalCertCompany();
                mcc.setBranchId(config1.StringNull(rs.getString(mcc.getFBranchId())));
                mcc.setComment1(config1.StringNull(rs.getString(mcc.getFComment1())));
                mcc.setDoctorId(config1.StringNull(rs.getString(mcc.getFDoctorId())));
                mcc.setDoctorNamee(config1.StringNull(rs.getString(mcc.getFDoctorNamee())));
                mcc.setDoctorNamet(config1.StringNull(rs.getString(mcc.getFDoctorNamet())));

                mcc.setMedicalCertCompanyDate(config1.StringNull(rs.getString(mcc.getFMedicalCertCompanyDate())));
                mcc.setMedicalCertCompanyId(config1.StringNull(rs.getString(mcc.getFMedicalCertCompanyId())));
                mcc.setPatientFullnamet(config1.StringNull(rs.getString(mcc.getFPatientFullnamet())));
                mcc.setMedicalCertCompanyActive(config1.StringNull(rs.getString(mcc.getFMedicalCertCompanyActive())));
                mcc.setVisitHn(config1.StringNull(rs.getString(mcc.getFVisitHn())));

                mcc.setMedicalCertCompanyTime(config1.StringNull(rs.getString(mcc.getFMedicalCertCompanyTime())));
                mcc.setTVisitId(config1.StringNull(rs.getString(mcc.getFTVisitId())));
                mcc.setVisitVn(config1.StringNull(rs.getString(mcc.getFVisitVn())));
                mcc.statusLatent = config1.StringNull(rs.getString(mcc.getFStatusLatent()));
                mcc.statusMedicalCert = config1.StringNull(rs.getString(mcc.getFStatusMedicalCert()));
                
                mcc.statusHasLab = config1.StringNull(rs.getString(mcc.getFStatusHasLab()));
                mcc.statusPrint = config1.StringNull(rs.getString(mcc.getFStatusPrint()));
                mcc.statusHasXray = config1.StringNull(rs.getString(mcc.getFStatusHasXray()));

                }
            rs.close();
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(OpdTMedicalCertCompanyDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return mcc;
    }
    public Vector getOpdTMedicalCertCompany(String branch_id, String where, String medical_cert_company_id, String flag) {
        Connection conn;
        String sql="";
        Vector v_medical_cert_company = new Vector();
        try {
            conn = config1.getConnectionBangna();
            Statement stbangna = conn.createStatement();
            if(flag.equals("date")){
                sql="Select * "
                +"From "+mcc.getOpdTMedicalCertCompany()+" "
                +"Where "+mcc.getFMedicalCertCompanyActive()+"='1' and "+
                        mcc.getFMedicalCertCompanyDate() +" = '"+medical_cert_company_id+"' and "+
                        mcc.getFBranchId()+"='"+branch_id+"' ";
            }else {
                sql="Select * "
                +"From "+mcc.getOpdTMedicalCertCompany()+" "
                +"Where "+mcc.getFMedicalCertCompanyActive()+"='1' and "+
                        mcc.getFBranchId()+"='"+branch_id+"'";
            }
            
                //+"Order By "+admintbilllab.getFBillLabId()+" desc";
            ResultSet rs = stbangna.executeQuery(sql);
            while(rs.next()){
                mcc = new OpdTMedicalCertCompany();
                mcc.setBranchId(config1.StringNull(rs.getString(mcc.getFBranchId())));
                mcc.setComment1(config1.StringNull(rs.getString(mcc.getFComment1())));
                mcc.setDoctorId(config1.StringNull(rs.getString(mcc.getFDoctorId())));
                mcc.setDoctorNamee(config1.StringNull(rs.getString(mcc.getFDoctorNamee())));
                mcc.setDoctorNamet(config1.StringNull(rs.getString(mcc.getFDoctorNamet())));

                mcc.setMedicalCertCompanyDate(config1.StringNull(rs.getString(mcc.getFMedicalCertCompanyDate())));
                mcc.setMedicalCertCompanyId(config1.StringNull(rs.getString(mcc.getFMedicalCertCompanyId())));
                mcc.setPatientFullnamet(config1.StringNull(rs.getString(mcc.getFPatientFullnamet())));
                mcc.setMedicalCertCompanyActive(config1.StringNull(rs.getString(mcc.getFMedicalCertCompanyActive())));
                mcc.setVisitHn(config1.StringNull(rs.getString(mcc.getFVisitHn())));

                mcc.setMedicalCertCompanyTime(config1.StringNull(rs.getString(mcc.getFMedicalCertCompanyTime())));
                mcc.setTVisitId(config1.StringNull(rs.getString(mcc.getFTVisitId())));
                mcc.setVisitVn(config1.StringNull(rs.getString(mcc.getFVisitVn())));
                mcc.statusLatent = config1.StringNull(rs.getString(mcc.getFStatusLatent()));
                mcc.statusMedicalCert = config1.StringNull(rs.getString(mcc.getFStatusMedicalCert()));
                
                mcc.statusHasLab = config1.StringNull(rs.getString(mcc.getFStatusHasLab()));
                mcc.statusPrint = config1.StringNull(rs.getString(mcc.getFStatusPrint()));
                mcc.statusHasXray = config1.StringNull(rs.getString(mcc.getFStatusHasXray()));

                v_medical_cert_company.add(mcc);

                }
            rs.close();
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(OpdTMedicalCertCompanyDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return v_medical_cert_company;
    }
    public OpdTMedicalCertCompanyDetail getOpdTMedicalCertCompanyDetailByPK(String brach_id, String where, String medical_cert_company_detail_id, String flag) {
        Connection conn;
        String sql="";
        try {
            conn = config1.getConnectionBangna();
            Statement stbangna = conn.createStatement();
            mccD = new OpdTMedicalCertCompanyDetail();
            if(flag.equals("result")) {
                sql="Select * "
                +"From "+mccD.getOpdTMedicalCertCompanyDetail()+" "
                +"Where "+mccD.getFMedicalCertCompanyId()+"='"+where+"' and "+
                        mccD.getFOrder1()+"='"+medical_cert_company_detail_id+"' and "+
                        mccD.getFMedicalCertCompanyDetailActive()+"='1'";
                //+"Order By "+admintbilllab.getFBillLabId()+" desc";
            }else {
                sql="Select * "
                +"From "+mccD.getOpdTMedicalCertCompanyDetail()+" "
                +"Where "+mccD.getFMedicalCertCompanyDetailId()+"='"+medical_cert_company_detail_id+"' and "+
                        mccD.getFMedicalCertCompanyDetailActive()+"='1'";
                //+"Order By "+admintbilllab.getFBillLabId()+" desc";
            }
            
            ResultSet rs = stbangna.executeQuery(sql);
            while(rs.next()){
                mccD = new OpdTMedicalCertCompanyDetail();
                mccD.setMedicalCertCompanyDetailId(config1.StringNull(rs.getString(mccD.getFMedicalCertCompanyDetailId())));
                mccD.setMedicalCertCompanyId(config1.StringNull(rs.getString(mccD.getFMedicalCertCompanyId())));
                mccD.setOrder1(config1.StringNull(rs.getString(mccD.getFOrder1())));
                mccD.setResult1(config1.StringNull(rs.getString(mccD.getFResult1())));
                mccD.setSort1(config1.StringNull(rs.getString(mccD.getFSort1())));

                mccD.setMedicalCertCompanyDetailActive(config1.StringNull(rs.getString(mccD.getFMedicalCertCompanyDetailActive())));
                mccD.setOrdere1(config1.StringNull(rs.getString(mccD.getFOrdere1())));

                }
            rs.close();
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(OpdTMedicalCertCompanyDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return mccD;
    }
    public Vector getOpdTMedicalCertCompanyDetail(String brach_id, String where, String medical_cert_company_detail_id, String flag) {
        Connection conn;
        String sql="";
        Vector v_medical_cert_company_detail = new Vector();
        try {
                conn = config1.getConnectionBangna();
                Statement stbangna = conn.createStatement();

            sql="Select * "
                +"From "+mccD.getOpdTMedicalCertCompanyDetail()+" "
                +"Where "+mccD.getFMedicalCertCompanyDetailId()+"='"+medical_cert_company_detail_id+"'";
                //+"Order By "+admintbilllab.getFBillLabId()+" desc";
            ResultSet rs = stbangna.executeQuery(sql);
            while(rs.next()){
                mccD = new OpdTMedicalCertCompanyDetail();
                mccD.setMedicalCertCompanyDetailId(config1.StringNull(rs.getString(mccD.getFMedicalCertCompanyDetailId())));
                mccD.setMedicalCertCompanyId(config1.StringNull(rs.getString(mccD.getFMedicalCertCompanyId())));
                mccD.setOrder1(config1.StringNull(rs.getString(mccD.getFOrder1())));
                mccD.setResult1(config1.StringNull(rs.getString(mccD.getFResult1())));
                mccD.setSort1(config1.StringNull(rs.getString(mccD.getSort1())));

                mccD.setMedicalCertCompanyDetailActive(config1.StringNull(rs.getString(mccD.getFMedicalCertCompanyDetailActive())));
                mccD.setOrdere1(config1.StringNull(rs.getString(mccD.getFOrdere1())));

                v_medical_cert_company_detail.add(mccD);

                }
            rs.close();
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(OpdTMedicalCertCompanyDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return v_medical_cert_company_detail;
    }
    public OpdBMedicalCertCompanyOrder getOpdBMedicalCertCompanyOrderByPK(Statement stbangna,String brach_id, String medical_cert_company_order_id) {
//        Connection conn;
        String sql="";
        try {
//                conn = config1.getConnectionBangna();
//                Statement stbangna = conn.createStatement();

            sql="Select * "
                +"From "+mcco.getOpdBMedicalCertCompanyOrder()+" "
                +"Where "+mcco.getFBOpdBMedicalCertCompanyOrderId()+"='"+medical_cert_company_order_id+"'";
                //+"Order By "+admintbilllab.getFBillLabId()+" desc";
            ResultSet rs = stbangna.executeQuery(sql);
            while(rs.next()){
                mcco = new OpdBMedicalCertCompanyOrder();
                mcco.setBMedicalCertCompanyOrderId(config1.StringNull(rs.getString(mcco.getFBOpdBMedicalCertCompanyOrderId())));
                mcco.setMedicalCertCompanyOrderActive(config1.StringNull(rs.getString(mcco.getFMedicalCertCompanyOrderActive())));
                mcco.setOrdere(config1.StringNull(rs.getString(mcco.getFOrdere())));
                mcco.setOrdert(config1.StringNull(rs.getString(mcco.getFOrdert())));
                mcco.setSort1(config1.StringNull(rs.getString(mcco.getFSort1())));
                
                mcco.setLabNumber(config1.StringNull(rs.getString(mcco.getFLabNumber())));

                }
            rs.close();
//            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(OpdTMedicalCertCompanyDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return mcco;
    }
    public Vector getOpdBMedicalCertCompanyOrder(String brach_id, String where, String medical_cert_company_order_id, String flag) {
        Connection conn;
        String sql="";
        Vector v_medical_cert_company_order = new Vector();
        try {
            conn = config1.getConnectionBangna();
            Statement stbangna = conn.createStatement();

            if(flag.equals("all")) {
                sql="Select * "
                +"From "+mcco.getOpdBMedicalCertCompanyOrder()+" "
                +"Where "+mcco.getFMedicalCertCompanyOrderActive()+"='1' "
                +"Order By "+mcco.getFSort1();
            }else {
                sql="Select * "
                +"From "+mcco.getOpdBMedicalCertCompanyOrder()+" "
                +"Where "+mcco.getFMedicalCertCompanyOrderActive()+"='1'";
            }
            
            //+"Order By "+admintbilllab.getFBillLabId()+" desc";
            ResultSet rs = stbangna.executeQuery(sql);
            while(rs.next()){
                mcco = new OpdBMedicalCertCompanyOrder();
                mcco.setBMedicalCertCompanyOrderId(config1.StringNull(rs.getString(mcco.getFBOpdBMedicalCertCompanyOrderId())));
                mcco.setMedicalCertCompanyOrderActive(config1.StringNull(rs.getString(mcco.getFMedicalCertCompanyOrderActive())));
                mcco.setOrdere(config1.StringNull(rs.getString(mcco.getFOrdere())));
                mcco.setOrdert(config1.StringNull(rs.getString(mcco.getFOrdert())));
                mcco.setSort1(config1.StringNull(rs.getString(mcco.getFSort1())));
                
                mcco.setLabNumber(config1.StringNull(rs.getString(mcco.getFLabNumber())));

                v_medical_cert_company_order.add(mcco);
                }
            rs.close();
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(OpdTMedicalCertCompanyDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return v_medical_cert_company_order;
    }
    public OpdBMedicalCertCompanyResult getOpdBMedicalCertCompanyResultByPK(Statement stbangna,String brach_id, String medical_cert_company_result_id) {
//        Connection conn;
        String sql="";
        try {
//                conn = config1.getConnectionBangna();
//                Statement stbangna = conn.createStatement();
            sql="Select * "
                +"From "+medical_cert_company_result.getOpdBMedicalCertCompanyResult()+" "
                +"Where "+medical_cert_company_result.getFBMedicalCertCompanyResultId()+"='"+medical_cert_company_result_id+"'";
                //+"Order By "+admintbilllab.getFBillLabId()+" desc";
            ResultSet rs = stbangna.executeQuery(sql);
            while(rs.next()){
                medical_cert_company_result = new OpdBMedicalCertCompanyResult();
                medical_cert_company_result.setBMedicalCertCompanyOrderId(config1.StringNull(rs.getString(medical_cert_company_result.getFBMedicalCertCompanyOrderId())));
                medical_cert_company_result.setBMedicalCertCompanyResultId(config1.StringNull(rs.getString(medical_cert_company_result.getFBMedicalCertCompanyResultId())));
                medical_cert_company_result.setMedicalCertCompanyResultActive(config1.StringNull(rs.getString(medical_cert_company_result.getFMedicalCertCompanyResultActive())));
                medical_cert_company_result.setResulte(config1.StringNull(rs.getString(medical_cert_company_result.getFResulte())));
                medical_cert_company_result.setResultt(config1.StringNull(rs.getString(medical_cert_company_result.getFResultt())));
                
                medical_cert_company_result.setSort1(config1.StringNull(rs.getString(medical_cert_company_result.getFSort1())));

                }
            rs.close();
//            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(OpdTMedicalCertCompanyDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return medical_cert_company_result;
    }
    public Vector getOpdBMedicalCertCompanyResult(String brach_id, String where, String medical_cert_company_result_id, String flag) {
        Connection conn;
        String sql="";
        Vector v_medical_cert_company_result = new Vector();
        try {
            conn = config1.getConnectionBangna();
            Statement stbangna = conn.createStatement();
            sql="Select * "
                +"From "+medical_cert_company_result.getOpdBMedicalCertCompanyResult()+" "
                +"Where "+medical_cert_company_result.getFBMedicalCertCompanyResultId()+"='"+medical_cert_company_result_id+"'";
                //+"Order By "+admintbilllab.getFBillLabId()+" desc";
            ResultSet rs = stbangna.executeQuery(sql);
            while(rs.next()){
                medical_cert_company_result = new OpdBMedicalCertCompanyResult();
                medical_cert_company_result.setBMedicalCertCompanyOrderId(config1.StringNull(rs.getString(medical_cert_company_result.getFBMedicalCertCompanyOrderId())));
                medical_cert_company_result.setBMedicalCertCompanyResultId(config1.StringNull(rs.getString(medical_cert_company_result.getFBMedicalCertCompanyResultId())));
                medical_cert_company_result.setMedicalCertCompanyResultActive(config1.StringNull(rs.getString(medical_cert_company_result.getFMedicalCertCompanyResultActive())));
                medical_cert_company_result.setResulte(config1.StringNull(rs.getString(medical_cert_company_result.getFResulte())));
                medical_cert_company_result.setResultt(config1.StringNull(rs.getString(medical_cert_company_result.getFResultt())));

                medical_cert_company_result.setSort1(config1.StringNull(rs.getString(medical_cert_company_result.getFSort1())));

                v_medical_cert_company_result.add(medical_cert_company_result);

                }
            rs.close();
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(OpdTMedicalCertCompanyDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return v_medical_cert_company_result;
    }
    public String setSaveOpdTMedicalCertCompany(String branch_id, OpdTMedicalCertCompany item) throws Exception {
        int chk=0;
        String sql="", ma_date="", attend_date="", max="";
        Connection conn;
        Statement st;
        try {
            conn = config1.getConnectionBangna();
            st = conn.createStatement();
            mcc = getOpdTMedicalCertCompanyByPK(branch_id,item.getMedicalCertCompanyId());
            item.setPatientFullnamet(item.getPatientFullnamet().replace("'", "''"));
            item.setComment1(item.getComment1().replace("'", "''"));
            item.setDoctorNamee(item.getDoctorNamee().replace("'", "''"));
            item.setDoctorNamet(item.getDoctorNamet().replace("'", "''"));
            if(mcc.getMedicalCertCompanyId().equals("")) {
                max = getMaxRowOpdTMedicalCertCompany(conn);
                sql="Insert Into "+mcc.getOpdTMedicalCertCompany()+"("+
                        mcc.getFMedicalCertCompanyId()+", "+mcc.getFComment1()+", "+
                        mcc.getFDoctorId()+","+ mcc.getFDoctorNamee()+","+
                        mcc.getFDoctorNamet()+","+ mcc.getFMedicalCertCompanyDate()+","+
                        mcc.getFBranchId()+","+ mcc.getFPatientFullnamet()+"," +
                        mcc.getFMedicalCertCompanyActive()+","+mcc.getFVisitHn()+"," +
                        mcc.getFMedicalCertCompanyTime()+","+mcc.getFTVisitId()+"," +
                        mcc.getFVisitVn()+","+mcc.getFStatusLatent()+","
                        + mcc.getFStatusMedicalCert()+","+mcc.getFStatusHasLab()+","
                        + mcc.getFStatusHasXray()+") "+
                        "Values('"+max+"','"+item.getComment1()+"','"+
                        item.getDoctorId() + "','"+ item.getDoctorNamee()+"','"+
                        item.getDoctorNamet() + "','"+ item.getMedicalCertCompanyDate()+"','"+
                        item.getBranchId() + "','"+ item.getPatientFullnamet()+"','" +
                        item.getMedicalCertCompanyActive()+"','"+item.getVisitHn()+"','" +
                        item.getMedicalCertCompanyTime()+"','"+item.getTVisitId()+"','" +
                        item.getVisitVn()+"','"+item.statusLatent+"','"
                        + item.statusMedicalCert+"','"+item.statusHasLab+"','"
                        + item.statusHasXray+"')";
            }else{
                sql = "Update "+mcc.getOpdTMedicalCertCompany()+" set "+
                mcc.getFPatientFullnamet()+" = '"+item.getPatientFullnamet()+"', "+
                mcc.getFComment1()+" = '"+item.getComment1()+"', "+
                mcc.getFDoctorId()+" = '"+item.getDoctorId()+"', "+
                mcc.getFDoctorNamee()+" = '"+item.getDoctorNamee()+"', "+
                mcc.getFDoctorNamet()+" = '"+item.getDoctorNamet()+"', "+
                mcc.getFMedicalCertCompanyDate()+" = '"+item.getMedicalCertCompanyDate()+"', "+
                mcc.getFBranchId()+" = '"+item.getBranchId()+"', "+
                mcc.getFMedicalCertCompanyActive()+" = '"+item.getMedicalCertCompanyActive()+"', "+
                mcc.getFVisitHn()+" = '"+item.getVisitHn()+"', "+
                mcc.getFMedicalCertCompanyTime()+" = '"+item.getMedicalCertCompanyTime()+"', "+
                mcc.getFTVisitId()+" = '"+item.getTVisitId()+"', "+
                mcc.getFVisitVn()+" = '"+item.getVisitVn()+"', "+
                mcc.getFStatusLatent()+" = '"+item.statusLatent+"', "+
                mcc.getFStatusMedicalCert()+" = '"+item.statusMedicalCert+"', "+
                mcc.getFStatusHasLab()+" = '"+item.statusHasLab+"', "+
                mcc.getFStatusHasXray()+" = '"+item.statusHasXray+"' "+
                "Where "+mcc.getFMedicalCertCompanyId()+" = '"+item.getMedicalCertCompanyId()+"'";
                max = item.getMedicalCertCompanyId();
            }
            chk = st.executeUpdate(sql);
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(OpdTMedicalCertCompanyDB.class.getName()).log(Level.SEVERE, null, ex);
            max = ex.getMessage();
        }
        return max;
    }
    public String setSaveOpdTMedicalCertCompanyDetail(String branch_id, OpdTMedicalCertCompanyDetail item) throws Exception {
        int chk=0;
        String sql="", max="";
        Connection conn;
        Statement st;
        try {
            conn = config1.getConnectionBangna();
            st = conn.createStatement();
            mccD = getOpdTMedicalCertCompanyDetailByPK(branch_id,"",item.getMedicalCertCompanyDetailId(),"");
            item.setOrder1(item.getOrder1().replace("'", "''"));
            item.setOrdere1(item.getOrdere1().replace("'", "''"));
            item.setResult1(item.getResult1().replace("'", "''"));
            if(mccD.getMedicalCertCompanyId().equals("")) {
                max = getMaxRowOpdTMedicalCertCompanyDetail(conn);
                sql="Insert Into "+mccD.getOpdTMedicalCertCompanyDetail()+"("+
                        mccD.getFMedicalCertCompanyDetailId()+", "+mccD.getFMedicalCertCompanyId()+", "+
                        mccD.getFOrder1()+","+ mccD.getFResult1()+"," +
                        mccD.getFSort1()+","+mccD.getFMedicalCertCompanyDetailActive()+"," +
                        mccD.getFOrdere1()+","+mccD.getFfItemGroupId()+") "+
                        "Values('"+max+"','"+item.getMedicalCertCompanyId()+"','"+
                        item.getOrder1() + "','"+ item.getResult1()+"','" +
                        item.getSort1()+"','"+item.getMedicalCertCompanyDetailActive()+"','" +
                        item.getOrdere1()+"','"+item.fItemGroupId+"')";
            }else{
                sql = "Update "+mccD.getOpdTMedicalCertCompanyDetail()+" set "+
                mccD.getFMedicalCertCompanyId()+" = '"+item.getMedicalCertCompanyId()+"', "+
                mccD.getFOrder1()+" = '"+item.getOrder1()+"', "+
                mccD.getFResult1()+" = '"+item.getResult1()+"', "+
                mccD.getFSort1()+" = '"+item.getSort1()+"', "+
                mccD.getFMedicalCertCompanyDetailActive()+" = '"+item.getMedicalCertCompanyDetailActive()+"', "+
                mccD.getFOrdere1()+" = '"+item.getOrdere1()+"', "+
                mccD.getFfItemGroupId()+" = '"+item.fItemGroupId+"' "+
                "Where "+mccD.getFMedicalCertCompanyDetailId()+" = '"+item.getMedicalCertCompanyDetailId()+"'";
                max = item.getMedicalCertCompanyId();
            }
            chk = st.executeUpdate(sql);
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(OpdTMedicalCertCompanyDB.class.getName()).log(Level.SEVERE, null, ex);
            max = ex.getMessage();
        }
        return max;
    }
    public String setSaveOpdTMedicalCertCompanyOrder(String branch_id, OpdBMedicalCertCompanyOrder item) throws Exception {
        int chk=0;
        String sql="", ma_date="", attend_date="", max="";
        Connection conn;
        Statement st;
        try {
            conn = config1.getConnectionBangna();
            st = conn.createStatement();
            mcco = getOpdBMedicalCertCompanyOrderByPK(st,branch_id,item.getBMedicalCertCompanyOrderId());
            item.setOrdere(item.getOrdere().replace("'", "''"));
            item.setOrdert(item.getOrdert().replace("'", "''"));
            if(mcco.getBMedicalCertCompanyOrderId().equals("")) {
                max = getMaxRowOpdBMedicalCertCompanyOrder(conn);
                sql="Insert Into "+mcco.getOpdBMedicalCertCompanyOrder()+"("+
                    mcco.getFBOpdBMedicalCertCompanyOrderId()+", "+mcco.getFMedicalCertCompanyOrderActive()+", "+
                    mcco.getFOrdere()+","+ mcco.getFOrdert()+"," +
                    mcco.getFSort1()+","+mcco.getFLabNumber()+") "+
                    "Values('"+max+"','"+item.getFMedicalCertCompanyOrderActive()+"','"+
                    item.getFOrdere() + "','"+ item.getFOrdert()+"','" +
                    item.getFSort1()+"','"+item.getLabNumber()+"')";
            }else{
                sql = "Update "+mcco.getOpdBMedicalCertCompanyOrder()+" set "+
                mcco.getFMedicalCertCompanyOrderActive()+" = '"+item.getMedicalCertCompanyOrderActive()+"', "+
                mcco.getFOrdere()+" = '"+item.getOrdere()+"', "+
                mcco.getFOrdert()+" = '"+item.getOrdert()+"' "+
                mcco.getFSort1()+" = '"+item.getSort1()+"' "+
                "Where "+mcco.getFBOpdBMedicalCertCompanyOrderId()+" = '"+item.getBMedicalCertCompanyOrderId()+"'";
                max = item.getBMedicalCertCompanyOrderId();
            }
            chk = st.executeUpdate(sql);
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(OpdTMedicalCertCompanyDB.class.getName()).log(Level.SEVERE, null, ex);
            max = ex.getMessage();
        }
        return max;
    }
    public String setSaveOpdTMedicalCertCompanyResult(String branch_id, OpdBMedicalCertCompanyResult item) throws Exception {
        int chk=0;
        String sql="", max="";
        Connection conn;
        Statement st;
        try {
            conn = config1.getConnectionBangna();
            st = conn.createStatement();
            medical_cert_company_result = getOpdBMedicalCertCompanyResultByPK(st,branch_id,item.getBMedicalCertCompanyResultId());
            item.setResulte(item.getResulte().replace("'", "''"));
            item.setResultt(item.getResultt().replace("'", "''"));
            if(medical_cert_company_result.getBMedicalCertCompanyResultId().equals("")) {
                max = getMaxRowOpdBMedicalCertCompanyResult(conn);
                sql="Insert Into "+medical_cert_company_result.getOpdBMedicalCertCompanyResult()+"("+
                        medical_cert_company_result.getFBMedicalCertCompanyResultId()+", "+medical_cert_company_result.getFBMedicalCertCompanyOrderId()+", "+
                        medical_cert_company_result.getFMedicalCertCompanyResultActive()+","+ medical_cert_company_result.getFResulte()+"," +
                        medical_cert_company_result.getFResultt()+","+medical_cert_company_result.getFSort1()+") "+
                        "Values('"+max+"','"+item.getFBMedicalCertCompanyOrderId()+"','"+
                        item.getFMedicalCertCompanyResultActive() + "','"+ item.getFResulte()+"','" +
                        item.getFResultt()+"','"+item.getFSort1()+"')";
            }else{
                sql = "Update "+medical_cert_company_result.getOpdBMedicalCertCompanyResult()+" set "+
                medical_cert_company_result.getFBMedicalCertCompanyOrderId()+" = '"+item.getBMedicalCertCompanyOrderId()+"', "+
                medical_cert_company_result.getFMedicalCertCompanyResultActive()+" = '"+item.getMedicalCertCompanyResultActive()+"', "+
                medical_cert_company_result.getFResulte()+" = '"+item.getResulte()+"', "+
                medical_cert_company_result.getFResultt()+" = '"+item.getResultt()+"', "+
                medical_cert_company_result.getFSort1()+" = '"+item.getSort1()+"' "+
                "Where "+medical_cert_company_result.getFBMedicalCertCompanyResultId()+" = '"+item.getBMedicalCertCompanyResultId()+"'";
                max = item.getBMedicalCertCompanyOrderId();
            }
            chk = st.executeUpdate(sql);
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(OpdTMedicalCertCompanyDB.class.getName()).log(Level.SEVERE, null, ex);
            max = ex.getMessage();
        }
        return max;
    }
    public String getTrMedicalCertCompanyOrder(String branch_id, String language, OpdTMedicalCertCompany medical_cert_company, String flag) {
        String sql="", text="", row_color="", font_color="", order1="",node="", result="", chkon="", btn_cert="";
        String visit_id="", sort1="", ordere1="";
        Integer row=0;
        TVisitVitalSignDB1 t_visit_vital_signdb = new TVisitVitalSignDB1(config1);
        PatientVisit patient_visit = new PatientVisit();
        Vector v_cert_company_order = new Vector();
        Vector v_visit = new Vector();
        v_cert_company_order = getOpdBMedicalCertCompanyOrder(branch_id,"", "","all");
        v_visit = config1.getPatientVisit(branch_id,medical_cert_company.getMedicalCertCompanyDate(),"",medical_cert_company.getVisitHn());
        for(int j=0;j<=v_visit.size()-1;j++){
            patient_visit = (PatientVisit) v_visit.get(j);
            visit_id = patient_visit.getTVisitId();
        }
        for(int i=0;i<=v_cert_company_order.size()-1;i++) {
            mcco = (OpdBMedicalCertCompanyOrder)v_cert_company_order.get(i);
            row++;
            order1 = "";
            ordere1 = "";
            result="";
            chkon="";
            if(language.equals("thai")) {
                order1=mcco.getOrdert();
                ordere1=mcco.getOrdere();
                sort1=mcco.getSort1();
                if(flag.equals("old_data")) {
                    mccD = getOpdTMedicalCertCompanyDetailByPK(branch_id,medical_cert_company.getMedicalCertCompanyId(),order1,"result");
                    if(!mccD.getMedicalCertCompanyDetailId().equals("")) {
                        order1 = mccD.getOrder1();
                        ordere1 = mccD.getOrdere1();
                        result = mccD.getResult1();
                        chkon = "checked";
                    }else{
                        order1=mcco.getOrdert();
                        ordere1=mcco.getOrdere();
                    }
                }else{
                    if(order1.equals("�ѹ�֡�ѭ�ҳ�վ")){
                        //visit_id = medical_cert_company.getTVisitId();
                        result = t_visit_vital_signdb.getPatientVisitVitalSign(branch_id, visit_id);
                        if(result.length()>0) {
                            chkon = "checked";
                        }
                        //btn_cert="<input type='button' name='btn_cert_vital_sign' id='btn_cert_vital_sign' value='...' onclick='searchVitalSign("+row+");'>";
                    }else if(order1.equals("��ǹ�٧/���˹ѡ")) {
                        result = t_visit_vital_signdb.getPatientVisitWidthHeight(branch_id, visit_id);
                        if(result.length()>0) {
                            chkon = "checked";
                        }
                        btn_cert="";
                    }else if(order1.equals("BMI")) {
                        result = t_visit_vital_signdb.getPatientVisitBMI(branch_id, visit_id);
                        if(result.length()>0) {
 //                           chkon = "checked";
                        }
                    }else if(!mcco.labNumber.equals("")){
                        result = rLabDB.getResultLab(branch_id, visit_id, mcco.labNumber);
                        if(result.length()>0) {
                            chkon = "checked";
                        }
                    
                        
                    }
                }
            }else {
                order1=mcco.getOrdere();
            }
            text+="<tr><td>&nbsp;&nbsp;&nbsp;</td><td>"+row.toString()+"</td>" +
                "<td><label><input type='checkbox' name='chk_cert_"+row+"' id ='chk_cert_"+row+"' onchange='cal()' "+chkon+"/>"+order1+"</label></td>" +
                "<td><input type='text' name ='txt_cert_result_"+row+"' id = 'txt_cert_result_"+row+"' size='50' onchange='chkrow("+row+")' value='"+result+"'>" +
                "<input type='hidden' name ='txt_cert_order_"+row+"' id = 'txt_cert_order_"+row+"' size='50' value='"+order1+"'>" +
                "<input type='hidden' name ='txt_cert_sort_"+row+"' id = 'txt_cert_sort_"+row+"' size='50' value='"+sort1+"'>" +
                "<input type='hidden' name ='txt_cert_ordere_"+row+"' id = 'txt_cert_ordere_"+row+"' size='50' value='"+ordere1+"'>" +
                btn_cert+"</td></tr>";
        }
        return text;
    }
    public String setMedicalCertCompanyUpdateActive(String branch_id,String medical_cert_company_id, String df_active) throws Exception {
        int chk=0;
        String sql="", ma_date="", attend_date="", max="";
        Connection conn;
        Statement st;
        try {
            conn = config1.getConnectionBangna();
            st = conn.createStatement();

            sql = "Update "+mcc.getOpdTMedicalCertCompany()+" set "+
            mcc.getFMedicalCertCompanyActive()+" = '"+df_active+"' "+
            "Where "+mcc.getFMedicalCertCompanyId()+" = '"+medical_cert_company_id+"' and " +
            mcc.getFBranchId()+"='"+branch_id+"'";

            st.executeUpdate(sql);
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(OpdTMedicalCertCompanyDB.class.getName()).log(Level.SEVERE, null, ex);
            max = ex.getMessage();
        }
        return max;
    }
    public String setMedicalCertCompanyDetailUpdateActive(String medical_cert_company_id, String df_active) throws Exception {
        int chk=0;
        String sql="", ma_date="", attend_date="", max="";
        Connection conn;
        Statement st;
        try {
            conn = config1.getConnectionBangna();
            st = conn.createStatement();

            sql = "Update "+mccD.getOpdTMedicalCertCompanyDetail()+" set "+
            mccD.getFMedicalCertCompanyDetailActive()+" = '"+df_active+"' "+
            "Where "+mccD.getFMedicalCertCompanyId()+" = '"+medical_cert_company_id+"' ";

            st.executeUpdate(sql);
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(OpdTMedicalCertCompanyDB.class.getName()).log(Level.SEVERE, null, ex);
            max = ex.getMessage();
        }
        return max;
    }
    public String setMedicalCertCompanyUpdateStatusPrint(String branch_id,String mccId, String statusPrint) throws Exception {
        int chk=0;
        String sql="", max="";
        Connection conn;
        Statement st;
        try {
            conn = config1.getConnectionBangna();
            st = conn.createStatement();

            sql = "Update "+mcc.getOpdTMedicalCertCompany()+" set "+
            mcc.getFStatusPrint()+" = '"+statusPrint+"' "+
            "Where "+mcc.getFMedicalCertCompanyId()+" = '"+mccId+"' and " + mcc.getFBranchId()+"='"+branch_id+"'";
            st.executeUpdate(sql);
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(OpdTMedicalCertCompanyDB.class.getName()).log(Level.SEVERE, null, ex);
            max = ex.getMessage();
        }
        return max;
    }
    public String setMedicalCertCompanyUpdateStatusLatent(String branch_id,String mccId, String statusPrint) throws Exception {
        int chk=0;
        String sql="", max="";
        Connection conn;
        Statement st;
        try {
            conn = config1.getConnectionBangna();
            st = conn.createStatement();

            sql = "Update "+mcc.getOpdTMedicalCertCompany()+" set "+
            mcc.getFStatusPrint()+" = '"+statusPrint+"' "+
            "Where "+mcc.getFMedicalCertCompanyId()+" = '"+mccId+"' and " + mcc.getFBranchId()+"='"+branch_id+"'";
            st.executeUpdate(sql);
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(OpdTMedicalCertCompanyDB.class.getName()).log(Level.SEVERE, null, ex);
            max = ex.getMessage();
        }
        return max;
    }
    public String setMedicalCertCompanyUpdateStatusXray(String branch_id,String mccId, String statusXray) throws Exception {
        int chk=0;
        String sql="", max="";
        Connection conn;
        Statement st;
        try {
            conn = config1.getConnectionBangna();
            st = conn.createStatement();

            sql = "Update "+mcc.getOpdTMedicalCertCompany()+" set "+
            mcc.getFStatusHasXray()+" = '"+statusXray+"' "+
            "Where "+mcc.getFMedicalCertCompanyId()+" = '"+mccId+"' and " + mcc.getFBranchId()+"='"+branch_id+"'";
            chk = st.executeUpdate(sql);
            max = String.valueOf(chk);
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(OpdTMedicalCertCompanyDB.class.getName()).log(Level.SEVERE, null, ex);
            max = ex.getMessage();
        }
        return max;
    }
}
