package All_Problems;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @ClassName Find_K_Closest_Elements_658
 * @Description
 * @Author cjx
 * @Date 2022/8/25 15:35
 * @Version 1.0
 */
public class Find_K_Closest_Elements_658 {
    @Test
    public void test(){
        int[] arr=new int[]{1,2,3,4,5};
        int k = 4;
        int x=3;
        List<Integer> ans= findClosestElements(arr,k,x);
        ans.forEach(System.out::println);
    }
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n = arr.length, l = 0, r = n - 1;
        while (l < r) {
            int mid = (l + r + 1) >> 1;
            if (arr[mid] <= x) l = mid;
            else r = mid - 1;
        }
        r = r < n - 1 && Math.abs(arr[r] - x) > Math.abs(arr[r + 1] - x) ? r + 1 : r;
        int i = r - 1, j = r + 1;
        while (j - i - 1 < k) {
            if (i < 0) {
                j = 1 + k;
                break;
            }
            if (j > n - 1) {
                i = n - 1 - k;
                break;
            }
            if (Math.abs(arr[i] - x) <= Math.abs(arr[j] - x)) i--;
            else j++;
        }
        List<Integer> ans = new ArrayList<>();
        for (int m = i + 1; m < j; m++) {
            ans.add(arr[m]);
        }
        return ans;
    }

}
