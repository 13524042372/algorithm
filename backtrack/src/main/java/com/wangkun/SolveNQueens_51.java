package com.wangkun;

import java.util.*;

/**
 * N皇后问题
 * 要列举出所有的解，那么首先要遍历所有可能
 * 每一层就是回溯的一层
 *
 */
public class SolveNQueens_51 {

    public List<List<String>> solveNQueens(int n) {
        boolean[] colums = new boolean[n];
        Set<Integer> s1 = new HashSet<>();
        Set<Integer> s2 = new HashSet<>();
        List<List<String>> res = new ArrayList<>();
        int[] rows = new int[n];
        backtrack(n,0,rows,colums,s1,s2,res);

        return res;
    }
    private void backtrack(int n, int row, int[] rows, boolean[] clums, Set<Integer> s1, Set<Integer> s2, List<List<String>> res){
        if(row == n ){
            res.add(gen(rows));
            return;
        }
        for(int i = 0; i < n; i++){
            if(clums[i]){
                continue;
            }
            int a1 = row + i;
            if(s1.contains(a1)){
                continue;
            }
            int a2 = row - i;
            if(s2.contains(a2)){
                continue;
            }
            clums[i] = true;
            rows[row] = i;
            s1.add(a1);
            s2.add(a2);
            backtrack(n,row + 1,rows,clums,s1,s2,res);
            clums[i] = false;
            rows[row] = -1;
            s1.remove(a1);
            s2.remove(a2);
        }
    }
    private List<String> gen(int[] rows){
        List<String> res  = new ArrayList<>();

        for (int i = 0; i < rows.length; i++) {
            char[] a = new char[rows.length];
            Arrays.fill(a,'.');
           a[rows[i]] = 'Q';
           res.add(new String(a));
        }
        return res;

    }

    public static void main(String[] args) {
        SolveNQueens_51 solveNQueens51 = new SolveNQueens_51();
        List<List<String>> lists = solveNQueens51.solveNQueens(4);
        for(List<String> list : lists){
            System.out.println("");
            for(String l: list){
                System.out.println(l);
            }
        }
    }


}
