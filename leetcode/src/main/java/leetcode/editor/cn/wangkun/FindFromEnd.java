package leetcode.editor.cn.wangkun;

import org.commen.ListNode;

import java.util.List;

/**
 *
 */
public class FindFromEnd {

    ListNode findFromEnd(ListNode head, int k) {
        ListNode ans  = null;
        ListNode t = head;
        while (t != null) {
            if (k == 0){
                ans = t;
            } else {
                k--;
            }
            t = t.next;
        }
        return ans;
    }


    ListNode deleteFromEnd(ListNode head, int k) {
        ListNode fromEnd = findFromEnd(head, k + 1);
        if(fromEnd != null){
            fromEnd.next = fromEnd.next == null ? null :fromEnd.next.next;
        } else {
            ListNode from = findFromEnd(head, k );
            return from.next;
        }
        return head;
    }

}