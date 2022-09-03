package All_Problems;

import org.junit.Test;

import java.util.Arrays;

/**
 * @ClassName Maximum_Equal_Frequency_1224
 * @Description
 * @Author cjx
 * @Date 2022/8/18 17:18
 * @Version 1.0
 */
public class Maximum_Equal_Frequency_1224 {
    @Test
    public void test() {
        int[] nums = new int[]{1,1,1,2,2,2,3,3,3,4,4,4,5};
        System.out.println(maxEqualFreq(nums));
    }

    static int[] cnt = new int[100001];
    static int[] sum = new int[100001];

    public int maxEqualFreq(int[] nums) {
        Arrays.fill(cnt, 0);
        Arrays.fill(sum, 0);
        int n = nums.length;
        int max = 0;
        int ans = 1;
        for (int i = 0; i < n; i++) {
            int cur = nums[i], len = i + 1;
            sum[cnt[cur]]--;
            cnt[cur]++;
            sum[cnt[cur]]++;
            max = Math.max(max, cnt[cur]);
            if (max == 1) {
                ans = len;
            } else if (max * sum[max] + 1 == len) {
                ans = len;
            } else if ((max - 1) * (sum[max - 1] + 1) + 1 == len) {
                ans = len;
            }
        }
        return ans;
    }

}
