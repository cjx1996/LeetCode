package All_Problems;

import org.junit.Test;

/**
 * @ClassName DieSimulator_1223
 * @Description
 * @Author cjx
 * @Date 2023/2/10 17:57
 * @Version 1.0
 */
public class DieSimulator_1223 {
    @Test
    public void test() {
        int n = 20;
        int[] rollMax = new int[]{8, 5, 10, 8, 7, 2};
        System.out.println(dieSimulator(n, rollMax));
    }

    static int M = 1000000007;

    public int dieSimulator(int n, int[] rollMax) {
        int m = 6;
        int k = 15;
        int[][][] dp = new int[n + 1][m][k + 1];
        for (int i = 0; i < m; i++) {
            dp[1][i][1] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int l = 1; l <= rollMax[j]; l++) {
                    for (int o = 0; o < 6; o++) {
                        if (j != o) {
                            dp[i + 1][o][1] += dp[i][j][l];
                            dp[i + 1][o][1] %= M;
                        } else if (rollMax[o] >= l + 1) {
                            dp[i + 1][o][l + 1] += dp[i][j][l];
                            dp[i + 1][o][l + 1] %= M;
                        }
                    }
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 1; j <= rollMax[i]; j++) {
                ans += dp[n][i][j];
                ans %= M;
            }
        }
        return ans;
    }

}
