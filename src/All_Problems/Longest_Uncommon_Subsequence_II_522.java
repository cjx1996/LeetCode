package All_Problems;

import org.junit.Test;

/**
 * @ClassName Longest_Uncommon_Subsequence_II_522
 * @Description lcs最长公共子序列问题
 * @Author cjx
 * @Date 2022/6/27 9:57
 * @Version 1.0
 */
public class Longest_Uncommon_Subsequence_II_522 {
    @Test
    public void test() {
        String[] strs = new String[]{"aaa", "aaa", "aa"};
        System.out.println(findLUSlength(strs));
    }

    public int findLUSlength(String[] strs) {
        int ans = -1;
        int n = strs.length;
        for (int i = 0; i < n; i++) {
            if (strs[i].length() <= ans) continue;
            boolean ok = true;
            for (int j = 0; j < n && ok; j++) {
                if (i == j) continue;
                if (check(strs[i], strs[j])) ok = false;
            }
            if (ok) ans = strs[i].length();
        }
        return ans;
    }

    /**
     * 检查s1是否是s2的子序列
     *
     * @param s1
     * @param s2
     * @return
     */
    boolean check(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        if (m > n) return false;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                dp[i][j] = s1.charAt(i - 1) == s2.charAt(j - 1) ? dp[i - 1][j - 1] + 1 : dp[i - 1][j - 1];
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j]);
                dp[i][j] = Math.max(dp[i][j - 1], dp[i][j]);
                if (dp[i][j] == m) return true;
            }
        }
        return false;
    }


}
