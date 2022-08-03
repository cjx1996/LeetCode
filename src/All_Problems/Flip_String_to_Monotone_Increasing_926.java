package All_Problems;

import org.junit.Test;

/**
 * @ClassName Flip_String_to_Monotone_Increasing_926
 * @Description
 * @Author cjx
 * @Date 2022/6/11 22:18
 * @Version 1.0
 */
public class Flip_String_to_Monotone_Increasing_926 {
    @Test
    public void test() {
        String s = "010110";
        System.out.println(minFlipMonoIncr(s));
    }

    public int minFlipMonoIncr(String s) {
        char[] cs = s.toCharArray();
        int n = s.length();
        int[][] dp = new int[n][2];
        dp[0][0] = cs[0] == '0' ? 0 : 1;
        dp[0][1] = cs[0] == '1' ? 0 : 1;
        for (int i = 1; i < n; i++) {
            int isOne = cs[i] == '1' ? 1 : 0;
            dp[i][0] = dp[i - 1][0] + isOne;
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][1]) + 1 - isOne;
        }
        return Math.min(dp[n - 1][0], dp[n - 1][1]);
    }

}
