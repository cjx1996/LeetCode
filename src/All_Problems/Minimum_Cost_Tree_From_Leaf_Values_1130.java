package All_Problems;

import org.junit.Test;

/**
 * @ClassName Minimum_Cost_Tree_From_Leaf_Values_1130
 * @Description
 * @Author cjx
 * @Date 2023/5/31 22:19
 * @Version 1.0
 */
public class Minimum_Cost_Tree_From_Leaf_Values_1130 {
    @Test
    public void test(){
        int[] arr=new int[]{4,11};
        System.out.println(mctFromLeafValues(arr));
    }
    public int mctFromLeafValues(int[] arr){
        int n = arr.length;
        int[][] max=new int[n][n];
        for (int i = 0; i < n; i++) {
            max[i][i]=arr[i];
        }
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                max[i][j]=Math.max(max[i][j-1],arr[j]);
            }
        }
        int[][] dp=new int[n][n];
        for (int i = n-1; i >=0 ; i--) {
            for(int j=i+1;j<n;j++){
                dp[i][j]=dp[i][j-1]+arr[j]*max[i][j-1];
                for(int k=i;k<j;k++){
                    dp[i][j]=Math.min(dp[i][j],max[i][k]*max[k+1][j]+dp[i][k]+dp[k+1][j]);
                }
            }
        }
        return dp[0][n-1];
    }

}
