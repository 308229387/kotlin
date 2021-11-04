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
import com.example.kotlin.utils.ToolsUtil
import com.example.kotlin.viewholder.HolderListener
import com.example.kotlin.viewholder.QAViewHolder
import com.example.kotlin.views.dialog.RememberDialog
import com.orhanobut.hawk.Hawk
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class QAAdapter(private val context: Context, private val dataList: ArrayList<QAItemData>) :
    RecyclerView.Adapter<QAViewHolder>() {
    lateinit var dialog:RememberDialog
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QAViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.q_a_list_items, parent, false)
        return QAViewHolder(view)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }


    override fun onBindViewHolder(holder: QAViewHolder, position: Int) {
        val itemData = dataList[position]
        holder.setData(itemData, position)
        holder.setOnListener(object : HolderListener {
            override fun delete() {
                dialog = RememberDialog(context)
                dialog.setListener(object :RememberDialog.RememberDialogCallBack{
                    override fun result() {
                        var specialList: ArrayList<QAItemData> = if (Hawk.contains(HawkConfig.SpecialQA)) {
                            Hawk.get(HawkConfig.SpecialQA)
                        } else {
                            ArrayList()
                        }

                        val simpleDateFormat = SimpleDateFormat("yyyy年MM月dd日")
                        dataList[position].lastTime = simpleDateFormat.format(Date(System.currentTimeMillis()))
                        dataList[position].tag++ //标记为处理状态

                        when {
                            dataList[position].tag == 1 -> {
                                dataList[position].nextTime = ToolsUtil.beforeAfterDate(1).toString()
                            }
                            dataList[position].tag == 2 -> {
                                dataList[position].nextTime = ToolsUtil.beforeAfterDate(2).toString()
                            }
                            dataList[position].tag == 3 -> {
                                dataList[position].nextTime = ToolsUtil.beforeAfterDate(4).toString()
                            }
                            dataList[position].tag == 4 -> {
                                dataList[position].nextTime = ToolsUtil.beforeAfterDate(7).toString()
                            }
                            dataList[position].tag > 4 -> {
                                dataList[position].nextTime = ToolsUtil.beforeAfterDate((dataList[position].tag-4)*15).toString()
                            }
                        }

                        if (!specialList.contains(dataList[position])) {
                            specialList.add(dataList[position])
                            Toast.makeText(context, "已保存", Toast.LENGTH_SHORT).show()
                        } else {
                            specialList[specialList.indexOf(dataList[position])] = dataList[position]
                            Toast.makeText(context, "已更新", Toast.LENGTH_SHORT).show()
                        }
                        Hawk.put(HawkConfig.SpecialQA, specialList)
                        Hawk.put(HawkConfig.QA, dataList)

                        notifyDataSetChanged()

                        dialog.dismiss()
                    }

                    override fun cancel() {
                       dialog.dismiss()
                    }

                }).show()

            }

            override fun jump() {
                QAAdapterJumpUtil.setIntent(context, dataList[position].title)
            }

            override fun longClick() {
                dataList.removeAt(position)
                notifyDataSetChanged()
                Hawk.put(HawkConfig.QA, dataList)
            }

        })
    }

}