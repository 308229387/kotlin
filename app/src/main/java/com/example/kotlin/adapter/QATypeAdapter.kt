package com.example.kotlin.adapter

import android.content.Context
import android.content.Intent
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin.R
import com.example.kotlin.activity.QListActivity
import com.example.kotlin.viewholder.QAViewHolder
import com.example.kotlin.views.dialog.RememberDialog
import kotlinx.android.synthetic.main.q_a_list_items.view.*

class QATypeAdapter(private val context: Context, private val dataList: ArrayList<String>) :
    RecyclerView.Adapter<QAViewHolder>() {
    lateinit var dialog: RememberDialog
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QAViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.q_a_list_items, parent, false)
        return QAViewHolder(view)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun onBindViewHolder(holder: QAViewHolder, position: Int) {
        holder.itemView.q_a_list_item_text.text = dataList[position]
        holder.itemView.setOnClickListener(View.OnClickListener {
            var intent: Intent = Intent(context, QListActivity::class.java)
            when (dataList[position]) {
                "组件化相关问题" -> {
                    intent.putExtra("intent", "component.json")
                    context.startActivity(intent)
                }
            }
        })

    }

}