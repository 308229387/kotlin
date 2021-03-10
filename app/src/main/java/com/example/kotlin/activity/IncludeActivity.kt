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

        vEmojiSwitcher = emoji_switcher

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

}