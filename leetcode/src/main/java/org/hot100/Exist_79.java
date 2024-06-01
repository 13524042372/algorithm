package org.hot100;


public class Exist_79 {
    boolean exist = false;

    public boolean exist(char[][] board, String word) {
        int m =  board.length;
        int n = board[0].length;
        boolean[][] a = new boolean[m][n];
        StringBuilder s = new StringBuilder();
        for(int i = 0; i < m ; i++){
            for( int j = 0; j < n ; j++){
                exist(board,word,i,j,a,s);
            }
        }
        return exist;
    }

    private void exist(char[][] board, String word,int m, int n,boolean[][] a,StringBuilder sb){
        if (exist){
            return;
        }
        if (sb.length() > word.length()){
            return;
        }
        if (m < 0 || m >= board.length|| n < 0|| n >= board[0].length){
            return;
        }

        a[m][n] = true;
        sb.append(board[m][n]);
        if(sb.toString().equals(word)){
            exist = true;
            return;
        }

        exist(board,word,m - 1,n,a,sb);
        exist(board,word,m + 1,n,a,sb);
        exist(board,word,m,n - 1,a,sb);
        exist(board,word,m,n + 1,a,sb);
        a[m][n] = false;
        sb.deleteCharAt(sb.length() - 1);
    }


}
