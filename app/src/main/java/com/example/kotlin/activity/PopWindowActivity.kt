package com.example.kotlin.activity

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlin.R
import kotlinx.android.synthetic.main.activity_pop_layout.*

class PopWindowActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pop_layout)
        pop_text.setOnClickListener {
            Toast.makeText(this,"点击了",Toast.LENGTH_SHORT).show()
        }
    }
}