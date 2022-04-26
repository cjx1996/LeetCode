package All_Problems;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName Longest_Harmonious_Subsequence_594
 * @Description
 * @Author cjx
 * @Date 2021/11/20 17:55
 * @Version 1.0
 */
public class Longest_Harmonious_Subsequence_594 {
    @Test
    public void test() {
        int[] nums = new int[]{1};
        System.out.println(findLHS(nums));
    }

    public int findLHS(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int max = 0;
        Set<Integer> set = map.keySet();
        for (Integer integer : set) {
            if (map.containsKey(integer + 1)) {
                max = Math.max(max, map.get(integer) + map.get(integer + 1));
            }
        }
        return max;
    }
}
