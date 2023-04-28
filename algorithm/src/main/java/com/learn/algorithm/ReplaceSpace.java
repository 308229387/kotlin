package com.learn.algorithm;

/**
 * 核心思想：创建个StringBuilder，然后把目标String转换成字节数组charArray，然后通过for循环，
 * 遍历每个字节，如果是空格，就把目标值放入StringBuilder中，否则就把字节放入builder。最后再返回Stringbuilder.toString()
 *
 * 时间复杂度 O(N)： 遍历使用 O(N)，每轮添加（修改）字符操作使用 O(1),
 * 空间复杂度 O(N)： Python 新建的 list 和 Java 新建的 StringBuilder 都使用了线性大小的额外空间。
 */
public class ReplaceSpace {
    public String replaceSpace(String s) {
        char[] c = s.toCharArray();
        StringBuilder res = new StringBuilder("");
        for (char tmp : c) {
            if (tmp == ' ') {
                res.append("%20");
            } else {
                res.append(tmp);
            }
        }
        return res.toString();
    }
}
