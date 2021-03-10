package com.example.kotlin.views

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.GridView
import android.widget.LinearLayout
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.example.kotlin.R
import com.example.kotlin.adapter.GifGridViewAdapter
import com.example.kotlin.data.Expression
import com.example.kotlin.data.GifData
import com.example.kotlin.utils.EmotionHelper
import com.example.kotlin.utils.EmotionHelper.Companion.EMOTION_GIF_JSON
import com.example.kotlin.views.indicator.CirclePageIndicator
import com.google.gson.Gson

/**
 * FileName: EmotionGifPanelView
 * Author: sym
 * Date: 2021/3/10 3:48 PM
 */
class EmotionGifPanelView(context: Context, attrs: AttributeSet) : LinearLayout(context, attrs) {
    private lateinit var vPager: ViewPager
    private lateinit var vIndicator: CirclePageIndicator
    private var gifGridList: ArrayList<GridView> = ArrayList()
    private lateinit var gifPagerAdapter: EmotionPagerGifAdapter
    private lateinit var gifClickListener: OnGifClickListener

    companion object {
        var ITEM_GRID_NUM = 8
        var NUMBER_COLUMNS = 4
    }

    init {
        init()
        initData()
    }

    private fun init() {
        LayoutInflater.from(context).inflate(R.layout.view_emotion_gif_panel, this, true)
        vPager = findViewById(R.id.gif_pager)
        vIndicator = findViewById(R.id.gif_indicator)
        gifPagerAdapter = EmotionPagerGifAdapter()
    }

    private fun initData() {
        vPager.adapter = gifPagerAdapter
        if (gifGridList.size == 0) initEmotionView(gifGridList)
        gifPagerAdapter.add(gifGridList)
        vIndicator.setViewPager(vPager)
    }

    private fun initEmotionView(gridList: ArrayList<GridView>) {
        val gifClickListener = GifClickListener()

        val json = EmotionHelper.getAssetsJson(EMOTION_GIF_JSON)
        val data = Gson().fromJson(json, GifData::class.java)
        val gifList = data.expressions

        val pageSize: Int =
            if (gifList.size % ITEM_GRID_NUM == 0) {
                gifList.size / ITEM_GRID_NUM
            } else {
                gifList.size / ITEM_GRID_NUM + 1
            }

        for (i in 0 until pageSize) {
            val gridView = GridView(context)
            val adapter = GifGridViewAdapter(gifList, i)
            gridView.numColumns = NUMBER_COLUMNS
            gridView.adapter = adapter
            gridView.onItemClickListener = gifClickListener
            gridList.add(gridView)
            gridView.selector = ColorDrawable(Color.TRANSPARENT)
        }
    }

    inner class EmotionPagerGifAdapter : PagerAdapter() {
        private var mViews: ArrayList<GridView> = ArrayList()

        override fun getCount(): Int {
            return mViews.size
        }

        override fun isViewFromObject(view: View, `object`: Any): Boolean {
            return view === `object`
        }

        override fun instantiateItem(container: ViewGroup, position: Int): Any {
            container.addView(mViews[position])
            return mViews[position]
        }

        override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
            container.removeView(mViews[position])
        }

        fun add(dataList: List<GridView>) {
            if (mViews.size > 0) {
                mViews.clear()
            }
            mViews.addAll(dataList)
            notifyDataSetChanged()
        }
    }


    fun setGifClickListener(gifClickListener: OnGifClickListener) {
        this.gifClickListener = gifClickListener
    }

    open inner class GifClickListener : AdapterView.OnItemClickListener {
        override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
            val gif: Expression = parent!!.adapter.getItem(position) as Expression
            gifClickListener.onGifClick(gif)
        }
    }

    interface OnGifClickListener {
        fun onGifClick(gif: Expression?)
    }

}