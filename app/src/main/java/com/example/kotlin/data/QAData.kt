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
        QAItemData(QA.clean_apk, R.mipmap.pineapple_pic),
        QAItemData(QA.string_string_buffer, R.mipmap.pineapple_pic),
        QAItemData(QA.thread_application, R.mipmap.pineapple_pic),
        QAItemData(QA.hash_map_hashtable, R.mipmap.pineapple_pic),
        QAItemData(QA.array_link, R.mipmap.pineapple_pic),
        QAItemData(QA.sum_link, R.mipmap.pineapple_pic),
        QAItemData(QA.deadlock_about, R.mipmap.pineapple_pic),
        QAItemData(QA.join_about, R.mipmap.pineapple_pic),
        QAItemData(QA.final_finally_finalize, R.mipmap.pineapple_pic),
        QAItemData(QA.equals_deng, R.mipmap.pineapple_pic),
        QAItemData(QA.overloading_overriding, R.mipmap.pineapple_pic),
        QAItemData(QA.polymorphism_extends, R.mipmap.pineapple_pic),
        QAItemData(QA.generic_reflection, R.mipmap.pineapple_pic),
        QAItemData(QA.assets_res, R.mipmap.pineapple_pic),
        QAItemData(QA.intent_service, R.mipmap.pineapple_pic),
        QAItemData(QA.mvp, R.mipmap.pineapple_pic),
        QAItemData(QA.app_start, R.mipmap.pineapple_pic),
        QAItemData(QA.invalidate, R.mipmap.pineapple_pic),
        QAItemData(QA.handler_thread, R.mipmap.pineapple_pic),
        QAItemData(QA.version_features, R.mipmap.pineapple_pic),
        QAItemData(QA.sleep_wait, R.mipmap.pineapple_pic),
        QAItemData(QA.thread_about, R.mipmap.pineapple_pic),
        QAItemData(QA.thread_local, R.mipmap.pineapple_pic),
        QAItemData(QA.synchronize_lock, R.mipmap.pineapple_pic),
        QAItemData(QA.java_reference, R.mipmap.pineapple_pic),
        QAItemData(QA.leak_canary, R.mipmap.pineapple_pic),
        QAItemData(QA.thread_pool, R.mipmap.pineapple_pic),
        QAItemData(QA.animations, R.mipmap.pineapple_pic),
        QAItemData(QA.hash_map, R.mipmap.pineapple_pic),
        QAItemData(QA.aidl, R.mipmap.pineapple_pic),
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
        QAItemData(QA.volatile_synchronize_use, R.mipmap.banana_pic)
    )
}