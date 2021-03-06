package com.example.kotlin.fragment

import android.annotation.SuppressLint
import android.app.ActionBar
import android.content.Context
import android.content.DialogInterface
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
import com.example.kotlin.utils.ToolsUtil
import com.example.kotlin.views.EmotionEditText
import com.example.kotlin.views.EmotionGifPanelView
import com.example.kotlin.views.EmotionPanelView
import kotlinx.android.synthetic.main.add_fragment_layout.*
import kotlinx.android.synthetic.main.add_fragment_layout.view.*

class AddCommentFragment : DialogFragment() {
    private lateinit var gifPanelView: EmotionGifPanelView
    private lateinit var emotionPanelView: EmotionPanelView
    private lateinit var panelView: RelativeLayout
    private lateinit var headBackView: LinearLayout
    private lateinit var normWithoutLayout: View
    private lateinit var vGifSwitcher: CheckBox
    private lateinit var vEmojiSwitcher: CheckBox
    private lateinit var specialWithoutLayout: LinearLayout

    private lateinit var gifShowLayout: RelativeLayout
    private lateinit var gifShowView: ImageView
    private lateinit var gifCloseView: ImageView
    private lateinit var sendBtn: Button
    private lateinit var actionListener: ActionListener

    private var gifData: Expression? = null

    private lateinit var withoutLayout: View
    private lateinit var mEditText: EditText
    private var mIsKeyboardActive = false //　输入法是否激活
    private var keyboardHeight = 0 //　键盘高度
    private var layoutHeight = 0 //　配置的布局高度
    private var viewHeight = 0 //　布局高度
    private lateinit var mWindow: Window
    private lateinit var mView: View
    private var fromExpression: Boolean = false
    private var heightParams: HeightParams = HeightParams(0)

    companion object {
        const val TAG = "VideoCommentExpress"
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.add_fragment_layout, null)
        initView(view)
        setOnListener()
        initDialog()
        judgeMobile()
        chooseSource()
        return view
    }

    private fun chooseSource() {
        if (tag == TAG) {
            fromExpression = true
            val params = panelView.layoutParams
            params.height = 835
            panelView.layoutParams = params
            layoutHeight = 1091
            vEmojiSwitcher.postDelayed({
                vEmojiSwitcher.isChecked = true
            }, 250)
        } else {
            fromExpression = false
        }
    }

    private fun judgeMobile() {
        if (ToolsUtil.judgePhone()) {
            specialWithoutLayout.visibility = View.VISIBLE
        } else {
            normWithoutLayout.visibility = View.VISIBLE
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
        normWithoutLayout = view.norm_without_layout
        specialWithoutLayout = view.special_without_layout1
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
        this.dialog!!.requestWindowFeature(Window.FEATURE_NO_TITLE)
        val window = this.dialog!!.window
        window!!.decorView.setPadding(0, 0, 0, 0)
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
            if (gifData != null) {
                actionListener.send(mEditText.text.toString() + gifData?.content)
                gifData = null
            } else {
                actionListener.send(mEditText.text.toString())
            }
            mEditText.setText("")
            closeDialog()
            dismiss()
        }

        //back键
        dialog!!.setOnKeyListener { _, keyCode, _ ->
            val b = if (keyCode == KeyEvent.KEYCODE_BACK) {
                closeDialog()
                false
            } else keyCode != KeyEvent.KEYCODE_DEL
            b
        }

        normWithoutLayout.setOnClickListener {
            closeDialog()
            dismiss()
        }
        specialWithoutLayout.setOnClickListener {
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
                panelView.visibility = View.VISIBLE
                emotionPanelView.visibility = View.VISIBLE
                vGifSwitcher.isChecked = false
                hideKeyBoard(mEditText)
                //规避显示面板时，点击EditText逻辑冲突
            } else if (ToolsUtil.isCustomFastStatus(500)) {
                emotionPanelView.visibility = View.GONE
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

        vGifSwitcher.setOnCheckedChangeListener { _, checked ->
            tempClose()
            if (checked) {
                panelView.visibility = View.VISIBLE
                gifPanelView.visibility = View.VISIBLE
                vEmojiSwitcher.isChecked = false
                hideKeyBoard(mEditText)
                //规避显示面板时，点击EditText逻辑冲突
            } else if (ToolsUtil.isCustomFastStatus(500)) {
                gifPanelView.visibility = View.GONE
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

        gifCloseView.setOnClickListener {
            gifShowLayout.visibility = View.GONE
            gifData = null
            if (ToolsUtil.judgePhone()) {
                specialWithoutLayout.layoutParams.height = heightParams.normWithoutHeight
                headBackView.layoutParams.height = ToolsUtil.dp2px(requireContext(), 114f)
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

                if (ToolsUtil.judgePhone())
                    specialWithoutLayout.layoutParams.height = heightParams.normWithoutHeight - ToolsUtil.dp2px(requireContext(), 63f)
                headBackView.layoutParams.height = ActionBar.LayoutParams.WRAP_CONTENT
            }

        })

        //开启获取键盘高度监听
        setKeyboardHeightListener()

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

                if (ToolsUtil.judgePhone()) {
                    if (::headBackView.isInitialized && getTopBarHeight() != null) {
                        layoutHeight = heightMax - height - ToolsUtil.dp2px(requireContext(), 114f) - getTopBarHeight()!!
                        //正常显示时的蒙层高度
                        if (heightParams.normWithoutHeight == 0) {
                            heightParams.normWithoutHeight = layoutHeight
                        }
                        if (gifShowLayout.visibility == View.GONE) {
                            specialWithoutLayout.layoutParams.height = heightParams.normWithoutHeight
                        }
                    }
                }


            } else if (keyboardHeight == 0 && gifPanelView.visibility != View.VISIBLE && emotionPanelView.visibility != View.VISIBLE) {
                panelView.visibility = View.GONE
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

    data class HeightParams(
        var normWithoutHeight: Int
    )


}