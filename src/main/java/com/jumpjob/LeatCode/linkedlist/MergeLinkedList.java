package com.jumpjob.LeatCode.linkedlist;

/**
 * 合并两个有序链表 *
 */
public class MergeLinkedList {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2, new ListNode(4));
        ListNode l2 = new ListNode(2, new ListNode(3));
        ListNode res = solution2(l1, l2);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }

    public static ListNode solution(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(-1);
        ListNode temp = res;
        while(l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                res.next = l1;
                res = res.next;
                l1 = l1.next;
            } else if(l1.val > l2.val) {
                res.next = l2;
                res = res.next;
                l2 = l2.next;
            } else {
                res.next = l1;
                res = res.next;
                l1 = l1.next;
            }
        }
        while(l1 != null) {
            res.next = l1;
            res = res.next;
            l1 = l1.next;
        }
        while(l2 != null) {
            res.next = l2;
            res = res.next;
            l2 = l2.next;
        }
        return temp.next;
    }

    public static ListNode solution1(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(-1);
        ListNode temp = res;
        while(l1 != null && l2 != null) {
            if(l1.val <= l2.val) {
                res.next = l1;
                res = res.next;
                l1 = l1.next;
            } else {
                res.next = l2;
                res = res.next;
                l2 = l2.next;
            }
        }
        res.next = l1 == null ? l2 : l1;
        return temp.next;
    }

    public static ListNode solution2(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val <= l2.val) {
            l1.next = solution2(l1.next, l2);
            return l1;
        } else {
            l2.next = solution2(l2.next, l1);
            return l2;
        }
    }
}
