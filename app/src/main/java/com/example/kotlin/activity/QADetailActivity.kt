package com.example.kotlin.activity

import android.os.Bundle
import android.text.Html
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlin.R
import kotlinx.android.synthetic.main.activity_q_a_image_text_detail.*
import kotlinx.android.synthetic.main.q_a_detail_layout.answer_text
import kotlinx.android.synthetic.main.q_a_detail_layout.question_text

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
        }
    }

}