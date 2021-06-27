package com.example.kotlin.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin.R
import com.example.kotlin.activity.*
import com.example.kotlin.data.Data
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
                    "算法" -> context.startActivity(Intent(context, AlgorithmListActivity::class.java))
                    "聊天交互框" -> context.startActivity(Intent(context, CommentTestActivity::class.java))
                    "include实现" -> context.startActivity(Intent(context, IncludeActivity::class.java))
                    "Fragment实现" -> context.startActivity(Intent(context, FragmentDemoActivity::class.java))
                    "键盘高度测量" -> context.startActivity(Intent(context, KeyboardActivity::class.java))
                    "简易ViewPager" -> context.startActivity(Intent(context, ViewPagerActivity::class.java))
                    "Grid样式recyclerview" -> context.startActivity(Intent(context, GridActivity::class.java))
                    "自定义Viewpager" -> context.startActivity(Intent(context, CustomViewpagerActivity::class.java))
                    "从asset中读取资源" -> context.startActivity(Intent(context, ReadAssetsActivity::class.java))
                    "bottomsheetDialog" -> context.startActivity(Intent(context, BottomDialogActivity::class.java))
                    "获取imei" -> context.startActivity(Intent(context, ImeiActivity::class.java))
                    "获取权限" -> context.startActivity(Intent(context, PermissionActivity::class.java))
                    "获取权限手机号" -> context.startActivity(Intent(context, GetPhoneNumActivity::class.java))
                    "首页Tab" -> context.startActivity(Intent(context, HomeTabActivity::class.java))
                    "TopBar" -> context.startActivity(Intent(context, TopBarActivity::class.java))
                    "基础列表listview" -> context.startActivity(Intent(context, ListViewActivity::class.java))
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