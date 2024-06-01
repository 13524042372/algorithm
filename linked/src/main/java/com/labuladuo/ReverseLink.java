package com.labuladuo;

import java.awt.*;

public class ReverseLink {
    /**
     * 反转链表
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode last = reverseList(head.next);//先把后面的翻转
        head.next.next = head;//处理当前的节点
        head.next = null;
        return last;
    }
    public ListNode reverseList_Iterrator(ListNode head){
        if (head == null || head.next == null){
            return head;
        }
        ListNode pre = null, t = head, next = null;
        while (t != null){
            next = t.next;
            t.next = pre;
            pre = t;
            t = next;
        }
        return pre;
    }


}
