package com.jumpjob.leetcode.linkedlist;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zuojianhou
 * @Date: 2020/11/19
 * @Description:
 */
public class CopyListWithRandomPointer {
    public static void main(String[] args) {

    }

    public static ListNode solution(ListNode head) {
        if (head == null) {
            return null;
        }


        List<ListNode> list = new ArrayList<>();
        List<ListNode> ori = new ArrayList<>();

        ListNode pre = head;

        ListNode first = new ListNode(head.val);

        ListNode cir = first;

        list.add(first);
        ori.add(head);

        while (head.next != null) {
            ListNode listNode = new ListNode(head.next.val);
            list.add(listNode);
            ori.add(head.next);
            first.next = listNode;
            first = first.next;
            head = head.next;
        }

        while (pre != null) {

            cir.random = pre.random == null ? null : list.get(ori.indexOf(pre.random));

            cir = cir.next;

            pre = pre.next;
        }

        return list.get(0);
    }
}
