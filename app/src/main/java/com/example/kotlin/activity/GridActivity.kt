package com.example.kotlin.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.kotlin.R
import com.example.kotlin.adapter.GridAdapter
import kotlinx.android.synthetic.main.activity_grid.*

class GridActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grid)
        grid_view.layoutManager = GridLayoutManager(this, 4)
        grid_view.adapter = GridAdapter(this)
    }
}