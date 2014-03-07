/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bangnanurse.control;

import bangnaLibrary.Config1;
import bangnanurse.objdb.OpdTMedicalCertCompanyDB;
import bangnanurse.object.OpdTMedicalCertCompany;
import com.bangna.control.BangnaLogControl;
import java.util.Vector;

/**
 *
 * @author root
 */
public class MedicalCertControl {
    public Config1 config1;
    OpdTMedicalCertCompany mcc;
    OpdTMedicalCertCompanyDB mccdb;
    public BangnaLogControl blc;
    public MedicalCertControl(){
        config1 = new Config1();
        initConfig(config1);
    }
    public MedicalCertControl(Config1 cf){
        config1 = cf;
        initConfig(cf);
    }
    public void initConfig(Config1 cf){
        mcc = new OpdTMedicalCertCompany();
        mccdb = new OpdTMedicalCertCompanyDB(config1);
        blc = new BangnaLogControl(cf);
    }
    public Vector getOpdTMedicalCertCompany(String branch_id, String where, String medical_cert_company_id, String flag) {
//        Vector v = new Vector();
        return mccdb.getOpdTMedicalCertCompany(branch_id, where, medical_cert_company_id, flag);
//        return v;
    }
    public String getTrMedicalCertCompanyOrder(String branch_id, String language, OpdTMedicalCertCompany medical_cert_company, String flag) {
        return mccdb.getTrMedicalCertCompanyOrder(branch_id, language, medical_cert_company, flag);
    }
    public OpdTMedicalCertCompany getOpdTMedicalCertCompanyByPK(String branch_id, String medical_cert_company_id) {
        return mccdb.getOpdTMedicalCertCompanyByPK(branch_id, medical_cert_company_id);
    }//¡
}
