package com.example.kotlin.fragment

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.kotlin.R
import kotlinx.android.synthetic.main.fragment_one_layout.view.*

/**
 * Author: sym
 * Date: 2021/4/28 5:49 PM
 * Describe:
 */
class FragmentTwo : Fragment() {
    @SuppressLint("ResourceAsColor")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_one_layout, null)
        view.setBackgroundColor(Color.parseColor("#000000"))
        view.fragment_text.text = "Fragment Two"
        view.fragment_text.setTextColor(Color.parseColor("#ffffff"))
        return view
    }
}