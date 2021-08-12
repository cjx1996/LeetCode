import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName Minimum_Operations_to_Make_a_Subsequence_1713
 * @Description
 * @Author cjx
 * @Date 2021/7/26 20:41
 * @Version 1.0
 */
public class Minimum_Operations_to_Make_a_Subsequence_1713 {
    @Test
    public void test(){
        int[] target = new int[]{6,4,8,1,3,2};
        int[] arr = new int[]{4,7,6,2,3,8,6,1};
        System.out.println(minOperations(target,arr));
    }
    class Solution {
        public int minOperations(int[] target, int[] arr) {
            Map<Integer, Integer> map = new HashMap<Integer, Integer>();
            for (int i = 0; i < target.length; i++)
                map.put(target[i], i);

            int index = 0;
            int[] nums = new int[arr.length];
            for (int i = 0; i < arr.length; i++) {
                if (map.containsKey(arr[i])) {
                    nums[index++] = map.get(arr[i]);
                }
            }

            return target.length - lengthOfLIS(nums, index);
        }

        public int lengthOfLIS(int[] nums, int n) {
            int len = 1;
            if (n == 0) {
                return 0;
            }
            int[] d = new int[n + 1];
            d[len] = nums[0];
            for (int i = 1; i < n; ++i) {
                if (nums[i] > d[len]) {
                    d[++len] = nums[i];
                } else {
                    int l = 1, r = len, pos = 0;
                    while (l <= r) {
                        int mid = (l + r) >> 1;
                        if (d[mid] < nums[i]) {
                            pos = mid;
                            l = mid + 1;
                        } else {
                            r = mid - 1;
                        }
                    }
                    d[pos + 1] = nums[i];
                }
            }
            return len;
        }
    }
    public int minOperations(int[] target, int[] arr) {
        Map<Integer, Integer> pos = new HashMap<>();
        for (int i = 0; i < target.length; i++) {
            pos.put(target[i], i);
        }
        List<Integer> comm = new ArrayList<>();
        for (int num : arr) {
            if (pos.containsKey(num)) {
                int index = binarySearch(comm, pos.get(num));
                if(index!=comm.size()){
                    comm.set(index,pos.get(num));
                }else{
                    comm.add(pos.get(num));
                }
            }
        }
        return target.length-comm.size();
    }

    int binarySearch(List<Integer> comm, int target) {
        int size = comm.size();
        if (size == 0 || comm.get(size - 1) < target) {
            return size;
        }
        int l = 0, r = size - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (comm.get(mid) < target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;

    }
}


