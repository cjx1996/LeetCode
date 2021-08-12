import org.junit.Test;

/**
 * @ClassName Longest_Palindromic_Subsequence_516
 * @Description
 * @Author cjx
 * @Date 2021/8/12 20:50
 * @Version 1.0
 */
public class Longest_Palindromic_Subsequence_516 {
    @Test
    public void test() {
        String s = "bbbab";
        System.out.println(longestPalindromeSubseq(s));
    }

    public int longestPalindromeSubseq(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        int[][] dp = new int[n][n];
       for(int i=n-1;i>-1;i--){
           char c1 = chars[i];
           dp[i][i]=1;
           for(int j=i+1;j<n;j++){
               if(c1==chars[j]){
                   dp[i][j] =2+dp[i+1][j-1];
               }else{
                   dp[i][j] = Math.max(dp[i+1][j],dp[i][j-1]);
               }
           }
       }
        return dp[0][n-1];
    }
}
