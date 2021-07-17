package com.example.kotlin.data

import com.example.kotlin.R

/**
 * Author: sym
 * Date: 2021/4/22 9:53 AM
 * Describe:
 */


data class QAItemData(var question: String, var image: Int) {
}


object QAData {
    val data = arrayListOf(
        QAItemData(QA.four_components, R.mipmap.cherry_pic),
        QAItemData(QA.handler_four_components_use, R.mipmap.grape_pic),
        QAItemData(QA.solve_anr, R.mipmap.mango_pic),
        QAItemData(QA.touch_event, R.mipmap.orange_pic),
        QAItemData(QA.memory_leak, R.mipmap.pear_pic),
        QAItemData(QA.performance_optimization, R.mipmap.strawberry_pic),
        QAItemData(QA.tcp_shake_hands, R.mipmap.apple_pic),
        QAItemData(QA.draw_view, R.mipmap.banana_pic),
        QAItemData(QA.lock_type_use, R.mipmap.cherry_pic),
        QAItemData(QA.activity_life, R.mipmap.grape_pic),
        QAItemData(QA.android_configChanges, R.mipmap.mango_pic),
        QAItemData(QA.activity_launchMode, R.mipmap.orange_pic),
        QAItemData(QA.service_life_stop, R.mipmap.pear_pic),
        QAItemData(QA.fragment_life, R.mipmap.pineapple_pic),
        QAItemData(QA.http_https, R.mipmap.strawberry_pic),
        QAItemData(QA.jvm_model, R.mipmap.watermelon_pic),
        QAItemData(QA.jvm_gc_root, R.mipmap.apple_pic),
        QAItemData(QA.volatile_synchronize_use, R.mipmap.banana_pic),
        QAItemData("替换空格", R.mipmap.pineapple_pic))
}