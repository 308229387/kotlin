package com.example.kotlin.viewholder

import android.graphics.Color
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin.adapter.AlgorithmAdapter
import com.example.kotlin.data.QAItemData
import kotlinx.android.synthetic.main.list_items.view.*

/**
 * Author: sym
 * Date: 2021/4/27 2:50 PM
 * Describe:
 */
class AlgorithmViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var currentData: QAItemData? = null
    var currentPosition: Int = 0
    private lateinit var listener: AlgorithmAdapter.HolderListener

    init {
        itemView.setOnClickListener {
            listener.jump()
        }
        itemView.list_item_image.setOnClickListener { listener.delete() }
    }


    fun setData(data: QAItemData, pos: Int) {
        /* val title =  itemView.findViewById<TextView>(R.id.tvTitle)
         title.text = hobby?.title */

        itemView.list_item_text.text = (pos+1).toString()+"、"+data.title
        data.image?.let { itemView.list_item_image.setBackgroundResource(it) }

        if(data.tag == 1){
            itemView.list_item_text.setTextColor(Color.GREEN)
        }else{
            itemView.list_item_text.setTextColor(Color.parseColor("#616161"))
        }

        this.currentData = data
        this.currentPosition = pos
    }

    fun setOnListener(deleteListener: AlgorithmAdapter.HolderListener) {
        listener = deleteListener
    }
}