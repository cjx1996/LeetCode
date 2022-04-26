package All_Problems;

import org.junit.Test;

import java.util.Arrays;

/**
 * @ClassName Sum_of_Unique_Elements_1748
 * @Description
 * @Author cjx
 * @Date 2022/2/6 9:38
 * @Version 1.0
 */
public class Sum_of_Unique_Elements_1748 {
    @Test
    public void test() {
        int[] nums = new int[]{1, 1, 1, 1, 1};
        System.out.println(sumOfUnique(nums));
    }

    public int sumOfUnique(int[] nums) {
        int[] cnt = new int[101];
        for (int num : nums) {
            cnt[num]++;
        }
        int ans = 0;
        for (int i = 0; i < cnt.length; i++) if (cnt[i] == 1) ans += i;

        return ans;
/*
        Arrays.sort(nums);
        int ans = 0;
        int n = nums.length;
        int l = 0, r = 0;
        while (r < n) {
            if (nums[r] != nums[l]) {
                if(r==l+1){
                    ans += nums[l];
                }
                l = r;
            }
            r++;
        }
        if(l==n-1) ans+=nums[l];
        return ans;
   */
    }
}
