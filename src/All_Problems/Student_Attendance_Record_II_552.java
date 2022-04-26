package All_Problems;

import org.junit.Test;

/**
 * @ClassName Student_Attendance_Record_II_552
 * @Description
 * @Author cjx
 * @Date 2021/8/18 9:57
 * @Version 1.0
 */
public class Student_Attendance_Record_II_552 {
    @Test
    public void test() {
        System.out.println(checkRecord(4));


    }

    public int checkRecord(int n) {
        int mod = (int) (1e9 + 7);
        //dp[i][j]表示前k轮迭代后，k+1位的缺勤次数i，以及前两位中j的连续位数
        int[][] dp = new int[2][3];
        
        int ans = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                ans += dp[i][j];
                ans %= mod;
            }
        }
        return ans;
    }
}
