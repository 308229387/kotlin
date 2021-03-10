package com.example.kotlin.fragment

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Typeface
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.*
import android.view.inputmethod.InputMethodManager
import android.widget.*
import androidx.fragment.app.DialogFragment
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.kotlin.R
import com.example.kotlin.data.Emotion
import com.example.kotlin.data.Expression
import com.example.kotlin.utils.EmotionHelper
import com.example.kotlin.utils.HeightProvider
import com.example.kotlin.views.EmotionEditText
import com.example.kotlin.views.EmotionGifPanelView
import com.example.kotlin.views.EmotionPanelView
import kotlinx.android.synthetic.main.add_fragment_layout.*
import kotlinx.android.synthetic.main.add_fragment_layout.view.*

class AddCommentFragment : DialogFragment() {
    private lateinit var panelView: RelativeLayout
    private lateinit var gifPanelView: EmotionGifPanelView
    private lateinit var emotionPanelView: EmotionPanelView

    private lateinit var vGifSwitcher: CheckBox
    private lateinit var vEmojiSwitcher: CheckBox

    private lateinit var gifShowLayout: RelativeLayout
    private lateinit var gifShowView: ImageView
    private lateinit var gifCloseView: ImageView
    private lateinit var sendBtn: Button
    private lateinit var actionListener: ActionListener


    private lateinit var withoutLayout: View
    private lateinit var mEditText: EditText
    private var mIsKeyboardActive = false //　输入法是否激活
    private var keyboardHeight = 0 //　键盘高度
    private var layoutHeight = 0 //　配置的布局高度
    private var viewHeight = 0 //　布局高度
    private lateinit var mWindow: Window
    private lateinit var mView: View
    private var fromExpression: Boolean = false

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
        panelView = view.panel_view
        emotionPanelView = view.panel_emotion_view
        gifPanelView = view.panel_gif_view
        gifShowLayout = view.gif_show_layout
        gifShowView = view.iv_gif_emotion
        gifCloseView = view.iv_gif_emotion_close
        vGifSwitcher = view.gif_switcher
        sendBtn = view.btn_send

        vEmojiSwitcher = view.emoji_switcher
        mEditText = view.edt_comment
        withoutLayout = view.without_layout


        val typeface: Typeface =
            Typeface.createFromAsset(activity?.assets, "fonts/YouSheBiaoTiHei.ttf")
        vEmojiSwitcher.typeface = typeface
        vGifSwitcher.typeface = typeface
    }

    //初始化dialog
    private fun initDialog() {
        this.dialog!!.requestWindowFeature(Window.FEATURE_NO_TITLE)
        val window = this.dialog!!.window
        window!!.decorView.setPadding(0, 0, 0, 0)
        window?.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_NOTHING);//这句是不让键盘影响布局

        val lp = window.attributes
        lp.width = WindowManager.LayoutParams.MATCH_PARENT//不要设置高不然会被键盘影响
        lp.gravity = Gravity.BOTTOM
        lp.windowAnimations = R.style.BottomDialogAnimation
        window.attributes = lp
        window.setBackgroundDrawable(ColorDrawable())
    }

    //设置监听
    @SuppressLint("ClickableViewAccessibility")
    private fun setOnListener() {
        sendBtn.setOnClickListener {
            actionListener.send(edt_comment.text.toString())
        }

        withoutLayout.setOnClickListener {
            if (mIsKeyboardActive) {
                hideKeyBoard(edt_comment)
            }
            dismiss()
        }

        dialog!!.setOnShowListener {
            if (!fromExpression) {
                showKeyBoard(edt_comment)
                viewHeight = mView.measuredHeight
            }
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

        vEmojiSwitcher.setOnCheckedChangeListener { _, checked ->
            tempClose()
            if (checked) {
                panelView.visibility = View.VISIBLE
                emotionPanelView.visibility = View.VISIBLE
                vGifSwitcher.isChecked = false
                hideKeyBoard(mEditText)
            } else {
                emotionPanelView.visibility = View.GONE
                emotionPanelView.postDelayed({
                    if (!vGifSwitcher.isChecked) {
                        panelView.visibility = View.INVISIBLE
                    }
                }, 250)
            }
        }

        vGifSwitcher.setOnCheckedChangeListener { _, checked ->
            tempClose()
            if (checked) {
                panelView.visibility = View.VISIBLE
                gifPanelView.visibility = View.VISIBLE
                vEmojiSwitcher.isChecked = false
                hideKeyBoard(mEditText)

            } else {
                gifPanelView.visibility = View.GONE
                gifPanelView.postDelayed({
                    if (!vEmojiSwitcher.isChecked) {
                        panelView.visibility = View.INVISIBLE
                    }
                }, 250)
            }
        }

        gifCloseView.setOnClickListener { gifShowLayout.visibility = View.GONE }

        gifPanelView.setGifClickListener(object : EmotionGifPanelView.OnGifClickListener {
            override fun onGifClick(gif: Expression?) {
                gifShowLayout.visibility = View.VISIBLE

                Glide.with(activity!!)
                    .setDefaultRequestOptions(RequestOptions().frame(1000000))
                    .load(gif!!.url)
                    .into(gifShowView)

            }

        })

        emotionPanelView.setEmotionClickListener(object : EmotionPanelView.OnEmotionClickListener {
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

    //防止连续点击
    private fun tempClose() {
        vEmojiSwitcher.isClickable = false
//        vGifSwitcher.isClickable = false
        panelView.postDelayed({
            vEmojiSwitcher.isClickable = true
//            vGifSwitcher.isClickable = true
        }, 300)
        vEmojiSwitcher.isClickable = false
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

    //高度监听
    private fun setKeyboardHeightListener() {
        HeightProvider(this.activity).init().setHeightListener { heightMax, height ->
            keyboardHeight = height
            mIsKeyboardActive = HeightProvider.isKeyboardShowing()
            if (mIsKeyboardActive) {
                val params = panelView.layoutParams
                params.height = keyboardHeight
                panelView.layoutParams = params
                panelView.visibility = View.VISIBLE
                if (getTopBarHeight() != null) {
                    layoutHeight = heightMax - height - viewHeight - getTopBarHeight()!!
                }
            } else if (keyboardHeight == 0 && gifPanelView.visibility != View.VISIBLE && emotionPanelView.visibility != View.VISIBLE) {
                panelView.visibility = View.GONE
            }
        }
    }


    //获取状态栏高度
    private fun getTopBarHeight(): Int? {
        val resourceId: Int? = activity?.resources?.getIdentifier("status_bar_height", "dimen", "android")
        return activity?.resources?.getDimensionPixelSize(resourceId!!)
    }


    fun setSendListener(actionListener: ActionListener) {
        this.actionListener = actionListener
    }

    interface ActionListener {
        fun send(str: String)
    }

}