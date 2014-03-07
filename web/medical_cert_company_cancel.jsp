<%-- 
    Document   : medical_cert_company_save
    Created on : Dec 27, 2009, 11:51:28 PM
    Author     : root
--%>
<%@page import="bangnanurse.objdb.OpdTMedicalCertCompanyDB"%>
<%@page import ="java.sql.*" %>
<%@page import ="java.text.*" %>
<%@page import ="java.util.* " %>
<%@page import ="bangnaLibrary.*" %>
<%@page contentType="text/html" pageEncoding="TIS-620"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%
String cbo_branch="", branch_id="", text="", patient_hn="", patient_fullnamet="",date_current="",medical_cert_company_id="";
String date_currentdb="", chk_cert="", order1="", result1="", chk_name="", order1_name="", result1_name="",doctor_id="",comment1="";
String visit_id="",visit_vn="", sort1="",sort1_name="";
String doctor_fullnamet="";
Config1 config1 = new Config1();
BBranch branch = new BBranch();
OpdTMedicalCertCompanyDB medical_cert_companydb = new OpdTMedicalCertCompanyDB(config1);
Patient patient = new Patient();
Doctor doctor = new Doctor();
try {
    if(request.getParameter("branch_id")!=null) {
            branch_id = new String (request.getParameter("branch_id").getBytes("ISO8859_1"),"TIS-620");
        }
    if(request.getParameter("medical_cert_company_id")!=null) {
            medical_cert_company_id = new String (request.getParameter("medical_cert_company_id").getBytes("ISO8859_1"),"TIS-620");
        }
    if(branch_id.equals("")){
        branch = config1.getBranchActive();
        branch_id = branch.getBranchId();
        }
    if(doctor_fullnamet.equals("")) {
        doctor = config1.getDoctorFullNamet(branch_id, doctor_id);
        doctor_fullnamet = doctor.getDoctorNamet()+" "+doctor.getDoctorLastNamet();
        }
    medical_cert_company_id = medical_cert_companydb.setMedicalCertCompanyUpdateActive(branch_id,medical_cert_company_id, "3");
    medical_cert_company_id = medical_cert_companydb.setMedicalCertCompanyDetailUpdateActive(medical_cert_company_id, "3");
} catch (Exception ex) {
    text = ex.getMessage();
}

response.sendRedirect("medical_cert_company_view.jsp?branch_id="+branch_id+"&flagpage=viewmonth");
%>
