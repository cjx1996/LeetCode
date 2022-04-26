package All_Problems;

/**
 * @ClassName Corporate_Flight_Bookings_1109
 * @Description
 * @Author cjx
 * @Date 2021/8/31 22:25
 * @Version 1.0
 */
public class Corporate_Flight_Bookings_1109 {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] ans = new int[n];
        for (int[] booking : bookings) {
            int l = booking[0], r = booking[1], value = booking[2];
            ans[l - 1] += value;
            if (r != n) ans[r] -= value;
        }
        for (int i = 1; i < n; i++) {
            ans[i] += ans[i - 1];
        }
        return ans;
    }
}
