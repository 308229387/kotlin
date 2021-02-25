package com.example.kotlin.activity

import android.os.Bundle
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
    }
}