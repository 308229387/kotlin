package com.example.kotlin

import android.content.Context
import android.content.DialogInterface
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.*
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import kotlinx.android.synthetic.main.one_add_fragment_layout.*
import kotlinx.android.synthetic.main.one_add_fragment_layout.view.*

class OneAddCommentFragment : DialogFragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.one_add_fragment_layout, null)
        this.dialog!!.requestWindowFeature(Window.FEATURE_NO_TITLE)
        setOnListener(view)
        initDialog()
        return view
    }

    //加载dialog
    private fun initDialog() {
        var window = this.dialog!!.window
        window!!.decorView.setPadding(0, 0, 0, 0)
        val lp = window!!.attributes
        lp.width = WindowManager.LayoutParams.MATCH_PARENT
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT
        lp.gravity = Gravity.BOTTOM
        lp.windowAnimations = R.style.BottomDialogAnimation
        window.attributes = lp
        window.setBackgroundDrawable(ColorDrawable())
    }

    private fun setOnListener(view: View) {
        dialog!!.setOnShowListener {
            showKeyBoard(edt_comment)
        }

        //隐藏输入法键盘
        dialog!!.window!!.decorView.setOnTouchListener { _, event ->
            if (event!!.action == MotionEvent.ACTION_DOWN) {
                if (dialog?.currentFocus?.windowToken != null) {
                    hideKeyBoard(edt_comment)
                }
            }
            false
        }

        //back键
        dialog!!.setOnKeyListener(DialogInterface.OnKeyListener { dialog, keyCode, _ ->
            val b = if (keyCode == KeyEvent.KEYCODE_BACK) {
                dialog.dismiss()
                false
            } else keyCode != KeyEvent.KEYCODE_DEL
            b
        })

        view.dialog_send.setOnClickListener {
            Toast.makeText(activity, edt_comment.text, Toast.LENGTH_SHORT).show()
            hideKeyBoard(edt_comment)
            dialog!!.dismiss()
        }
    }

    private fun showKeyBoard(v: View) {
        if (v != null) {
            v.isFocusable = true
            v.isFocusableInTouchMode = true
            v.requestFocus()
        }
        val imm = activity?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0)
        imm.showSoftInput(v, InputMethodManager.SHOW_IMPLICIT)
    }

    private fun hideKeyBoard(v: View?) {
        if (v == null || activity == null) {
            return
        }
        val imm = activity?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(v.windowToken, 0)
    }
}