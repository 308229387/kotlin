package com.learn.algorithm;

/**
 * 核心思想：创建一前一后双指针，快的先前进K步，然后启动一个while循环，同步前进，当快的到头后，慢的就是倒数第K个节点。
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
}
