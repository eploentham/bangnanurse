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
public class OpdTMedicalCertCompanyDetail extends Persistent{
    public String medicalCertCompanyDetailId="";
    public String medicalCertCompanyId="";
    public String order1="";
    public String result1="";
    public String sort1="";
    public String medicalCertCompanyDetailActive="";
    public String ordere1="",fItemGroupId="";

    public OpdTMedicalCertCompanyDetail() {
    }
    public String getOpdTMedicalCertCompanyDetail() {
        return "opd_t_medical_cert_company_detail";
    }
    public String getFMedicalCertCompanyDetailId() {
        return "medical_cert_company_detail_id";
    }
    public String getFMedicalCertCompanyId() {
        return "medical_cert_company_id";
    }
    public String getFOrder1() {
        return "order1";
    }
    public String getFResult1() {
        return "result1";
    }
    public String getFSort1() {
        return "sort1";
    }
    public String getFMedicalCertCompanyDetailActive() {
        return "medical_cert_company_detail_active";
    }
    public String getFOrdere1() {
        return "ordere1";
    }
    public String getFfItemGroupId() {
        return "f_item_group_id";
    }

    public OpdTMedicalCertCompanyDetail(String medicalCertCompanyDetailId) {
        this.medicalCertCompanyDetailId = medicalCertCompanyDetailId;
    }

    public String getMedicalCertCompanyDetailId() {
        return medicalCertCompanyDetailId;
    }

    public void setMedicalCertCompanyDetailId(String medicalCertCompanyDetailId) {
        this.medicalCertCompanyDetailId = medicalCertCompanyDetailId;
    }

    public String getMedicalCertCompanyId() {
        return medicalCertCompanyId;
    }

    public void setMedicalCertCompanyId(String medicalCertCompanyId) {
        this.medicalCertCompanyId = medicalCertCompanyId;
    }

    public String getOrder1() {
        return order1;
    }

    public void setOrder1(String order1) {
        this.order1 = order1;
    }

    public String getResult1() {
        return result1;
    }
    public void setResult1(String result1) {
        this.result1 = result1;
    }
    public String getSort1() {
        return sort1;
    }
    public void setSort1(String sort1) {
        this.sort1 = sort1;
    }

    public String getMedicalCertCompanyDetailActive() {
        return medicalCertCompanyDetailActive;
    }
    public void setMedicalCertCompanyDetailActive(String medicalCertCompanyDetailActive) {
        this.medicalCertCompanyDetailActive = medicalCertCompanyDetailActive;
    }

    public String getOrdere1() {
        return ordere1;
    }
    public void setOrdere1(String ordere1) {
        this.ordere1 = ordere1;
    }

    public String toString() {
        return "bangnaopd.OpdTMedicalCertCompanyDetail[medicalCertCompanyDetailId=" + medicalCertCompanyDetailId + "]";
    }

}
