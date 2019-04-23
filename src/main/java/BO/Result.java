package BO;

import com.alibaba.fastjson.JSONObject;

/**
 * 响应实体
 *
 * @author mioko
 */

/**
 * @author mioko
 */
public class Result {
    private Object data;

    private String msg;
    private String err;


    public static JSONObject returnData() {
        JSONObject json = new JSONObject();
        json.put("err", null);
        json.put("msg", null);
        json.put("data", null);
        return json;
    }

    public static JSONObject returnData(String err) {
        JSONObject json = new JSONObject();
        json.put("err", err);
        json.put("msg", null);
        json.put("data", null);
        return json;
    }

    public static JSONObject returnData(Object data) {
        JSONObject json = new JSONObject();
        json.put("err", null);
        json.put("msg", "查询成功");
        json.put("data", data);
        return json;
    }

    public static JSONObject returnData(String err, String msg) {
        JSONObject json = new JSONObject();
        json.put("err", err);
        json.put("msg", msg);
        json.put("data", null);
        return json;
    }

    public static JSONObject returnData(String err, String msg, Object data) {
        JSONObject json = new JSONObject();
        json.put("err", err);
        json.put("msg", msg);
        json.put("data", data);
        return json;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getErr() {
        return err;
    }

    public void setErr(String err) {
        this.err = err;
    }
}