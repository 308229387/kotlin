package com.example.kotlin.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlin.AddCommentFragment
import com.example.kotlin.R
import kotlinx.android.synthetic.main.activity_pop_layout.*

class PopWindowActivity : AppCompatActivity() {
    var dialogFragment: AddCommentFragment = AddCommentFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pop_layout)
        pop_text.setOnClickListener {
            dialogFragment.show(supportFragmentManager, "")
        }
    }
}