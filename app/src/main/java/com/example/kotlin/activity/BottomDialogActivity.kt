package com.example.kotlin.activity

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlin.R
import com.example.kotlin.fragment.AddCommentFragment
import com.google.android.material.bottomsheet.BottomSheetDialog

/**
 * FileName: BottomsheetActivity
 * Author: sym
 * Date: 2021/3/3 4:22 PM
 */
class BottomDialogActivity : AppCompatActivity() {
    private var bottomSheetDialog: BottomSheetDialog? = null
    private var dialogFragment: AddCommentFragment = AddCommentFragment()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comment_multi)
        showSheetDialog()

    }

    private fun showSheetDialog() {
        if (bottomSheetDialog != null) {
            bottomSheetDialog!!.show()
            return
        }
        val view = View.inflate(this, R.layout.dialog_bottomsheet, null)
        val iv_dialog_close = view.findViewById<View>(R.id.dialog_bottomsheet_iv_close) as ImageView
        val rl_comment = view.findViewById<View>(R.id.rl_comment) as RelativeLayout
        iv_dialog_close.setOnClickListener { v: View? -> bottomSheetDialog!!.dismiss() }
        rl_comment.setOnClickListener {  dialogFragment.show(supportFragmentManager, "")}
        bottomSheetDialog = BottomSheetDialog(this, R.style.dialog)
        bottomSheetDialog!!.setContentView(view)
        bottomSheetDialog!!.setCanceledOnTouchOutside(true)
    }

    fun show(view: View?) {
        bottomSheetDialog!!.show()
    }


}