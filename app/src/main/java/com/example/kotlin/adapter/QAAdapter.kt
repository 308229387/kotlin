package com.example.kotlin.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin.R
import com.example.kotlin.activity.AlgorithmDetailActivity
import com.example.kotlin.activity.QADetailActivity
import com.example.kotlin.data.HawkConfig
import com.example.kotlin.data.QA
import com.example.kotlin.data.QAItemData
import com.example.kotlin.viewholder.QAViewHolder
import com.orhanobut.hawk.Hawk

class QAAdapter(private val context: Context, private val dataList: ArrayList<QAItemData>) :
    RecyclerView.Adapter<QAViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QAViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_items, parent, false)
        return QAViewHolder(view)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    interface HolderListener {
        fun delete()
        fun jump()
    }

    override fun onBindViewHolder(holder: QAViewHolder, position: Int) {
        val itemData = dataList[position]
        holder.setData(itemData, position)
        holder.setOnListener(object : HolderListener {
            override fun delete() {
                dataList.removeAt(position)
                notifyDataSetChanged()
                Hawk.put(HawkConfig.QA, dataList)
            }

            override fun jump() {
                var intent = Intent(context, QADetailActivity::class.java)
                when (dataList[position].question) {
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
                    QA.fragment_life -> {
                        intent = Intent(context, AlgorithmDetailActivity::class.java)
                        intent.putExtra("image", R.drawable.fragment_life_image)
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


                }
                context.startActivity(intent)


            }
        })
    }

}