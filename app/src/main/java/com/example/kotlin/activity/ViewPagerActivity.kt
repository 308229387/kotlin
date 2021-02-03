package com.example.kotlin.activity

import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager.OnPageChangeListener
import com.example.kotlin.R
import com.example.kotlin.adapter.MyPagerAdapter
import kotlinx.android.synthetic.main.activity_viewpager.*


class ViewPagerActivity : AppCompatActivity() {
    private lateinit var pagerAdapter: MyPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_viewpager)
        initView()
    }

    private fun initView() {
        //得到view数据
        var views = ArrayList<View>()
        val inflater = layoutInflater
        var view1 = inflater.inflate(R.layout.viewpager_view, null, false)
        var view2 = inflater.inflate(R.layout.viewpager_view, null, false)
        var view3 = inflater.inflate(R.layout.viewpager_view, null, false)

        var pagerText1 = view1.findViewById<TextView>(R.id.viewpager_text)
        var pagerText2 = view2.findViewById<TextView>(R.id.viewpager_text)
        var pagerText3 = view3.findViewById<TextView>(R.id.viewpager_text)

        pagerText1.text = "我是第一个view"
        pagerText2.text = "我是第二个view"
        pagerText3.text = "我是第三个view"

        pagerText1.setOnClickListener { Toast.makeText(this, "第一个view被点击了", Toast.LENGTH_SHORT).show() }
        pagerText2.setOnClickListener { Toast.makeText(this, "第二个view被点击了", Toast.LENGTH_SHORT).show() }
        pagerText3.setOnClickListener { Toast.makeText(this, "第三个view被点击了", Toast.LENGTH_SHORT).show() }

        //顺序无所谓，先放进里面再放事件也能响应
        views.add(view1)
        views.add(view2)
        views.add(view3)

        //创建Adapter
        pagerAdapter = MyPagerAdapter(views, this)
        viewPager.adapter = pagerAdapter
        viewPager.addOnPageChangeListener(object : OnPageChangeListener {
            //当页面滑动时
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {}

            //当页面选中时
            override fun onPageSelected(position: Int) {
                when (position) {
                    0 -> {
                        setDot(a = true, b = false, c = false)
                    }
                    1 -> {
                        setDot(a = false, b = true, c = false)
                    }
                    2 -> {
                        setDot(a = false, b = false, c = true)
                    }
                }
            }

            override fun onPageScrollStateChanged(state: Int) {}
        })

        //把第一个设置亮其他为暗
        setDot(a = true, b = false, c = false)
    }

    //小点的变化方法，为true时背景设亮，为false时背景设暗
    private fun setDot(a: Boolean, b: Boolean, c: Boolean) {
        if (a) {
            dot_1.setBackgroundResource(R.mipmap.point_green)
        } else {
            dot_1.setBackgroundResource(R.mipmap.point_gray)
        }
        if (b) {
            dot_2.setBackgroundResource(R.mipmap.point_green)
        } else {
            dot_2.setBackgroundResource(R.mipmap.point_gray)
        }
        if (c) {
            dot_3.setBackgroundResource(R.mipmap.point_green)
        } else {
            dot_3.setBackgroundResource(R.mipmap.point_gray)
        }
    }
}