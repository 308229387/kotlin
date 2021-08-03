package com.example.kotlin.data

import com.example.kotlin.R

/**
 * Author: sym
 * Date: 2021/4/22 9:53 AM
 * Describe:
 */


data class AlgorithmItemData(var title: String, var image: Int) {
    constructor(image: Int) : this("", image)
}


object AlgorithmData {
    val data = arrayListOf(
        AlgorithmItemData(QA.reverse_list, R.mipmap.strawberry_pic),
        AlgorithmItemData(QA.has_cycle , R.mipmap.pineapple_pic),
        AlgorithmItemData(QA.merge_two_lists, R.mipmap.apple_pic),
        AlgorithmItemData(QA.k_th_from_end, R.mipmap.apple_pic),
        AlgorithmItemData(QA.jump_steps, R.mipmap.apple_pic),

        AlgorithmItemData("遍历对称二叉数", R.mipmap.apple_pic),
        AlgorithmItemData("查找重复的数", R.mipmap.banana_pic),
        AlgorithmItemData("创建链表", R.mipmap.cherry_pic),
        AlgorithmItemData("两个栈实现队列1", R.mipmap.grape_pic),
        AlgorithmItemData("两个栈实现队列2", R.mipmap.mango_pic),
        AlgorithmItemData("二分查找", R.mipmap.orange_pic),
        AlgorithmItemData("二叉数前中后序", R.mipmap.pear_pic),
        AlgorithmItemData("二叉数的层序遍历", R.mipmap.pineapple_pic),
        AlgorithmItemData("从尾到头打印链表", R.mipmap.strawberry_pic),
        AlgorithmItemData("删除倒数第N个节点", R.mipmap.watermelon_pic),
        AlgorithmItemData("合并有序数组", R.mipmap.banana_pic),
        AlgorithmItemData("圆圈中最后的数", R.mipmap.cherry_pic),
        AlgorithmItemData("如果有环找到入口", R.mipmap.grape_pic),
        AlgorithmItemData("字符串相加", R.mipmap.mango_pic),
        AlgorithmItemData("广度搜索计算二叉数深度", R.mipmap.orange_pic),
        AlgorithmItemData("快速排序", R.mipmap.pear_pic),
        AlgorithmItemData("替换空格", R.mipmap.pineapple_pic),
        AlgorithmItemData("相交链表", R.mipmap.strawberry_pic),
        AlgorithmItemData("移除链表元素", R.mipmap.watermelon_pic),
        AlgorithmItemData("空间足够合并有序数组", R.mipmap.apple_pic),
        AlgorithmItemData("第一个只出现一次的字符", R.mipmap.banana_pic),
        AlgorithmItemData("路径总和", R.mipmap.cherry_pic),
        AlgorithmItemData("连续子数组最大和", R.mipmap.grape_pic),
        AlgorithmItemData("迭代对称二叉数", R.mipmap.mango_pic),
        AlgorithmItemData("递归对称二叉树", R.mipmap.orange_pic),
        AlgorithmItemData("青蛙跳台阶", R.mipmap.strawberry_pic))

}