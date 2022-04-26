package All_Problems;

import org.junit.Test;

/**
 * @ClassName Arithmetic_Slices_413
 * @Description
 * @Author cjx
 * @Date 2021/8/10 10:57
 * @Version 1.0
 */
public class Arithmetic_Slices_413 {
    @Test
    public void test() {
        int[] nums = new int[]{1,2,3,4,5,6};
        System.out.println(numberOfArithmeticSlices(nums));
    }

    //用双指针方法得到结果
    public int numberOfArithmeticSlices(int[] nums) {
        int len = nums.length;
        if (len < 3) return 0;
        int left = 0, right = 1;
        int ans = 0;
        while (right < len) {
            int diff = nums[right] - nums[left];
            while (right < len && nums[right] - nums[right - 1] == diff) {
                right++;
            }
            if (right > left + 2) {
                int n = right-left;
                ans += (n-2)*(n-1)/2;
            }
            left = right;
            right = left + 1;
        }
        return ans;
    }
}
