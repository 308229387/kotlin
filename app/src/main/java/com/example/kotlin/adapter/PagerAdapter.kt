package com.example.kotlin.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter


class MyPagerAdapter(private val views: List<View>, private val context: Context) : PagerAdapter() {
    //获得viewpager中有多少个view
    override fun getCount(): Int {
        return views.size
    }

    //判断instantiateItem(ViewGroup, int)函数所返回来的Key与一个页面视图是否是 代表的同一个视图
    // (即它俩是否是对应的，对应的表示同一个View),通常我们直接写 return view == object!
    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object`
    }

    //①将给定位置的view添加到ViewGroup(容器)中,创建并显示出来 ②返回一个代表新增页面的Object(key),
    // 通常都是直接返回view本身就可以了,当然你也可以 自定义自己的key,但是key和每个view要一一对应的关系
    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        container.addView(views[position])
        return views[position]
    }

    //移除一个给定位置的页面
    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(views[position])
    }
}