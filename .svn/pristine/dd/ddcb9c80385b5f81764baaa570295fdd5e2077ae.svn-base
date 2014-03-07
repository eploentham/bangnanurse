/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bangnanurse.objdb;
import bangnanurse.object.NurseTFoodsOrderDetail;
import bangnanurse.object.NurseTFoodsOrder;
import bangnaLibrary.FoodsPeriod;
import com.bangna.object.BDepartment;
import java.sql.*;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author pop
 */
public class NurseTFoodsOrderDB {
    private bangnaLibrary.Config1 config1 = new bangnaLibrary.Config1();
    private NurseTFoodsOrder foodsorder;
    private NurseTFoodsOrderDetail foodsorderdetail;
    public NurseTFoodsOrderDB(){
        config1 = new bangnaLibrary.Config1();
        initConfig();
    }
    public NurseTFoodsOrderDB(bangnaLibrary.Config1 cf){
        config1 = cf;
        initConfig();
    }
    public void initConfig(){
        foodsorder = new NurseTFoodsOrder();
        foodsorderdetail = new NurseTFoodsOrderDetail();
    }
    public String getMaxRowFoodsOrder(Connection conn){
        String sql="", max="";
        try {
//            Connection conn = config1.getConnectionBangna();
            Statement st;
            ResultSet rs;
            st = conn.createStatement();

            sql="Select max("+foodsorder.getFFoodsOrderId()+") as cnt From "+foodsorder.getNurseTFoodsOrder();
            rs = st.executeQuery(sql);
            while(rs.next()){
                max = rs.getString("cnt");
            }
            rs.close();
//            conn.close();
            if(max!=null && !max.equals("")){
                max =  String.valueOf(Integer.parseInt(max)+1);
            }
            else{
                max = "11100001";
            }
        } catch (Exception ex) {
            Logger.getLogger(NurseTFoodsOrderDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return max;
    }
    public String getMaxRowFoodsOrderDetail(Connection conn){
        String sql="", max="";
        try {
//            Connection conn = config1.getConnectionBangna();
            Statement st;
            ResultSet rs;
            st = conn.createStatement();

            sql="Select max("+foodsorderdetail.getFFoodsOrderDetailId()+") as cnt "
                    +"From "+foodsorderdetail.getNurseTFoodsOrderDetail();
            rs = st.executeQuery(sql);
            while(rs.next()){
                max = rs.getString("cnt");
            }
            rs.close();
//            conn.close();
            if(max!=null && !max.equals("")){
                max =  String.valueOf(Integer.parseInt(max)+1);
            }
            else{
                max = "11600001";
            }
        } catch (Exception ex) {
            Logger.getLogger(NurseTFoodsOrderDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return max;
    }
    public String getPageNumberFoodsOrderDetail(Connection conn, String foods_order_detail_id){
        String sql="", max="";
        try {
//            Connection conn = config1.getConnectionBangna();
            Statement st;
            ResultSet rs;
            st = conn.createStatement();

            sql="Select count("+foodsorderdetail.getFFoodsOrderDetailId()+") as cnt "
                    +"From "+foodsorderdetail.getNurseTFoodsOrderDetail()+" "
                    +"Where "+foodsorderdetail.getFFoodsOrderId()+"='"+foods_order_detail_id+"' and "
                    +foodsorderdetail.getFFoodsOrderDetailActive()+"='1'";
            rs = st.executeQuery(sql);
            while(rs.next()){
                max = rs.getString("cnt");
            }
            rs.close();
//            conn.close();
            if(max!=null && !max.equals("")){
                if(Integer.parseInt(max)<=12){
                    max =  "1";
                }
                else if(Integer.parseInt(max)<=24){
                    max =  "2";
                }
                else if(Integer.parseInt(max)<=36){
                    max =  "3";
                }
                else{
                    max="1";
                }
            }
            else{
                max = "1";
            }
        } catch (Exception ex) {
            Logger.getLogger(NurseTFoodsOrderDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return max;
    }
    public NurseTFoodsOrder getNurserFoodsOrderByPK(String foodsorder_id) {
        Connection conn;
//        NurseTFoodsOrder foodsorder = new NurseTFoodsOrder();
        BDepartment department = new BDepartment();
        FoodsPeriod foodsperiod = new FoodsPeriod();
        try {
            conn = config1.getConnectionBangna();
            Statement stbangna = conn.createStatement();

            String sql="";
            sql="Select foodsorder.* "
                +"From "+foodsorder.getNurseTFoodsOrder()+" as foodsorder left join "
                +department.getBDepartment()+" as department on "
                +foodsorder.getFWardId()+" = "+department.getFDepartmentId() + " "
                +"Where "+foodsorder.getFFoodsOrderId()+" = '"+foodsorder_id+"' ";
                //+"Order By "+admintbilllab.getFBillLabId()+" desc";
            ResultSet rs = stbangna.executeQuery(sql);
            while(rs.next()){
                foodsorder = new NurseTFoodsOrder();
                foodsorder.setFoodsOrderId(config1.StringNull(rs.getString(foodsorder.getFFoodsOrderId())));
                foodsorder.setWardId(config1.StringNull(rs.getString(foodsorder.getFWardId())));
                foodsorder.setDateFoodsOrder(config1.StringNull(rs.getString(foodsorder.getFDateFoodsOrder())));
                foodsorder.setFoodsOrderActive(config1.StringNull(rs.getString(foodsorder.getFFoodsOrderActive())));
                foodsorder.setUserIdFoodsOrder(config1.StringNull(rs.getString(foodsorder.getFUserIdFoodsOrder())));

                foodsorder.setUserIdFoodsReceive(config1.StringNull(rs.getString(foodsorder.getFUserIdFoodsReceive())));
                foodsorder.setUserIdNutritionist(config1.StringNull(rs.getString(foodsorder.getFUserIdNutritionist())));
                foodsorder.setUserIdCreate(config1.StringNull(rs.getString(foodsorder.getFUserIdCreate())));
                foodsorder.setUserIdModify(config1.StringNull(rs.getString(foodsorder.getFUserIdModify())));
                foodsorder.setUserIdCancel(config1.StringNull(rs.getString(foodsorder.getFUserIdCancel())));

                foodsorder.setDateCreate(config1.StringNull(rs.getString(foodsorder.getFDateCreate())));
                foodsorder.setDateModify(config1.StringNull(rs.getString(foodsorder.getFDateModify())));
                foodsorder.setDateCancel(config1.StringNull(rs.getString(foodsorder.getFDateCancel())));
                foodsorder.setBranchId(config1.StringNull(rs.getString(foodsorder.getFBranchId())));
//                foodsorder.setWardNamet(config1.StringNull(rs.getString("department_namet")));

                foodsorder.setUserNametFoodsOrder(config1.StringNull(rs.getString(foodsorder.getFUserNametFoodsOrder())));
                foodsorder.setUserNametFoodsReceive(config1.StringNull(rs.getString(foodsorder.getFUserNametFoodsReceive())));
                foodsorder.setUserNametNutritionist(config1.StringNull(rs.getString(foodsorder.getFUserNametNutritionist())));
                foodsorder.setWardNamet(config1.StringNull(rs.getString(foodsorder.getFWardNamet())));
                foodsorder.setFoodsPeriodId(config1.StringNull(rs.getString(foodsorder.getFFoodsPeriod())));

                foodsorder.setTimeFoodsOrder(config1.StringNull(rs.getString(foodsorder.getTimeFoodsOrder().substring(0, 7))));
//                foodsorder.setFoodsPeriodNamet(config1.StringNull(rs.getString("foods_period_namet")));
                
                }
            rs.close();
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(NurseTFoodsOrderDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return foodsorder;
    }
    public NurseTFoodsOrderDetail getNurserFoodsOrderDetailByPK(String foodsorderdetail_id) {
        Connection conn;
//        NurseTFoodsOrderDetail foodsorderdetail = new NurseTFoodsOrderDetail();
        try {
            conn = config1.getConnectionBangna();
            Statement stbangna = conn.createStatement();

            String sql="";
            sql="Select * "
                +"From "+foodsorderdetail.getNurseTFoodsOrderDetail()+" as fod "
                +"Where "+foodsorderdetail.getFFoodsOrderDetailId()+" = '"+foodsorderdetail_id+"' ";
                //+"Order By "+admintbilllab.getFBillLabId()+" desc";
            ResultSet rs = stbangna.executeQuery(sql);
            while(rs.next()){
                foodsorderdetail = new NurseTFoodsOrderDetail();
                foodsorderdetail.setFoodsOrderDetailId(config1.StringNull(rs.getString(foodsorderdetail.getFFoodsOrderDetailId())));
                foodsorderdetail.setBedId(config1.StringNull(rs.getString(foodsorderdetail.getFBedId())));
                foodsorderdetail.setPatientFullnamet(config1.StringNull(rs.getString(foodsorderdetail.getFPatientFullNamet())));
                foodsorderdetail.setPatientHnNo(config1.StringNull(rs.getString(foodsorderdetail.getFPatientHnNo())));
                foodsorderdetail.setRemark(config1.StringNull(rs.getString(foodsorderdetail.getFRemark())));

                foodsorderdetail.setRoomId(config1.StringNull(rs.getString(foodsorderdetail.getFRoomId())));
                foodsorderdetail.setTypeFoodsId(config1.StringNull(rs.getString(foodsorderdetail.getFTypeFoodsId())));
                foodsorderdetail.setTypeFoodsNamet(config1.StringNull(rs.getString(foodsorderdetail.getFTypeFoodsNamet())));
                foodsorderdetail.setFoodsOrderDetailActive(config1.StringNull(rs.getString(foodsorderdetail.getFFoodsOrderDetailActive())));
                foodsorderdetail.setFoodsOrderId(config1.StringNull(rs.getString(foodsorderdetail.getFFoodsOrderId())));
                
                foodsorderdetail.setPaidId(config1.StringNull(rs.getString(foodsorderdetail.getFPaidId())));
                foodsorderdetail.setPaidNamet(config1.StringNull(rs.getString(foodsorderdetail.getFPaidNamet())));
                foodsorderdetail.setPageNumber(config1.StringNull(rs.getString(foodsorderdetail.getFPageNumber())));
                foodsorderdetail.setFoodsPrice(Double.parseDouble(rs.getString(foodsorderdetail.getFFoodsPrice())));

                }
            rs.close();
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(NurseTFoodsOrderDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return foodsorderdetail;
    }
    public Vector getNurserFoodsOrder(String branch_id, String flag, String where1, String where2) {
        Connection conn;
//        NurseTFoodsOrder foodsorder = new NurseTFoodsOrder();
        BDepartment department = new BDepartment();
        FoodsPeriod foodsperiod = new FoodsPeriod();
        Vector v_foodsorder = new Vector();
        String sql="", time_foods_order="";
        try {
            conn = config1.getConnectionBangna();
            Statement stbangna = conn.createStatement();
            ResultSet rs;
            if(flag.equals("date")) {
                sql="Select foodsorder.*, fop.foods_period_namet "
                    +"From "+foodsorder.getNurseTFoodsOrder()+" as foodsorder left join "
//                    +department.getBDepartment()+" as department on "
//                    +foodsorder.getFWardId()+" = "+department.getFDepartmentId() + " left join "
                    +foodsperiod.getFoodsPeriod()+" as fop on fop."
                    +foodsorder.getFFoodsPeriod()+" = foodsorder." +foodsperiod.getFFoodsPeriodId()+" "
                    +"Where foodsorder."+foodsorder.getFFoodsOrderActive()+" = '1' and "
                    +"foodsorder."+foodsorder.getFDateFoodsOrder()+" >= '"+where1+"' and "
                    +"foodsorder."+foodsorder.getFDateFoodsOrder()+" <= '"+where2+"' and "
                    +"foodsorder."+foodsorder.getFBranchId()+" = '"+branch_id+"' "
                    +"Order By foodsorder."+ foodsorder.getFBranchId() +", foodsorder."+foodsorder.getFDateFoodsOrder()
                    +", foodsorder."+foodsorder.getFWardNamet()
                    +", foodsorder."+foodsorder.getFFoodsOrderId();
            }
            else {
                sql="Select foodsorder.*, department.department_namet, fop.foods_period_namet "
                    +"From "+foodsorder.getNurseTFoodsOrder()+" as foodsorder left join "
                    +department.getBDepartment()+" as department on "
                    +foodsorder.getFWardId()+" = "+department.getFDepartmentId() + " left join "
                    +foodsperiod.getFoodsPeriod()+" as fop on fop." +foodsorder.getFFoodsPeriod()+" = foodsorder." +foodsperiod.getFFoodsPeriodId()+" "
                    +"Where foodsorder."+foodsorder.getFFoodsOrderActive()+" = '1' "
                    +"Order By "+foodsorder.getFFoodsOrderId()+" Desc";
            }
            rs = stbangna.executeQuery(sql);
            while(rs.next()) {
                foodsorder = new NurseTFoodsOrder();
                foodsorder.setFoodsOrderId(config1.StringNull(rs.getString(foodsorder.getFFoodsOrderId())));
                foodsorder.setWardId(config1.StringNull(rs.getString(foodsorder.getFWardId())));
                foodsorder.setDateFoodsOrder(config1.StringNull(rs.getString(foodsorder.getFDateFoodsOrder())));
                foodsorder.setFoodsOrderActive(config1.StringNull(rs.getString(foodsorder.getFFoodsOrderActive())));
                foodsorder.setUserIdFoodsOrder(config1.StringNull(rs.getString(foodsorder.getFUserIdFoodsOrder())));

                foodsorder.setUserIdFoodsReceive(config1.StringNull(rs.getString(foodsorder.getFUserIdFoodsReceive())));
                foodsorder.setUserIdNutritionist(config1.StringNull(rs.getString(foodsorder.getFUserIdNutritionist())));
                foodsorder.setUserIdCreate(config1.StringNull(rs.getString(foodsorder.getFUserIdCreate())));
                foodsorder.setUserIdModify(config1.StringNull(rs.getString(foodsorder.getFUserIdModify())));
                foodsorder.setUserIdCancel(config1.StringNull(rs.getString(foodsorder.getFUserIdCancel())));

                foodsorder.setDateCreate(config1.StringNull(rs.getString(foodsorder.getFDateCreate())));
                foodsorder.setDateModify(config1.StringNull(rs.getString(foodsorder.getFDateModify())));
                foodsorder.setDateCancel(config1.StringNull(rs.getString(foodsorder.getFDateCancel())));
                foodsorder.setBranchId(config1.StringNull(rs.getString(foodsorder.getFBranchId())));
//                foodsorder.setWardNamet(config1.StringNull(rs.getString("department_namet")));

                foodsorder.setUserNametFoodsOrder(config1.StringNull(rs.getString(foodsorder.getFUserNametFoodsOrder())));
                foodsorder.setUserNametFoodsReceive(config1.StringNull(rs.getString(foodsorder.getFUserNametFoodsReceive())));
                foodsorder.setUserNametNutritionist(config1.StringNull(rs.getString(foodsorder.getFUserNametNutritionist())));
                foodsorder.setWardNamet(config1.StringNull(rs.getString(foodsorder.getFWardNamet())));
                foodsorder.setFoodsPeriodId(config1.StringNull(rs.getString(foodsorder.getFFoodsPeriod())));
                foodsorder.setFoodsPeriodNamet(config1.StringNull(rs.getString("foods_period_namet")));

                time_foods_order = rs.getString(foodsorder.getFTimeFoodsOrder());
                if(time_foods_order != null && time_foods_order.length()>=8){
                    time_foods_order = rs.getString(foodsorder.getFTimeFoodsOrder()).substring(0, 8);
                }
                foodsorder.setTimeFoodsOrder(config1.StringNull(time_foods_order));
                
                v_foodsorder.add(foodsorder);
            }
            rs.close();
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(NurseTFoodsOrderDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return v_foodsorder;
    }
    public Vector getNurserFoodsOrderDetail(String branch_id, String foods_order_id, String flag) {
        Connection conn;
//        NurseTFoodsOrderDetail foodsorderdetail = new NurseTFoodsOrderDetail();
        Vector v_foodsorder = new Vector();
        try {
            conn = config1.getConnectionBangna();
            Statement stbangna = conn.createStatement();
            String sql="";
            if(flag.equals("viewnursedetail")){
                sql="Select fod.*, fo. "+foodsorder.getFWardNamet()+" "
                +"From "+foodsorderdetail.getNurseTFoodsOrderDetail()+" as fod left join "+foodsorder.getNurseTFoodsOrder()+" as fo " +
                "on fo."+foodsorder.getFFoodsOrderId()+"=fod."+foodsorderdetail.getFFoodsOrderId()+" "
                +"Where fo."+foodsorder.getFDateFoodsOrder()+" = '"+foods_order_id+"' and fod."
                +foodsorderdetail.getFFoodsOrderDetailActive()+"='1' and fo."+foodsorder.getFFoodsOrderActive()+"='1' "
                +"Order By fo."+foodsorder.getFFoodsOrderId()+", fod."+foodsorderdetail.getFFoodsOrderDetailId();
            }else if(flag.equals("date_foods_order")){
                sql="Select fodi.* "
                +"From "+foodsorderdetail.getNurseTFoodsOrderDetail()+" as fodi "
                + "Left Join "+foodsorder.getNurseTFoodsOrder()+" as fod On fod."+foodsorder.getFFoodsOrderId()+"=fodi."+foodsorderdetail.getFFoodsOrderId()+" "
                +"Where fod."+foodsorder.getFDateFoodsOrder()+" = '"+foods_order_id+"' and fodi."
                +foodsorderdetail.getFFoodsOrderDetailActive()+"='1' and fod."+foodsorder.getFFoodsOrderActive()+"='1' "
                +"Order By fodi."+foodsorderdetail.getFFoodsOrderDetailId();
            }else {
                sql="Select * "
                +"From "+foodsorderdetail.getNurseTFoodsOrderDetail()+" as foodsorderdetail "
                +"Where "+foodsorderdetail.getFFoodsOrderId()+" = '"+foods_order_id+"' and "
                +foodsorderdetail.getFFoodsOrderDetailActive()+"='1' "
                +"Order By "+foodsorderdetail.getFFoodsOrderDetailId();
            }
            ResultSet rs = stbangna.executeQuery(sql);
            while(rs.next()){
                foodsorderdetail = new NurseTFoodsOrderDetail();
                foodsorderdetail.setFoodsOrderId(config1.StringNull(rs.getString(foodsorderdetail.getFFoodsOrderId())));
                foodsorderdetail.setFoodsOrderDetailId(config1.StringNull(rs.getString(foodsorderdetail.getFFoodsOrderDetailId())));
                foodsorderdetail.setBedId(config1.StringNull(rs.getString(foodsorderdetail.getFBedId())));
                foodsorderdetail.setFoodsOrderDetailActive(config1.StringNull(rs.getString(foodsorderdetail.getFFoodsOrderDetailActive())));
                foodsorderdetail.setPatientFullnamet(config1.StringNull(rs.getString(foodsorderdetail.getFPatientFullNamet())));

                foodsorderdetail.setPatientHnNo(config1.StringNull(rs.getString(foodsorderdetail.getFPatientHnNo())));
                foodsorderdetail.setRemark(config1.StringNull(rs.getString(foodsorderdetail.getFRemark())));
                foodsorderdetail.setRoomId(config1.StringNull(rs.getString(foodsorderdetail.getFRoomId())));
                foodsorderdetail.setTypeFoodsId(config1.StringNull(rs.getString(foodsorderdetail.getFTypeFoodsId())));
                foodsorderdetail.setTypeFoodsNamet(config1.StringNull(rs.getString(foodsorderdetail.getFTypeFoodsNamet())));

                foodsorderdetail.setPaidId(config1.StringNull(rs.getString(foodsorderdetail.getFPaidId())));
                foodsorderdetail.setPaidNamet(config1.StringNull(rs.getString(foodsorderdetail.getFPaidNamet())));
                foodsorderdetail.setPageNumber(config1.StringNull(rs.getString(foodsorderdetail.getFPageNumber())));
                foodsorderdetail.setFoodsPrice(Double.parseDouble(rs.getString(foodsorderdetail.getFFoodsPrice())));
                if(flag.equals("viewnursedetail")){
                    foodsorderdetail.setWardNamet(config1.StringNull(rs.getString(foodsorder.getFWardNamet())));
                }
                
                v_foodsorder.add(foodsorderdetail);

                }
            rs.close();
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(NurseTFoodsOrderDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return v_foodsorder;
    }
    public NurseTFoodsOrderDetail getNurserFoodsOrderDetailSum(String branch_id, String itemNumber, String foods_order_id, String flag) {
        Connection conn;
//        NurseTFoodsOrderDetail foodsorderdetail = new NurseTFoodsOrderDetail();
        Vector v_foodsorder = new Vector();
        try {
            foodsorderdetail = new NurseTFoodsOrderDetail();
            conn = config1.getConnectionBangna();
            Statement stbangna = conn.createStatement();
            String sql="";
            if(flag.equals("viewnursedetail")){
                sql="Select fod.*, fo. "+foodsorder.getFWardNamet()+" "
                +"From "+foodsorderdetail.getNurseTFoodsOrderDetail()+" as fod left join "+foodsorder.getNurseTFoodsOrder()+" as fo " +
                "on fo."+foodsorder.getFFoodsOrderId()+"=fod."+foodsorderdetail.getFFoodsOrderId()+" "
                +"Where fo."+foodsorder.getFDateFoodsOrder()+" = '"+foods_order_id+"' and fod."
                +foodsorderdetail.getFFoodsOrderDetailActive()+"='1' and fo."+foodsorder.getFFoodsOrderActive()+"='1' "
                +"Order By fo."+foodsorder.getFFoodsOrderId()+", fod."+foodsorderdetail.getFFoodsOrderDetailId();
            }else if(flag.equals("date_foods_order")){
                sql="Select count(1) as cnt  "
                +"From "+foodsorderdetail.getNurseTFoodsOrderDetail()+" as fodi "
                + "Left Join "+foodsorder.getNurseTFoodsOrder()+" as fod On fod."+foodsorder.getFFoodsOrderId()+"=fodi."+foodsorderdetail.getFFoodsOrderId()+" "
                +"Where fod."+foodsorder.getFDateFoodsOrder()+" = '"+foods_order_id+"' and fodi."
                +foodsorderdetail.getFFoodsOrderDetailActive()+"='1' and fod."+foodsorder.getFFoodsOrderActive()+"='1' and fodi."+foodsorderdetail.getFTypeFoodsId()+"='"+itemNumber+"' "
                +"Group By fod."+foodsorder.getFDateFoodsOrder();
            }else {
                sql="Select * "
                +"From "+foodsorderdetail.getNurseTFoodsOrderDetail()+" as foodsorderdetail "
                +"Where "+foodsorderdetail.getFFoodsOrderId()+" = '"+foods_order_id+"' and "
                +foodsorderdetail.getFFoodsOrderDetailActive()+"='1' "
                +"Order By "+foodsorderdetail.getFFoodsOrderDetailId();
            }
            ResultSet rs = stbangna.executeQuery(sql);
            while(rs.next()){
                foodsorderdetail = new NurseTFoodsOrderDetail();
                foodsorderdetail.setRemark(config1.StringNull(rs.getString("cnt")));
//                foodsorderdetail.setFoodsOrderDetailId(config1.StringNull(rs.getString(foodsorderdetail.getFFoodsOrderDetailId())));
//                foodsorderdetail.setBedId(config1.StringNull(rs.getString(foodsorderdetail.getFBedId())));
//                foodsorderdetail.setFoodsOrderDetailActive(config1.StringNull(rs.getString(foodsorderdetail.getFFoodsOrderDetailActive())));
//                foodsorderdetail.setPatientFullnamet(config1.StringNull(rs.getString(foodsorderdetail.getFPatientFullNamet())));
//
//                foodsorderdetail.setPatientHnNo(config1.StringNull(rs.getString(foodsorderdetail.getFPatientHnNo())));
//                foodsorderdetail.setRemark(config1.StringNull(rs.getString(foodsorderdetail.getFRemark())));
//                foodsorderdetail.setRoomId(config1.StringNull(rs.getString(foodsorderdetail.getFRoomId())));
//                foodsorderdetail.setTypeFoodsId(config1.StringNull(rs.getString(foodsorderdetail.getFTypeFoodsId())));
//                foodsorderdetail.setTypeFoodsNamet(config1.StringNull(rs.getString(foodsorderdetail.getFTypeFoodsNamet())));
//
//                foodsorderdetail.setPaidId(config1.StringNull(rs.getString(foodsorderdetail.getFPaidId())));
//                foodsorderdetail.setPaidNamet(config1.StringNull(rs.getString(foodsorderdetail.getFPaidNamet())));
//                foodsorderdetail.setPageNumber(config1.StringNull(rs.getString(foodsorderdetail.getFPageNumber())));
//                foodsorderdetail.setFoodsPrice(Double.parseDouble(rs.getString(foodsorderdetail.getFFoodsPrice())));
//                if(flag.equals("viewnursedetail")){
//                    foodsorderdetail.setWardNamet(config1.StringNull(rs.getString(foodsorder.getFWardNamet())));
//                }
//                
//                v_foodsorder.add(foodsorderdetail);

                }
            rs.close();
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(NurseTFoodsOrderDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return foodsorderdetail;
    }
    public String setSaveFoodsOrder(NurseTFoodsOrder item, String flagpage) throws Exception {
        int chk=0;
        String sql="", max="";
//        NurseTFoodsOrder foodsorder = new NurseTFoodsOrder();
        Connection conn;
        Statement st;
        try {
            conn = config1.getConnectionBangna();
            st = conn.createStatement();
            foodsorder = getNurserFoodsOrderByPK(item.getFoodsOrderId());
//            item.set(item.getAssetNamet().replace("'", "''"));
            
            if(foodsorder.getFoodsOrderId().equals("")){
                max = getMaxRowFoodsOrder(conn);
                sql="Insert Into "+foodsorder.getNurseTFoodsOrder()+"("
                        +foodsorder.getFFoodsOrderId()+", "+foodsorder.getFWardId()+", "
                        +foodsorder.getFDateFoodsOrder()+","+ foodsorder.getFUserIdFoodsOrder()+","
                        +foodsorder.getFUserIdFoodsReceive()+","+ foodsorder.getFFoodsOrderActive()+","
                        +foodsorder.getFDateCreate()+","+ foodsorder.getFDateModify()+","
                        +foodsorder.getFDateCancel()+","+ foodsorder.getFUserIdCreate()+","
                        +foodsorder.getFUserIdModify()+","+ foodsorder.getFUserIdCancel()+","
                        +foodsorder.getFUserNametFoodsOrder()+","+ foodsorder.getFUserNametFoodsReceive()+","
                        +foodsorder.getFUserNametNutritionist()+","+foodsorder.getFUserIdNutritionist()+","
                        +foodsorder.getFBranchId()+","+foodsorder.getFWardNamet()+","
                        +foodsorder.getFFoodsPeriod()+","+foodsorder.getFTimeFoodsOrder()+") "
                        +"Values('"+max+"','"+item.getWardId() + "','"
                        +item.getDateFoodsOrder()+"','"+item.getUserIdFoodsOrder() + "','"
                        +item.getUserIdFoodsReceive()+"','"+item.getFoodsOrderActive() + "','"
                        +item.getDateCreate()+"','"+item.getDateModify() + "','"
                        +item.getDateCancel()+"','"+item.getUserIdCreate() + "','"
                        +item.getUserIdModify()+"','"+item.getUserIdCancel() + "','"
                        +item.getUserNametFoodsOrder()+"','"+item.getUserNametFoodsReceive() + "','"
                        +item.getUserNametNutritionist()+"','"+ item.getUserIdNutritionist()+"','"
                        +item.getBranchId()+"','"+item.getWardNamet()+"','"
                        +item.getFoodsPeriodId()+"',current_time)";
            }
            else{
                max = item.getFoodsOrderId();
//                attend_date=config1.DateFormatShow2DB(itemdetail.getAttendDate(), "ddMMyyyy");
//                wound_care_date=config1.DateFormatShow2DB(itemdetail.getMaDate(), "ddMMyyyy");
                sql = "Update "+foodsorder.getNurseTFoodsOrder()+" set "
                +foodsorder.getFWardId()+" = '"+item.getWardId()+"', "
                +foodsorder.getFFoodsOrderId()+" = '"+item.getFoodsOrderId()+"', "
                +foodsorder.getFFoodsOrderActive()+" = '"+item.getFoodsOrderActive()+"', "
                +foodsorder.getFDateFoodsOrder()+" = '"+item.getDateFoodsOrder()+"', "
                +foodsorder.getFUserIdFoodsOrder()+" = '"+item.getUserIdFoodsOrder()+"', "
                +foodsorder.getFUserIdFoodsReceive()+" = '"+item.getUserIdFoodsReceive()+"', "
                +foodsorder.getFDateCreate()+" = '"+item.getDateCreate()+"', "
                +foodsorder.getFDateModify()+" = '"+item.getDateModify()+"', "
                +foodsorder.getFDateCancel()+" = '"+item.getDateCancel()+"', "
                +foodsorder.getFUserIdCreate()+" = '"+item.getUserIdCreate()+"', "
                +foodsorder.getFUserIdModify()+" = '"+item.getUserIdModify()+"', "
                +foodsorder.getFUserIdCancel()+" = '"+item.getUserIdCancel()+"', "
                +foodsorder.getFUserIdNutritionist()+" = '"+item.getUserIdNutritionist()+"', "
                +foodsorder.getFUserNametFoodsOrder()+" = '"+item.getUserNametFoodsOrder()+"', "
                +foodsorder.getFUserNametFoodsReceive()+" = '"+item.getUserNametFoodsReceive()+"', "
                +foodsorder.getFUserNametNutritionist()+" = '"+item.getUserNametNutritionist()+"', "
                +foodsorder.getFBranchId()+" = '"+item.getBranchId()+"', "
                +foodsorder.getFWardNamet()+" = '"+item.getWardNamet()+"', "
                +foodsorder.getFFoodsPeriod()+" = '"+item.getFoodsPeriodId()+"', "
                +foodsorder.getFTimeFoodsOrder()+" = current_time "
                +"Where "+foodsorder.getFFoodsOrderId()+" = '"+item.getFoodsOrderId()+"'";
//                max = item.getBillLabId();
            }
            chk = st.executeUpdate(sql);
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(NurseTFoodsOrderDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return max;
    }
    public String setSaveFoodsOrderDetail(NurseTFoodsOrderDetail item, String flagpage) throws Exception {
        int chk=0;
        String sql="", ma_date="", attend_date="", max="", pageNumber="", foods_price="", foods_namet="";
//        NurseTFoodsOrderDetail foodsorderdetail = new NurseTFoodsOrderDetail();
        Connection conn;
        Statement st;
        try {
            conn = config1.getConnectionBangna();
            st = conn.createStatement();
            foodsorderdetail = getNurserFoodsOrderDetailByPK(item.getFoodsOrderDetailId());
            item.setPatientFullnamet(item.getPatientFullnamet().replace("'", "''"));
            item.setTypeFoodsNamet(item.getTypeFoodsNamet().replace("'", "''"));
            item.setTypeFoodsNamet(item.getTypeFoodsNamet().replace("/", "-"));
            item.setRemark(item.getRemark().replace("'", "''"));
            foods_namet = item.getTypeFoodsNamet();
            if(foods_namet.indexOf("[")>0){
                foods_price = foods_namet.substring(foods_namet.indexOf("["), foods_namet.length()-1);
                foods_price = foods_price.substring(1, foods_price.length()-1);
//                foods_namet = foods_namet.substring(0, foods_namet.indexOf("["));
            }
            
            if(foodsorderdetail.getFoodsOrderDetailId().equals("")){
                max = getMaxRowFoodsOrderDetail(conn);
                pageNumber = getPageNumberFoodsOrderDetail(conn,item.getFoodsOrderId());
                item.setPageNumber(pageNumber);
                sql="Insert Into "+foodsorderdetail.getNurseTFoodsOrderDetail()+"("
                +foodsorderdetail.getFFoodsOrderDetailId()+", "+foodsorderdetail.getFFoodsOrderId()+", "
                +foodsorderdetail.getFFoodsOrderDetailActive()+","+foodsorderdetail.getFBedId()+","
                +foodsorderdetail.getFPatientFullNamet()+","+ foodsorderdetail.getFPatientHnNo()+","
                +foodsorderdetail.getFRemark()+","+ foodsorderdetail.getFRoomId()+","
                +foodsorderdetail.getFTypeFoodsId()+","+ foodsorderdetail.getFTypeFoodsNamet()+","
                +foodsorderdetail.getFPaidId()+","+ foodsorderdetail.getFPaidNamet()+","
                +foodsorderdetail.getFPageNumber()+","+foodsorderdetail.getFFoodsPrice()+") "
                +"Values('"+max+"','"+item.getFoodsOrderId()+"','"
                +item.getFoodsOrderDetailActice() + "','"+ item.getBedId()+"','"
                +item.getPatientFullnamet() + "','"+ item.getPatientHnNo()+"','"
                +item.getRemark() + "','"+ item.getRoomId()+"','"
                +item.getTypeFoodsId() + "','"+ item.getTypeFoodsNamet()+"','"
                +item.getPaidId() + "','"+ item.getPaidNamet()+"','"
                +item.getPageNumber()+"',"+foods_price+")";
            }
            else{
                max = item.getFoodsOrderDetailId();
                if(item.getPageNumber().equals("")){
                    pageNumber = getPageNumberFoodsOrderDetail(conn,item.getFoodsOrderId());
                    item.setPageNumber(pageNumber);
                    }
//                attend_date=config1.DateFormatShow2DB(itemdetail.getAttendDate(), "ddMMyyyy");
//                wound_care_date=config1.DateFormatShow2DB(itemdetail.getMaDate(), "ddMMyyyy");
                sql = "Update "+foodsorderdetail.getNurseTFoodsOrderDetail()+" set "
                +foodsorderdetail.getFFoodsOrderId()+" = '"+item.getFoodsOrderId()+"', "
                +foodsorderdetail.getFFoodsOrderDetailActive()+" = '"+item.getFoodsOrderDetailActice()+"', "
                +foodsorderdetail.getFBedId()+" = '"+item.getBedId()+"', "
                +foodsorderdetail.getFPatientFullNamet()+" = '"+item.getPatientFullnamet()+"', "
                +foodsorderdetail.getFPatientHnNo()+" = '"+item.getPatientHnNo()+"', "
                +foodsorderdetail.getFRemark()+" = '"+item.getRemark()+"', "
                +foodsorderdetail.getFRoomId()+" = '"+item.getRoomId()+"', "
                +foodsorderdetail.getFTypeFoodsId()+" = '"+item.getTypeFoodsId()+"', "
                +foodsorderdetail.getFTypeFoodsNamet()+" = '"+item.getTypeFoodsNamet()+"', "
                +foodsorderdetail.getFPaidId()+" = '"+item.getPaidId()+"', "
                +foodsorderdetail.getFPaidNamet()+" = '"+item.getPaidNamet()+"', "
                +foodsorderdetail.getFPageNumber()+" = '"+item.getPageNumber()+"', "
                +foodsorderdetail.getFFoodsPrice()+" = "+foods_price+" "
                +"Where "+foodsorderdetail.getFFoodsOrderDetailId()+" = '"+item.getFoodsOrderDetailId()+"'";
//                max = item.getBillLabId();
            }
            chk = st.executeUpdate(sql);
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(NurseTFoodsOrderDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return max;
    }
    public String getTrFoodsOrderDetail(String branch_id,String foods_order_id, String selected){
        String txt="",sql="",tHeader="",tFooder="</table><script type='text/javascript' charset='UTF-8'>$('#txt_foods_order_id').val("+foods_order_id+"); </script>";
        Vector v_foods_order_detail = new Vector();
        tHeader = "<table width='100%' id='trFoodsOrderDetail'><thead><th>ห้อง</th><th>เตียง</th><th>HN NO</th><th>ชื่อผู้ป่วย</th><th width='110'>ประเภทอาหาร</th><th width='80'>หมายเหตุ</th></thead>";
        NurseTFoodsOrderDetail fOd = new NurseTFoodsOrderDetail();
        v_foods_order_detail = getNurserFoodsOrderDetail(branch_id, foods_order_id, "");
        for(int i=0;i<=v_foods_order_detail.size()-1;i++) {
            fOd = (NurseTFoodsOrderDetail) v_foods_order_detail.get(i);
                txt += "<tr  class='style14'><td width='15' align='center'>"+fOd.getRoomId()+"</td>"
                    +"<td width='15' align='center'>"+fOd.getBedId()+"</td>"
                    +"<td width='80' align='center'><A HREF='javascript:setFoodsOrderDetailAdd("
        +fOd.getFoodsOrderDetailId()+")'  >"+fOd.getPatientHnNo()+"</A></td>"
                    +"<td width='200' align='left'>"+fOd.getPatientFullnamet()+"</td>"
                    +"<td width='200' align='left'>"+fOd.getTypeFoodsNamet()+"</td>"
                    +"<td width='180' align='left'>"+fOd.getRemark()+"</td></tr>";
            if(i==4){
                sql="";
            }
        }
        return tHeader+txt+tFooder;
    }
    public String setUpdateFoodOrderDetailVoid(String brnachId,String foodsOrderDetailId){
        Integer chk=0;
        String sql="", ma_date="", attend_date="", max="";
        Connection conn;
        Statement st;
        try {
            conn = config1.getConnectionBangna();
            st = conn.createStatement();

            sql = "Update "+foodsorderdetail.getNurseTFoodsOrderDetail()+" set "+
            foodsorderdetail.getFFoodsOrderDetailActive()+" = '3' "+
            "Where "+foodsorderdetail.getFFoodsOrderDetailId()+" = '"+foodsOrderDetailId+"' ";

            chk = st.executeUpdate(sql);
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(NurseTFoodsOrderDB.class.getName()).log(Level.SEVERE, null, ex);
//            max = ex.getMessage();
        }
        return chk.toString();
    }
    public String setUpdateFoodOrderVoid(String brnachId,String foodsOrderId){
        Integer chk=0;
        String sql="", ma_date="", attend_date="", max="";
        Connection conn;
        Statement st;
        try {
            conn = config1.getConnectionBangna();
            st = conn.createStatement();

            sql = "Update "+foodsorder.getNurseTFoodsOrder()+" set "+
            foodsorder.getFFoodsOrderActive()+" = '3' "+
            "Where "+foodsorder.getFFoodsOrderId()+" = '"+foodsOrderId+"' ";

            chk = st.executeUpdate(sql);
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(NurseTFoodsOrderDB.class.getName()).log(Level.SEVERE, null, ex);
//            max = ex.getMessage();
        }
        return chk.toString();
    }
}
