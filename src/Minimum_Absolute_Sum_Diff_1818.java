import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @ClassName Minimum_Absolute_Sum_Diff_1818
 * @Description TODO
 * @Author cjx
 * @Date 2021/7/14 17:11
 * @Version 1.0
 */
public class Minimum_Absolute_Sum_Diff_1818 {
    @Test
    public void test() {
        int[] nums1 = new int[]{2, 100, 4, 4, 2, 7};
        int[] nums2 = new int[]{93, 9, 5, 1, 7, 4};
        System.out.println(minAbsoluteSumDiff(nums1, nums2));
    }

    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        int res = 0;
        int len = nums1.length;
        int mod = 1000000007;
        int[] nums3 = Arrays.copyOf(nums1, len);

        Arrays.sort(nums3);
        int max = 0;
        for (int i = 0; i < len; i++) {
            int currRes = Math.abs(nums1[i] - nums2[i]);
            res = (res + currRes) % mod;
            int index = binarySearch(nums3, nums2[i]);

            int posRes = Math.abs(nums3[index] - nums2[i]);
            int posDiff = currRes - posRes;
            max = (posDiff > max) ? posDiff : max;

            if (index != 0) {
                posRes = Math.abs(nums3[index - 1] - nums2[i]);
                posDiff = currRes - posRes;
                max = (posDiff > max) ? posDiff : max;
            }
        }


        return (res - max + mod) % mod;
    }

    int binarySearch(int[] a, int tar) {
        int left = 0;
        int right = a.length - 1;
        while (left < right) {
            int mid = (left + right) >> 1;
            if (a[mid] < tar) {
                left = mid + 1;
            } else if (a[mid] > tar) {
                right = mid;
            } else {
                return mid;
            }
          /*
            int mid = left + (right - left) / 2 + 1;
            if (list.get(mid) < tar) {
                left = mid;
            } else if (list.get(mid) > tar) {
                right = mid - 1;
            } else {
                return mid;
            }
*/
        }
        return right;
    }
}
