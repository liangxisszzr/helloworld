package com.jumpjob.LeatCode.linkedlist;

import java.util.Stack;

/**
 * 两数相加II
 * @Auther: zuojianhou
 * @Date: 2020/11/7
 * @Description:
 */
public class TwoNumberAddII {
    public static void main(String[] args) {

    }

    /**
     * 未改动原链表
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode solution(ListNode l1, ListNode l2) {
        Stack<Integer> m = new Stack<>();
        Stack<Integer> n = new Stack<>();
        while (l1 != null) {
            m.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            n.push(l2.val);
            l2 = l2.next;
        }
        ListNode res = null;
        int carry = 0;
        int sum;
        while (!m.empty() || !n.empty()) {
            if (m.empty()) {
                sum = n.pop() + carry;
            } else if (n.empty()) {
                sum = m.pop() + carry;
            } else {
                sum = m.pop() + n.pop() + carry;
            }
            ListNode temp = new ListNode(sum % 10);
            temp.next = res;
            res = temp;
            carry = sum / 10;
        }
        if (carry == 1) {
            ListNode temp = new ListNode(1);
            temp.next = res;
            res = temp;
        }
        return res;
    }

    public static ListNode solution2(ListNode l1, ListNode l2) {
        ListNode a = ReverseLinkedList.solution1(l1);
        ListNode b = ReverseLinkedList.solution1(l2);
        ListNode res = null;
        int carry = 0;
        int sum;
        while (a != null || b != null) {
            if (a == null) {
                sum = b.val + carry;
                b = b.next;
            } else if (b == null) {
                sum = a.val + carry;
                a = a.next;
            } else {
                sum = a.val + b.val + carry;
                a = a.next;
                b = b.next;
            }
            ListNode temp = new ListNode(sum % 10);
            temp.next = res;
            res = temp;
            carry = sum / 10;
        }
        if (carry == 1) {
            ListNode temp = new ListNode(1);
            temp.next = res;
            res = temp;
        }
        return res;
    }
}
