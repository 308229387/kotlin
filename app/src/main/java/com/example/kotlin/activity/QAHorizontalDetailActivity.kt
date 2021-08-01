package com.example.kotlin.activity

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlin.R
import kotlinx.android.synthetic.main.q_a_detail_layout.*

/**
 * Author: sym
 * Date: 2021/7/13 7:34 PM
 * Describe:
 */
class QAHorizontalDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.q_a_detail_layout)
        if (intent != null) {
            question_text.text = intent.getStringExtra("question")
            Log.d("song_tag", intent.getStringExtra("question").toString())
            answer_text.text = intent.getStringExtra("answer")
        }
    }

}