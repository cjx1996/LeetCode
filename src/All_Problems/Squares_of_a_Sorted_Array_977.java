package All_Problems;

import org.junit.Test;

/**
 * @ClassName Squares_of_a_Sorted_Array_977
 * @Description
 * @Author cjx
 * @Date 2021/8/6 22:07
 * @Version 1.0
 */
public class Squares_of_a_Sorted_Array_977 {
    @Test
    public void test(){
    int[] nums = new int[]{-5,-3,-2,-1};
        for (int i : sortedSquares(nums)) {
            System.out.println(i);
        }
    }
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int index = binarySearch(nums);

        int l = index - 1, r = index;
        for (int i = 0; i < n; i++) {
            int num = 0;
            if (l >= 0 && r < n) {
                if (nums[r] < -nums[l]) {
                    num = nums[r];
                    r++;
                } else {
                    num = -nums[l];
                    l--;
                }
            } else if (l < 0) {
                num = nums[r];
                r++;
            } else if (r > n - 1) {
                num = -nums[l];
                l--;
            }
            ans[i] = num * num;
        }
        return ans;

    }

    int binarySearch(int[] nums) {
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] < 0) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }
}
