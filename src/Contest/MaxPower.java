package Contest;

import org.junit.Test;

import java.util.Arrays;

/**
 * @ClassName MaxPower
 * @Description
 * @Author cjx
 * @Date 2023/1/7 23:25
 * @Version 1.0
 */
public class MaxPower {
    @Test
    public void test() {
        int[] stations=new int[]{
                13,12,8,14,7
        };
        int r = 2;
        int k = 23;
        System.out.println(maxPower(stations, r, k));
    }

    public long maxPower(int[] stations, int r, int k) {
        int n = stations.length;
        long[] sum = new long[n + 1];
        for (int i = 0; i < stations.length; i++) {
            sum[i + 1] = sum[i] + stations[i];
        }
        long left = 1, right = sum[n] + k;
        while (left < right) {
            long mid = left + (right - left + 1) / 2;
            if (cal(sum, r, mid, k)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    public boolean cal(long[] _pre, int r, long mid, int k) {
        long[] pre = Arrays.copyOf(_pre, _pre.length);
        int n = pre.length - 1;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            int left = Math.max(0, i - r);
            int right = Math.min(n - 1, i + r);
            long diff = mid - pre[right + 1] + pre[left];
            if (diff > 0) {
                cnt += diff;
                for (int j = i+r+1 ; j <= n; j++) {
                    pre[j] += diff;
                }
            } else continue;
            if (cnt > k) return false;
        }
        return true;
    }

}
