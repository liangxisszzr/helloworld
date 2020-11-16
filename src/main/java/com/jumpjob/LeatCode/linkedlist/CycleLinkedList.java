package com.jumpjob.LeatCode.linkedlist;

import java.util.HashSet;
import java.util.Set;

/**
 * 循环链表
 * @Auther: zuojianhou
 * @Date: 2020/11/7
 * @Description:
 */
public class CycleLinkedList {
    public static void main(String[] args) {

    }

    public static ListNode solution(ListNode head) {
        Set set = new HashSet();
        while (head != null) {
            if (set.contains(head)) {
                return head;
            } else {
                set.add(head);
            }
            head = head.next;
        }
        return null;
    }
}
