package com.jumpjob.leetcode.linkedlist;

/**
 * @Auther: zuojianhou
 * @Date: 2020/11/13
 * @Description:
 */
public class RemoveDuplicatesFromSortedListii {
    public static void main(String[] args) {
        int[] a = {1,1};
        ListNode test = SwapNodesInPairs.producer(a);
        ListNode res = deleteDuplicates(test);
        System.out.println(res);
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        return null;
    }
}
