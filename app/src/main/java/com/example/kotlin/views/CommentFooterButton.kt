package com.example.kotlin.views

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import com.example.kotlin.R.drawable
import com.example.kotlin.R.styleable
import com.example.kotlin.utils.ToolsUtil.dp2px

@SuppressLint("CustomViewStyleable")
class CommentFooterButton(context: Context, attrs: AttributeSet) : View(context, attrs, 0) {//获取attrs文件下配置属性

    //记得把TypedArray对象回收
    //图片ID
    private var map = 0
    private var lightMap = 0

    //图像画笔
    private var bitmapPaint: Paint? = null

    //没有点赞的图像
    private var unLikeBitmap: Bitmap? = null

    //点赞后的图像
    private var likeBitmap: Bitmap? = null

    //是否点赞
    private var isLike = false

    //小手的缩放倍数
    private var handScale = 1.0f

    //初始化不跳一下的tag
    private var tag = 0


    init {
        val typedArray = context.obtainStyledAttributes(attrs, styleable.CommentFooterView)
        map = typedArray.getResourceId(styleable.CommentFooterView_map_id, drawable.ic_launcher_background)
        lightMap = typedArray.getResourceId(styleable.CommentFooterView_light_map_id, drawable.ic_launcher_background)
        typedArray.recycle()
        initView()
    }

    private fun initView() {
        //bitmapPaint是图像画笔
        bitmapPaint = Paint(Paint.ANTI_ALIAS_FLAG)
        //圆画笔初始化 Paint.Style.STROKE只绘制图形轮廓
        //圆画笔
        val circlePaint = Paint(Paint.ANTI_ALIAS_FLAG)
        circlePaint.color = Color.RED
        circlePaint.style = Paint.Style.STROKE
        //设置轮廓宽度
        circlePaint.strokeWidth = dp2px(context, 2f).toFloat()
        //设置模糊效果 第一个参数是模糊半径，越大越模糊，第二个参数是阴影的横向偏移距离，正值向下偏移 负值向上偏移
        //第三个参数是纵向偏移距离，正值向下偏移，负值向上偏移 第四个参数是画笔的颜色
        circlePaint.setShadowLayer(dp2px(context, 1f).toFloat(), dp2px(context, 1f).toFloat(), dp2px(context, 1f).toFloat(), Color.RED)
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        val resources = resources
        //构造Bitmap对象，通过BitmapFactory工厂类的static Bitmap decodeResource根据给定的资源id解析成位图
        unLikeBitmap = BitmapFactory.decodeResource(resources, map)
        likeBitmap = BitmapFactory.decodeResource(resources, lightMap)
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        //回收bitmap
        unLikeBitmap!!.recycle()
        likeBitmap!!.recycle()
    }

    override fun onMeasure(widthMeasureSpec1: Int, heightMeasureSpec1: Int) {
        //高度默认是bitmap的高度加上下margin各10dp
        val heightMeasureSpec: Int = MeasureSpec.makeMeasureSpec(unLikeBitmap!!.height, MeasureSpec.EXACTLY)
        //计算整个View的宽度 小手宽度 + 文本宽度 + 30px
        val widthMeasureSpec: Int = MeasureSpec.makeMeasureSpec(unLikeBitmap!!.width, MeasureSpec.EXACTLY)
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        //获取正个View的高度
        val height = height
        //取中心
        val centerY = height / 2
        //小手根据有没有点赞进行改变
        val handBitmap = if (isLike) likeBitmap!! else unLikeBitmap!!
        //得到图像宽度
        val handBitmapWidth = handBitmap.width
        //得到图像高度
        val handBitmapHeight = handBitmap.height
        //画小手
        val handTop = (height - handBitmapHeight) / 2
        //先保存画布的状态
        canvas!!.save()
        //根据bitmap中心进行缩放
        canvas.scale(handScale, handScale, (handBitmapWidth / 2).toFloat(), centerY.toFloat())
        //画bitmap小手，第一个是参数对应的bitmap，第二个参数是左上角坐标，第三个参数上顶部坐标，第四个是画笔
        canvas.drawBitmap(handBitmap, dp2px(context, 0f).toFloat(), handTop.toFloat(), bitmapPaint)
        //读取之前没有缩放画布的状态
        canvas.restore()
    }

    private fun jump() {
        isLike = !isLike
        //动画播放时间
        val duration = 250
        if (isLike) {
            val handScaleAnim = ObjectAnimator.ofFloat(this, "handScale", 1f, 0.8f, 1f)
            handScaleAnim.duration = duration.toLong()
            val animatorSet = AnimatorSet()
            animatorSet.playTogether(handScaleAnim)
            animatorSet.start()
        } else {
            val handScaleAnim = ObjectAnimator.ofFloat(this, "handScale", 1f, 0.8f, 1f)
            handScaleAnim.duration = duration.toLong()
            handScaleAnim.start()
        }
    }

    //不能删除
    fun setHandScale(handScale: Float) {
        //传递缩放系数
        this.handScale = handScale
        invalidate()
    }

    fun isChecked(): Boolean {
        return isLike
    }

    fun setStatus(boolean: Boolean) {
        isLike = boolean
        requestLayout()
        invalidate()
        if (tag != 0) {
            jump()
        } else {
            tag++
        }
    }


}