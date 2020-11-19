package com.jumpjob.leetcode.linkedlist;

import java.util.HashSet;
import java.util.Set;

/**
 * @author zuojianhou
 * @Date: 2020/11/19
 * @Description:
 */
public class IntersectionOfTwoLinkedListsLcci {
    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        b.next = new ListNode(5);
        System.out.println(solution3(a, b));
    }

    public static ListNode solution(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        Set<ListNode> set = new HashSet<>();
        while (headA != null) {
            set.add(headA);
            headA = headA.next;
        }
        while (headB != null) {
            if (set.contains(headB)) {
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }

    public static ListNode solution2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        int sumA = 0, sumB = 0;
        ListNode l1 = headA;
        ListNode l2 = headB;
        while (headA != null) {
            sumA++;
            headA = headA.next;
        }
        while (headB != null) {
            sumB++;
            headB = headB.next;
        }
        int x = Math.abs(sumA - sumB);
        if (x > 0) {
            if (sumA > sumB) {
                while (x > 0) {
                    l1 = l1.next;
                    x--;
                }
            } else {
                while (x > 0) {
                    l2 = l2.next;
                    x--;
                }
            }
        }
        int res = Math.min(sumA, sumB);
        while (res > 0 && l1 != null) {
            if (l1 == l2) {
                return l1;
            }
            l1 = l1.next;
            l2 = l2.next;
            res--;
        }
        return null;
    }

    public static ListNode solution3(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode l1 = headA;
        ListNode l2 = headB;
        while (headA != headB) {
            headA = headA == null ? l2 : headA.next;
            headB = headB == null ? l1 : headB.next;
        }
        return headA;
    }
}
