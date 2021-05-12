package com.example.kotlin.views

import com.example.kotlin.utils.ToolsUtil
import com.google.android.material.badge.BadgeDrawable
import com.google.android.material.bottomnavigation.BottomNavigationView

/**
 * @description: 小红点操作工具类 结合BottomNavigationView使用
 * @author: huyajun
 * @date:  2021/4/28
 **/
class BadgeUtils {
//    companion object {

    /**
     * 设置badge样式
     */

}

fun BottomNavigationView.badgeStyle(
    index: Int,
    textColor: Int?,
    backgroundColor: Int?,
) {
    getOrCreateBadge(index).horizontalOffset = ToolsUtil.dp2px(-10f)
    getOrCreateBadge(index).verticalOffset = ToolsUtil.dp2px(5f)
    textColor?.let {
        getOrCreateBadge(index).badgeTextColor = resources.getColor(it)
    }
    backgroundColor?.let {
        getOrCreateBadge(index).backgroundColor =
            resources.getColor(it)
    }
}

/**
 * 设置数字
 */
fun setBadgeNumber(
    view: BottomNavigationView,
    index: Int, number: Int,
) {
    if (number == 0) {
        removeBadge(view, index)
    } else {
        view.getOrCreateBadge(index).number = number
    }

}

/**
 * 移除badge
 */
fun removeBadge(view: BottomNavigationView, index: Int) {
    view.removeBadge(index)
}


fun BottomNavigationView.item(index: Int): BadgeDrawable {
    return getOrCreateBadge(index)
}