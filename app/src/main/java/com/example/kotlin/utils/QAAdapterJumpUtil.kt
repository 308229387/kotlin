package com.example.kotlin.utils

import android.content.Context
import android.content.Intent
import com.example.kotlin.activity.QADetailActivity
import com.example.kotlin.activity.QAHorizontalDetailActivity
import com.example.kotlin.data.AlgorithmQA
import com.example.kotlin.data.QA

/**
 * Author: sym
 * Date: 2021/8/6 10:07 PM
 * Describe:
 */
class QAAdapterJumpUtil {
    companion object {
        var intent =Intent()
        fun setIntent(context: Context, title:String) {
            when (title) {
                QA.performance_optimization -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.performance_optimization)
                    intent.putExtra("answer", QA.performance_optimization_answer)
                }
                QA.tcp_shake_hands -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.tcp_shake_hands)
                    intent.putExtra("answer", QA.tcp_shake_hands_answer)
                }
                QA.draw_view -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.draw_view)
                    intent.putExtra("answer", QA.draw_view_answer)
                }
                QA.lock_type_use -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.lock_type_use)
                    intent.putExtra("answer", QA.lock_type_use_answer)
                }
                QA.activity_life -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.activity_life)
                    intent.putExtra("answer", QA.activity_life_answer)
                }
                QA.android_configChanges -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.android_configChanges)
                    intent.putExtra("answer", QA.android_configChanges_answer)
                }

                QA.service_life_stop -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.service_life_stop)
                    intent.putExtra("answer", QA.service_life_stop_answer)
                }
                QA.activity_launchMode -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.activity_launchMode)
                    intent.putExtra("answer", QA.activity_launchMode_answer)
                }
                QA.http_https -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.http_https)
                    intent.putExtra("answer", QA.http_https_answer)
                }
                QA.jvm_model -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.jvm_model)
                    intent.putExtra("answer", QA.jvm_model_answer)
                }
                QA.jvm_gc_root -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.jvm_gc_root)
                    intent.putExtra("answer", QA.jvm_gc_root_answer)
                }
                QA.volatile_synchronize_use -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.volatile_synchronize_use)
                    intent.putExtra("answer", QA.volatile_synchronize_use_answer)
                }
                QA.four_components -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.four_components)
                    intent.putExtra("answer", QA.four_components_answer)
                }
                QA.handler_four_components_use -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.handler_four_components_use)
                    intent.putExtra("answer", QA.handler_four_components_use_answer)
                }
                QA.solve_anr -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.solve_anr)
                    intent.putExtra("answer", QA.solve_anr_answer)
                }
                QA.touch_event -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.touch_event)
                    intent.putExtra("answer", QA.touch_event_answer)
                }
                QA.memory_leak -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.memory_leak)
                    intent.putExtra("answer", QA.memory_leak_answer)
                }
                QA.animations -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.animations)
                    intent.putExtra("answer", QA.animations_answer)
                }
                QA.hash_map -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.hash_map)
                    intent.putExtra("answer", QA.hash_map_answer)
                }
                QA.aidl -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.aidl)
                    intent.putExtra("answer", QA.aidl_answer)
                }
                QA.thread_pool -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.thread_pool)
                    intent.putExtra("answer", QA.thread_pool_answer)
                }
                QA.leak_canary -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.leak_canary)
                    intent.putExtra("answer", QA.leak_canary_answer)
                }
                QA.java_reference -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.java_reference)
                    intent.putExtra("answer", QA.java_reference_answer)
                }
                QA.synchronize_lock -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.synchronize_lock)
                    intent.putExtra("answer", QA.synchronize_lock_answer)
                }
                QA.thread_local -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.thread_local)
                    intent.putExtra("answer", QA.thread_local_answer)
                }
                QA.thread_about -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.thread_about)
                    intent.putExtra("answer", QA.thread_about_answer)
                }
                QA.sleep_wait -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.sleep_wait)
                    intent.putExtra("answer", QA.sleep_wait_answer)
                }
                QA.version_features -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.version_features)
                    intent.putExtra("answer", QA.version_features_answer)
                }
                QA.handler_thread -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.handler_thread)
                    intent.putExtra("answer", QA.handler_thread_answer)
                }
                QA.invalidate -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.invalidate)
                    intent.putExtra("answer", QA.invalidate_answer)
                }
                QA.app_start -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.app_start)
                    intent.putExtra("answer", QA.app_start_answer)
                }
                QA.mvp -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.mvp)
                    intent.putExtra("answer", QA.mvp_answer)
                }
                QA.intent_service -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.intent_service)
                    intent.putExtra("answer", QA.intent_service_answer)
                }
                QA.assets_res -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.assets_res)
                    intent.putExtra("answer", QA.assets_res_answer)
                }
                QA.final_finally_finalize -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.final_finally_finalize)
                    intent.putExtra("answer", QA.final_finally_finalize_answer)
                }
                QA.equals_deng -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.equals_deng)
                    intent.putExtra("answer", QA.equals_deng_answer)
                }
                QA.overloading_overriding -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.overloading_overriding)
                    intent.putExtra("answer", QA.overloading_overriding_answer)
                }
                QA.polymorphism_extends -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.polymorphism_extends)
                    intent.putExtra("answer", QA.polymorphism_extends_answer)
                }
                QA.generic_reflection -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.generic_reflection)
                    intent.putExtra("answer", QA.generic_reflection_answer)
                }
                QA.join_about -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.join_about)
                    intent.putExtra("answer", QA.join_about_answer)
                }
                QA.deadlock_about -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.deadlock_about)
                    intent.putExtra("answer", QA.deadlock_about_answer)
                }
                QA.sum_link -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.sum_link)
                    intent.putExtra("answer", QA.sum_link_answer)
                }
                QA.array_link -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.array_link)
                    intent.putExtra("answer", QA.array_link_answer)
                }
                QA.string_string_buffer -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.string_string_buffer)
                    intent.putExtra("answer", QA.string_string_buffer_answer)
                }
                QA.thread_application -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.thread_application)
                    intent.putExtra("answer", QA.thread_application_answer)
                }
                QA.hash_map_hashtable -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.hash_map_hashtable)
                    intent.putExtra("answer", QA.hash_map_hashtable_answer)
                }
                QA.clean_apk -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.clean_apk)
                    intent.putExtra("answer", QA.clean_apk_answer)
                }
                QA.binder_info -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.binder_info)
                    intent.putExtra("answer", QA.binder_info_answer)
                }
                QA.thread_status -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.thread_status)
                    intent.putExtra("answer", QA.thread_status_answer)
                }
                QA.interrupt_interrupted -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.interrupt_interrupted)
                    intent.putExtra("answer", QA.interrupt_interrupted_answer)
                }
                QA.catch_exception -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.catch_exception)
                    intent.putExtra("answer", QA.catch_exception_answer)
                }
                QA.ui_block -> {
                    intent.putExtra("title", QA.ui_block)
                    intent.putExtra("answer", QA.ui_block_answer)
                }
                QA.not_ui_refresh -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.not_ui_refresh)
                    intent.putExtra("answer", QA.not_ui_refresh_answer)
                }
                QA.serializable_parcelable -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.serializable_parcelable)
                    intent.putExtra("answer", QA.serializable_parcelable_answer)
                }
                QA.more_process -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.more_process)
                    intent.putExtra("answer", QA.more_process_answer)
                }
                QA.sp_about -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.sp_about)
                    intent.putExtra("answer", QA.sp_about_answer)
                }
                QA.fragment_life -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.fragment_life)
                    intent.putExtra("answer", QA.fragment_life_answer)
                }
                QA.lazy_fragment -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.lazy_fragment)
                    intent.putExtra("answer", QA.lazy_fragment_answer)
                }
                QA.class_load -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.class_load)
                    intent.putExtra("answer", QA.class_load_answer)
                }
                QA.abstract_interface -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.abstract_interface)
                    intent.putExtra("answer", QA.abstract_interface_answer)
                }
                QA.blocking_queue -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.blocking_queue)
                    intent.putExtra("answer", QA.blocking_queue_answer)
                }
                QA.why_no_die -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.why_no_die)
                    intent.putExtra("answer", QA.why_no_die_answer)
                }
                QA.delay_message -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.delay_message)
                    intent.putExtra("answer", QA.delay_message_answer)
                }
                QA.handler_async -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.handler_async)
                    intent.putExtra("answer", QA.handler_async_answer)
                }



                AlgorithmQA.reverse_list -> {
                    intent = Intent(context, QAHorizontalDetailActivity::class.java)
                    intent.putExtra("question", AlgorithmQA.reverse_list)
                    intent.putExtra("answer", AlgorithmQA.reverse_list_answer)
                }
                AlgorithmQA.has_cycle -> {
                    intent = Intent(context, QAHorizontalDetailActivity::class.java)
                    intent.putExtra("question", AlgorithmQA.has_cycle)
                    intent.putExtra("answer", AlgorithmQA.has_cycle_answer)
                }
                AlgorithmQA.merge_two_lists -> {
                    intent = Intent(context, QAHorizontalDetailActivity::class.java)
                    intent.putExtra("question", AlgorithmQA.merge_two_lists)
                    intent.putExtra("answer", AlgorithmQA.merge_two_lists_answer)
                }
                AlgorithmQA.k_th_from_end -> {
                    intent = Intent(context, QAHorizontalDetailActivity::class.java)
                    intent.putExtra("question", AlgorithmQA.k_th_from_end)
                    intent.putExtra("answer", AlgorithmQA.k_th_from_end_answer)
                }
                AlgorithmQA.jump_steps -> {
                    intent = Intent(context, QAHorizontalDetailActivity::class.java)
                    intent.putExtra("question", AlgorithmQA.jump_steps)
                    intent.putExtra("answer", AlgorithmQA.jump_steps_answer)
                }
                AlgorithmQA.delete_node -> {
                    intent = Intent(context, QAHorizontalDetailActivity::class.java)
                    intent.putExtra("question", AlgorithmQA.delete_node)
                    intent.putExtra("answer", AlgorithmQA.delete_node_answer)
                }
                AlgorithmQA.merge_num -> {
                    intent = Intent(context, QAHorizontalDetailActivity::class.java)
                    intent.putExtra("question", AlgorithmQA.merge_num)
                    intent.putExtra("answer", AlgorithmQA.merge_num_answer)
                }
                AlgorithmQA.merge_num_traverse -> {
                    intent = Intent(context, QAHorizontalDetailActivity::class.java)
                    intent.putExtra("question", AlgorithmQA.merge_num_traverse)
                    intent.putExtra("answer", AlgorithmQA.merge_num_traverse_answer)
                }
                AlgorithmQA.string_add -> {
                    intent = Intent(context, QAHorizontalDetailActivity::class.java)
                    intent.putExtra("question", AlgorithmQA.string_add)
                    intent.putExtra("answer", AlgorithmQA.string_add_answer)
                }
                AlgorithmQA.first_show_char -> {
                    intent.putExtra("question", AlgorithmQA.first_show_char)
                    intent.putExtra("answer", AlgorithmQA.first_show_char_answer)
                }
                AlgorithmQA.two_sum -> {
                    intent.putExtra("question", AlgorithmQA.two_sum)
                    intent.putExtra("answer", AlgorithmQA.two_sum_answer)
                }
                AlgorithmQA.replace_space -> {
                    intent = Intent(context, QAHorizontalDetailActivity::class.java)
                    intent.putExtra("question", AlgorithmQA.replace_space)
                    intent.putExtra("answer", AlgorithmQA.replace_space_answer)
                }
                AlgorithmQA.reverse_print_recursive -> {
                    intent = Intent(context, QAHorizontalDetailActivity::class.java)
                    intent.putExtra("question", AlgorithmQA.reverse_print_recursive)
                    intent.putExtra("answer", AlgorithmQA.reverse_print_recursive_answer)
                }
                AlgorithmQA.reverse_print_stack -> {
                    intent = Intent(context, QAHorizontalDetailActivity::class.java)
                    intent.putExtra("question", AlgorithmQA.reverse_print_stack)
                    intent.putExtra("answer", AlgorithmQA.reverse_print_stack_answer)
                }


//                    QA.fragment_life -> {//图片缩放
//                        intent = Intent(context, AlgorithmDetailActivity::class.java)
//                        intent.putExtra("image", R.drawable.fragment_life_image)
//                    }

            }
            context.startActivity(intent)
        }
    }
}