package com.example.kotlin.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin.R
import com.example.kotlin.activity.*
import com.example.kotlin.data.AlgorithmData
import com.example.kotlin.data.Data
import com.example.kotlin.data.HawkConfig
import com.example.kotlin.data.QAData
import com.example.kotlin.viewholder.MyViewHolder
import com.orhanobut.hawk.Hawk

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
                    "全部问答" -> context.startActivity(Intent(context, MainListActivity::class.java))
                    "问答" -> context.startActivity(Intent(context, QAListActivity::class.java))
                    "分类问答" -> context.startActivity(Intent(context, QListActivity::class.java))
                    "待解决问答" -> context.startActivity(Intent(context, SpecialQAListActivity::class.java))
                    "算法" -> context.startActivity(Intent(context, AlgorithmListActivity::class.java))
                    "通用功能" -> context.startActivity(Intent(context, CommonActivity::class.java))
                    "json数组转对象" -> context.startActivity(Intent(context, CommonActivity::class.java))
                    "仿京东搜索" -> context.startActivity(Intent(context, JDSearchActivity::class.java))
                    "聊天交互框" -> context.startActivity(Intent(context, CommentTestActivity::class.java))
                    "include实现、html文字" -> context.startActivity(Intent(context, IncludeActivity::class.java))
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
                    "addView" -> context.startActivity(Intent(context, AddViewActivity::class.java))
                    "圆角、圆头像" -> context.startActivity(Intent(context, RoundImageActivity::class.java))
                    "Glide图片显示" -> context.startActivity(Intent(context, GlideShowImageActivity::class.java))
                    "重复定时任务" -> context.startActivity(Intent(context, ScheduleTaskActivity::class.java))
                    "RxJava学习" -> context.startActivity(Intent(context, RxJavaLeanActivity::class.java))
                    "权限管理" -> context.startActivity(Intent(context, PermissionActivity::class.java))
                    "触摸滑动事件" -> context.startActivity(Intent(context, TouchEventActivity::class.java))
                    "上拉加载、下拉刷新" -> context.startActivity(Intent(context, LoadMoreActivity::class.java))
                    "选择文件、本地json读取" -> context.startActivity(Intent(context, PickViewActivity::class.java))
                    "折叠列表" -> context.startActivity(Intent(context, ExpandableListActivity::class.java))
                    "恢复问答" -> {
                        Toast.makeText(context, "已刷新", Toast.LENGTH_SHORT).show()
                        Hawk.put(HawkConfig.QA, QAData.data)
                    }
                    "恢复算法" -> {
                        Toast.makeText(context, "已刷新", Toast.LENGTH_SHORT).show()
                        Hawk.put(HawkConfig.AlgorithmQA, AlgorithmData.data)
                    }

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