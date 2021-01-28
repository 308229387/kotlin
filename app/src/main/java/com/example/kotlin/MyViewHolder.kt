package com.example.kotlin

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list_items.view.*

class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var currentHobby: Hobby? = null
    var currentPosition: Int = 0
    private lateinit var listener: HobbiesAdapter.HolderListener

    init {
        itemView.setOnClickListener {
            listener.delete()
        }
    }


    fun setData(hobby: Hobby?, pos: Int) {
        /* val title =  itemView.findViewById<TextView>(R.id.tvTitle)
         title.text = hobby?.title */

        itemView.tvTitle.text = hobby?.title
        hobby?.image?.let { itemView.imgShare.setBackgroundResource(it) }

        this.currentHobby = hobby
        this.currentPosition = pos
    }

    fun setOnDeleteListener(deleteListener: HobbiesAdapter.HolderListener) {
        listener = deleteListener
    }
}