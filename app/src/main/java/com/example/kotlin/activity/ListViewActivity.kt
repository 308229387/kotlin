package com.example.kotlin.activity

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlin.R
import com.example.kotlin.adapter.ListAdapter
import kotlinx.android.synthetic.main.activity_list_view.*

/**
 * Author: sym
 * Date: 2021/6/27 3:28 PM
 * Describe:
 */
class ListViewActivity : AppCompatActivity(), AdapterView.OnItemClickListener {
    private var data = ArrayList<String>()
    private var adapter = ListAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)
        base_list_view.adapter = adapter
        base_list_view.onItemClickListener = this
        data.add("我是第1列")
        data.add("我是第2列")
        data.add("我是第3列")
        data.add("我是第4列")
        data.add("我是第5列")
        data.add("我是第6列")
        data.add("我是第7列")
        data.add("我是第8列")
        data.add("我是第9列")
        data.add("我是第10列")
        data.add("我是第11列")

        adapter.setData(data)
    }

    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        Toast.makeText(this@ListViewActivity, "数据内容为：" + data[position], Toast.LENGTH_SHORT).show()
    }

}