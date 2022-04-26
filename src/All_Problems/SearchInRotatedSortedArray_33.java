package All_Problems;

import org.junit.Test;

/**
 * @ClassName SearchInRotatedSortedArray_33
 * @Description TODO
 * @Author cjx
 * @Date 2021/4/7 16:44
 * @Version 1.0
 */
public class SearchInRotatedSortedArray_33 {

    /**
     * 数组中的值互不相同
     *
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {

        if (nums.length == 1) {
            if (target == nums[0]) {
                return 0;
            } else {
                return -1;
            }
        }
        return searchIndex(nums, 0, nums.length - 1, target);

    };

    private int searchIndex(int[] nums, int left, int right, int target) {

        if (right == left + 1) {
            if (target == nums[left]) {
                return left;
            } else if (target == nums[right]) {
                return right;
            }else {
                return -1;
            }
        }
        int mid = (right + left) / 2;
        if (target == nums[mid]) {
            return mid;
        };
        if (nums[mid] > nums[left]) {
            if (target >= nums[left] && target < nums[mid]) {
                return searchIndex(nums, left, mid, target);
            } else {
                return searchIndex(nums, mid, right, target);
            }
        };
        if (nums[mid] < nums[right]) {
            if (target > nums[mid] && target <= nums[right]) {
                return searchIndex(nums, mid, right, target);
            } else {
                return searchIndex(nums, left, mid, target);
            }
        };
        return -1;


    }

    @Test
    public void test() {
        int[] nums = {4,5,6,7,0,1,2};
        int target = 1;
        int index = search(nums, target);
        System.out.println(index);
    }
    @Test
    public void test2(){
        System.out.println(-5%2);
    }
}
