package com.example.kotlin.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin.R
import com.example.kotlin.activity.AlgorithmDetailActivity
import com.example.kotlin.activity.QAHorizontalDetailActivity
import com.example.kotlin.data.AlgorithmItemData
import com.example.kotlin.data.QA
import com.example.kotlin.viewholder.AlgorithmViewHolder

class AlgorithmAdapter(private val context: Context, private val dataList: ArrayList<AlgorithmItemData>) :
    RecyclerView.Adapter<AlgorithmViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlgorithmViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_items, parent, false)
        return AlgorithmViewHolder(view)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    interface HolderListener {
        fun delete()
        fun jump()
    }

    override fun onBindViewHolder(holder: AlgorithmViewHolder, position: Int) {
        val itemData = dataList[position]
        holder.setData(itemData, position)
        holder.setOnListener(object : HolderListener {
            override fun delete() {
                dataList.removeAt(position)
                notifyDataSetChanged()
            }

            override fun jump() {
                var intent = Intent(context, AlgorithmDetailActivity::class.java)
                when (dataList[position].title) {
                    "反转链表" -> {
                        intent = Intent(context, QAHorizontalDetailActivity::class.java)
                        intent.putExtra("question", QA.reverse_list)
                        intent.putExtra("answer", QA.reverse_list_answer)
                    }
                    "链表是否有环" -> {
                        intent = Intent(context, QAHorizontalDetailActivity::class.java)
                        intent.putExtra("question", QA.has_cycle)
                        intent.putExtra("answer", QA.has_cycle_answer)
                    }
                    QA.merge_two_lists -> {
                        intent = Intent(context, QAHorizontalDetailActivity::class.java)
                        intent.putExtra("question", QA.merge_two_lists)
                        intent.putExtra("answer", QA.merge_two_lists_answer)
                    }
                    "遍历对称二叉数" -> {
                        intent.putExtra("image", R.drawable.ergodically_symmetric_binary_numbers)
                    }
                    "查找重复的数" -> {
                        intent.putExtra("image", R.drawable.find_duplicate_numbers)
                    }
                    "创建链表" -> {
                        intent.putExtra("image", R.drawable.create_list)
                    }
                    "两个栈实现队列1" -> {
                        intent.putExtra("image", R.drawable.two_stacks_implement_queues_a)
                    }
                    "两个栈实现队列2" -> {
                        intent.putExtra("image", R.drawable.two_stacks_implement_queues_b)
                    }
                    "二分查找" -> {
                        intent.putExtra("image", R.drawable.binary_search)
                    }
                    "二叉数前中后序" -> {
                        intent.putExtra("image", R.drawable.binary_number_front_middle_back_order)
                    }
                    "二叉数的层序遍历" -> {
                        intent.putExtra("image", R.drawable.sequential_traversal_of_binary_numbers)
                    }
                    "从尾到头打印链表" -> {
                        intent.putExtra("image", R.drawable.print_the_list_from_end_to_begin)
                    }
                    "删除倒数第N个节点" -> {
                        intent.putExtra("image", R.drawable.delete_the_n_penultimate_node)
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
                    "青蛙跳台阶" -> {
                        intent.putExtra("image", R.drawable.frog_jump_the_steps)
                    }

                }
                context.startActivity(intent)


            }
        })
    }

}