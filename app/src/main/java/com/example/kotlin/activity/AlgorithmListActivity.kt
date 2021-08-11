package com.example.kotlin.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlin.R
import com.example.kotlin.adapter.AlgorithmAdapter
import com.example.kotlin.data.AlgorithmData
import com.example.kotlin.data.HawkConfig
import com.example.kotlin.data.QAData
import com.example.kotlin.data.QAItemData
import com.orhanobut.hawk.Hawk
import kotlinx.android.synthetic.main.activity_algorithm_list.*

/**
 * Author: sym
 * Date: 2021/4/21 7:27 PM
 * Describe:
 */
class AlgorithmListActivity : AppCompatActivity() {
    private lateinit var dataList: ArrayList<QAItemData>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_algorithm_list)

        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        algorithm_recyclerView.layoutManager = layoutManager

        if (!Hawk.contains(HawkConfig.AlgorithmQA)) {
            Hawk.put(HawkConfig.AlgorithmQA, AlgorithmData.data)
        }

        dataList = Hawk.get(HawkConfig.AlgorithmQA)

        val adapter = AlgorithmAdapter(this, dataList)
        algorithm_recyclerView.adapter = adapter
    }
}