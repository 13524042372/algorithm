package leetcode.editor.cn.wangkun.backtrack;

import java.util.*;

public class N皇后 {
    class Solution {
        public List<List<String>> solveNQueens(int n) {
            List<List<String>> solutions = new ArrayList<List<String>>();
            int[] queens = new int[n];
            Arrays.fill(queens, -1);
            Set<Integer> columns = new HashSet<Integer>();
            Set<Integer> diagonals1 = new HashSet<Integer>();
            Set<Integer> diagonals2 = new HashSet<Integer>();
            backtrack(solutions, queens, n, 0, columns, diagonals1, diagonals2);
            return solutions;
        }

        public void backtrack(List<List<String>> solutions, int[] queens, int n, int row, Set<Integer> columns, Set<Integer> diagonals1, Set<Integer> diagonals2) {
            if (row == n) {//结束条件 ，将结果放入结果集中
                List<String> board = generateBoard(queens, n);
                solutions.add(board);
            } else {//开始处理下一层
                for (int i = 0; i < n; i++) {//遍历下一层
                    if (columns.contains(i)) {
                        continue;
                    }
                    int diagonal1 = row - i;
                    if (diagonals1.contains(diagonal1)) {
                        continue;
                    }
                    int diagonal2 = row + i;
                    if (diagonals2.contains(diagonal2)) {
                        continue;
                    }
                    queens[row] = i;//记录当前选择
                    columns.add(i);//记录记录当前选择的限制
                    diagonals1.add(diagonal1);
                    diagonals2.add(diagonal2);
                    backtrack(solutions, queens, n, row + 1, columns, diagonals1, diagonals2);//进行下一层遍历
                    queens[row] = -1;//当前选择的撤销
                    columns.remove(i);
                    diagonals1.remove(diagonal1);
                    diagonals2.remove(diagonal2);
                }
            }
        }

        public List<String> generateBoard(int[] queens, int n) {
            List<String> board = new ArrayList<String>();
            for (int i = 0; i < n; i++) {
                char[] row = new char[n];
                Arrays.fill(row, '.');
                row[queens[i]] = 'Q';
                board.add(new String(row));
            }
            return board;
        }
    }


}
