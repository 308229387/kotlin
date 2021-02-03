package com.example.kotlin.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin.R


class GridAdapter(private var context: Context) : RecyclerView.Adapter<GridAdapter.GridViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GridViewHolder {
        return GridViewHolder(LayoutInflater.from(context).inflate(R.layout.activity_grid_item, parent, false)); }

    override fun onBindViewHolder(holder: GridViewHolder, position: Int) {
        holder.tv.text = "hello"
        var tempPosition = position+1
        holder.tv.setOnClickListener {
            Toast.makeText(context, "position = $tempPosition", Toast.LENGTH_LONG).show()
        }
    }

    override fun getItemCount(): Int {
        return 30
    }

    inner class GridViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tv: TextView = itemView.findViewById(R.id.textView3)

    }

}