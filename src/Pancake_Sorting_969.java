import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Pancake_Sorting_969
 * @Description
 * @Author cjx
 * @Date 2022/2/19 10:36
 * @Version 1.0
 */
public class Pancake_Sorting_969 {
    @Test
    public void test() {
        int[] arr = new int[]{3, 2, 4, 1};
        List<Integer> list = pancakeSort(arr);
        for (Integer i : list) {
            System.out.println(i);
        }
    }

    public List<Integer> pancakeSort(int[] arr) {
        List<Integer> ans = new ArrayList<>();
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int index = findIndex(arr, n - i);
            if (index == n - 1 - i) continue;
            if (index != 0) {
                reverseK(arr, index);
                ans.add(index+1);
            }
            reverseK(arr, n - 1 - i);
            ans.add(n  - i);
        }
        return ans;
    }

    int findIndex(int[] arr, int target) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (arr[i] == target) return i;
        }
        return -1;
    }

    void reverseK(int[] arr, int k) {
        int l = 0, r = k;
        while (l < r) {
            int tem = arr[l];
            arr[l] = arr[r];
            arr[r] = tem;
            l++;
            r--;
        }
    }
}
