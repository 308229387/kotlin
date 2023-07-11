package com.learn.algorithm;

/**
 * 问题描述：给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。返回删除后的链表的头节点。
 * 核心思想：建两个指针，当前指针cur与后指针pre，启动一个while循环，条件就是当前指针不为null，并且当前指针val与目标val不等，
 * 然后当前指针前移，后继指针跟上。遇到相待的cur，把后节点指向前节点的下一位，返回haed就行了
 * <p>
 * 时间复杂度 O(N) ： N 为链表长度，删除操作平均需循环 N/2 次，最差 N 次。
 * 空间复杂度 O(1) ： cur, pre 占用常数大小额外空间。"
 */
public class DeleteNode {
    public ListNode deleteNode(ListNode head, int val) {
        if (head.val == val) {
            return head.next;
        }
        ListNode pre = head, cur = pre.next;
        while (cur != null && cur.val != val) {
            pre = cur;
            cur = cur.next;
        }
        if (cur.val == val) {
            pre.next = cur.next;
        }
        return head;
    }


    public ListNode deleteNode1(ListNode head, int val) {
        if (head.val == val) {
            return head.next;
        }
        ListNode pre = head, cur = pre.next;
        while (cur != null && cur.val != val) {
            pre = cur;
            cur = cur.next;
        }
        if (cur.val == val) {
            pre.next = cur.next;
        }
        return head;

    }


}
