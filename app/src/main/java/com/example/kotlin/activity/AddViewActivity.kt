package com.example.kotlin.activity

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.RelativeLayout
import android.widget.Toast
import com.example.kotlin.R
import com.example.kotlin.base.BaseActivity
import com.example.kotlin.databinding.ActivityAddViewBinding
import com.example.kotlin.utils.ToolsUtil
import kotlinx.android.synthetic.main.child_view_a.view.*
import kotlinx.android.synthetic.main.child_view_b.view.*


/**
 * Author: sym
 * Date: 2021/7/2 10:08 AM
 * Describe:   卡片切换、卡片.9阴影切图
 */
class AddViewActivity : BaseActivity<ActivityAddViewBinding>() {
    override fun createViewBinding(): ActivityAddViewBinding {
        return ActivityAddViewBinding.inflate(layoutInflater)
    }

    @SuppressLint("InflateParams")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val childA = layoutInflater.inflate(R.layout.child_view_a, null)
        val childB = layoutInflater.inflate(R.layout.child_view_b, null)
        //必须要有这个
        val params = RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT)
        val animation = AnimationUtils.loadAnimation(this@AddViewActivity, R.anim.slow_show)

        viewBind.addAllViewABtn.setOnClickListener {
            if (ToolsUtil.isFastClick) {
                childA.without_layout_a.visibility = View.VISIBLE
                viewBind.fatherView.addView(childA, params)
                childA.startAnimation(animation)
            }
        }

        viewBind.addAllViewBBtn.setOnClickListener {
            if (ToolsUtil.isFastClick) {
                childB.without_layout_b.visibility = View.VISIBLE
                viewBind.fatherView.addView(childB, params)
                childB.startAnimation(animation)
            }
        }


        viewBind.deleteAViewBtn.setOnClickListener {
            if (ToolsUtil.isFastClick) {
                viewBind.fatherView.removeView(childA)
            }
        }

        viewBind.deleteBViewBtn.setOnClickListener {
            if (ToolsUtil.isFastClick) {
                viewBind.fatherView.removeView(childB)
            }
        }

        fun setLayoutClick(status: Boolean) {
            childA.without_layout_a.isClickable = status
            childA.go_buy_btn.isClickable = status
            childB.without_layout_b.isClickable = !status
            childB.key_a.isClickable = !status
            childB.key_b.isClickable = !status
            childB.key_c.isClickable = !status
            childB.more_key.isClickable = !status
        }

        childA.without_layout_a.setOnClickListener {
            if (ToolsUtil.isFastClick) {
                setLayoutClick(false)
                viewBind.fatherView.removeAllViews()
                viewBind.fatherView.addView(childA, params)
                viewBind.fatherView.addView(childB, params)
                childB.startAnimation(animation)
            }
        }

        childB.without_layout_b.setOnClickListener {
            if (ToolsUtil.isFastClick) {
                setLayoutClick(true)
                viewBind.fatherView.removeAllViews()
                viewBind.fatherView.addView(childB, params)
                viewBind.fatherView.addView(childA, params)
                childA.startAnimation(animation)
            }
        }

        viewBind.onlyAViewBtn.setOnClickListener {
            if (ToolsUtil.isFastClick) {
                viewBind.fatherView.removeAllViews()
                childA.without_layout_a.visibility = View.GONE
                viewBind.fatherView.addView(childA, params)
                childA.startAnimation(animation)
            }
        }

        viewBind.onlyBViewBtn.setOnClickListener {
            if (ToolsUtil.isFastClick) {
                viewBind.fatherView.removeAllViews()
                childB.without_layout_b.visibility = View.GONE
                viewBind.fatherView.addView(childB, params)
                childB.startAnimation(animation)
            }
        }

        childB.key_a.setOnClickListener { Toast.makeText(this@AddViewActivity, "key_a", Toast.LENGTH_SHORT).show() }
        childB.key_b.setOnClickListener { Toast.makeText(this@AddViewActivity, "key_b", Toast.LENGTH_SHORT).show() }
        childB.key_c.setOnClickListener { Toast.makeText(this@AddViewActivity, "key_c", Toast.LENGTH_SHORT).show() }
        childB.more_key.setOnClickListener { Toast.makeText(this@AddViewActivity, "more_key", Toast.LENGTH_SHORT).show() }
        childA.go_buy_btn.setOnClickListener { Toast.makeText(this@AddViewActivity, "go_buy_btn", Toast.LENGTH_SHORT).show() }

    }


}