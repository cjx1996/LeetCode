import org.junit.Test;

/**
 * @ClassName Guess_Number_Higher_or_Lower_II_375
 * @Description
 * @Author cjx
 * @Date 2021/11/12 12:10
 * @Version 1.0
 */
public class Guess_Number_Higher_or_Lower_II_375 {
    @Test
    public void test() {
        System.out.println(getMoneyAmount(10));
    }

    public int getMoneyAmount(int n) {
        //dp[i][j]=min(X+max(dp[i][X-1],dp[X+1][j])
        int[][] dp = new int[n + 1][n + 1];
        for (int i = n; i >= 1; i--) {
            for (int j = i + 1; j <= n; j++) {
                int global_min = Integer.MAX_VALUE;
                for (int k = i + 1; k < j; k++) {
                    int local_max = k + Math.max(dp[i][k - 1], dp[k + 1][j]);
                    global_min = Math.min(global_min, local_max);
                }
                dp[i][j] = j == i + 1 ? i : global_min;
            }
        }
        return dp[1][n];
    }
}
