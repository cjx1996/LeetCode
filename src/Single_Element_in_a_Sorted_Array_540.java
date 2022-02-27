import org.junit.Test;

/**
 * @ClassName Single_Element_in_a_Sorted_Array_540
 * @Description
 * @Author cjx
 * @Date 2022/2/14 10:39
 * @Version 1.0
 */
public class Single_Element_in_a_Sorted_Array_540 {
    @Test
    public void test() {
        int[] nums = new int[]{3, 3, 7, 7, 10};
        System.out.println(singleNonDuplicate(nums));
    }

    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        int l = 0, r = n - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == nums[mid ^ 1]) l = mid + 1;
            else r = mid;
        }
        return nums[l];
    }
}
