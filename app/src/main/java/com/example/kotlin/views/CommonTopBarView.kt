package com.example.kotlin.views

import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.isVisible
import com.example.kotlin.R
import com.example.kotlin.databinding.ViewCommonTopBarBinding


class CommonTopBarView @JvmOverloads constructor(
  context: Context,
  attrs: AttributeSet? = null,
  defStyle: Int = 0,
) : ConstraintLayout(context, attrs, defStyle), View.OnClickListener {

  private val viewBinding by lazy {
    ViewCommonTopBarBinding.bind(
      View.inflate(
        getContext(),
        R.layout.view_common_top_bar,
        this
      )
    )
  }

  /**
   * 返回按钮点击回调
   */
  private var backCallback: OnCommonTopBarBackCallback? = null

  /**
   * 操作按钮点击回调
   */
  private var actionCallback: OnCommonTopBarActionCallback? = null

  init {
    val typeArray = context.obtainStyledAttributes(attrs, R.styleable.CommonTopBarView)
    viewBinding.tvTitle.text =
      typeArray.getText(R.styleable.CommonTopBarView_CommonTopBarView_title_text)
    typeArray.getText(R.styleable.CommonTopBarView_CommonTopBarView_action_text)?.let {
      if (it.isNotEmpty()) visibility = View.VISIBLE
      viewBinding.tvAction.text = it
    }
    typeArray.recycle()

    viewBinding.ivBack.setOnClickListener(this)
    viewBinding.tvAction.setOnClickListener(this)
  }

  /**
   * 设置返回按钮是否可见
   */
  fun setBackVisibility(isVisible: Boolean) {
    viewBinding.ivBack.isVisible = isVisible
  }

  /**
   * 设置操作按钮是否可见
   */
  fun setActionVisibility(isVisible: Boolean) {
    viewBinding.tvAction.isVisible = isVisible
  }

  override fun onClick(v: View?) {
    if (v?.id == R.id.iv_back) {
      // 若没有设置返回点击回调则默认pop
//      backCallback?.onDoBack() ?: XPageManager.pop(null)
      backCallback?.onDoBack()
    } else if (v?.id == R.id.tv_action) {
      actionCallback?.onDoAction()
    }
  }

  /**
   * 设置回调
   * @param backCallback 返回按钮点击回调
   * @param actionCallback 操作按钮点击回调
   */
  fun setOnCommonTopBarCallback(backCallback: OnCommonTopBarBackCallback?, actionCallback: OnCommonTopBarActionCallback?) {
    this.backCallback = backCallback
    this.actionCallback = actionCallback
  }

  interface OnCommonTopBarActionCallback {
    /**
     * 操作按钮回调
     */
    fun onDoAction()
  }

  interface OnCommonTopBarBackCallback {
    /**
     * 返回按钮回调
     */
    fun onDoBack()


  }
}
