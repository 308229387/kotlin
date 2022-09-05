package com.example.kotlin.utils

import android.annotation.SuppressLint
import android.content.ClipboardManager
import android.content.Context
import android.os.Build
import android.util.DisplayMetrics
import android.util.TypedValue
import com.example.kotlin.App
import org.json.JSONArray
import java.io.ByteArrayOutputStream
import java.io.Closeable
import java.io.IOException
import java.io.InputStream
import java.text.SimpleDateFormat
import java.util.*

object ToolsUtil {
    //防止连续点击
    private var lastClickTime: Long = 0

    //自定义快速点击时间
    private var currentLastClickTime: Long = 0

    //备用自定义快速点击时间
    private var tempLastClickTime: Long = 0

    private fun close(closeable: Closeable?) {
        if (closeable != null) {
            try {
                closeable.close()
            } catch (var2: IOException) {
                var2.printStackTrace()
            }
        }
    }

    fun readAndClose(`is`: InputStream?): String? {
        val result: String = read(`is`)!!
        close(`is`)
        return result
    }

    private fun read(`is`: InputStream?): String? {
        return if (`is` == null) {
            null
        } else {
            val result = ByteArrayOutputStream()
            try {
                val buffer = ByteArray(1024)
                var length: Int
                while (`is`.read(buffer).also { length = it } != -1) {
                    result.write(buffer, 0, length)
                }
                result.toString("UTF-8")
            } catch (var4: IOException) {
                var4.printStackTrace()
                null
            }
        }
    }

    @SuppressLint("WrongConstant")
    fun getCopyText(): CharSequence? {
        val clipboard = App.getAppContext()!!.getSystemService("clipboard") as ClipboardManager
        return run {
            val clip = clipboard.primaryClip
            clip?.getItemAt(0)?.text
        }
    }

    fun dp2px(context: Context, dpVal: Float): Int {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dpVal, context.resources.displayMetrics).toInt()
    }

    fun dp2px(dpValue: Float): Int {
        return TypedValue.applyDimension(1, dpValue, DisplayMetrics()).toInt()
    }

    fun judgePhone(): Boolean {
        val manufacturer: String = Build.MANUFACTURER
        return if (manufacturer.isNotEmpty()) {
            when (manufacturer.toLowerCase(Locale.ROOT)) {
                "oppo" -> true
                else -> false

            }
        } else false
    }

    //快速点击检测
    val isFastClick: Boolean
        get() {
            val time = System.currentTimeMillis()
            val timeD = time - lastClickTime
            if (timeD <600) {
                return false
            }
            lastClickTime = time
            return true
        }

    //自定义时间检测
    fun isCustomFastClick(timeNum: Long): Boolean {
        val time = System.currentTimeMillis()
        val timeD = time - currentLastClickTime
        if (timeD < timeNum) {
            return false
        }
        currentLastClickTime = time
        return true
    }

    //备用自定义时间检测
    fun isCustomFastStatus(timeNum: Long): Boolean {
        val time = System.currentTimeMillis()
        val timeD = time - tempLastClickTime
        if (timeD < timeNum) {
            return false
        }
        tempLastClickTime = time
        return true
    }

    fun beforeAfterDate(days: Int): String? {
        val nowTime = System.currentTimeMillis()
        val changeTimes = days * 24L * 60 * 60 * 1000
        return getStrTime((nowTime + changeTimes).toString(), "yyyy-MM-dd")
    }

    fun getStrTime(timeStamp: String?, format: String?): String? {
        var timeString: String? = null
        val sdf = SimpleDateFormat(format)
        val l = java.lang.Long.valueOf(timeStamp)
        timeString = sdf.format(Date(l)) //单位秒
        return timeString
    }

    //把map数据转成json打印出来
    fun MapToJson(map: Map<String, String>?): String? {
        val maplist: MutableList<Map<String, String>?> = ArrayList()
        maplist.add(map)
        val obj = JSONArray(maplist)
        return obj.toString()
    }
}

