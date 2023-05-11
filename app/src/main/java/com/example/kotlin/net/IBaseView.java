package com.example.kotlin.net;

import android.content.Context;

/**
 * 黄振伟
 * 2022/5/21
 * Describe ：
 */
public interface IBaseView {
    /**
     * 提示错误信息给用户
     */
    void onError(String msg);

    default Context getContext(){
      return null;
    }
}
