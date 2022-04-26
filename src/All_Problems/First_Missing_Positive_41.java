package All_Problems;

import org.junit.Test;

/**
 * @ClassName First_Missing_Positive_41
 * @Description
 * @Author cjx
 * @Date 2021/8/6 23:46
 * @Version 1.0
 */
public class First_Missing_Positive_41 {
    @Test
    public void test() {
        int[] nums = new int[]{3,4,-1,1};
        System.out.println(firstMissingPositive(nums));
    }

    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            while (num>-1&&num < n && nums[num] != num) {
                nums[i] ^= nums[num];
                nums[num] ^= nums[i];
                nums[i] ^= nums[num];
                num = nums[i];
            }
        }
        for (int i = 1; i < n; i++) {
            if (nums[i] != i) {
                return i;
            }
        }
        return nums[0]==n?n+1:n;
    }
}
