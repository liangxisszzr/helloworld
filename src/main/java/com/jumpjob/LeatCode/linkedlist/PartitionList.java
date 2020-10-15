package com.jumpjob.LeatCode.linkedlist;

/**
 * 分隔链表
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
        ListNode result1 = solution(test, 3);
//        ListNode result2 = solution2(head);
        while (result1 != null) {
            System.out.println(result1.val);
            result1 = result1.next;
        }
    }

    public static ListNode solution(ListNode head, int x) {
        ListNode guard = new ListNode(0);
        guard.next = head;
        ListNode res = guard;
        ListNode pre = head;
        ListNode flag = null;
        while(head != null) {
            if(head.val == x) {
                flag = head;
                break;
            }
            head = head.next;
        }
        ListNode temp = flag;
        while(pre != flag) {
            if(pre.val > x) {
                ListNode zz = pre;
                pre = pre.next;
                guard.next = zz.next;
                zz.next = temp.next;
                temp.next = zz;
                temp = temp.next;
            } else {
                guard = guard.next;
                pre = pre.next;
            }
        }
        while(temp.next != null) {
            if(temp.next.val < x) {
                ListNode rear = temp.next;
                temp.next = rear.next;
                guard.next = rear;
                rear.next = flag;
                guard = guard.next;
            } else if (temp.next.val == x) {
                ListNode rear = temp.next;
                temp.next = rear.next;
                rear.next = pre.next;
                pre.next = rear;
                pre = pre.next;
                temp = temp.next;
            } else {
                temp = temp.next;
            }
        }
        return res.next;
    }
}
