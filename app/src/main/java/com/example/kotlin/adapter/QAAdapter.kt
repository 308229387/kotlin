package com.example.kotlin.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin.R
import com.example.kotlin.activity.AlgorithmDetailActivity
import com.example.kotlin.activity.QADetailActivity
import com.example.kotlin.data.QA
import com.example.kotlin.data.QAItemData
import com.example.kotlin.viewholder.QAViewHolder

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
                notifyDataSetChanged()
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
                    QA.jvm_gc -> {
                        intent.putExtra("question", QA.jvm_gc)
                        intent.putExtra("answer", QA.jvm_gc_answer)
                    }
                    "合并两个有序链表" -> {
                        intent.putExtra("image", R.drawable.merges_two_ordered_linked_lists)
                    }
                    "合并有序数组" -> {
                        intent.putExtra("image", R.drawable.merge_ordered_array)
                    }
                    "圆圈中最后的数" -> {
                        intent.putExtra("image", R.drawable.the_last_number_in_the_circle)
                    }
                    "如果有环找到入口" -> {
                        intent.putExtra("image", R.drawable.if_a_ring_finds_the_entrance)
                    }
                    "字符串相加" -> {
                        intent.putExtra("image", R.drawable.string_addition)
                    }
                    "广度搜索计算二叉数深度" -> {
                        intent.putExtra("image", R.drawable.breadth_search_calculates_binary_number_depth)
                    }
                    "快速排序" -> {
                        intent.putExtra("image", R.drawable.quick_sort)
                    }
                    "替换空格" -> {
                        intent.putExtra("image", R.drawable.replace_the_blank_space)
                    }
                    "相交链表" -> {
                        intent.putExtra("image", R.drawable.cross_linked_list)
                    }
                    "移除链表元素" -> {
                        intent.putExtra("image", R.drawable.remove_linked_list_elements)
                    }
                    "空间足够合并有序数组" -> {
                        intent.putExtra("image", R.drawable.enough_space_to_merge_ordered_arrays)
                    }
                    "第一个只出现一次的字符" -> {
                        intent.putExtra("image", R.drawable.the_first_character_that_appears_only_once)
                    }
                    "路径总和" -> {
                        intent.putExtra("image", R.drawable.path_to_the_combined)
                    }
                    "连续子数组最大和" -> {
                        intent.putExtra("image", R.drawable.maximum_sum_of_contiguous_subarrays)
                    }
                    "迭代对称二叉数" -> {
                        intent.putExtra("image", R.drawable.lterate_symmetric_binomial_numbers)
                    }
                    "递归对称二叉树" -> {
                        intent.putExtra("image", R.drawable.recursive_symmetric_binary_trees)
                    }
                    "链表中倒数第k个节点" -> {
                        intent.putExtra("image", R.drawable.the_k_penultimate_node_in_the_linked_list)
                    }
                    "链表是否有环" -> {
                        intent.putExtra("image", R.drawable.whether_a_linked_list_has_a_ring)
                    }
                    "青蛙跳台阶" -> {
                        intent.putExtra("image", R.drawable.frog_jump_the_steps)
                    }

                }
                context.startActivity(intent)


            }
        })
    }

}