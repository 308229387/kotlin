package com.example.kotlin.activity

import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.RelativeLayout
import com.example.kotlin.R
import com.example.kotlin.base.BaseActivity
import com.example.kotlin.databinding.ActivityAddViewBinding
import com.example.kotlin.utils.ToolsUtil
import kotlinx.android.synthetic.main.child_view_a.view.*
import kotlinx.android.synthetic.main.child_view_b.view.*


/**
 * Author: sym
 * Date: 2021/7/2 10:08 AM
 * Describe:
 */
class AddViewActivity : BaseActivity<ActivityAddViewBinding>() {
    override fun createViewBinding(): ActivityAddViewBinding {
        return ActivityAddViewBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var childA = layoutInflater.inflate(R.layout.child_view_a, null)
        var childB = layoutInflater.inflate(R.layout.child_view_b, null)
        //必须要有这个
        var params = RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT)

        var animation = AnimationUtils.loadAnimation(this@AddViewActivity, R.anim.slow_show)

        viewBind.addAllViewABtn.setOnClickListener {
            if (ToolsUtil.isFastClick) {
                childA.without_layout_a_all.visibility = View.VISIBLE
                viewBind.fatherView.addView(childA, params)
                childA.startAnimation(animation)
            }
        }

        viewBind.addAllViewBBtn.setOnClickListener {
            if (ToolsUtil.isFastClick) {

                childB.without_layout_b_all.visibility = View.VISIBLE
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

        childA.without_layout_a_part.setOnClickListener {
            if (ToolsUtil.isFastClick) {
                childB.without_layout_b_all.visibility = View.VISIBLE
                childA.without_layout_a_all.visibility = View.GONE
                viewBind.fatherView.removeAllViews()
                viewBind.fatherView.addView(childA, params)
                viewBind.fatherView.addView(childB, params)
                childB.startAnimation(animation)
            }

        }

        childB.without_layout_b_part.setOnClickListener {
            if (ToolsUtil.isFastClick) {
                childA.without_layout_a_all.visibility = View.VISIBLE
                childB.without_layout_b_all.visibility = View.GONE
                viewBind.fatherView.removeAllViews()
                viewBind.fatherView.addView(childB, params)
                viewBind.fatherView.addView(childA, params)
                childA.startAnimation(animation)
            }
        }

        viewBind.onlyAViewBtn.setOnClickListener {
            if (ToolsUtil.isFastClick) {

                viewBind.fatherView.removeAllViews()
                childA.without_layout_a_all.visibility = View.GONE
                viewBind.fatherView.addView(childA, params)
                childA.startAnimation(animation)
            }
        }

        viewBind.onlyBViewBtn.setOnClickListener {
            if (ToolsUtil.isFastClick) {
                viewBind.fatherView.removeAllViews()
                childB.without_layout_b_all.visibility = View.GONE
                viewBind.fatherView.addView(childB, params)
                childB.startAnimation(animation)
            }
        }

    }
}