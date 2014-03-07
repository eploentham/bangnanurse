<%-- 
    Document   : nurse_foods_order_view
    Created on : 8 ส.ค. 2552, 12:05:36
    Author     : pop
--%>

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
//BDepartmentDB b_departmentdb = new BDepartmentDB(config1);
String text="", cbo_ward="",cbo_branch="",date_start="", date_end="", flagpage="";
String row_color="", txt_color="",txt_color1="", branch_id="", ward_id="", date_foods_order="";
String width_date="80", width_ward="70", width_user_order="70", width_nutritition="70";
String width_period="100", date_current="",date_startdb="", date_enddb="";
Integer row=0;
BBranch branch = new BBranch();
branch = config1.getBranchActive();
Vector v_foods_order = new Vector();
try {
    if(request.getParameter("flagpage")!=null) {
        flagpage = request.getParameter("flagpage");
    }
    if(request.getParameter("cbo_branch")!=null) {
        branch_id = request.getParameter("cbo_branch");
    }
    if(request.getParameter("cbo_ward")!=null) {
        ward_id = request.getParameter("cbo_ward");
    }
    if(request.getParameter("txt_date_start")!=null) {
        date_start = request.getParameter("txt_date_start");
    }
    if(request.getParameter("txt_date_end")!=null) {
        date_end = request.getParameter("txt_date_end");
    }
    if(branch_id.equals("")){
        //branch = config1.getBranchActive();
        branch_id = branch.getBranchId();
    }
    cbo_branch = combodb.getComboBranch(branch_id);
    //cbo_ward = config1.CboWard(branch_id,ward_id);
    date_current = config1.getDate("yyyyMMdd");
    //cbo_ward = b_departmentdb.CboDepartment(branch_id,ward_id);
    cbo_ward = combodb.CboWardN(branch_id,ward_id);//bangna1 mainhis
    //cbo_ward = config1.CboWard(branch_id,ward_id);
    //String year = date_current.substring(0, 4);
    //date_current = String.valueOf(Integer.parseInt(year)-543)+"-"+date_current.substring(4, 6)+"-"+date_current.substring(date_current.length()-2, date_current.length());
    if(date_start.equals("")){
        date_start = config1.DateFormatDB2Show(date_current,"ddMMyyyy");
        date_end = config1.DateFormatDB2Show(date_current,"ddMMyyyy");
    }
    if(flagpage.equals("old_date")){
        date_startdb = config1.DateFormatShow2DB(date_start, "ddMMyyyy");
        date_enddb = config1.DateFormatShow2DB(date_end, "ddMMyyyy");
    }else{
        date_startdb = config1.getDate("yyyyMMdd");
        //date_start = config1.DateFormatShow2DB(date_start, "ddMMyyyy");
        date_enddb = config1.getDate("yyyyMMdd");
    }
    v_foods_order = foodsorderdb.getNurserFoodsOrder(branch_id, "date",date_startdb,date_enddb);
    
    for(int i=0;i<=v_foods_order.size()-1;i++) {
        row++;
        foodsorder = (NurseTFoodsOrder)v_foods_order.get(i);
        date_foods_order = config1.DateFormatDB2Show(foodsorder.getDateFoodsOrder(), "ddMMyyyy");

        row_color = "";
        text+="<tr class='style14r' "+row_color+"> <td align='center' width='30'>"+row.toString()+"</td>"
            +"<td width='"+width_date+"'><div align='left'> "+txt_color+date_foods_order+txt_color1+"</div></td>"
            +"<td width='"+width_ward+"'>"+txt_color+foodsorder.getTimeFoodsOrder()+txt_color1+"</td>"
            +"<td width='"+width_ward+"'>"+txt_color+foodsorder.getWardNamet()+txt_color1+"</td>"
            +"<td width='"+width_period+"'><A HREF='nurse_fo_add.jsp?foodsOrderId="+foodsorder.getFoodsOrderId()
            +"&flagpage=viewdetail' name='nurse_foods_order_add' id='nurse_foods_order_add'>"
                +txt_color+foodsorder.getFoodsPeriodNamet()+" ["+foodsorder.getFoodsOrderId()+"]"
                +txt_color1+"</a></td>"
            +"<td width='"+width_user_order+"'>"+txt_color+foodsorder.getUserNametFoodsOrder()+txt_color1+"</td>"
            +"<td width='"+width_nutritition+"'>"+txt_color+foodsorder.getUserNametNutritionist()+txt_color1+"</td>"
            +"</tr>";
    }
    if(text.equals("")){
        text="<tr class='style14r' ><td>ไม่พบข้อมูล</td><td></td><td></td><td></td><td></td><td></td><td></td></tr>";
    }
}catch(Exception ex){
    text = ex.getMessage();
}
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style type="text/css" title="currentStyle">
                @import "css/tab.css";
                @import "css/demo_table.css";
                @import "css/jquery-ui-1.8.18.custom.css";
        </style>
        <script type="text/javascript" src="js/jquery-1.6.4.js"></script>
        <script type="text/javascript" src="js/jquery-ui-1.8.18.custom.min.js"></script>
        <!-- <script type="text/javascript" src="js/ui.datepicker.js"></script>
        <script type="text/javascript" src="js/ui.dialog.js"></script>
        
        <script type="text/javascript" src="js/listing.6.2.js"></script>
        <script type="text/javascript" src="js/ProgressBar.js"></script>
        <SCRIPT LANGUAGE="JavaScript" SRC="js/CalendarPopup.js"></SCRIPT>
        <SCRIPT LANGUAGE="JavaScript" SRC="js/date.js"></SCRIPT>
        <script type="text/javascript" src="js/prototype-1.6.0.3.js"></script>
        <SCRIPT LANGUAGE="JavaScript" SRC="js/AnchorPosition.js"></SCRIPT>
        <SCRIPT LANGUAGE="JavaScript" SRC="js/PopupWindow.js"></SCRIPT>
        <script type="text/javascript" src="js/dojo1.3.1/dojo/dojo.js" djConfig="parseOnLoad: true"></script>
        -->

        <style type="text/css">
          div.error {
            color: red;
          }
        </style>
        <script type="text/javascript">
            $(document).ready(function() {
                hideLoader();
                $("#txt_date_start").datepicker({ dateFormat: 'dd-mm-yy' });
                $("#txt_date_end").datepicker({ dateFormat: 'dd-mm-yy' });
                $("#btn_search").click(showSearch);
                $("#txt_date_current").change(showSearch);
                $("#tab1").css("background-image","url('../images/tabright_click.gif')");
                $("#tab11").html("<font color='red'><b>"+$("#tab11").html()+"</b></font>");
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
            
        </script>
    </head>
    <body>
        <form name="nurse_foods_order_view" id="nurse_foods_order_view" action="nurse_foods_order_view.jsp" method="POST">
            <%@include  file="nurse_foods_order_header.jsp" %>
            <table><tr><td >
                        <fieldset >
                            <legend>เงื่อนไข:</legend>
                            <label>&nbsp;&nbsp;สาขา :&nbsp;<select name="cbo_branch" id="cbo_branch">
                                <%out.print(cbo_branch); %>
                </select></label>
                <label>&nbsp;&nbsp;Ward :&nbsp;<select name="cbo_ward" id="cbo_ward"><%out.print(cbo_ward); %></select></label>
                &nbsp;&nbsp;วันที่ :&nbsp;<input type="text" name="txt_date_start" id="txt_date_start" value="<% out.print(date_start);%>" readonly="readonly" class="dateinput" size="8">
&nbsp;&nbsp;ถึงวันที่ :&nbsp;<input type="text" name="txt_date_end" id="txt_date_end" value="<% out.print(date_end);%>" readonly="readonly" class="dateinput" size="8">
<input type="button" name="btn_seacrh" id="btn_search" value=" ค้นหา...      " />
                        </fieldset>
                </td></tr></table>
            <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <thead>
                <tr bgcolor="#336699"  class="style14w">
                    <th width="15" ><div align="center">ลำดับ</div></th>
                  <th width="80" ><div align="center">วันที่สั่ง</div></th>
                  <th width="80" ><div align="center">เวลาสั่ง</div></th>
                  <th width="100" bgcolor="#336699" ><div align="center">Ward</div></th>
                  <th width="100" bgcolor="#336699" ><div align="center">มื้อ</div></th>
                  <th width="70" bgcolor="#336699" ><div align="center">เจ้าหน้าที่ผู้สั่ง</div></th>
                  <th width="100" bgcolor="#336699" ><div align="center">โภชนากร</div></th>                  
                </tr>
            </thead>
            <% out.print(text);%>
            </table>
        </form>
    </body>
</html>
