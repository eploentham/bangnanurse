<%-- 
    Document   : nurse_fo_add_detail
    Created on : Feb 8, 2012, 3:35:48 PM
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
String text2="",dateCurrent="",foodsOrderDetailId="",cbo_type_foods_order="";
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
    if(request.getParameter("foodsOrderDetailId")!=null) {
        foodsOrderDetailId = new String (request.getParameter("foodsOrderDetailId").getBytes("ISO8859_1"),"TIS-620");
    }
    if(branchId.equals("")){
        branch = config1.getBranchActive();
        branchId = branch.getBranchId();
    }
    fO = NC.fOdb.getNurserFoodsOrderByPK(foodsOrderId);
    fOD = NC.fOdb.getNurserFoodsOrderDetailByPK(foodsOrderDetailId);
    //cbo_branch = combodb.getComboBranch(branchId);
    //cbo_ward = combodb.CboWardN(branchId,fO.getWardId());//bangna1 mainhis
    //cbo_foods_period = combodb.CboFoodsPeriod(branchId, fO.getFoodsPeriodId());
    cbo_type_foods_order = combodb.CboTypeFoods(branchId,fOD.getTypeFoodsId());
    if(!fO.getDateFoodsOrder().equals(""))dateCurrent = config1.DateFormatDB2Show(fO.getDateFoodsOrder(), "ddMMyyyy");
    else dateCurrent = config1.getDate("ddMMyyyy");
}catch(Exception ex){
    text = ex.getMessage();
}
%>
<script type="text/javascript">
            $(document).ready(function() {
                $("#txt_contact_road").keyup(autoSearchRoad);
                $("#txt_province_namet").keyup(autoSearchChangwat);
                $("#txt_province_namet").change(setChangwat);
                $("#txt_amphur_namet").keyup(autoSearchAmphur);
                $("#txt_amphur_namet").change(setAmphur);
                $("#txt_tambon_namet").keyup(autoSearchTambon);
                $("#txt_tambon_namet").change(setTambon);
            });
function setPatientName(){
    $("#txt_patient_fullnamet").val($("#cbo_patient_hn_no option:selected").text());
    $("#txt_patient_hn_no").val($("#cbo_patient_hn_no").val());
    //if($("#txt_bed_id").val()==""){
        $("#devTempBed").load("nurse_foods_order_f_view.jsp",
        {hnNo : $("#txt_patient_hn_no").val(), branch_id : $("#txtBranchId").val(), flagpage: 'search_ward_bed'}, function() { hideLoader();
        var str_month = $("#devTempBed").html();
        var arr_month = str_month.split("@");
        $("#txt_room_id").val(arr_month[0]);
        $("#txt_bed_id").val(arr_month[1]);
    });
        
    //}
}
function setCboHnno(){
    $("#cbo_patient_hn_no").remove();
    $("#divHnno").load("nurse_foods_order_f_view.jsp",
            {ward_id : $("#cbo_ward").val(), branch_id : $("#txtBranchId").val(), bedId : $("#txt_bed_id").val(), roomId : $("#txt_room_id").val(),
                flagpage: 'cbo_hn_no'}, function() { hideLoader();});
     $("#cbo_patient_hn_no").appendTo($("#divHnno").contents());
}
</script>
<table width="100%">
                            <thead>
                            <tr>
                                    <th width="120">ห้อง</th>
                                    <td valign="top" width="200">
                                        <input type="text" name="txt_room_id" id="txt_room_id" size="5" value="<%out.print(fOD.getRoomId());%>">
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<A HREF="#" onClick="voidFoodsOrderDetail();" NAME="anchorVoidDetail" ID="anchorVoidDetail">
<img src="images/trash1.gif" alt="" width="20" height="16" border="0">ยกเลิกรายการ</A>
    <input type="hidden" name="txt_foods_order_detail_active" id="txt_foods_order_detail_active" value="<%out.print(fOD.getFoodsOrderDetailActice());%>">
                                    </td></tr><tr>
                                    <th width="100">เตียง</th>
                                    <td valign="top" >
<input type="text" name="txt_bed_id" id="txt_bed_id" size="5" value="<%out.print(fOD.getBedId());%>">
<input type="hidden" name="txt_foods_order_detail_id" id="txt_foods_order_detail_id" value="<%out.print(fOD.getFoodsOrderDetailId());%>">
                                    </td></tr><tr>
                                    <th width="120">HN N0</th>
                                    <td>
                                        <!--<select name="cbo_patient_hn_no" id="cbo_patient_hn_no" >
                    <%//out.print(cbo_patient_hn_no); %>
        </select>-->
        <input type="hidden" name="txt_paid_id" id="txt_paid_id" value="<%out.print(fOD.getPaidId());%>" size="3">
        <input type="hidden" name="txt_paid_namet" id="txt_paid_namet" value="<%out.print(fOD.getPaidNamet());%>" size="25">
        <input type="hidden" name="txt_page_number" id="txt_page_number" size="6" value="<%out.print(fOD.getPageNumber());%>">
        <table width="100%"><tr>
                <td><A HREF="#" id="anchorSubmitHnno" NAME="anchorSubmitHnno" onclick="setCboHnno();"><img src="images/lightbulb.gif" alt="" width="19" height="19" border="0"></A></td>
                <td valign="top" ><div id="divHnno"></div></td></tr><tr><td colspan="2">
<input type="text" name="txt_patient_hn_no" id="txt_patient_hn_no" size="6" value="<%out.print(fOD.getPatientHnNo());%>">
<A HREF="#" id="anchorSubmitHnno1" NAME="anchorSubmitHnno1"><img src="images/lightbulb.gif" alt="" width="19" height="19" border="0"></A>
<input type="text" name="txt_patient_fullnamet" id="txt_patient_fullnamet" size="20" value="<%out.print(fOD.getPatientFullnamet());%>">
<!--<div id="vn"></div>--></td></tr></table>
                                    </td></tr><tr>
                                    <th width="120">ประเภทอาหาร</th>
                                    <td valign="top" width="200">
                        <select name="cbo_type_foods_order" id="cbo_type_foods_order" >
                                    <%out.print(cbo_type_foods_order); %>
                        </select>
<input type="hidden" name="txt_type_foods_order" id="txt_type_foods_order"  value="<%out.print(fOD.getTypeFoodsNamet());%>">
                                    </td></tr><tr>
                                    <th width="100">หมายเหตุ</th>
                                    <td valign="top" class="style14">
<input type="text" name="txt_remark" id="txt_remark" size="35" value="<%out.print(fOD.getRemark());%>"><br><br>
<label><input type="checkbox" name="chk_1" id="chk_1" value="อ่อน" onClick="setChk1();"/>อ่อน</label>
&nbsp;<label><input type="checkbox" name="chk_2" id="chk_2" value="ธรรมดา" onClick="setChk2();"/>ธรรมดา</label>
&nbsp;<label><input type="checkbox" name="chk_3" id="chk_3" value="โจ๊ก" onClick="setChk3();"/>โจ๊ก</label>
&nbsp;<label><input type="checkbox" name="chk_4" id="chk_4" value="โจ๊กปั่น" onClick="setChk4();"/>โจ๊กปั่น</label>
<br><label><input type="checkbox" name="chk_5" id="chk_5" value="เหลวใส" onClick="setChk5();"/>เหลวใส</label>
&nbsp;<label><input type="checkbox" name="chk_6" id="chk_6" value="เหลวข้น" onClick="setChk6();"/>เหลวข้น</label><br><br>

<label><input type="checkbox" name="chk_7" id="chk_7" value="งดหวาน" onClick="setChk7();"/>งดหวาน</label>
&nbsp;<label><input type="checkbox" name="chk_8" id="chk_8" value="งดสัตว์ปีก" onClick="setChk8();"/>งดสัตว์ปีก</label>
&nbsp;<label><input type="checkbox" name="chk_9" id="chk_9" value="แพ้อาหารทะเล" onClick="setChk9();"/>งดอาหารทะเล</label>
<br><label><input type="checkbox" name="chk_10" id="chk_10" value="งดเค็ม" onClick="setChk10();"/>งดเค็ม</label>
&nbsp;<label><input type="checkbox" name="chk_11" id="chk_11" value="งดมัน" onClick="setChk11();"/>งดมัน</label><br><br>
<input type="button" name="clearButton" id="clearButton" value=" Clear" onClick="clearRemark();"/>
                                    </td>
                            </tr>
                            </thead>
                </table>
<div id="devTempBed"></div>