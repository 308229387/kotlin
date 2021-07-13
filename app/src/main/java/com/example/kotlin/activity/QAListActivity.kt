package com.example.kotlin.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlin.R
import com.example.kotlin.adapter.AlgorithmAdapter
import com.example.kotlin.adapter.QAAdapter
import com.example.kotlin.data.AlgorithmData
import com.example.kotlin.data.QAData
import kotlinx.android.synthetic.main.activity_algorithm_list.*
import kotlinx.android.synthetic.main.activity_q_a_list.*

/**
 * Author: sym
 * Date: 2021/4/21 7:27 PM
 * Describe:
 */
class QAListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_q_a_list)

        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        q_a_recyclerView.layoutManager = layoutManager

        val adapter = QAAdapter(this, QAData.data)
        q_a_recyclerView.adapter = adapter
    }
}