package com.learn.algorithm;

/**
 * 问题描述：输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。这个链表的倒数第 3 个节点是值为 4 的节点。
 * 核心思想：创建一前一后双指针，快的先前进K步，然后启动一个while循环，同步前进，当快的到头后，慢的就是倒数第K个节点。
 *
 * 时间复杂度 O(N) ： N 为链表长度；总体看， former 走了 N 步， latter 走了 (N-k)步。
 * 空间复杂度 O(1) ： 双指针 former , latter 使用常数大小的额外空间。
 */
public class GetKthFromEnd {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode former = head, latter = head;
        for (int i = 0; i < k; i++) {
            former = former.next;
        }
        while (former != null) {
            former = former.next;
            latter = latter.next;
        }
        return latter;
    }

    public ListNode getKthFromEnd1(ListNode head,int k){
        ListNode former = head,latter = head;
        for(int i = 0;i<k;i++){
            former = former.next;
        }
        while(former!=null){
            former = former.next;
            latter = latter.next;
        }
        return latter;
    }
}
