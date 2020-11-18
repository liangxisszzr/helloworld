package com.jumpjob.leetcode.linkedlist;

/**
 * 返回倒数第K个节点 *
 */
public class LinkedListKthNodeFromEnd {
    public static void main(String[] args) {

    }

    /**
     * 解法一：
     *      暴力解法：反转链表，顺序查找第K个节点
     * @param head
     * @param k
     * @return
     */
    public static int solution1(ListNode head, int k) {
        ListNode pre = head;
        ListNode rear = null;
        while (pre != null) {
            ListNode temp = pre.next;
            pre.next = rear;
            rear = pre;
            pre = temp;
        }
        int i = 1;
        while (i < k) {
            pre = pre.next;
            i++;
        }
        return pre.val;
    }

    /**
     * 解法二：快慢指针
     * @param head
     * @param k
     * @return
     */
    public static int solution2(ListNode head, int k) {
        ListNode pre = head;
        ListNode rear = head;
        while (k > 1) {
            pre = pre.next;
            k--;
        }
        while (pre.next != null) {
            rear = rear.next;
            pre = pre.next;
        }
        return rear.val;
    }
}
