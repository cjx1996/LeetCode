package All_Problems;

import org.junit.Test;

import java.util.*;

/**
 * @ClassName Find_K_Pairs_with_Smallest_Sums_373
 * @Description
 * @Author cjx
 * @Date 2022/1/14 13:04
 * @Version 1.0
 */
public class Find_K_Pairs_with_Smallest_Sums_373 {
    @Test
    public void tset(){
    int[] nums1= new int[]{1,7,11};int[] nums2= new int[]{2,4,6};
        List<List<Integer>> ans = kSmallestPairs(nums1, nums2, 3);
        for (List<Integer> list : ans) {
            for (Integer num : list) {
                System.out.print(num+" ");
            }
            System.out.println();
        }
    }
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int m = nums1.length, n = nums2.length;
        List<List<Integer>> ans = new ArrayList<>();
        Queue<int[]> q = new PriorityQueue<int[]>((a, b) -> (nums1[a[0]] + nums2[a[1]] - nums1[b[0]] - nums2[b[1]]));
        int len = Math.min(m,k);
        for (int i = 0; i < len; i++) {
            q.add(new int[]{i,0});
        }

        while (ans.size() < k&&!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];
            List<Integer> p = new ArrayList<>();
            p.add(nums1[x]);
            p.add(nums2[y]);
            ans.add(p);
            if (y != n - 1 ) {
                q.add(new int[]{x, y + 1});
            }
        }
        return ans;
    }
}
