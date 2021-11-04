package com.example.kotlin.data

/**
 * Author: sym
 * Date: 2021/8/10 10:20 PM
 * Describe:
 */
data class QAItemData(var title: String, var image: Int) {
    var tag = 0 //常规状态 1是处理状态
    var lastTime = ""
    var nextTime = ""


    constructor(title: String, image: Int, tag: Int,lastTime:String,nextTime:String) : this(title, image) {
        this.tag = tag
        this.lastTime = lastTime
        this.nextTime = nextTime
    }
}
