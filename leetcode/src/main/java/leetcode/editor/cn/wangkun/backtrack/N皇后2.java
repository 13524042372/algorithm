package leetcode.editor.cn.wangkun.backtrack;

import java.util.*;

public class N皇后2 {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        int[] quques = new int[n];
        Arrays.fill(quques, -1);
        Set<Integer> colums = new HashSet<>();
        Set<Integer> t1 = new HashSet<>();
        Set<Integer> t2 = new HashSet<>();
        trackback(n, 0, res, quques, colums, t1, t2);
        return res;
    }

    private void  trackback(int n, int row, List<List<String>> res, int[] queues, Set<Integer> colums, Set<Integer> t1, Set<Integer> t2  ) {
        if (n == row) {//结束条件
            List<String> ans = genans(queues, n);
            res.add(ans);
        } else {
            for (int i = 0; i < n; i++) {
                if (colums.contains(i)) {
                    continue;
                }
                int p1 = row - i;
                if (t1.contains(p1)) {
                    continue;
                }
                int p2 = row + i;
                if (t2.contains(p2)) {
                    continue;
                }
                queues[row] = i;
                colums.add(i);
                t1.add(p1);
                t2.add(p2);

                trackback(n, row +1,res,queues,colums,t1,t2);
                queues[row] = -1;
                colums.remove(i);
                t1.remove(p1);
                t2.remove(p2);
            }
        }
    }

    private List<String> genans(int[] queues, int n) {
        char[] c = new char[n];
        List<String> temp = new ArrayList<>();
        for(int i = 0; i < n; i++){
            Arrays.fill(c, '.');
            c[queues[i]] = 'Q';
            temp.add(new String(c));
        }
        return temp;
    }

    public static void main(String[] args) {
        N皇后2 n = new N皇后2();
        List<List<String>> lists = n.solveNQueens(4);
        System.out.println(lists);


    }
}
