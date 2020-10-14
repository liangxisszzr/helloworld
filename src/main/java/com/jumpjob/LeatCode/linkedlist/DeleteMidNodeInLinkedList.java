package com.jumpjob.LeatCode.linkedlist;

/**
 * 删除中间节点,仅可访问删除节点
 */
public class DeleteMidNodeInLinkedList {
    public static void main(String[] args) {

    }

    /**
     * 狸猫换太子巧解：要求删除节点，并未提及必须删除实质节点，利用值替换实现删除
     * @param mid
     */
    public static void solution(ListNode mid) {
        mid.val = mid.next.val;
        mid.next = mid.next.next;
    }
}
