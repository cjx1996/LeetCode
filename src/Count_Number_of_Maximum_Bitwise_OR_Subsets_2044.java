/**
 * @ClassName Count_Number_of_Maximum_Bitwise_OR_Subsets_2044
 * @Description
 * @Author cjx
 * @Date 2022/3/15 9:24
 * @Version 1.0
 */
public class Count_Number_of_Maximum_Bitwise_OR_Subsets_2044 {
    public int countMaxOrSubsets(int[] nums){
        int n = nums.length;
        int max = 0;
        for (int i = 0; i < n; i++) {
            max |=nums[i];
        }
        int ans =0;
        int N = 1<<n;
        for (int i = 0; i < N; i++) {
            int cur = 0;
            for (int j = 0; j < n; j++) {
                if((i>>j&1)==1){
                    cur|=nums[j];
                }
            }
            if(cur==max) ans++;
        }
        return ans;
    }
}
