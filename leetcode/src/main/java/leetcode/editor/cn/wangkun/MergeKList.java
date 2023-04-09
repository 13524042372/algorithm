package leetcode.editor.cn.wangkun;

import org.commen.ListNode;

import java.util.List;

public class MergeKList {
    ListNode mergeKLists(ListNode[] lists) {
        ListNode ans = new ListNode(Integer.MIN_VALUE);

        for (ListNode list : lists) {
            ans = mergeTwoList(ans,list);
        }
        return ans.next;
    }

    private ListNode mergeTwoList(ListNode l1, ListNode l2){
        ListNode ans = new ListNode(-1);
        ListNode p = ans, p1 = l1, p2 = l2;
        while (l1 != null && l2 != null){
            if(p1.val < p2.val){
                p.next = p1;
                p1 = p1.next;
            } else {
                p.next = p2;
                p2 = p2.next;
            }
            p = p.next;
        }
        p.next = p1 != null? p1 : p2;
        return ans.next;
    }
}
