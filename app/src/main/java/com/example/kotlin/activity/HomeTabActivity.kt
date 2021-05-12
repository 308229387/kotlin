package com.example.kotlin.activity

import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.core.view.forEach
import androidx.core.view.get
import androidx.fragment.app.Fragment
import com.example.kotlin.R
import com.example.kotlin.adapter.ViewPagerAdapter
import com.example.kotlin.base.BaseActivity
import com.example.kotlin.databinding.ActivityHomeTabBinding
import com.example.kotlin.fragment.*
import com.example.kotlin.views.badgeStyle
import com.example.kotlin.views.item
import com.google.android.material.bottomnavigation.LabelVisibilityMode

/**
 * Author: sym
 * Date: 2021/5/11 2:19 PM
 * Describe:
 */
class HomeTabActivity : BaseActivity<ActivityHomeTabBinding>() {
    private var fragmentList = mutableListOf<Fragment>()
    var menus = arrayListOf("广场", "求职招聘", "燕郊圈", "消息", "我")
    var menuIcons = arrayListOf<Int>(
        R.drawable.ic_launcher_foreground,
        R.mipmap.ic_launcher_round,
        R.mipmap.ic_launcher_round,
        R.mipmap.ic_launcher_round,
        R.mipmap.ic_launcher_round
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initFragment()
        initView()
        initListener()
    }

    private fun initFragment() {
        fragmentList.add(FragmentOne())
        fragmentList.add(FragmentTwo())
        fragmentList.add(FragmentThree())
        fragmentList.add(FragmentFour())
        fragmentList.add(FragmentFive())
    }

    private fun initView() {
        viewBind.viewPager.offscreenPageLimit = fragmentList.size
        viewBind.viewPager.adapter = ViewPagerAdapter(
            supportFragmentManager, fragmentList
        )
        viewBind.navView.itemIconTintList = null
        viewBind.navView.labelVisibilityMode = LabelVisibilityMode.LABEL_VISIBILITY_LABELED;//1 不开动画 0 动画
        menus.forEachIndexed { index, title ->
            viewBind.navView.menu.add(0, index, 0, title)
                .setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM)
            viewBind.navView.menu.getItem(index).setIcon(menuIcons[index])
        }
        //设置默认选中
        viewBind.navView.menu[0].isChecked = true

        addBadgeView()
    }

    private fun initListener() {
        viewBind.navView.setOnNavigationItemSelectedListener { menuItem ->
            viewBind.navView.menu.forEach {
                if (it.itemId == menuItem.itemId) {
                    viewBind.viewPager.setCurrentItem(menuItem.itemId, false)
                    it.setIcon(R.drawable.ic_launcher_foreground)
                    if (it.itemId == 1){
                        viewBind.navView.getOrCreateBadge(1).clearNumber()
                        viewBind.navView.getOrCreateBadge(1).isVisible=false

                    }
                    if (it.itemId == 4){
                        viewBind.navView.getOrCreateBadge(1).number =998
                        viewBind.navView.getOrCreateBadge(1).isVisible=true

                    }

                } else {
                    it.setIcon(R.mipmap.ic_launcher_round)
                    Log.d("song_test", "it.itemId != menuItem.itemId")
                }
            }
            true
        }
    }


    override fun createViewBinding(): ActivityHomeTabBinding {
        return ActivityHomeTabBinding.inflate(layoutInflater)
    }

    private fun addBadgeView() {
        viewBind.navView.badgeStyle(1, null, android.R.color.holo_red_dark)
        viewBind.navView.getOrCreateBadge(1).maxCharacterCount = 3
        viewBind.navView.getOrCreateBadge(1).number =99

        viewBind.navView.getOrCreateBadge(2).isVisible=true

    }


}