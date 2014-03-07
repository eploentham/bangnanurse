<%-- 
    Document   : nurse_fo_add
    Created on : Feb 2, 2012, 9:01:02 PM
    Author     : root
--%>

<%@page import="bangnanurse.control.NurseControl"%>
<%@page import="bangnanurse.object.NurseTFoodsOrderDetail"%>
<%@page import="bangnanurse.object.NurseTFoodsOrder"%>
<%@page import="bangnaLibrary.BBranch"%>
<%@page import="bangnaLibrary.ComboDB"%>
<%@page import="bangnaLibrary.Config1"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
String cbo_branch="", branchId="",cbo_ward="",flagpage="",text="",foodsOrderId="",cbo_foods_period="",foods_order_detail_id="";
String text2="",dateCurrent="",cbo_patient_hn_no="",cbo_type_foods_order="";
BBranch branch = new BBranch();
Config1 config1 = new Config1();
ComboDB combodb = new ComboDB(config1);
NurseTFoodsOrder fO = new NurseTFoodsOrder();
NurseTFoodsOrderDetail fOD = new NurseTFoodsOrderDetail();
NurseControl NC = new NurseControl(config1);
try {
    //date_foods_order = config1.getDate("ddMMyyyy");
    if(request.getParameter("flagpage")!=null) {
        flagpage = new String (request.getParameter("flagpage").getBytes("ISO8859_1"),"TIS-620");
    }
    if(request.getParameter("branchId")!=null) {
        branchId = new String (request.getParameter("branchId").getBytes("ISO8859_1"),"TIS-620");
    }
    if(request.getParameter("foodsOrderId")!=null) {
        foodsOrderId = new String (request.getParameter("foodsOrderId").getBytes("ISO8859_1"),"TIS-620");
    }
    if(branchId.equals("")){
        branch = config1.getBranchActive();
        branchId = branch.getBranchId();
    }
    fO = NC.fOdb.getNurserFoodsOrderByPK(foodsOrderId);
    fOD = NC.fOdb.getNurserFoodsOrderDetailByPK(foods_order_detail_id);
    cbo_branch = combodb.getComboBranch(branchId);
    cbo_ward = combodb.CboWardN(branchId,fO.getWardId());//bangna1 mainhis
    cbo_foods_period = combodb.CboFoodsPeriod(branchId, fO.getFoodsPeriodId());
    cbo_type_foods_order = combodb.CboTypeFoods(branchId,fOD.getTypeFoodsId());
    if(!fO.getDateFoodsOrder().equals(""))dateCurrent = config1.DateFormatDB2Show(fO.getDateFoodsOrder(), "ddMMyyyy");
    else dateCurrent = config1.getDate("ddMMyyyy");
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
                @import "css/jquery-ui-1.7.2.custom.css";
        </style>
        <title>JSP Page</title>
        <script type="text/javascript" src="js/jquery-1.6.4.js"></script>
        <script type="text/javascript" src="js/jquery-ui-1.8.18.custom.min.js"></script>
        <script type="text/javascript" charset="UTF-8">
            $(document).ready(function() {
                hideLoader();
                $("#btn_search").click(showSearch);
                $("#txt_date_foods_order").datepicker({ dateFormat: 'dd-mm-yy' });
                $("#divTemp").hide();
                $("#devTempBed").hide();
                $("#dialogFoodsOrderVoid").hide();
                $("#cbo_ward").change(setWard);
                $("#cbo_foods_period").change(setFoodsPeriod);
                $("#clearButton").click(clearRemark);
                $("#txt_user_id_foods_order").change(setUsername);
                $("#txt_user_id_foods_receive").change(setUsernameFoodsReceive);
                $("#txt_user_id_foods_nutritionist").change(setUsernameFoodsNutritionist);
                $("#anchorSubmitHnno").click(setCboHnno);
                $("#anchorFoodOrderSave").click(saveFoodsOrderDetail);
                $("#anchorFoodOrderDetailNew").click(setFoodsOrderDetailAdd);
                $("#anchorFoodsOrderVoid").click(showDialogVoidFoodsOrder);
                $("#chk_1").click(setChk1);
                $("#chk_2").click(setChk2);
                $("#chk_3").click(setChk3);
                $("#chk_4").click(setChk4);
                $("#chk_5").click(setChk5);
                $("#chk_6").click(setChk6);
                $("#chk_7").click(setChk7);
                $("#chk_8").click(setChk8);
                $("#chk_9").click(setChk9);
                $("#chk_10").click(setChk10);
                $("#chk_11").click(setChk11);
                $("#anchorVoidDetail").click(voidFoodsOrderDetail);
                $("#anchorFoodsOrderPrint").click(changesubmitprintfoodsorder);
                $("#cbo_patient_hn_no").change(setPatientName);
                // Make visible that a row is clicked
                $("#tab2").css("background-image","url('../images/tabright_click.gif')");
                $("#tab22").html("<font color='red'><b>"+$("#tab22").html()+"</b></font>");
                hideLoader();
                showFoodsOrderDetail();
                setFoodsOrderDetailAdd();
            });
    function showLoader() {
        $("#loading").show();
    }
    function hideLoader() {
        $("#loading").hide();
    }
    function printBillingInvoice() {
        document.forms[0].action = "rpt_report_view.jsp?txt_report_name=billing_invoice";
        document.forms[0].submit();
    }
    function hideLoaderRefresh() {
        $("#loading").hide();
        window.location="back_funds_billing_view.jsp?flagpage=new&sub_system=funds";
    }
    function showCheckup(mkcu_id) {
        $("#loading").hide();
        window.location="marketing_checkup_add.jsp?flagpage=view&flag=pe&mkcu_id="+mkcu_id;
    }
function showDialogSave(){
    $("#dialogSave").dialog("destroy");
    $("#dialogSave").dialog({
        bgiframe: true,			modal: true,                        width: 400 ,                        height: 250,
        buttons: {
            Ok: function() {
                    changesubmitSaveBilling();
                    $(this).dialog('close');
            },
            Cancel: function() {
                    $(this).dialog('close');
            }
        }
    });
}
    function setFoodsDetail(){//txt_foods_order_id
        $("#divTemp").load("nurse_foods_order_f_view.jsp",
                {foods_order_id : $("#txt_foods_order_id").val(), branch_id: $("#txtBranchId").val(), 
                    flagpage: 'foods_detail'}, function() { hideLoader();});
    }
    function showSearch(){
        showLoader();
        document.forms[0].action = "marketing_checkup_view.jsp?flagpage=search";
        document.forms[0].submit();
    }
    function setWard(){
        $("#txt_ward_namet").val($("#cbo_ward").text);
    }
    function setFoodsPeriod(){
        $("#txt_foods_period").val($("#cbo_foods_period").text);
    }
    function clearRemark(){
        $("#txt_remark").val("") ;
        $("#chk_1").attr("checked", false);
        $("#chk_2").attr("checked", false);
        $("#chk_3").attr("checked", false);
        $("#chk_4").attr("checked", false);
        $("#chk_5").attr("checked", false);
        $("#chk_6").attr("checked", false);
        $("#chk_7").attr("checked", false);
        $("#chk_8").attr("checked", false);
        $("#chk_9").attr("checked", false);
        $("#chk_10").attr("checked", false);
        $("#chk_11").attr("checked", false);
    }
    function setChk1(){
        $("#txt_remark").val($("#txt_remark").val()+" "+$("#chk_1").val()) ;
    }
    function setChk2(){
        $("#txt_remark").val($("#txt_remark").val()+" "+$("#chk_2").val()) ;
    }
    function setChk3(){
        $("#txt_remark").val($("#txt_remark").val()+" "+$("#chk_3").val()) ;
    }
    function setChk4(){
        $("#txt_remark").val($("#txt_remark").val()+" "+$("#chk_4").val()) ;
    }
    function setChk5(){
        $("#txt_remark").val($("#txt_remark").val()+" "+$("#chk_5").val()) ;
    }
    function setChk6(){
        $("#txt_remark").val($("#txt_remark").val()+" "+$("#chk_6").val()) ;
    }
    function setChk7(){
        $("#txt_remark").val($("#txt_remark").val()+" "+$("#chk_7").val()) ;
    }
    function setChk8(){
        $("#txt_remark").val($("#txt_remark").val()+" "+$("#chk_8").val()) ;
    }
    function setChk9(){
        $("#txt_remark").val($("#txt_remark").val()+" "+$("#chk_9").val()) ;
    }
    function setChk10(){
        $("#txt_remark").val($("#txt_remark").val()+" "+$("#chk_10").val()) ;
    }
    function setChk11(){
        $("#txt_remark").val($("#txt_remark").val()+" "+$("#chk_11").val()) ;
    }
    function setUsername(){
        $("#divTemp").load("nurse_foods_order_f_view.jsp",
                {employee_id_order : $("#txt_user_id_foods_order").val(), branch_id: $("#txtBranchId").val(), 
                    flagpage: 'userfoodsorderhnno'}, function() { $("#txt_user_namet_foods_order").val($("#divTemp").html()); $("#divTemp").val("");});
        //alert("aaa  "+$("#divTemp").html());
    }
    function setUsernameFoodsReceive(){
        $("#divTemp").load("nurse_foods_order_f_view.jsp",
                {employee_id_order : $("#txt_user_id_foods_receive").val(), branch_id: $("#txtBranchId").val(), 
                    flagpage: 'userfoodsorderhnno'}, function() { $("#txt_user_namet_foods_receive").val($("#divTemp").html()); $("#divTemp").val("");});
    }
    function setUsernameFoodsNutritionist(){
        $("#divTemp").load("nurse_foods_order_f_view.jsp",
                {employee_id_order : $("#txt_user_id_foods_nutritionist").val(), branch_id: $("#txtBranchId").val(), 
                    flagpage: 'userfoodsorderhnno'}, function() { $("#txt_user_namet_nutritionist").val($("#divTemp").html()); $("#divTemp").val("");});
    }
    function setCboHnno(){
        $("#cbo_patient_hn_no").remove();
        $("#divHnno").load("nurse_foods_order_f_view.jsp",
                {ward_id : $("#cbo_ward").val(), branch_id : $("#txtBranchId").val(), bedId : $("#txt_bed_id").val(), roomId : $("#txt_room_id").val(),
                    flagpage: 'cbo_hn_no'}, function() { hideLoader();});
         $("#cbo_patient_hn_no").appendTo($("#divHnno").contents());
    }
    function saveFoodsOrderDetail(){
        if($("#txt_bed_id").val()==""){
            alert("ไม่ป้อนเตียง");
            return;
        }
        if($("#txt_room_id").val()==""){
            alert("ไม่ป้อนห้อง");
            return;
        }
        if($("#txt_patient_hn_no").val()==""){
            alert("ไม่ป้อน hn");
            return;
        }
        if($("#cbo_ward").val()==""){
            alert("ไม่เลือก ward");
            return;
        }
        if($("#cbo_foods_period").val()==""){
            alert("ไม่เลือก มื้ออาหาร");
            return;
        }
        if($("#txt_date_foods_order").val()==""){
            alert("ไม่เลือก วันที่สั่งอาหาร");
            return;
        }
        if($("#cbo_type_foods_order").val()==""){
            alert("ไม่เลือก ประเภทอาหาร");
            return;
        }
        $("#divFoodsDetail").load("nurse_foods_order_f_save.jsp",
                {foodsOrderId : $("#txt_foods_order_id").val(), branch_id: $("#txtBranchId").val(), 
                    wardId : $("#cbo_ward").val(), foodsPeriodId : $("#cbo_foods_period").val(), 
                    dateFoodsOrder : $("#txt_date_foods_order").val(), userIdFoodsOrder : $("#txt_user_id_foods_order").val(), 
                    userNametFoodsOrder : $("#txt_user_namet_foods_order").val(), userIdFoodsReceive : $("#txt_user_id_foods_receive").val(), 
                    userNametFoodsReceive : $("#txt_user_namet_foods_receive").val(), userIdFoodsNutritionist : $("#txt_user_id_foods_nutritionist").val(), 
                    userNametNutritionist : $("#txt_user_namet_nutritionist").val(), roomId : $("#txt_room_id").val(), 
                    bedId : $("#txt_bed_id").val(), foodsOrderDetailId : $("#txt_foods_order_detail_id").val(), 
                    paidId : $("#txt_paid_id").val(), paidNamet : $("#txt_paid_namet").val(), 
                    pageNumber : $("#txt_page_number").val(), patientHnno : $("#txt_patient_hn_no").val(), 
                    patientFullnamet : $("#txt_patient_fullnamet").val(), typeFoodsOrderId : $("#cbo_type_foods_order").val(), 
                    typeFoodsOrderName : $("#cbo_type_foods_order option:selected").text(), remark : $("#txt_remark").val(), 
                    wardName : $("#cbo_ward option:selected").text(), 
                    flagpage: 'save_foods'}, function() { hideLoader(); setFoodsOrderDetailAdd();});
        $("#trFoodsOrderDetail").appendTo($("#divFoodsDetail").contents());
    }
    function setPatientName(){
        $("#txt_patient_fullnamet").val($("#cbo_patient_hn_no option:selected").text());
        $("#txt_patient_hn_no").val($("#cbo_patient_hn_no").val());
    }
    function voidFoodsOrderDetail(){
        $("#divTemp").load("nurse_foods_order_f_view.jsp",
                {foodsOrderDetailId : $("#txt_foods_order_detail_id").val(), branch_id : $("#txtBranchId").val(),
                    flagpage: 'void_foods_order_detail'}, function() { hideLoader();});
        setFoodsOrderDetailAdd();
        showFoodsOrderDetail();
    }
    function showFoodsOrderDetail(){
        $("#divFoodsDetail").load("nurse_foods_order_f_view.jsp",
            {foodsOrderId : $("#txt_foods_order_id").val(), branch_id : $("#txtBranchId").val(),flagpage: 'foods_detail'}, function() { hideLoader();});
    }
    function showDialogVoidFoodsOrder(){
    $("#dialogFoodsOrderVoid").dialog("destroy");
    $("#dialogFoodsOrderVoid").dialog({
            bgiframe: true,			modal: true,                        width: 400 ,                        height: 250,
            buttons: {
                Ok: function() {
                    setFoodsOrderVoid();
                    $(this).dialog('close');
                },
                Cancel: function() {
                    $(this).dialog('close');
                }
            }
        });
    }
    function setFoodsOrderDetailAdd(foodsOrderDetailId){
        //divFoodsDetailAdd
        //alert("aaa");
        //$("#divFoodsDetailAdd").remove();
        $("#txt_room_id").val("");
        $("#txt_bed_id").val("");
        $("#txt_patient_hn_no").val("");
        $("#txt_patient_fullnamet").val("");
        $("#txt_remark").val("");
        $("#cbo_type_foods_order").val("")
        clearRemark();
        //$("#cbo_patient_hn_no").remove();
        $("#divFoodsDetailAdd").load("nurse_fo_add_detail.jsp",
            {foodsOrderDetailId : foodsOrderDetailId, branch_id : $("#txtBranchId").val(),flagpage: 'foods_order_detail'}, function() { hideLoader();});
        //$("#divFoodsDetailAdd").appendTo($("#divFoodsDetailAdd").contents());
    }
    function changesubmitprintfoodsorder(){
        var foods_order_id = $("#txt_foods_order_id").val();
        document.forms[0].action = "rpt_report_view.jsp?txt_report_name=nurse_foods_order&txt_form=daily&foods_order_id="+foods_order_id+"&cbo_branch="+$("#txtBranchId").val();
        document.forms[0].submit();
        return false;
    } 
    function setFoodsOrderVoid(){
        $("#divTemp").load("nurse_foods_order_f_view.jsp",
                {foodsOrderId : $("#txt_foods_order_id").val(), branch_id : $("#txtBranchId").val(),
                    flagpage: "void_foods_order"}, function() { hideLoader();});
    }
    </script>
    </head>
    <body>
        <form name="nurse_fo_add" id="nurse_fo_add" action="nurse_fo_add.jsp" method="POST">
            <%@include  file="nurse_foods_order_header.jsp" %>
            <table border="0" width="100%" align="center">
                <thead>
                    <tr>
                        <th colspan="4" ><div align="center">ป้อนรายการ</div></th>
                        <!--<th width="65%"></th>-->
                    </tr>
                </thead>
                <tbody>
    <tr>
        <th scope="row"  width="140" >เลขที่ใบสั่งอาหาร :</th>
        <td class="style14"> <input type="text" name="txt_foods_order_id" id="txt_foods_order_id" value="<% out.print(fO.getFoodsOrderId());%>" readonly="readonly" size="8" >
        <A HREF="#" onClick="changesubmitcancel();" NAME="anchorFoodsOrderVoid" ID="anchorFoodsOrderVoid">
<img src="images/trash1.gif" alt="" width="20" height="16" border="0">ยกเลิกทั้งใบ</A>
    <input type="hidden" name="txt_foods_order_active" id="txt_foods_order_active" value="<%out.print(fO.getFoodsOrderActive());%>">
        </td>
      <td class="style14">Ward : <select name="cbo_ward" id="cbo_ward" ><%out.print(cbo_ward); %></select>
        &nbsp;&nbsp;มื้อ :&nbsp;<select name="cbo_foods_period" id="cbo_foods_period" ><%out.print(cbo_foods_period); %></select>
      <input type="hidden" name="txt_ward_namet" id="txt_ward_namet"  value="<%out.print(fO.getWardNamet());%>">
      <input type="hidden" name="txt_foods_period" id="txt_foods_period" value="<%out.print(fO.getFoodsPeriodNamet());%>">
      </td>
        <td class="style14">วันที่สั่งอาหาร :
            <input type="text" name="txt_date_foods_order" id="txt_date_foods_order" value="<% out.print(dateCurrent);%>" readonly="readonly" class="dateinput" size="9"></td>
    </tr>
    <tr>
        <th scope="row"  width="140" >จน.ผู้สั่งอาหาร :</th>
      <td>
          <input type="text" name="txt_user_id_foods_order" id="txt_user_id_foods_order" value="<%out.print(fO.getUserIdFoodsOrder());%>" size="5" >
          <input type="text" name="txt_user_namet_foods_order" id="txt_user_namet_foods_order" value="<%out.print(fO.getUserNametFoodsOrder());%>" size="18">
      </td>
      <td class="style14"> จน.ผู้รับอาหาร :
    <input type="text" name="txt_user_id_foods_receive" id="txt_user_id_foods_receive" value="<%out.print(fO.getUserIdFoodsReceive());%>" size="5" >
    <input type="text" name="txt_user_namet_foods_receive" id="txt_user_namet_foods_receive" value="<%out.print(fO.getUserNametFoodsReceive());%>" size="15">
        </td>
        <td class="style14">โภชนากร :
    <input type="text" name="txt_user_id_foods_nutritionist" id="txt_user_id_foods_nutritionist" value="<%out.print(fO.getUserIdNutritionist());%>" size="5" >
      <input type="text" name="txt_user_namet_nutritionist" id="txt_user_namet_nutritionist" value="<%out.print(fO.getUserNametNutritionist());%>"></td>
    </tr>
    </tbody></table>
    <table border="0" width="100%">
            <tbody>
                <tr>
                    <td width="750" align="center" bgcolor='#FCF1F6'><label>รายการที่สั่งในแต่ละวัน</label>
                    </td>
<td  bgcolor='#FCF1F6'><label><a href="#" id="anchorFoodOrderDetailNew" name="anchorFoodOrderDetailNew" > ป้อนข้อมูลใหม่ <img src="images/new.gif" alt="" width="16" height="16" border="0"></a></label>&nbsp;
<label><A HREF="#" id="anchorFoodOrderSave" NAME="anchorFoodOrderSave" >บันทึกข้อมูล&nbsp;<img src="images/savedrafticon.gif" alt="" width="16" align="middle" height="16" border="0"></A></label>&nbsp;&nbsp;
<label><A HREF="#" id="anchorFoodsOrderPrint" NAME="anchorFoodsOrderPrint" >พิมพ์ใบสั่งอาหาร&nbsp;<img src="images/printer-a.png" alt="" width="16" align="middle" height="16" border="0"></A></label>
                    </td>
                    <td><div id="loading"><img src="images/ajax-loader1.gif" name="loader" id="loader"></div></td>
                </tr>
                <tr>
                    <td valign="top"><div id="divFoodsDetail"></div>
                    </td>
                    <td colspan="2">
                        <div id="divFoodsDetailAdd"></div>
                    </td>
                </tr>
            </tbody>
   </table>
        <div id="divTemp"></div>
        <div id="dialogFoodsOrderVoid" title="ยกเลิก รายการ">
	<p>
		<span class="ui-icon ui-icon-circle-check" style="float:left; margin:0 7px 50px 0;"></span>
		ยกเลิกรายการ
	</p>
        </div>
            <input type="hidden" name="txtBranchId" id="txtBranchId" size="6" value="<%out.print(branchId);%>">
        </form>
    </body>
</html>
