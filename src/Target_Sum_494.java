import org.junit.Test;

/**
 * @ClassName Target_Sum_494
 * @Description TODO
 * @Author cjx
 * @Date 2021/6/7 10:59
 * @Version 1.0
 */
public class Target_Sum_494 {
    public int findTargetSumWays(int[] nums, int target){
        int sum = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            sum += nums[i];
        }

        if(sum<target||(sum-target)%2!=0){
            return 0;
        }
        int neg = (sum-target)>>1;
       /*
       //构建dp[i][j]数组，表示在前i个数中，和为j的方法数
        int[][] dp =new int[len+1][neg+1];
        //dp数组的初始化
        dp[0][0]=1;
        for (int i = 1; i < neg+1; i++) {
            dp[0][i] = 0;
        }
        for (int i = 1; i < len+1; i++) {
            for(int j = 0; j< neg+1; j++){
                dp[i][j]=dp[i-1][j];
                if(nums[i-1]<=j){
                    int currNum = nums[i-1];
                    dp[i][j] +=dp[i-1][j-currNum];
                }
            }

        }
        return dp[len][neg];
        */
        //相比于使用二维数组，可以使用一维数组，因为后一行的数据只和前一行相关，所以可以使用一维数组，滚动起来即可
        int[] dp = new int[neg+1];
        dp[0] = 1;
        for(int num:nums){
            for(int j = neg;j>=num;j--){
                dp[j] += dp[j-num];
            }
        }
        return dp[neg];

    }
    @Test
    public void test(){
        int[] nums= new int[]{1,1,1,1,1};
        int target  = 3;
        System.out.println(findTargetSumWays(nums,target));
    }

}
