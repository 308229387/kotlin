package com.example.kotlin.net;

/**
 * 黄振伟
 * 2022/5/23
 * Describe ：上传参数bean
 */
public class JsonParamsBean<T> {
    private String method = "post";
    private String type ="json";
    private String url;
    private T data;

    public JsonParamsBean(String url, T data) {
        this.url = url;
        this.data = data;
    }

    public T getData() {
        return data;
    }
}
