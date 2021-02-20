package com.example.kotlin.fragment

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.*
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.ImageSwitcher
import androidx.fragment.app.DialogFragment
import com.example.kotlin.R
import com.example.kotlin.data.Emotion
import com.example.kotlin.utils.EmotionHelper
import com.example.kotlin.utils.HeightProvider
import com.example.kotlin.views.EmotionEditText
import com.example.kotlin.views.EmotionPanelView
import kotlinx.android.synthetic.main.add_fragment_layout.*
import kotlinx.android.synthetic.main.add_fragment_layout.view.*

class AddCommentFragment : DialogFragment() {
    private lateinit var vEmojiSwitcher: ImageSwitcher
    private lateinit var mEditText: EditText
    private lateinit var mPanelView: EmotionPanelView
    private var mIsKeyboardActive = false //　输入法是否激活
    private var keyboardHeight = 0 //　键盘高度
    private var layoutHeight = 0 //　配置的布局高度
    private var viewHeight = 0 //　布局高度
    private lateinit var mWindow: Window
    private lateinit var mView: View
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.add_fragment_layout, null)
        initView(view)
        setOnListener()
        initDialog()
        return view
    }

    //初始化控件
    private fun initView(view: View) {
        mView = view
        mWindow = this.dialog?.window!!
        vEmojiSwitcher = view.emoji_switcher
        mEditText = view.edt_comment
        mPanelView = view.panel_view
    }

    //初始化dialog
    private fun initDialog() {
        this.dialog!!.requestWindowFeature(Window.FEATURE_NO_TITLE)
        val window = this.dialog!!.window
        window!!.decorView.setPadding(0, 0, 0, 0)
        val lp = window.attributes
        lp.width = WindowManager.LayoutParams.MATCH_PARENT
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT
        lp.gravity = Gravity.BOTTOM
        lp.windowAnimations = R.style.BottomDialogAnimation
        window.attributes = lp
        window.setBackgroundDrawable(ColorDrawable())
    }

    //设置监听
    @SuppressLint("ClickableViewAccessibility")
    private fun setOnListener() {
        dialog!!.setOnShowListener {
            showKeyBoard(edt_comment)
            viewHeight = mView.measuredHeight
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
        dialog!!.setOnKeyListener { dialog, keyCode, _ ->
            val b = if (keyCode == KeyEvent.KEYCODE_BACK) {
                dialog.dismiss()
                false
            } else keyCode != KeyEvent.KEYCODE_DEL
            b
        }

        //表情键
        vEmojiSwitcher.setOnClickListener {
            if (mIsKeyboardActive) {
                clickEmoji()
                switchEmoji(1)
                mPanelView.visibility = View.VISIBLE
                hideKeyBoard(mEditText)
            } else {
                switchEmoji(0)
                showKeyBoard(mEditText)
                mPanelView.postDelayed({
                    dismissEmoji()
                    mPanelView.visibility = View.GONE
                }, 250)
            }
        }

        mPanelView.setEmotionClickListener(object : EmotionPanelView.OnEmotionClickListener {
            override fun onEmotionClick(emotion: Emotion?) {
                when (emotion) {
                    Emotion.DEL -> {
                        var flag = false
                        if (mEditText is EmotionEditText) {
                            val inputConnection = (mEditText as EmotionEditText).getInputConnection()
                            if (inputConnection != null) {
                                inputConnection.sendKeyEvent(
                                    KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_DEL)
                                )
                                flag = true
                            }
                        }
                        if (!flag) {
                            EmotionHelper.deleteEmotion(mEditText)
                        }
                    }
                    else -> {
                        EmotionHelper.appendEmotion(mEditText, emotion!!)
                    }
                }
            }
        })

        //开启获取键盘高度监听
        setKeyboardHeightListener()
    }

    private fun clickEmoji() {
        val params = mWindow.attributes
        params.y = layoutHeight
        mWindow.attributes = params
        mWindow.setGravity(Gravity.TOP)
    }

    private fun dismissEmoji() {
        val params = mWindow.attributes
        params.y = 0
        mWindow.attributes = params
        mWindow.setGravity(Gravity.BOTTOM)
    }

    //显示键盘
    private fun showKeyBoard(v: View) {
        v.isFocusable = true
        v.isFocusableInTouchMode = true
        v.requestFocus()
        val imm = activity?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0)
        imm.showSoftInput(v, InputMethodManager.SHOW_IMPLICIT)
    }

    //隐藏键盘
    private fun hideKeyBoard(v: View?) {
        if (v == null || activity == null) {
            return
        }
        val imm = activity?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(v.windowToken, 0)
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

    //高度监听
    private fun setKeyboardHeightListener() {
        HeightProvider(this.activity).init().setHeightListener { heightMax, height ->
            keyboardHeight = height
            mIsKeyboardActive = HeightProvider.isKeyboardShowing()

            if (mIsKeyboardActive) {
                val params = mPanelView.layoutParams
                params.height = keyboardHeight
                mPanelView.layoutParams = params
                layoutHeight = heightMax - height - viewHeight - getTopBarHeight()!!
            }
        }
    }

    //获取状态栏高度
    private fun getTopBarHeight(): Int? {
        val resourceId: Int? = activity?.resources?.getIdentifier("status_bar_height", "dimen", "android")
        return activity?.resources?.getDimensionPixelSize(resourceId!!)
    }

}