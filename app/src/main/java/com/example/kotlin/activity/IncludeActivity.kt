package com.example.kotlin.activity

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlin.R
import kotlinx.android.synthetic.main.activity_include_layout.*
import kotlinx.android.synthetic.main.include_layout.*

class IncludeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_include_layout)
        tv_setting_update_app_title.setOnClickListener {
            Toast.makeText(this, tv_setting_update_app_title.text, Toast.LENGTH_SHORT).show()
        }

        visible_test.setOnClickListener {
            if (include_parent.visibility == View.GONE) {
                include_parent.visibility = View.VISIBLE
            } else if (include_parent.visibility == View.VISIBLE) {
                include_parent.visibility = View.GONE
            }
        }
    }
}