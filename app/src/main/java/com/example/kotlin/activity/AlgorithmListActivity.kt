package com.example.kotlin.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlin.R
import com.example.kotlin.adapter.AlgorithmAdapter
import com.example.kotlin.data.AlgorithmData
import kotlinx.android.synthetic.main.activity_algorithm_list.*

/**
 * Author: sym
 * Date: 2021/4/21 7:27 PM
 * Describe:
 */
class AlgorithmListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_algorithm_list)

        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        algorithm_recyclerView.layoutManager = layoutManager

        val adapter = AlgorithmAdapter(this, AlgorithmData.data)
        algorithm_recyclerView.adapter = adapter
    }
}