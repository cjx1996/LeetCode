package All_Problems;

import org.junit.Test;

/**
 * @ClassName Num_Subarray_Bounder_Max_795
 * @Description
 * @Author cjx
 * @Date 2022/11/24 10:56
 * @Version 1.0
 */
public class Num_Subarray_Bounder_Max_795 {
    @Test
    public void test(){
        int[] nums=new int[]{2,1,4,3};
        System.out.println(numSubarrayBoundedMax(nums,2,3));
    }
    public int count(int[] nums,int lower){
        int ans=0,cnt=0;
        for (int num : nums) {
            ans+=num<=lower?(++cnt):(cnt=0);
        }
        return ans;
    }

    public int numSubarrayBoundedMax(int[] nums,int left,int right){
        return count(nums,right)-count(nums,left-1);
    }
/* 第二种方法
    public int numSubarrayBoundedMax(int[] nums,int left,int right){
        int n=nums.length;
        int ans=0;
        int lPos=-1;
        int rPos=-1;
        for (int i = 0; i < n; i++) {
            if(nums[i]>=left&&nums[i]<=right){
                rPos=i;
            }else if(nums[i]>right){
                lPos=i;
                rPos=-1;
            }
            if(rPos!=-1){
                ans+=rPos-lPos;
            }
        }
        return ans;
    }
*/
}
