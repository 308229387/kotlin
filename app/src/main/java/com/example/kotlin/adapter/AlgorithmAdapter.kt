package com.example.kotlin.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin.Data
import com.example.kotlin.R
import com.example.kotlin.viewholder.MyViewHolder

class AlgorithmAdapter(private val context: Context, private val dataList: ArrayList<Data>) :
    RecyclerView.Adapter<MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_items, parent, false)
        return MyViewHolder(view)
    }


    override fun getItemCount(): Int {
        return dataList.size
    }

    interface HolderListener {
        fun delete()
        fun jump()
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

    }

}