package com.jumpjob.LeatCode.linkedlist;

/**
 * 分隔链表 *
 */
public class PartitionList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode test = head;
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(2);
        ListNode result1 = solution2(test, 3);
//        ListNode result2 = solution2(head);
        while (result1 != null) {
            System.out.println(result1.val);
            result1 = result1.next;
        }
    }

    public static ListNode solution(ListNode head, int x) {
        ListNode rear = new ListNode(1);
        ListNode pre = new ListNode(0);
        ListNode res = pre;
        ListNode last = rear;
        while (head != null) {
            ListNode temp = head.next;
            if (head.val < x) {
                pre.next = head;
                pre = pre.next;
                pre.next = null;
            } else {
                rear.next = head;
                rear = rear.next;
                rear.next = null;
            }
            head = temp;
        }
        pre.next = last.next;
        return res.next;
    }

    public static ListNode solution2(ListNode head, int x) {
        ListNode rear = new ListNode(1);
        ListNode pre = new ListNode(0);
        ListNode res = pre;
        ListNode last = rear;
        while (head != null) {
            if (head.val < x) {
                pre.next = head;
                pre = pre.next;
            } else {
                rear.next = head;
                rear = rear.next;
            }
            head = head.next;
        }
        rear.next = null;
        pre.next = last.next;
        return res.next;
    }
}
