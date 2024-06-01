package com.labuladuo;

public class ReverseN {

    private ListNode p ;
    ListNode reverseN(ListNode head, int n) {
        //结束条件
        if (n == 1){
            ListNode next = head.next;
            p = next;
            return head;
        }
        ListNode tail = reverseN(head.next, n - 1);
        head.next.next = head;
        head.next = p;
        return tail;
    }

    ListNode reverse(ListNode head, int m , int n) {
        //结束条件
        if (m == 1){
            return reverseN(head.next, n);
        }
        return reverse(head.next, m - 1, n);
    }
}
