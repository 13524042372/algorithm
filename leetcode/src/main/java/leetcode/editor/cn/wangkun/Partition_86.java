package leetcode.editor.cn.wangkun;

import org.commen.ListNode;

public class Partition_86 {
    public ListNode partition(ListNode head, int x) {
        ListNode l = new ListNode(-1);
        ListNode g = new ListNode(-1);
        ListNode  p1 = l, p2 = g;
        ListNode h = head;
        while (h != null){
            if(h.val <= x){
                p1.next = h;
                p1 = p1.next;
            }else {
                p2.next = h;
                p2 = p2.next;
            }
            h = h.next;
        }
        p1.next = null;
        p2.next = null;
        if (l.next == null){
            return g.next;
        }else {
            p1.next = g.next;
            return l.next;
        }
    }
}
