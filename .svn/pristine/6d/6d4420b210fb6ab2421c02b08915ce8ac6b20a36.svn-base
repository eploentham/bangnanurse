<%-- 
    Document   : medical_cert_company_save
    Created on : Dec 27, 2009, 11:51:28 PM
    Author     : root
--%>
<%@page import="com.bangna.control.OrderControl"%>
<%@page import="bangnanurse.objdb.OpdTMedicalCertCompanyDB"%>
<%@page import="bangnanurse.object.OpdBMedicalCertCompanyOrder"%>
<%@page import="bangnanurse.object.OpdBMedicalCertCompanyResult"%>
<%@page import="bangnanurse.object.OpdTMedicalCertCompany"%>
<%@page import="bangnanurse.object.OpdTMedicalCertCompanyDetail"%>
<%@page import="com.bangna.control.LabControl"%>
<%@page import ="java.sql.*" %>
<%@page import ="java.text.*" %>
<%@page import ="java.util.* " %>
<%@page import ="bangnaLibrary.*" %>
<%@page contentType="text/html" pageEncoding="TIS-620"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%
String cbo_branch="", branch_id="", text="", patient_hn="", patient_fullnamet="",date_current="",mccId="";
String date_currentdb="", chk_cert="", order1="", result1="", chk_name="", order1_name="", result1_name="",doctor_id="",comment1="";
String visit_id="",visit_vn="", sort1="",sort1_name="", ordere1="", order1_namee="",statusMedicalCert="",statusLatent="";
String doctor_fullnamet="",doctor_fullnamee="", chkLab="", chkXray="";
Config1 config1 = new Config1();
BBranch branch = new BBranch();
OpdTMedicalCertCompanyDetail mccD = new OpdTMedicalCertCompanyDetail();
OpdTMedicalCertCompany mcc = new OpdTMedicalCertCompany();
OpdBMedicalCertCompanyResult medical_cert_company_result = new OpdBMedicalCertCompanyResult();
OpdBMedicalCertCompanyOrder medical_cert_company_order = new OpdBMedicalCertCompanyOrder();
OpdTMedicalCertCompanyDB medical_cert_companydb = new OpdTMedicalCertCompanyDB(config1);
Patient patient = new Patient();
OrderControl oc = new OrderControl(config1);
Doctor doctor = new Doctor();
try {
    if(request.getParameter("branch_id")!=null) {
        branch_id = new String (request.getParameter("branch_id").getBytes("ISO8859_1"),"TIS-620");
    }
    if(request.getParameter("txt_patient_hn")!=null) {
        patient_hn = new String (request.getParameter("txt_patient_hn").getBytes("ISO8859_1"),"TIS-620");
    }
    if(request.getParameter("txt_patient_fullnamet")!=null) {
        patient_fullnamet = new String (request.getParameter("txt_patient_fullnamet").getBytes("ISO8859_1"),"TIS-620");
    }
    if(request.getParameter("txt_date_current")!=null) {
        date_current = new String (request.getParameter("txt_date_current").getBytes("ISO8859_1"),"TIS-620");
    }
    if(request.getParameter("txt_medical_cert_company_id")!=null) {
        mccId = new String (request.getParameter("txt_medical_cert_company_id").getBytes("ISO8859_1"),"TIS-620");
    }
    if(request.getParameter("cbo_doctor")!=null) {
        doctor_id = new String (request.getParameter("cbo_doctor").getBytes("ISO8859_1"),"TIS-620");
    }
    if(request.getParameter("cbo_visit")!=null) {
        visit_id = new String (request.getParameter("cbo_visit").getBytes("ISO8859_1"),"TIS-620");
    }
    if(request.getParameter("txt_visit_vn")!=null) {
        visit_vn = new String (request.getParameter("txt_visit_vn").getBytes("ISO8859_1"),"TIS-620");
    }
    if(request.getParameter("txt_doctor_fullnamet")!=null) {
        doctor_fullnamet = new String (request.getParameter("txt_doctor_fullnamet").getBytes("ISO8859_1"),"TIS-620");
    }
    if(request.getParameter("txt_comment1")!=null) {
        comment1 = new String (request.getParameter("txt_comment1").getBytes("ISO8859_1"),"TIS-620");
    }
    if(request.getParameter("statusMedicalCert")!=null) {
        statusMedicalCert = new String (request.getParameter("statusMedicalCert").getBytes("ISO8859_1"),"TIS-620");
    }
    if(request.getParameter("statusLatent")!=null) {
        statusLatent = new String (request.getParameter("statusLatent").getBytes("ISO8859_1"),"TIS-620");
    }
    if(branch_id.equals("")){
        branch = config1.getBranchActive();
        branch_id = branch.getBranchId();
    }
    if(doctor_fullnamet.equals("")) {
        doctor = config1.getDoctorFullNamet(branch_id, doctor_id);
        doctor_fullnamet = doctor.getDoctorNamet()+" "+doctor.getDoctorLastNamet();
        doctor_fullnamee = doctor.getDoctorNamee()+" "+doctor.getDoctorLastNamee();
    }
    date_currentdb = config1.DateFormatShow2DB(date_current, "ddMMyyyy");
    mcc.setBranchId(branch_id);
    mcc.setComment1(comment1);
    mcc.setDoctorId(doctor_id);
    mcc.setDoctorNamet(doctor_fullnamet);
    mcc.setDoctorNamee(doctor_fullnamee);
    mcc.setMedicalCertCompanyDate(date_currentdb);
    mcc.setMedicalCertCompanyId(mccId);
    mcc.setPatientFullnamet(patient_fullnamet);
    mcc.setVisitHn(patient_hn);
    mcc.setTVisitId(visit_id);
    mcc.setVisitVn(visit_vn);
    mcc.setMedicalCertCompanyActive("1");
    mcc.setMedicalCertCompanyTime(config1.getDate("hh:mm"));
    mcc.statusLatent=statusLatent;
    mcc.statusMedicalCert=statusMedicalCert;
    Boolean chk = oc.getHasLabByVisitId(branch_id, visit_id);
    Boolean chk1 = oc.getHasXrayByVisitId(branch_id, visit_id);
    if(chk) chkLab = "1";
    else chkLab = "0";
    if(chk1) chkXray = "1";
    else chkXray = "0";
    mcc.statusHasLab = chkLab;
    mcc.statusHasXray = chkXray;

    mccId = medical_cert_companydb.setSaveOpdTMedicalCertCompany(branch_id, mcc);
    if(mccId.length()>=8) {
        medical_cert_companydb.setMedicalCertCompanyDetailUpdateActive(mccId, "3");
        medical_cert_companydb.setMedicalCertCompanyUpdateStatusXray(branch_id, mccId, "0");
        for(int i=1;i<=30;i++) {
            chk_name = "chk_cert_"+i;
            order1_name = "txt_cert_order_"+i;
            order1_namee = "txt_cert_ordere_"+i;
            result1_name = "txt_cert_result_"+i;
            sort1_name = "txt_cert_sort_"+i;
            if(request.getParameter(chk_name)!=null) chk_cert = new String (request.getParameter(chk_name).getBytes("ISO8859_1"),"TIS-620");
            else   chk_cert="";
            
            if(!chk_cert.equals("")) {
                order1 = new String (request.getParameter(order1_name).getBytes("ISO8859_1"),"TIS-620");
                ordere1 = new String (request.getParameter(order1_namee).getBytes("ISO8859_1"),"TIS-620");
                result1 = new String (request.getParameter(result1_name).getBytes("ISO8859_1"),"TIS-620");
                sort1 = new String (request.getParameter(sort1_name).getBytes("ISO8859_1"),"TIS-620");
                if(order1.indexOf("àÍç¡«àÃÂì»Í´")>0) medical_cert_companydb.setMedicalCertCompanyUpdateStatusXray(branch_id, mccId, "1");
                else medical_cert_companydb.setMedicalCertCompanyUpdateStatusXray(branch_id, mccId, "0");
                mccD = new OpdTMedicalCertCompanyDetail();
                mccD.setMedicalCertCompanyDetailId("");
                mccD.setMedicalCertCompanyId(mccId);
                mccD.setOrder1(order1);
                mccD.setResult1(result1);
                mccD.setSort1(sort1);
                mccD.setOrdere1(ordere1);
                mccD.setMedicalCertCompanyDetailActive("1");
                medical_cert_companydb.setSaveOpdTMedicalCertCompanyDetail(branch_id, mccD);
            }
        }
    }else{
        text = mccId;
    }
} catch (Exception ex) {
    text = ex.getMessage();
}

response.sendRedirect("medical_cert_company_add.jsp?branch_id="+branch_id+"&medical_cert_company_id="+mccId);
%>
