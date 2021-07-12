package com.example.kotlin.activity

import android.os.Bundle
import com.example.kotlin.base.BaseActivity
import com.example.kotlin.databinding.ActivityHomeTabBinding

/**
 * Author: sym
 * Date: 2021/5/11 2:19 PM
 * Describe:
 */
class HomeTabActivity : BaseActivity<ActivityHomeTabBinding>() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


    override fun createViewBinding(): ActivityHomeTabBinding {
        return ActivityHomeTabBinding.inflate(layoutInflater)
    }


}