package All_Problems;

import org.junit.Test;

import java.util.concurrent.ForkJoinPool;

/**
 * @ClassName K_Inverse_Pairs_Array_629
 * @Description
 * @Author cjx
 * @Date 2021/11/11 16:37
 * @Version 1.0
 */
public class K_Inverse_Pairs_Array_629 {
    @Test
    public void test() {
        System.out.println(kInversePairs(3, 3));
    }

    public int kInversePairs(int n, int k) {
        final int MOD = (int) 1e9 + 7;
        int[][] dp = new int[n + 1][k + 1];
        if (k == 0) return 1;
        if (n == 1) return 0;
        dp[0][0] = 1;
        for (int i = 1; i < n + 1; i++) {
            int sum = 0;
            for (int j = 0; j < k + 1; j++) {
                sum += dp[i - 1][j];
                sum %= MOD;
                if (j >= i) sum -= dp[i - 1][j - i];
                sum = (sum + MOD) % MOD;
                dp[i][j] = sum;
            }
        }
        return dp[n][k];
    }

    public int kInversePairs1(int n, int k) {
        final int MOD = (int) 1e9 + 7;
        if (k == 0) return 1;
        if (n == 1) return 0;
        int[][] dp = new int[n + 1][k + 1];
        dp[2][0] = 1;
        dp[2][1] = 1;
        for (int i = 3; i < n + 1; i++) {
            dp[i][0] = 1;
            for (int j = 1; j <= Math.min(i * (i - 1) / 2, k); j++) {
                dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % MOD;
                if (j >= i) dp[i][j] -= dp[i - 1][j - i];
                dp[i][j] = (dp[i][j] + MOD) % MOD;
            }
        }
        return dp[n][k];
    }
}