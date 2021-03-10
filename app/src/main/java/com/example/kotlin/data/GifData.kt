package com.example.kotlin.data

/**
 * FileName: GifGroup
 * Author: sym
 * Date: 2021/3/1 11:03 AM
 */
data class GifData(
    val code: Int,
    val expressions: List<Expression>,
    val status: String
)

data class Expression(
    val content: String,
    val display: Boolean,
    val url: String
)