package com.example.kotlin.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.viewbinding.ViewBinding
import com.example.kotlin.R
import com.example.kotlin.utils.statusbar.StatusBarCompat
import com.gyf.immersionbar.ImmersionBar

/**
 * Author: sym
 * Date: 2021/4/28 8:46 PM
 * Describe:https://github.com/gyf-dev/ImmersionBar   沉侵依赖库，可以改状态栏颜色，字颜色，隐藏显示状态栏等
 */
abstract class BaseActivity<VB : ViewBinding> : AppCompatActivity() {
    protected lateinit var viewBind:VB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBind = createViewBinding()
        setContentView(viewBind.root)


//        ImmersionBar.with(this)
////            .fitsSystemWindows(true)  //使用该属性,必须指定状态栏颜色
////            .statusBarColor(R.color.colorPrimary)
//            .init();

        setStatusBar()

    }

    /**
     * 状态栏设置
     */
    fun setStatusBar() {
        StatusBarCompat.compat(this, ContextCompat.getColor(this, R.color.top_bar_color), false)
    }

    abstract fun createViewBinding(): VB
}