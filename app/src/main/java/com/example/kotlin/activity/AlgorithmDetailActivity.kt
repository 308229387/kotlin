package com.example.kotlin.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlin.R
import kotlinx.android.synthetic.main.activity_algorithm_detail.*

/**
 * Author: sym
 * Date: 2021/4/27 3:05 PM
 * Describe:
 */
class AlgorithmDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_algorithm_detail)

        if (intent.getIntExtra("image", 0) != null) {
            img.setImageResource(intent.getIntExtra("image", 0))
            img.enable()
        }

    }
}