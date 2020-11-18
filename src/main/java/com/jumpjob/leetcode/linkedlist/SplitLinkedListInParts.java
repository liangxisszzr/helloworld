package com.jumpjob.leetcode.linkedlist;

/**
 * @author zuojianhou
 * @Date: 2020/11/18
 * @Description:
 */
public class SplitLinkedListInParts {
    public static void main(String[] args) {

    }

    public static ListNode[] solution(ListNode head, int k) {
        int sum = 0;
        ListNode flag = head;
        while (head != null) {
            sum++;
            head = head.next;
        }
        ListNode[] res = new ListNode[k];
        ListNode temp = null;
        int i = 0;
        if (sum <= k) {
            while (i < k) {
                if (flag != null) {
                    temp = flag.next;
                    res[i] = flag;
                    flag.next = null;
                    flag = temp;
                } else {
                    res[i] = null;
                }
                i++;
            }
        } else {
            int num = sum / k;
            int largeNum = sum % k;
            int count = 0;
            while (i < largeNum) {
                res[count] = flag;
                int x = 0;
                while (x < num) {
                    flag = flag.next;
                    x++;
                }
                ListNode rear = flag.next;
                flag.next = null;
                flag = rear;
                count++;
                i++;
            }
            while(flag != null) {
                res[count] = flag;
                int y = 0;
                while (y < num - 1) {
                    flag = flag.next;
                    y++;
                }
                ListNode pre = flag.next;
                flag.next = null;
                flag = pre;
                count++;
            }
        }
        return res;
    }
}
