package com.jumpjob.leetcode.linkedlist;

/**
 * 翻转K个一组的链表
 * @author zuojianhou
 * @Date: 2020/11/18
 * @Description:
 */
public class ReverseNodesInKGroup {
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5};
        ListNode test = SwapNodesInPairs.producer(a);
        solution(test, 3);
    }

    public static ListNode solution(ListNode head, int k) {
        if (head == null || head.next == null || k == 1) {
            return head;
        }
        ListNode guard = new ListNode(-1);
        ListNode res = guard;
        guard.next = head;

        boolean ok = available(head, k);

        while (ok) {
            ListNode temp = reverse(head, guard, k);
            guard = temp;
            head = temp.next;
            ok = available(head, k);
        }

        return res.next;
    }

    public static boolean available(ListNode head, int k) {
        if (head == null) {
            return false;
        }
        while (k > 1) {
            head = head.next;
            if (head == null) {
                return false;
            }
            k--;
        }
        return true;
    }

    public static ListNode reverse(ListNode head, ListNode guard, int k) {
        while (k > 1) {
            ListNode rear = head.next;
            head.next = rear.next;
            rear.next = guard.next;
            guard.next = rear;
            k--;
        }
        return head;
    }
}
