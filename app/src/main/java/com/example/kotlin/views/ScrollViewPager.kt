package com.example.kotlin.views

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import androidx.viewpager.widget.ViewPager

/**
 * @depiction   ： 可设置是否滑动的ViewPager
 */
class ScrollViewPager : ViewPager {
    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

    private var scrollable = false

    fun setScrollable(isScrollable: Boolean) {
        scrollable = isScrollable
    }

    override fun onInterceptTouchEvent(ev: MotionEvent?): Boolean {
        return scrollable
    }

    override fun onTouchEvent(ev: MotionEvent?): Boolean {
        return scrollable
    }

}