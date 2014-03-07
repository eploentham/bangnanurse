<%-- 
    Document   : medical_cert_company_add
    Created on : Dec 27, 2009, 11:50:47 PM
    Author     : root
    update By Ekapop Ticket Id :
    m1 เพิ่ม latent ให้เลือกออกเอง
    update By Ekapop Ticket Id : 5500231
    m2  
    update By Ekapop Ticket Id :
    m3 เพิ่ม Log
       เอารูปออก 
--%>
<%@page import="bangnanurse.control.MedicalCertControl"%>
<%@page import="bangnanurse.objdb.OpdTMedicalCertCompanyDB"%>
<%@page import="bangnanurse.object.OpdTMedicalCertCompany"%>
<%@page import ="java.sql.*" %>
<%@page import ="java.text.*" %>
<%@page import ="java.util.* " %>
<%@page import ="bangnaLibrary.*" %>
<%@page contentType="text/html" pageEncoding="TIS-620"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%
String cbo_branch="", branch_id="", text="", patient_hn="", patient_fullnamet="",date_current="",medical_cert_company_id="",date_currentdb="";
String cbo_doctor="", comment1="",doctor_id="", cbo_visit="",txt="",visit_id="";
Config1 config1 = new Config1();
BBranch branch = new BBranch();
ComboDB combodb = new ComboDB(config1);
//OpdTMedicalCertCompanyDetail medical_cert_company_detail = new OpdTMedicalCertCompanyDetail();
OpdTMedicalCertCompany medical_cert_company = new OpdTMedicalCertCompany();
//OpdBMedicalCertCompanyResult medical_cert_company_result = new OpdBMedicalCertCompanyResult();
//OpdBMedicalCertCompanyOrder medical_cert_company_order = new OpdBMedicalCertCompanyOrder();
MedicalCertControl theMCC = new MedicalCertControl(config1);
//Patient patient = new Patient();
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
    if(request.getParameter("txt_comment1")!=null) {
        comment1 = new String (request.getParameter("txt_comment1").getBytes("ISO8859_1"),"TIS-620");
    }
    if(request.getParameter("cbo_doctor")!=null) {
        doctor_id = new String (request.getParameter("cbo_doctor").getBytes("ISO8859_1"),"TIS-620");
    }
    if(request.getParameter("txt_date_current")!=null) {
        date_current = new String (request.getParameter("txt_date_current").getBytes("ISO8859_1"),"TIS-620");
    }
    if(request.getParameter("medical_cert_company_id")!=null) {
        medical_cert_company_id = new String (request.getParameter("medical_cert_company_id").getBytes("ISO8859_1"),"TIS-620");
    }
    if(request.getParameter("cbo_visit")!=null) {
        visit_id = new String (request.getParameter("cbo_visit").getBytes("ISO8859_1"),"TIS-620");
    }

    if(branch_id.equals("")) {
        branch = config1.getBranchActive();
        branch_id = branch.getBranchId();
    }
    date_current = config1.getDate("ddMMyyyy");
    date_currentdb = config1.DateFormatShow2DBHospital(date_current, "ddMMyyyy");
    
    if(!patient_hn.equals("")) {
        patient_fullnamet = config1.getPatientFullNamet(branch_id, patient_hn);
    }
    if(medical_cert_company_id.equals("")) {// new ข้อมูลใหม่
        cbo_visit = combodb.CboPatientVisitShowVN(branch_id, date_currentdb, "", patient_hn, visit_id);
        medical_cert_company.setPatientFullnamet(patient_fullnamet);
        medical_cert_company.setVisitHn(patient_hn);
        medical_cert_company.setMedicalCertCompanyDate(date_currentdb);
        medical_cert_company.setTVisitId(visit_id);
        text = theMCC.getTrMedicalCertCompanyOrder(branch_id, "thai", medical_cert_company, "new");
        theMCC.blc.saveLog("bangnanurse.medical_cert_company_add", "", "", "", config1.getDateDBHospital("yyyyMMdd hh:mm:ss"), request.getRemoteAddr(), "", "patient_hn="+patient_hn+",visit_id="+visit_id+"status=new");
    }else{// old ข้อมูลเก่า
        medical_cert_company = theMCC.getOpdTMedicalCertCompanyByPK( branch_id, medical_cert_company_id);
        text = theMCC.getTrMedicalCertCompanyOrder(branch_id, "thai", medical_cert_company,"old_data");
        cbo_visit="<option value='"+medical_cert_company.getTVisitId()+"' selected>"+medical_cert_company.getVisitVn()+"</option>";
        theMCC.blc.saveLog("bangnanurse.medical_cert_company_add", "", "", "", config1.getDateDBHospital("yyyyMMdd hh:mm:ss"), request.getRemoteAddr(), "", "patient_hn="+patient_hn+",visit_id="+visit_id+"status=old_data");
    }
    cbo_doctor = config1.getComboDoctorFullNametFront(branch_id, medical_cert_company.getDoctorId());
    //medical_cert_company = medical_cert_companydb.getOpdTMedicalCertCompanyByPK(branch_id, "", medical_cert_company_id, "");
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
                @import "css/jquery.autocomplete.css";
        </style>

        <script type="text/javascript" src="js/jquery-1.4.2.js"></script>
        <script type="text/javascript" src="js/ui.core.js"></script>
        <script type="text/javascript" src="js/ui.datepicker.js"></script>
        <script type="text/javascript" src="js/ui.dialog.js"></script>
        
        <!--
        <script type="text/javascript" src="js/jquery.dataTables.js"></script>
        <script type='text/javascript' src='js/jquery.autocomplete.js'></script>
        <script type="text/javascript" src="js/ProgressBar.js"></script>
        <script type="text/javascript" src="js/listing.6.2.js"></script>
        <script type="text/javascript" src="js/jquery.treeTable.js"></script>
        <script type="text/javascript" src="js/jquery.numeric.js"></script>
        -->            
        <script type="text/javascript">
            $(document).ready(function(){
                hideLoader();
                $("#dialogImportNew").hide();
                $("#dialogImportView").hide();
                //$("input.numeric").numeric();
                //$("#example").treeTable();

                $("#btn_search").click(showSearch);
                //$("#btn_cert_vital_sign").click(searchVitalSign);
                $("#anchor_save").click(saveMedicalCertCompany);
                $("#anchor_cancel").click(changesubmitcancel);
                $("#txt_patient_hn").click(showSearchHN);
                $("#txtDoctorId").change(searchDoctor);
                $("#tab2").css("background-image","url('../images/tabright_click.gif')");
                $("#tab22").html("<font color='red'><b>"+$("#tab22").html()+"</b></font>");
                if($("#txtLatent").val()!="") $("select[name=cboLatent]" + " option[text=" + $("#txtLatent").val() + "]").attr("selected","selected");
                //$("select[name=cboLatent]" + " option[value=" + value + "]").attr("selected","selected");
                //$("#txt_date_start").datepicker({ dateFormat: 'dd-mm-yy' });
                //showSearch();
                //$("#tabs").tabs();
            });
            function searchVitalSign(row){//txt_cert_result_14
                var visit_id="";
                visit_id = $("#cbo_visit").val();
                $("#txt_cert_result_"+row).load("medical_cert_company_f_vital_sign.jsp", {
                    branch_id: $("#cbo_branch").val(), visit_id: $("#cbo_visit").val()
                }, function() {hideLoader();});

            }
            function showSearch() { 
                document.forms[0].action = "medical_cert_company_add.jsp";
                document.forms[0].submit();
            }
            function saveMedicalCertCompany(){
                showLoader();
                $("#txt_visit_vn").val($('#cbo_visit :selected').text());
                document.forms[0].action = "medical_cert_company_save.jsp?statusLatent="+$("#cboLatent option:selected").text();
                document.forms[0].submit();
                hideLoader();
            }
            function changesubmitcancel(){
                var medical_cert_company_id = $("#txt_medical_cert_company_id").val();
                var patient_fullnamet = $("#txt_patient_fullnamet").val();
                var r=confirm("ต้องการยกเลิกรายการนี้ "+medical_cert_company_id+"\n ชื่อ-นามสกุล : "+patient_fullnamet);
                if(r==true){
                    document.forms[0].action = "medical_cert_company_cancel.jsp?medical_cert_company_id="+medical_cert_company_id;
                    document.forms[0].submit();
                }
            }
            function chkrow(row){
                var row1 = "chk_cert_"+row;
                if($("#txt_cert_result_"+row).val()!=""){
                    //alert("row");
                    $("#chk_cert_"+row).attr("checked","checked");
                }else{
                    //alert("eeeeeeeeee");
                    $("#chk_cert_"+row).removeAttr("checked");
                }
            }
            function searchDoctor(){
                var doctorId = $("#txtDoctorId").val();
                if(doctorId.length>=4){
                    //alert("aaaa "+doctorId);
                    //$("#cbo_doctor").find(doctorId).focus();
                    select_by_value("select[name=cbo_doctor]", doctorId);
                }
            }
            function select_by_value(path, value){
                    $(path + " option[value=" + value + "]").attr("selected","selected");
            }
            function changesubmitprint(flag){
                if($("#cboLatent").val()==""){//m1+
                    alert("aaaaa");//m1+
                    return;//m1+
                } //m1+
                //document.forms[0].action = "rpt_report_view.jsp?flagpage=thai&latent="+flag;//m1-
                document.forms[0].action = "rpt_report_view.jsp?flagpage=thai&latent="+$("#cboLatent option:selected").text();//m1+
                document.forms[0].submit();
            }
            function changesubmitprintenglish(){
                document.forms[0].action = "rpt_report_view.jsp?flagpage=english";
                document.forms[0].submit();
            }
            function showLoader() {
                $("#loading").show();
            }
            function hideLoader() {
                $("#loading").hide();
            }
            function showSearchHN(){
                var patient_hn = $("#txt_patient_hn").val();
                if(patient_hn.length>=4){
                    
                }
            }
        </script>
    </head>
    <body>
        <form name="medical_cert_company_add" id="medical_cert_company_add" method="post">
        <%@include  file="medical_cert_company_header.jsp" %>
        <table><tr><td colspan="6">
                        <fieldset class="style14r">
        <legend>ค้นหา :</legend>
        <label>วันที่ :<input type="text" size="8" name="txt_date_current" id="txt_date_current" value="<% out.print(date_current);%>" readonly="readonly" /></label>
        <label>&nbsp;&nbsp;HN :&nbsp;<input type="text" size="10" name="txt_patient_hn" id="txt_patient_hn" value="<% out.print(medical_cert_company.getVisitHn());%>" ></label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <label>ชื่อ-นามสกุล :<input type="text" size="30" name="txt_patient_fullnamet" id="txt_patient_fullnamet" value="<% out.print(medical_cert_company.getPatientFullnamet());%>" ></label>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input type="button" name="btn_seacrh" id="btn_search" value=" ค้นหา...      " />
<label>&nbsp;&nbsp;VN :&nbsp;<select name="cbo_visit" id="cbo_visit">
                                <%out.print(cbo_visit); %>
                </select></label>
<br>
<label><A HREF="#" NAME="anchor_save" ID="anchor_save">
         บันทึกข้อมูล &nbsp;<img src="images/savedrafticon.gif" alt="" width="16" align="middle" height="16" border="0"></A></label>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<A HREF="#" NAME="anchor_cancel" ID="anchor_cancel">
                ยกเลิกรายการนี้&nbsp;<img src="images/trash1.gif" alt="" width="16" align="middle"
      height="16" border="0"></A>
<label>&nbsp;&nbsp;กามโรค :&nbsp;<select name="cboLatent" id="cboLatent"><!-- m1+ -->
        <option value="001">6. ซิฟิลิสในระยะที่ 2 (Syphilis Secondary)</option><option value="002">6. ซิฟิลิสในระยะที่ 3 (Syphilis Latent)</option>
                </select></label>
<label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <A HREF="#" onClick="changesubmitprint('');" NAME="anchor" ID="anchor"> พิมพ์ข้อมูล&nbsp;<img src="images/printer-a.png" alt="" width="16" align="middle"
      height="16" border="0"></A></label>
<label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <A HREF="#" onClick="changesubmitprint('latent');" NAME="anchor" ID="anchor"> พิมพ์ข้อมูล ต่างด้าว&nbsp;<img src="images/printer-a.png" alt="" width="16" align="middle"
      height="16" border="0"></A></label>
<label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <A HREF="#" onClick="changesubmitprintenglish();" NAME="anchor_english" ID="anchor_english"> Print Medical&nbsp;<img src="images/printer-a.png" alt="" width="16" align="middle"
      height="16" border="0"></A></label>
                        </fieldset>
                </td></tr>
            <tr><td>&nbsp;&nbsp รหัสแพทย์ :&nbsp;<input type="text" id="txtDoctorId" name="txtDoctorId" value="<% out.print(medical_cert_company.getDoctorId());%>" size="5">&nbsp;<label><select name="cbo_doctor" id="cbo_doctor">
                                <%out.print(cbo_doctor); %>
                </select></label>
                <label>หมายเหตุ :<!--<input type="text" size="40" name="txt_comment1" id="txt_comment1" value="<% //out.print(medical_cert_company.getComment1());%>" >-->
                <textarea name="txt_comment1" id="txt_comment1" rows="3" cols="50" ><%out.print(medical_cert_company.getComment1());%></textarea></label></td></tr> </table>
        <div id="loading"><img src="images/ajax-loader1.gif" name="loader" id="loader"></div>
        <br>
        <table>
            <% out.print(text); %>
        </table>
        <input type="hidden" name="txt_medical_cert_company_id" id ="txt_medical_cert_company_id" value="<% out.print(medical_cert_company.getMedicalCertCompanyId()); %>" >
        <input type="hidden" name="txt_report_name" id ="txt_report_name" value="<% out.print("medical_cert"); %>" >
        <input type="hidden" name="txt_visit_vn" id ="txt_visit_vn" value="<% out.print(medical_cert_company.getVisitVn()); %>" >
        <input type="hidden" name="txt_form" id ="txt_report_name" value="<% out.print("daily"); %>" >
        <input type="hidden" name="cbo_branch" id ="cbo_branch" value="<% out.print(branch_id); %>" >
        <input type="hidden" name="txtLatent" id ="txtLatent" value="<% out.print(medical_cert_company.statusLatent); %>" >
        </form>
        
    </body>
</html>
