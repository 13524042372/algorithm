package com.wangkun;

import java.util.ArrayList;
import java.util.List;

public class GenKuohao {
    public List<String> gen(int n){
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        backtrack(res,sb,n,0,0);
        return res;
    }

    private void backtrack(List<String> res, StringBuilder sb, int n,int l, int r){
        if(sb.length() == 2 * n){
            res.add(sb.toString());
            return;
        }

      if(l < n) {
          sb.append('(');
          backtrack(res, sb, n, l + 1,r);
          sb.deleteCharAt(sb.length() - 1);
      }
      if(r < l) {
          sb.append(')');
          backtrack(res, sb, n,l ,r + 1);
          sb.deleteCharAt(sb.length() - 1);
      }
    }

    public static void main(String[] args) {
        GenKuohao genKuohao = new GenKuohao();
        System.out.println(genKuohao.gen(3));
    }

}
