import org.junit.Test;

/**
 * @ClassName Search_Insert_35
 * @Description TODO
 * @Author cjx
 * @Date 2021/6/8 23:18
 * @Version 1.0
 */
public class Search_Insert_35 {
    @Test
    public void test() {
        int[] nums = new int[]{1, 3, 5, 6};
        System.out.println(searchInsert(nums, 5));
    }

    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid = right / 2;
        while (left <= right) {
            if (nums[mid] == target) return mid;
            if (nums[mid] < target) {

                left = mid + 1;
                if (left == nums.length)
                    return left;
                mid = (left + right) / 2;
            } else if (nums[mid] > target) {

                right = mid - 1;

                mid = (left + right) / 2;
            }
        }
        return nums[left]>target?left:left+1;
    }
}
