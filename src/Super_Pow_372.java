import org.junit.Test;

/**
 * @ClassName Super_Pow_372
 * @Description
 * @Author cjx
 * @Date 2021/12/5 14:22
 * @Version 1.0
 */
public class Super_Pow_372 {
    @Test
    public void test() {
        System.out.println(superPow1(Integer.MAX_VALUE, new int[]{2, 0, 0}));
    }

    //寻找循环次数，整除得到最简次数，计算最简次数后的模
    public int superPow1(int a, int[] b) {
        if (a == 1) return 1;
        a = a % 1337;
        int point = 0;
        int cur = a;
        do {
            cur = (cur * a) % 1337;
            point++;
        } while (cur % 1337 != a);
        int key = 0;
        int len = b.length;
        for (int i = 0; i < len; i++) {
            key = (key * 10 + b[i]) % point;
        }
        System.out.println(point);
        int res = a;
        for (int i = 0; i < key - 1; i++) {
            res = (res * a) % 1337;
        }
        return res;
    }

    public int superPow(int a, int[] b) {
        int len = b.length;
        a = a % 1337;
        int[] pow = new int[len];
        pow[len - 1] = a;
        for (int i = len - 2; i >= 0; i--) {
            pow[i] = pow(pow[i + 1], 10);
        }

        int sum = 1;
        for (int i = 0; i < len; i++) {
            sum *= pow(pow[i], b[i]);
            sum %= 1337;
        }
        return sum;
    }

    public int pow(int a, int pow) {
        if (pow == 0) return 1;
        int[] dp = new int[pow + 1];
        dp[1] = a;
        for (int i = 2; i <= pow; i++) {
            dp[i] = (dp[i / 2] * dp[i - i / 2]) % 1337;
        }
        return dp[pow];
    }
}
