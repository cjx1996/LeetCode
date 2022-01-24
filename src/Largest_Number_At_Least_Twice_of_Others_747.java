import org.junit.Test;

/**
 * @ClassName Largest_Number_At_Least_Twice_of_Others_747
 * @Description
 * @Author cjx
 * @Date 2022/1/13 11:36
 * @Version 1.0
 */
public class Largest_Number_At_Least_Twice_of_Others_747 {

    @Test
    public void test() {
        int[] nums = new int[]{0, 0, 3, 2};
        System.out.println(dominantIndex(nums));
    }

    public int dominantIndex(int[] nums) {
        int n = nums.length;
        int largest = nums[0], larger = 0;
        int index = 0;
        for (int i = 1; i < n; i++) {
            int cur = nums[i];
            larger = Math.max(larger, Math.min(largest, cur));
            if (cur > largest) {
                index = i;
                largest = cur;
            }
        }
        return largest >= 2 * larger ? index : -1;
    }
}
