package com.example.kotlin.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin.Data
import com.example.kotlin.adapter.HomeAdapter
import kotlinx.android.synthetic.main.list_items.view.*

class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var currentData: Data? = null
    var currentPosition: Int = 0
    private lateinit var listener: HomeAdapter.HolderListener

    init {
        itemView.setOnClickListener {
                listener.jump()
        }
        itemView.list_item_image.setOnClickListener { listener.delete() }
    }


    fun setData(data: Data?, pos: Int) {
        /* val title =  itemView.findViewById<TextView>(R.id.tvTitle)
         title.text = hobby?.title */

        itemView.list_item_text.text = data?.title
        data?.image?.let { itemView.list_item_image.setBackgroundResource(it) }

        this.currentData = data
        this.currentPosition = pos
    }

    fun setOnListener(deleteListener: HomeAdapter.HolderListener) {
        listener = deleteListener
    }
}