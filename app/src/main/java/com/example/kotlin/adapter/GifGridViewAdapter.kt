package com.example.kotlin.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.kotlin.R
import com.example.kotlin.data.Expression
import com.example.kotlin.views.EmotionGifPanelView

class GifGridViewAdapter(emotionList: List<Expression>, page: Int) : BaseAdapter() {
    private var emotionList = ArrayList<Expression>()
    init {
        var start = page * EmotionGifPanelView.ITEM_GRID_NUM
        val end = start + EmotionGifPanelView.ITEM_GRID_NUM
        while (start < emotionList.size && start < end) {
            this.emotionList.add(emotionList[start])
            start++
        }
    }

    override fun getCount(): Int {
        return emotionList.size
    }

    override fun getItem(p0: Int): Any {
        return emotionList[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    @SuppressLint("InflateParams")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View?
        val myHolder: MyHolder?


        if (convertView == null) {
            myHolder = MyHolder()
            view = LayoutInflater.from(parent!!.context).inflate(R.layout.item_gif_gridview, null)
            myHolder.image = view.findViewById(R.id.iv_img)
            myHolder.text = view.findViewById(R.id.gif_text)
            view.tag = myHolder
        } else {
            view = convertView
            myHolder = view.tag as MyHolder
        }
        Glide.with(parent!!.context)
            .setDefaultRequestOptions(RequestOptions().frame(1000000))
            .load(emotionList[position].url)
            .into(myHolder.image)
        myHolder.text.text = emotionList[position].content.replace("#GIF#", "")
        return view!!
    }

    inner class MyHolder {
        lateinit var image: ImageView
        lateinit var text: TextView
    }
}