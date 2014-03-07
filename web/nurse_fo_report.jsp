<%-- 
    Document   : nurse_fo_report
    Created on : May 8, 2012, 4:30:02 PM
    Author     : root
--%>

<%@page import="bangnaLibrary.BBranch"%>
<%@page import="bangnaLibrary.ComboDB"%>
<%@page import="bangnaLibrary.Config1"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
String text="",flagpage="",branchId="",date_start="",date_end="",date_start_admin_day="",date_end_admin_day="",date_current="",cbo_branch="",cbo_ward="",ward_id="";
Config1 config1 = new Config1();
ComboDB combodb = new ComboDB(config1);
BBranch branch = new BBranch();
try {
    if(request.getParameter("flagpage")!=null) {
        flagpage = new String (request.getParameter("flagpage").getBytes("ISO8859_1"),"TIS-620");
    }
    if(request.getParameter("cbo_branch")!=null) {
        branchId = new String (request.getParameter("cbo_branch").getBytes("ISO8859_1"),"TIS-620");
    }
    if(request.getParameter("cbo_ward")!=null) {
        ward_id = request.getParameter("cbo_ward");
    }
    if(branchId.equals("")){
        branch=config1.getBranchActive();
        branchId = branch.branchId;
    }
    cbo_branch = combodb.getComboBranch(branchId);
    date_current = config1.getDate("yyyyMMdd");
    date_start = config1.DateFormatDB2Show(date_current,"ddMMyyyy");
    date_end = config1.DateFormatDB2Show(date_current,"ddMMyyyy");
    date_start_admin_day = config1.DateFormatDB2Show(date_current,"ddMMyyyy");
    date_end_admin_day = config1.DateFormatDB2Show(date_current,"ddMMyyyy");
    cbo_ward = combodb.CboWardN(branchId,ward_id);
}catch(Exception ex){
    text = ex.getMessage();
}
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <style type="text/css" title="currentStyle">
            @import "css/tab.css";
            @import "css/demo_table.css";
            @import "css/jquery-ui-1.8.18.custom.css";
        </style>
        <script type="text/javascript" src="js/jquery-1.6.4.js"></script>
        <script type="text/javascript" src="js/jquery-ui-1.8.18.custom.min.js"></script>
        <script type="text/javascript">
            $(document).ready(function() {
                hideLoader();
                $("#txt_date_start").datepicker({ dateFormat: 'dd-mm-yy' });
                $("#txt_date_end").datepicker({ dateFormat: 'dd-mm-yy' });
                $("#txt_date_start_admin_day").datepicker({ dateFormat: 'dd-mm-yy' });
                $("#txt_date_end_admin_day").datepicker({ dateFormat: 'dd-mm-yy' });
                $("#dialogShowStickerAdmit").hide();
                $("#dialogShowFOAdmin").hide();
                $("#dialogShowFOAdminDetail").hide();
                $("#txtVisitHn").keyup(autoSearch);
                $("#chkFoReportAdminDay").click(showDialogFOAdmin);
                $("#chkFoReportAdminDetail").click(showDialogFOAdminDetail);
                $("#chkStickerAdmit").click(showDialogStickerAdmit);
                $("#anchorSearchAdmit").click(searchPatientAdmit);
                $("#anchorFoReportAdminDay").click(changesubmitFoReportAdminDay);
                $("#anchorFoReportAdminDetail").click(changesubmitFoReportAdminDetail);
                $("#anchorStickerAdmit").click(changesubmitFoReportStickerAdmit);
                $("#tab3").css("background-image","url('../images/tabright_click.gif')");
                $("#tab33").html("<font color='red'><b>"+$("#tab33").html()+"</b></font>");
            });
    function showSearch() {
        //$("#tr_view").load("medical_cert_company_f_view.jsp",
        //{date_current: $("#txt_date_current").val(), branch_id: $("#cbo_branch").val(), flagpage: 'view_old'},
        //function() {hideLoader();});
        document.forms[0].action = "nurse_foods_order_view.jsp?flagpage=old_date&dateStart"+$("#txt_date_start").val()
            +"&dateEnd="+$("#txt_date_end").val()+"&cbo_ward="+$("#cbo_ward").val();
        document.forms[0].submit();
    }
    function showLoader() {
        $("#loading").show();
    }
    function hideLoader() {
        $("#loading").hide();
    }
    function showDialogStickerAdmit(){
        $("#dialogShowStickerAdmit").show();
        $("#dialogShowFOAdminDetail").hide();
        $("#dialogShowFOAdmin").hide();
    }
    function showDialogFOAdminDetail(){
        $("#dialogShowFOAdminDetail").show();
        $("#dialogShowStickerAdmit").hide();
        $("#dialogShowFOAdmin").hide();
    }
    function showDialogFOAdmin(){
        $("#dialogShowFOAdmin").show();
        $("#dialogShowStickerAdmit").hide();
        $("#dialogShowFOAdminDetail").hide();
    }
    function autoSearch(){
        $("#divTemp").load("nurse_foods_order_f_view.jsp",
            {searchHn : $("#txtVisitHn").val(), branchId : $("#cbo_branch").val(), flagpage : "auto_search_hn"},function() {
                $("#divTemp").hide();
                hideLoader();
                var str_month = $("#divTemp").html();
                var source = str_month.split("@");
                $("#txtVisitHn").autocomplete({source : source});
            });
    }
    function searchPatientAdmit(){
        $("#txtVisitHn").val("");
        $("#divTemp").show();
        showLoader();
        $("#divTemp").load("nurse_foods_order_f_view.jsp",
            {doctorSearch : $("#txtVisitHn").val(), branch_id : $("#cbo_branch").val(), flagpage : "search_admit"},function() {hideLoader();});
    }
function changesubmitFoReportAdminDay(){
    document.forms[0].action = "rpt_report_view.jsp?txt_report_name=nurse_foods_order_admin&txt_form=daily&date_start_admin_day="
        +$("#txt_date_start_admin_day").val()+"&date_end_admin_day="+$("#txt_date_end_admin_day").val();
    document.forms[0].submit();
    return false;
}
function chkEnable(row){
    //alert("mkBpId "+row+$("#txtRowCnt").val());
    //alert("aa"+$("#txtmkBpName"+row).val());
    if($("#txtVisitPrint"+row).val()=="0"){
        //alert("aaaa "+row);
        $("#txtVisitPrint"+row).val("1");
    }else if($("#txtVisitPrint"+row).val()=="1"){
        //alert("bbbb "+row);
        $("#txtVisitPrint"+row).val("0");
    }
}
function changesubmitFoReportStickerAdmit(){
    var visitHn="";
    var cnt = $("#txtRowCnt").val();
    if($("#txtVisitHn").val()!=""){
        visitHn = $("#txtVisitHn").val();
    }else{
        for(var i=0;i<cnt;i++){
            var chk = $("#txtVisitPrint"+i).val();
            //alert("ccc "+chk);
            if(chk=="1") {
                //alert("ddd "+chk);
                visitHn+=$("#txtVisitVnPrint"+i).val()+"@";
            }
        }
    }
    
    document.forms[0].action = "rpt_report_view.jsp?txt_report_name=print_sticker_admit&txt_form=daily&visitHn="+visitHn;
    document.forms[0].submit();
    return false;
}
function changesubmitFoReportAdminDetail(){
    document.forms[0].action = "rpt_report_view.jsp?txt_report_name=nurse_foods_order_admin_detail&txt_form=daily&date_start="
        +$("#txt_date_start").val()+"&date_end="+$("#txt_date_end").val()+"&ward_id="+$("#cbo_ward").val();
    document.forms[0].submit();
    return false;
}
    </script>
    </head>
    <body>
        <form name="nurse_fo_report" id="nurse_fo_report" action="nurse_fo_report.jsp" method="POST">
            <%@include  file="nurse_foods_order_header.jsp" %>
            <table><tr align="center"><td align="center"><table width="400" align="left">
      <thead><th colspan="2" scope="col"><div align="center">เลือกรายการ</div></th></thead>
            <tr><td align="left"><label><input type="radio" id="chkFoReportAdminDetail" name="chkReport">&nbsp;1. รายงานแสดงรายการสั่งอาหาร แต่ละวัน</label>
            <div id="dialogShowFOAdminDetail">
            <table>
                    <tr><td colspan="4"><label>Ward :&nbsp;<select name="cbo_ward" id="cbo_ward"><%out.print(cbo_ward); %></select></label></td></tr>
                    <tr><td>วันที่ :</td><td><input type="text" name="txt_date_start" id="txt_date_start" value="<% out.print(date_start);%>" readonly="readonly" class="dateinput" size="8"></td>
                    <td>ถึงวันที่ :&nbsp;<input type="text" name="txt_date_end" id="txt_date_end" value="<% out.print(date_end);%>" readonly="readonly" class="dateinput" size="8"></td>
                    <td><label><A HREF="#" id="anchorFoReportAdminDetail" NAME="anchorFoReportAdminDetail" ><img src="images/printer-a.png" alt="" width="16" align="middle" height="16" border="0"></A></label>
                    </td></tr>                    
            </table></div>
            </td></tr>
            <tr><td align="left"><label><input type="radio" id="chkFoReportAdminDay" name="chkReport">&nbsp;2. รายงานสรุปค่าอาหารจากพยาบาลตามประเภทอาหาร แต่ละวัน</label>
            <div id="dialogShowFOAdmin">
            <table>
                    <tr><td colspan="4"><label>สาขา :&nbsp;<select name="cbo_branch" id="cbo_branch"><%out.print(cbo_branch); %></select></label></td></tr>
                    <tr><td>วันที่ :</td><td><input type="text" name="txt_date_start_admin_day" id="txt_date_start_admin_day" value="<% out.print(date_start_admin_day);%>" readonly="readonly" class="dateinput" size="8"></td>
                    <td>ถึงวันที่ :&nbsp;<input type="text" name="txt_date_end_admin_day" id="txt_date_end_admin_day" value="<% out.print(date_end_admin_day);%>" readonly="readonly" class="dateinput" size="8"></td>
                    <td><label><A HREF="#" id="anchorFoReportAdminDay" NAME="anchorFoReportAdminDay" >พิมพ์&nbsp;<img src="images/printer-a.png" alt="" width="16" align="middle" height="16" border="0"></A></label>
                    </td></tr>
            </table></div>
            </td></tr>
                <tr><td align="left">
                    <label><input type="radio" id="chkStickerAdmit" name="chkReport">&nbsp;3. พิมพ์ Sticker คนไข้admit</label>
            <div id="dialogShowStickerAdmit">
                <table >
    <tr><td>HN</td><td><input type="text" name="txtVisitHn" id="txtVisitHn" value="" size="30"><img src="images/search1.jpeg" alt="" border="0"></td></tr>
        <tr><td colspan="2"><label><A HREF="#" id="anchorSearchAdmit" NAME="anchorSearchAdmit" >ดึงข้อมูลที่ admit ทั้งหมด&nbsp;</A></label></td></tr>
        <tr><td colspan="2"><label><A HREF="#" id="anchorStickerAdmit" NAME="anchorStickerAdmit" >พิมพ์&nbsp;<img src="images/printer-a.png" alt="" width="16" align="middle" height="16" border="0"></A></label>
        </td></tr>
                </table>
            </div>
                    </td></tr></table>
                    </td></tr>
                <tr><td><div id="loading"><img src="images/ajax-loader1.gif" name="loader" id="loader"></div>
                        <div id="divTemp"></div></td></tr></table>
        <input type="hidden" id="txt_report_name" name="txt_report_name" value="">
        <input type="hidden" id="txt_form" name="txt_form" value="daily">
        </form>
    </body>
</html>
