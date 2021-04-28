package com.example.kotlin.fragment

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.kotlin.databinding.FragmentOneLayoutBinding

/**
 * Author: sym
 * Date: 2021/4/28 5:49 PM
 * Describe:
 */
class FragmentOne : Fragment() {

    private lateinit var binding: FragmentOneLayoutBinding

    @SuppressLint("ResourceAsColor")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentOneLayoutBinding.inflate(inflater, container, false);
        binding.fragmentBackLayout.setBackgroundColor(Color.parseColor("#00ff00"))
        binding.fragmentText.text = "Fragment One"
        binding.fragmentText.setTextColor(Color.parseColor("#ff0000"))
        return binding.root
    }
}