package com.jumpjob.LeatCode.linkedlist;

/**
 * 旋转链表
 * @Auther: zuojianhou
 * @Date: 2020/11/7
 * @Description:
 */
public class RotateLinkedList {
    public static void main(String[] args) {

    }
    public static ListNode solution(ListNode head, int k) {
        //空链表或单节点或k==0返回本身（k==0情况需要移动比较次数最多，增加此条判断可减少运行时间提高效率）
        if(head == null || head.next == null || k == 0) {
            return head;
        }
        //pre指向初始头结点
        ListNode pre = head;
        int x = 1;
        while(head.next != null) {
            head = head.next;
            x++;
        }
        //形成循环链表
        head.next = pre;
        //flag指向初始尾节点
        ListNode flag = head;

        //快指针rear
        ListNode rear = pre;
        //确定出口
        x = k % x;
        while(x > 0) {
            rear = rear.next;
            x--;
        }
        while(rear != flag) {
            pre = pre.next;
            rear = rear.next;
        }
        ListNode res = pre.next;
        pre.next = null;
        return res;
    }
}
