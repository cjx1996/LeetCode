package All_Problems;

import org.junit.Test;

/**
 * @ClassName Nth_Digit_400
 * @Description
 * @Author cjx
 * @Date 2021/11/30 19:24
 * @Version 1.0
 */
public class Nth_Digit_400 {
    @Test
    public void test() {
        System.out.println(findNthDigit(12));
    }

    public int findNthDigit(int n) {
        int d = 1, sum = 9;
        //得到n位所在的数的位数
        while (n > (long)d * sum) {//需要添加long，否则可能会超出范围
            n -= d * sum;
            d++;
            sum *= 10;
        }
        //将位数的下标从1转换到0，n自减1
        n--;

        //所在的那个数在所有d位数的数中的次序（从0开始)
        int index = n / d;
        //第n位所在的那个数
        int num = index + sum / 9;
        //第n位在所在数的次序(从左开始数)
        n = n%d;
        //第n位在所在数的次序(从右开始数)
        n = d - n - 1;
        return  (num / (int)Math.pow(10, n)) % 10;
    }
}
