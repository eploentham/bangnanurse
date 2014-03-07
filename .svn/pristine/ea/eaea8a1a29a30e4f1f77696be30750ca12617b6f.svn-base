<%-- 
    Document   : medical_cert_company_f_vital_sign
    Created on : Jan 5, 2010, 1:33:55 PM
    Author     : root
--%>
<%@page import ="java.sql.*" %>
<%@page import ="java.text.*" %>
<%@page import ="java.util.* " %>
<%@page import ="bangnaLibrary.*" %>
<%@page contentType="text/html" pageEncoding="TIS-620"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%
String text="",branch_id="",flagpage="",visit_id="",date_current="", text_header="", row_color="", font_color="";
String date_currentdb = "", link="";
Config1 config1 = new Config1();
TVisitVitalSignDB t_visit_vital_signdb = new TVisitVitalSignDB();

try {
    if(request.getParameter("branch_id")!=null) {
            branch_id = new String (request.getParameter("branch_id").getBytes("ISO8859_1"),"TIS-620");
        }
    if(request.getParameter("visit_id")!=null) {
            visit_id = new String (request.getParameter("visit_id").getBytes("ISO8859_1"),"TIS-620");
        }
    if(request.getParameter("flagpage")!=null) {
            flagpage = new String (request.getParameter("flagpage").getBytes("ISO8859_1"),"TIS-620");
        }
    
    text = t_visit_vital_signdb.getPatientVisitVitalSign(branch_id, visit_id);
} catch (Exception ex) {
    text = ex.getMessage();
}

out.print(text);
%>
