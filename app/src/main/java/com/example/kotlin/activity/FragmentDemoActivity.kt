package com.example.kotlin.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlin.R
import com.example.kotlin.databinding.ActivityFragmentLayoutBinding
import com.example.kotlin.fragment.FragmentOne
import com.example.kotlin.fragment.FragmentThree
import com.example.kotlin.fragment.FragmentTwo

class FragmentDemoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFragmentLayoutBinding
    private lateinit var fragmentOne: FragmentOne
    private lateinit var fragmentTwo: FragmentTwo
    private lateinit var fragmentThree: FragmentThree
    private var tag = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFragmentLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        fragmentOne = FragmentOne()
        fragmentTwo = FragmentTwo()
        fragmentThree = FragmentThree()
        binding.modifyFragmentButton.setOnClickListener {
            when (tag) {
                0 -> {
                    supportFragmentManager.beginTransaction().replace(R.id.fragment_layout, fragmentOne).commit()
                    tag = 1
                }
                1 -> {
                    supportFragmentManager.beginTransaction().replace(R.id.fragment_layout, fragmentTwo).commit()
                    tag = 2
                }
                2 -> {
                    supportFragmentManager.beginTransaction().replace(R.id.fragment_layout, fragmentThree).commit()
                    tag = 0
                }
            }
        }
    }
}