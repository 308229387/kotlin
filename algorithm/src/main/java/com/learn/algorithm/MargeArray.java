package com.learn.algorithm;

/**
 * 问题描述：给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
 * 核心思想：先得到双数组之和的辅助下标k，然后再把数组1与数组2的的最后一位元素一一比较，从大到小，
 * 从后到前，反向放入nums1中。当有一组放完后，再把剩余一组，通过for循环逐个放入。
 *
 * 时间复杂度：O(M + N)\n
 * 空间复杂度：O(1)
 */
public class MargeArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int k = m + n - 1;
        while (m > 0 && n > 0) {
            if (nums1[m - 1] < nums2[n - 1]) {
                nums1[k] = nums2[n - 1];
                k--;
                n--;
            } else {
                nums1[k] = nums1[m - 1];
                k--;
                m--;
            }
        }
        for (int i = 0; i < n; i++) {//肯定有一方还有值，直接启动个for循环，把数组2的值搬过来，如果数组2没值，就跳过了
            nums1[i] = nums2[i];
        }
    }

    public void merge1(int[] nums1,int m, int[] nums2,int n){
        int k = m+n-1;
        while(m>0&&n>0){
            if(nums1[m-1]<nums2[n-1]){
                nums1[k] = nums2[n-1];
                k--;n--;
            }else{
                nums1[k] = nums1[m-1];
                k--;m--;
            }
        }
        for(int i = 0;i<n;i++){
            nums1[i] = nums2[i];
        }
    }
}
