package All_Problems;

import java.util.Arrays;

/**
 * @ClassName longest_Increasing_Subsequence_300
 * @Description
 * @Author cjx
 * @Date 2023/1/4 18:11
 * @Version 1.0
 */
public class longest_Increasing_Subsequence_300 {
    //方法一：动态规划
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int ans = 1;
        for (int i = 1; i < n; i++) {
            int num = nums[i];
            for (int j = 0; j < i; j++) {
                if (num > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }

    //方法二：贪心+二分查找 维护一个数组d[i]，表示长度为i的最长上升子序列的末尾元素的最小值
    public int lengthOfLIS2(int[] nums) {
        int n = nums.length;
        int[] d = new int[n + 1];
        int len = 1;
        d[1] = nums[0];
        for (int i = 0; i < n; i++) {
            int num=nums[i];
            if (num > d[len]) {
                len++;
                d[len] = num;
            } else {
                int l = 1, r = len;
                while (l < r) {
                    int mid = l + (r - l) / 2;
                    if (d[mid]<num){
                        l=mid+1;
                    }else{
                        r=mid;
                    }
                }
                d[l]=num;
            }
        }
        return len;
    }
}
