package com.example.kotlin.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.kotlin.databinding.FragmentMineOneLayoutBinding

class MineOneFragment : Fragment() {
    private lateinit var binding: FragmentMineOneLayoutBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentMineOneLayoutBinding.inflate(inflater, container, false);
        return binding.root
    }

}
