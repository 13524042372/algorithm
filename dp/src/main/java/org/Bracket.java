package org;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 计算合法连续括号的长度
 */
public class Bracket {

    /**
     * dp算法
     *
     * int[] dp
     * 每个元素是以这个元素为结尾的连续括号数量
     * （ ： 0
     *  ）： 两种情况
     *      1 （ ： dp[i - 2] + 2
     *      2  ) :
     *          dp[i - dp[i - 1] - 1] :
     *              (: 2 +  dp[i - 1]
     *              ): 0
     *
     * @param s
     * @return
     *
     *
     */
    public int bracketNum_dp(String s){
        int n = s.length();
        int[] dp = new int[n];
        int max  = 0;
        for(int i = 1 ; i < n ; i ++){
            if(')' == s.charAt(i)){
                if('(' == s.charAt(i - 1)){
                    dp[i] = dp[i > 1 ? i - 2: 0] + 2;
                } else {
                    if(i - dp[i - 1] - 1 >= 0){
                        if('(' == s.charAt(i - dp[i - 1] - 1) ){
                            dp[i] = 2 + dp[i - 1];
                        }
                    }
                }
            }
            max = Math.max(dp[i], max);
        }
        return max;

    }


    /**
     * 一个栈，需要保证栈底元素始终是最后一个不能匹配的坐标
     * @param s
     * @return
     */
    public int bracketNum_stack(String s){
        Deque<Integer> stack = new LinkedList<>();
        stack.push(-1);
        int n = s.length();
        int max = 0;
        for(int i = 0; i < n; i++){
            if ('(' == s.charAt(i)) {
                stack.push(i);
            } else {
                Integer pop = stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    max = Math.max(max, i - pop + 1);
                }
            }
        }
        return max;

    }
    public static void main(String[] args) {
        Bracket bracket = new Bracket();
       // System.out.println(bracket.bracketNum_dp("((())"));
        System.out.println(bracket.bracketNum_stack("()"));

    }

}
