package com.example.kotlin.activity

import android.os.Bundle
import android.view.View
import android.widget.ImageSwitcher
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlin.R
import kotlinx.android.synthetic.main.activity_include_layout.*
import kotlinx.android.synthetic.main.include_layout.*

class IncludeActivity : AppCompatActivity() {
    private lateinit var vEmojiSwitcher: ImageSwitcher
    private var switcherTag: Boolean = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_include_layout)
        tv_setting_update_app_title.setOnClickListener {
            Toast.makeText(this, tv_setting_update_app_title.text, Toast.LENGTH_SHORT).show()
        }

        var i ={x:Int,y:Int->x+y}
        i(2,3)

        var j :(Int,Int)->Int = {x,y -> x+y}

        vEmojiSwitcher = emoji_switcher

        result_for.text = forResult()

        setOnListener()
    }

  

    private fun setOnListener() {
        visible_test.setOnClickListener {
            if (include_parent.visibility == View.GONE) {
                include_parent.visibility = View.VISIBLE
            } else if (include_parent.visibility == View.VISIBLE) {
                include_parent.visibility = View.GONE
            }
        }

        //表情键
        vEmojiSwitcher.setOnClickListener {
            if (switcherTag) {
                switchEmoji(1)
                switcherTag = false
            } else {
                switchEmoji(0)
                switcherTag = true
            }

        }
    }

    //表情与键盘标记切换
    private fun switchEmoji(index: Int) {
        if (vEmojiSwitcher.displayedChild == index) {
            return
        }
        if (index == 0) {
            vEmojiSwitcher.displayedChild = 0
        } else if (index == 1) {
            vEmojiSwitcher.displayedChild = 1
        }
    }

    //区间for循环
    private fun forResult(): String {
        val temp = 1..10
        val temp1 = 1 until 10
        val temp2 = 1 until 20
        val str = StringBuffer()
        val str1 = StringBuffer()
        val str2 = StringBuffer()

        for (i in temp) {
            str.append("$i")
        }

        for (i in temp1) {
            str1.append(i)
        }

        for (i in temp2 step 2) {
            str2.append("$i ")
        }
        return "..区间for循环：$str  \n until闭区间for循环：$str1 \n step+until闭区间for循环：$str2"
    }

}