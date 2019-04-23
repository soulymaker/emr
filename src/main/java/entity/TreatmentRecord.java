package entity;

import java.sql.Timestamp;

public class TreatmentRecord extends Emr {

    private Integer id;

    private String uid;

    private String treatmentName;

    private String doctor;

    private String status;

    private Timestamp lastchangedTime;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

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

    public String getTreatmentName() {
        return treatmentName;
    }

    public void setTreatmentName(String treatmentName) {
        this.treatmentName = treatmentName;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    public Timestamp getLastchangedTime() {
        return lastchangedTime;
    }

    public void setLastchangedTime(Timestamp lastchangedTime) {
        this.lastchangedTime = lastchangedTime;
    }

    @Override
    public String toString() {
        return "TreatmentRecord{" +
                "id=" + id +
                ", uid='" + uid + '\'' +
                ", treatmentName='" + treatmentName + '\'' +
                ", doctor='" + doctor + '\'' +
                ", status='" + status + '\'' +
                ", lastchangedTime=" + lastchangedTime +
                '}';
    }
}
