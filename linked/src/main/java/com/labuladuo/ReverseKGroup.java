package com.labuladuo;

public class ReverseKGroup {
    ListNode reverseKGroup(ListNode head, int k) {
        /**
         * 结束条件
         * 1 节点为null
         * 2 节点不够k个
         */



        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode t = head ;
        for (int i = 1; i < 6; i ++){
            t.next = new ListNode(i);
            t = t.next;
        }
        fastandslow(head.next);
        t = head;
        System.out.println("**********************");
        for (int i = 1; i < 5; i++){
            t.next = new ListNode(i);
            t = t.next;
        }
        fastandslow(head.next);
    }


    public static void fastandslow(ListNode head){
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        System.out.println(slow.val);
        System.out.println(fast == null? "null" : fast.val);
    }
}
