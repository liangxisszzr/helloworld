package com.eastnorth.zuojianhou;

/**
 * @author zuojianhou
 * @Date: 2019/11/30
 * @Description:
 *
 * 给出两个非空的链表用来表示两个非负的整数。其中，它们各自的位数是按照逆序的方式存储的，并且它们的每个节点只能存储一位数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字0之外，这两个数都不会以0开头。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class TwoNumberAdd {
    public static void main(String[] args) {
        ListNode a = new ListNode(9);
        a.next = new ListNode(0);
        a.next.next = new ListNode(9);
        ListNode b = new ListNode(2);
        b.next = new ListNode(0);
        b.next.next = new ListNode(2);
        Solution solution = new Solution();
        ListNode result = solution.addTwoNumbers(a, b);
        System.out.println(result);
    }
}

class ListNode {

    int val;

    ListNode next;

    ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}

class Solution {
    ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result;
        int flag = 0;
        if ((l1.val + l2.val) >= 10) {
            int val = (l1.val + l2.val) % 10;
            result = new ListNode(val);
            flag = 1;
        } else {
            result = new ListNode(l1.val + l2.val);
        }
        ListNode parse = result;
        while (l1.next != null && l2.next != null) {
            ListNode r1 = l1.next;
            ListNode r2 = l2.next;
            int val = r1.val + r2.val + flag;
            if (val >= 10) {
                int x = val % 10;
                result.next = new ListNode(x);
                flag = 1;
            } else {
                result.next = new ListNode(val);
                flag = 0;
            }
            result = result.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1.next != null) {
            int val = l1.next.val + flag;
            if (val >= 10) {
                int x = val % 10;
                result.next = new ListNode(x);
                flag = 1;
            } else {
                result.next = new ListNode(val);
                flag = 0;
            }
            result = result.next;
            l1 = l1.next;
        }
        while (l2.next != null) {
            int val = l2.next.val + flag;
            if (val >= 10) {
                int x = val % 10;
                result.next = new ListNode(x);
                flag = 1;
            } else {
                result.next = new ListNode(val);
                flag = 0;
            }
            result = result.next;
            l2 = l2.next;
        }
        while (flag == 1) {
           result.next = new ListNode(1);
           flag = 0;
        }
        return parse;
    }
}