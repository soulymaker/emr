package DTO;

import entity.Emr;

import java.util.List;

public class QueryDTO {

    public List<? extends Emr> result;

    public String flag;

    public List<? extends Emr> getResult() {
        return result;
    }

    public void setResult(List<? extends Emr> result) {
        this.result = result;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "QueryDTO{" +
                "result=" + result +
                ", flag='" + flag + '\'' +
                '}';
    }
}
