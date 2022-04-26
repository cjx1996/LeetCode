package All_Problems;

import org.junit.Test;

/**
 * @ClassName Find_Minimum_In_Rotated_Sorted_Array_153
 * @Description 在一个互不相同的经过多次旋转的排序数组中输出最小元素
 * @Author cjx
 * @Date 2021/4/9 15:08
 * @Version 1.0
 */

public class Find_Minimum_In_Rotated_Sorted_Array_153 {

    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            //当数组为有序列表时，直接跳出输出l即可
            if (nums[l] <= nums[r]) {
                return nums[l];
            }

            if (nums[mid] > nums[r]) {
                l = mid + 1;
            } else {
                r = mid;
            }

        }
        return nums[l];
    }

    @Test
    public void test() {
        int[] nums = {11,13,15,17};
        int min = findMin(nums);
        System.out.println(min);
    }

}
