package com.example.kotlin.data

/**
 * Author: sym
 * Date: 2021/8/10 10:20 PM
 * Describe:
 */
data class QAItemData(var title: String, var image: Int) {
    var tag = 0 //常规状态 1是处理状态

    constructor(title: String, image: Int, tag: Int) : this(title, image) {
        this.tag = tag
    }
}
