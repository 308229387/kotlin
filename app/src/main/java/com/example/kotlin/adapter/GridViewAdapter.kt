package com.example.kotlin.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import com.example.kotlin.R
import com.example.kotlin.data.Emotion
import com.example.kotlin.utils.EmotionHelper
import com.example.kotlin.views.EmotionPanelView

class GridViewAdapter(emotionList: ArrayList<Emotion>, page: Int, private var dir: String) : BaseAdapter() {
    private var emotionList = ArrayList<Emotion>()

    init {
        var start = page * EmotionPanelView.ITEM_GRID_NUM
        val end = start + EmotionPanelView.ITEM_GRID_NUM
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
            view = LayoutInflater.from(parent!!.context).inflate(R.layout.item_gridview, null)
            myHolder.image = view.findViewById(R.id.iv_img)
            view.tag = myHolder
        } else {
            view = convertView
            myHolder = view.tag as MyHolder
        }

        when {
            emotionList[position].getRes().equals("delete") -> {
                myHolder.image.setBackgroundResource(R.mipmap.delete_emotion)
            }
            emotionList[position].getRes().equals("null") -> {
            }
            else -> {
                if (emotionList[position].getRes() != null) {
                    val path = dir + "/" + emotionList[position].getRes()
                    myHolder.image.setImageDrawable(EmotionHelper.getDrawable(path))
                    emotionList[position].path = path
                }
            }
        }
        return view!!
    }

    inner class MyHolder {
        lateinit var image: ImageView
    }
}