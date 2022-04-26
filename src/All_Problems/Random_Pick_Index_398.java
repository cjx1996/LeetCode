package All_Problems;

import java.util.*;

/**
 * @ClassName Random_Pick_Index_398
 * @Description
 * @Author cjx
 * @Date 2022/4/25 17:23
 * @Version 1.0
 */
public class Random_Pick_Index_398 {
    private class Solution{
        Map<Integer, List<Integer>> map;
        Random random = new Random();
        public Solution(int[] nums){
            map = new HashMap<>();
            for(int i = 0;i<nums.length;i++){
                List<Integer> indexs = map.getOrDefault(nums[i], new ArrayList<>());
                indexs.add(i);
                map.put(nums[i],indexs);
            }
        }

        public int pick(int target){
            return map.get(target).get(random.nextInt(map.get(target).size()));
        }
    }

}
