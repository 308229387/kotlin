package com.example.kotlin.activity

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlin.adapter.HomeAdapter
import com.example.kotlin.base.BaseActivity
import com.example.kotlin.data.HomeData
import com.example.kotlin.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupRecyclerView()

    }

    private fun setupRecyclerView() {
        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        viewBind.recyclerView.layoutManager = layoutManager

        val adapter = HomeAdapter(this, HomeData.data)
        viewBind.recyclerView.adapter = adapter
    }

    override fun createViewBinding(): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }


}