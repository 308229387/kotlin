package com.example.kotlin

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class HobbiesAdapter(val context: Context, private val hobbies: ArrayList<Hobby>) :
    RecyclerView.Adapter<MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_items, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val hobby = hobbies[position]
        holder.setData(hobby, position)
        holder.setOnDeleteListener(object : HolderListener {
            override fun delete() {
                hobbies.removeAt(position)
                notifyDataSetChanged()
            }
        })
    }

    override fun getItemCount(): Int {
        return hobbies.size
    }

    interface HolderListener {
        fun delete()
    }

}