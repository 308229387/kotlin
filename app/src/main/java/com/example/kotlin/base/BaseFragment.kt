package com.example.kotlin.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

/**
 * Author: sym
 * Date: 2021/4/28 8:46 PM
 * Describe:
 */
abstract class BaseFragment<VB : ViewBinding> : Fragment() {
    lateinit var viewBind:VB

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewBind = createViewBinding(inflater,container)
        init(savedInstanceState)
        return viewBind.root
    }

    abstract fun createViewBinding(inflater: LayoutInflater, container: ViewGroup?): VB

    protected open fun init(savedInstanceState: Bundle?) {}

}