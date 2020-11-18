package com.jumpjob.leetcode.linkedlist;

/**
 * @Auther: zuojianhou
 * @Date: 2020/11/13
 * @Description:
 */
public class SumListsLcci {
    public static void main(String[] args) {

    }

    public static ListNode solution(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1;
        }
        int carry = 0;
        ListNode res = new ListNode(-1);
        ListNode x = res;
        int sum;
        while (l1 != null && l2 != null) {
            sum = l1.val + l2.val + carry;
            carry = sum / 10;
            res.next = new ListNode(sum % 10);
            l1 = l1.next;
            l2 = l2.next;
            res = res.next;
        }
        while (l1 != null) {
            sum = l1.val + carry;
            carry = sum / 10;
            res.next = new ListNode(sum % 10);
            l1 = l1.next;
            res = res.next;
        }
        while (l2 != null) {
            sum = l2.val + carry;
            carry = sum / 10;
            res.next = new ListNode(sum % 10);
            l2 = l2.next;
            res = res.next;
        }
        if (carry == 1) {
            res.next = new ListNode(1);
        }

        return x.next;
    }
}
