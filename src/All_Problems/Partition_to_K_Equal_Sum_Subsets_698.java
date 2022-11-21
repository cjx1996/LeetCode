package All_Problems;

import org.junit.Test;

import java.util.Arrays;

/**
 * @ClassName Partition_to_K_Equal_Sum_Subsets_698
 * @Description
 * @Author cjx
 * @Date 2022/6/1 15:33
 * @Version 1.0
 */
public class Partition_to_K_Equal_Sum_Subsets_698 {
    @Test
    public void test() {
        int[] nums = new int[]{4, 3, 2, 3, 5, 2, 1};
        int k = 4;
        System.out.println(canPartitionKSubsets(nums, k));
    }

    int n,k,p;
    int[] nums;
    public boolean canPartitionKSubsets(int[] _nums, int _k) {
        nums=_nums;
        n=nums.length;
        k=_k;
        if(k==1) return true;
        int sum=Arrays.stream(nums).sum();
        if(sum%k!=0) return false;
        p=sum/k;
        if(nums[n-1]>k)return false;
        Arrays.sort(nums);
        return dfs(n-1,0,0,new boolean[n]);
    }
    boolean dfs(int index,int sum,int cnt,boolean[] vis){
        if(cnt==k) return true;
        if(sum==p) return dfs(n-1,0,cnt+1,vis);
        for(int i=index;i>=0;i--){//顺序性剪枝
            if(vis[i]||sum+nums[i]>p) continue;//可行性剪枝
            vis[i]=true;
            if(dfs(i-1, sum+nums[i],cnt ,vis )) return true;
            vis[i]=false;
            if(sum==0) return false;//可行性剪枝
        }
        return false;
    }



    /*
    public boolean canPartitionKSubsets(int[] nums, int k) {
        if (k == 1) return true;
        int sum = Arrays.stream(nums).sum();
        if (sum % k != 0) return false;
        int par = sum / k;
        int len = nums.length;
        Arrays.sort(nums);
        if (nums[len - 1] > par) return false;
        int n = 1 << len;
        boolean[] dp = new boolean[n];
        int[] mod = new int[n];
        dp[0] = true;
        for (int i = 0; i < n; i++) {
            if (!dp[i]) continue;
            for (int j = 0; j < len; j++) {
                if (mod[i] + nums[j] > par) break;
                if (((i >> j) & 1) == 0) {
                    int next = i | (1 << j);
                    if (!dp[next]) {
                        mod[next] = (mod[i] + nums[j]) % par;
                        dp[next] = true;
                    }
                }
            }
        }
        return dp[n - 1];
    }
*/




}

