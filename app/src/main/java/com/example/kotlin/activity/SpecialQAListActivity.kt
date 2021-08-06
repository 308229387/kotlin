package com.example.kotlin.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlin.R
import com.example.kotlin.adapter.SpecialQAAdapter
import com.example.kotlin.data.HawkConfig
import com.example.kotlin.data.QAItemData
import com.orhanobut.hawk.Hawk
import kotlinx.android.synthetic.main.activity_special_q_a_list.*

/**
 * Author: sym
 * Date: 2021/4/21 7:27 PM
 * Describe:
 */
class SpecialQAListActivity : AppCompatActivity() {

    private lateinit var dataList: ArrayList<QAItemData>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_special_q_a_list)

        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        special_q_a_recyclerView.layoutManager = layoutManager

        if (Hawk.contains(HawkConfig.SpecialQA)) {
            dataList = Hawk.get(HawkConfig.SpecialQA)
            val adapter = SpecialQAAdapter(this, dataList)
            special_q_a_recyclerView.adapter = adapter
        }

    }
}