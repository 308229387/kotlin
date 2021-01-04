package com.example.kotlin

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list_items.view.*

class HobbiesAdapter(val context: Context, private val hobbies: List<Hobby>) :
    RecyclerView.Adapter<HobbiesAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_items, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val hobby = hobbies[position]
        holder.setData(hobby, position)
    }

    override fun getItemCount(): Int {
        return hobbies.size
    }


    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var currentHobby: Hobby? = null
        var currentPosition: Int = 0


        init {
            itemView.setOnClickListener {
                Toast.makeText(context, currentHobby!!.title, Toast.LENGTH_SHORT)
                    .show()
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
    }
}