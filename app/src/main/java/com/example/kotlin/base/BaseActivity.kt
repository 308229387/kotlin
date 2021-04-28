package com.example.kotlin.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

/**
 * Author: sym
 * Date: 2021/4/28 8:46 PM
 * Describe:
 */
abstract class BaseActivity<VB : ViewBinding> : AppCompatActivity() {
    protected lateinit var viewBind:VB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBind = createViewBinding()
        setContentView(viewBind.root)
    }

    abstract fun createViewBinding(): VB
}