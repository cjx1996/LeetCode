package All_Problems;

import org.junit.Test;

/**
 * @ClassName Subarray_Product_Less_Than_K_713
 * @Description
 * @Author cjx
 * @Date 2021/7/19 23:23
 * @Version 1.0
 */
public class Subarray_Product_Less_Than_K_713 {
    @Test
    public void test() {
        int[] nums = new int[]{10, 5, 2, 101, 1};
        System.out.println(numSubarrayProductLessThanK(nums, 0));
    }

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k<1) return 0;
        int l = 0, r = 0;
        int len = nums.length;
        int ans = 0;
        int mul = 1;
        while (r < len) {
            mul *= nums[r];
            //乘积超过限制，左指针移动，乘积减小
            while(mul>=k) mul/=nums[l++];
            ans += r - l + 1;
            r++;
        }
        return ans;

    }
}
