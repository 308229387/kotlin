package com.example.kotlin.views

import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.RelativeLayout
import androidx.fragment.app.FragmentActivity
import com.example.kotlin.R
import com.example.kotlin.activity.BottomDialogActivity
import com.example.kotlin.fragment.AddCommentFragment
import com.google.android.material.bottomsheet.BottomSheetDialog

/**
 * FileName: BottomDialogView
 * Author: sym
 * Date: 2021/3/3 7:12 PM
 */
class BottomDialogView : BottomSheetDialog {
    private var dialogFragment: AddCommentFragment = AddCommentFragment()

    constructor(context: Context) : this(context, R.style.dialog)

    constructor(context: Context, theme: Int) : super(context, theme) {
        val view = View.inflate(context, R.layout.dialog_bottomsheet, null)
        val iv_dialog_close = view.findViewById<View>(R.id.dialog_bottomsheet_iv_close) as ImageView
        val rl_comment = view.findViewById<View>(R.id.rl_comment) as RelativeLayout
        iv_dialog_close.setOnClickListener { dismiss() }
        rl_comment.setOnClickListener {
            if (context is FragmentActivity)
                dialogFragment.show(context.supportFragmentManager, "")
        }

        setContentView(view)
        setCanceledOnTouchOutside(true)
    }

}