package com.example.kotlin.net;

import com.example.kotlin.utils.ToastUtil;
import com.qsinong.qlog.QLog;

import java.net.SocketTimeoutException;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;

/**
 * 黄振伟
 * 2022/5/20
 * Describe ：请求返回结果
 */
public abstract class ResponseObserver<T> implements Observer<ObserverBean<T>> {

    @Override
    public void onSubscribe(@NonNull Disposable d) {

    }

    @Override
    public void onNext(@NonNull ObserverBean<T> t) {
        try {
            if (t.getStatus().equals("0")) {
                onReply(t.getData());
            } else {
                if (t.getErrMsg() != null) {
                    ToastUtil.showTextViewPrompt("错误码："+t.getCode()+"\n错误信息："+t.getErrMsg());
                    onFailure(t.getErrMsg());
                } else if (t.getMsg() != null) {
                    ToastUtil.showTextViewPrompt("错误码："+t.getCode()+"\n错误信息："+t.getMsg());
                    onFailure(t.getMsg());
                }
            }
        } catch (Exception e) {
            ToastUtil.showTextViewPrompt("数据格式错误");
            QLog.d("网络请求数据返回异常，message = "+e.getMessage());
        }

//            else if (t.getMessage() != null) {
//                onFailure(t.getMessage());
//            }

    }

    public abstract void onReply(T reply);

    public abstract void onFailure(String errorMsg);

    @Override
    public void onError(@NonNull Throwable e) {
        if (e instanceof SocketTimeoutException) {
            onFailure("网络请求超时");
        } else {
            onFailure(e.getMessage());
        }
    }

    @Override
    public void onComplete() {
    }
}
