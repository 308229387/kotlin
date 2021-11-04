package com.example.kotlin.data

import com.example.kotlin.R

/**
 * Author: sym
 * Date: 2021/4/22 9:53 AM
 * Describe:
 */

object QAData {
    val data = arrayListOf(
        QAItemData("java基础", R.mipmap.pineapple_pic,1),
        QAItemData(QA.how_many_string, R.mipmap.pineapple_pic),


        QAItemData("四大组件", R.mipmap.pineapple_pic,1),
        QAItemData(QA.fragment_activity_communication, R.mipmap.pineapple_pic),


        QAItemData("Handler", R.mipmap.pineapple_pic,1),
        QAItemData(QA.why_no_die, R.mipmap.grape_pic),
        QAItemData(QA.delay_message, R.mipmap.banana_pic),
        QAItemData(QA.handler_async, R.mipmap.pineapple_pic),


        QAItemData("数据类型与存储", R.mipmap.pineapple_pic,1),
        QAItemData(QA.concurrent_hash_map, R.mipmap.pineapple_pic),
        QAItemData(QA.content_provider, R.mipmap.pineapple_pic),



        QAItemData("性能优化", R.mipmap.pineapple_pic,1),


        QAItemData("JVM", R.mipmap.pineapple_pic,1),


        QAItemData("view与显示", R.mipmap.pineapple_pic,1),
        QAItemData(QA.auto_adapter_screen, R.mipmap.pineapple_pic),


        QAItemData("线程", R.mipmap.pineapple_pic,1),


        QAItemData("锁", R.mipmap.pineapple_pic,1),
        QAItemData(QA.volatile_principle, R.mipmap.pineapple_pic),


        QAItemData("线程池", R.mipmap.pineapple_pic,1),


        QAItemData("进程", R.mipmap.pineapple_pic,1),


        QAItemData("网络", R.mipmap.pineapple_pic,1),
        QAItemData(QA.tcp_udp_different, R.mipmap.pineapple_pic),
        QAItemData(QA.url_process, R.mipmap.pineapple_pic),
        QAItemData(QA.https_process, R.mipmap.pineapple_pic),
        QAItemData(QA.net_work_level, R.mipmap.pineapple_pic),

        QAItemData(QA.http_error_code, R.mipmap.pineapple_pic),


        QAItemData("第三方控件与框架", R.mipmap.pineapple_pic,1),
        QAItemData(QA.jet_pack, R.mipmap.pineapple_pic),
        QAItemData(QA.r_x_java, R.mipmap.pineapple_pic),


        QAItemData("开发模式", R.mipmap.pineapple_pic,1),


        QAItemData("设计模式", R.mipmap.pineapple_pic,1),
        QAItemData(QA.design_patterns, R.mipmap.pineapple_pic),



        QAItemData("系统架构", R.mipmap.pineapple_pic,1),

        QAItemData(QA.class_load, R.mipmap.pineapple_pic),
        QAItemData(QA.abstract_interface, R.mipmap.pineapple_pic),
        QAItemData(QA.blocking_queue, R.mipmap.pineapple_pic),
        QAItemData(QA.lazy_fragment, R.mipmap.grape_pic),
        QAItemData(QA.fragment_life, R.mipmap.banana_pic),
        QAItemData(QA.sp_about, R.mipmap.pineapple_pic),
        QAItemData(QA.more_process, R.mipmap.pineapple_pic),
        QAItemData(QA.serializable_parcelable, R.mipmap.pineapple_pic),
        QAItemData(QA.not_ui_refresh, R.mipmap.grape_pic),
        QAItemData(QA.ui_block, R.mipmap.banana_pic),
        QAItemData(QA.catch_exception, R.mipmap.pineapple_pic),
        QAItemData(QA.interrupt_interrupted, R.mipmap.pineapple_pic),
        QAItemData(QA.thread_status, R.mipmap.pineapple_pic),
        QAItemData(QA.binder_info, R.mipmap.pineapple_pic),
        QAItemData(QA.clean_apk, R.mipmap.grape_pic),
        QAItemData(QA.string_string_buffer, R.mipmap.banana_pic),
        QAItemData(QA.thread_application, R.mipmap.pineapple_pic),
        QAItemData(QA.hash_map_hashtable, R.mipmap.pineapple_pic),
        QAItemData(QA.array_link, R.mipmap.pineapple_pic),
        QAItemData(QA.sum_link, R.mipmap.pineapple_pic),
        QAItemData(QA.deadlock_about, R.mipmap.pineapple_pic),
        QAItemData(QA.join_about, R.mipmap.pineapple_pic),
        QAItemData(QA.final_finally_finalize, R.mipmap.pineapple_pic),
        QAItemData(QA.equals_deng, R.mipmap.grape_pic),
        QAItemData(QA.overloading_overriding, R.mipmap.banana_pic),
        QAItemData(QA.polymorphism_extends, R.mipmap.pineapple_pic),
        QAItemData(QA.generic_reflection, R.mipmap.pineapple_pic),
        QAItemData(QA.assets_res, R.mipmap.pineapple_pic),
        QAItemData(QA.intent_service, R.mipmap.pineapple_pic),
        QAItemData(QA.mvp, R.mipmap.grape_pic),
        QAItemData(QA.app_start, R.mipmap.pineapple_pic),
        QAItemData(QA.invalidate, R.mipmap.pineapple_pic),
        QAItemData(QA.handler_thread, R.mipmap.pineapple_pic),
        QAItemData(QA.version_features, R.mipmap.pineapple_pic),
        QAItemData(QA.sleep_wait, R.mipmap.pineapple_pic),
        QAItemData(QA.thread_about, R.mipmap.pineapple_pic),
        QAItemData(QA.thread_local, R.mipmap.pineapple_pic),
        QAItemData(QA.synchronize_lock, R.mipmap.grape_pic),
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
        QAItemData(QA.http_https, R.mipmap.strawberry_pic),
        QAItemData(QA.jvm_model, R.mipmap.watermelon_pic),
        QAItemData(QA.jvm_gc_root, R.mipmap.apple_pic),
        QAItemData(QA.volatile_synchronize_use, R.mipmap.banana_pic)
    )
}