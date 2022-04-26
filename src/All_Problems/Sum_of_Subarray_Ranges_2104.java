package All_Problems;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @ClassName Sum_of_Subarray_Ranges_2104
 * @Description
 * @Author cjx
 * @Date 2022/3/4 9:16
 * @Version 1.0
 */
public class Sum_of_Subarray_Ranges_2104 {
    @Test
    public void test(){
    int[] nums = new int[]{1,3,3};
        System.out.println(subArrayRanges(nums));}
    //单调栈解法
    public long subArrayRanges(int[] nums) {
        long[] min = getCnt(nums, true), max = getCnt(nums, false);
        long ans = 0;
        for (int i = 0; i < nums.length; i++) {
            ans += (max[i] - min[i]) * nums[i];
        }
        return ans;
    }

    long[] getCnt(int[] nums, boolean isMin) {
        int n = nums.length;
        int[] left = new int[n], right = new int[n];
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!q.isEmpty() && (isMin ? nums[q.peek()] > nums[i] : nums[q.peek()] < nums[i])) q.pop();
            left[i] = q.isEmpty() ? -1 : q.peek();
            q.push(i);
        }
        q.clear();
        for (int i = n-1; i >= 0; i--) {
            while (!q.isEmpty() && (isMin ? nums[q.peek()] >= nums[i] : nums[q.peek()] <= nums[i])) q.pop();
            right[i] = q.isEmpty() ? n : q.peek();
            q.push(i);
        }
        long[] cnt = new long[n];
        for (int i = 0; i < n; i++) {
            cnt[i] = (right[i] - i) * (i - left[i]);
        }
        return cnt;
    }

   /* public long subArrayRanges(int[] nums){
        int n = nums.length;
        long ans = 0;
        for (int i = 0; i < n; i++) {
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            for (int j = i; j < n; j++) {
                max = Math.max(max,nums[j]);
                min = Math.min(min,nums[j]);
                ans+=max-min;
            }
        }
        return ans;
    }*/
}
