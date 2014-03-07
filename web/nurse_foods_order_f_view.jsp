<%-- 
    Document   : nurse_foods_order_f_view
    Created on : Feb 2, 2012, 4:52:15 PM
    Author     : root
--%>

<%@page import="java.util.Vector"%>
<%@page import="bangnanurse.control.NurseControl"%>
<%@page import="bangnanurse.object.NurseTFoodsOrderDetail"%>
<%@page import="bangnaLibrary.PatientVisit"%>
<%@page import="bangnaLibrary.BBranch"%>
<%@page import="bangnaLibrary.ComboDB"%>
<%@page import="bangnaLibrary.Config1"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
Config1 config1 = new Config1();
//ComboDB combodb = new ComboDB(config1);
BBranch branch = new BBranch();
//NurseTFoodsOrderDB foodsorderdb = new NurseTFoodsOrderDB();
NurseControl NC = new NurseControl(config1);
NurseTFoodsOrderDetail foodsorderdetail;
PatientVisit pv = new PatientVisit();
String flag="",foodsOrderId="",branchId="",bedId="",cboPatientHnno="",wardId="",employeeIdOrder="",roomId="",foodsOrderDetailId="",ward_id="";
String text="", hnNo="";
if(request.getParameter("flagpage")!=null) {
    flag = new String (request.getParameter("flagpage").getBytes("ISO8859_1"),"TIS-620");
}
if(request.getParameter("foods_order_id")!=null) {//foodsOrderId
    foodsOrderId = new String (request.getParameter("foods_order_id").getBytes("ISO8859_1"),"TIS-620");
}
if(request.getParameter("branch_id")!=null) {
    branchId = new String (request.getParameter("branch_id").getBytes("ISO8859_1"),"TIS-620");
}
try{
    if(branchId.equals("")){
        branch = config1.getBranchActive();
        branchId = branch.getBranchId();
    }
    if(flag.equals("foods_detail")){
        //foodsorderdetail = new NurseTFoodsOrderDetail();
        //foodsorderdetail.setFoodsOrderId(foodsOrderId);
        //cbo_type_foods_order = combodb.CboTypeFoods(branchId,foodsorderdetail.getTypeFoodsId());
        if(request.getParameter("foodsOrderId")!=null) {//foodsOrderId
            foodsOrderId = new String (request.getParameter("foodsOrderId").getBytes("ISO8859_1"),"TIS-620");
        }
        text = NC.fOdb.getTrFoodsOrderDetail(branchId, foodsOrderId, "");
    }else if(flag.equals("userfoodsorderhnno")){
        if(request.getParameter("employee_id_order")!=null) {
            employeeIdOrder = new String (request.getParameter("employee_id_order").getBytes("ISO8859_1"),"TIS-620");
        }
        text = config1.getEmployeeFullNamet(branchId, employeeIdOrder);
    }else if(flag.equals("cbo_hn_no")){
        if(request.getParameter("ward_id")!=null) {
            wardId = new String (request.getParameter("ward_id").getBytes("ISO8859_1"),"TIS-620");
        }
        if(request.getParameter("bed_id")!=null) {
            bedId = new String (request.getParameter("bed_id").getBytes("ISO8859_1"),"TIS-620");
        }
        if(request.getParameter("room_id")!=null) {
            roomId = new String (request.getParameter("room_id").getBytes("ISO8859_1"),"TIS-620");
        }
        cboPatientHnno = config1.CboPatientinWard(branchId,"","hnno", wardId,wardId,roomId, bedId);
        //Vector v_room = config1.SearchPaitentinWard(branch_id, "", "", "hnno", ward_id, room_id, bed_id);
       //(v_room.size()==1){
       //     PatientVisit patientvisit = new PatientVisit();
        //    patientvisit = (bangnaLibrary.PatientVisit) v_room.get(0);
        //    patient_hn_no = patientvisit.getPatientId();
        //    patient_fullnamet = patientvisit.getPatientNamet();
        //    paid_id = patientvisit.getVisitPaidId();
        //    paid_namet = patientvisit.getVisitPaidNamet();
        //}
        text = "<Select id='cbo_patient_hn_no' onchange='setPatientName();'>"+cboPatientHnno+"</Select>";
    }else if(flag.equals("void_foods_order_detail")){
        if(request.getParameter("foodsOrderDetailId")!=null) {//foodsOrderId
            foodsOrderDetailId = new String (request.getParameter("foodsOrderDetailId").getBytes("ISO8859_1"),"TIS-620");
        }
        NC.voidFoodsOrderDetail(branchId, foodsOrderDetailId);
        text="<script type='text/javascript' charset='UTF-8'> setFoodsOrderDetailAdd(); </script>";
    }else if(flag.equals("void_foods_order")){
        if(request.getParameter("foodsOrderId")!=null) {//foodsOrderId
            foodsOrderId = new String (request.getParameter("foodsOrderId").getBytes("ISO8859_1"),"TIS-620");
        }
        NC.voidFoodsOrder(branchId, foodsOrderId);
        text="<script type='text/javascript' charset='UTF-8'> window.location='nurse_foods_order_view.jsp?flagpage=old_date' </script>";
    }else if(flag.equals("search_ward_bed")){
        if(request.getParameter("hnNo")!=null) {//foodsOrderId
            hnNo = new String (request.getParameter("hnNo").getBytes("ISO8859_1"),"TIS-620");
        }
        if(request.getParameter("ward_id")!=null) {//foodsOrderId
            ward_id = new String (request.getParameter("ward_id").getBytes("ISO8859_1"),"TIS-620");
        }
        Vector v = config1.SearchPaitentinWard(branchId, "", hnNo, "hnno_bed", ward_id, "", "");
        if(v.size()>0){
            pv = (PatientVisit)v.get(0);
            text = pv.room+"@";
            text += pv.bed;
        }
    }else if(flag.equals("search_admit")){
        text = NC.getTrPatientAdmit(branchId);
    }else if(flag.equals("auto_search_hn")){
        if(request.getParameter("searchHn")!=null) {//foodsOrderId
            hnNo = new String (request.getParameter("searchHn").getBytes("ISO8859_1"),"TIS-620");
        }
        text = NC.getAutoSearch(branchId,hnNo,flag);
    }
}catch(Exception ex){
    text = ex.getMessage();
}
out.print(text);
%>