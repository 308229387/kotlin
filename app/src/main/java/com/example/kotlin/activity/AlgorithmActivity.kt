package com.example.kotlin.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlin.HomeData
import com.example.kotlin.R
import com.example.kotlin.adapter.HomeAdapter
import kotlinx.android.synthetic.main.activity_algorithm.*
import kotlinx.android.synthetic.main.activity_main.recyclerView

/**
 * Author: sym
 * Date: 2021/4/21 7:27 PM
 * Describe:
 */
class AlgorithmActivity:AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_algorithm)

        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        algorithm_recyclerView.layoutManager = layoutManager

        val adapter = HomeAdapter(this, HomeData.data)
        algorithm_recyclerView.adapter = adapter
    }
}