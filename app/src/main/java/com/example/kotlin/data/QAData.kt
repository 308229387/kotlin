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
        QAItemData(QA.abstract_interface, R.mipmap.pineapple_pic),
        QAItemData(QA.string_string_buffer, R.mipmap.banana_pic),
        QAItemData(QA.final_finally_finalize, R.mipmap.pineapple_pic),
        QAItemData(QA.equals_deng, R.mipmap.grape_pic),
        QAItemData(QA.equals_hash_code, R.mipmap.grape_pic),
        QAItemData(QA.overloading_overriding, R.mipmap.banana_pic),
        QAItemData(QA.java_three_point, R.mipmap.pineapple_pic),
        QAItemData(QA.generic_reflection, R.mipmap.pineapple_pic),
        QAItemData(QA.java_reference, R.mipmap.pineapple_pic),
        QAItemData(QA.java_reference_queue, R.mipmap.pineapple_pic),
        QAItemData(QA.android_annotation, R.mipmap.pineapple_pic),


        QAItemData("四大组件", R.mipmap.pineapple_pic,1),
        QAItemData(QA.four_components, R.mipmap.cherry_pic),
        QAItemData(QA.activity_life, R.mipmap.grape_pic),
        QAItemData(QA.activity_launchMode, R.mipmap.orange_pic),
        QAItemData(QA.activity_task, R.mipmap.orange_pic),
        QAItemData(QA.activity_launchMode_how, R.mipmap.orange_pic),
        QAItemData(QA.activity_launchMode_question, R.mipmap.orange_pic),
        QAItemData(QA.android_configChanges, R.mipmap.mango_pic),
        QAItemData(QA.fragment_activity_communication, R.mipmap.pineapple_pic),
        QAItemData(QA.lazy_fragment_purpose, R.mipmap.grape_pic),
        QAItemData(QA.lazy_fragment_support, R.mipmap.grape_pic),
        QAItemData(QA.lazy_fragment_androidx, R.mipmap.grape_pic),
        QAItemData(QA.fragment_life, R.mipmap.banana_pic),
        QAItemData(QA.fragment_life_change, R.mipmap.banana_pic),
        QAItemData(QA.intent_service, R.mipmap.pineapple_pic),
        QAItemData(QA.service_create, R.mipmap.pear_pic),
        QAItemData(QA.service_two_create_diff, R.mipmap.pear_pic),
        QAItemData(QA.service_life, R.mipmap.pear_pic),
        QAItemData(QA.service_stop, R.mipmap.pear_pic),
        QAItemData(QA.service_activity_info, R.mipmap.pear_pic),
        QAItemData(QA.content_provider, R.mipmap.pineapple_pic),
        QAItemData(QA.content_resolver, R.mipmap.pineapple_pic),
        QAItemData(QA.content_provider_uri, R.mipmap.pineapple_pic),
        QAItemData(QA.content_provider_steps, R.mipmap.pineapple_pic),


        QAItemData("Handler", R.mipmap.pineapple_pic,1),
        QAItemData(QA.handler_four_components, R.mipmap.grape_pic),
        QAItemData(QA.handler_use, R.mipmap.grape_pic),
        QAItemData(QA.handler_child_create, R.mipmap.grape_pic),
        QAItemData(QA.why_no_die, R.mipmap.grape_pic),
        QAItemData(QA.delay_message, R.mipmap.banana_pic),
        QAItemData(QA.handler_async, R.mipmap.pineapple_pic),


        QAItemData("数据类型与存储", R.mipmap.pineapple_pic,1),
        QAItemData(QA.concurrent_hash_map, R.mipmap.pineapple_pic),
        QAItemData(QA.sp_about, R.mipmap.pineapple_pic),
        QAItemData(QA.sp_why_light, R.mipmap.pineapple_pic),
        QAItemData(QA.sp_save_steps, R.mipmap.pineapple_pic),
        QAItemData(QA.sp_principle, R.mipmap.pineapple_pic),
        QAItemData(QA.sp_two_save_method, R.mipmap.pineapple_pic),
        QAItemData(QA.sp_why_no_safe, R.mipmap.pineapple_pic),
        QAItemData(QA.serializable_parcelable, R.mipmap.pineapple_pic),
        QAItemData(QA.hash_map_hashtable, R.mipmap.pineapple_pic),
        QAItemData(QA.array_link, R.mipmap.pineapple_pic),
        QAItemData(QA.sum_link, R.mipmap.pineapple_pic),
        QAItemData(QA.hash_map, R.mipmap.pineapple_pic),
        QAItemData(QA.how_hash, R.mipmap.pineapple_pic),
        QAItemData(QA.change_big, R.mipmap.pineapple_pic),
        QAItemData(QA.red_black_time, R.mipmap.pineapple_pic),



        QAItemData("性能优化", R.mipmap.pineapple_pic,1),
        QAItemData(QA.ui_block, R.mipmap.banana_pic),
        QAItemData(QA.how_solve_block, R.mipmap.banana_pic),
        QAItemData(QA.clean_apk, R.mipmap.grape_pic),
        QAItemData(QA.leak_canary, R.mipmap.pineapple_pic),
        QAItemData(QA.what_anr, R.mipmap.mango_pic),
        QAItemData(QA.watching_anr, R.mipmap.mango_pic),
        QAItemData(QA.solve_anr, R.mipmap.mango_pic),
        QAItemData(QA.block_canary_principle, R.mipmap.mango_pic),
        QAItemData(QA.memory_leak, R.mipmap.pear_pic),
        QAItemData(QA.performance_optimization, R.mipmap.strawberry_pic),
        QAItemData(QA.cache_optimization, R.mipmap.strawberry_pic),
        QAItemData(QA.cache_big, R.mipmap.strawberry_pic),
        QAItemData(QA.app_start_process, R.mipmap.pineapple_pic),
        QAItemData(QA.app_start_about_role, R.mipmap.pineapple_pic),
        QAItemData(QA.app_start_start_time, R.mipmap.pineapple_pic),
        QAItemData(QA.app_start_optimize, R.mipmap.pineapple_pic),
        QAItemData(QA.app_start_method_sequence, R.mipmap.pineapple_pic),


        QAItemData("JVM", R.mipmap.pineapple_pic,1),
        QAItemData(QA.class_load, R.mipmap.pineapple_pic),
        QAItemData(QA.class_load_three, R.mipmap.pineapple_pic),
        QAItemData(QA.jvm_model, R.mipmap.watermelon_pic),
        QAItemData(QA.jvm_gc_root, R.mipmap.apple_pic),
        QAItemData(QA.jvm_gc_work, R.mipmap.apple_pic),
        QAItemData(QA.mark_rubbish, R.mipmap.apple_pic),
        QAItemData(QA.clean_rubbish, R.mipmap.apple_pic),
        QAItemData(QA.rubbish_robot, R.mipmap.apple_pic),


        QAItemData("view与显示", R.mipmap.pineapple_pic,1),
        QAItemData(QA.auto_adapter_screen, R.mipmap.pineapple_pic),
        QAItemData(QA.touch_event, R.mipmap.orange_pic),
        QAItemData(QA.touch_event_move, R.mipmap.orange_pic),
        QAItemData(QA.touch_event_target, R.mipmap.orange_pic),
        QAItemData(QA.touch_event_conflict, R.mipmap.orange_pic),
        QAItemData(QA.touch_event_x_different, R.mipmap.orange_pic),
        QAItemData(QA.draw_view, R.mipmap.banana_pic),
        QAItemData(QA.view_draw_process, R.mipmap.banana_pic),
        QAItemData(QA.surfaceView_about, R.mipmap.banana_pic),
        QAItemData(QA.surfaceView_use, R.mipmap.banana_pic),

        QAItemData("动画", R.mipmap.pineapple_pic,1),
        QAItemData(QA.animations, R.mipmap.pineapple_pic),
        QAItemData(QA.value_animations_about, R.mipmap.banana_pic),
        QAItemData(QA.value_animator, R.mipmap.banana_pic),
        QAItemData(QA.object_animator, R.mipmap.banana_pic),
        QAItemData(QA.animator_animator_set, R.mipmap.banana_pic),
        QAItemData(QA.property_values_holder, R.mipmap.banana_pic),
        QAItemData(QA.type_evaluator_about, R.mipmap.banana_pic),
        QAItemData(QA.interpolator_about, R.mipmap.banana_pic),
        QAItemData(QA.animator_listener, R.mipmap.banana_pic),
        QAItemData(QA.type_evaluator_interpolator_diff, R.mipmap.banana_pic),


        QAItemData("线程", R.mipmap.pineapple_pic,1),
        QAItemData(QA.not_ui_refresh, R.mipmap.grape_pic),
        QAItemData(QA.thread_status, R.mipmap.pineapple_pic),
        QAItemData(QA.join_about, R.mipmap.pineapple_pic),
        QAItemData(QA.invalidate, R.mipmap.pineapple_pic),
        QAItemData(QA.handler_thread, R.mipmap.pineapple_pic),
        QAItemData(QA.thread_create, R.mipmap.pineapple_pic),
        QAItemData(QA.thread_stop, R.mipmap.pineapple_pic),
        QAItemData(QA.interrupt_interrupted, R.mipmap.pineapple_pic),
        QAItemData(QA.thread_change, R.mipmap.pineapple_pic),
        QAItemData(QA.thread_safe, R.mipmap.pineapple_pic),
        QAItemData(QA.thread_local, R.mipmap.pineapple_pic),


        QAItemData("锁", R.mipmap.pineapple_pic,1),
        QAItemData(QA.volatile_principle, R.mipmap.pineapple_pic),
        QAItemData(QA.deadlock_about, R.mipmap.pineapple_pic),
        QAItemData(QA.sleep_wait, R.mipmap.pineapple_pic),
        QAItemData(QA.sleep_0, R.mipmap.pineapple_pic),
        QAItemData(QA.volatile_features, R.mipmap.banana_pic),
        QAItemData(QA.synchronize_principle, R.mipmap.banana_pic),
        QAItemData(QA.volatile_synchronize_different, R.mipmap.banana_pic),
        QAItemData(QA.synchronize_range, R.mipmap.banana_pic),
        QAItemData(QA.true_lock, R.mipmap.banana_pic),
        QAItemData(QA.false_lock, R.mipmap.banana_pic),
        QAItemData(QA.twice_lock, R.mipmap.banana_pic),
        QAItemData(QA.lock_use, R.mipmap.banana_pic),
        QAItemData(QA.synchronized_use, R.mipmap.cherry_pic),
        QAItemData(QA.synchronized_lock_diff, R.mipmap.banana_pic),


        QAItemData("线程池", R.mipmap.pineapple_pic,1),
        QAItemData(QA.thread_pool_create, R.mipmap.pineapple_pic),
        QAItemData(QA.thread_four_api, R.mipmap.pineapple_pic),
        QAItemData(QA.thread_seven_params, R.mipmap.pineapple_pic),
        QAItemData(QA.thread_work_principle, R.mipmap.pineapple_pic),
        QAItemData(QA.thread_shut_down, R.mipmap.pineapple_pic),
        QAItemData(QA.thread_pool_work_queue, R.mipmap.pineapple_pic),
        QAItemData(QA.thread_pool_recycling, R.mipmap.pineapple_pic),
        QAItemData(QA.thread_pool_reject_policy, R.mipmap.pineapple_pic),
        QAItemData(QA.blocking_queue, R.mipmap.pineapple_pic),


        QAItemData("进程", R.mipmap.pineapple_pic,1),
        QAItemData(QA.more_process_purpose, R.mipmap.pineapple_pic),
        QAItemData(QA.more_process_use, R.mipmap.pineapple_pic),
        QAItemData(QA.many_process_communication, R.mipmap.pineapple_pic),
        QAItemData(QA.more_process_question, R.mipmap.pineapple_pic),
        QAItemData(QA.binder_info, R.mipmap.pineapple_pic),
        QAItemData(QA.thread_application, R.mipmap.pineapple_pic),
        QAItemData(QA.aidl, R.mipmap.pineapple_pic),


        QAItemData("网络", R.mipmap.pineapple_pic,1),
        QAItemData(QA.tcp_shake_hands, R.mipmap.apple_pic),
        QAItemData(QA.tcp_udp_different, R.mipmap.pineapple_pic),
        QAItemData(QA.url_process, R.mipmap.pineapple_pic),
        QAItemData(QA.https_process, R.mipmap.pineapple_pic),
        QAItemData(QA.net_work_level, R.mipmap.pineapple_pic),
        QAItemData(QA.http_https, R.mipmap.strawberry_pic),
        QAItemData(QA.http_error_code, R.mipmap.pineapple_pic),
        QAItemData(QA.ok_http_process, R.mipmap.pineapple_pic),
        QAItemData(QA.ok_http_principle, R.mipmap.pineapple_pic),
        QAItemData(QA.ok_http_usr_model, R.mipmap.pineapple_pic),
        QAItemData(QA.ok_http_interceptor, R.mipmap.pineapple_pic),
        QAItemData(QA.retrofit_use, R.mipmap.pineapple_pic),
        QAItemData(QA.retrofit_principle, R.mipmap.pineapple_pic),
        QAItemData(QA.retrofit_good, R.mipmap.pineapple_pic),
        QAItemData(QA.dynamic_proxy_good, R.mipmap.pineapple_pic),


        QAItemData("第三方控件与框架", R.mipmap.pineapple_pic,1),
        QAItemData(QA.jet_pack, R.mipmap.pineapple_pic),
        QAItemData(QA.r_x_java, R.mipmap.pineapple_pic),
        QAItemData(QA.catch_exception, R.mipmap.pineapple_pic),
        QAItemData(QA.list_diff, R.mipmap.pineapple_pic),
        QAItemData(QA.butter_knife, R.mipmap.pineapple_pic),
        QAItemData(QA.hot_repair, R.mipmap.pineapple_pic),
        QAItemData(QA.glide_good_principle, R.mipmap.pineapple_pic),
        QAItemData(QA.glide_cache, R.mipmap.pineapple_pic),


        QAItemData("开发模式", R.mipmap.pineapple_pic,1),
        QAItemData(QA.mvp, R.mipmap.grape_pic),
        QAItemData(QA.mvc, R.mipmap.grape_pic),
        QAItemData(QA.mvvm, R.mipmap.grape_pic),


        QAItemData("设计模式", R.mipmap.pineapple_pic,1),
        QAItemData(QA.design_patterns, R.mipmap.pineapple_pic),



        QAItemData("系统架构", R.mipmap.pineapple_pic,1),
        QAItemData(QA.assets_res, R.mipmap.pineapple_pic),
        QAItemData(QA.version_features, R.mipmap.pineapple_pic),
        QAItemData(QA.framework_about, R.mipmap.pineapple_pic),
        QAItemData(QA.android_base, R.mipmap.pineapple_pic),
        QAItemData(QA.rely_on_repeat, R.mipmap.pineapple_pic),
        QAItemData(QA.modify_jar_class, R.mipmap.pineapple_pic),


        QAItemData("扩展", R.mipmap.pineapple_pic,1),
        QAItemData(QA.kotlin_good, R.mipmap.pineapple_pic),
        QAItemData(QA.kotlin_coroutines, R.mipmap.pineapple_pic),
        QAItemData(QA.coroutines_create, R.mipmap.pineapple_pic),
        QAItemData(QA.coroutines_stop, R.mipmap.pineapple_pic),
        QAItemData(QA.flutter_about, R.mipmap.pineapple_pic),



        )
}