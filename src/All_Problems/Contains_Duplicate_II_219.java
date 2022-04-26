package All_Problems;

import java.util.*;

/**
 * @ClassName Contains_Duplicate_II_219
 * @Description
 * @Author cjx
 * @Date 2022/1/19 10:15
 * @Version 1.0
 */
public class Contains_Duplicate_II_219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Object> set = new HashSet<>();
        if(k==0) return false;
        for (int i = 0; i < k&&i<nums.length; i++) {
            if(set.contains(nums[i])) return true;
            set.add(nums[i]);
        }
        for (int i = k; i < nums.length; i++) {
            if(!set.add(nums[i]))return true;
            set.remove(nums[i-k]);
        }
        return false;

        //使用了HashMap，浪费了空间，用时19ms
        /*
        Map<Integer,Integer> map = new HashMap<>();
        if(k==0) return false;
        int l =0,r=0;
        for(;r<nums.length;r++){
            if(r-l>k) {
                map.remove(nums[l]);
                l++;
            }
            if(map.containsKey(nums[r])) return true;
            else map.put(nums[r],1);
        }
        return true;
        */
        //超时
        /*
        ArrayDeque<Integer> q = new ArrayDeque<>();
        if (k == 0) return false;
        int l = 0, r = 0;
        for (; r < nums.length; r++) {
            if (r - l > k) {
                q.poll();
                l++;
            }
            if (q.contains(nums[r])) return true;
            else q.offer(nums[r]);
        }
        return false;
        */
    }
}
