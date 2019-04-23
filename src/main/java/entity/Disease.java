package entity;

public class Disease extends Emr {

    private Integer id;

    private String icdCode;

    private String diseaseName;

    private String code;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIcdCode() {
        return icdCode;
    }

    public void setIcdCode(String icdCode) {
        this.icdCode = icdCode;
    }

    public String getDieaseName() {
        return diseaseName;
    }

    public void setDieaseName(String dieaseName) {
        this.diseaseName = dieaseName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Disease{" +
                "id=" + id +
                ", icdCode='" + icdCode + '\'' +
                ", diseaseName='" + diseaseName + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
