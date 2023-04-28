package com.learn.algorithm;

/**
 * 核心思想：此问题基本与斐波那契数列一至，只是斐波那契是从0开始，而青蛙跳台阶是从1开始，
 * sum初始是从n = 2开始算的，也就是求n级台阶的跳法，要取n-2，也就是a的值
 *
 * 时间复杂度 O(N) ： 计算 f(n) 需循环 n 次，每轮循环内计算操作使用 O(1) 。
 * 空间复杂度 O(1) ： 几个标志变量使用常数大小的额外空间。
 */
public class NumWays {
    public int NumWays(int n){
        int a = 1,b = 1,sum;
        for(int i = 0;i<n;i++){
            sum = (a+b)%1000000007;
            a = b;
            b = sum;
        }
        return a;
    }
}
