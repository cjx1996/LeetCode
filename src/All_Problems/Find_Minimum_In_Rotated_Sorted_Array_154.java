package All_Problems;

import org.junit.Test;

/**
 * @ClassName Find_Minimum_In_Rotated_Sorted_Array_153
 * @Description 在一个存在相同元素的经过多次旋转的排序数组中输出最小元素
 * @Author cjx
 * @Date 2021/4/9 15:08
 * @Version 1.0
 */

public class Find_Minimum_In_Rotated_Sorted_Array_154 {

    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            //当前子数组为有序数组，直接输出nums[l]
            if (nums[l] < nums[r]) {
                return nums[l];
            }
            int mid = (l + r) / 2;
            if (nums[l] == nums[mid]) {
                l++;

            } else if (nums[mid] > nums[l]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return nums[l];
    }

    @Test
    public void test() {
        int[] nums = {2,2,2,0,1};
        int min = findMin(nums);
        System.out.println(min);
    }

}
