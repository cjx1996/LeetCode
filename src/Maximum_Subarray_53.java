import org.junit.Test;

import java.util.Arrays;

/**
 * @ClassName Maximum_Subarray_53
 * @Description TODO
 * @Author cjx
 * @Date 2021/6/11 23:32
 * @Version 1.0
 */
public class Maximum_Subarray_53 {
    @Test
    public void test() {
        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(nums));
    }

    public int maxSubArray(int[] nums) {

        int len = nums.length;

        /*
        //定义dp数组，dp[i]表示数组的前i个元素构成的子数组的以nums[i]结尾的最大子数组的和
        int[] dp = new int[len + 1];
        for (int i = 1; i < len + 1; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i - 1], dp[i]);
        }
        int max = 0;
        for (int value : dp) {
            if (value > max) max = value;
        }
        return max;
        */

        int max=Integer.MIN_VALUE,pre = 0;
        for (int num : nums) {
            pre = Math.max(num,pre+num);
            max = Math.max(pre,max);
        }
        return max;
    }
}


