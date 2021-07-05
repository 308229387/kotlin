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
        AlgorithmItemData("反转链表", R.mipmap.strawberry_pic),
        AlgorithmItemData("Apple", R.mipmap.apple_pic),
        AlgorithmItemData("Banana", R.mipmap.banana_pic),
        AlgorithmItemData("Cherry", R.mipmap.cherry_pic),
        AlgorithmItemData("Grape", R.mipmap.grape_pic),
        AlgorithmItemData("Mango", R.mipmap.mango_pic),
        AlgorithmItemData("Orange", R.mipmap.orange_pic),
        AlgorithmItemData("Pear", R.mipmap.pear_pic),
        AlgorithmItemData("Pineapple", R.mipmap.pineapple_pic),
        AlgorithmItemData("Strawberry", R.mipmap.strawberry_pic),
        AlgorithmItemData("Watermelon", R.mipmap.watermelon_pic),
        AlgorithmItemData("Apple", R.mipmap.apple_pic),
        AlgorithmItemData("Banana", R.mipmap.banana_pic),
        AlgorithmItemData("Cherry", R.mipmap.cherry_pic),
        AlgorithmItemData("Grape", R.mipmap.grape_pic),
        AlgorithmItemData("Mango", R.mipmap.mango_pic),
        AlgorithmItemData("Orange", R.mipmap.orange_pic),
        AlgorithmItemData("Pear", R.mipmap.pear_pic),
        AlgorithmItemData("Pineapple", R.mipmap.pineapple_pic),
        AlgorithmItemData("Strawberry", R.mipmap.strawberry_pic),
        AlgorithmItemData("Watermelon", R.mipmap.watermelon_pic)    )

}