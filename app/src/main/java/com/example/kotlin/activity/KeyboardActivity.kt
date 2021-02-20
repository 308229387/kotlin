package com.example.kotlin.activity

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlin.R
import com.example.kotlin.utils.SoleHeightProvider
import kotlinx.android.synthetic.main.activity_nt_nothing.*

class KeyboardActivity : AppCompatActivity() {
    companion object {
        private const val TAG = "KeyboardActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nt_nothing)

        SoleHeightProvider(this).init().setHeightListener { height ->
            height_result.text = "键盘高度为$height"
            Log.d(TAG, "键盘高度为$height")
        }
    }
}
