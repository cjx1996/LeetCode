package Interviews;

import org.junit.Test;

/**
 * @ClassName Exchange_0_1
 * @Description
 * @Author cjx
 * @Date 2022/5/7 16:38
 * @Version 1.0
 */
public class Exchange_0_1 {
    @Test
    public void test(){
        String[] ss=new String[]{
                "10101","00001","01001101","1110"
        };
        for (String s : ss) {
            System.out.println(exchange(s));
        }
    }
    public int exchange(String s) {
        int n = s.length();
        char[] cs = s.toCharArray();
        int[][] dp = new int[n][n];
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (cs[i] == cs[j]) {
                    //dp[i+1][j-1]：看成子串首部尾部各一个指针，都往中间移动
                    dp[i][j] = dp[i + 1][j - 1];//无需操作
                } else {
                    if(cs[i]=='1'){
                        dp[i][j]=dp[i+1][j]+1;
                    }else{
                        dp[i][j]=dp[i][j-1]+1;
                    }
                }
            }
        }
        return dp[0][n-1];
    }

}
