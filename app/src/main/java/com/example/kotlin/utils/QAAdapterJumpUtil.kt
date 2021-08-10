package com.example.kotlin.utils

import android.content.Intent
import com.example.kotlin.data.QA

/**
 * Author: sym
 * Date: 2021/8/6 10:07 PM
 * Describe:
 */
class QAAdapterJumpUtil {
    companion object {

        fun setIntent(question:String,intent: Intent) {
            when (question) {
                QA.performance_optimization -> {
                    intent.putExtra("question", QA.performance_optimization)
                    intent.putExtra("answer", QA.performance_optimization_answer)
                }
                QA.tcp_shake_hands -> {
                    intent.putExtra("question", QA.tcp_shake_hands)
                    intent.putExtra("answer", QA.tcp_shake_hands_answer)
                }
                QA.draw_view -> {
                    intent.putExtra("question", QA.draw_view)
                    intent.putExtra("answer", QA.draw_view_answer)
                }
                QA.lock_type_use -> {
                    intent.putExtra("question", QA.lock_type_use)
                    intent.putExtra("answer", QA.lock_type_use_answer)
                }
                QA.activity_life -> {
                    intent.putExtra("question", QA.activity_life)
                    intent.putExtra("answer", QA.activity_life_answer)
                }
                QA.android_configChanges -> {
                    intent.putExtra("question", QA.android_configChanges)
                    intent.putExtra("answer", QA.android_configChanges_answer)
                }

                QA.service_life_stop -> {
                    intent.putExtra("question", QA.service_life_stop)
                    intent.putExtra("answer", QA.service_life_stop_answer)
                }
                QA.activity_launchMode -> {
                    intent.putExtra("question", QA.activity_launchMode)
                    intent.putExtra("answer", QA.activity_launchMode_answer)
                }
                QA.http_https -> {
                    intent.putExtra("question", QA.http_https)
                    intent.putExtra("answer", QA.http_https_answer)
                }
                QA.jvm_model -> {
                    intent.putExtra("question", QA.jvm_model)
                    intent.putExtra("answer", QA.jvm_model_answer)
                }
                QA.jvm_gc_root -> {
                    intent.putExtra("question", QA.jvm_gc_root)
                    intent.putExtra("answer", QA.jvm_gc_root_answer)
                }
                QA.volatile_synchronize_use -> {
                    intent.putExtra("question", QA.volatile_synchronize_use)
                    intent.putExtra("answer", QA.volatile_synchronize_use_answer)
                }
                QA.four_components -> {
                    intent.putExtra("question", QA.four_components)
                    intent.putExtra("answer", QA.four_components_answer)
                }
                QA.handler_four_components_use -> {
                    intent.putExtra("question", QA.handler_four_components_use)
                    intent.putExtra("answer", QA.handler_four_components_use_answer)
                }
                QA.solve_anr -> {
                    intent.putExtra("question", QA.solve_anr)
                    intent.putExtra("answer", QA.solve_anr_answer)
                }
                QA.touch_event -> {
                    intent.putExtra("question", QA.touch_event)
                    intent.putExtra("answer", QA.touch_event_answer)
                }
                QA.memory_leak -> {
                    intent.putExtra("question", QA.memory_leak)
                    intent.putExtra("answer", QA.memory_leak_answer)
                }
                QA.animations -> {
                    intent.putExtra("question", QA.animations)
                    intent.putExtra("answer", QA.animations_answer)
                }
                QA.hash_map -> {
                    intent.putExtra("question", QA.hash_map)
                    intent.putExtra("answer", QA.hash_map_answer)
                }
                QA.aidl -> {
                    intent.putExtra("question", QA.aidl)
                    intent.putExtra("answer", QA.aidl_answer)
                }
                QA.thread_pool -> {
                    intent.putExtra("question", QA.thread_pool)
                    intent.putExtra("answer", QA.thread_pool_answer)
                }
                QA.leak_canary -> {
                    intent.putExtra("question", QA.leak_canary)
                    intent.putExtra("answer", QA.leak_canary_answer)
                }
                QA.java_reference -> {
                    intent.putExtra("question", QA.java_reference)
                    intent.putExtra("answer", QA.java_reference_answer)
                }
                QA.synchronize_lock -> {
                    intent.putExtra("question", QA.synchronize_lock)
                    intent.putExtra("answer", QA.synchronize_lock_answer)
                }
                QA.thread_local -> {
                    intent.putExtra("question", QA.thread_local)
                    intent.putExtra("answer", QA.thread_local_answer)
                }
                QA.thread_about -> {
                    intent.putExtra("question", QA.thread_about)
                    intent.putExtra("answer", QA.thread_about_answer)
                }
                QA.sleep_wait -> {
                    intent.putExtra("question", QA.sleep_wait)
                    intent.putExtra("answer", QA.sleep_wait_answer)
                }
                QA.version_features -> {
                    intent.putExtra("question", QA.version_features)
                    intent.putExtra("answer", QA.version_features_answer)
                }
                QA.handler_thread -> {
                    intent.putExtra("question", QA.handler_thread)
                    intent.putExtra("answer", QA.handler_thread_answer)
                }
                QA.invalidate -> {
                    intent.putExtra("question", QA.invalidate)
                    intent.putExtra("answer", QA.invalidate_answer)
                }
                QA.app_start -> {
                    intent.putExtra("question", QA.app_start)
                    intent.putExtra("answer", QA.app_start_answer)
                }
                QA.mvp -> {
                    intent.putExtra("question", QA.mvp)
                    intent.putExtra("answer", QA.mvp_answer)
                }
                QA.intent_service -> {
                    intent.putExtra("question", QA.intent_service)
                    intent.putExtra("answer", QA.intent_service_answer)
                }
                QA.assets_res -> {
                    intent.putExtra("question", QA.assets_res)
                    intent.putExtra("answer", QA.assets_res_answer)
                }
                QA.final_finally_finalize -> {
                    intent.putExtra("question", QA.final_finally_finalize)
                    intent.putExtra("answer", QA.final_finally_finalize_answer)
                }
                QA.equals_deng -> {
                    intent.putExtra("question", QA.equals_deng)
                    intent.putExtra("answer", QA.equals_deng_answer)
                }
                QA.overloading_overriding -> {
                    intent.putExtra("question", QA.overloading_overriding)
                    intent.putExtra("answer", QA.overloading_overriding_answer)
                }
                QA.polymorphism_extends -> {
                    intent.putExtra("question", QA.polymorphism_extends)
                    intent.putExtra("answer", QA.polymorphism_extends_answer)
                }
                QA.generic_reflection -> {
                    intent.putExtra("question", QA.generic_reflection)
                    intent.putExtra("answer", QA.generic_reflection_answer)
                }
                QA.join_about -> {
                    intent.putExtra("question", QA.join_about)
                    intent.putExtra("answer", QA.join_about_answer)
                }
                QA.deadlock_about -> {
                    intent.putExtra("question", QA.deadlock_about)
                    intent.putExtra("answer", QA.deadlock_about_answer)
                }
                QA.sum_link -> {
                    intent.putExtra("question", QA.sum_link)
                    intent.putExtra("answer", QA.sum_link_answer)
                }
                QA.array_link -> {
                    intent.putExtra("question", QA.array_link)
                    intent.putExtra("answer", QA.array_link_answer)
                }
                QA.string_string_buffer -> {
                    intent.putExtra("question", QA.string_string_buffer)
                    intent.putExtra("answer", QA.string_string_buffer_answer)
                }
                QA.thread_application -> {
                    intent.putExtra("question", QA.thread_application)
                    intent.putExtra("answer", QA.thread_application_answer)
                }
                QA.hash_map_hashtable -> {
                    intent.putExtra("question", QA.hash_map_hashtable)
                    intent.putExtra("answer", QA.hash_map_hashtable_answer)
                }
                QA.clean_apk -> {
                    intent.putExtra("question", QA.clean_apk)
                    intent.putExtra("answer", QA.clean_apk_answer)
                }
                QA.binder_info -> {
                    intent.putExtra("question", QA.binder_info)
                    intent.putExtra("answer", QA.binder_info_answer)
                }
                QA.thread_status -> {
                    intent.putExtra("question", QA.thread_status)
                    intent.putExtra("answer", QA.thread_status_answer)
                }
                QA.interrupt_interrupted -> {
                    intent.putExtra("question", QA.interrupt_interrupted)
                    intent.putExtra("answer", QA.interrupt_interrupted_answer)
                }
                QA.catch_exception -> {
                    intent.putExtra("question", QA.catch_exception)
                    intent.putExtra("answer", QA.catch_exception_answer)
                }
                QA.ui_block -> {
                    intent.putExtra("question", QA.ui_block)
                    intent.putExtra("answer", QA.ui_block_answer)
                }
                QA.not_ui_refresh -> {
                    intent.putExtra("question", QA.not_ui_refresh)
                    intent.putExtra("answer", QA.not_ui_refresh_answer)
                }
                QA.serializable_parcelable -> {
                    intent.putExtra("question", QA.serializable_parcelable)
                    intent.putExtra("answer", QA.serializable_parcelable_answer)
                }
                QA.more_process -> {
                    intent.putExtra("question", QA.more_process)
                    intent.putExtra("answer", QA.more_process_answer)
                }
                QA.sp_about -> {
                    intent.putExtra("question", QA.sp_about)
                    intent.putExtra("answer", QA.sp_about_answer)
                }
                QA.fragment_life -> {
                    intent.putExtra("question", QA.fragment_life)
                    intent.putExtra("answer", QA.fragment_life_answer)
                }
                QA.lazy_fragment -> {
                    intent.putExtra("question", QA.lazy_fragment)
                    intent.putExtra("answer", QA.lazy_fragment_answer)
                }
                QA.class_load -> {
                    intent.putExtra("question", QA.class_load)
                    intent.putExtra("answer", QA.class_load_answer)
                }
                QA.abstract_interface -> {
                    intent.putExtra("question", QA.abstract_interface)
                    intent.putExtra("answer", QA.abstract_interface_answer)
                }
                QA.blocking_queue -> {
                    intent.putExtra("question", QA.blocking_queue)
                    intent.putExtra("answer", QA.blocking_queue_answer)
                }
                QA.why_no_die -> {
                    intent.putExtra("question", QA.why_no_die)
                    intent.putExtra("answer", QA.why_no_die_answer)
                }
                QA.delay_message -> {
                    intent.putExtra("question", QA.delay_message)
                    intent.putExtra("answer", QA.delay_message_answer)
                }
                QA.handler_async -> {
                    intent.putExtra("question", QA.handler_async)
                    intent.putExtra("answer", QA.handler_async_answer)
                }

//                    QA.fragment_life -> {//图片缩放
//                        intent = Intent(context, AlgorithmDetailActivity::class.java)
//                        intent.putExtra("image", R.drawable.fragment_life_image)
//                    }

            }
        }
    }
}