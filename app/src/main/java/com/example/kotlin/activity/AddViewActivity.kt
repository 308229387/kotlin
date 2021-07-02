package com.example.kotlin.activity

import android.os.Bundle
import android.view.View
import android.widget.RelativeLayout
import com.example.kotlin.R
import com.example.kotlin.base.BaseActivity
import com.example.kotlin.databinding.ActivityAddViewBinding
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

        viewBind.addAllViewABtn.setOnClickListener {
            childA.without_layout_a.visibility = View.VISIBLE
            viewBind.fatherView.addView(childA, params)
        }

        viewBind.addAllViewBBtn.setOnClickListener {
            childB.without_layout_b.visibility = View.VISIBLE
            viewBind.fatherView.addView(childB, params)
        }


        viewBind.deleteAViewBtn.setOnClickListener {
            viewBind.fatherView.removeView(childA)
        }

        viewBind.deleteBViewBtn.setOnClickListener {
            viewBind.fatherView.removeView(childB)
        }

        childA.without_layout_a.setOnClickListener {
            viewBind.fatherView.removeAllViews()
            viewBind.fatherView.addView(childA, params)
            viewBind.fatherView.addView(childB, params)
        }
        childB.without_layout_b.setOnClickListener {
            viewBind.fatherView.removeAllViews()
            viewBind.fatherView.addView(childB, params)
            viewBind.fatherView.addView(childA, params)
        }

        viewBind.onlyAViewBtn.setOnClickListener {
            viewBind.fatherView.removeAllViews()
            childA.without_layout_a.visibility = View.GONE
            viewBind.fatherView.addView(childA, params)
        }

        viewBind.onlyBViewBtn.setOnClickListener {
            viewBind.fatherView.removeAllViews()
            childB.without_layout_b.visibility = View.GONE
            viewBind.fatherView.addView(childB, params)
        }


    }
}