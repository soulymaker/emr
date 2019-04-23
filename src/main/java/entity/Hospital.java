package entity;


import java.sql.Timestamp;

public class Hospital extends Emr {

    private Integer id;

    private String code;

    private String hospitalName;

    private String level;

    private String telephone;

    private String address;

    private Timestamp lastchangedTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Timestamp getLastchangedTime() {
        return lastchangedTime;
    }

    public void setLastchangedTime(Timestamp lastchangedTime) {
        this.lastchangedTime = lastchangedTime;
    }

    @Override
    public String toString() {
        return "hospital{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", hospitalName='" + hospitalName + '\'' +
                ", level='" + level + '\'' +
                ", telephone='" + telephone + '\'' +
                ", address='" + address + '\'' +
                ", lastchangedTime=" + lastchangedTime +
                '}';
    }
}
