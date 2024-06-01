package org.hot100;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis_22 {
    /**
     * 1 right < left
     * 2 left <= n
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        int left = 0, right = 0;
        StringBuilder sb = new StringBuilder();
        List<String> ans = new ArrayList<>();
        generateParenthesis(n, left,right,sb,ans);
        return ans;
    }

    private void generateParenthesis(int n, int left, int right, StringBuilder sb, List<String> ans){
        if(left > n || right > left){
            return;
        }
        if (right == n){
            ans.add(sb.toString());
            return;
        }

        left++;
        sb.append('(');
        generateParenthesis(n,left,right,sb,ans);
        sb.deleteCharAt(sb.length() - 1);
        left--;

        right++;
        sb.append(')');
        generateParenthesis(n,left,right,sb,ans);
        sb.deleteCharAt(sb.length() - 1);
        right--;

    }

    public static void main(String[] args) {
        GenerateParenthesis_22 generateParenthesis22 = new GenerateParenthesis_22();
        List<String> strings = generateParenthesis22.generateParenthesis(3);
        System.out.println(strings);
    }
}
