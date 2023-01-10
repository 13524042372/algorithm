package org.hot100;

import org.commen.ListNode;

import java.util.List;

public class AddTwoNumbers_2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2){
        ListNode result = null;
        ListNode r1 = null;
        int t = 0;
        while(l1 != null || l2 != null){
            int a = t;
            if (l1 != null) {
                a += l1.val;
            }
            if (l2 != null) {
                a += l2.val;
            }

            if(result == null){
               r1 =  result = new ListNode(a % 10);
            }else {
                r1.next = new ListNode(a % 10);
                r1 = r1.next;
            }
            t = a / 10;
            l1 = l1.next;
            l2 = l2.next;
        }
        if (t == 1) {
            r1.next = new ListNode(t);
        }
        return result;
    }

    public ListNode addTwoNumbers_2(ListNode l1, ListNode l2){
        ListNode result = null, r1 = null;
        int t = 0;
        while (l1 != null || l2 != null) {
            int a = t;
            if(l1 != null){
                a += l1.val;
            }
            if (l2 != null) {
                a += l2.val;
            }
            if(result == null){
                r1 = result = new ListNode(a % 10);
            }else {
                r1.next = new ListNode(a % 10);
                r1 = r1.next;
            }
            l1 = l1.next;
            l2 = l2.next;
            t = a / 10;
        }
        if (t == 1) {
            r1.next = new ListNode(t);
        }
        return result;


    }

    public static void main(String[] args) {

        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(1);
        ListNode t1 = l1;
        ListNode t2 = l2;
        for (int i = 0; i < 10; i++) {
            t1.next = new ListNode(i);
            t2.next = new ListNode(i);
            t1 = t1.next;
            t2 = t2.next;

        }



        AddTwoNumbers_2 addTwoNumbers2 = new AddTwoNumbers_2();
        ListNode listNode = addTwoNumbers2.addTwoNumbers_2(l1, l2);
        while(listNode != null){
            System.out.print(listNode.val + ",");
            listNode = listNode.next;
        }

    }

}
