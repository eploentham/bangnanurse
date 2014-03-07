/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bangnanurse.object;

import com.bangna.usecase.connection.Persistent;

/**
 *
 * @author root
 */
public class OpdBMedicalCertCompanyResult extends Persistent{
    public String bMedicalCertCompanyResultId="";
    public String bMedicalCertCompanyOrderId="";
    public String resultt="";
    public String resulte="";
    public String sort1="";
    public String medicalCertCompanyResultActive="";

    public OpdBMedicalCertCompanyResult() {
    }
    public String getOpdBMedicalCertCompanyResult() {
        return "opd_b_medical_cert_company_result";
    }
    public String getFBMedicalCertCompanyResultId() {
        return "b_medical_cert_company_result_id";
    }
    public String getFBMedicalCertCompanyOrderId() {
        return "b_medical_cert_company_order_id";
    }
    public String getFResultt() {
        return "resultt";
    }
    public String getFResulte() {
        return "resulte";
    }
    public String getFSort1() {
        return "sort1";
    }
    public String getFMedicalCertCompanyResultActive() {
        return "medical_cert_company_result_active";
    }

    public OpdBMedicalCertCompanyResult(String bMedicalCertCompanyResultId) {
        this.bMedicalCertCompanyResultId = bMedicalCertCompanyResultId;
    }

    public String getBMedicalCertCompanyResultId() {
        return bMedicalCertCompanyResultId;
    }

    public void setBMedicalCertCompanyResultId(String bMedicalCertCompanyResultId) {
        this.bMedicalCertCompanyResultId = bMedicalCertCompanyResultId;
    }

    public String getBMedicalCertCompanyOrderId() {
        return bMedicalCertCompanyOrderId;
    }

    public void setBMedicalCertCompanyOrderId(String bMedicalCertCompanyOrderId) {
        this.bMedicalCertCompanyOrderId = bMedicalCertCompanyOrderId;
    }

    public String getResultt() {
        return resultt;
    }

    public void setResultt(String resultt) {
        this.resultt = resultt;
    }

    public String getResulte() {
        return resulte;
    }

    public void setResulte(String resulte) {
        this.resulte = resulte;
    }

    public String getSort1() {
        return sort1;
    }

    public void setSort1(String sort1) {
        this.sort1 = sort1;
    }

    public String getMedicalCertCompanyResultActive() {
        return medicalCertCompanyResultActive;
    }

    public void setMedicalCertCompanyResultActive(String medicalCertCompanyResultActive) {
        this.medicalCertCompanyResultActive = medicalCertCompanyResultActive;
    }

    public String toString() {
        return "bangnaopd.OpdBMedicalCertCompanyResult[bMedicalCertCompanyResultId=" + bMedicalCertCompanyResultId + "]";
    }

}
