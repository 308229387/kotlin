package com.example.kotlin.fragment

import android.annotation.SuppressLint
import android.content.Context
import android.content.DialogInterface
import android.graphics.Typeface
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.*
import android.view.inputmethod.InputMethodManager
import android.widget.*
import androidx.fragment.app.DialogFragment
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.kotlin.R
import com.example.kotlin.data.Emotion
import com.example.kotlin.data.Expression
import com.example.kotlin.data.HawkConfig
import com.example.kotlin.utils.EmotionHelper
import com.example.kotlin.utils.HeightProvider
import com.example.kotlin.utils.ToolsUtil
import com.example.kotlin.views.EmotionEditText
import com.example.kotlin.views.EmotionGifPanelView
import com.example.kotlin.views.EmotionPanelView
import com.orhanobut.hawk.Hawk
import kotlinx.android.synthetic.main.add_fragment_layout.*
import kotlinx.android.synthetic.main.add_fragment_layout.view.*

class AddCommentFragment : DialogFragment() {
    private lateinit var vEmojiSwitcher: CheckBox
    private lateinit var vGifSwitcher: CheckBox
    private lateinit var mEditText: EditText
    private lateinit var emotionPanelView: EmotionPanelView//高度是动态分配的
    private lateinit var gifPanelView: EmotionGifPanelView
    private lateinit var gifShowLayout: RelativeLayout
    private lateinit var panelView: RelativeLayout
    private lateinit var headBackView: LinearLayout
    private lateinit var gifShowView: ImageView
    private lateinit var gifCloseView: ImageView
    private lateinit var sendBtn: Button
    private lateinit var actionListener: ActionListener
    private var gifData: Expression? = null
    private var mIsKeyboardActive = false //　输入法是否激活
    private var keyboardHeight = 0 //　键盘高度
    private var layoutHeight = 0 //　配置的布局高度
    private var showKeyTime = 0 //　部分机型重复显示键盘次数
    private lateinit var mWindow: Window
    private lateinit var mView: View
    private var fromExpression: Boolean = false


    @SuppressLint("InflateParams")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.add_fragment_layout, null)
        initView(view)
        setOnListener()
        initDialog()
        chooseSource()
        return view
    }

    private fun chooseSource() {
        if (tag == "VideoCommentExpress") {
            fromExpression = true
            //键盘高度主要用于普通机型
            val panelParams = panelView.layoutParams
            if (Hawk.get(HawkConfig.KeyboardHeight, 0) != 0) {
                panelParams.height = Hawk.get<Int>(HawkConfig.KeyboardHeight)
            } else {
                panelParams.height = ViewGroup.LayoutParams.WRAP_CONTENT
            }
            panelView.layoutParams = panelParams

            vEmojiSwitcher.postDelayed({
                vEmojiSwitcher.isChecked = true
            }, 250)
        } else {
            fromExpression = false
        }
    }

    //初始化控件
    private fun initView(view: View) {
        mView = view
        mWindow = this.dialog?.window!!
        vEmojiSwitcher = view.emoji_switcher
        vGifSwitcher = view.gif_switcher
        mEditText = view.edt_comment
        emotionPanelView = view.panel_emotion_view
        gifPanelView = view.panel_gif_view
        panelView = view.panel_view
        headBackView = view.head_back_view
        gifShowLayout = view.gif_show_layout
        gifShowView = view.iv_gif_emotion
        gifCloseView = view.iv_gif_emotion_close
        sendBtn = view.btn_send

        val typeface: Typeface =
            Typeface.createFromAsset(activity?.assets, "fonts/YouSheBiaoTiHei.ttf")
        vEmojiSwitcher.typeface = typeface
        vGifSwitcher.typeface = typeface
    }

    //初始化dialog
    private fun initDialog() {
        val window = this.dialog!!.window
        window!!.decorView.setPadding(0, 0, 0, 0)
        window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_NOTHING)

        val lp = window.attributes
        lp.gravity = Gravity.BOTTOM
        lp.windowAnimations = R.style.BottomDialogAnimation
        window.attributes = lp
        window.setBackgroundDrawable(ColorDrawable())
    }

    //设置监听
    @SuppressLint("ClickableViewAccessibility")
    private fun setOnListener() {
        dialog!!.setOnShowListener {
            if (!fromExpression) {
                showKeyBoard(edt_comment)
            }
            if (gifData != null) {
                showGifImage(gifData)
            }
        }

        //点击外部灰色区域
        dialog!!.window!!.decorView.setOnTouchListener { _, event ->
            if (event!!.action == MotionEvent.ACTION_DOWN) {
                if (dialog?.currentFocus?.windowToken != null) {
                    closeDialog()
                }
            }
            false
        }

        sendBtn.setOnClickListener {
            when {
                mEditText.text.length > 400 -> {
                    Toast.makeText(activity, "评论字数需要在400字以内哦", Toast.LENGTH_SHORT).show()
                }
                mEditText.text.isEmpty() && gifData == null -> {
                    Toast.makeText(activity, "评论字数需要在400字以内哦", Toast.LENGTH_SHORT).show()
                }
                else -> {
                    if (::actionListener.isInitialized) {
                        if (gifData != null) {
                            actionListener.send(mEditText.text.toString() + gifData?.content)
                        } else {
                            actionListener.send(mEditText.text.toString())
                        }
                        mEditText.setText("")
                        gifData = null
                    }
                    closeDialog()
                    dismiss()
                }
            }
        }

        //back键
        dialog!!.setOnKeyListener { _, keyCode, _ ->
            val b = if (keyCode == KeyEvent.KEYCODE_BACK) {
                closeDialog()
                false
            } else keyCode != KeyEvent.KEYCODE_DEL
            b
        }

        headBackView.setOnClickListener {
            closeDialog()
            dismiss()
        }

        //不能删，承接touchdown事件，删除会有bug
        gifShowLayout.setOnClickListener {

        }

        mEditText.setOnClickListener {
            if (ToolsUtil.isCustomFastStatus(500))
                shutDownState()
        }

        vEmojiSwitcher.setOnCheckedChangeListener { _, checked ->
            tempClose()
            if (checked) {
                headBackView.layoutParams.height = Hawk.get(HawkConfig.HeadViewHeight, 1300)
                panelView.visibility = View.VISIBLE
                emotionPanelView.visibility = View.VISIBLE
                vGifSwitcher.isChecked = false
                hideKeyBoard(mEditText)
            } else {
                emotionPanelView.visibility = View.GONE
                if (ToolsUtil.isCustomFastStatus(500)) {
                    if (!vGifSwitcher.isChecked) {
                        //规避显示panelView时会弹起键盘
                        if (ToolsUtil.isCustomFastClick(500))
                            showKeyBoard(mEditText)
                        emotionPanelView.postDelayed({
                            panelView.visibility = View.INVISIBLE
                        }, 250)
                    }
                }
            }
        }


        vGifSwitcher.setOnCheckedChangeListener { _, checked ->
            tempClose()
            if (checked) {
                headBackView.layoutParams.height = Hawk.get(HawkConfig.HeadViewHeight, 1300)
                panelView.visibility = View.VISIBLE
                gifPanelView.visibility = View.VISIBLE
                vEmojiSwitcher.isChecked = false
                hideKeyBoard(mEditText)
            } else {
                gifPanelView.visibility = View.GONE
                if (ToolsUtil.isCustomFastStatus(500)) {
                    if (!vEmojiSwitcher.isChecked) {
                        //规避显示panelView时会弹起键盘
                        if (ToolsUtil.isCustomFastClick(500))
                            showKeyBoard(mEditText)
                        gifPanelView.postDelayed({
                            panelView.visibility = View.INVISIBLE
                        }, 250)
                    }

                }
            }
        }

        gifCloseView.setOnClickListener {
            gifShowLayout.visibility = View.GONE
            gifData = null

            if (mEditText.text.isEmpty()) {
                btnCanNotSendState()
            }
        }

        emotionPanelView.setEmotionClickListener(object : EmotionPanelView.OnEmotionClickListener {
            override fun onEmotionClick(emotion: Emotion?) {
                when (emotion) {
                    Emotion.DEL -> {
                        var flag = false
                        if (mEditText is EmotionEditText) {
                            val inputConnection =
                                (mEditText as EmotionEditText).getInputConnection()
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

        gifPanelView.setGifClickListener(object : EmotionGifPanelView.OnGifClickListener {
            override fun onGifClick(gif: Expression?) {
                gifShowLayout.visibility = View.VISIBLE

                Glide.with(activity!!)
                    .setDefaultRequestOptions(RequestOptions().frame(1000000))
                    .load(gif!!.url)
                    .into(gifShowView)

                gifData = gif

                btnCanSendState()
            }

        })

        mEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            @SuppressLint("ResourceAsColor")
            override fun afterTextChanged(p0: Editable?) {
                if (p0.toString() == "" && gifData == null) {
                    btnCanNotSendState()
                } else {
                    btnCanSendState()
                }
            }

        })

        //开启获取键盘高度监听
        setKeyboardHeightListener()
    }

    private fun btnCanSendState() {
        sendBtn.setBackgroundResource(R.drawable.btn_comment_can_send)
        sendBtn.setTextColor(resources.getColor(R.color.black))
    }

    private fun btnCanNotSendState() {
        sendBtn.setBackgroundResource(R.drawable.btn_comment_can_not_send)
        sendBtn.setTextColor(resources.getColor(R.color.commentSendBtn))
    }

    private fun showGifImage(gif: Expression?) {
        gifShowLayout.visibility = View.VISIBLE

        Glide.with(requireActivity())
            .setDefaultRequestOptions(RequestOptions().frame(1000000))
            .load(gif!!.url)
            .into(gifShowView)

        gifData = gif

        btnCanSendState()
    }

    //防止连续点击
    private fun tempClose() {
        vEmojiSwitcher.isClickable = false
        vGifSwitcher.isClickable = false
        panelView.postDelayed({
            vEmojiSwitcher.isClickable = true
            vGifSwitcher.isClickable = true
        }, 500)
        vEmojiSwitcher.isClickable = false
    }

    private fun closeDialog() {
        if (mIsKeyboardActive) {
            hideKeyBoard(mEditText)
        }
        if (ToolsUtil.isCustomFastClick(500))
            shutDownState()
    }

    private fun shutDownState() {
        if (vEmojiSwitcher.isChecked)
            vEmojiSwitcher.isChecked = false
        if (vGifSwitcher.isChecked)
            vGifSwitcher.isChecked = false
    }

    //显示键盘
    private fun showKeyBoard(v: View) {
        v.isFocusable = true
        v.isFocusableInTouchMode = true
        v.requestFocus()
        if (activity?.getSystemService(Context.INPUT_METHOD_SERVICE) != null) {
            val imm = activity?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0)
            imm.showSoftInput(v, InputMethodManager.SHOW_IMPLICIT)
            v.postDelayed({//部分机型有一定概率弹不出键盘，会重复尝试弹3次
                if (!mIsKeyboardActive && showKeyTime < 4) {
                    showKeyTime++
                    showKeyBoard(v)
                    Log.d("song_test", "重复弹起键盘  showKeyTime = $showKeyTime")
                } else {
                    showKeyTime = 0
                }
            }, 500)
        }
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
            Log.d("song_test", "keyboardHeight = $keyboardHeight")
            mIsKeyboardActive = HeightProvider.isKeyboardShowing()
            if (Hawk.get(HawkConfig.KeyboardHeight, 0) == 0) {
                Hawk.put<Int>(HawkConfig.KeyboardHeight, keyboardHeight)
            }

            if (mIsKeyboardActive) {
                if (Hawk.get(HawkConfig.KeyboardHeight, 0) == 0) {
                    Hawk.put<Int>(HawkConfig.KeyboardHeight, keyboardHeight)
                }

                val params = panelView.layoutParams
                params.height = keyboardHeight
                panelView.layoutParams = params
                panelView.visibility = View.VISIBLE

                if (::headBackView.isInitialized && getTopBarHeight() != null) {
                    layoutHeight = heightMax - height - getTopBarHeight()!!
                    //正常显示时的蒙层高度
                    if (Hawk.get(HawkConfig.HeadViewHeight, 0) == 0) {
                        Hawk.put<Int>(HawkConfig.HeadViewHeight, layoutHeight)
                    }
                    headBackView.layoutParams.height = Hawk.get(HawkConfig.HeadViewHeight, 0)
                }


            } else if (keyboardHeight == 0 && !vEmojiSwitcher.isChecked && !vGifSwitcher.isChecked) {
                panelView.visibility = View.GONE

                if (isAdded) {
                    headBackView.layoutParams.height = heightMax - getTopBarHeight()!!
                }
            }
        }
    }


    //获取状态栏高度
    private fun getTopBarHeight(): Int? {
        val resourceId: Int? =
            activity?.resources?.getIdentifier("status_bar_height", "dimen", "android")
        return activity?.resources?.getDimensionPixelSize(resourceId!!)
    }

    fun setSendListener(actionListener: ActionListener) {
        this.actionListener = actionListener
    }

    interface ActionListener {
        fun send(str: String)
    }

    override fun onDismiss(dialog: DialogInterface) {
        super.onDismiss(dialog)
        closeDialog()
    }

    fun setHintText(text: String) {
        mEditText.hint = text
        mEditText.setText("")
    }


}