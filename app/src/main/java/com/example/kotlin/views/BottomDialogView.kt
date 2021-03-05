package com.example.kotlin.views

import android.content.Context
import android.view.Gravity
import android.view.View
import android.view.WindowManager
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.fragment.app.FragmentActivity
import com.example.kotlin.R
import com.example.kotlin.fragment.AddCommentFragment
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.dialog_bottomsheet.view.*

/**
 * FileName: BottomDialogView
 * Author: sym
 * Date: 2021/3/3 7:12 PM
 */
class BottomDialogView : BottomSheetDialog {
    private var dialogFragment: AddCommentFragment = AddCommentFragment()

    constructor(context: Context) : this(context, R.style.dialog)

    constructor(context: Context, theme: Int) : super(context, theme) {

        window?.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_NOTHING);


        val view = View.inflate(context, R.layout.dialog_bottomsheet, null)
        val iv_dialog_close = view.dialog_bottomsheet_iv_close
        val rl_comment = view.rl_comment
        val mWebView = view.dialog_web_view
        mWebView.loadUrl("www.baidu.com");//加载url

        iv_dialog_close.setOnClickListener { dismiss() }
        rl_comment.setOnClickListener {
            if (context is FragmentActivity)
                dialogFragment.show(context.supportFragmentManager, "")
        }

        setContentView(view)
        setCanceledOnTouchOutside(true)
    }

}