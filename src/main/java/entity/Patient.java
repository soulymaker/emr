package entity;

import java.sql.Timestamp;

public class Patient extends Emr {

    private Integer id;

    private String uid;

    private String patientName;

    private String sex;  // 男 女  未登记

    private String birthYear;

    private String nativePlace;

    private String address;

    private String phone;

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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(String birthYear) {
        this.birthYear = birthYear;
    }

    public String getNativePlace() {
        return nativePlace;
    }

    public void setNativePlace(String nativePlace) {
        this.nativePlace = nativePlace;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Timestamp getLastchangedTime() {
        return lastchangedTime;
    }

    public void setLastchangedTime(Timestamp lastchangedTime) {
        this.lastchangedTime = lastchangedTime;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", uid='" + uid + '\'' +
                ", patientName='" + patientName + '\'' +
                ", sex='" + sex + '\'' +
                ", birthYear='" + birthYear + '\'' +
                ", nativePlace='" + nativePlace + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", lastchangedTime=" + lastchangedTime +
                '}';
    }
}
