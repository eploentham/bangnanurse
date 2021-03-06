/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bangnanurse.objdb;

import bangnaLibrary.Config1;
import bangnanurse.object.RFoodsOrder;
import com.bangna.usecase.connection.ConnectionDBMgr;
import com.bangna.usecase.connection.ConnectionInf;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author root
 */
public class RFoodsOrderDB {
    Config1 config1;
    public RFoodsOrder rFoodsOrder, dbObj;
    final private String idtable = "223";
    public ConnectionInf theConnectionInf;
    public RFoodsOrderDB(){
        config1 = new Config1();
        initConfig(config1);
    }
    public RFoodsOrderDB(Config1 cf){
        config1 = cf;
        initConfig(cf);
    }
    public void initConfig(Config1 cf){
        rFoodsOrder = new RFoodsOrder();
        theConnectionInf = new ConnectionDBMgr(config1.host,config1.database, config1.userDB,config1.passDB);
        dbObj = new RFoodsOrder();
        dbObj.branchId="branch_id";
        dbObj.dateFoodsOrder="date_foods_order";
        
        dbObj.bItemId1="b_item_id1";
        dbObj.itemName1="item_name1";
        dbObj.itemPrice1="item_price1";
        dbObj.itemQty1="item_qty1";
        dbObj.itemTotal1="item_total1";

        dbObj.bItemId2="b_item_id2";
        dbObj.itemName2="item_name2";
        dbObj.itemPrice2="item_price2";
        dbObj.itemQty2="item_qty2";
        dbObj.itemTotal2="item_total2";
        
        dbObj.bItemId3="b_item_id3";
        dbObj.itemName3="item_name3";
        dbObj.itemPrice3="item_price3";
        dbObj.itemQty3="item_qty3";
        dbObj.itemTotal3="item_total3";
        
        dbObj.bItemId4="b_item_id4";
        dbObj.itemName4="item_name4";
        dbObj.itemPrice4="item_price4";
        dbObj.itemQty4="item_qty4";
        dbObj.itemTotal4="item_total4";
        
        dbObj.bItemId5="b_item_id5";
        dbObj.itemName5="item_name5";
        dbObj.itemPrice5="item_price5";
        dbObj.itemQty5="item_qty5";
        dbObj.itemTotal5="item_total5";
        
        dbObj.bItemId6="b_item_id6";
        dbObj.itemName6="item_name6";
        dbObj.itemPrice6="item_price6";
        dbObj.itemQty6="item_qty6";
        dbObj.itemTotal6="item_total6";
        
        dbObj.bItemId7="b_item_id7";
        dbObj.itemName7="item_name7";
        dbObj.itemPrice7="item_price7";
        dbObj.itemQty7="item_qty7";
        dbObj.itemTotal7="item_total7";
        
        dbObj.bItemId8="b_item_id8";
        dbObj.itemName8="item_name8";
        dbObj.itemPrice8="item_price8";
        dbObj.itemQty8="item_qty8";
        dbObj.itemTotal8="item_total8";
        
        dbObj.bItemId9="b_item_id9";
        dbObj.itemName9="item_name9";
        dbObj.itemPrice9="item_price9";
        dbObj.itemQty9="item_qty9";
        dbObj.itemTotal9="item_total9";
        
        dbObj.bItemId10="b_item_id10";
        dbObj.itemName10="item_name10";
        dbObj.itemPrice10="item_price10";
        dbObj.itemQty10="item_qty10";
        dbObj.itemTotal10="item_total10";
        
        dbObj.bItemId11="b_item_id11";
        dbObj.itemName11="item_name11";
        dbObj.itemPrice11="item_price11";
        dbObj.itemQty11="item_qty11";
        dbObj.itemTotal11="item_total11";
        
        dbObj.bItemId12="b_item_id12";
        dbObj.itemName12="item_name12";
        dbObj.itemPrice12="item_price12";
        dbObj.itemQty12="item_qty12";
        dbObj.itemTotal12="item_total12";
        
        dbObj.bItemId13="b_item_id13";
        dbObj.itemName13="item_name13";
        dbObj.itemPrice13="item_price13";
        dbObj.itemQty13="item_qty13";
        dbObj.itemTotal13="item_total13";
        
        dbObj.bItemId14="b_item_id14";
        dbObj.itemName14="item_name14";
        dbObj.itemPrice14="item_price14";
        dbObj.itemQty14="item_qty14";
        dbObj.itemTotal14="item_total14";

        dbObj.bItemId15="b_item_id15";
        dbObj.itemName15="item_name15";
        dbObj.itemPrice15="item_price15";
        dbObj.itemQty15="item_qty15";
        dbObj.itemTotal15="item_total15";
        
        dbObj.rFoodsOrderId="r_foods_order_id";
        dbObj.pk_field="r_foods_order_id";
        dbObj.table="r_foods_order";
    }
    public String insert(String branchId, RFoodsOrder item){
        String chk="";
//        Connection conn;
        StringBuilder sql = new StringBuilder();
        item.generateOID(idtable);
        sql.append("Insert Into ").append(dbObj.table).append("(").append(dbObj.pk_field).append(",").append(dbObj.dateFoodsOrder).append(",")
                .append(dbObj.branchId).append(") ")
                .append("Values ('").append(item.getObjectId()).append("','").append(item.dateFoodsOrder).append("','")
                .append(item.branchId).append("')");
        try{
//            conn = config1.getConnectionBangna();
//            Statement st = conn.createStatement();
            if(theConnectionInf.eUpdate(sql.toString())>0) chk = item.getObjectId();
        }catch(Exception ex){
            Logger.getLogger(RFoodsOrderDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return chk.toString();
    }
    public String updateRFoodsOrderName(String branchId, String itemName, String flag){
        Integer chk=0;
//        Connection conn;
        StringBuilder sql = new StringBuilder();
        if(flag.equals("name1")){//�
            sql.append("Update ").append(dbObj.table).append(" Set ")
            .append(dbObj.itemName1).append(" = '").append(itemName).append("' ");
        }else if(flag.equals("name2"))
            sql.append("Update ").append(dbObj.table).append(" Set ")
            .append(dbObj.itemName2).append(" = '").append(itemName).append("' ");
        else if(flag.equals("name3"))
            sql.append("Update ").append(dbObj.table).append(" Set ")
            .append(dbObj.itemName3).append(" = '").append(itemName).append("' ");
        else if(flag.equals("name4"))
            sql.append("Update ").append(dbObj.table).append(" Set ")
            .append(dbObj.itemName4).append(" = '").append(itemName).append("' ");
        else if(flag.equals("name5"))
            sql.append("Update ").append(dbObj.table).append(" Set ")
            .append(dbObj.itemName5).append(" = '").append(itemName).append("' ");
        else if(flag.equals("name6"))
            sql.append("Update ").append(dbObj.table).append(" Set ")
            .append(dbObj.itemName6).append(" = '").append(itemName).append("' ");
        else if(flag.equals("name7"))
            sql.append("Update ").append(dbObj.table).append(" Set ")
            .append(dbObj.itemName7).append(" = '").append(itemName).append("' ");
        else if(flag.equals("name8"))
            sql.append("Update ").append(dbObj.table).append(" Set ")
            .append(dbObj.itemName8).append(" = '").append(itemName).append("' ");
        else if(flag.equals("name9"))
            sql.append("Update ").append(dbObj.table).append(" Set ")
            .append(dbObj.itemName9).append(" = '").append(itemName).append("' ");
        else if(flag.equals("name10"))
            sql.append("Update ").append(dbObj.table).append(" Set ")
            .append(dbObj.itemName10).append(" = '").append(itemName).append("' ");
        else if(flag.equals("name11"))
            sql.append("Update ").append(dbObj.table).append(" Set ")
            .append(dbObj.itemName11).append(" = '").append(itemName).append("' ");
        else if(flag.equals("name12"))
            sql.append("Update ").append(dbObj.table).append(" Set ")
            .append(dbObj.itemName12).append(" = '").append(itemName).append("' ");
        else if(flag.equals("name13"))
            sql.append("Update ").append(dbObj.table).append(" Set ")
            .append(dbObj.itemName13).append(" = '").append(itemName).append("' ");
        else if(flag.equals("name14"))
            sql.append("Update ").append(dbObj.table).append(" Set ")
            .append(dbObj.itemName14).append(" = '").append(itemName).append("' ");
        else if(flag.equals("name15"))
            sql.append("Update ").append(dbObj.table).append(" Set ")
            .append(dbObj.itemName15).append(" = '").append(itemName).append("' ");
        try{
            chk = theConnectionInf.eUpdate(sql.toString());
        }catch(Exception ex){
            Logger.getLogger(RFoodsOrderDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return chk.toString();
    }
    public String updateRFoodsOrder1(String branchId, String rFOId, String itemName1, String itemPrice1, String itemTotal1, String itemQty1){
        Integer chk=0;
//        Connection conn;
        StringBuilder sql = new StringBuilder();
        sql.append("Update ").append(dbObj.table).append(" Set ")
                .append(dbObj.itemName1).append(" = '").append(itemName1).append("',")
                .append(dbObj.itemPrice1).append(" = '").append(itemPrice1).append("',")
                .append(dbObj.itemTotal1).append(" = '").append(itemTotal1).append("', ")
                .append(dbObj.itemQty1).append(" = ").append(dbObj.itemQty1).append("+").append(itemQty1).append(" ")
                .append("Where ").append(dbObj.pk_field).append(" = '").append(rFOId).append("'");
        try{
            chk = theConnectionInf.eUpdate(sql.toString());
        }catch(Exception ex){
            Logger.getLogger(RFoodsOrderDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return chk.toString();
    }
    public String updateRFoodsOrder2(String branchId, String rFOId, String itemName2, String itemPrice2, String itemTotal2, String itemQty2){
        Integer chk=0;
//        Connection conn;
        StringBuilder sql = new StringBuilder();
        sql.append("Update ").append(dbObj.table).append(" Set ")
                .append(dbObj.itemName2).append(" = '").append(itemName2).append("',")
                .append(dbObj.itemPrice2).append(" = '").append(itemPrice2).append("',")
                .append(dbObj.itemTotal2).append(" = '").append(itemTotal2).append("', ")
                .append(dbObj.itemQty2).append(" = ").append(dbObj.itemQty2).append("+").append(itemQty2).append(" ")
                .append("Where ").append(dbObj.pk_field).append(" = '").append(rFOId).append("'");
        try{
            chk = theConnectionInf.eUpdate(sql.toString());
        }catch(Exception ex){
            Logger.getLogger(RFoodsOrderDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return chk.toString();
    }
    public String updateRFoodsOrder3(String branchId, String rFOId, String itemName3, String itemPrice3, String itemTotal3, String itemQty3){
        Integer chk=0;
//        Connection conn;
        StringBuilder sql = new StringBuilder();
        sql.append("Update ").append(dbObj.table).append(" Set ")
                .append(dbObj.itemName3).append(" = '").append(itemName3).append("',")
                .append(dbObj.itemPrice3).append(" = '").append(itemPrice3).append("',")
                .append(dbObj.itemTotal3).append(" = '").append(itemTotal3).append("', ")
                .append(dbObj.itemQty3).append(" = ").append(dbObj.itemQty3).append("+").append(itemQty3).append(" ")
                .append("Where ").append(dbObj.pk_field).append(" = '").append(rFOId).append("'");
        try{
            chk = theConnectionInf.eUpdate(sql.toString());
        }catch(Exception ex){
            Logger.getLogger(RFoodsOrderDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return chk.toString();
    }
    public String updateRFoodsOrder4(String branchId, String rFOId, String itemName4, String itemPrice4, String itemTotal4, String itemQty4){
        Integer chk=0;
//        Connection conn;
        StringBuilder sql = new StringBuilder();
        sql.append("Update ").append(dbObj.table).append(" Set ")
                .append(dbObj.itemName4).append(" = '").append(itemName4).append("',")
                .append(dbObj.itemPrice4).append(" = '").append(itemPrice4).append("',")
                .append(dbObj.itemTotal4).append(" = '").append(itemTotal4).append("', ")
                .append(dbObj.itemQty4).append(" = ").append(dbObj.itemQty4).append("+").append(itemQty4).append(" ")
                .append("Where ").append(dbObj.pk_field).append(" = '").append(rFOId).append("'");
        try{
            chk = theConnectionInf.eUpdate(sql.toString());
        }catch(Exception ex){
            Logger.getLogger(RFoodsOrderDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return chk.toString();
    }
    public String updateRFoodsOrder5(String branchId, String rFOId, String itemName5, String itemPrice5, String itemTotal5, String itemQty5){
        Integer chk=0;
//        Connection conn;
        StringBuilder sql = new StringBuilder();
        sql.append("Update ").append(dbObj.table).append(" Set ")
                .append(dbObj.itemName5).append(" = '").append(itemName5).append("',")
                .append(dbObj.itemPrice5).append(" = '").append(itemPrice5).append("',")
                .append(dbObj.itemTotal5).append(" = '").append(itemTotal5).append("', ")
                .append(dbObj.itemQty5).append(" = ").append(dbObj.itemQty5).append("+").append(itemQty5).append(" ")
                .append("Where ").append(dbObj.pk_field).append(" = '").append(rFOId).append("'");
        try{
            chk = theConnectionInf.eUpdate(sql.toString());
        }catch(Exception ex){
            Logger.getLogger(RFoodsOrderDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return chk.toString();
    }
    public String updateRFoodsOrder6(String branchId, String rFOId, String itemName6, String itemPrice6, String itemTotal6, String itemQty6){
        Integer chk=0;
//        Connection conn;
        StringBuilder sql = new StringBuilder();
        sql.append("Update ").append(dbObj.table).append(" Set ")
                .append(dbObj.itemName6).append(" = '").append(itemName6).append("',")
                .append(dbObj.itemPrice6).append(" = '").append(itemPrice6).append("',")
                .append(dbObj.itemTotal6).append(" = '").append(itemTotal6).append("', ")
                .append(dbObj.itemQty6).append(" = ").append(dbObj.itemQty6).append("+").append(itemQty6).append(" ")
                .append("Where ").append(dbObj.pk_field).append(" = '").append(rFOId).append("'");
        try{
            chk = theConnectionInf.eUpdate(sql.toString());
        }catch(Exception ex){
            Logger.getLogger(RFoodsOrderDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return chk.toString();
    }
    public String updateRFoodsOrder7(String branchId, String rFOId, String itemName7, String itemPrice7, String itemTotal7, String itemQty7){
        Integer chk=0;
//        Connection conn;
        StringBuilder sql = new StringBuilder();
        sql.append("Update ").append(dbObj.table).append(" Set ")
                .append(dbObj.itemName7).append(" = '").append(itemName7).append("',")
                .append(dbObj.itemPrice7).append(" = '").append(itemPrice7).append("',")
                .append(dbObj.itemTotal7).append(" = '").append(itemTotal7).append("', ")
                .append(dbObj.itemQty7).append(" = ").append(dbObj.itemQty7).append("+").append(itemQty7).append(" ")
                .append("Where ").append(dbObj.pk_field).append(" = '").append(rFOId).append("'");
        try{
            chk = theConnectionInf.eUpdate(sql.toString());
        }catch(Exception ex){
            Logger.getLogger(RFoodsOrderDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return chk.toString();
    }
    public String updateRFoodsOrder8(String branchId, String rFOId, String itemName8, String itemPrice8, String itemTotal8, String itemQty8){
        Integer chk=0;
//        Connection conn;
        StringBuilder sql = new StringBuilder();
        sql.append("Update ").append(dbObj.table).append(" Set ")
                .append(dbObj.itemName8).append(" = '").append(itemName8).append("',")
                .append(dbObj.itemPrice8).append(" = '").append(itemPrice8).append("',")
                .append(dbObj.itemTotal8).append(" = '").append(itemTotal8).append("', ")
                .append(dbObj.itemQty8).append(" = ").append(dbObj.itemQty8).append("+").append(itemQty8).append(" ")
                .append("Where ").append(dbObj.pk_field).append(" = '").append(rFOId).append("'");
        try{
            chk = theConnectionInf.eUpdate(sql.toString());
        }catch(Exception ex){
            Logger.getLogger(RFoodsOrderDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return chk.toString();
    }
    public String updateRFoodsOrder9(String branchId, String rFOId, String itemName9, String itemPrice9, String itemTotal9, String itemQty9){
        Integer chk=0;
//        Connection conn;
        StringBuilder sql = new StringBuilder();
        sql.append("Update ").append(dbObj.table).append(" Set ")
                .append(dbObj.itemName9).append(" = '").append(itemName9).append("',")
                .append(dbObj.itemPrice9).append(" = '").append(itemPrice9).append("',")
                .append(dbObj.itemTotal9).append(" = '").append(itemTotal9).append("', ")
                .append(dbObj.itemQty9).append(" = ").append(dbObj.itemQty9).append("+").append(itemQty9).append(" ")
                .append("Where ").append(dbObj.pk_field).append(" = '").append(rFOId).append("'");
        try{
            chk = theConnectionInf.eUpdate(sql.toString());
        }catch(Exception ex){
            Logger.getLogger(RFoodsOrderDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return chk.toString();
    }
    public String updateRFoodsOrder10(String branchId, String rFOId, String itemName10, String itemPrice10, String itemTotal10, String itemQty10){
        Integer chk=0;
//        Connection conn;
        StringBuilder sql = new StringBuilder();
        sql.append("Update ").append(dbObj.table).append(" Set ")
                .append(dbObj.itemName10).append(" = '").append(itemName10).append("',")
                .append(dbObj.itemPrice10).append(" = '").append(itemPrice10).append("',")
                .append(dbObj.itemTotal10).append(" = '").append(itemTotal10).append("', ")
                .append(dbObj.itemQty10).append(" = ").append(dbObj.itemQty10).append("+").append(itemQty10).append(" ")
                .append("Where ").append(dbObj.pk_field).append(" = '").append(rFOId).append("'");
        try{
            chk = theConnectionInf.eUpdate(sql.toString());
        }catch(Exception ex){
            Logger.getLogger(RFoodsOrderDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return chk.toString();
    }
    public String updateRFoodsOrder11(String branchId, String rFOId, String itemName10, String itemPrice10, String itemTotal10, String itemQty10){
        Integer chk=0;
//        Connection conn;
        StringBuilder sql = new StringBuilder();
        sql.append("Update ").append(dbObj.table).append(" Set ")
                .append(dbObj.itemName11).append(" = '").append(itemName10).append("',")
                .append(dbObj.itemPrice11).append(" = '").append(itemPrice10).append("',")
                .append(dbObj.itemTotal11).append(" = '").append(itemTotal10).append("', ")
                .append(dbObj.itemQty11).append(" = ").append(dbObj.itemQty11).append("+").append(itemQty10).append(" ")
                .append("Where ").append(dbObj.pk_field).append(" = '").append(rFOId).append("'");
        try{
            chk = theConnectionInf.eUpdate(sql.toString());
        }catch(Exception ex){
            Logger.getLogger(RFoodsOrderDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return chk.toString();
    }
    public String updateRFoodsOrder12(String branchId, String rFOId, String itemName10, String itemPrice10, String itemTotal10, String itemQty10){
        Integer chk=0;
//        Connection conn;
        StringBuilder sql = new StringBuilder();
        sql.append("Update ").append(dbObj.table).append(" Set ")
                .append(dbObj.itemName12).append(" = '").append(itemName10).append("',")
                .append(dbObj.itemPrice12).append(" = '").append(itemPrice10).append("',")
                .append(dbObj.itemTotal12).append(" = '").append(itemTotal10).append("', ")
                .append(dbObj.itemQty12).append(" = ").append(dbObj.itemQty12).append("+").append(itemQty10).append(" ")
                .append("Where ").append(dbObj.pk_field).append(" = '").append(rFOId).append("'");
        try{
            chk = theConnectionInf.eUpdate(sql.toString());
        }catch(Exception ex){
            Logger.getLogger(RFoodsOrderDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return chk.toString();
    }
    public String updateRFoodsOrder13(String branchId, String rFOId, String itemName10, String itemPrice10, String itemTotal10, String itemQty10){
        Integer chk=0;
//        Connection conn;
        StringBuilder sql = new StringBuilder();
        sql.append("Update ").append(dbObj.table).append(" Set ")
                .append(dbObj.itemName13).append(" = '").append(itemName10).append("',")
                .append(dbObj.itemPrice13).append(" = '").append(itemPrice10).append("',")
                .append(dbObj.itemTotal13).append(" = '").append(itemTotal10).append("', ")
                .append(dbObj.itemQty13).append(" = ").append(dbObj.itemQty13).append("+").append(itemQty10).append(" ")
                .append("Where ").append(dbObj.pk_field).append(" = '").append(rFOId).append("'");
        try{
            chk = theConnectionInf.eUpdate(sql.toString());
        }catch(Exception ex){
            Logger.getLogger(RFoodsOrderDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return chk.toString();
    }
    public String updateRFoodsOrder14(String branchId, String rFOId, String itemName10, String itemPrice10, String itemTotal10, String itemQty10){
        Integer chk=0;
//        Connection conn;
        StringBuilder sql = new StringBuilder();
        sql.append("Update ").append(dbObj.table).append(" Set ")
                .append(dbObj.itemName14).append(" = '").append(itemName10).append("',")
                .append(dbObj.itemPrice14).append(" = '").append(itemPrice10).append("',")
                .append(dbObj.itemTotal14).append(" = '").append(itemTotal10).append("', ")
                .append(dbObj.itemQty14).append(" = ").append(dbObj.itemQty14).append("+").append(itemQty10).append(" ")
                .append("Where ").append(dbObj.pk_field).append(" = '").append(rFOId).append("'");
        try{
            chk = theConnectionInf.eUpdate(sql.toString());
        }catch(Exception ex){
            Logger.getLogger(RFoodsOrderDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return chk.toString();
    }
    public String updateRFoodsOrder15(String branchId, String rFOId, String itemName10, String itemPrice10, String itemTotal10, String itemQty10){
        Integer chk=0;
//        Connection conn;
        StringBuilder sql = new StringBuilder();
        sql.append("Update ").append(dbObj.table).append(" Set ")
                .append(dbObj.itemName15).append(" = '").append(itemName10).append("',")
                .append(dbObj.itemPrice15).append(" = '").append(itemPrice10).append("',")
                .append(dbObj.itemTotal15).append(" = '").append(itemTotal10).append("', ")
                .append(dbObj.itemQty15).append(" = ").append(dbObj.itemQty15).append("+").append(itemQty10).append(" ")
                .append("Where ").append(dbObj.pk_field).append(" = '").append(rFOId).append("'");
        try{
            chk = theConnectionInf.eUpdate(sql.toString());
        }catch(Exception ex){
            Logger.getLogger(RFoodsOrderDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return chk.toString();
    }
    public Vector eQuery(String sql){
        Vector list = new Vector();
        RFoodsOrder p;
        try {
            ResultSet rs = theConnectionInf.eQuery(sql);
            while(rs.next()){
                p = new RFoodsOrder();
                p.setObjectId(rs.getString(dbObj.pk_field));
                p.dateFoodsOrder = rs.getString(dbObj.dateFoodsOrder);
//                p.bItemId1 = rs.getString(dbObj.bItemId1);
//                p.branchId = rs.getString(dbObj.branchId);
//                p.itemName1 = rs.getString(dbObj.itemName1);
//                p.itemPrice1 = rs.getString(dbObj.itemPrice1);
//                p.itemQty1 = rs.getString(dbObj.itemQty1);
//                p.itemTotal1 = rs.getString(dbObj.itemTotal1);
                list.add(p);
            }
            rs.close();
        } catch (Exception ex) {
            Logger.getLogger(RFoodsOrderDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    public void deleteAll() throws Exception{
        StringBuilder sql = new StringBuilder();
        sql.append("Delete From ").append(dbObj.table).append(" ");
        theConnectionInf.eUpdate(sql.toString());
    }
    public Vector selectByPk(String pk)throws Exception{
        Vector v = new Vector();
        StringBuilder sql = new StringBuilder();
        sql.append("Select * From ").append(dbObj.table).append(" Where ").append(dbObj.pk_field).append(" = '").append(pk).append("'");
        v = eQuery(sql.toString());
        return v;
    }
    public Vector selectAll()throws Exception{
        Vector v = new Vector();
        StringBuilder sql = new StringBuilder();
        sql.append("Select * From ").append(dbObj.table).append(" Order By ").append(dbObj.dateFoodsOrder);
        v = eQuery(sql.toString());
        return v;
    }
}
