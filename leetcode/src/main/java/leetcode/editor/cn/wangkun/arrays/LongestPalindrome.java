package leetcode.editor.cn.wangkun.arrays;

/**
 * @Description
 * @Author wangkun
 * @Date 2024/5/26
 */
public class LongestPalindrome {
    public String longestPalindrome(String s) {
        int start = 0;
        int end = 0;
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++){
            dp[i][i] = true;
        }
        for(int i = 1; i < len ;i++){
            for(int j = i - 1 ;j >= 0; j--){
                if (j + 1 == i){
                    dp[j][i] = s.charAt(j) == s.charAt(i);
                } else {
                    dp[j][i] = dp[j + 1][i - 1] &&  s.charAt(j) == s.charAt(i);
                }
                if (dp[j][i]){
                    if (i - j > end - start){
                        start = j;
                        end = i;
                    }
                }
            }
        }
        return s.substring(start,end + 1);
    }

    public static void main(String[] args) {
        LongestPalindrome longestPalindrome = new LongestPalindrome();
        String resp = longestPalindrome.longestPalindrome("bb");
        System.out.println(resp);
    }
}
