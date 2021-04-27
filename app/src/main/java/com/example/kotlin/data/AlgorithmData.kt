package com.example.kotlin.data

import com.example.kotlin.R

/**
 * Author: sym
 * Date: 2021/4/22 9:53 AM
 * Describe:
 */


data class AlgorithmItemData(var title: String, var image: Int) {
    constructor(image: Int) : this("", image)
}


object AlgorithmData {
    val data = arrayListOf(
        AlgorithmItemData("算法", R.mipmap.strawberry_pic),
        AlgorithmItemData(R.mipmap.watermelon_pic),
    )

}