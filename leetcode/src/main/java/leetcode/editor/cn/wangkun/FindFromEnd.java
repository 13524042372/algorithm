package leetcode.editor.cn.wangkun;

import org.commen.ListNode;

import java.util.*;

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
    public static void main(String[] args) {
        System.out.println(1 << 15);
        int a = 2;
        for(int i = 1 ; i < 10; i++){
            a *= 2;
            //System.out.println(a + " " + Integer.numberOfLeadingZeros(a) );
            //System.out.println(a + " " + ( (Integer.numberOfLeadingZeros(a)  | 1 << (16 - 1)) << 16));

            System.out.println(a + " " + Integer.toBinaryString( (Integer.numberOfLeadingZeros(a)  | 1 << (16 - 1)) << 16));
        }

        Map<Integer,Integer> map = new HashMap();
        PriorityQueue<int[]> pq =  new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);

       // map.entrySet()
       /* System.out.println(Character.getNumericValue('6'));
        StringBuilder sb = new StringBuilder();
        sb.append('a').append('b').append('c');
        sb.reverse();
        System.out.println(sb.toString());
        PriorityQueue<Integer> pq = new PriorityQueue(Comparator.reverseOrder());
        PriorityQueue<int[]> pq1 = new PriorityQueue<>(Comparator.comparingInt((int[] o) -> o[0]));
        Map<Integer,Integer> map = new HashMap();
        for(Map.Entry e : map.entrySet()){
            Object key = e.getKey();
        }
        pq.poll();
*/
    }

}