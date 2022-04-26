package All_Problems;

import org.junit.Test;

/**
 * @ClassName Divide_Two_Integers_29
 * @Description
 * @Author cjx
 * @Date 2021/6/9 18:18
 * @Version 1.0
 */
public class Divide_Two_Integers_29 {
    @Test
    public void test() {
        System.out.println(divide1(9, -3));
    }

    public int divide(int dividend, int divisor) {
        //a,b分别代表被除数和除数
        long a = dividend, b = divisor;
        boolean isNeg = false;
        if ((a < 0 && b > 0) || (a > 0 && b < 0)) isNeg = true;
        if (a < 0) a = -a;
        if (b < 0) b = -b;
        long l = 0, r = a;
        while (l < r) {
            long mid = (l + r + 1) >> 1;
            if (mul(b, mid) <= a) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        long ans = isNeg ? -l : l;
        if (ans > Integer.MAX_VALUE || ans < Integer.MIN_VALUE) return Integer.MAX_VALUE;
        return (int) ans;
    }

    long mul(long a, long k) {
        long ans = 0;
        while (k != 0) {
            if ((k & 1) != 0) ans += a;
            k = k >> 1;
            a += a;
        }
        return ans;
    }


    //单纯使用移位进行操作
    public int divide1(int dividend, int divisor) {
        long a = dividend, b = divisor;
        boolean isNeg = false;
        if ((a < 0 && b > 0) || (a > 0 && b < 0)) isNeg = true;
        if (a < 0) a = -a;
        if (b < 0) b = -b;
        long temp, result = 1, ans = 0;
        while (a >= b) {
            temp = b << 1;
            result = 1;
            while (a >= temp) {
                temp <<= 1;
                result <<= 1;
            }
            a -= temp >> 1;
            ans += result;
        }
        ans = isNeg ? -ans : ans;
        if (ans > Integer.MAX_VALUE || ans < Integer.MIN_VALUE) return Integer.MAX_VALUE;
        return (int) ans;
    }
}
