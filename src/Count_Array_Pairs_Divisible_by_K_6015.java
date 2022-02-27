import org.junit.Test;

/**
 * @ClassName Count_Array_Pairs_Divisible_by_K_6015
 * @Description
 * @Author cjx
 * @Date 2022/2/20 13:04
 * @Version 1.0
 */
public class Count_Array_Pairs_Divisible_by_K_6015 {
    @Test
    public void test() {
        int[] nums = new int[]{1, 2, 3, 4};
        System.out.println(coutPairs(nums, 5));
    }

    public long coutPairs(int[] nums, int k) {
        int[] cnt = new int[k + 1];
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            cnt[gcd(nums[i], k)]++;
        }
        long ans = 0;
        for (int i = 0; i <= k; i++) {
            if (cnt[i] == 0) continue;
            if ((long) i * i % k == 0) {
                ans += (long) cnt[i] * (cnt[i] - 1) / 2;
            }
            for (int j = i + 1; j <= k; j++) {
                if ((long) i * j % k == 0) {
                    ans += (long) cnt[i] * cnt[j];
                }
            }
        }
        return ans;
    }

    int gcd(int a, int b) {
        if (b > a) {
            int tem = b;
            b = a;
            a = tem;
        }
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
