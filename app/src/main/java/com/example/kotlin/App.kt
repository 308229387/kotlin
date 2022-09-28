package com.example.kotlin

import android.app.Application
import android.content.Context
import com.example.kotlin.utils.AppContextUtils
import com.orhanobut.hawk.Hawk
import com.orhanobut.hawk.HawkBuilder
import com.orhanobut.hawk.LogLevel
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.DiskLogAdapter
import com.orhanobut.logger.Logger
import com.qsinong.qlog.QLog
import com.orhanobut.logger.PrettyFormatStrategy

import com.orhanobut.logger.FormatStrategy




class App : Application() {


    companion object {
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
            .build()
        AppContextUtils.initApp(this)
        QLog.init(this)
//        Logger.addLogAdapter(DiskLogAdapter())

        val formatStrategy: FormatStrategy = PrettyFormatStrategy.newBuilder()
            .showThreadInfo(false) // 展示线程信息
            .methodCount(5) // 展示调用的方法个数，默认是 2
            .methodOffset(0) // 跳过堆栈中的方法个数， 默认是 0
            .tag("song_test") //  TAG 内容. 默认是 PRETTY_LOGGER
            .build()
        Logger.addLogAdapter(DiskLogAdapter(formatStrategy))

    }





}