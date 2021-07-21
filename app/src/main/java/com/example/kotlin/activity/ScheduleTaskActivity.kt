package com.example.kotlin.activity

import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlin.R
import kotlinx.android.synthetic.main.activity_schedule_task.*
import java.util.*

/**
 * Author: sym
 * Date: 2021/7/21 2:46 PM
 * Describe:定时任务实现
 */
class ScheduleTaskActivity : AppCompatActivity() {
    private var timer: Timer = Timer()
    private var i = 0

    private val handler: Handler = Handler {
        schedule_text.text = it.arg1.toString()
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_schedule_task)
        timer.schedule(object : TimerTask() {
            override fun run() {
                var message = handler.obtainMessage()
                message.arg1 = i
                handler.sendMessage(message)
                i++
            }

        }, 0, 1000)
    }
}