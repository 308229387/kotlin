package com.example.kotlin

import android.app.Application
import android.content.Context
import com.orhanobut.hawk.Hawk
import com.orhanobut.hawk.HawkBuilder
import com.orhanobut.hawk.LogLevel

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
        Hawk.init(this)
            .setEncryptionMethod(HawkBuilder.EncryptionMethod.MEDIUM)
            .setStorage(HawkBuilder.newSqliteStorage(this))
            .setLogLevel(LogLevel.FULL)
            .build()    }



}