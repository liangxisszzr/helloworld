package com.jumpjob.leetcode.linkedlist;

/**
 * @Auther: zuojianhou
 * @Date: 2020/11/7
 * @Description:
 */
public class PrintValueFromEndToStartInLinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(3);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(4);
        solution(head);
    }

    public static boolean solution(ListNode head) {
        boolean i = true;
        while (head != null && i) {
            i = solution(head.next);
            System.out.println(head.val);
        }
        return false;
    }
}
