package org.hot100;

public class LongestPalindrome_3 {

    /**
     * 暴力解法
     * 找到所有的子串，判断是不是回文串
     *
     * @param s
     * @return
     */
    public static String longestPalindrome_baoli(String s) {
        //存储最长子串
        String str = "";
        //存储最长长度
        int longest = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length() + 1; j++) {//找到所有的子串
                String str1 = s.substring(i, j);
                if (isPalindromes(str1) && str1.length() > longest) {
                    str = str1;
                    longest = str.length();
                }
            }
        }
        return str;
    }

    public static boolean isPalindromes(String str) {
        if (str.length() == 1) {
            return true;
        }
        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 暴力求解优化版
     *
     * @param s
     * @return
     */
    public static String longestPalindrome_baoli_1(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }
        //最大长度
        int maxLen = 0;
        //开始的下标
        int begin = 0;
        //存储s字符数组，就可以不用每次截取字符串比较了。
        char[] chars = s.toCharArray();
        for (int i = 0; i < len - 1; i++) {
            //子串长度比maxLen小，那么他不可能是最长回文子串了。
            for (int j = i + maxLen; j < len; j++) {
                if (isPalindromes(chars, i, j) && j - i + 1 > maxLen) {
                    //重新记录最大长度和开始下标
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        //这种第二个参数为开始下标+长度 ，比 结束下标+1 更简单更容易。
        return s.substring(begin, begin + maxLen);
    }

    //chars[left]至chars[right]是否是回文串，包括左右下标
    public static boolean isPalindromes(char[] chars, int left, int right) {
        while (left <= right) {
            //不是回文串
            if (chars[left] != chars[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    //动态规划
    public static String longestPalindromeDp(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }
        //最大长度
        int maxLen = 1;
        int begin = 0;
        //存储是否是回文串
        boolean[][] dp = new boolean[len][len];
        char[] chars = s.toCharArray();
        //单个字符一定是回文
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        for (int j = 1; j < len; j++) {
            for (int i = 0; i < j; i++) {
                if (chars[i] != chars[j]) {
                    dp[i][j] = false;
                } else {
                    //长度为2或3是，肯定是回文。即除去chars[i]和 chars[j]后，只要1个或0个字符。防止出现例如 i=2 j=3情况下 查看dp[3][2]。
                    if (j - i < 2) {
                        dp[i][j] = true;
                    } else {
                        //排除头尾元素后，是否是回文串
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, maxLen + begin);
    }

    //中心扩展
    public static String longestPalindrome_expandAroundCenter(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }
        char[] chars = s.toCharArray();
        //最大长度
        int maxLen = 0;
        int begin = 0;
        //char[0] chars[len-1] 时是第一个和最后一个元素,无法左扩展和无法右扩展，排除这俩个元素。
        for (int i = 0; i < len - 1; i++) {
            //回文子串长度为奇数，初始子串为一个字符charAt(i)
            int oddLen = expandAroundCenter(chars, i, i);
            //回文子串长度为偶数，初始子串为charAt(i)和charAt(i+1)，i<len-1，i+1不会下标越界
            int evenLen = expandAroundCenter(chars, i, i + 1);
            //取奇偶情况下的当前最长回文子串
            int curMaxLen = Math.max(oddLen, evenLen);
            //比当前存储最长回文子串长，重新存储
            if (curMaxLen > maxLen) {
                // 当回文子串为偶数，一定是i右边多一个字符。
                // 所以左边长度要减1
                // 回文字符串奇数时 int/2取整  -1也不影响结果
                maxLen = curMaxLen;
                begin = i - (maxLen - 1) / 2;
            }
            //优化
            if ((len - i - 2) * 2 + 1 < maxLen) {//已经到最后一个元素了
                return s.substring(begin, begin + maxLen);
            }
        }
        return s.substring(begin, begin + maxLen);
    }

    //计算下标为i时，最长回文子串的长度
    public static int expandAroundCenter(char[] chars, int left, int right) {
        while (left >= 0 && right < chars.length && chars[left] == chars[right]) {
            //是回文串，向外扩展
            left--;
            right++;
        }
        return right - left - 1;
    }
}
