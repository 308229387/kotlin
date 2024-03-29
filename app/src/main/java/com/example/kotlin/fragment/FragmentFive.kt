package com.example.kotlin.fragment

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kotlin.base.BaseFragment
import com.example.kotlin.databinding.FragmentOneLayoutBinding

/**
 * Author: sym
 * Date: 2021/4/28 5:49 PM
 * Describe:
 */
class FragmentFive : BaseFragment<FragmentOneLayoutBinding>() {

    override fun init(savedInstanceState: Bundle?) {
        super.init(savedInstanceState)
        viewBind.fragmentBackLayout.setBackgroundColor(Color.parseColor("#f00000"))
        viewBind.fragmentText.text = "Fragment Five"
        viewBind.fragmentText.setTextColor(Color.parseColor("#ffff00"))
    }


    override fun createViewBinding(inflater: LayoutInflater, container: ViewGroup?): FragmentOneLayoutBinding {
        return FragmentOneLayoutBinding.inflate(inflater, container, false)
    }

}