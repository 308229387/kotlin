package com.learn.algorithm;

/**
 * 问题描述：给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
 * 核心思想：二分查找定义查找的范围 [left,right]，初始查找范围是整个数组。每次取查找范围的中点 mid，
 * 比较nums[mid] 和target 的大小，如果相等则 mid 即为要寻找的下标，如果不相等则根据 nums[mid] 和target 的大小关系将查找范围缩小一半。
 * <p>
 * 时间复杂度：O(logn)，其中 n 是数组的长度。
 * 空间复杂度：O(1)。
 */
public class HalfSearch {
    public int halfSearch(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            int m = (i + j) / 2;
            if (nums[m] > target) {
                j = m - 1;
            } else if (nums[m] < target) {
                i = m + 1;
            } else {
                return m;
            }
        }
        return -1;
    }
}
