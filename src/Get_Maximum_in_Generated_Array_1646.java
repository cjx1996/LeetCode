/**
 * @ClassName Get_Maximum_in_Generated_Array_1646
 * @Description
 * @Author cjx
 * @Date 2021/8/23 23:25
 * @Version 1.0
 */
public class Get_Maximum_in_Generated_Array_1646 {
    public int getMaximumGenerated(int n) {
        if (n == 0) return 0;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        int max = 1;
        for (int i = 2; i <= n; i++) {
            if (i % 2 == 0) {
                dp[i] = dp[i / 2];
            } else {
                dp[i] = dp[i / 2] + dp[i / 2 + 1];
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

}
