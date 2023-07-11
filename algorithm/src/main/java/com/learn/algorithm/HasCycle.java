package com.learn.algorithm;

/**
 * 问题描述：给你一个链表的头节点 head ，判断链表中是否有环。
 * 核心思想：判断链表是否有环，核心思想是创建一快一慢两个指针，
 * 慢的走1步，快的走2步，然后在while循环中两个一起向前走，如果两节点相待了，那就说明有环，否则就没有。
 *
 *  时间复杂度：O(N)，其中 N 是链表中的节点数。
 *  空间复杂度：O(1)。我们只使用了两个指针的额外空间。
 */
public class HasCycle {
    public boolean hasCycle(ListNode head){
        ListNode slow = head,fast = slow;
        while(true){
            if(fast == null||fast.next == null){
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return true;
            }
        }
    }


    public boolean hasCycle1(ListNode head){
        ListNode slow = head,fast = slow;
        while(true){
            if(fast == null||fast.next == null){
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return true;
            }
        }
    }
}
