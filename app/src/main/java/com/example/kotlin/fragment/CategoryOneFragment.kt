package com.example.kotlin.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.kotlin.databinding.FragmentCategoryOneLayoutBinding
import com.example.kotlin.databinding.FragmentHomeOneLayoutBinding

class CategoryOneFragment : Fragment() {
    private lateinit var binding: FragmentCategoryOneLayoutBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentCategoryOneLayoutBinding.inflate(inflater, container, false)
        return binding.root
    }

}
