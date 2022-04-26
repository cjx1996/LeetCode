package All_Problems;

import java.util.Arrays;
import java.util.Random;

/**
 * @ClassName Shuffle_an_Array_384
 * @Description
 * @Author cjx
 * @Date 2021/11/22 17:18
 * @Version 1.0
 */
public class Shuffle_an_Array_384 {
    private class Solution {
        private int[] nums;//目标数组的地址
        int n;

        public Solution(int[] nums) {
            this.nums = nums;
            n = nums.length;
        }

        public int[] reset() {
            return nums;
        }

        public int[] shuffle() {
            Random random = new Random();
            int[] ans = nums.clone();
            for (int i = 0; i < n; i++) {
                int j = i+random.nextInt(n - i);
                int temp = ans[i];
                ans[i] = ans[j];
                ans[j] = temp;
            }
            return ans;
        }
    }
}
/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
