/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bangnanurse.control;

import bangnaLibrary.*;
import bangnanurse.objdb.NurseTFoodsOrderDB;
import bangnanurse.objdb.RFoodsOrderDB;
import bangnanurse.object.NurseTFoodsOrder;
import bangnanurse.object.NurseTFoodsOrderDetail;
import bangnanurse.object.RFoodsOrder;
import com.bangna.objdb.RStickerDB;
import com.bangna.object.RSticker;
import java.sql.Connection;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author root
 */
public class NurseControl {
    public Config1 config1;
    public NurseTFoodsOrderDB fOdb ;
    NurseTFoodsOrder fO;
    NurseTFoodsOrderDetail fOD;
    RFoodsOrder rFo;
    RFoodsOrderDB rFodb;
    ComboDB combodb;
    TVisitDB visitdb;
    PatientDB patientdb;
    VVisit vVisit;
    public RStickerDB stickerdb;
//    PatientVisit pv = new PatientVisit();
    public NurseControl(){
        config1 = new Config1();
        initConfig(config1);
    }
    public NurseControl(Config1 cf){
        config1 = cf;
        initConfig(config1);
    }
    public void initConfig(Config1 cf){
        fOdb = new NurseTFoodsOrderDB(config1);
        rFodb = new RFoodsOrderDB(cf);
        visitdb = new TVisitDB(cf);
        patientdb = new PatientDB(cf);
        stickerdb = new RStickerDB(config1);
        
        combodb = new ComboDB(cf);
        fO = new NurseTFoodsOrder();
        fOD = new NurseTFoodsOrderDetail();
        rFo = new RFoodsOrder();
        vVisit = new VVisit();
    }
    public String getTrFoodsOrder(String branchId, String dateStart, String dateEnd){
        String text="", dateFO="",row_color="", txt_color="", width_user_order="70", width_nutritition="70";
        String width_date="80", width_ward="70",width_period="100",txt_color1="";
        Vector vFO = new Vector();
        Integer row=0;
        vFO = fOdb.getNurserFoodsOrder(branchId, "date",dateStart,dateEnd);
        for(int i=0;i<=vFO.size()-1;i++) {
            row++;
            fO = (NurseTFoodsOrder)vFO.get(i);
            try {
                dateFO = config1.DateFormatDB2Show(fO.getDateFoodsOrder(), "ddMMyyyy");
                row_color = "";
                text+="<tr class='style14r' "+row_color+"> <td align='center' width='30'>"+row.toString()+"</td>"
                    +"<td width='"+width_date+"'><div align='left'> "+txt_color+dateFO+txt_color1+"</div></td>"
                    +"<td width='"+width_ward+"'>"+txt_color+fO.getTimeFoodsOrder()+txt_color1+"</td>"
                    +"<td width='"+width_ward+"'>"+txt_color+fO.getWardNamet()+txt_color1+"</td>"
                    +"<td width='"+width_period+"'><A HREF='nurse_foods_order_add.jsp?txt_foods_order_id="+fO.getFoodsOrderId()
                    +"&flagpage=viewdetail' name='nurse_foods_order_add' id='nurse_foods_order_add'>"
                        +txt_color+fO.getFoodsPeriodNamet()+" ["+fO.getFoodsOrderId()+"]"
                        +txt_color1+"</a></td>"
                    +"<td width='"+width_user_order+"'>"+txt_color+fO.getUserNametFoodsOrder()+txt_color1+"</td>"
                    +"<td width='"+width_nutritition+"'>"+txt_color+fO.getUserNametNutritionist()+txt_color1+"</td>"
                    +"</tr>";
            } catch (Exception ex) {
                Logger.getLogger(NurseControl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return text;
    }
    public void voidFoodsOrderDetail(String branchId, String foodsOrderDetailId){
        fOdb.setUpdateFoodOrderDetailVoid(branchId, foodsOrderDetailId);
    }
    public void voidFoodsOrder(String branchId, String foodsOrderId){
        fOdb.setUpdateFoodOrderVoid(branchId, foodsOrderId);
    }
    public String setRFoodsOrder(String branchId, String dateStart, String dateEnd){
        String chk="", rFOId="", dateCurrent="",dateCurrent1="";
        Integer cntDate=0;
        Vector vFO = new Vector();
        Vector vFOD = new Vector();
        Vector vRO = new Vector();
        TypeFoods typefoods = new TypeFoods();
        vFO = combodb.getTypeFoods(branchId);
        cntDate = Math.abs(Integer.parseInt(config1.getDateDiffN1(dateEnd, dateStart)));
        cntDate++;
        try {
            rFodb.deleteAll();
            for(int i=0;i<cntDate;i++){
                if(i==0) dateCurrent = dateStart;
                else dateCurrent = config1.getDateAdd(dateCurrent, "1");
                if(dateCurrent.length()>10) dateCurrent = dateCurrent.substring(0, 10);
                dateCurrent1 = config1.DateFormatShow2DB(config1.DateFormatDB2ShowHospital(dateCurrent, "ddMMyyyy"),"ddMMyyyy");
                rFo = new RFoodsOrder();
                rFo.dateFoodsOrder = dateCurrent;
                rFo.branchId = branchId;
                rFOId = rFodb.insert(branchId, rFo);
            }
            vRO = rFodb.selectAll();
            for(int k=0;k<vFO.size();k++){
                String aaa = "name"+(k+1);
                typefoods = (TypeFoods)vFO.get(k);
                if(typefoods.type_foods_namet.equals("����öҴ���")){
                    typefoods.type_foods_namet = "Ͷ ���";
                }else if(typefoods.type_foods_namet.equals("���������ҧ - ����")){
                    typefoods.type_foods_namet = "��� ����";
                }else if(typefoods.type_foods_namet.equals("��������ǻ��.")){
                    typefoods.type_foods_namet = "�� ���";
                }else if(typefoods.type_foods_namet.equals("����þ���ɻ��")){
                    typefoods.type_foods_namet = "; ���";
                }else if(typefoods.type_foods_namet.equals("����öҴ�����")){
                    typefoods.type_foods_namet = "Ͷ �����";
                }else if(typefoods.type_foods_namet.equals("����þ���ɷ����")){
                    typefoods.type_foods_namet = "; �����";
                }else if(typefoods.type_foods_namet.equals("����öҴ��� (ICU)-����")){
                    typefoods.type_foods_namet = "Ͷ� icu����";
                }else if(typefoods.type_foods_namet.equals("���������ҧ ICU - 100 �ҷ")){
                    typefoods.type_foods_namet = "��� icu100";
                }
                rFodb.updateRFoodsOrderName(branchId,typefoods.type_foods_namet,aaa);
            }
            for(int i=0;i<vRO.size();i++){
                rFo = (RFoodsOrder)vRO.get(i);
                for(int j=0;j<vFO.size();j++){
                    typefoods = (TypeFoods)vFO.get(j);
                    fOD = fOdb.getNurserFoodsOrderDetailSum(branchId, typefoods.type_foods_id, rFo.dateFoodsOrder, "date_foods_order");
                    if(typefoods.foods_price.equals("")) typefoods.foods_price="0.1";
                    if(fOD.remark.equals("")) continue;
                    if(j==0){
                        rFodb.updateRFoodsOrder1(branchId, rFo.getObjectId(), typefoods.type_foods_namet,typefoods.foods_price, String.valueOf(Integer.parseInt(typefoods.foods_price)*Integer.parseInt(fOD.remark)), fOD.remark);
                    }else if(j==1){
                        rFodb.updateRFoodsOrder2(branchId, rFo.getObjectId(), typefoods.type_foods_namet, typefoods.foods_price, String.valueOf(Integer.parseInt(typefoods.foods_price)*Integer.parseInt(fOD.remark)), fOD.remark);
                    }else if(j==2){
                        rFodb.updateRFoodsOrder3(branchId, rFo.getObjectId(), typefoods.type_foods_namet, typefoods.foods_price, String.valueOf(Integer.parseInt(typefoods.foods_price)*Integer.parseInt(fOD.remark)), fOD.remark);
                    }else if(j==3){
                        rFodb.updateRFoodsOrder4(branchId, rFo.getObjectId(), typefoods.type_foods_namet, typefoods.foods_price, String.valueOf(Integer.parseInt(typefoods.foods_price)*Integer.parseInt(fOD.remark)), fOD.remark);
                    }else if(j==4){
                        rFodb.updateRFoodsOrder5(branchId, rFo.getObjectId(), typefoods.type_foods_namet, typefoods.foods_price, String.valueOf(Integer.parseInt(typefoods.foods_price)*Integer.parseInt(fOD.remark)), fOD.remark);
                    }else if(j==5){
                        rFodb.updateRFoodsOrder6(branchId, rFo.getObjectId(), typefoods.type_foods_namet, typefoods.foods_price, String.valueOf(Integer.parseInt(typefoods.foods_price)*Integer.parseInt(fOD.remark)), fOD.remark);
                    }else if(j==6){
                        rFodb.updateRFoodsOrder7(branchId, rFo.getObjectId(), typefoods.type_foods_namet, typefoods.foods_price, String.valueOf(Integer.parseInt(typefoods.foods_price)*Integer.parseInt(fOD.remark)), fOD.remark);
                    }else if(j==7){
                        rFodb.updateRFoodsOrder8(branchId, rFo.getObjectId(), typefoods.type_foods_namet, typefoods.foods_price, String.valueOf(Integer.parseInt(typefoods.foods_price)*Integer.parseInt(fOD.remark)), fOD.remark);
                    }else if(j==8){
                        rFodb.updateRFoodsOrder9(branchId, rFo.getObjectId(), typefoods.type_foods_namet, typefoods.foods_price, String.valueOf(Integer.parseInt(typefoods.foods_price)*Integer.parseInt(fOD.remark)), fOD.remark);
                    }else if(j==9){
                        rFodb.updateRFoodsOrder10(branchId, rFo.getObjectId(), typefoods.type_foods_namet, typefoods.foods_price, String.valueOf(Integer.parseInt(typefoods.foods_price)*Integer.parseInt(fOD.remark)), fOD.remark);
                    }else if(j==10){
                        rFodb.updateRFoodsOrder11(branchId, rFo.getObjectId(), typefoods.type_foods_namet, typefoods.foods_price, String.valueOf(Integer.parseInt(typefoods.foods_price)*Integer.parseInt(fOD.remark)), fOD.remark);
                    }else if(j==11){
                        rFodb.updateRFoodsOrder12(branchId, rFo.getObjectId(), typefoods.type_foods_namet, typefoods.foods_price, String.valueOf(Integer.parseInt(typefoods.foods_price)*Integer.parseInt(fOD.remark)), fOD.remark);
                    }else if(j==12){
                        rFodb.updateRFoodsOrder13(branchId, rFo.getObjectId(), typefoods.type_foods_namet, typefoods.foods_price, String.valueOf(Integer.parseInt(typefoods.foods_price)*Integer.parseInt(fOD.remark)), fOD.remark);
                    }else if(j==13){
                        rFodb.updateRFoodsOrder14(branchId, rFo.getObjectId(), typefoods.type_foods_namet, typefoods.foods_price, String.valueOf(Integer.parseInt(typefoods.foods_price)*Integer.parseInt(fOD.remark)), fOD.remark);
                    }else if(j==14){
                        rFodb.updateRFoodsOrder15(branchId, rFo.getObjectId(), typefoods.type_foods_namet, typefoods.foods_price, String.valueOf(Integer.parseInt(typefoods.foods_price)*Integer.parseInt(fOD.remark)), fOD.remark);
                    }
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(NurseControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return chk;
    }
    public String getTrPatientAdmit(String branchId){
        String tHeader="", tFooder="</table>",patientFullName="", visitHn="", chkPrint="", txtVisitPrint="", txtrowCnt="", txtVisitVnPrint="";
        Integer i=0;
        Vector v = new Vector();
        StringBuilder text = new StringBuilder();
        tHeader = "<table><tr><th>�ӴѺ</th><th>����-���ʡ��</th><th>����</th><th>��</th><th>HN</th><th>AN</th>";
        v = visitdb.getVVisit(branchId, "", "", "", "", "", "", "admit");
        for(i=0;i<v.size();i++){
            vVisit = (VVisit)v.get(i);
            visitHn = vVisit.getVisitHn();
            chkPrint="<input type='checkbox' id='chkPrint"+i+"' onClick='chkEnable("+i+")'>";
            txtVisitPrint = "<input type='hidden' id='txtVisitPrint"+i+"' value='0'>";
            txtVisitVnPrint = "<input type='hidden' id='txtVisitVnPrint"+i+"' value='"+vVisit.getVisitVn()+"'>";
            patientFullName = "<label>"+chkPrint+vVisit.getPatientPrefixDescription()+" "+ vVisit.getPatientFirstname()+" "+vVisit.getPatientLastname()+"</label>";
            text.append("<tr><td>").append(i+1).append("</td><td>").append(patientFullName).append(txtVisitPrint).append(txtVisitVnPrint).append("</td><td>")
                .append(vVisit.visitAge).append("</td><td>").append(vVisit.sex).append("</td><td>")
                .append(vVisit.getVisitHn()).append("</td><td>").append(vVisit.getVisitVn()).append("</td></tr>");
        }
        txtrowCnt = "<input type='hidden' id='txtRowCnt' value='"+i+"' >";
        return tHeader+text.toString()+tFooder+txtrowCnt;
    }
    public String getAutoSearch(String branchId,String searchHn, String flag){
        return patientdb.getAutoSearch(branchId, searchHn, flag);
    }
    public void setPrintSticker(String branchId, String visitHn){
        Integer rowNum=0;
        String patientFullName="", visitVn="";
//        stickerdb.delete();
        String[] arrayVisitHn = visitHn.split("@");
        RSticker sticker = new RSticker();
        Vector v = new Vector();
        Connection conn;
        try {
            conn = config1.getConnectionBangna();
            Statement st = conn.createStatement();
            stickerdb.delete();
            for(int i=0;i<arrayVisitHn.length;i++){
                if(!arrayVisitHn[i].equals(""))
                    visitVn += "'"+arrayVisitHn[i]+"',";
            }
            if(visitVn.substring(visitVn.length()-1).equals(","))
                visitVn = visitVn.substring(0,visitVn.length()-1);
            v = visitdb.getVVisit(branchId, "", "", "", "", visitVn, "", "search_vn");
            for(int i=0;i<v.size();i++){
                vVisit = (VVisit)v.get(i);
                sticker = new RSticker();
                patientFullName = vVisit.getPatientPrefixDescription()+" "+ vVisit.getPatientFirstname()+" "+vVisit.getPatientLastname();
                sticker.stickerNo = config1.IntegerFormat(i);
                sticker.stickerName = patientFullName;
                sticker.visitAge = vVisit.visitAge;
                sticker.visitHn = vVisit.visitHn;
                sticker.visitVn = vVisit.visitVn;
                sticker.visitWardName = vVisit.visitWardName;
                sticker.contractPlansDescription = vVisit.contractPlansDescription;
                sticker.visitBed = vVisit.getVisitBed();
                sticker.sort1 = String.valueOf(i);
                stickerdb.insert(st,sticker);
            }
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(NurseControl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
//    public PatientVisit getVisitRoomBed(String branchId, String hnNo){
        
//        return pv;
//    }
}
