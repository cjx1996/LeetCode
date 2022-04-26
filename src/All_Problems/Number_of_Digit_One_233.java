package All_Problems;

import org.junit.Test;

/**
 * @ClassName Number_of_Digit_One_233
 * @Description
 * @Author cjx
 * @Date 2021/8/13 16:07
 * @Version 1.0
 */
public class Number_of_Digit_One_233 {
    @Test
    public void test() {
        int n = 13;
        System.out.println(countDigitOne(n));
    }

    public int countDigitOne(int n) {
        int tem = n, i = 0;
        int ans = 0;
        while (tem != 0) {
            ans += (int) (n / (Math.pow(10, i + 1))) * Math.pow(10, i)
                    + Math.min(Math.max(0, n % Math.pow(10, i + 1) - Math.pow(10, i) + 1), Math.pow(10,i));
            tem /= 10;
            i++;
        }
        return ans;
    }
}
