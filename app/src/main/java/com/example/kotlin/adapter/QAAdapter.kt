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

class QAAdapter(private val context: Context, private val dataList: ArrayList<QAItemData>) :
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
                var specialList: ArrayList<QAItemData> = if (Hawk.contains(HawkConfig.SpecialQA)) {
                    Hawk.get(HawkConfig.SpecialQA)
                } else {
                    ArrayList()
                }
                specialList.add(dataList[position])
                Hawk.put(HawkConfig.SpecialQA, specialList)
                Toast.makeText(context, "已保存", Toast.LENGTH_SHORT).show()

                dataList[position].tag = 1 //标记为处理状态
                notifyDataSetChanged()
                Hawk.put(HawkConfig.QA, dataList)
            }

            override fun jump() {
                val intent = Intent(context, QADetailActivity::class.java)
                QAAdapterJumpUtil.setIntent(dataList[position].title, intent)
                context.startActivity(intent)
            }

            override fun longClick() {
                dataList.removeAt(position)
                notifyDataSetChanged()
                Hawk.put(HawkConfig.QA, dataList)
            }

        })
    }

}