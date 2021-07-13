package com.example.kotlin.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlin.R
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
        if(intent!=null){
            question_text.text = intent.getStringExtra("question")
            answer_text.text = intent.getStringExtra("answer")
        }
    }

}