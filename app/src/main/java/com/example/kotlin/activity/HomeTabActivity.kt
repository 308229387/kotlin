package com.example.kotlin.activity

import android.os.Bundle
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.example.kotlin.base.BaseActivity
import com.example.kotlin.databinding.ActivityHomeTabBinding
import com.example.kotlin.fragment.CategoryOneFragment
import com.example.kotlin.fragment.HomeOneFragment
import com.example.kotlin.fragment.MineOneFragment
import com.example.kotlin.fragment.ServiceOneFragment
import com.example.kotlin.views.CustomViewPager

/**
 * Author: sym
 * Date: 2021/5/11 2:19 PM
 * Describe:
 */
class HomeTabActivity : BaseActivity<ActivityHomeTabBinding>() {
    private lateinit var viewPager: CustomViewPager
    private val mFragments: MutableList<Fragment> = mutableListOf()
    var homeOneFragment: HomeOneFragment = HomeOneFragment()
    var categoryOneFragment: CategoryOneFragment = CategoryOneFragment()
    var serviceOneFragment: ServiceOneFragment = ServiceOneFragment()
    var mineOneFragment: MineOneFragment = MineOneFragment()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewPager = viewBind.viewPager

        mFragments.add(homeOneFragment)
        mFragments.add(categoryOneFragment)
        mFragments.add(serviceOneFragment)
        mFragments.add(mineOneFragment)

        viewPager.adapter = MyAdapter(supportFragmentManager)
        viewPager.offscreenPageLimit = 3
        viewBind.homeBottomTab.llHome.isSelected = true

        setOnListener()
    }

    private fun setOnListener() {
        viewBind.homeBottomTab.llHome.setOnClickListener {
            viewPager.currentItem = 0
            tabSelected(viewBind.homeBottomTab.llHome)
        }
        viewBind.homeBottomTab.llCategory.setOnClickListener {
            viewPager.currentItem = 1
            tabSelected(viewBind.homeBottomTab.llCategory)
        }
        viewBind.homeBottomTab.llService.setOnClickListener {
            viewPager.currentItem = 2
            tabSelected(viewBind.homeBottomTab.llService)
        }
        viewBind.homeBottomTab.llMine.setOnClickListener {
            viewPager.currentItem = 3
            tabSelected(viewBind.homeBottomTab.llMine)
        }
        viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
            }

            override fun onPageSelected(position: Int) {
                when (position) {
                    0 -> tabSelected(viewBind.homeBottomTab.llHome)
                    1 -> tabSelected(viewBind.homeBottomTab.llCategory)
                    2 -> tabSelected(viewBind.homeBottomTab.llService)
                    3 -> tabSelected(viewBind.homeBottomTab.llMine)
                    else -> {
                    }
                }
            }

            override fun onPageScrollStateChanged(state: Int) {
            }

        })

    }


    override fun createViewBinding(): ActivityHomeTabBinding {
        return ActivityHomeTabBinding.inflate(layoutInflater)
    }

    private inner class MyAdapter internal constructor(fm: FragmentManager?) : FragmentPagerAdapter(fm!!) {

        override fun getCount(): Int {
            return mFragments.size
        }

        override fun getItem(position: Int): Fragment {
            return mFragments[position]
        }

    }

    private fun tabSelected(linearLayout: LinearLayout) {
        viewBind.homeBottomTab.llHome.isSelected = false
        viewBind.homeBottomTab.llCategory.isSelected = false
        viewBind.homeBottomTab.llService.isSelected = false
        viewBind.homeBottomTab.llMine.isSelected = false
        linearLayout.isSelected = true
    }


}