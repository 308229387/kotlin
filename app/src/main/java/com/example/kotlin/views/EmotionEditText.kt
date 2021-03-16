package com.example.kotlin.views

import android.annotation.SuppressLint
import android.content.Context
import android.text.InputFilter
import android.util.AttributeSet
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputConnection
import android.widget.EditText
import com.example.kotlin.utils.EmotionHelper
import com.example.kotlin.utils.ToolsUtil

@SuppressLint("AppCompatCustomView")
class EmotionEditText(context: Context, attrs: AttributeSet) : EditText(context, attrs) {
    private var mMaxLength: Int = 0
    private var inputConnection: InputConnection? = null

    init {
        init2()
    }

    private fun init2() {
        try {
            val inputFilters = filters
            if (inputFilters != null && inputFilters.isNotEmpty()) {
                for (filter in inputFilters) {
                    if (filter is InputFilter.LengthFilter) {
                        mMaxLength = filter.max
                        break
                    }
                }
            }
        } catch (e: NoSuchMethodError) {
        }

    }

    override fun onTextContextMenuItem(id: Int): Boolean {
        when (id) {
            android.R.id.paste, android.R.id.pasteAsPlainText -> {
                val text = ToolsUtil.getCopyText()
                if (text != null) {
                    val indexStart = selectionStart
                    val indexEnd = selectionEnd

                    val originText = getText().toString()
                    val finalText = originText.substring(0, indexStart) + text + originText.substring(indexEnd)

                    if (mMaxLength > 0 && finalText.length > mMaxLength) {
                        return false
                    }

                    //不要使用editable.replace方法，效率太低了！！！
                    setText(EmotionHelper.getEmotionText(finalText, textSize))

                    /*
                    光标位置确定
                     */
                    val maxLen = getText().length
                    var index = indexStart + text.length
                    if (index > maxLen) {
                        index = maxLen
                    }
                    setSelection(index)
                }
                return true
            }
            else -> {
                return super.onTextContextMenuItem(id)
            }
        }
    }

    override fun onCreateInputConnection(outAttrs: EditorInfo?): InputConnection? {
        inputConnection = super.onCreateInputConnection(outAttrs)
        return inputConnection
    }

    fun getInputConnection(): InputConnection? {
        return inputConnection
    }


}