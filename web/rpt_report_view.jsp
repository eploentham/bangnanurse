<%--
    Document   : rpt_report_view
    Created on : Oct 29, 2009, 10:41:51 PM
    Author     : root
    Update By Ekapop 55-02-07 Ticket Id :
    m1
    Update By Ekapop 55-02-28 Ticket Id :
    m2
    Update By Ekapop 55-03-21 Ticket Id :
    m3 เพิ่ม Log
       เอารูปออก 
--%>
<%@page import="bangnanurse.control.NurseControl"%>
<%@page import="bangnanurse.objdb.RFoodsOrderDB"%>
<%@page import="bangnanurse.control.MedicalCertControl"%>
<%@page import="bangnanurse.objdb.OpdTMedicalCertCompanyDB"%>
<%@page import="bangnanurse.object.OpdTMedicalCertCompany"%>
<%@ page import ="bangnaLibrary.*" %>
<%@ page import ="java.sql.*" %>
<%@ page import ="java.util.*" %>
<%@ page import ="java.io.*" %>
<%@ page import ="net.sf.jasperreports.engine.*" %>
<%@page contentType="text/html" pageEncoding="TIS-620"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%
    Config1 config1 = new Config1();
    String branch_id="",branch_name="", text="", header1="", header4="", address_name="", header3="";
    String jdbc = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    String url = "jdbc:sqlserver://172.1.1.1:1433";
    Connection conn=null;
    Statement st;
    ResultSet rs;
    Map par = new HashMap();
    par.put("header1","โรงพยาบาลบางนา 1 1302 ถ.บางนา-ตราด กม.3 แขวงบางนา เขตบางนา กรุงเทพฯ 10260 Tel: (662) 746-8630-8 Fax: (662) 398-9531");
    par.put("header2","BANGNA GENERAL HOSPITAL 1302 Bangna-Trad Road, Bangna,Bangkok Thailand 10260 Email :BANGNA1@BANGNA.CO.TH");
    String reportname = config1.StringNull(request.getParameter("txt_report_name"));
    String form = config1.StringNull(request.getParameter("txt_form"));
    branch_id = config1.StringNull(request.getParameter("cbo_branch"));
    branch_name = config1.getSiteNamet(branch_id);
    OpdTMedicalCertCompany mcc = new OpdTMedicalCertCompany();//m2+
    //OpdTMedicalCertCompanyDB mccdb = new OpdTMedicalCertCompanyDB(config1);//m2+
    MedicalCertControl theMCC = new MedicalCertControl(config1);//m3+
    NurseControl theNC = new NurseControl(config1);

    //form = "daily";
    //reportname="asset_item";

    if(branch_id.equals("103001")){
        //branch_name = "สาขาบางนา 1";
    }else if(branch_id.equals("103002")) {
        //branch_name = "สาขาบางนา 2";
    }else if(branch_id.equals("103003")) {
        //branch_name = "สาขาบางนา 3";
    }
    //conn = config1.getConnectionHospital(branch_id);
    header1 = config1.getSiteNamet(branch_id);
    header4 = config1.getAddressEnglish(branch_id);
    if(form.equals("daily")) {
        if(reportname.equals("medical_cert")){
            String medical_cert_company_id = config1.StringNull(request.getParameter("txt_medical_cert_company_id"));
            String flagpage = config1.StringNull(request.getParameter("flagpage"));
            String date_current = "วันที่ "+config1.getDateDBHospital("dd MMMM yyyy");
            String month = date_current.substring(6, 8);
            par.put("header1", header1);
            //par.put("header4", header4);
            par.put("p_medical_cert_company_id", medical_cert_company_id);
            mcc = theMCC.getOpdTMedicalCertCompanyByPK(branch_id, medical_cert_company_id);//m2+
            if(flagpage.equals("english")){
                reportname = reportname+"_english";
                branch_name = config1.getSiteNamee(branch_id);
                address_name = config1.getSiteAddressNamee(branch_id);
                date_current = "Date : "+ config1.getDateDB("MMddyyyy");
                header3 = "MEDICAL CERTIFICATE";
                par.put("header1", branch_name);
                par.put("header2", address_name);
                par.put("date_current", date_current);
                par.put("header3", header3);
                //if(mcc.statusHaslab.equals("1")) par.put("p_valid", "VALID FOR ONE MONTHS");//m2+
                //else par.put("p_valid", "VALID FOR THREE MONTHS");//m2+
                if(mcc.statusHasLab.equals("1") || mcc.statusHasXray.equals("1")) par.put("p_valid", "VALID FOR THREE MONTHS");//m3+
                else par.put("p_valid", "VALID FOR ONE MONTHS");//m3+
            }else {
                //new String (request.getParameter("latent").getBytes("ISO8859_1"),"UTF-8");
                String latent = config1.StringNull(new String (request.getParameter("latent").getBytes("ISO8859_1"),"TIS-620"));//m1+
                reportname = reportname;
                branch_name = config1.getSiteNamet1(branch_id);
                address_name = config1.getSiteAddressNamet(branch_id);
                header3 = "ใบรับรองแพทย์";
                par.put("header1", branch_name);
                par.put("header2", address_name);
                par.put("header3", header3);
                par.put("p_latent", latent);
                par.put("date_current", date_current);
                //par.put("p_valid", "VALID FOR THREE MONTHS");
                //if(mcc.statusHaslab.equals("1")) par.put("p_valid", "มีอายุการใช้งาน 1 เดือน (VALID FOR THREE MONTHS)");//m2+
                //else par.put("p_valid", "มีอายุการใช้งาน 3 เดือน (VALID FOR THREE MONTHS)");//m2+
                if(mcc.statusHasLab.equals("1") || mcc.statusHasXray.equals("1")) par.put("p_valid", "มีอายุการใช้งาน 3 เดือน (VALID FOR THREE MONTHS)");//m3+
                else par.put("p_valid", "มีอายุการใช้งาน 1 เดือน (VALID FOR ONE MONTHS)");//m3+
            }
            //theMCC.blc.saveLog("bangnanurse.medical_cert_company_add", "", "", reportname, config1.getDateDBHospital("yyyyMMdd hh:mm:ss"), request.getRemoteAddr(), "", 
            //        "header3="+header3+",p_medical_cert_company_id="+medical_cert_company_id);
        }else if(reportname.equals("nurse_foods_order_admin")){            
            String  dateStart = config1.StringNull(request.getParameter("date_start"));
            String  dateEnd = config1.StringNull(request.getParameter("date_end"));
            theNC.setRFoodsOrder(branch_id, config1.DateFormatShow2DB(dateStart,"ddMMyyyy"), config1.DateFormatShow2DB(dateEnd,"ddMMyyyy"));
            par.put("header1", branch_name);
            par.put("header2", address_name);
            par.put("header3", header3);
            par.put("dateStart", dateStart);
            par.put("dateEnd", dateEnd);            
        }else if(reportname.equals("nurse_foods_order_admin_detail")){            
            String date_start = config1.StringNull(request.getParameter("date_start"));
            String date_end = config1.StringNull(request.getParameter("date_end"));
            String ward_id = config1.StringNull(request.getParameter("ward_id"));
            theNC.setRFoodsOrder(branch_id, config1.DateFormatShow2DB(date_start,"ddMMyyyy"), config1.DateFormatShow2DB(date_end,"ddMMyyyy"));
            if(!date_start.equals("") || !date_end.equals("") || !ward_id.equals("")){
                date_start = " fo.date_foods_order = '"+date_start+"' ";
                date_end = " fo.date_foods_order = '"+date_end+"' ";
                ward_id = " fo.ward_id = '"+ward_id+"' ";
            }
            par.put("header1", branch_name);
            par.put("header2", address_name);
            par.put("header3", header3);
            par.put("date_start", date_start);
            par.put("date_end", date_end);
            par.put("ward_id", ward_id);                       
        }else if(reportname.equals("nurse_foods_order")){
            String  foods_order_id = config1.StringNull(request.getParameter("foods_order_id"));
            branch_name = config1.getSiteNamet1(branch_id);
            par.put("header1", branch_name);
            par.put("p_foods_order_id", foods_order_id);
            par.put("header2","ใบสั่งอาหาร " );
            //par.put("header3","1" );
            theMCC.blc.saveLog("bangnanurse.nurse_foods_order", "", "", "", config1.getDateDBHospital("yyyyMMdd hh:mm:ss"), request.getRemoteAddr(), "", "");
            conn=config1.getConnectionBangna();
        }else if(reportname.equals("print_sticker_admit")){
            String  visitHn = config1.StringNull(request.getParameter("visitHn"));
            par.put("header1", branch_name);
            par.put("header2", address_name);
            par.put("header3", header3);
            theNC.setPrintSticker(branch_id, visitHn);
        }else{
            
        }
        conn=config1.getConnectionBangna();
    }else if(form.equals("monthly")) {
    }else if(form.equals("yearly")){
    }

    try{
        File reportFile = new File(application.getRealPath("/report/"+reportname+".jasper"));
        String rptfile = application.getRealPath("/report/"+reportname+".jasper");
        //String rptfile = "/data/source//report/"+reportname+".jrxml";
        //out.print(rptfile);

        if (!reportFile.exists())
            throw new JRRuntimeException("File not found. The report desing must be compiled first.");
        byte[] bytes = JasperRunManager.runReportToPdf(rptfile,par,conn);
        response.setContentType("application/pdf");
        response.setContentLength((bytes.length));
        ServletOutputStream outputStream = response.getOutputStream();
        outputStream.write(bytes,0,bytes.length);
        outputStream.flush();
        outputStream.close();
    }catch (Exception ex) {
        text=ex.getMessage();
        System.out.println("Initial SQL Error " + ex.getMessage());
    }
%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=TIS-620">
        <title>JSP Page</title>
    </head>
    <body>
        <% out.print(text); %>
    </body>
</html>
