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
import com.orhanobut.hawk.Hawk

class SpecialQAAdapter(private val context: Context, private val dataList: ArrayList<QAItemData>) :
    RecyclerView.Adapter<QAViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QAViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_items, parent, false)
        return QAViewHolder(view)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: QAViewHolder, position: Int) {
        val itemData = dataList[position]
        holder.setData(itemData, position)
        holder.setOnListener(object : HolderListener {
            override fun delete() {
                dataList.removeAt(position)
                notifyDataSetChanged()
                Hawk.put(HawkConfig.SpecialQA, dataList)
            }

            override fun jump() {
                val intent = Intent(context, QADetailActivity::class.java)
                QAAdapterJumpUtil.setIntent(dataList[position].title, intent)
                context.startActivity(intent)
            }

            override fun longClick() {
                Toast.makeText(context, "长按", Toast.LENGTH_SHORT).show()
            }

        })
    }

}