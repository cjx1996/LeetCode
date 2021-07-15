import org.junit.Test;

import java.util.HashMap;

/**
 * @ClassName Total_Hamming_Distance_477
 * @Description TODO
 * @Author cjx
 * @Date 2021/5/28 10:51
 * @Version 1.0
 */
public class Total_Hamming_Distance_477 {
    @Test
    public void test1() {
        int[] nums = {6, 1, 8, 6, 8};
        System.out.println(totalHammingDistance(nums));
    }


    //本方法为暴力法，当遇到大数据量的数组时，将会超时，下面介绍简单的方法
    public int totalHammingDistance(int[] nums) {
        HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (null == hash.get(nums[i])) {
                hash.put(nums[i], 1);
            } else {
                hash.put(nums[i], hash.get(nums[i]) + 1);
            }
        }
        Object[] nums2 = hash.keySet().toArray();
        len = nums2.length;
        int result = 0;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                result += hammingDistance((Integer) nums2[i], (Integer) nums2[j]) * hash.get((Integer) nums2[i]) * hash.get((Integer) nums2[j]);
            }
        }
        return result;
    }

    int hammingDistance(int x, int y) {
        int z = x ^ y;
        int result = 0;
        while (z != 0) {
            z = z & (z - 1);
            result++;
        }
        return result;
    }


    /**
     * 这里对每一位上的汉明距离进行计算， 最后将所有位的汉明距离相加得到结果，即在计算方法上将加法改进为了乘法，复杂度大大降低
     * @param nums
     * @return
     */
    public int totalHammingDistance1(int[] nums) {
        int result = 0;
        int len = nums.length;

        for (int i = 0; i < 30; i++) {
            int c = 0;
            for (int j = 0; j < len; j++) {
                c += (nums[j] >> i) & 1;
            }
            result += c * (len - c);
        }
        return result;
    }

    @Test
    public void test2() {
        int[] nums = {4, 14, 4};
        System.out.println(totalHammingDistance1(nums));
    }
}
