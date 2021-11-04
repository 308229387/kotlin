package com.example.kotlin.viewholder

import android.graphics.Color
import android.os.Build
import android.view.View
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin.data.QAItemData
import kotlinx.android.synthetic.main.list_items.view.*
import kotlinx.android.synthetic.main.list_items.view.list_item_text
import kotlinx.android.synthetic.main.q_a_list_items.view.*

/**
 * Author: sym
 * Date: 2021/4/27 2:50 PM
 * Describe:
 */
class QAViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var currentData: QAItemData? = null
    var currentPosition: Int = 0
    private lateinit var listener: HolderListener

    init {
        itemView.setOnClickListener {
            listener.jump()
        }
        itemView.q_a_list_item_image.setOnClickListener { listener.delete() }
        itemView.q_a_list_item_image.setOnLongClickListener {
            listener.longClick()
            return@setOnLongClickListener true
        }
    }


    fun setData(data: QAItemData, pos: Int) {
        itemView.q_a_list_item_text.text = data?.title
        data?.image?.let { itemView.q_a_list_item_image.setBackgroundResource(it) }
        when {
            data.tag == 1 -> {
                itemView.q_a_list_item_text.setTextColor(Color.parseColor("#FF0000"))
            }
            data.tag == 2 -> {
                itemView.q_a_list_item_text.setTextColor(Color.parseColor("#FF00FF"))
            }
            data.tag == 3 -> {
                itemView.q_a_list_item_text.setTextColor(Color.parseColor("#FFD700"))
            }
            data.tag == 4 -> {
                itemView.q_a_list_item_text.setTextColor(Color.parseColor("#00FFFF"))
            }
            data.tag > 4 -> {
                itemView.q_a_list_item_text.setTextColor(Color.parseColor("#00FF00"))
            }
        }
        if(data.lastTime!=null&&data.lastTime.isNotEmpty()){
            itemView.remember_last_time.text = "last : "+data.lastTime
        }else{
            itemView.remember_last_time.text = "未学习"
        }
        if(data.nextTime!=null&&data.nextTime.isNotEmpty()){
            itemView.remember_next_time.text = "next : "+data.nextTime
        }else{
            itemView.remember_next_time.text = ""
        }
        this.currentData = data
        this.currentPosition = pos
    }

    fun setOnListener(deleteListener: HolderListener) {
        listener = deleteListener
    }
}