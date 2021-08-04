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
                    QA.reverse_list -> {
                        intent = Intent(context, QAHorizontalDetailActivity::class.java)
                        intent.putExtra("question", QA.reverse_list)
                        intent.putExtra("answer", QA.reverse_list_answer)
                    }
                    QA.has_cycle -> {
                        intent = Intent(context, QAHorizontalDetailActivity::class.java)
                        intent.putExtra("question", QA.has_cycle)
                        intent.putExtra("answer", QA.has_cycle_answer)
                    }
                    QA.merge_two_lists -> {
                        intent = Intent(context, QAHorizontalDetailActivity::class.java)
                        intent.putExtra("question", QA.merge_two_lists)
                        intent.putExtra("answer", QA.merge_two_lists_answer)
                    }
                    QA.k_th_from_end -> {
                        intent = Intent(context, QAHorizontalDetailActivity::class.java)
                        intent.putExtra("question", QA.k_th_from_end)
                        intent.putExtra("answer", QA.k_th_from_end_answer)
                    }
                    QA.jump_steps -> {
                        intent = Intent(context, QAHorizontalDetailActivity::class.java)
                        intent.putExtra("question", QA.jump_steps)
                        intent.putExtra("answer", QA.jump_steps_answer)
                    }
                    QA.delete_node -> {
                        intent = Intent(context, QAHorizontalDetailActivity::class.java)
                        intent.putExtra("question", QA.delete_node)
                        intent.putExtra("answer", QA.delete_node_answer)
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