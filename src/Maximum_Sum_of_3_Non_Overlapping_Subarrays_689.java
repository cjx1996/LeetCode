import org.junit.Test;

/**
 * @ClassName Maximum_Sum_of_3_Non_Overlapping_Subarrays_689
 * @Description
 * @Author cjx
 * @Date 2021/12/8 21:42
 * @Version 1.0
 */
public class Maximum_Sum_of_3_Non_Overlapping_Subarrays_689 {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int len = nums.length;
        //构建前缀和数组 sum[i]表示nums的前i个数之和
        int[] sum = new int[len+1];
        for (int i = 1; i <=len; i++) {
            sum[i] = sum[i-1]+nums[i-1];
        }

        //构建dp数组
        //这里简化性的将dp范围扩大一些，可以将所有必要的值都规范在同一种求取语句中
        int[][] dp = new int[len+10][4];
        for (int i = len-k+1; i >=1; i--) {
            for (int j = 1; j <4; j++) {
                dp[i][j]= Math.max(dp[i+1][j],sum[i+k-1]-sum[i-1]+dp[i+k][j-1]);
            }
        }
        int[] ans = new int[3];
        int index = 1;
        for (int i = 0; i <= 2; i++) {
            while (dp[index][3 - i] != (sum[index+k-1]-sum[index-1] + dp[index + k][2 - i])) {
                index++;
            }
            ans[i] = index-1;
            index += k;
        }
        return ans;
    }
}
