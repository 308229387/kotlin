package com.example.kotlin.activity

import android.content.Context
import android.os.Bundle
import android.util.DisplayMetrics
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
            height_result.text = "键盘高度为$height     导航栏高度为${getNavigationHeight(this)} "
            Log.d(TAG, "键盘高度为$height")
        }
    }


    private fun getNavigationHeight(context: Context): Int {
        var windowheight: Int = windowManager.defaultDisplay.height
        Log.d("song_test", "无导航栏状态栏时窗口高度 = $windowheight")
        var fullheigh = 0;   //窗口总高度
        var display = windowManager.defaultDisplay
        var dm = DisplayMetrics()
        try {
            var klass = Class.forName("android.view.Display")

            var method = klass.getMethod("getRealMetrics", DisplayMetrics::class.java)
            method.invoke(display, dm)
            fullheigh = dm.heightPixels

        } catch (e: Exception) {
            e.printStackTrace()
        }
        Log.d("song_test", "有导航栏状态栏时窗口高度  fullheigh = $fullheigh")
        if (windowheight == fullheigh) return 0;   //无虚拟导航栏存在
        Log.d("song_test", "栏状态栏高度   =   ${getStatusBarHeight(context)}");

        return fullheigh - windowheight - getStatusBarHeight(context);  //导航栏高度
    }

    private fun getStatusBarHeight(context: Context): Int {
        var result = 0
        val resourceId = context.resources
            .getIdentifier("status_bar_height", "dimen", "android")
        if (resourceId > 0) {
            result = context.resources.getDimensionPixelSize(resourceId)
        }
        return result
    }

}
