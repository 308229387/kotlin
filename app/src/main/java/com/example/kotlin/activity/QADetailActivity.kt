package com.example.kotlin.activity

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.kotlin.R
import com.example.kotlin.utils.ToastUtil
import kotlinx.android.synthetic.main.q_a_detail_layout.*

/**
 * Author: sym
 * Date: 2021/7/13 7:34 PM
 * Describe:
 */
class QADetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.q_a_detail_layout)
        if (intent != null) {
            question_text.text = intent.getStringExtra("title")
            answer_text.text = intent.getStringExtra("answer")

            if (null != intent.getStringExtra("image")) {
                answer_image.visibility = View.VISIBLE
                val resId: Int = this.resources.getIdentifier(intent.getStringExtra("image"), "drawable", this.packageName)
                Glide.with(this).load(resId).into(answer_image)
                answer_image.setOnClickListener(View.OnClickListener {
                    ToastUtil.showTextViewPrompt("test")
                })
            }

        }
    }

}