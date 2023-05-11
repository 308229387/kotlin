package com.example.kotlin.net;

/**
 * 黄振伟
 * 2022/5/17
 * Describe ：统一的 {"code":0,"status":0,"data":{}}
 */
public class ObserverBean<T> {
    private String status;
    private int size;
    private T data;
    private String errMsg;
    private String msg;
    private String message;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    private String code;


    public String getStatus() {
        return status;
    }

    public T getData() {
        return data;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public int getSize() {
        return size;
    }

    public String getMsg() {
        return msg;
    }

    public String getMessage() {
        return message;
    }
}
