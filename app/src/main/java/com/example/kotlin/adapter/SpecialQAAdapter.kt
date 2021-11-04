package com.example.kotlin.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin.R
import com.example.kotlin.activity.QADetailActivity
import com.example.kotlin.data.HawkConfig
import com.example.kotlin.data.QAItemData
import com.example.kotlin.utils.QAAdapterJumpUtil
import com.example.kotlin.viewholder.HolderListener
import com.example.kotlin.viewholder.QAViewHolder
import com.example.kotlin.viewholder.SpecialQAViewHolder
import com.orhanobut.hawk.Hawk

class SpecialQAAdapter(private val context: Context, private val dataList: ArrayList<QAItemData>) :
    RecyclerView.Adapter<SpecialQAViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SpecialQAViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.q_a_list_items, parent, false)
        return SpecialQAViewHolder(view)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: SpecialQAViewHolder, position: Int) {
        val itemData = dataList[position]
        holder.setData(itemData, position)
        holder.setOnListener(object : HolderListener {
            override fun delete() {
                dataList.removeAt(position)
                notifyDataSetChanged()
                Hawk.put(HawkConfig.SpecialQA, dataList)
            }

            override fun jump() {
                QAAdapterJumpUtil.setIntent(context,dataList[position].title)
            }

            override fun longClick() {
                Toast.makeText(context, "长按", Toast.LENGTH_SHORT).show()
            }

        })
    }

}