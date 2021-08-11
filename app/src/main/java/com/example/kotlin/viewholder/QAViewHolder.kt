package com.example.kotlin.viewholder

import android.graphics.Color
import android.os.Build
import android.view.View
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin.data.QAItemData
import kotlinx.android.synthetic.main.list_items.view.*

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
        itemView.list_item_image.setOnClickListener { listener.delete() }
        itemView.list_item_image.setOnLongClickListener {
            listener.longClick()
            return@setOnLongClickListener true
        }


    }


    fun setData(data: QAItemData, pos: Int) {
        /* val title =  itemView.findViewById<TextView>(R.id.tvTitle)
         title.text = hobby?.title */

        itemView.list_item_text.text = data?.title
        data?.image?.let { itemView.list_item_image.setBackgroundResource(it) }
        if(data.tag == 1){
            itemView.list_item_text.setTextColor(Color.GREEN)
        }else{
            itemView.list_item_text.setTextColor(Color.parseColor("#616161"))
        }
        this.currentData = data
        this.currentPosition = pos
    }

    fun setOnListener(deleteListener: HolderListener) {
        listener = deleteListener
    }
}