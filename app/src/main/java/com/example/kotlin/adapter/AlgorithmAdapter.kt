package com.example.kotlin.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin.R
import com.example.kotlin.data.HawkConfig
import com.example.kotlin.data.QAItemData
import com.example.kotlin.utils.QAAdapterJumpUtil
import com.example.kotlin.viewholder.AlgorithmViewHolder
import com.orhanobut.hawk.Hawk

class AlgorithmAdapter(private val context: Context, private val dataList: ArrayList<QAItemData>) :
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
                var specialList: ArrayList<QAItemData> = if (Hawk.contains(HawkConfig.SpecialQA)) {
                    Hawk.get(HawkConfig.SpecialQA)
                } else {
                    ArrayList()
                }

                if (!specialList.contains(dataList[position])) {
                    specialList.add(dataList[position])
                    Hawk.put(HawkConfig.SpecialQA, specialList)
                    Toast.makeText(context, "已保存", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(context, "已在关注列表", Toast.LENGTH_SHORT).show()
                }



                dataList[position].tag = 1 //标记为处理状态
                notifyDataSetChanged()
                Hawk.put(HawkConfig.AlgorithmQA, dataList)
            }

            override fun jump() {
                QAAdapterJumpUtil.setIntent(context, dataList[position].title)
            }
        })
    }

}