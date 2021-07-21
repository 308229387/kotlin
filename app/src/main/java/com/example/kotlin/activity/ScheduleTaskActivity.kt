package com.example.kotlin.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlin.R
import com.example.kotlin.utils.ScheduleSearchTextUtil
import kotlinx.android.synthetic.main.activity_schedule_task.*

/**
 * Author: sym
 * Date: 2021/7/21 2:46 PM
 * Describe:定时任务实现
 */
class ScheduleTaskActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_schedule_task)
        ScheduleSearchTextUtil.get().setTextToSearch(schedule_text)
    }
}