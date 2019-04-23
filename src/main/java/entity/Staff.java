package entity;

import java.sql.Timestamp;

public class Staff extends Emr {

    private Integer id;

    private String jobNumber;

    private String staffName;

    private String type;  // 医生 护士 护工 未登记

    private String grade;

    private String hospital;

    private String departmentName;

    private Timestamp lastchangedTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getJobNumber() {
        return jobNumber;
    }

    public void setJobNumber(String jobNumber) {
        this.jobNumber = jobNumber;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getHospital() {
        return hospital;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Timestamp getLastchangedTime() {
        return lastchangedTime;
    }

    public void setLastchangedTime(Timestamp lastchangedTime) {
        this.lastchangedTime = lastchangedTime;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "id=" + id +
                ", jobNumber='" + jobNumber + '\'' +
                ", staffName='" + staffName + '\'' +
                ", type='" + type + '\'' +
                ", grade='" + grade + '\'' +
                ", hospital='" + hospital + '\'' +
                ", departmentName='" + departmentName + '\'' +
                ", lastchangedTime=" + lastchangedTime +
                '}';
    }
}
