package entity;

import java.sql.Timestamp;

public class TestRecord extends Emr {

    private Integer id;

    private String testName;

    private String department;

    private String uid;

    private String status;
    private Timestamp lastchangedTime;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "TestRecord{" +
                "id=" + id +
                ", testName='" + testName + '\'' +
                ", department='" + department + '\'' +
                ", uid='" + uid + '\'' +
                ", status='" + status + '\'' +
                ", lastchangedTime=" + lastchangedTime +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public Timestamp getLastchangedTime() {
        return lastchangedTime;
    }

    public void setLastchangedTime(Timestamp lastchangedTime) {
        this.lastchangedTime = lastchangedTime;
    }

}
