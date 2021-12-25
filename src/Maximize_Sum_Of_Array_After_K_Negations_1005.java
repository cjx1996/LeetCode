import java.util.Arrays;

/**
 * @ClassName Maximize_Sum_Of_Array_After_K_Negations_1005
 * @Description sort
 * @Author cjx
 * @Date 2021/12/3 13:40
 * @Version 1.0
 */
public class Maximize_Sum_Of_Array_After_K_Negations_1005 {
    public int largestSumAfterKNegations(int[] nums, int k) {
        int[] cnt = new int[201];
        for (int num : nums) cnt[num+100]++;
        for(int i = 0;i<=100;i++){
            if(k!=0){
                int tem  = Math.min(cnt[i],k);
                cnt[i] -=tem;
                cnt[200-i]+=tem;
                k -=tem;
            }
        }
        if(k>0&&k%2==1){
            int i  = 100;
            while(cnt[i]==0) i++;
            cnt[i]--;
            cnt[200-i]++;
        }
        int ans = 0;
        for (int i = 0; i < 201; i++) {
            ans +=(i-100)*cnt[i];
        }
        return ans;
    }
}
