package com.learn.algorithm;

/**
 * 问题描述：定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 * 时间复杂度：O(n)其中n是链表的长度。需要遍历链表一次。
 * 空间复杂度：O(1)反转指针而已
 */
public class ReverseList {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {  //先做一层判断，触发终止时结束递归，并返回最后的节点head
            return head;
        }
        ListNode cur = reverseList(head.next); //然后创建一个要返回的节点，递归调用reverseList，传入下一个head.next，这里假设传1-2-3-4-5，那这一步会递归的执行5回
        head.next.next = head;  //比如4的next 是5，那4的next的next等于4，意思是让5指向4
        head.next = null;   //现在head已经是4了，5已经指向4了，要把4指向5的置null，变成单向指
        return cur;   //返回首节点cur
    }

    public ListNode reverseList1(ListNode head){
        if(head == null||head.next == null){
            return head;
        }
        ListNode cur = reverseList1(head.next);
        head.next.next = head;
        head.next = null;
        return cur;
    }

}

