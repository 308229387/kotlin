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
class FragmentOne : Fragment() {
    @SuppressLint("ResourceAsColor")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_one_layout, null)
        view.setBackgroundColor(Color.parseColor("#00ff00"))
        view.fragment_text.text = "Fragment One"
        view.fragment_text.setTextColor(Color.parseColor("#ff0000"))
        return view
    }
}