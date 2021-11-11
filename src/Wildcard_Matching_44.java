import org.junit.Test;

/**
 * @ClassName Wildcard_Matching_44
 * @Description
 * @Author cjx
 * @Date 2021/8/26 11:33
 * @Version 1.0
 */
public class Wildcard_Matching_44 {
    @Test
    public void test() {
        System.out.println(isMatch("adceb", "*a*b"));
    }

    public boolean isMatch(String s, String p) {
        char[] c1 = s.toCharArray();
        char[] c2 = p.toCharArray();
        int l1 = c1.length, l2 = c2.length;
        boolean[][] dp = new boolean[l1 + 1][l2 + 1];
        dp[0][0] = true;
        for (int i = 1; i <= l2; i++) {
            if (c2[i - 1] == '*') dp[0][i] = dp[0][i - 1];
        }
        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {

                if (c1[i - 1] == c2[j - 1]||c2[j-1]=='?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (c2[j - 1] == '*') {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                } else {
                    dp[i][j] = false;
                }
            }
        }
        return dp[l1][l2];
    }

}
