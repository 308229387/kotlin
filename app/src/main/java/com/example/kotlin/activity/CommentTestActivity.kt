package com.example.kotlin.activity

import android.graphics.Typeface
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlin.R
import com.example.kotlin.fragment.AddCommentFragment
import kotlinx.android.synthetic.main.activity_comment_layout.*
import kotlinx.android.synthetic.main.news_view_footer_layout.view.*

class CommentTestActivity : AppCompatActivity() {
    private var dialogFragment: AddCommentFragment = AddCommentFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comment_layout)
        toolbar_container_frame.wright_box.setOnClickListener {
            dialogFragment.show(supportFragmentManager, "")
        }

        dialogFragment.setSendListener(object : AddCommentFragment.ActionListener {
            override fun send(str: String) {
                if (str.isNotEmpty()) {
                    Toast.makeText(this@CommentTestActivity, str, Toast.LENGTH_SHORT).show()
                }
            }
        })

        toolbar_container_frame.footer_favorite.setStatus(true)

        toolbar_container_frame.footer_favorite.setOnClickListener {
            val status = toolbar_container_frame.footer_favorite.isChecked()
            toolbar_container_frame.footer_favorite.setStatus(status)
        }

        val typeface: Typeface =
            Typeface.createFromAsset(assets, "fonts/YouSheBiaoTiHei.ttf")

        comment_emoji.typeface = typeface
        comment_text.typeface = typeface

        comment_text.setOnClickListener {
            dialogFragment.show(supportFragmentManager, "")
        }
        comment_emoji.setOnClickListener {
            dialogFragment.show(supportFragmentManager, "VideoCommentExpress")
        }
    }
}