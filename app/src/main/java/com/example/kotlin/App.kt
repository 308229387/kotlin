package com.example.kotlin

import android.app.Application
import android.content.Context
import com.orhanobut.hawk.Hawk

class App : Application() {


    companion object{
        private var mContext: Context? = null

        fun getAppContext(): Context? {
            return mContext
        }
    }

    override fun onCreate() {
        super.onCreate()
        mContext = applicationContext;
        Hawk.init(this).build();
    }



}