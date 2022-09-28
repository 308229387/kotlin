package com.example.kotlin.activity

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlin.adapter.HomeAdapter
import com.example.kotlin.base.BaseActivity
import com.example.kotlin.data.HomeData
import com.example.kotlin.databinding.ActivityMainBinding
import com.gyf.immersionbar.ImmersionBar
import com.orhanobut.logger.Logger

class MainActivity : BaseActivity<ActivityMainBinding>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ImmersionBar.with(this).fitsSystemWindows(true).transparentStatusBar().init()

        //已在base中设置透明，把字变暗些
        if (ImmersionBar.isSupportStatusBarDarkFont()) {
            ImmersionBar.with(this).statusBarDarkFont(true).init()
        } else {
            Toast.makeText(this, "当前设备不支持状态栏字体变色", Toast.LENGTH_SHORT).show()
        }

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