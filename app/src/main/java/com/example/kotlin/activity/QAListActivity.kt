package com.example.kotlin.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlin.R
import com.example.kotlin.adapter.QAAdapter
import com.example.kotlin.adapter.QATypeAdapter
import com.example.kotlin.data.HawkConfig
import com.example.kotlin.data.QAData
import com.example.kotlin.data.QAItemData
import com.orhanobut.hawk.Hawk
import kotlinx.android.synthetic.main.activity_q_a_list.*

/**
 * Author: sym
 * Date: 2021/4/21 7:27 PM
 * Describe:
 */
class QAListActivity : AppCompatActivity() {

    private lateinit var dataList: ArrayList<QAItemData>
   var list: ArrayList<String> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_q_a_list)

        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        q_a_recyclerView.layoutManager = layoutManager

        if (!Hawk.contains(HawkConfig.QA)) {
            Hawk.put(HawkConfig.QA, QAData.data)
        }

        dataList = Hawk.get(HawkConfig.QA)
        val adapter = QAAdapter(this, dataList)

//        list.add("组件化相关问题")
//        list.add("kotlin问题")
//        list.add("java基础")
//        list.add("四大组件")
//        list.add("Handler")
//        list.add("数据类型与存储")
//        list.add("性能优化")
//        list.add("JVM")
//        list.add("view与显示")
//        list.add("动画")
//        list.add("线程")
//        list.add("锁")
//        list.add("线程池")
//        list.add("进程")
//        list.add("网络")
//        list.add("第三方控件与框架")
//        list.add("音视频")
//        list.add("开发模式")
//        list.add("设计模式")
//        list.add("系统架构")
//        list.add("扩展")
//        val adapter = QATypeAdapter(this, list)
        q_a_recyclerView.adapter = adapter
    }
}