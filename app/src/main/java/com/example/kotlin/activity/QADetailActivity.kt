package com.example.kotlin.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.kotlin.R
import com.example.kotlin.utils.ToastUtil
import com.example.kotlin.utils.ToolUtils
import kotlinx.android.synthetic.main.q_a_detail_layout.*
import java.util.ArrayList

/**
 * Author: sym
 * Date: 2021/7/13 7:34 PM
 * Describe:
 */
class QADetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.q_a_detail_layout)
        question_text.text = intent.getStringExtra("title")

        if (intent != null) {
            if(null == intent.getStringExtra("answer")|| (intent.getStringExtra("answer"))!!.isEmpty()){
                answer_text.visibility = View.GONE
            }else{
                answer_text.text = intent.getStringExtra("answer")
            }

            if (null != intent.getStringArrayListExtra("imageList")) {
                image_parent.visibility = View.VISIBLE
                var imageList =
                    intent.getStringArrayListExtra("imageList") as ArrayList<String>

                if (imageList != null) {
                    for (i in 0..(imageList.size-1)) {
                        var tmp = imageList[i]
                        if(ToolUtils.startWithText(tmp)){
                            val lp = FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
                            lp.bottomMargin = 70
                            val textView = TextView(this)
                            textView.text = ToolUtils.replaceText(tmp)
                            textView.textSize = 20f
                            textView.setTextColor(resources.getColor(R.color.grey))
                            textView.layoutParams = lp
                            image_parent.addView(textView)
                        }else if(ToolUtils.startWithImage(tmp)){
                            val lp = FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
                            lp.bottomMargin = 70
                            lp.leftMargin = 80
                            lp.rightMargin = 80
                            val imageView = ImageView(this)
                            imageView.layoutParams = lp

                            var tmp1: String = ToolUtils.replaceImage(tmp)
                            var id: Int = ToolUtils.getImages(tmp1)
                            Glide.with(this).load(id).into(imageView)

                            imageView.setOnClickListener(View.OnClickListener {
                                var intent =
                                    Intent(QADetailActivity@ this, BigImageActivity::class.java)
                                intent.putExtra("image", id)

                                startActivity(intent)
                            })

                            image_parent.addView(imageView)
                        }
                    }
                }
            }

        }
    }

}