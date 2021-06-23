package com.example.kotlin.activity

import android.os.Bundle
import android.widget.Toast
import com.example.kotlin.base.BaseActivity
import com.example.kotlin.databinding.ActivityTopBarBinding
import com.example.kotlin.views.CommonTopBarView

/**
 * Author: sym
 * Date: 2021/6/23 6:35 PM
 * Describe:
 */
class TopBarActivity : BaseActivity<ActivityTopBarBinding>(), CommonTopBarView.OnCommonTopBarActionCallback, CommonTopBarView.OnCommonTopBarBackCallback {
    override fun createViewBinding(): ActivityTopBarBinding {
        return ActivityTopBarBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBind.bvTopBar.setOnCommonTopBarCallback(this, this)
    }

    override fun onDoAction() {
        Toast.makeText(this@TopBarActivity, "save", Toast.LENGTH_SHORT).show()
    }

    override fun onDoBack() {
        finish()
    }

}