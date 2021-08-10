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
        AlgorithmItemData(AlgorithmQA.reverse_print_recursive, R.mipmap.strawberry_pic),
        AlgorithmItemData(AlgorithmQA.reverse_print_stack, R.mipmap.strawberry_pic),
        AlgorithmItemData(AlgorithmQA.replace_space, R.mipmap.strawberry_pic),
        AlgorithmItemData(AlgorithmQA.two_sum, R.mipmap.strawberry_pic),
        AlgorithmItemData(AlgorithmQA.first_show_char, R.mipmap.strawberry_pic),
        AlgorithmItemData(AlgorithmQA.string_add, R.mipmap.strawberry_pic),
        AlgorithmItemData(AlgorithmQA.merge_num, R.mipmap.strawberry_pic),
        AlgorithmItemData(AlgorithmQA.merge_num_traverse, R.mipmap.strawberry_pic),
        AlgorithmItemData(AlgorithmQA.delete_node, R.mipmap.strawberry_pic),
        AlgorithmItemData(AlgorithmQA.reverse_list, R.mipmap.strawberry_pic),
        AlgorithmItemData(AlgorithmQA.has_cycle, R.mipmap.pineapple_pic),
        AlgorithmItemData(AlgorithmQA.merge_two_lists, R.mipmap.apple_pic),
        AlgorithmItemData(AlgorithmQA.k_th_from_end, R.mipmap.apple_pic),
        AlgorithmItemData(AlgorithmQA.jump_steps, R.mipmap.apple_pic))

}