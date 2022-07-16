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
        var intent = Intent()

        fun jumpQA(text:String,answer:String,context: Context){
            intent = Intent(context, QADetailActivity::class.java)
            intent.putExtra("title", text)
            intent.putExtra("answer", answer)
        }

        fun setIntent(context: Context, title: String) {
            when (title) {
                QA.performance_optimization -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.performance_optimization)
                    intent.putExtra("answer", QA.performance_optimization_answer)
                }
                QA.cache_optimization -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.cache_optimization)
                    intent.putExtra("answer", QA.cache_optimization_answer)
                }
                QA.cache_big -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.cache_big)
                    intent.putExtra("answer", QA.cache_big_answer)
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
                QA.view_draw_process -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.view_draw_process)
                    intent.putExtra("answer", QA.view_draw_process_answer)
                }
                QA.surfaceView_about -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.surfaceView_about)
                    intent.putExtra("answer", QA.surfaceView_about_answer)
                }
                QA.surfaceView_use -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.surfaceView_use)
                    intent.putExtra("answer", QA.surfaceView_use_answer)
                }
                QA.synchronized_use -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.synchronized_use)
                    intent.putExtra("answer", QA.synchronized_use_answer)
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

                QA.service_create -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.service_create)
                    intent.putExtra("answer", QA.service_create_answer)
                }
                QA.service_two_create_diff -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.service_two_create_diff)
                    intent.putExtra("answer", QA.service_two_create_diff_answer)
                }
                QA.service_life -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.service_life)
                    intent.putExtra("answer", QA.service_life_answer)
                }
                QA.service_stop -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.service_stop)
                    intent.putExtra("answer", QA.service_stop_answer)
                }
                QA.service_activity_info -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.service_activity_info)
                    intent.putExtra("answer", QA.service_activity_info_answer)
                }
                QA.activity_launchMode -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.activity_launchMode)
                    intent.putExtra("answer", QA.activity_launchMode_answer)
                }
                QA.activity_task -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.activity_task)
                    intent.putExtra("answer", QA.activity_task_answer)
                }
                QA.activity_launchMode_how -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.activity_launchMode_how)
                    intent.putExtra("answer", QA.activity_launchMode_how_answer)
                }
                QA.activity_launchMode_question -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.activity_launchMode_question)
                    intent.putExtra("answer", QA.activity_launchMode_question_answer)
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
                QA.jvm_gc_work -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.jvm_gc_work)
                    intent.putExtra("answer", QA.jvm_gc_work_answer)
                }
                QA.mark_rubbish -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.mark_rubbish)
                    intent.putExtra("answer", QA.mark_rubbish_answer)
                }
                QA.clean_rubbish -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.clean_rubbish)
                    intent.putExtra("answer", QA.clean_rubbish_answer)
                }
                QA.rubbish_robot -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.rubbish_robot)
                    intent.putExtra("answer", QA.rubbish_robot_answer)
                }
                QA.four_components -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.four_components)
                    intent.putExtra("answer", QA.four_components_answer)
                }
                QA.handler_four_components -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.handler_four_components)
                    intent.putExtra("answer", QA.handler_four_components_answer)
                }
                QA.handler_use -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.handler_use)
                    intent.putExtra("answer", QA.handler_use_answer)
                }
                QA.handler_child_create -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.handler_child_create)
                    intent.putExtra("answer", QA.handler_child_create_answer)
                }
                QA.what_anr -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.what_anr)
                    intent.putExtra("answer", QA.what_anr_answer)
                }
                QA.watching_anr -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.watching_anr)
                    intent.putExtra("answer", QA.watching_anr_answer)
                }
                QA.solve_anr -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.solve_anr)
                    intent.putExtra("answer", QA.solve_anr_answer)
                }
                QA.block_canary_principle -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.block_canary_principle)
                    intent.putExtra("answer", QA.block_canary_principle_answer)
                }
                QA.touch_event -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.touch_event)
                    intent.putExtra("answer", QA.touch_event_answer)
                }
                QA.touch_event_move -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.touch_event_move)
                    intent.putExtra("answer", QA.touch_event_move_answer)
                }
                QA.touch_event_target -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.touch_event_target)
                    intent.putExtra("answer", QA.touch_event_target_answer)
                }
                QA.touch_event_conflict -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.touch_event_conflict)
                    intent.putExtra("answer", QA.touch_event_conflict_answer)
                }
                QA.touch_event_x_different -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.touch_event_x_different)
                    intent.putExtra("answer", QA.touch_event_x_different_answer)
                }
                QA.memory_leak -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.memory_leak)
                    intent.putExtra("answer", QA.memory_leak_answer)
                }
                QA.value_animator -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.value_animator)
                    intent.putExtra("answer", QA.value_animator_answer)
                }
                QA.object_animator -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.object_animator)
                    intent.putExtra("answer", QA.object_animator_answer)
                }
                QA.animator_animator_set -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.animator_animator_set)
                    intent.putExtra("answer", QA.animator_animator_set_answer)
                }
                QA.property_values_holder -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.property_values_holder)
                    intent.putExtra("answer", QA.property_values_holder_answer)
                }
                QA.type_evaluator_about -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.type_evaluator_about)
                    intent.putExtra("answer", QA.type_evaluator_about_answer)
                }
                QA.interpolator_about -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.interpolator_about)
                    intent.putExtra("answer", QA.interpolator_about_answer)
                }
                QA.animator_listener -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.animator_listener)
                    intent.putExtra("answer", QA.animator_listener_answer)
                }
                QA.type_evaluator_interpolator_diff -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.type_evaluator_interpolator_diff)
                    intent.putExtra("answer", QA.type_evaluator_interpolator_diff_answer)
                }
                QA.value_animations_about -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.value_animations_about)
                    intent.putExtra("answer", QA.value_animations_about_answer)
                }
                QA.frame_animation -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.frame_animation)
                    intent.putExtra("answer", QA.frame_animation_answer)
                }
                QA.tween_animation -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.tween_animation)
                    intent.putExtra("answer", QA.tween_animation_answer)
                }
                QA.hash_map -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.hash_map)
                    intent.putExtra("answer", QA.hash_map_answer)
                }
                QA.how_hash -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.how_hash)
                    intent.putExtra("answer", QA.how_hash_answer)
                }
                QA.how_hash_map_index -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.how_hash_map_index)
                    intent.putExtra("answer", QA.how_hash_map_index_answer)
                }
                QA.change_big -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.change_big)
                    intent.putExtra("answer", QA.change_big_answer)
                }
                QA.red_black_time -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.red_black_time)
                    intent.putExtra("answer", QA.red_black_time_answer)
                }
                QA.aidl -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.aidl)
                    intent.putExtra("answer", QA.aidl_answer)
                }
                QA.thread_pool_create -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.thread_pool_create)
                    intent.putExtra("answer", QA.thread_pool_create_answer)
                }
                QA.thread_work_principle -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.thread_work_principle)
                    intent.putExtra("answer", QA.thread_work_principle_answer)
                }
                QA.thread_seven_params -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.thread_seven_params)
                    intent.putExtra("answer", QA.thread_seven_params_answer)
                }
                QA.thread_four_api -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.thread_four_api)
                    intent.putExtra("answer", QA.thread_four_api_answer)
                }
                QA.thread_shut_down -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.thread_shut_down)
                    intent.putExtra("answer", QA.thread_shut_down_answer)
                }
                QA.thread_pool_work_queue -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.thread_pool_work_queue)
                    intent.putExtra("answer", QA.thread_pool_work_queue_answer)
                }
                QA.thread_pool_reject_policy -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.thread_pool_reject_policy)
                    intent.putExtra("answer", QA.thread_pool_reject_policy_answer)
                }
                QA.thread_pool_recycling -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.thread_pool_recycling)
                    intent.putExtra("answer", QA.thread_pool_recycling_answer)
                }
                QA.get_view_high -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.get_view_high)
                    intent.putExtra("answer", QA.get_view_high_answer)
                }
                QA.base_activity -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.base_activity)
                    intent.putExtra("answer", QA.base_activity_answer)
                }
                QA.project_version -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.project_version)
                    intent.putExtra("answer", QA.project_version_answer)
                }
                QA.always_exception -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.always_exception)
                    intent.putExtra("answer", QA.always_exception_answer)
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
                QA.java_reference_queue -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.java_reference_queue)
                    intent.putExtra("answer", QA.java_reference_queue_answer)
                }
                QA.android_annotation -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.android_annotation)
                    intent.putExtra("answer", QA.android_annotation_answer)
                }
                QA.thread_local -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.thread_local)
                    intent.putExtra("answer", QA.thread_local_answer)
                }
                QA.thread_create -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.thread_create)
                    intent.putExtra("answer", QA.thread_create_answer)
                }
                QA.thread_stop -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.thread_stop)
                    intent.putExtra("answer", QA.thread_stop_answer)
                }
                QA.thread_change -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.thread_change)
                    intent.putExtra("answer", QA.thread_change_answer)
                }
                QA.thread_safe -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.thread_safe)
                    intent.putExtra("answer", QA.thread_safe_answer)
                }
                QA.sleep_wait -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.sleep_wait)
                    intent.putExtra("answer", QA.sleep_wait_answer)
                }
                QA.sleep_0 -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.sleep_0)
                    intent.putExtra("answer", QA.sleep_0_answer)
                }
                QA.version_features -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.version_features)
                    intent.putExtra("answer", QA.version_features_answer)
                }
                QA.framework_about -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.framework_about)
                    intent.putExtra("answer", QA.framework_about_answer)
                }
                QA.android_base -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.android_base)
                    intent.putExtra("answer", QA.android_base_answer)
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
                QA.app_start_process -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.app_start_process)
                    intent.putExtra("answer", QA.app_start_process_answer)
                }
                QA.app_start_about_role -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.app_start_about_role)
                    intent.putExtra("answer", QA.app_start_about_role_answer)
                }
                QA.app_start_start_time -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.app_start_start_time)
                    intent.putExtra("answer", QA.app_start_start_time_answer)
                }
                QA.app_start_optimize -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.app_start_optimize)
                    intent.putExtra("answer", QA.app_start_optimize_answer)
                }
                QA.app_start_method_sequence -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.app_start_method_sequence)
                    intent.putExtra("answer", QA.app_start_method_sequence_answer)
                }
                QA.mvp -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.mvp)
                    intent.putExtra("answer", QA.mvp_answer)
                }
                QA.mvc -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.mvc)
                    intent.putExtra("answer", QA.mvc_answer)
                }
                QA.mvvm -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.mvvm)
                    intent.putExtra("answer", QA.mvvm_answer)
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
                QA.equals_hash_code -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.equals_hash_code)
                    intent.putExtra("answer", QA.equals_hash_code_answer)
                }
                QA.overloading_overriding -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.overloading_overriding)
                    intent.putExtra("answer", QA.overloading_overriding_answer)
                }
                QA.java_three_point -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.java_three_point)
                    intent.putExtra("answer", QA.java_three_point_answer)
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
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.ui_block)
                    intent.putExtra("answer", QA.ui_block_answer)
                }
                QA.how_solve_block -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.how_solve_block)
                    intent.putExtra("answer", QA.how_solve_block_answer)
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
                QA.more_process_purpose -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.more_process_purpose)
                    intent.putExtra("answer", QA.more_process_purpose_answer)
                }
                QA.more_process_use -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.more_process_use)
                    intent.putExtra("answer", QA.more_process_use_answer)
                }
                QA.many_process_communication -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.many_process_communication)
                    intent.putExtra("answer", QA.many_process_communication_answer)
                }
                QA.more_process_question -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.more_process_question)
                    intent.putExtra("answer", QA.more_process_question_answer)
                }
                QA.sp_about -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.sp_about)
                    intent.putExtra("answer", QA.sp_about_answer)
                }
                QA.sp_why_light -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.sp_why_light)
                    intent.putExtra("answer", QA.sp_why_light_answer)
                }
                QA.sp_save_steps -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.sp_save_steps)
                    intent.putExtra("answer", QA.sp_save_steps_answer)
                }
                QA.sp_principle -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.sp_principle)
                    intent.putExtra("answer", QA.sp_principle_answer)
                }
                QA.sp_two_save_method -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.sp_two_save_method)
                    intent.putExtra("answer", QA.sp_two_save_method_answer)
                }
                QA.sp_why_no_safe -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.sp_why_no_safe)
                    intent.putExtra("answer", QA.sp_why_no_safe_answer)
                }
                QA.fragment_life -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.fragment_life)
                    intent.putExtra("answer", QA.fragment_life_answer)
                }
                QA.fragment_life_change -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.fragment_life_change)
                    intent.putExtra("answer", QA.fragment_life_change_answer)
                }
                QA.lazy_fragment_purpose -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.lazy_fragment_purpose)
                    intent.putExtra("answer", QA.lazy_fragment_purpose_answer)
                }
                QA.lazy_fragment_support -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.lazy_fragment_support)
                    intent.putExtra("answer", QA.lazy_fragment_support_answer)
                }
                QA.lazy_fragment_androidx -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.lazy_fragment_androidx)
                    intent.putExtra("answer", QA.lazy_fragment_androidx_answer)
                }
                QA.class_load -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.class_load)
                    intent.putExtra("answer", QA.class_load_answer)
                }
                QA.class_load_three -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.class_load_three)
                    intent.putExtra("answer", QA.class_load_three_answer)
                }
                QA.android_class_load -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.android_class_load)
                    intent.putExtra("answer", QA.android_class_load_answer)
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
                QA.content_provider -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.content_provider)
                    intent.putExtra("answer", QA.content_provider_answer)
                }
                QA.content_resolver -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.content_resolver)
                    intent.putExtra("answer", QA.content_resolver_answer)
                }
                QA.content_provider_uri -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.content_provider_uri)
                    intent.putExtra("answer", QA.content_provider_uri_answer)
                }
                QA.content_provider_steps -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.content_provider_steps)
                    intent.putExtra("answer", QA.content_provider_steps_answer)
                }
                QA.how_many_string -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.how_many_string)
                    intent.putExtra("answer", QA.how_many_string_answer)
                }
                QA.volatile_principle -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.volatile_principle)
                    intent.putExtra("answer", QA.volatile_principle_answer)
                }
                QA.volatile_features -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.volatile_features)
                    intent.putExtra("answer", QA.volatile_features_answer)
                }
                QA.synchronize_principle -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.synchronize_principle)
                    intent.putExtra("answer", QA.synchronize_principle_answer)
                }
                QA.lock_principle -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.lock_principle)
                    intent.putExtra("answer", QA.lock_principle_answer)
                }
                QA.project_architecture -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.project_architecture)
                    intent.putExtra("answer", QA.project_architecture_answer)
                }
                QA.bao_xiao_mi -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.bao_xiao_mi)
                    intent.putExtra("answer", QA.bao_xiao_mi_answer)
                }
                QA.hashtable_about -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.hashtable_about)
                    intent.putExtra("answer", QA.hashtable_about_answer)
                }
                QA.live_level_plan -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.live_level_plan)
                    intent.putExtra("answer", QA.live_level_plan_answer)
                }
                QA.on_line_block -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.on_line_block)
                    intent.putExtra("answer", QA.on_line_block_answer)
                }
                QA.on_line_cache -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.on_line_cache)
                    intent.putExtra("answer", QA.on_line_cache_answer)
                }
                QA.anr_watch_dog -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.anr_watch_dog)
                    intent.putExtra("answer", QA.anr_watch_dog_answer)
                }
                QA.volatile_synchronize_different -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.volatile_synchronize_different)
                    intent.putExtra("answer", QA.volatile_synchronize_different_answer)
                }
                QA.synchronize_range -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.synchronize_range)
                    intent.putExtra("answer", QA.synchronize_range_answer)
                }
                QA.synchronized_lock_diff -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.synchronized_lock_diff)
                    intent.putExtra("answer", QA.synchronized_lock_diff_answer)
                }
                QA.true_lock -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.true_lock)
                    intent.putExtra("answer", QA.true_lock_answer)
                }
                QA.false_lock -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.false_lock)
                    intent.putExtra("answer", QA.false_lock_answer)
                }
                QA.twice_lock -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.twice_lock)
                    intent.putExtra("answer", QA.twice_lock_answer)
                }
                QA.lock_use -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.lock_use)
                    intent.putExtra("answer", QA.lock_use_answer)
                }
                QA.fragment_activity_communication -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.fragment_activity_communication)
                    intent.putExtra("answer", QA.fragment_activity_communication_answer)
                }
                QA.list_diff -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.list_diff)
                    intent.putExtra("answer", QA.list_diff_answer)
                }
                QA.butter_knife -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.butter_knife)
                    intent.putExtra("answer", QA.butter_knife_answer)
                }
                QA.hot_class_load -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.hot_class_load)
                    intent.putExtra("answer", QA.hot_class_load_answer)
                }
                QA.hot_below_replace -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.hot_below_replace)
                    intent.putExtra("answer", QA.hot_below_replace_answer)
                }
                QA.hot_instant_run -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.hot_instant_run)
                    intent.putExtra("answer", QA.hot_instant_run_answer)
                }
                QA.jet_pack -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.jet_pack)
                    intent.putExtra("answer", QA.jet_pack_answer)
                }
                QA.auto_adapter_screen -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.auto_adapter_screen)
                    intent.putExtra("answer", QA.auto_adapter_screen_answer)
                }
                QA.concurrent_hash_map -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.concurrent_hash_map)
                    intent.putExtra("answer", QA.concurrent_hash_map_answer)
                }
                QA.https_process -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.https_process)
                    intent.putExtra("answer", QA.https_process_answer)
                }
                QA.design_patterns -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.design_patterns)
                    intent.putExtra("answer", QA.design_patterns_answer)
                }
                QA.net_work_level -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.net_work_level)
                    intent.putExtra("answer", QA.net_work_level_answer)
                }
                QA.tcp_udp_different -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.tcp_udp_different)
                    intent.putExtra("answer", QA.tcp_udp_different_answer)
                }
                QA.url_process -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.url_process)
                    intent.putExtra("answer", QA.url_process_answer)
                }
                QA.http_error_code -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.http_error_code)
                    intent.putExtra("answer", QA.http_error_code_answer)
                }
                QA.retrofit_principle -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.retrofit_principle)
                    intent.putExtra("answer", QA.retrofit_principle_answer)
                }
                QA.dynamic_proxy_good -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.dynamic_proxy_good)
                    intent.putExtra("answer", QA.dynamic_proxy_good_answer)
                }
                QA.kotlin_good -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.kotlin_good)
                    intent.putExtra("answer", QA.kotlin_good_answer)
                }
                QA.kotlin_coroutines -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.kotlin_coroutines)
                    intent.putExtra("answer", QA.kotlin_coroutines_answer)
                }
                QA.coroutines_create -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.coroutines_create)
                    intent.putExtra("answer", QA.coroutines_create_answer)
                }
                QA.flutter_about -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.flutter_about)
                    intent.putExtra("answer", QA.flutter_about_answer)
                }
                QA.coroutines_stop -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.coroutines_stop)
                    intent.putExtra("answer", QA.coroutines_stop_answer)
                }
                QA.ok_http_process -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.ok_http_process)
                    intent.putExtra("answer", QA.ok_http_process_answer)
                }
                QA.ok_http_principle -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.ok_http_principle)
                    intent.putExtra("answer", QA.ok_http_principle_answer)
                }
                QA.glide_good_principle -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.glide_good_principle)
                    intent.putExtra("answer", QA.glide_good_principle_answer)
                }
                QA.glide_cache -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.glide_cache)
                    intent.putExtra("answer", QA.glide_cache_answer)
                }
                QA.ok_http_usr_model -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.ok_http_usr_model)
                    intent.putExtra("answer", QA.ok_http_usr_model_answer)
                }
                QA.ok_http_interceptor -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.ok_http_interceptor)
                    intent.putExtra("answer", QA.ok_http_interceptor_answer)
                }
                QA.retrofit_use -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.retrofit_use)
                    intent.putExtra("answer", QA.retrofit_use_answer)
                }
                QA.retrofit_good -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.retrofit_good)
                    intent.putExtra("answer", QA.retrofit_good_answer)
                }
                QA.modify_jar_class -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.modify_jar_class)
                    intent.putExtra("answer", QA.modify_jar_class_answer)
                }
                QA.rely_on_repeat -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.rely_on_repeat)
                    intent.putExtra("answer", QA.rely_on_repeat_answer)
                }
                QA.r_x_java_1 -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.r_x_java_1)
                    intent.putExtra("answer", QA.r_x_java_1_answer)
                }
                QA.r_x_java_2 -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.r_x_java_2)
                    intent.putExtra("answer", QA.r_x_java_2_answer)
                }
                QA.r_x_java_3 -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.r_x_java_3)
                    intent.putExtra("answer", QA.r_x_java_3_answer)
                }
                QA.r_x_java_4 -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.r_x_java_4)
                    intent.putExtra("answer", QA.r_x_java_4_answer)
                }
                QA.async_task_use -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.async_task_use)
                    intent.putExtra("answer", QA.async_task_use_answer)
                }
                QA.async_task_principle -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.async_task_principle)
                    intent.putExtra("answer", QA.async_task_principle_answer)
                }
                QA.async_task_fun -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.async_task_fun)
                    intent.putExtra("answer", QA.async_task_fun_answer)
                }
                QA.r_x_use_code -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.r_x_use_code)
                    intent.putExtra("answer", QA.r_x_use_code_answer)
                }
                QA.r_x_java_send -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.r_x_java_send)
                    intent.putExtra("answer", QA.r_x_java_send_answer)
                }
                QA.coroutines_cancel_join -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.coroutines_cancel_join)
                    intent.putExtra("answer", QA.coroutines_cancel_join_answer)
                }
                QA.coroutines_async -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.coroutines_async)
                    intent.putExtra("answer", QA.coroutines_async_answer)
                }
                QA.coroutines_pause_return -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.coroutines_pause_return)
                    intent.putExtra("answer", QA.coroutines_pause_return_answer)
                }
                QA.have_no_broadcast_diff -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.have_no_broadcast_diff)
                    intent.putExtra("answer", QA.have_no_broadcast_diff_answer)
                }
                QA.dynamic_broadcast_registered -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.dynamic_broadcast_registered)
                    intent.putExtra("answer", QA.dynamic_broadcast_registered_answer)
                }
                QA.static_broadcast_registered -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.static_broadcast_registered)
                    intent.putExtra("answer", QA.static_broadcast_registered_answer)
                }
                QA.program_alive -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.program_alive)
                    intent.putExtra("answer", QA.program_alive_answer)
                }
                QA.bitmap_optimize -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.bitmap_optimize)
                    intent.putExtra("answer", QA.bitmap_optimize_answer)
                }
                AlgorithmQA.task_7 -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("question", AlgorithmQA.task_7)
                    intent.putExtra("answer", AlgorithmQA.task_7_answer)
                }
                QA.long_bitmap_show -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.long_bitmap_show)
                    intent.putExtra("answer", QA.long_bitmap_show_answer)
                }
                QA.u3d_about -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.u3d_about)
                    intent.putExtra("answer", QA.u3d_about_answer)
                }
                QA.bone_animation -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.bone_animation)
                    intent.putExtra("answer", QA.bone_animation_answer)
                }
                QA.web_view_process -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.web_view_process)
                    intent.putExtra("answer", QA.web_view_process_answer)
                }
                QA.web_view_optimize -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.web_view_optimize)
                    intent.putExtra("answer", QA.web_view_optimize_answer)
                }
                QA.international_app -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.international_app)
                    intent.putExtra("answer", QA.international_app_answer)
                }
                QA.how_to_build_apk -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.how_to_build_apk)
                    intent.putExtra("answer", QA.how_to_build_apk_answer)
                }
                QA.activity_layout_build -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.activity_layout_build)
                    intent.putExtra("answer", QA.activity_layout_build_answer)
                }
                QA.activity_application_context -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.activity_application_context)
                    intent.putExtra("answer", QA.activity_application_context_answer)
                }
                QA.local_all_broadcast -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.local_all_broadcast)
                    intent.putExtra("answer", QA.local_all_broadcast_answer)
                }
                QA.thread_pool_cup_io -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.thread_pool_cup_io)
                    intent.putExtra("answer", QA.thread_pool_cup_io_answer)
                }
                QA.kotlin_code -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.kotlin_code)
                    intent.putExtra("answer", QA.kotlin_code_answer)
                }
                QA.component_jump -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.component_jump)
                    intent.putExtra("answer", QA.component_jump_answer)
                }
                QA.live_data -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.live_data)
                    intent.putExtra("answer", QA.live_data_answer)
                }
                QA.live_cycle -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.live_cycle)
                    intent.putExtra("answer", QA.live_cycle_answer)
                }
                QA.recycler_view_repeat_use -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.recycler_view_repeat_use)
                    intent.putExtra("answer", QA.recycler_view_repeat_use_answer)
                }
                QA.change_big_method -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.change_big_method)
                    intent.putExtra("answer", QA.change_big_method_answer)
                }
                QA.interceptor_usr_diff -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.interceptor_usr_diff)
                    intent.putExtra("answer", QA.interceptor_usr_diff_answer)
                }
                QA.aidl_support_data -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.aidl_support_data)
                    intent.putExtra("answer", QA.aidl_support_data_answer)
                }
                QA.aidl_bad -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.aidl_bad)
                    intent.putExtra("answer", QA.aidl_bad_answer)
                }
                QA.voice_record -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.voice_record)
                    intent.putExtra("answer", QA.voice_record_answer)
                }
                QA.voice_play -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.voice_play)
                    intent.putExtra("answer", QA.voice_play_answer)
                }
                QA.video_record -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.video_record)
                    intent.putExtra("answer", QA.video_record_answer)
                }
                QA.video_play -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.video_play)
                    intent.putExtra("answer", QA.video_play_answer)
                }
                QA.tcp_http_socket -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.tcp_http_socket)
                    intent.putExtra("answer", QA.tcp_http_socket_answer)
                }

                QA.https_hijack -> jumpQA(QA.https_hijack,QA.https_hijack_answer,context)
                QA.frame_count -> jumpQA(QA.frame_count,QA.frame_count_answer,context)
                QA.xie_cheng_yi_bu -> jumpQA(QA.xie_cheng_yi_bu,QA.xie_cheng_yi_bu_answer,context)
                QA.http_version_diff -> jumpQA(QA.http_version_diff,QA.http_version_diff_answer,context)
                QA.null_safe -> jumpQA(QA.null_safe,QA.null_safe_answer,context)
                QA.how_build_sdk -> jumpQA(QA.how_build_sdk,QA.how_build_sdk_answer,context)
                QA.zu_jian_hua_info -> jumpQA(QA.zu_jian_hua_info,QA.zu_jian_hua_info_answer,context)
                QA.event_bus -> jumpQA(QA.event_bus,QA.event_bus_answer,context)
                QA.lan_ya_net -> jumpQA(QA.lan_ya_net,QA.lan_ya_net_answer,context)
                QA.thread_pool_no_state -> jumpQA(QA.thread_pool_no_state,QA.thread_pool_no_state_answer,context)
                QA.binder_one_copy -> jumpQA(QA.binder_one_copy,QA.binder_one_copy_answer,context)
                QA.recycler_view_item_refresh -> jumpQA(QA.recycler_view_item_refresh,QA.recycler_view_item_refresh_answer,context)
                QA.base_model_value -> jumpQA(QA.base_model_value,QA.base_model_value_answer,context)
                QA.intent_move_big -> jumpQA(QA.intent_move_big,QA.intent_move_big_answer,context)
                QA.git_code -> jumpQA(QA.git_code,QA.git_code_answer,context)
                QA.context_use -> jumpQA(QA.context_use,QA.context_use_answer,context)
                QA.message_obtain -> jumpQA(QA.message_obtain,QA.message_obtain_answer,context)
                QA.zhu_jie -> jumpQA(QA.zhu_jie,QA.zhu_jie_answer,context)
                QA.use_zhu_jie -> jumpQA(QA.use_zhu_jie,QA.use_zhu_jie_answer,context)
                QA.pager_adapter -> jumpQA(QA.pager_adapter,QA.pager_adapter_answer,context)
                QA.thread_pool_use -> jumpQA(QA.thread_pool_use,QA.thread_pool_use_answer,context)
                QA.big_file_down_load -> jumpQA(QA.big_file_down_load,QA.big_file_down_load_answer,context)
                QA.m_map -> jumpQA(QA.m_map,QA.m_map_answer,context)
                QA.data_class -> jumpQA(QA.data_class,QA.data_class_answer,context)
                QA.kotlin_how_gou_zao -> jumpQA(QA.kotlin_how_gou_zao,QA.kotlin_how_gou_zao_answer,context)
                QA.copy_diff -> jumpQA(QA.copy_diff,QA.copy_diff_answer,context)
                QA.message_shun_xu -> jumpQA(QA.message_shun_xu,QA.message_shun_xu_answer,context)
                QA.cas_ji_zhi -> jumpQA(QA.cas_ji_zhi,QA.cas_ji_zhi_answer,context)
                QA.synchronized_lock -> jumpQA(QA.synchronized_lock,QA.synchronized_lock_answer,context)
                QA.zhi_jie_cache -> jumpQA(QA.zhi_jie_cache,QA.zhi_jie_cache_answer,context)
                QA.set_content_view -> jumpQA(QA.set_content_view,QA.set_content_view_answer,context)
                QA.a_router_interceptor -> jumpQA(QA.a_router_interceptor,QA.a_router_interceptor_answer,context)
                QA.a_router_usr -> jumpQA(QA.a_router_usr,QA.a_router_usr_answer,context)
                QA.a_router_process -> jumpQA(QA.a_router_process,QA.a_router_process_answer,context)
                QA.zu_jian_resource_repeat -> jumpQA(QA.zu_jian_resource_repeat,QA.zu_jian_resource_repeat_answer,context)


                //分界点---------------------


                AlgorithmQA.reverse_list -> {
                    intent = Intent(context, QAHorizontalDetailActivity::class.java)
                    intent.putExtra("question", AlgorithmQA.reverse_list)
                    intent.putExtra("answer", AlgorithmQA.reverse_list_answer)
                }
                AlgorithmQA.reverse_list_iteration -> {
                    intent = Intent(context, QAHorizontalDetailActivity::class.java)
                    intent.putExtra("question", AlgorithmQA.reverse_list_iteration)
                    intent.putExtra("answer", AlgorithmQA.reverse_list_iteration_answer)
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
                AlgorithmQA.once_show_char -> {
                    intent = Intent(context, QAHorizontalDetailActivity::class.java)
                    intent.putExtra("question", AlgorithmQA.once_show_char)
                    intent.putExtra("answer", AlgorithmQA.once_show_char_answer)
                }
                AlgorithmQA.left_rotation_string -> {
                    intent = Intent(context, QAHorizontalDetailActivity::class.java)
                    intent.putExtra("question", AlgorithmQA.left_rotation_string)
                    intent.putExtra("answer", AlgorithmQA.left_rotation_string_answer)
                }
                AlgorithmQA.string_all_arrangement -> {
                    intent = Intent(context, QAHorizontalDetailActivity::class.java)
                    intent.putExtra("question", AlgorithmQA.string_all_arrangement)
                    intent.putExtra("answer", AlgorithmQA.string_all_arrangement_answer)
                }
                AlgorithmQA.array_repeat_num -> {
                    intent = Intent(context, QAHorizontalDetailActivity::class.java)
                    intent.putExtra("question", AlgorithmQA.array_repeat_num)
                    intent.putExtra("answer", AlgorithmQA.array_repeat_num_answer)
                }
                AlgorithmQA.arrangement_array_find_num -> {
                    intent = Intent(context, QAHorizontalDetailActivity::class.java)
                    intent.putExtra("question", AlgorithmQA.arrangement_array_find_num)
                    intent.putExtra("answer", AlgorithmQA.arrangement_array_find_num_answer)
                }
                AlgorithmQA.array_missing_num -> {
                    intent = Intent(context, QAHorizontalDetailActivity::class.java)
                    intent.putExtra("question", AlgorithmQA.array_missing_num)
                    intent.putExtra("answer", AlgorithmQA.array_missing_num_answer)
                }
                AlgorithmQA.two_array_find -> {
                    intent = Intent(context, QAHorizontalDetailActivity::class.java)
                    intent.putExtra("question", AlgorithmQA.two_array_find)
                    intent.putExtra("answer", AlgorithmQA.two_array_find_answer)
                }
                AlgorithmQA.rotation_small -> {
                    intent = Intent(context, QAHorizontalDetailActivity::class.java)
                    intent.putExtra("question", AlgorithmQA.rotation_small)
                    intent.putExtra("answer", AlgorithmQA.rotation_small_answer)
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
                AlgorithmQA.two_stack_for_list -> {
                    intent = Intent(context, QAHorizontalDetailActivity::class.java)
                    intent.putExtra("question", AlgorithmQA.two_stack_for_list)
                    intent.putExtra("answer", AlgorithmQA.two_stack_for_list_answer)
                }
                AlgorithmQA.contains_min -> {
                    intent = Intent(context, QAHorizontalDetailActivity::class.java)
                    intent.putExtra("question", AlgorithmQA.contains_min)
                    intent.putExtra("answer", AlgorithmQA.contains_min_answer)
                }
                AlgorithmQA.hard_list -> {
                    intent = Intent(context, QAHorizontalDetailActivity::class.java)
                    intent.putExtra("question", AlgorithmQA.hard_list)
                    intent.putExtra("answer", AlgorithmQA.hard_list_answer)
                }
                AlgorithmQA.create_list -> {
                    intent = Intent(context, QAHorizontalDetailActivity::class.java)
                    intent.putExtra("question", AlgorithmQA.create_list)
                    intent.putExtra("answer", AlgorithmQA.create_list_answer)
                }
                AlgorithmQA.remove_n_from_end -> {
                    intent = Intent(context, QAHorizontalDetailActivity::class.java)
                    intent.putExtra("question", AlgorithmQA.remove_n_from_end)
                    intent.putExtra("answer", AlgorithmQA.remove_n_from_end_answer)
                }
                AlgorithmQA.remove_elements -> {
                    intent = Intent(context, QAHorizontalDetailActivity::class.java)
                    intent.putExtra("question", AlgorithmQA.remove_elements)
                    intent.putExtra("answer", AlgorithmQA.remove_elements_answer)
                }
                AlgorithmQA.if_has_circle -> {
                    intent = Intent(context, QAHorizontalDetailActivity::class.java)
                    intent.putExtra("question", AlgorithmQA.if_has_circle)
                    intent.putExtra("answer", AlgorithmQA.if_has_circle_answer)
                }
                AlgorithmQA.cross_list_find_cross -> {
                    intent = Intent(context, QAHorizontalDetailActivity::class.java)
                    intent.putExtra("question", AlgorithmQA.cross_list_find_cross)
                    intent.putExtra("answer", AlgorithmQA.cross_list_find_cross_answer)
                }
                AlgorithmQA.odd_even_list -> {
                    intent = Intent(context, QAHorizontalDetailActivity::class.java)
                    intent.putExtra("question", AlgorithmQA.odd_even_list)
                    intent.putExtra("answer", AlgorithmQA.odd_even_list_answer)
                }
                AlgorithmQA.is_palindrome -> {
                    intent = Intent(context, QAHorizontalDetailActivity::class.java)
                    intent.putExtra("question", AlgorithmQA.is_palindrome)
                    intent.putExtra("answer", AlgorithmQA.is_palindrome_answer)
                }
                AlgorithmQA.add_two_num -> {
                    intent = Intent(context, QAHorizontalDetailActivity::class.java)
                    intent.putExtra("question", AlgorithmQA.add_two_num)
                    intent.putExtra("answer", AlgorithmQA.add_two_num_answer)
                }
                AlgorithmQA.pre_order_traversal_recursive -> {
                    intent = Intent(context, QAHorizontalDetailActivity::class.java)
                    intent.putExtra("question", AlgorithmQA.pre_order_traversal_recursive)
                    intent.putExtra("answer", AlgorithmQA.pre_order_traversal_recursive_answer)
                }
                AlgorithmQA.iteration_pre_order -> {
                    intent = Intent(context, QAHorizontalDetailActivity::class.java)
                    intent.putExtra("question", AlgorithmQA.iteration_pre_order)
                    intent.putExtra("answer", AlgorithmQA.iteration_pre_order_answer)
                }
                AlgorithmQA.inorder_traversal -> {
                    intent = Intent(context, QAHorizontalDetailActivity::class.java)
                    intent.putExtra("question", AlgorithmQA.inorder_traversal)
                    intent.putExtra("answer", AlgorithmQA.inorder_traversal_answer)
                }
                AlgorithmQA.recursive_inorder_traversal -> {
                    intent = Intent(context, QAHorizontalDetailActivity::class.java)
                    intent.putExtra("question", AlgorithmQA.recursive_inorder_traversal)
                    intent.putExtra("answer", AlgorithmQA.recursive_inorder_traversal_answer)
                }
                AlgorithmQA.post_order_traversal -> {
                    intent = Intent(context, QAHorizontalDetailActivity::class.java)
                    intent.putExtra("question", AlgorithmQA.post_order_traversal)
                    intent.putExtra("answer", AlgorithmQA.post_order_traversal_answer)
                }
                AlgorithmQA.recursive_post_order_traversal -> {
                    intent = Intent(context, QAHorizontalDetailActivity::class.java)
                    intent.putExtra("question", AlgorithmQA.recursive_post_order_traversal)
                    intent.putExtra("answer", AlgorithmQA.recursive_post_order_traversal_answer)
                }
                AlgorithmQA.level_order -> {
                    intent = Intent(context, QAHorizontalDetailActivity::class.java)
                    intent.putExtra("question", AlgorithmQA.level_order)
                    intent.putExtra("answer", AlgorithmQA.level_order_answer)
                }
                AlgorithmQA.recursive_level_order -> {
                    intent = Intent(context, QAHorizontalDetailActivity::class.java)
                    intent.putExtra("question", AlgorithmQA.recursive_level_order)
                    intent.putExtra("answer", AlgorithmQA.recursive_level_order_answer)
                }
                AlgorithmQA.println_tree_node -> {
                    intent = Intent(context, QAHorizontalDetailActivity::class.java)
                    intent.putExtra("question", AlgorithmQA.println_tree_node)
                    intent.putExtra("answer", AlgorithmQA.println_tree_node_answer)
                }
                AlgorithmQA.println_tree_node_zhi -> {
                    intent = Intent(context, QAHorizontalDetailActivity::class.java)
                    intent.putExtra("question", AlgorithmQA.println_tree_node_zhi)
                    intent.putExtra("answer", AlgorithmQA.println_tree_node_zhi_answer)
                }
                AlgorithmQA.symmetry_tree -> {
                    intent = Intent(context, QAHorizontalDetailActivity::class.java)
                    intent.putExtra("question", AlgorithmQA.symmetry_tree)
                    intent.putExtra("answer", AlgorithmQA.symmetry_tree_answer)
                }
                AlgorithmQA.tree_left_to_right -> {
                    intent = Intent(context, QAHorizontalDetailActivity::class.java)
                    intent.putExtra("question", AlgorithmQA.tree_left_to_right)
                    intent.putExtra("answer", AlgorithmQA.tree_left_to_right_answer)
                }
                AlgorithmQA.tree_is_sub -> {
                    intent = Intent(context, QAHorizontalDetailActivity::class.java)
                    intent.putExtra("question", AlgorithmQA.tree_is_sub)
                    intent.putExtra("answer", AlgorithmQA.tree_is_sub_answer)
                }
                AlgorithmQA.fei_bo_na_qi -> {
                    intent = Intent(context, QAHorizontalDetailActivity::class.java)
                    intent.putExtra("question", AlgorithmQA.fei_bo_na_qi)
                    intent.putExtra("answer", AlgorithmQA.fei_bo_na_qi_answer)
                }
                AlgorithmQA.qi_wa_jump_tai_jie -> {
                    intent = Intent(context, QAHorizontalDetailActivity::class.java)
                    intent.putExtra("question", AlgorithmQA.qi_wa_jump_tai_jie)
                    intent.putExtra("answer", AlgorithmQA.qi_wa_jump_tai_jie_answer)
                }
                AlgorithmQA.stock_match_money -> {
                    intent = Intent(context, QAHorizontalDetailActivity::class.java)
                    intent.putExtra("question", AlgorithmQA.stock_match_money)
                    intent.putExtra("answer", AlgorithmQA.stock_match_money_answer)
                }
                AlgorithmQA.binary_search -> {
                    intent = Intent(context, QAHorizontalDetailActivity::class.java)
                    intent.putExtra("question", AlgorithmQA.binary_search)
                    intent.putExtra("answer", AlgorithmQA.binary_search_answer)
                }
                AlgorithmQA.continue_max_sum -> {
                    intent = Intent(context, QAHorizontalDetailActivity::class.java)
                    intent.putExtra("question", AlgorithmQA.continue_max_sum)
                    intent.putExtra("answer", AlgorithmQA.continue_max_sum_answer)
                }
                AlgorithmQA.gift_max_value -> {
                    intent = Intent(context, QAHorizontalDetailActivity::class.java)
                    intent.putExtra("question", AlgorithmQA.gift_max_value)
                    intent.putExtra("answer", AlgorithmQA.gift_max_value_answer)
                }
                AlgorithmQA.num_to_string -> {
                    intent = Intent(context, QAHorizontalDetailActivity::class.java)
                    intent.putExtra("question", AlgorithmQA.num_to_string)
                    intent.putExtra("answer", AlgorithmQA.num_to_string_answer)
                }
                AlgorithmQA.long_no_repeat_string -> {
                    intent = Intent(context, QAHorizontalDetailActivity::class.java)
                    intent.putExtra("question", AlgorithmQA.long_no_repeat_string)
                    intent.putExtra("answer", AlgorithmQA.long_no_repeat_string_answer)
                }
                AlgorithmQA.ji_ou_separate -> {
                    intent = Intent(context, QAHorizontalDetailActivity::class.java)
                    intent.putExtra("question", AlgorithmQA.ji_ou_separate)
                    intent.putExtra("answer", AlgorithmQA.ji_ou_separate_answer)
                }
                AlgorithmQA.sum_is_s -> {
                    intent = Intent(context, QAHorizontalDetailActivity::class.java)
                    intent.putExtra("question", AlgorithmQA.sum_is_s)
                    intent.putExtra("answer", AlgorithmQA.sum_is_s_answer)
                }
                AlgorithmQA.reverse_word -> {
                    intent = Intent(context, QAHorizontalDetailActivity::class.java)
                    intent.putExtra("question", AlgorithmQA.reverse_word)
                    intent.putExtra("answer", AlgorithmQA.reverse_word_answer)
                }
                AlgorithmQA.n_println -> {
                    intent = Intent(context, QAHorizontalDetailActivity::class.java)
                    intent.putExtra("question", AlgorithmQA.n_println)
                    intent.putExtra("answer", AlgorithmQA.n_println_answer)
                }
                AlgorithmQA.binary_number_deep -> {
                    intent = Intent(context, QAHorizontalDetailActivity::class.java)
                    intent.putExtra("question", AlgorithmQA.binary_number_deep)
                    intent.putExtra("answer", AlgorithmQA.binary_number_deep_answer)
                }
                AlgorithmQA.path_sum -> {
                    intent = Intent(context, QAHorizontalDetailActivity::class.java)
                    intent.putExtra("question", AlgorithmQA.path_sum)
                    intent.putExtra("answer", AlgorithmQA.path_sum_answer)
                }
                AlgorithmQA.binary_num_two_node -> {
                    intent = Intent(context, QAHorizontalDetailActivity::class.java)
                    intent.putExtra("question", AlgorithmQA.binary_num_two_node)
                    intent.putExtra("answer", AlgorithmQA.binary_num_two_node_answer)
                }
                AlgorithmQA.binary_num_k_big -> {
                    intent = Intent(context, QAHorizontalDetailActivity::class.java)
                    intent.putExtra("question", AlgorithmQA.binary_num_k_big)
                    intent.putExtra("answer", AlgorithmQA.binary_num_k_big_answer)
                }
                AlgorithmQA.joker_shun_zi -> {
                    intent = Intent(context, QAHorizontalDetailActivity::class.java)
                    intent.putExtra("question", AlgorithmQA.joker_shun_zi)
                    intent.putExtra("answer", AlgorithmQA.joker_shun_zi_answer)
                }
                AlgorithmQA.singleton_three -> {
                    intent = Intent(context, QAHorizontalDetailActivity::class.java)
                    intent.putExtra("question", AlgorithmQA.singleton_three)
                    intent.putExtra("answer", AlgorithmQA.singleton_three_answer)
                }
                AlgorithmQA.one_add_to_n -> {
                    intent = Intent(context, QAHorizontalDetailActivity::class.java)
                    intent.putExtra("question", AlgorithmQA.one_add_to_n)
                    intent.putExtra("answer", AlgorithmQA.one_add_to_n_answer)
                }
                AlgorithmQA.hamming_weight -> {
                    intent = Intent(context, QAHorizontalDetailActivity::class.java)
                    intent.putExtra("question", AlgorithmQA.hamming_weight)
                    intent.putExtra("answer", AlgorithmQA.hamming_weight_answer)
                }
                AlgorithmQA.small_k_num -> {
                    intent = Intent(context, QAHorizontalDetailActivity::class.java)
                    intent.putExtra("question", AlgorithmQA.small_k_num)
                    intent.putExtra("answer", AlgorithmQA.small_k_num_answer)
                }
                AlgorithmQA.quick_sort -> {
                    intent = Intent(context, QAHorizontalDetailActivity::class.java)
                    intent.putExtra("question", AlgorithmQA.quick_sort)
                    intent.putExtra("answer", AlgorithmQA.quick_sort_answer)
                }
                AlgorithmQA.is_balance_tree -> {
                    intent = Intent(context, QAHorizontalDetailActivity::class.java)
                    intent.putExtra("question", AlgorithmQA.is_balance_tree)
                    intent.putExtra("answer", AlgorithmQA.is_balance_tree_answer)
                }
                AlgorithmQA.nearly_ancestor -> {
                    intent = Intent(context, QAHorizontalDetailActivity::class.java)
                    intent.putExtra("question", AlgorithmQA.nearly_ancestor)
                    intent.putExtra("answer", AlgorithmQA.nearly_ancestor_answer)
                }
                AlgorithmQA.search_nearly_ancestor -> {
                    intent = Intent(context, QAHorizontalDetailActivity::class.java)
                    intent.putExtra("question", AlgorithmQA.search_nearly_ancestor)
                    intent.putExtra("answer", AlgorithmQA.search_nearly_ancestor_answer)
                }
                AlgorithmQA.no_add_make_add -> {
                    intent = Intent(context, QAHorizontalDetailActivity::class.java)
                    intent.putExtra("question", AlgorithmQA.no_add_make_add)
                    intent.putExtra("answer", AlgorithmQA.no_add_make_add_answer)
                }
                AlgorithmQA.many_num -> {
                    intent = Intent(context, QAHorizontalDetailActivity::class.java)
                    intent.putExtra("question", AlgorithmQA.many_num)
                    intent.putExtra("answer", AlgorithmQA.many_num_answer)
                }
                AlgorithmQA.task_1, AlgorithmQA.task_2, AlgorithmQA.task_3, AlgorithmQA.task_4, AlgorithmQA.task_5, AlgorithmQA.task_6 -> {
                    intent = Intent(context, QADetailActivity::class.java)
                    intent.putExtra("title", QA.interrupt_interrupted)
                    intent.putExtra("answer", QA.interrupt_interrupted_answer)
                }

            }
            context.startActivity(intent)
        }
    }
}