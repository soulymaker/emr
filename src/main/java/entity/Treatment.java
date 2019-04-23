package entity;

public class Treatment extends Emr {

    private Integer id;

    private String treatmentName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTreatmentName() {
        return treatmentName;
    }

    public void setTreatmentName(String treatmentName) {
        this.treatmentName = treatmentName;
    }

    @Override
    public String toString() {
        return "Treatment{" +
                "id=" + id +
                ", treatmentName='" + treatmentName + '\'' +
                '}';
    }
}
