package All_Problems;

import java.util.Arrays;

/**
 * @ClassName Wiggle_Sort_II_324
 * @Description
 * @Author cjx
 * @Date 2022/6/28 9:53
 * @Version 1.0
 */
public class Wiggle_Sort_II_324 {
    public void wiggleSort(int[] nums) {
        int[] arr = nums.clone();
        Arrays.sort(arr);
        int n = arr.length;
        int x = (n + 1) / 2;
        for (int i = 0, j = x - 1, k = n - 1; i < n; i += 2, j--, k--) {
            nums[i] = arr[j];
            if (i + 1 < n) {
                nums[i + 1] = arr[k];
            }
        }
    }
}