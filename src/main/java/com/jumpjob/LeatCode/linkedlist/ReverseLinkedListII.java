package com.jumpjob.LeatCode.linkedlist;

/**
 * 反转链表II：翻转 m - n 部分的节点
 */
public class ReverseLinkedListII {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode test = head;
        int i = 2;
        while (i < 6) {
            head.next = new ListNode(i);
            head = head.next;
            i++;
        }
        ListNode result1 = solution(test, 2, 4);
//        ListNode result2 = solution2(head);
        while (result1 != null) {
            System.out.println(result1.val);
            result1 = result1.next;
        }
    }

    public static ListNode solution(ListNode head, int m, int n) {
        ListNode guard = new ListNode(-1);
        ListNode res = guard;
        guard.next = head;
        ListNode pre = null;
        int x = m;
        while(m > 0) {
            if(m == 1) {
                pre = guard;
            }
            guard = guard.next;
            m--;
        }
        ListNode start = guard;
        while(n > x) {
            guard = guard.next;
            n--;
        }
        ListNode rear = guard.next;
        guard.next = null;
        pre.next = ReverseLinkedList.solution1(start);
        start.next = rear;
        return res.next;
    }

    public static ListNode solution2(ListNode head, int m, int n) {
        ListNode guard = new ListNode(-1);
        ListNode res = guard;
        guard.next = head;
        int x = m;
        while(m > 1) {
            guard = guard.next;
            m--;
        }
        ListNode pre = guard;
        ListNode start = pre.next;
        ListNode flag = start;
        ListNode rear = start.next;
        ListNode temp;
        while(n > x) {
            temp = rear.next;
            rear.next = start;
            start = rear;
            pre.next = rear;
            rear = temp;
            n--;
        }
        flag.next = rear;
        return res.next;
    }

    public static ListNode solution3(ListNode head, int m, int n) {
        ListNode guard = new ListNode(-1);
        ListNode res = guard;
        guard.next = head;
        while(m > 1) {
            guard = guard.next;
            m--;
            n--;
        }
        ListNode pre = guard;
        ListNode start = pre.next;
        while(n > 1) {
            ListNode temp = start.next;
            start.next = temp.next;
            temp.next = pre.next;
            pre.next = temp;
            n--;
        }
        return res.next;
    }
}
