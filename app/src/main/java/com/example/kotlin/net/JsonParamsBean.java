package com.example.kotlin.net;

/**
 * 黄振伟
 * 2022/5/23
 * Describe ：上传参数bean
 */
public class JsonParamsBean<T> {

    public JsonParamsBean(String url,String type,String method, T data) {
        this.method = method;
        this.type = type;
        this.url = url;
        this.data = data;
    }
    private String method = "post";
    private String type ="json";
    private String url;
    private T data;

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
