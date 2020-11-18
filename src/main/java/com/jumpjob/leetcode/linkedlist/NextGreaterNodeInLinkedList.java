package com.jumpjob.leetcode.linkedlist;

/**
 * 下一个更大的节点
 * @Auther: zuojianhou
 * @Date: 2020/11/8
 * @Description:
 */
public class NextGreaterNodeInLinkedList {
    public static void main(String[] args) {

    }

    public static int[] solution(ListNode head) {
        if (head == null) {
            return new int[0];
        }
        ListNode pre = head;
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        int[] res = new int[count];
        count = 0;
        while (pre.next != null) {
            ListNode rear = pre.next;
            while (rear != null) {
                if (rear.val > pre.val) {
                    res[count] = rear.val;
                    count++;
                    break;
                } else {
                    rear = rear.next;
                }
            }
            if (rear == null) {
                res[count] = 0;
                count++;
            }
            pre = pre.next;
        }
        res[res.length - 1] = 0;
        return res;
    }
}
