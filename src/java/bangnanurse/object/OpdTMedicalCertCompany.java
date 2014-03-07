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
public class OpdTMedicalCertCompany extends Persistent{
    public String medicalCertCompanyId="";
    public String medicalCertCompanyDate="";
    public String doctorNamet="";
    public String doctorNamee="";
    public String doctorId="";
    public String patientFullnamet="";
    public String comment1="";
    public String branchId="";
    public String medicalCertCompanyActive="";
    public String visitHn="";
    public String medicalCertCompanyTime="";
    public String tVisitId="";
    public String visitVn="";
    public String statusLatent="";
    public String statusMedicalCert="";
    public String statusHasLab="";
    public String statusPrint="";
    public String statusHasXray="";

    public OpdTMedicalCertCompany() {
    }

    public String getOpdTMedicalCertCompany(){
        return "opd_t_medical_cert_company";
    }
    public String getFMedicalCertCompanyId(){
        return "medical_cert_company_id";
    }
    public String getFMedicalCertCompanyDate(){
        return "medical_cert_company_date";
    }
    public String getFDoctorNamet(){
        return "doctor_namet";
    }
    public String getFDoctorNamee(){
        return "doctor_namee";
    }
    public String getFDoctorId(){
        return "doctor_id";
    }
    public String getFPatientFullnamet(){
        return "patient_fullnamet";
    }
    public String getFComment1(){
        return "comment1";
    }
    public String getFBranchId(){
        return "branch_id";
    }
    public String getFMedicalCertCompanyActive(){
        return "medical_cert_company_active";
    }
    public String getFVisitHn(){
        return "visit_hn";
    }
    public String getFMedicalCertCompanyTime(){
        return "medical_cert_company_time";
    }
    public String getFTVisitId(){
        return "t_visit_id";
    }
    public String getFVisitVn(){
        return "visit_vn";
    }
    public String getFStatusLatent(){
        return "status_latent";
    }
    public String getFStatusMedicalCert(){
        return "status_medical_cert";
    }
    public String getFStatusHasLab(){
        return "status_has_lab";
    }
    public String getFStatusPrint(){
        return "status_print";
    }
    public String getFStatusHasXray(){
        return "status_has_xray";
    }

    public OpdTMedicalCertCompany(String medicalCertCompanyId) {
        this.medicalCertCompanyId = medicalCertCompanyId;
    }

    public String getMedicalCertCompanyId() {
        return medicalCertCompanyId;
    }

    public void setMedicalCertCompanyId(String medicalCertCompanyId) {
        this.medicalCertCompanyId = medicalCertCompanyId;
    }

    public String getMedicalCertCompanyDate() {
        return medicalCertCompanyDate;
    }

    public void setMedicalCertCompanyDate(String medicalCertCompanyDate) {
        this.medicalCertCompanyDate = medicalCertCompanyDate;
    }

    public String getDoctorNamet() {
        return doctorNamet;
    }

    public void setDoctorNamet(String doctorNamet) {
        this.doctorNamet = doctorNamet;
    }

    public String getDoctorNamee() {
        return doctorNamee;
    }

    public void setDoctorNamee(String doctorNamee) {
        this.doctorNamee = doctorNamee;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public String getPatientFullnamet() {
        return patientFullnamet;
    }

    public void setPatientFullnamet(String patientFullnamet) {
        this.patientFullnamet = patientFullnamet;
    }

    public String getComment1() {
        return comment1;
    }
    public void setComment1(String comment1) {
        this.comment1 = comment1;
    }

    public String getBranchId() {
        return branchId;
    }
    public void setBranchId(String branchId) {
        this.branchId = branchId;
    }

    public String getMedicalCertCompanyActive() {
        return medicalCertCompanyActive;
    }
    public void setMedicalCertCompanyActive(String medicalCertCompanyActive) {
        this.medicalCertCompanyActive = medicalCertCompanyActive;
    }

    public String getVisitHn() {
        return visitHn;
    }
    public void setVisitHn(String visitHn) {
        this.visitHn = visitHn;
    }
    public String getMedicalCertCompanyTime() {
        return medicalCertCompanyTime;
    }
    public void setMedicalCertCompanyTime(String medicalCertCompanyTime) {
        this.medicalCertCompanyTime = medicalCertCompanyTime;
    }
    public String getTVisitId() {
        return tVisitId;
    }
    public void setTVisitId(String tVisitId) {
        this.tVisitId = tVisitId;
    }
    public String getVisitVn() {
        return visitVn;
    }
    public void setVisitVn(String visitVn) {
        this.visitVn = visitVn;
    }

    public int hashCode() {
        int hash = 0;
        hash += (medicalCertCompanyId != null ? medicalCertCompanyId.hashCode() : 0);
        return hash;
    }

    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OpdTMedicalCertCompany)) {
            return false;
        }
        OpdTMedicalCertCompany other = (OpdTMedicalCertCompany) object;
        if ((this.medicalCertCompanyId == null && other.medicalCertCompanyId != null) || (this.medicalCertCompanyId != null && !this.medicalCertCompanyId.equals(other.medicalCertCompanyId))) {
            return false;
        }
        return true;
    }

    public String toString() {
        return "bangnaopd.OpdTMedicalCertCompany[medicalCertCompanyId=" + medicalCertCompanyId + "]";
    }

}
