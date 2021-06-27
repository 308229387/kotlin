package com.example.kotlin.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.kotlin.R

/**
 * Author: sym
 * Date: 2021/6/27 3:35 PM
 * Describe:
 */
class ListAdapter : BaseAdapter() {
    private lateinit var data: ArrayList<String>

    override fun getCount(): Int {
        return if (::data.isInitialized) {
            data.size
        } else {
            0
        }
    }

    override fun getItem(position: Int): Any {
        return position
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View?

        var holder: ViewHolder
        if (convertView == null) {
            holder = ViewHolder()
            view = LayoutInflater.from(parent!!.context).inflate(R.layout.list_view_item, null)
            holder.title_TextView = view.findViewById(R.id.list_view_item_text)
            view.tag = holder

        } else {
            view = convertView
            holder = view.tag as ViewHolder
        }
        //填充数据
        holder.title_TextView!!.text = data[position]

        return view!!
    }

    internal class ViewHolder {
        var title_TextView: TextView? = null
    }

    fun setData(data: ArrayList<String>) {
        this.data = data
        notifyDataSetChanged()
    }
}