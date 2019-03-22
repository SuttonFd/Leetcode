package xin.suttonprog.dp;

/**
 * @author codingZhengsz
 * @since 2019-03-21 22:59
 **/
public class _5LongestPalindromicSubstring {



    /**
     * http://www.cnblogs.com/TenosDoIt/p/3675788.html
     * 解法1：暴力解法，枚举所有的子串，对每一个子串判断是否是回文串，复杂度为O(n^3)
     */

    /**
     * 解法2：对暴力解法进行优化。删除很多重复的判断。
     * 使用动态规划，时间复杂度为O(n^2)，空间复杂度为O(n^2)
     * dp[i][j] 表示子串s[i...j]是否为回文串
     *
     * Runtime: 54 ms, faster than 38.13%
     * Memory Usage: 39.1 MB, less than 24.92%
     */
    public String longestPalindrome_dp(String s) {
        if(s == null || s.length() <= 1) {
            return s;
        }
        int len = s.length();
        int maxLen = 1,begin = 0;
        boolean[][] dp = new boolean[len][len];

        for(int i = 0;i < s.length();i++){
            for(int j = 0;j < i;j++) {
                dp[j][i] = (s.charAt(j) == s.charAt(i) && (i - j < 2 || dp[j + 1][i - 1]));
                if(dp[j][i] && i - j + 1 > maxLen) {
                    maxLen = i - j + 1;
                    begin = j;
                }
            }
            dp[i][i] = true;
        }
        return s.substring(begin,begin + maxLen);
    }

    /**
     * 解法三：以某个元素为中心，分别计算偶数长度的回文最大长度和奇数长度的回文最大长度
     * 时间复杂度为O(n^2)，空间复杂度为O(1)
     *
     * Runtime: 32 ms, faster than 51.92%
     * Memory Usage: 37.7 MB, less than 87.12%
     */
    public String longestPalindrome_SimpleAlgorithm(String s) {
        if(s == null || s.length() <= 1) {
            return s;
        }
        int length = s.length();
        int maxLen = 1,begin = 0;
        for(int i = 1; i < length; i++) {
            int low = i - 1,high = i;
            while(low >= 0 && high < length && s.charAt(low) == s.charAt(high)){
                low --;
                high ++;
            }
            if(high - low - 1 > maxLen) {
                maxLen = high - low - 1;
                begin = low + 1;
            }
            low = i - 1;
            high = i + 1;
            while(low >= 0 && high < length && s.charAt(low) == s.charAt(high)) {
                low --;
                high ++;
            }
            if(high - low - 1 > maxLen){
                maxLen = high - low - 1;
                begin = low + 1;
            }
        }
        return s.substring(begin,begin+maxLen);
    }

    public static void main(String[] args) {
        String s = "";
        System.out.println(new _5LongestPalindromicSubstring().longestPalindrome_SimpleAlgorithm(s));
    }

}
