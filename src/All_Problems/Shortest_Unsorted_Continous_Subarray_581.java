package All_Problems;

import org.junit.Test;

/**
 * @ClassName Shortest_Unsorted_Continous_Subarray_581
 * @Description
 * @Author cjx
 * @Date 2021/8/3 23:41
 * @Version 1.0
 */
public class Shortest_Unsorted_Continous_Subarray_581 {
    @Test
    public void test() {
        int[] nums = new int[]{1};
        System.out.println(findUnsortedSubarray(nums));
    }

    public int findUnsortedSubarray(int[] nums) {
        int len = nums.length;
        int left = -1;
        int right = len;
        int maxn = -100001;
        int minn = 100001;
        for (int i = 0; i < len; i++) {
            int currL = nums[len - 1 - i];
            int currR = nums[i];
            if (currL > minn) left = len - 1 - i;
            if (currR < maxn) right = i;
            minn = Math.min(minn, currL);
            maxn = Math.max(maxn, currR);
        }
        if (left == -1) return 0;
        return right - left + 1;
    }
}
