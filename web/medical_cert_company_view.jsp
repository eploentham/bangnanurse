<%-- 
    Document   : medical_cert_company
    Created on : Dec 24, 2009, 2:42:48 PM
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
String cbo_branch="", branch_id="", text="", date_current="";
Config1 config1 = new Config1();
ComboDB combodb = new ComboDB(config1);
//BBranch branch = new BBranch();
//OpdTMedicalCertCompanyDetail medical_cert_company_detail = new OpdTMedicalCertCompanyDetail();
//OpdTMedicalCertCompany medical_cert_company = new OpdTMedicalCertCompany();
//OpdBMedicalCertCompanyResult medical_cert_company_result = new OpdBMedicalCertCompanyResult();
//OpdBMedicalCertCompanyOrder medical_cert_company_order = new OpdBMedicalCertCompanyOrder();
//OpdTMedicalCertCompanyDB medical_cert_companydb = new OpdTMedicalCertCompanyDB(config1);
//Vector v_medical_cert_company = new Vector();
try {
    if(request.getParameter("cbo_branch")!=null) {
        branch_id = new String (request.getParameter("cbo_branch").getBytes("ISO8859_1"),"TIS-620");
    }
    if(branch_id.equals("")){
        branch_id = config1.branch.getBranchId();
    }
    cbo_branch = combodb.getComboBranch(branch_id);
    date_current = config1.getDate("ddMMyyyy");
    //v_medical_cert_company = medical_cert_companydb.getOpdTMedicalCertCompany(branch_id, "", "", "");
    //for(int i=0;i<=v_medical_cert_company.size()-1;i++){
    //
    //    }
} catch (Exception ex) {
    text = ex.getMessage();
}
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=TIS-620">
        <!-- <link href="css/tab.css" rel="stylesheet" type="text/css">
        <link href="css/jquery-ui-1.7.2.custom.css" rel="stylesheet" type="text/css">
        <link href="css/style.css" rel="stylesheet" type="text/css">-->
        <style type="text/css" title="currentStyle">
                @import "css/tab.css";
                @import "css/demo_table.css";
                @import "css/jquery-ui-1.7.2.custom.css";
                @import "css/jquery.treeTable.css";
        </style>

        <script type="text/javascript" src="js/jquery-1.4.2.js"></script>
        <script type="text/javascript" src="js/ui.core.js"></script>
        <script type="text/javascript" src="js/ui.datepicker.js"></script>
        <script type="text/javascript" src="js/ui.dialog.js"></script>
        
        <!--
        <script type="text/javascript" src="js/ProgressBar.js"></script>
        <script type="text/javascript" src="js/listing.6.2.js"></script>
        <script type="text/javascript" src="js/jquery.dataTables.js"></script>
        <script type="text/javascript" src="js/jquery.treeTable.js"></script>
        <script type="text/javascript" src="js/jquery.numeric.js"></script>
        -->

        <script type="text/javascript">
            $(document).ready(function() {
                hideLoader();
                $("#dialogImportNew").hide();
                $("#dialogImportView").hide();
                //$("input.numeric").numeric();
                //$("#example").treeTable();
                $("#txt_date_current").datepicker({ dateFormat: 'dd-mm-yy' });
                $("#btn_search").click(showSearch);
                $("#txt_date_current").change(showSearch);
                showSearch();
                $("#tab1").css("background-image","url('../images/tabright_click.gif')");
                $("#tab11").html("<font color='red'><b>"+$("#tab11").html()+"</b></font>");
                //$("#tabs").tabs();
            });
            function showSearch() {
            $("#tr_view").load("medical_cert_company_f_view.jsp",
                {date_current: $("#txt_date_current").val(), branch_id: $("#cbo_branch").val(), flagpage: 'view_old'},
                function() {hideLoader();})
            }
            function showLoader() {
                $("#loading").show();
            }
            function hideLoader() {
                $("#loading").hide();
            }
        </script>
    </head>
    <body>
        <form name="medical_cert_company_view" id="medical_cert_company_view" method="post">
            <%@include  file="medical_cert_company_header.jsp" %>
            <table><tr><td >
                        <fieldset class="style14r">
                            <legend>เงื่อนไข:</legend>
                            <label>&nbsp;&nbsp;สาขา :&nbsp;<select name="cbo_branch" id="cbo_branch">
                                <%out.print(cbo_branch); %>
                </select></label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <label>วันที่ :<input type="text" size="10" name="txt_date_current" id="txt_date_current" value="<% out.print(date_current);%>" readonly="readonly" /></label>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input type="button" name="btn_seacrh" id="btn_search" value=" ค้นหา...      " />

<label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <A HREF="#" onClick="changesubmitprint();" NAME="anchor" ID="anchor"> พิมพ์ข้อมูล&nbsp;<img src="images/printer-a.png" alt="" width="16" align="middle"
      height="16" border="0"></A></label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        </fieldset>
                </td></tr></table>
                <div id="loading"><img src="images/ajax-loader1.gif" name="loader" id="loader"></div>
                <div id="tr_view"></div>
        </form>
    </body>
</html>
