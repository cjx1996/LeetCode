import org.junit.Test;



/**
 * @author cjx
 * @version 1.0
 * @classname the_number_of_good_subsets_1994
 * @description
 * @date 2022/2/22 11:43
 */
public class The_Number_of_Good_Subsets_1994 {
    @Test
    public void test() {
        int[] nums = new int[]{1, 2, 3, 4};
        System.out.println(numberOfGoodSubsets(nums));
    }

    public int numberOfGoodSubsets(int[] nums) {
        int MOD = (int) 1e9 + 7;
        int[] p = new int[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29};
        int[] cnt = new int[35];
        int mask = 1 << 10;
        long[] f = new long[mask];
        for (int num : nums) cnt[num]++;
        f[0] = 1;
        for (int i = 2; i <= 30; i++) {
            if (cnt[i] == 0) continue;
            int cur = 0, x = i;
            boolean ok = true;
            for (int j = 0; j < 10; j++) {
                int c = 0;
                while (x % p[j] == 0) {
                    cur |= 1 << j;
                    x /= p[j];
                    c++;
                }
                if (c > 1) {
                    ok = false;
                    break;
                }
            }
            if (!ok) continue;
            for (int pre = mask - 1; pre >= 0; pre--) {
                if ((pre & cur) != 0||f[pre]==0) continue;
                f[pre | cur] = (f[pre | cur] + f[pre] * cnt[i]) % MOD;
            }
        }
        long ans = 0;
        for (int i = 1; i < mask; i++) ans = (ans+f[i])%MOD;
        for (int i = 0; i < cnt[1]; i++) {
            ans = (ans*2)%MOD;
        }
        return (int)ans;
    }
}
