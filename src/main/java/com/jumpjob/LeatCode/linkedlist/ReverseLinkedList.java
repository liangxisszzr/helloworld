package com.jumpjob.LeatCode.linkedlist;

/**
 * 翻转链表 *
 */
public class ReverseLinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode test = head;
        int i = 2;
        while (i < 6) {
            head.next = new ListNode(i);
            head = head.next;
            i++;
        }
        ListNode result1 = solution1(test);
//        ListNode result2 = solution2(head);
        while (result1 != null) {
            System.out.println(result1.val);
            result1 = result1.next;
        }

//        while (result2 != null) {
//            System.out.println(result2.val);
//            result2 = result2.next;
//        }
    }

    /**
     * 解法一： 迭代法，头插法
     * @param head
     * @return
     */
    public static ListNode solution1(ListNode head) {
        ListNode pre = null;
        ListNode last = head;
        while (last != null) {
            //依次跟踪下一个节点
            ListNode temp = last.next;
            last.next = pre;
            pre = last;
            last = temp;
        }
        return pre;
    }

    /**
     * 解法二：递归法
     * @param head
     * @return
     */
    public static ListNode solution2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode res = solution2(head.next);
        head.next.next = head;
        head.next = null;
        return res;
    }
}
