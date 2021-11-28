package com.example.kotlin.data

import com.example.kotlin.R

/**
 * Author: sym
 * Date: 2021/4/22 9:53 AM
 * Describe:
 */


object AlgorithmData {
    val data = arrayListOf(

        QAItemData("链表", R.mipmap.pineapple_pic,1),
        QAItemData(AlgorithmQA.create_list, R.mipmap.banana_pic),
        QAItemData(AlgorithmQA.has_cycle, R.mipmap.pineapple_pic),
        QAItemData(AlgorithmQA.if_has_circle, R.mipmap.banana_pic),
        QAItemData(AlgorithmQA.cross_list_find_cross, R.mipmap.banana_pic),
        QAItemData(AlgorithmQA.remove_n_from_end, R.mipmap.banana_pic),
        QAItemData(AlgorithmQA.reverse_list, R.mipmap.strawberry_pic),
        QAItemData(AlgorithmQA.reverse_list_iteration, R.mipmap.strawberry_pic),
        QAItemData(AlgorithmQA.hard_list, R.mipmap.strawberry_pic),
        QAItemData(AlgorithmQA.delete_node, R.mipmap.strawberry_pic),
        QAItemData(AlgorithmQA.k_th_from_end, R.mipmap.apple_pic),
        QAItemData(AlgorithmQA.merge_two_lists, R.mipmap.apple_pic),

        QAItemData("队列和栈", R.mipmap.pineapple_pic,1),
        QAItemData(AlgorithmQA.reverse_print_stack, R.mipmap.banana_pic),
        QAItemData(AlgorithmQA.two_stack_for_list, R.mipmap.banana_pic),
        QAItemData(AlgorithmQA.contains_min, R.mipmap.banana_pic),

        QAItemData("字符串", R.mipmap.pineapple_pic,1),
        QAItemData(AlgorithmQA.replace_space, R.mipmap.banana_pic),
        QAItemData(AlgorithmQA.left_rotation_string, R.mipmap.banana_pic),
        QAItemData(AlgorithmQA.string_all_arrangement, R.mipmap.banana_pic),
        QAItemData(AlgorithmQA.once_show_char, R.mipmap.banana_pic),
        QAItemData(AlgorithmQA.reverse_word, R.mipmap.banana_pic),
        QAItemData(AlgorithmQA.singleton_three, R.mipmap.banana_pic),

        QAItemData("数组", R.mipmap.pineapple_pic,1),
        QAItemData(AlgorithmQA.array_repeat_num, R.mipmap.banana_pic),
        QAItemData(AlgorithmQA.arrangement_array_find_num, R.mipmap.banana_pic),
        QAItemData(AlgorithmQA.array_missing_num, R.mipmap.banana_pic),
        QAItemData(AlgorithmQA.rotation_small, R.mipmap.banana_pic),
        QAItemData(AlgorithmQA.two_array_find, R.mipmap.banana_pic),
        QAItemData(AlgorithmQA.binary_search, R.mipmap.banana_pic),
        QAItemData(AlgorithmQA.ji_ou_separate, R.mipmap.banana_pic),
        QAItemData(AlgorithmQA.sum_is_s, R.mipmap.banana_pic),
        QAItemData(AlgorithmQA.n_println, R.mipmap.banana_pic),
        QAItemData(AlgorithmQA.joker_shun_zi, R.mipmap.banana_pic),
        QAItemData(AlgorithmQA.small_k_num, R.mipmap.banana_pic),
        QAItemData(AlgorithmQA.quick_sort, R.mipmap.banana_pic),
        QAItemData(AlgorithmQA.many_num, R.mipmap.banana_pic),

        QAItemData("二叉数", R.mipmap.pineapple_pic,1),
        QAItemData(AlgorithmQA.println_tree_node, R.mipmap.banana_pic),
        QAItemData(AlgorithmQA.level_order, R.mipmap.banana_pic),
        QAItemData(AlgorithmQA.println_tree_node_zhi, R.mipmap.banana_pic),
        QAItemData(AlgorithmQA.tree_is_sub, R.mipmap.banana_pic),
        QAItemData(AlgorithmQA.tree_left_to_right, R.mipmap.banana_pic),
        QAItemData(AlgorithmQA.symmetry_tree, R.mipmap.banana_pic),
        QAItemData(AlgorithmQA.binary_number_deep, R.mipmap.banana_pic),
        QAItemData(AlgorithmQA.is_balance_tree, R.mipmap.banana_pic),
        QAItemData(AlgorithmQA.path_sum, R.mipmap.banana_pic),
        QAItemData(AlgorithmQA.binary_num_two_node, R.mipmap.banana_pic),
        QAItemData(AlgorithmQA.binary_num_k_big, R.mipmap.banana_pic),
        QAItemData(AlgorithmQA.search_nearly_ancestor, R.mipmap.banana_pic),
        QAItemData(AlgorithmQA.nearly_ancestor, R.mipmap.banana_pic),

        QAItemData("动态规划", R.mipmap.pineapple_pic,1),
        QAItemData(AlgorithmQA.fei_bo_na_qi, R.mipmap.banana_pic),
        QAItemData(AlgorithmQA.qi_wa_jump_tai_jie, R.mipmap.banana_pic),
        QAItemData(AlgorithmQA.stock_match_money, R.mipmap.banana_pic),
        QAItemData(AlgorithmQA.continue_max_sum, R.mipmap.banana_pic),
        QAItemData(AlgorithmQA.gift_max_value, R.mipmap.banana_pic),
        QAItemData(AlgorithmQA.num_to_string, R.mipmap.banana_pic),
        QAItemData(AlgorithmQA.long_no_repeat_string, R.mipmap.banana_pic),

        QAItemData("数学", R.mipmap.pineapple_pic,1),
        QAItemData(AlgorithmQA.one_add_to_n, R.mipmap.banana_pic),
        QAItemData(AlgorithmQA.hamming_weight, R.mipmap.banana_pic),
        QAItemData(AlgorithmQA.no_add_make_add, R.mipmap.banana_pic),

        QAItemData("待梳理", R.mipmap.pineapple_pic,1),
        QAItemData(AlgorithmQA.inorder_traversal, R.mipmap.banana_pic),
        QAItemData(AlgorithmQA.recursive_inorder_traversal, R.mipmap.banana_pic),
        QAItemData(AlgorithmQA.post_order_traversal, R.mipmap.banana_pic),
        QAItemData(AlgorithmQA.recursive_post_order_traversal, R.mipmap.banana_pic),
        QAItemData(AlgorithmQA.recursive_level_order, R.mipmap.banana_pic),
        QAItemData(AlgorithmQA.odd_even_list, R.mipmap.banana_pic),
        QAItemData(AlgorithmQA.is_palindrome, R.mipmap.banana_pic),
        QAItemData(AlgorithmQA.add_two_num, R.mipmap.banana_pic),
        QAItemData(AlgorithmQA.pre_order_traversal_recursive, R.mipmap.banana_pic),
        QAItemData(AlgorithmQA.iteration_pre_order, R.mipmap.banana_pic),
        QAItemData(AlgorithmQA.remove_elements, R.mipmap.banana_pic),
        QAItemData(AlgorithmQA.reverse_print_recursive, R.mipmap.banana_pic),
        QAItemData(AlgorithmQA.reverse_print_stack, R.mipmap.banana_pic),
        QAItemData(AlgorithmQA.two_sum, R.mipmap.banana_pic),
        QAItemData(AlgorithmQA.first_show_char, R.mipmap.banana_pic),
        QAItemData(AlgorithmQA.string_add, R.mipmap.banana_pic),
        QAItemData(AlgorithmQA.merge_num, R.mipmap.strawberry_pic),
        QAItemData(AlgorithmQA.merge_num_traverse, R.mipmap.strawberry_pic))
}