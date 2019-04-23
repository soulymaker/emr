package entity;

import java.sql.Timestamp;

public class Record extends Emr {

    private Integer id;

    private String uid;

    private String patientName;

    private String doctorName;

    private String consultationDate;  //YYYY-MM-DD

    private String test;

    private String description;

    private String diseaseType;

    private String conclusion;

    private String treatment;

    private String visitType;  // 转院 急诊 门诊

    private Timestamp lastchangedTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getConsultationDate() {
        return consultationDate;
    }

    public void setConsultationDate(String consultationDate) {
        this.consultationDate = consultationDate;
    }

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDiseaseType() {
        return diseaseType;
    }

    public void setDiseaseType(String diseaseType) {
        this.diseaseType = diseaseType;
    }

    public String getConclusion() {
        return conclusion;
    }

    public void setConclusion(String conclusion) {
        this.conclusion = conclusion;
    }

    public String getTreatment() {
        return treatment;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }

    public String getVisitType() {
        return visitType;
    }

    public void setVisitType(String visitType) {
        this.visitType = visitType;
    }

    public Timestamp getLastchangedTime() {
        return lastchangedTime;
    }

    public void setLastchangedTime(Timestamp lastchangedTime) {
        this.lastchangedTime = lastchangedTime;
    }

    @Override
    public String toString() {
        return "Record{" +
                "id=" + id +
                ", uid='" + uid + '\'' +
                ", patientName='" + patientName + '\'' +
                ", doctorName='" + doctorName + '\'' +
                ", consultationDate='" + consultationDate + '\'' +
                ", test='" + test + '\'' +
                ", description='" + description + '\'' +
                ", diseaseType='" + diseaseType + '\'' +
                ", conclusion='" + conclusion + '\'' +
                ", treatment='" + treatment + '\'' +
                ", visitType='" + visitType + '\'' +
                ", lastchangedTime=" + lastchangedTime +
                '}';
    }
}
