import org.junit.Test;

/**
 * @ClassName Ones_And_Zeros_474
 * @Description
 * @Author cjx
 * @Date 2021/6/7 11:47
 * @Version 1.0
 */
public class Ones_And_Zeros_474 {
    @Test
    public void test() {
        String[] strs = new String[]{"10", "0001", "111001", "1", "0"};
        System.out.println(findMaxForm(strs, 5, 3));
    }

    /**
     * @param strs 给定的二进制字符串数组
     * @param m    最多包含的0个数
     * @param n    最多包含的1个数
     * @return
     */
    public int findMaxForm(String[] strs, int m, int n) {
        int count = 0;
        int len = strs.length;

       /*
       //定义一个三维dp数组，dp[i][j][k]表示在数组的前i个中，最多包含j个0，k个1的子集数目
        int[][][] dp = new int[len+1][m+1][n+1];

        //初始化dp数组

        //根据转移方程，求出数组
        for (int i = 1; i < len+1; i++) {
            String currStr = strs[i-1];
            int currLen = currStr.length();
            int ones = ones(currStr);
            int zeros = currLen-ones;
            for(int j = 0;j<m+1;j++){
                for(int k=0;k<n+1;k++){
                    if(zeros>j||ones>k){
                        dp[i][j][k]=dp[i-1][j][k];
                    }else{
                        dp[i][j][k]=Integer.max(dp[i-1][j][k],1+dp[i-1][j-zeros][k-ones]);
                    }
                }
            }
        }
        return dp[len][m][n];
        */

        //尝试对dp数组进行改进，因为下一行只与前一行数据相关，所以可以进行滚动变化
        //定义二维数组dp[j][k]，表示对于当前元素集，最多包含j个0，k个1的最大子集
        int[][] dp = new int[m + 1][n + 1];
        for (String str : strs) {
            int currLen = str.length();
            int ones = ones(str);
            int zeros = currLen - ones;
            for (int j = m; j >=0; j--) {
                for (int k = n; k >= 0; k--) {
                    if (zeros <= j && ones <= k) {
                        dp[j][k] = Integer.max(1 + dp[j - zeros][k - ones], dp[j][k]);
                    }
                }
            }
        }
        return dp[m][n];

    }

    int ones(String str) {
        int result = 0;
        int len = str.length();
        for (int i = 0; i < len; i++) {
            char c = str.charAt(i);
            if (c == '1') result++;
        }
        return result;
    }

}
