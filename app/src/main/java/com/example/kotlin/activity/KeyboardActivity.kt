package com.example.kotlin.activity

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlin.R
import com.example.kotlin.utils.HeightProvider
import kotlinx.android.synthetic.main.activity_nt_nothing.*

class KeyboardActivity : AppCompatActivity() {
    companion object {
        private const val TAG = "KeyboardActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nt_nothing)

        HeightProvider(this).init().setHeightListener { height ->
            Log.v(TAG, "获取到键盘高度$height")
            etBottom.translationY = -height.toFloat()
        }
    }
}
