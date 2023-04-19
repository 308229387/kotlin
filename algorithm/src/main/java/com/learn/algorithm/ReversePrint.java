package com.learn.algorithm;

import java.util.Stack;

/**
 * 利用栈先进后出的原理，把节点依次放入栈中，然后再依次从栈中取出，赋值给数组并返回。
 * 时间复杂度：O(n)。正向遍历一遍链表，然后从栈弹出全部节点，等于又反向遍历一遍链表。
 * 空间复杂度：O(n)。额外使用一个栈存储链表中的每个节点。
 */
public class ReversePrint {
    public int[] reversePrint(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }
        int length = stack.size();
        int[] res = new int[length];
        for (int i = 0; i < length; i++) {
            res[i] = stack.pop().val;
        }
        return res;
    }
}
