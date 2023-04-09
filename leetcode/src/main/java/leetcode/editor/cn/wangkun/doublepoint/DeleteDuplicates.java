package leetcode.editor.cn.wangkun.doublepoint;

import org.commen.ListNode;

import java.sql.ClientInfoStatus;

public class DeleteDuplicates {
    /**
     * 删除有序链表中的重复元素
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head, fast = head, newHead = head;
        while (fast != null) {
            if(fast.val != slow.val){
                slow.next = fast;
                slow = fast;
            }
            fast = fast.next;
        }
        slow.next = null;
        return newHead;
    }
}
