package All_Problems;

import org.junit.Test;

/**
 * @ClassName SearchInRotatedSortedArray_81
 * @Description TODO 未解决
 * @Author cjx
 * @Date 2021/4/7 16:28
 * @Version 1.0
 */
public class SearchInRotatedSortedArray_81 {
    public boolean search(int[] nums, int target) {
        int length = nums.length;
        if (nums[0] == target || nums[length - 1] == target) {
            return true;
        }
//        if(nums[0])
        return false;
    }

    @Test
    public void test() {

    }
}
