package All_Problems;

/**
 * @ClassName Running_Sum_of_1d_Array_1480
 * @Description
 * @Author cjx
 * @Date 2021/8/28 13:08
 * @Version 1.0
 */
public class Running_Sum_of_1d_Array_1480 {
    public int[] runningSum(int[] nums) {
        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum[i] = nums[i] + sum[i - 1];
        }
        return sum;
    }
}
