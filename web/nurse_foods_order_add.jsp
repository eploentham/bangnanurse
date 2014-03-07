<%-- 
    Document   : nurse_foods_foods_add
    Created on : 8 ส.ค. 2552, 12:06:00
    Author     : pop
--%>

<%@page import="bangnanurse.object.NurseTFoodsOrderDetail"%>
<%@page import="bangnanurse.object.NurseTFoodsOrder"%>
<%@page import="bangnanurse.objdb.NurseTFoodsOrderDB"%>
<%@page import="com.bangna.objdb.BDepartmentDB"%>
<%@page import ="java.sql.*" %>
<%@page import ="java.text.*" %>
<%@page import ="java.util.* " %>
<%@page import ="bangnaLibrary.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%
Config1 config1 = new Config1();
ComboDB combodb = new ComboDB(config1);
NurseTFoodsOrderDB foodsorderdb = new NurseTFoodsOrderDB(config1);
NurseTFoodsOrder foodsorder = new NurseTFoodsOrder();
NurseTFoodsOrderDetail foodsorderdetail = new NurseTFoodsOrderDetail();
bangnaLibrary.BBranch branch = new bangnaLibrary.BBranch();
//BDepartmentDB b_departmentdb = new BDepartmentDB(config1);
Vector v_foodsorder = new Vector();
String text="", cbo_ward="",cbo_branch="",date_foods_order="", date_end="";
String row_color="", txt_color="",txt_color1="", branch_id="", ward_id="";
String cbo_user_foods_order="", cbo_user_foods_receive="", cbo_user_nutritionist="";
String cbo_employee_order="",employee_id_order="",cbo_employee_receive="",employee_id_receive="";
String cbo_employee_nutritionist="",employee_id_nutritionist="13459", cbo_foods_order_detail="";
String cbo_type_foods_order="", type_foods_order_id="", bed_id="", patient_hn_no="",room_id="";
String remark="", patient_fullnamet="",foods_order_id="", foods_order_detail_id="", flag="";
String type_foods_order_namet="",cbo_patient_hn_no="", cbo_foods_period="", foods_period_id="";
String ward_namet="",employee_namet_order="",employee_namet_receive="",employee_namet_nutritionist="";
String paid_id="", paid_namet="", text2="";
try {
    //date_foods_order = config1.getDate("ddMMyyyy");
    if(request.getParameter("flag")!=null) {
        flag = new String (request.getParameter("flag").getBytes("ISO8859_1"),"TIS-620");
    }
    if(request.getParameter("txt_foods_order_id")!=null) {
        foods_order_id = new String (request.getParameter("txt_foods_order_id").getBytes("ISO8859_1"),"TIS-620");
    }
    if(request.getParameter("txt_foods_order_detail_id")!=null) {
        foods_order_detail_id = new String (request.getParameter("txt_foods_order_detail_id").getBytes("ISO8859_1"),"TIS-620");
    }
    if(request.getParameter("cbo_branch")!=null) {
        branch_id = new String (request.getParameter("cbo_branch").getBytes("ISO8859_1"),"TIS-620");
    }
    if(request.getParameter("cbo_ward")!=null) {
        ward_id = new String (request.getParameter("cbo_ward").getBytes("ISO8859_1"),"TIS-620");
    }
    if(request.getParameter("txt_ward_namet")!=null) {
        ward_namet = new String (request.getParameter("txt_ward_namet").getBytes("ISO8859_1"),"TIS-620");
    }
    if(request.getParameter("txt_user_id_foods_order")!=null) {
        employee_id_order = new String (request.getParameter("txt_user_id_foods_order").getBytes("ISO8859_1"),"TIS-620");
    }
    if(request.getParameter("txt_user_namet_foods_order")!=null) {
        employee_namet_order = new String (request.getParameter("txt_user_namet_foods_order").getBytes("ISO8859_1"),"TIS-620");
    }
    if(request.getParameter("txt_user_id_foods_receive")!=null) {
        employee_id_receive = new String (request.getParameter("txt_user_id_foods_receive").getBytes("ISO8859_1"),"TIS-620");
    }
    if(request.getParameter("txt_user_namet_foods_receive")!=null) {
        employee_namet_receive = new String (request.getParameter("txt_user_namet_foods_receive").getBytes("ISO8859_1"),"TIS-620");
    }
    if(request.getParameter("txt_user_id_foods_nutritionist")!=null) {
        employee_id_nutritionist = new String (request.getParameter("txt_user_id_foods_nutritionist").getBytes("ISO8859_1"),"TIS-620");
    }
    if(request.getParameter("txt_user_namet_nutritionist")!=null) {
        employee_namet_nutritionist = new String (request.getParameter("txt_user_namet_nutritionist").getBytes("ISO8859_1"),"TIS-620");
    }
    if(request.getParameter("cbo_type_foods_order")!=null) {
        type_foods_order_id = new String (request.getParameter("cbo_type_foods_order").getBytes("ISO8859_1"),"TIS-620");
    }
    if(request.getParameter("txt_type_foods_order")!=null) {
        type_foods_order_namet = new String (request.getParameter("txt_type_foods_order").getBytes("ISO8859_1"),"TIS-620");
    }
    if(request.getParameter("txt_bed_id")!=null) {
        bed_id = new String (request.getParameter("txt_bed_id").getBytes("ISO8859_1"),"TIS-620");
    }
    if(request.getParameter("txt_patient_hn_no")!=null) {
        patient_hn_no = new String (request.getParameter("txt_patient_hn_no").getBytes("ISO8859_1"),"TIS-620");
    }
    if(request.getParameter("txt_room_id")!=null) {
        room_id = new String (request.getParameter("txt_room_id").getBytes("ISO8859_1"),"TIS-620");
    }
    if(request.getParameter("txt_patient_fullnamet")!=null) {
        patient_fullnamet = new String (request.getParameter("txt_patient_fullnamet").getBytes("ISO8859_1"),"TIS-620");
    }
    if(request.getParameter("txt_date_foods_order")!=null) {
        date_foods_order = new String (request.getParameter("txt_date_foods_order").getBytes("ISO8859_1"),"TIS-620");
    }
    if(date_foods_order.equals("")){
        date_foods_order = config1.getDate("ddMMyyyy");
    }
    if(request.getParameter("txt_remark")!=null) {
        remark = new String (request.getParameter("txt_remark").getBytes("ISO8859_1"),"TIS-620");
    }
    if(request.getParameter("cbo_type_foods_order")!=null) {
        type_foods_order_id = new String (request.getParameter("cbo_type_foods_order").getBytes("ISO8859_1"),"TIS-620");
    }
    if(request.getParameter("cbo_foods_period")!=null) {
        foods_period_id = new String (request.getParameter("cbo_foods_period").getBytes("ISO8859_1"),"TIS-620");
    }
    if(request.getParameter("txt_paid_id")!=null) {
        paid_id = new String (request.getParameter("txt_paid_id").getBytes("ISO8859_1"),"TIS-620");
    }
    if(request.getParameter("txt_paid_namet")!=null) {
        paid_namet = new String (request.getParameter("txt_paid_namet").getBytes("ISO8859_1"),"TIS-620");
    }
    if(branch_id.equals("")){
        branch = config1.getBranchActive();
        branch_id = branch.getBranchId();
    }
    foodsorder = foodsorderdb.getNurserFoodsOrderByPK(foods_order_id);

    if(!foodsorder.getDateFoodsOrder().equals("")){
        date_foods_order=config1.DateFormatDB2Show(foodsorder.getDateFoodsOrder(),"ddMMyyyy");
    }
    if(flag.equals("search_hn_no") && !patient_hn_no.equals("")){
        patient_fullnamet = config1.getPatientFullNamet(branch_id, patient_hn_no);
        foodsorderdetail.setBedId(bed_id);
        foodsorderdetail.setRoomId(room_id);
        foodsorderdetail.setRemark(remark);
        foodsorderdetail.setPatientHnNo(patient_hn_no);
        foodsorderdetail.setPatientFullnamet(patient_fullnamet);
        foodsorderdetail.setTypeFoodsId(type_foods_order_id);
        foodsorderdetail.setTypeFoodsNamet(type_foods_order_namet);
        foodsorderdetail.setFoodsOrderId(foods_order_id);
        foodsorderdetail.setFoodsOrderDetailId(foods_order_detail_id);
    }else if(flag.equals("detail")){
        if(request.getParameter("foods_order_detail_id")!=null) {
            foods_order_detail_id = new String (request.getParameter("foods_order_detail_id").getBytes("ISO8859_1"),"TIS-620");
            }
        foodsorderdetail = foodsorderdb.getNurserFoodsOrderDetailByPK(foods_order_detail_id);
        cbo_type_foods_order = combodb.CboTypeFoods(branch_id,foodsorderdetail.getTypeFoodsId());
        cbo_foods_order_detail = foodsorderdb.getTrFoodsOrderDetail(branch_id, foods_order_id, "");
    }else if(flag.equals("hnno")) {
        //NurseFormDB nurseformdb = new NurseFormDB();
        cbo_patient_hn_no = config1.CboPatientinWard(branch_id,"","hnno", ward_id,ward_id,room_id, bed_id);
        Vector v_room = config1.SearchPaitentinWard(branch_id, "", "", "hnno", ward_id, room_id, bed_id);
        if(v_room.size()==1){
            bangnaLibrary.PatientVisit patientvisit = new bangnaLibrary.PatientVisit();
            patientvisit = (bangnaLibrary.PatientVisit) v_room.get(0);
            patient_hn_no = patientvisit.getPatientId();
            patient_fullnamet = patientvisit.getPatientNamet();
            paid_id = patientvisit.getVisitPaidId();
            paid_namet = patientvisit.getVisitPaidNamet();
            }
    }else if(flag.equals("userfoodsorderhnno")) {
        employee_namet_order = config1.getEmployeeFullNamet(branch_id, employee_id_order);
        foodsorder.setUserIdFoodsOrder(employee_id_order);
        foodsorder.setUserNametFoodsOrder(employee_namet_order);
        }
else if(flag.equals("userfoodsreceivehnno")) {
        employee_namet_receive = config1.getEmployeeFullNamet(branch_id, employee_id_receive);
        foodsorder.setUserIdFoodsReceive(employee_id_receive);
        foodsorder.setUserNametFoodsReceive(employee_namet_receive);
        }
else if(flag.equals("userfoodsnutritionisthnno")) {
        employee_namet_nutritionist = config1.getEmployeeFullNamet(branch_id, employee_id_nutritionist);
        foodsorder.setUserIdNutritionist(employee_id_nutritionist);
        foodsorder.setUserNametNutritionist(employee_namet_nutritionist);
    }
    if(foodsorder.getWardId().equals("")){
        foodsorder.setWardId(ward_id);
    }
    if(foodsorder.getDateFoodsOrder().equals("")){
        //foodsorder.setDateFoodsOrder(date);
    }
    if(foodsorder.getWardNamet().equals("")){
        foodsorder.setWardNamet(ward_namet);
    }
    if(foodsorderdetail.getRoomId().equals("")){
        foodsorderdetail.setRoomId(room_id);
    }
    if(foodsorderdetail.getFoodsOrderDetailId().equals("")){
        foodsorderdetail.setFoodsOrderDetailId(foods_order_detail_id);
    }
    if(foodsorderdetail.getBedId().equals("")){
        foodsorderdetail.setBedId(bed_id);
    }
    if(foodsorderdetail.getPatientHnNo().equals("")){
        foodsorderdetail.setPatientHnNo(patient_hn_no);
    }
    if(foodsorderdetail.getPatientFullnamet().equals("")){
        foodsorderdetail.setPatientFullnamet(patient_fullnamet);
    }
    if(foodsorderdetail.getRemark().equals("")){
        foodsorderdetail.setRemark(remark);
        }
    if(foodsorder.getUserIdFoodsOrder().equals("")){
        foodsorder.setUserIdFoodsOrder(employee_id_order);
        }
    if(foodsorder.getUserIdFoodsReceive().equals("")){
        foodsorder.setUserIdFoodsReceive(employee_id_receive);
        }
    if(foodsorder.getUserIdNutritionist().equals("")){
        foodsorder.setUserIdNutritionist(employee_id_nutritionist);
        }
    if(foodsorder.getFoodsPeriodId().equals("")){
        foodsorder.setFoodsPeriodId(foods_period_id);
        }
    if(foodsorder.getUserNametFoodsOrder().equals("")){
        foodsorder.setUserNametFoodsOrder(employee_namet_order);
        }
    if(foodsorder.getUserNametFoodsReceive().equals("")){
        foodsorder.setUserNametFoodsReceive(employee_namet_receive);
        }
    if(foodsorder.getUserNametNutritionist().equals("")){
        foodsorder.setUserNametNutritionist(employee_namet_nutritionist);
    }

    if(foodsorderdetail.getPaidId().equals("")){
        foodsorderdetail.setPaidId(paid_id);
    }
    if(foodsorderdetail.getPaidNamet().equals("")){
        foodsorderdetail.setPaidNamet(paid_namet);
    }
    if(foodsorder.getUserNametNutritionist().equals("")){
        foodsorder.setUserNametNutritionist(employee_namet_nutritionist);
    }
    cbo_branch = combodb.getComboBranch(branch_id);
    cbo_ward = combodb.CboWard(branch_id,foodsorder.getWardId());//bangna1 mainhis
    //cbo_ward = b_departmentdb.CboDepartment(branch_id,ward_id);
    //cbo_employee_order = config1.CboEmployee(branch_id,foodsorder.getUserIdFoodsOrder());
    //cbo_employee_receive = config1.CboEmployee(branch_id,foodsorder.getUserIdFoodsReceive());
    cbo_employee_nutritionist = combodb.CboEmployee(branch_id,foodsorder.getUserIdNutritionist());
    cbo_type_foods_order = combodb.CboTypeFoods(branch_id,foodsorderdetail.getTypeFoodsId());
    cbo_foods_order_detail = foodsorderdb.getTrFoodsOrderDetail(branch_id, foods_order_id, "");
    cbo_foods_period = combodb.CboFoodsPeriod(branch_id, foodsorder.getFoodsPeriodId());
    if(flag.equals("detailnew")){
        foodsorderdetail = new NurseTFoodsOrderDetail();
        foodsorderdetail.setFoodsOrderId(foods_order_id);
        cbo_type_foods_order = combodb.CboTypeFoods(branch_id,foodsorderdetail.getTypeFoodsId());
        cbo_foods_order_detail = foodsorderdb.getTrFoodsOrderDetail(branch_id, foods_order_id, "");
    }
    v_foodsorder = foodsorderdb.getNurserFoodsOrderDetail(branch_id, foods_order_id, "");
    if(v_foodsorder.size()>8){
        for(int i=0;i<=v_foodsorder.size()-3;i++){
            text2+="<br>";
            }
        text2="<tr><td>"+text2+"</td></tr>";
        }
    
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
                @import "css/table.css";
        </style>
        <!--<script type="text/javascript" src="js/dojo1.3.1/dojo/dojo.js" djConfig="parseOnLoad: true"></script>
        <script type="text/javascript" src="js/prototype-1.6.0.3.js"></script>
        <script type="text/javascript" src="js/ProgressBar.js"></script>
        <script type="text/javascript" src="js/listing.6.2.js"></script><!--->
        <script type="text/javascript" src="js/jquery-1.6.4.js"></script>
        <script type="text/javascript" src="js/jquery-ui-1.8.18.custom.min.js"></script>

        <script>
            $(document).ready(function(){
                $("#txt_date_foods_order").datepicker({ dateFormat: 'dd-mm-yy' });
                $("#vn").load("", "", "");
                $("#anchorFoodOrderDetailNew").click(changesubmitfoodsorderdetailnew);
                $("#anchorFoodOrderSave").click(changesubmitfoodsordersave);
                $("#anchorFoodsOrderPrint").click(changesubmitprintfoodsorder);

            });

      function changesubmitfoodsordersave() {
          //var usernametfoodsorder = document.getElementById("cbo_user_foods_order").value;
          //var usernametfoodsreceive = document.getElementById("cbo_user_foods_receive").value;
          //var usernametnutritionist = document.getElementById("cbo_user_foods_nutritionist").value;
          //var usernametfoodsorder="",usernametfoodsreceive="",usernametnutritionist="";
        document.forms[0].action = "nurse_foods_order_save.jsp?flag=foodsordersave";
        document.forms[0].submit();
        return false;
      }
      function changesubmitfoodsorderdetailshow(foods_order_detail_id) {
          var foods_order_id = document.getElementById("txt_foods_order_id").value;
          document.forms[0].action = "nurse_foods_order_add.jsp?flag=detail&foods_order_id="+foods_order_id
              +"&foods_order_detail_id="+foods_order_detail_id;
        document.forms[0].submit();
        return false;
      }
    function changesubmitfoodsorderdetailnew(){
        var foods_order_id = $("#txt_foods_order_id").val();
        document.forms[0].action = "nurse_foods_order_add.jsp?flag=detailnew&foods_order_id="+foods_order_id;
        document.forms[0].submit();
        return false;
    }
function changesubmitprintfoodsorder(){
    var foods_order_id = $("#txt_foods_order_id").val();
    document.forms[0].action = "rpt_report_view.jsp?txt_report_name=nurse_foods_order&txt_form=daily&foods_order_id="+foods_order_id;
    document.forms[0].submit();
    return false;
}
      function changesubmithnno() {
        document.forms[0].action = "nurse_foods_order_add.jsp?flag=hnno";
        document.forms[0].submit();
        return false;
      }
      function changesubmitcanceldetail() {
      document.forms.nurse_foods_order_add.txt_foods_order_detail_active.value = '3';
        document.forms[0].action = "nurse_foods_order_save.jsp?flag=foodsordersave";
        document.forms[0].submit();
        return false;
      }
      function changesubmitcancel() {
        document.forms.nurse_foods_order_add.txt_foods_order_active.value = '3';
        document.forms[0].action = "nurse_foods_order_save.jsp?flag=foodsordersave&flag_redirect=cancel";
        document.forms[0].submit();
        return false;
      }
      function changesubmithnnouserfoodsorder(){
          document.forms[0].action = "nurse_foods_order_add.jsp?flag=userfoodsorderhnno";
        document.forms[0].submit();
        return false;
      }
      function changesubmithnnouserfoodsreceive(){
        document.forms[0].action = "nurse_foods_order_add.jsp?flag=userfoodsreceivehnno";
        document.forms[0].submit();
        return false;
      }
      function changesubmithnnouserfoodsnutritionist(){
        document.forms[0].action = "nurse_foods_order_add.jsp?flag=userfoodsnutritionisthnno";
        document.forms[0].submit();
        return false;
      }
    </script>
    </head>
    <body>
        <form name="nurse_foods_order_add" id="nurse_foods_order_add" action="nurse_foods_order_add.jsp" method="POST">
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
        <td class="style14"> <input type="text" name="txt_foods_order_id" id="txt_foods_order_id" value="<% out.print(foodsorder.getFoodsOrderId());%>" readonly="readonly" size="8" >
        <A HREF="#" onClick="changesubmitcancel();" NAME="anchor" ID="anchor">
<img src="images/trash1.gif" alt="" width="20" height="16" border="0">ยกเลิกทั้งใบ</A>
    <input type="hidden" name="txt_foods_order_active" id="txt_foods_order_active" value="<%out.print(foodsorder.getFoodsOrderActive());%>">
        </td>
    
      <td class="style14">Ward : <select name="cbo_ward" id="cbo_ward" ONCHANGE = "document.forms.nurse_foods_order_add.txt_ward_namet.value = document.forms.nurse_foods_order_add.cbo_ward.options[
document.forms.nurse_foods_order_add.cbo_ward.selectedIndex ].text ;">
                    <%out.print(cbo_ward); %>
        </select>
        &nbsp;&nbsp;มื้อ :&nbsp;<select name="cbo_foods_period" id="cbo_foods_period" ONCHANGE = "document.forms.nurse_foods_order_add.txt_foods_period.value = document.forms.nurse_foods_order_add.cbo_foods_period.options[
document.forms.nurse_foods_order_add.cbo_foods_period.selectedIndex ].text ;">
                    <%out.print(cbo_foods_period); %>
        </select>
      <input type="hidden" name="txt_ward_namet" id="txt_ward_namet"  value="<%out.print(foodsorder.getWardNamet());%>">
      <input type="hidden" name="txt_foods_period" id="txt_foods_period" value="<%out.print(foodsorder.getFoodsPeriodNamet());%>">
      </td>
        <td class="style14">วันที่สั่งอาหาร :
            <input type="text" name="txt_date_foods_order" id="txt_date_foods_order" value="<% out.print(date_foods_order);%>" readonly="readonly" class="dateinput" size="9"></td>
        
    </tr>
    <tr>
        <th scope="row"  width="140" >เจ้าหน้าที่ผู้สั่งอาหาร :</th>
      <td>
          <input type="text" name="txt_user_id_foods_order" id="txt_user_id_foods_order" value="<%out.print(foodsorder.getUserIdFoodsOrder());%>" size="5" onblur="changesubmithnnouserfoodsorder();">
          <input type="text" name="txt_user_namet_foods_order" id="txt_user_namet_foods_order" value="<%out.print(foodsorder.getUserNametFoodsOrder());%>" size="18">
      </td>
      <td class="style14"> เจ้าหน้าที่ผู้รับอาหาร :
    <input type="text" name="txt_user_id_foods_receive" id="txt_user_id_foods_receive" value="<%out.print(foodsorder.getUserIdFoodsReceive());%>" size="5" onblur="changesubmithnnouserfoodsreceive();">
    <input type="text" name="txt_user_namet_foods_receive" id="txt_user_namet_foods_receive" value="<%out.print(foodsorder.getUserNametFoodsReceive());%>" size="15">
        </td>
    
        <td class="style14">โภชนากร :
    <input type="text" name="txt_user_id_foods_nutritionist" id="txt_user_id_foods_nutritionist" value="<%out.print(foodsorder.getUserIdNutritionist());%>" size="5" onblur="changesubmithnnouserfoodsnutritionist();">
      <input type="text" name="txt_user_namet_nutritionist" id="txt_user_namet_nutritionist" value="<%out.print(foodsorder.getUserNametNutritionist());%>"></td>
    </tr>
                </tbody></table>

        <table border="0" width="100%">
            <tbody>
                <tr>
                    <td width="250" align="center" bgcolor='#FCF1F6'><label>รายการที่สั่งในแต่ละวัน</label>
                    </td>
<td  bgcolor='#FCF1F6'><label><a href="#" id="anchorFoodOrderDetailNew" > ป้อนข้อมูลใหม่ <img src="images/new.gif" alt="" width="16" height="16" border="0"></a></label>&nbsp;
<label><A HREF="#" id="anchorFoodOrderSave" NAME="anchor" ID="anchor">บันทึกข้อมูล&nbsp;<img src="images/savedrafticon.gif" alt="" width="16" align="middle" height="16" border="0"></A></label>&nbsp;&nbsp;
<label><A HREF="#" id="anchorFoodsOrderPrint" NAME="anchor" ID="anchor">พิมพ์ใบสั่งอาหาร&nbsp;<img src="images/printer-a.png" alt="" width="16" align="middle" height="16" border="0"></A></label>
                    </td>
                </tr>
                <tr>
                    <td valign="top">
                        <table width="600">
                            <thead>
                            <th>ห้อง</th>
                            <th>เตียง</th>
                            <th>HN NO</th>
                            <th>ชื่อผู้ป่วย</th>
                            <th width="50">ประเภทอาหาร</th>
                            <th width="50">หมายเหตุ</th>
                            </thead>
                            <%out.print(cbo_foods_order_detail);%>
                        </table>
                    </td>
                    <td>
                        <table width="100%">
                            <thead>
                            <tr>
                                    <th width="100">ห้อง</th>
                                    <td valign="top" width="200">
                                        <input type="text" name="txt_room_id" id="txt_room_id" size="5" value="<%out.print(foodsorderdetail.getRoomId());%>">
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<A HREF="#" onClick="changesubmitcanceldetail();" NAME="anchor" ID="anchor">
<img src="images/trash1.gif" alt="" width="20" height="16" border="0">ยกเลิกรายการ</A>
    <input type="hidden" name="txt_foods_order_detail_active" id="txt_foods_order_detail_active" value="<%out.print(foodsorderdetail.getFoodsOrderDetailActice());%>">
    
                                    </td></tr><tr>
                                    <th width="100">เตียง</th>
                                    <td valign="top" width="200">
<input type="text" name="txt_bed_id" id="txt_bed_id" size="5" value="<%out.print(foodsorderdetail.getBedId());%>">
<input type="hidden" name="txt_foods_order_detail_id" id="txt_foods_order_detail_id" value="<%out.print(foodsorderdetail.getFoodsOrderDetailId());%>">
                                    </td></tr><tr>
                                    <th width="100">HN N0</th>
                                    <td valign="top" width="300">
        <select name="cbo_patient_hn_no" id="cbo_patient_hn_no"ONCHANGE = "document.forms.nurse_foods_order_add.txt_patient_fullnamet.value = document.forms.nurse_foods_order_add.cbo_patient_hn_no.options[
document.forms.nurse_foods_order_add.cbo_patient_hn_no.selectedIndex ].text ; document.forms.nurse_foods_order_add.txt_patient_hn_no.value = document.getElementById('cbo_patient_hn_no').value;">
                    <%out.print(cbo_patient_hn_no); %>
        </select>
        <A HREF="#" onClick="changesubmithnno();" NAME="anchor" ID="anchor">
            <img src="images/lightbulb.gif" alt="" width="19" height="19" border="0"></A>
        <input type="hidden" name="txt_paid_id" id="txt_paid_id" value="<%out.print(foodsorderdetail.getPaidId());%>" size="3">
        <input type="hidden" name="txt_paid_namet" id="txt_paid_namet" value="<%out.print(foodsorderdetail.getPaidNamet());%>" size="25">
        <input type="hidden" name="txt_page_number" id="txt_page_number" size="6" value="<%out.print(foodsorderdetail.getPageNumber());%>">
        <br>
        <table width="100%"><tr><td>
<input type="text" name="txt_patient_hn_no" id="txt_patient_hn_no" size="6" value="<%out.print(foodsorderdetail.getPatientHnNo());%>">
<input type="button" name="btn_seacrh" id="hn_noButton" value=" ค้นหา...      " />
<div id="vn"></div></td></tr></table>
    <input type="text" name="txt_patient_fullnamet" id="txt_patient_fullnamet" size="35" value="<%out.print(foodsorderdetail.getPatientFullnamet());%>">
                                    </td></tr><tr>
                                    <th width="100">ประเภทอาหาร</th>
                                    <td valign="top" width="200">
                        <select name="cbo_type_foods_order" id="cbo_type_foods_order" ONCHANGE = "document.forms.nurse_foods_order_add.txt_type_foods_order.value = document.forms.nurse_foods_order_add.cbo_type_foods_order.options[
document.forms.nurse_foods_order_add.cbo_type_foods_order.selectedIndex ].text ;">
                                    <%out.print(cbo_type_foods_order); %>
                        </select>
<input type="hidden" name="txt_type_foods_order" id="txt_type_foods_order"  value="<%out.print(foodsorderdetail.getTypeFoodsNamet());%>">
                                    </td></tr><tr>
                                    <th width="100">หมายเหตุ</th>
                                    <td valign="top" class="style14">
<input type="text" name="txt_remark" id="txt_remark" size="35" value="<%out.print(foodsorderdetail.getRemark());%>"><br><br>
<label><input type="checkbox" name="chk_1" value="อ่อน" onchange="document.forms.nurse_foods_order_add.txt_remark.value = document.forms.nurse_foods_order_add.txt_remark.value + document.forms.nurse_foods_order_add.chk_1.value+' ';"/>อ่อน</label>
&nbsp;<label><input type="checkbox" name="chk_2" value="ธรรมดา" onchange="document.forms.nurse_foods_order_add.txt_remark.value = document.forms.nurse_foods_order_add.txt_remark.value + document.forms.nurse_foods_order_add.chk_2.value+' ';"/>ธรรมดา</label>
&nbsp;<label><input type="checkbox" name="chk_3" value="โจ๊ก" onchange="document.forms.nurse_foods_order_add.txt_remark.value = document.forms.nurse_foods_order_add.txt_remark.value + document.forms.nurse_foods_order_add.chk_3.value+' ';"/>โจ๊ก</label>
&nbsp;<label><input type="checkbox" name="chk_4" value="โจ๊กปั่น" onchange="document.forms.nurse_foods_order_add.txt_remark.value = document.forms.nurse_foods_order_add.txt_remark.value + document.forms.nurse_foods_order_add.chk_4.value+' ';"/>โจ๊กปั่น</label>
<br><label><input type="checkbox" name="chk_5" value="เหลวใส" onchange="document.forms.nurse_foods_order_add.txt_remark.value = document.forms.nurse_foods_order_add.txt_remark.value + document.forms.nurse_foods_order_add.chk_5.value+' ';"/>เหลวใส</label>
&nbsp;<label><input type="checkbox" name="chk_6" value="เหลวข้น" onchange="document.forms.nurse_foods_order_add.txt_remark.value = document.forms.nurse_foods_order_add.txt_remark.value + document.forms.nurse_foods_order_add.chk_6.value+' ';"/>เหลวข้น</label><br><br>

<label><input type="checkbox" name="chk_7" value="งดหวาน" onchange="document.forms.nurse_foods_order_add.txt_remark.value = document.forms.nurse_foods_order_add.txt_remark.value + document.forms.nurse_foods_order_add.chk_7.value+' ';"/>งดหวาน</label>
&nbsp;<label><input type="checkbox" name="chk_8" value="งดสัตว์ปีก" onchange="document.forms.nurse_foods_order_add.txt_remark.value = document.forms.nurse_foods_order_add.txt_remark.value + document.forms.nurse_foods_order_add.chk_8.value+' ';"/>งดสัตว์ปีก</label>
&nbsp;<label><input type="checkbox" name="chk_9" value="แพ้อาหารทะเล" onchange="document.forms.nurse_foods_order_add.txt_remark.value = document.forms.nurse_foods_order_add.txt_remark.value + document.forms.nurse_foods_order_add.chk_9.value+' ';"/>งดอาหารทะเล</label>
<br><label><input type="checkbox" name="chk_10" value="งดเค็ม" onchange="document.forms.nurse_foods_order_add.txt_remark.value = document.forms.nurse_foods_order_add.txt_remark.value + document.forms.nurse_foods_order_add.chk_10.value+' ';"/>งดเค็ม</label>
&nbsp;<label><input type="checkbox" name="chk_11" value="งดมัน" onchange="document.forms.nurse_foods_order_add.txt_remark.value = document.forms.nurse_foods_order_add.txt_remark.value + document.forms.nurse_foods_order_add.chk_11.value+' ';"/>งดมัน</label><br><br>
<input type="button" name="clearButton" id="clearButton" value=" Clear" />
                                    </td>
                            </tr>
                            </thead>
                           <%out.print(text2);%>
                        </table>
                    </td>
                </tr>
            </tbody>
       </table>

        </form>
    </body>
</html>
