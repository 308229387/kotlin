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
import com.example.kotlin.adapter.GridViewAdapter
import com.example.kotlin.data.Emotion
import com.example.kotlin.utils.EmotionHelper
import com.example.kotlin.utils.EmotionHelper.Companion.EMOTION_CLASSIC_DIR
import com.example.kotlin.utils.EmotionHelper.Companion.EMOTION_CLASSIC_JSON
import com.example.kotlin.utils.EmotionHelper.Companion.EMOTION_DEFAULT_DIR
import com.example.kotlin.utils.EmotionHelper.Companion.EMOTION_DEFAULT_JSON
import com.example.kotlin.views.indicator.CirclePageIndicator
import kotlinx.android.synthetic.main.view_emotion_panel.view.*

class EmotionPanelView(context: Context, attrs: AttributeSet) : LinearLayout(context, attrs) {
    private lateinit var vPager: ViewPager
    private lateinit var vIndicator: CirclePageIndicator
    private var classicGridList: ArrayList<GridView> = ArrayList()
    private var defaultGridList: ArrayList<GridView> = ArrayList()
    private lateinit var classicPagerAdapter: EmotionPagerAdapter
    private lateinit var defaultPagerAdapter: EmotionPagerAdapter
    private lateinit var emotionClickListener: OnEmotionClickListener

    companion object {
        var ITEM_GRID_NUM = 21
        var NUMBER_COLUMNS = 7
    }

    init {
        init()
        initClassicData()
    }

    private fun init() {
        LayoutInflater.from(context).inflate(R.layout.view_emotion_panel, this, true)
        vPager = findViewById(R.id.pager)
        vIndicator = findViewById(R.id.indicator)
        classicPagerAdapter = EmotionPagerAdapter()
        defaultPagerAdapter = EmotionPagerAdapter()

        classic_view.setOnClickListener {
            classic_view.isSelected = true
            default_view.isSelected = false
            initClassicData()
        }

        default_view.setOnClickListener {
            default_view.isSelected = true
            classic_view.isSelected = false
            initDefaultData()
        }
    }

    private fun initClassicData() {
        vPager.adapter = classicPagerAdapter
        if (classicGridList.size == 0) initEmotionView(EMOTION_CLASSIC_JSON, EMOTION_CLASSIC_DIR, classicGridList)
        classicPagerAdapter.add(classicGridList)
        indicator.setViewPager(vPager)
        classic_view.isSelected = true
    }

    private fun initDefaultData() {
        vPager.adapter = defaultPagerAdapter
        if (defaultGridList.size == 0) initEmotionView(EMOTION_DEFAULT_JSON, EMOTION_DEFAULT_DIR, defaultGridList)
        defaultPagerAdapter.add(defaultGridList)
        indicator.setViewPager(vPager)
        default_view.isSelected = true
    }

    private fun initEmotionView(jsonDir: String, fileDir: String, gridList: ArrayList<GridView>) {
        val emotionClickListener = EmotionClickListener()

        try {
            val emotionList: ArrayList<Emotion> =
                EmotionHelper.getEmotionsGroup(jsonDir).getEmotions() as ArrayList<Emotion>
            val pageSize: Int =
                if (emotionList.size % ITEM_GRID_NUM == 0) emotionList.size / ITEM_GRID_NUM else emotionList.size / ITEM_GRID_NUM + 1
            for (i in 0 until pageSize) {
                val gridView = GridView(context)
                val adapter = GridViewAdapter(emotionList, i, fileDir)
                gridView.numColumns = NUMBER_COLUMNS
                gridView.adapter = adapter
                gridView.onItemClickListener = emotionClickListener
                gridList.add(gridView)
                gridView.selector = ColorDrawable(Color.TRANSPARENT)
            }
            indicator.visibility = View.VISIBLE
        } catch (e: Exception) {
            return
        }
    }

    inner class EmotionPagerAdapter : PagerAdapter() {
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

    fun setEmotionClickListener(emotionClickListener: OnEmotionClickListener) {
        emotionClickListener.also { this.emotionClickListener = it }
    }

    open inner class EmotionClickListener : AdapterView.OnItemClickListener {
        override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
            val emotion: Emotion = parent!!.adapter.getItem(position) as Emotion
            emotionClickListener.onEmotionClick(emotion)
        }
    }

    interface OnEmotionClickListener {
        fun onEmotionClick(emotion: Emotion?)
    }

}