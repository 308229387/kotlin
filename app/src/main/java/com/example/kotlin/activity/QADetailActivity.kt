package com.example.kotlin.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin.R
import com.example.kotlin.adapter.MyAdapter
import kotlinx.android.synthetic.main.q_a_detail_layout.*

/**
 * Author: sym
 * Date: 2021/7/13 7:34 PM
 * Describe:
 */
class QADetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.q_a_detail_layout)
        if (intent != null) {
            if (null != intent.getStringArrayListExtra("imageList")) {
                val imageList = intent.getStringArrayListExtra("imageList")
                val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
                recyclerView.layoutManager = LinearLayoutManager(this) // 设置布局管理器
                recyclerView.adapter = MyAdapter(imageList) // 设置适配器
            }
        }
    }

}