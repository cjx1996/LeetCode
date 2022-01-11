import org.junit.Test;

import java.util.*;

/**
 * @ClassName Recover_the_Orighina_Array_5966
 * @Description
 * @Author cjx
 * @Date 2021/12/26 11:44
 * @Version 1.0
 */
public class Recover_the_Original_Array_5966 {
    @Test
    public void test() {
        int[] nums = new int[]{2, 10, 6, 4, 8, 12};
        int[] ans = recoverArray(nums);
        for (int num : ans) {
            System.out.println(num);
        }
    }

    public int[] recoverArray(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        int[] ans;
        HashMap<Integer, Integer> cnt = new HashMap<>();
        List<Integer> posK = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            cnt.put(nums[i], cnt.getOrDefault(nums[i], 0) + 1);
            if (i > 0 && (nums[i] - nums[0]) % 2 == 0) posK.add(nums[i] - nums[0]);
        }
        for (Integer tK : posK) {
            ans = check(cnt, tK, nums);
            if (ans.length == len / 2) return ans;
        }
        return null;
    }

    int[] check(Map<Integer, Integer> cnt, int k, int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>(cnt);
        List<Integer> list = new ArrayList<>();
        int i = 0;
        while (map.size() > 0) {
            Integer value1 = map.getOrDefault(nums[i], 0);
            int value2 = map.getOrDefault(nums[i] + k, 0);
            if (value1 == 0) {
                i++;
            continue;}
            else if (value2 == 0) {
                i++;
                break;
            }
            else {
                if (value1 == 1) map.remove(nums[i]);
                else map.put(nums[i], value1 - 1);
                if (value2 == 1) map.remove(nums[i] + k);
                else map.put(nums[i] + k, value2 - 1);
                list.add((nums[i]) + k / 2);
            }
            i++;
        }
        return list.stream().mapToInt(Integer::valueOf).toArray();

    }
}
