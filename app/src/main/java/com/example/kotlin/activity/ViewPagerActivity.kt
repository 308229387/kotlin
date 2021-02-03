package com.example.kotlin.activity

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager.OnPageChangeListener
import com.example.kotlin.R
import com.example.kotlin.adapter.MyPagerAdapter
import kotlinx.android.synthetic.main.activity_viewpager.*


class ViewPagerActivity : AppCompatActivity() {
    private lateinit var views: List<View>
    private lateinit var pagerAdapter: MyPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_viewpager)
        initView()
    }

    private fun initView() {
        //得到view数据
        views = ArrayList()
        val inflater = layoutInflater
        (views as ArrayList<View>).add(inflater.inflate(R.layout.viewpager_view1, null, false))
        (views as ArrayList<View>).add(inflater.inflate(R.layout.viewpager_view2, null, false))
        (views as ArrayList<View>).add(inflater.inflate(R.layout.viewpager_view3, null, false))
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