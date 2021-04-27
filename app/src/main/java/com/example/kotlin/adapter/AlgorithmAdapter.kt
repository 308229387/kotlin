package com.example.kotlin.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin.R
import com.example.kotlin.activity.*
import com.example.kotlin.data.AlgorithmItemData
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
                when (dataList[position].title) {
                    "算法" -> context.startActivity(Intent(context, AlgorithmDetailActivity::class.java))
                }

            }
        })
    }

}