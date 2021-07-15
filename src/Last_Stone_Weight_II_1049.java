import org.junit.Test;

/**
 * @ClassName Last_Stone_Weight_II_1049
 * @Description TODO
 * @Author cjx
 * @Date 2021/6/8 22:51
 * @Version 1.0
 */
public class Last_Stone_Weight_II_1049 {
    public int lastStoneWeightII(int[] stones){
        int len = stones.length;
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += stones[i];
        }
        int target = sum>>1;
        /*
        //创建dp数组，dp[i][j]表示前i块石头中，任意块和最接近j的是多少
        int[][] dp = new int[len + 1][target + 1];
        //初始化dp
        //定义转移方程
        for (int i = 1; i <len+1; i++) {
            int weight = stones[i-1];
            for(int j = 0;j <target+1; j++){
                if(weight>j){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = Integer.max(dp[i-1][j],weight+dp[i-1][j-weight]);
                }
            }
        }
        target =  dp[len][target];
        */
        //创建一维dp数组
        int[] dp = new int[target+1];
        for (int stone : stones) {
            for(int j = target;j >=1; j--){
                if(j>= stone){
                    dp[j] = Integer.max(dp[j],stone+dp[j-stone]);
                }
            }
        }
        target = dp[target];

        return Math.abs(sum-2*target);
    }
    @Test
    public void test(){
        int[] stones = new int[]{31,26,33,21,40};
        System.out.println(lastStoneWeightII(stones));
    }
}
