package All_Problems;

import java.util.*;

/**
 * @ClassName TwoOutOfThree_2032
 * @Description
 * @Author cjx
 * @Date 2022/12/29 17:24
 * @Version 1.0
 */
public class TwoOutOfThree_2032 {
    int[] cnt=new int[101];
    Set<Integer> set;
    public List<Integer> twoOutOfThree(int[] nums1,int[] nums2,int[] nums3){
        solve(nums1);
        solve(nums2);
        solve(nums3);
        List<Integer> res=new ArrayList<>();
        for (int i = 0; i <= 100; i++) {
            if(cnt[i]>=2) res.add(i);
        }
        return res;
    }
    public void solve(int[] nums){
        set=new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        for (Integer i : set) {
            cnt[i]++;
        }
    }

}
