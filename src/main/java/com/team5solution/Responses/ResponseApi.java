package com.team5solution.Responses;

import java.io.Serializable;

public class ResponseApi implements Serializable {

    private Boolean success = Boolean.FALSE;
    private Integer code = 0;
    private String message = "Has Error, please try again later";
    private Object data = null;

    public static ResponseApi createSuccessResponse(Object data) {
        ResponseApi api = new ResponseApi();
        api.success = Boolean.TRUE;
        api.code = 1;
        api.message = "Successful";
        api.data = data;
        return api;
    }

    public static ResponseApi createSuccessResponse() {
        return createSuccessResponse(null);
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
