package leetcode.editor.cn.wangkun;

import org.commen.ListNode;

import java.util.List;

public class MergeTwoLists {

    ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode(-1); //虚拟头结点

        ListNode t = ans;
        while(l1 != null && l2 != null){
            if(l1.val <= l2.val) {
                t.next = l1;
                l1 = l1.next;
            }else{
                t.next = l2;
                l2 = l2.next;
            }
            t = t.next;
        }
        t.next = l1 != null ? l1 : l2;
        return ans.next;
    }

    ListNode mergeTwoLists_1(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode(-1);
        ListNode p = ans , p1 = l1, p2 = l2;
        while (p1 != null && p2 != null ){
            if( p1.val <= p2.val){
                p.next = p1;
                p1 = p1.next;
            } else {
                p.next = p2;
                p2 = p2.next;
            }
            p = p.next;
        }

        p.next = p1 != null ? p1 : p2;
        return ans.next;
    }

    ListNode mergeTwoLists_2(ListNode l1, ListNode l2){
        ListNode ans = new ListNode(-1);
        ListNode p = ans, p1 = l1, p2 = l2;
        while (p1 != null && p2 != null){
            if(p1.val <= p2.val){
                p.next = p1;
                p1 = p1.next;
            }else {
                p.next = p2;
                p2 = p2.next;
            }
            p = p.next;
        }
        p.next = p1 != null? p1 : p2;
        return ans.next;
    }
/*
    public static void main(String[] args) {
        ListNode l1 = new ListNode(-1);
        ListNode s = l1;
        for(int i = 0; i < 20;){
            s.next = new ListNode(i);;
            s = s.next;
            i += 2;
        }
        ListNode l2 = new ListNode(-1);
        s = l2;
        for(int i = 1; i < 20;){
            s.next = new ListNode(i);
            s = s.next;
            i += 2;
        }
        MergeTwoLists mergeTwoLists = new MergeTwoLists();
        ListNode listNode = mergeTwoLists.mergeTwoLists(l1, l2);

        while ( listNode != null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }*/
}
