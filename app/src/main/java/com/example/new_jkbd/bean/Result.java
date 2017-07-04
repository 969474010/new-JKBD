package com.example.new_jkbd.bean;

import java.util.List;

/**
 * Created by &&&&& on 2017/7/4.
 */

public class Result {

    /**
     * error_code : 0
     * reason : ok
     * result : [{"id":4,"question":"这个标志是何含义？","answer":"2","item1":"禁止自行车通行车道","item2":"非机动车车道","item3":"自行车专用车道","item4":"停放自行车路段","explains":"此图为非机动车车道，别误以为自行车专用车道，没有自行车专用车道这一说。","url":"http"}]
     */

    private int error_code;
    private String reason;
    private List<Exam> result;

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public List<Exam> getResult() {
        return result;
    }

    public void setResult(List<Exam> result) {
        this.result = result;
    }


}
