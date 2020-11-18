package com.jumpjob.leetcode.linkedlist;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zuojianhou
 * @Date: 2020/11/18
 * @Description:
 */
public class ConvertBinaryNumberInALinkedListToInteger {
    public static void main(String[] args) {
        int[] a = {1,0,0,1,0};
        ListNode test = SwapNodesInPairs.producer(a);
        System.out.println(solution(test));
    }

    public static int solution(ListNode head) {
        if (head == null) {
            return 0;
        }
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int[] a = list.stream().mapToInt(Integer::intValue).toArray();

        int sum = 0;

        for (int i = 0; i < a.length; i++) {
            if (a[i] == 1) {
                sum += a[i] << (a.length - i - 1);
            }
        }
        return sum;
    }

    public static int solution2(ListNode head) {
        if (head == null) {
            return 0;
        }
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }

        int sum = 0;

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == 1) {
                sum += 1 << (list.size() - i - 1);
            }
        }
        return sum;
    }

    public static int solution3(ListNode head) {
        int sum = 0;

        while (head != null) {
            sum = sum * 2 + head.val;
            head = head.next;
        }

        return sum;
    }
}
