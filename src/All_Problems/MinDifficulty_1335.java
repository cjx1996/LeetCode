package All_Problems;

import org.junit.Test;

public class MinDifficulty_1335 {
    @Test
    public void test() {
        int[] jobDifficulty = new int[]{6, 5, 4, 3, 2, 1};
        int d = 2;
        int res = optimize1(jobDifficulty, d);
        System.out.println(res);
    }

    public int minDifficulty(int[] jobDifficulty, int d) {
        int n = jobDifficulty.length;//表示工作任务数量
        if (n < d) return -1;
        int[][] dp = new int[n + 1][d + 1];//d表示工作天数 dp[i][j]表示在j天内完成i项任务的最低难度
        for (int i = 1; i < n + 1; i++) {
            dp[i][1] = Math.max(dp[i - 1][1], jobDifficulty[i - 1]);
        }

        for (int i = 2; i < n + 1; i++) {
            for (int j = 2; j <= i && j <= d; j++) {
                int max = jobDifficulty[i - 1];
                dp[i][j] = dp[i - 1][j - 1] + max;
                for (int k = 2; k + j <= i + 1; k++) {
                    max = Math.max(max, jobDifficulty[i - k]);
                    dp[i][j] = Math.min(dp[i][j], dp[i - k][j - 1] + max);
                }
            }
        }
        return dp[n][d];
    }

    public int optimize1(int[] jobDifficulty, int d) {
        int n = jobDifficulty.length;//表示工作任务数量
        if (n < d) return -1;
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = Math.max(dp[i - 1], jobDifficulty[i - 1]);
        }
        for (int i = 2; i <= d; i++) {
            for (int j = n; j >= i; j--) {
                int max = jobDifficulty[j - 1];
                dp[j] = dp[j - 1] + max;
                for (int k = 2; k + i <= j + 1; k++) {
                    max = Math.max(max, jobDifficulty[j - k]);
                    dp[j] = Math.min(dp[j], dp[j - k] + max);
                }
            }
        }

        return dp[n];
    }

}