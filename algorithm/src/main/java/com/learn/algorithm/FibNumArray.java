package com.learn.algorithm;

/**
 * 核心思想：F(N) = F(N - 1) + F(N - 2)。sum是从3开始的，n=1时，a = 0,b = 1,sum = 1。所以最后的sum是多出2次的，直接返回a即可。
 * 时间复杂度 O(N) ： 计算 f(n) 需循环 n 次，每轮循环内计算操作使用 O(1) 。
 * 空间复杂度 O(1) ： 几个标志变量使用常数大小的额外空间。
 */
public class FibNumArray {
    public int fib(int n){
        int a =0,b = 1,sum;
        for(int i = 0;i<n;i++){
            sum = (a+b)%1000000007;
            a = b;
            b = sum;
        }
        return a;
    }
}
