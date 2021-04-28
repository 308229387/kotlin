package com.example.kotlin.activity

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlin.R
import com.example.kotlin.views.BottomDialogView

/**
 * FileName: BottomsheetActivity
 * Author: sym
 * Date: 2021/3/3 4:22 PM
 */
class BottomDialogActivity : AppCompatActivity() {
    private lateinit var bottomSheetDialog: BottomDialogView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comment_multi)
        bottomSheetDialog = BottomDialogView(this)
    }

    //不能删除里面的参数，不然会崩
    fun show(view: View?) {
        bottomSheetDialog!!.show()
    }

}