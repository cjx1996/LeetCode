package All_Problems;

import org.junit.Test;

/**
 * @ClassName minSwaps_5976
 * @Description
 * @Author cjx
 * @Date 2022/1/9 11:04
 * @Version 1.0
 */
public class minSwaps_5976 {
    @Test
    public void test() {
        int[] nums = new int[]{1, 1, 0, 0, 1};
        System.out.println(minSwaps(nums));
    }

    public int minSwaps(int[] nums) {
        int cnt = 0;
        int n = nums.length;
        int[] cur = new int[2 * n];
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) cnt++;
            cur[i] = nums[i];
            cur[n + i] = nums[i];
        }
        int tem = 0;
        for (int i = 0; i < cnt; i++) {
            if (cur[i] == 1) tem++;
        }
        int ans = Integer.MAX_VALUE;
        ans = Math.min(ans, cnt - tem);
        for (int i = cnt; i < 2 * n; i++) {
            if (cur[i] == 1) tem++;
            if (cur[i - cnt] == 1) tem--;
            ans = Math.min(ans, cnt - tem);
        }
        return ans;
    }
}
