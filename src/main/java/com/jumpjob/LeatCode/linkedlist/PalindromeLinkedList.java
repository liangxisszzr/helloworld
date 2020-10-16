package com.jumpjob.LeatCode.linkedlist;

import java.util.Stack;

/**
 * 回文链表
 */
public class PalindromeLinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(0, new ListNode(0));
        ListNode p = ReverseLinkedList.solution2(head);
        boolean res = true;
        while(p != null) {
            if(p.val != head.val) {
                res = false;
                break;
            }
            p = p.next;
            head = head.next;
        }
        System.out.println(res);
    }

    public static boolean solution(ListNode head) {
        if(head == null || head.next == null) {
            return true;
        }
        ListNode pre = head;
        ListNode rear = head.next;
        while(rear.next != null && rear.next.next != null) {
            pre = pre.next;
            rear = rear.next.next;
        }
        if(rear.next != null) {
            rear = pre.next.next;
        } else {
            rear = pre.next;
        }
        pre.next = null;
        ListNode res = ReverseLinkedList.solution1(head);
        while(res != null) {
            if(res.val != rear.val) {
                return false;
            }
            res = res.next;
            rear = rear.next;
        }
        return true;
    }

    public static boolean solution2(ListNode head) {
        ListNode res = head;
        Stack<Integer> stack = new Stack<Integer>();
        while(head != null) {
            stack.push(head.val);
            head = head.next;
        }
        while(res != null) {
            int temp = stack.pop();
            if(temp != res.val) {
                return false;
            }
            res = res.next;
        }
        return true;
    }
}
