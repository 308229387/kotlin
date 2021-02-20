package com.example.kotlin.views

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import androidx.viewpager.widget.ViewPager
import com.example.kotlin.R
import com.example.kotlin.adapter.MyPagerAdapter

class PanelView : LinearLayout {
    lateinit var vPager: ViewPager
    var views = ArrayList<View>()
    private lateinit var pagerAdapter: MyPagerAdapter

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init()
    }

    private fun init() {
        LayoutInflater.from(context).inflate(R.layout.view_panel, this, true)
        var view1 = LayoutInflater.from(context).inflate(R.layout.viewpager_view, null, false)
        var view2 = LayoutInflater.from(context).inflate(R.layout.viewpager_view, null, false)
        views.add(view1)
        views.add(view2)
        vPager = findViewById(R.id.pager)
        pagerAdapter = MyPagerAdapter(views, context)
        vPager.adapter = pagerAdapter

    }
}