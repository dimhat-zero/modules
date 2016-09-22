package com.jianla.model.base;

import java.io.Serializable;

/**
 * Created by think on 2016/8/22.
 */
public class JsonResult implements Serializable {

    private Boolean success=true;

    private String msg;

    private String code;

    private Object data;

    public static final JsonResult OK = new JsonResult();

    public static  final JsonResult ERR = new JsonResult(false,"请求发生错误");



    public JsonResult(Boolean success, String msg) {
        this.success = success;
        this.msg = msg;
    }

    public JsonResult(Boolean success) {
        this.success = success;
    }

    public JsonResult() {
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
