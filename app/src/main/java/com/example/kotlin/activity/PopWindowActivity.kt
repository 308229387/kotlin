package com.example.kotlin.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlin.OneAddCommentFragment
import com.example.kotlin.R
import kotlinx.android.synthetic.main.activity_pop_layout.*

class PopWindowActivity : AppCompatActivity() {
    var dialogFragment: OneAddCommentFragment = OneAddCommentFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pop_layout)
        pop_text.setOnClickListener {
            dialogFragment.show(supportFragmentManager, "")
        }
    }
}