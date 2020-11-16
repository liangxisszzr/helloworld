package com.jumpjob.LeatCode.linkedlist;

/**
 * 交换链表中的节点 *
 */
public class SwapNodesInPairs {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(3);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(4);
        ListNode res = solution2(head);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }

    public static ListNode producer(int[] a) {
        if (a == null || a.length == 0) {
            return null;
        }
        ListNode res = new ListNode(-1);
        ListNode flag = res;
        for (int value : a) {
            flag.next = new ListNode(value);
            flag = flag.next;
        }

        return res.next;
    }

    /**
     * 解法一：
     *      递归：思路同反转链表相同
     * @param head
     * @return
     */
    public static ListNode solution1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode temp = solution1(head.next.next);
        ListNode res = head.next;
        head.next.next = head;
        head.next = temp;
        return res;
    }

    /**
     * 解法二：
     *      迭代法：考虑到除第一对节点无需处理头结点，与后续节点对不形成统一规律，加入哨兵以使规律一致
     *             后续操作和反转链表类似
     * @param head
     * @return
     */
    public static ListNode solution2(ListNode head) {
        ListNode guard = new ListNode(-1);
        guard.next = head;
        ListNode first = guard;

        ListNode pre = head;
        while (pre != null && pre.next != null) {
            ListNode rear = pre.next;

            //swap
            pre.next = rear.next;
            guard.next = rear;
            rear.next = pre;

            //iteration
            guard = pre;
            pre = pre.next;
        }
        return first.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
