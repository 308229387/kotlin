package com.example.kotlin.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin.Data
import com.example.kotlin.R
import com.example.kotlin.activity.*
import com.example.kotlin.viewholder.MyViewHolder

class HomeAdapter(private val context: Context, private val dataList: ArrayList<Data>) :
    RecyclerView.Adapter<MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_items, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val hobby = dataList[position]
        holder.setData(hobby, position)
        holder.setOnListener(object : HolderListener {
            override fun delete() {
                dataList.removeAt(position)
                notifyDataSetChanged()
            }

            override fun jump() {
                when (dataList[position].title) {
                    "include实现" -> context.startActivity(Intent(context, IncludeActivity::class.java))
                    "dialogFragment实现" -> context.startActivity(Intent(context, PopWindowActivity::class.java))
                    "键盘高度测量" -> context.startActivity(Intent(context, KeyboardActivity::class.java))
                    "简易ViewPager" -> context.startActivity(Intent(context, ViewPagerActivity::class.java))
                    "Grid样式recyclerview" -> context.startActivity(Intent(context, GridActivity::class.java))
                    "自定义Viewpager" -> context.startActivity(Intent(context, CustomViewpagerActivity::class.java))
                    "从asset中读取资源" -> context.startActivity(Intent(context, ReadAssetsActivity::class.java))
                }

            }
        })
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    interface HolderListener {
        fun delete()
        fun jump()
    }

}