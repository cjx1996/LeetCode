package All_Problems;

import org.junit.Test;

/**
 * @ClassName Maximum_Value_1802
 * @Description
 * @Author cjx
 * @Date 2023/1/4 11:55
 * @Version 1.0
 */
public class Maximum_Value_1802 {
    @Test
    public void test(){
        System.out.println(maxValue(3,2,18));
    }
    public int maxValue(int n, int index, int maxSum) {
        int l = 1, r = maxSum;
        while (l < r) {
            int mid = l + (r - l+1) / 2;
            if (!valid(mid, n, index, maxSum)){
                r=mid-1;
            }else{
                l=mid;
            }
        }
        return l;
    }

    public boolean valid(int mid, int n, int index, int maxSum) {
        int left = index+1;
        int right = n - index;
        return cal(mid, left) + cal(mid, right) - mid <= maxSum;
    }

    public long cal(int max, int length) {
        if (max >= length) {
            return (long) (2 * max - length + 1) * length / 2;
        } else {
            return (long) max * (max + 1) / 2 + length - max;
        }
    }

}
