package com.example.kotlin.utils

import android.os.Handler
import android.os.Message
import android.widget.TextView
import java.util.*

/**
 * Author: sym
 * Date: 2021/7/21 4:58 PM
 * Describe:支持多个地方共同配置文字
 */
class ScheduleSearchTextUtil {
    private var i = 0
    private var textView1: TextView? = null
    private var textView2: TextView? = null
    private val handler: Handler = object : Handler() {
        override fun handleMessage(msg: Message) {
            if (msg.arg1 == 200) {
                val result: Int = i % 5
                textView1?.text = "默认$result"
                textView2?.text = "默认$result"
            }
        }
    }

    //单例
    companion object {
        private var instance: ScheduleSearchTextUtil? = null
            get() {
                if (field == null) {
                    field = ScheduleSearchTextUtil()
                }
                return field
            }

        fun get(): ScheduleSearchTextUtil {
            return instance!!
        }
    }

    constructor() {
        val timer = Timer()
        timer.schedule(object : TimerTask() {
            override fun run() {
                val message: Message = handler.obtainMessage()
                message.isAsynchronous
                message.arg1 = 200
                handler.sendMessage(message)
                i++
            }
        }, 0, 1000)
    }

    fun setTextToSearch(textView: TextView?) {
        textView1 = textView
    }

    fun setTextToSearch1(textView: TextView?) {
        textView2 = textView
    }

}