package All_Problems;

import org.junit.Test;

import javax.sound.midi.Soundbank;

/**
 * @ClassName Minimum_Size_Subarray_Sum_209
 * @Description
 * @Author cjx
 * @Date 2021/7/20 10:42
 * @Version 1.0
 */
public class Minimum_Size_Subarray_Sum_209 {
    @Test
    public void test() {
        int[] nums = new int[]{2, 3, 1, 2, 4, 3};
        System.out.println(minSubArrayLen(7, nums));
    }

    public int minSubArrayLen(int target, int[] nums) {
        int len = nums.length;
        int left = 0;
        int right = 0;
        int mul = 0;
        int ans = len + 1;
        if (target <= 0) return 0;

        //无论如何每一次循环时right都必须增加，窗口增大
        for (right = 0; right < len; right++) {
            //每一次right增加更新mul
            mul += nums[right];
            //判断窗口缩小的条件
            while (mul >= target&&left<len) {
                //满足缩小条件后
                //更新结果
                ans = Math.min(ans, right - left + 1);
                //更新窗口（进行窗口内数据的一系列更新）
                mul -= nums[left];
                left++;
            }
        }
        if (ans == len + 1) ans = 0;
        //返回结果
        return ans;
    }
}
