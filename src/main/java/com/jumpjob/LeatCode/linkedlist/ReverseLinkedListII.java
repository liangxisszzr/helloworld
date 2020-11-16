package com.jumpjob.LeatCode.linkedlist;

/**
 * 反转链表II：翻转 m - n 部分的节点 *
 */
public class ReverseLinkedListII {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode test = head;
        int i = 2;
        while (i < 6) {
            head.next = new ListNode(i);
            head = head.next;
            i++;
        }
        ListNode result1 = solution(test, 2, 4);
//        ListNode result2 = solution2(head);
        while (result1 != null) {
            System.out.println(result1.val);
            result1 = result1.next;
        }
    }

    /**
     * 解法一：将 m - n 部分反转
     * @param head
     * @param m
     * @param n
     * @return
     */
    public static ListNode solution(ListNode head, int m, int n) {
        //设置哨兵，保证从头结点开始和后续各节点开始等效
        ListNode guard = new ListNode(-1);
        ListNode res = guard;
        guard.next = head;
        ListNode pre = null;
        int x = m;
        while(m > 0) {
            //找到开始节点的前一个节点
            if(m == 1) {
                pre = guard;
            }
            guard = guard.next;
            m--;
        }
        ListNode start = guard;
        //找到结束节点
        while(n > x) {
            guard = guard.next;
            n--;
        }
        //分割需要操作部分的节点
        ListNode rear = guard.next;
        guard.next = null;
        //反转m-n部分节点并和之前分割的部分连接
        pre.next = ReverseLinkedList.solution1(start);
        start.next = rear;
        return res.next;
    }

    /**
     * 解法二：迭代法，类似全反转
     * @param head
     * @param m
     * @param n
     * @return
     */
    public static ListNode solution2(ListNode head, int m, int n) {
        //设置哨兵保证操作等效性
        ListNode guard = new ListNode(-1);
        ListNode res = guard;
        guard.next = head;
        int x = m;
        //找到操作头
        while(m > 1) {
            guard = guard.next;
            m--;
        }
        //操作头的前置
        ListNode pre = guard;
        //定义操作头
        ListNode start = pre.next;
        ListNode flag = start;
        ListNode rear = start.next;
        ListNode temp;
        //迭代
        while(n > x) {
            temp = rear.next;
            rear.next = start;
            start = rear;
            pre.next = rear;
            rear = temp;
            n--;
        }
        flag.next = rear;
        return res.next;
    }

    /**
     * 解法三：解法二的优化
     * @param head
     * @param m
     * @param n
     * @return
     */
    public static ListNode solution3(ListNode head, int m, int n) {
        ListNode guard = new ListNode(-1);
        ListNode res = guard;
        guard.next = head;
        while(m > 1) {
            guard = guard.next;
            m--;
            n--;
        }
        ListNode pre = guard;
        ListNode start = pre.next;
        while(n > 1) {
            ListNode temp = start.next;
            start.next = temp.next;
            temp.next = pre.next;
            pre.next = temp;
            n--;
        }
        return res.next;
    }
}
