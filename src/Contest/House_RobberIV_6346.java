package Contest;

import org.junit.Test;

/**
 * @ClassName House_RobberIV_6346
 * @Description
 * @Author cjx
 * @Date 2023/2/5 10:55
 * @Version 1.0
 */
public class House_RobberIV_6346 {
    @Test
    public void test(){
        int[] nums=new int[]{2,7,9,3,1};
        int k = 2;
        System.out.println(minCapability(nums,k));
    }
    public int minCapability(int[] nums,int k){
        int max=0;
        for(int num:nums) max=Math.max(max,num);
        int l=0,r=max;
        while(l<r){
            int mid=l+(r-l)/2;
            if(ifMatch(nums,mid,k)){
                r=mid;
            }else l=mid+1;
        }
        return l;
    }
    public boolean ifMatch(int[] nums,int target,int k){
        int n = nums.length;
        int cnt=0;
        for(int i=0;i<n;i++){
            if(nums[i]<=target) {
                cnt++;
                if(cnt>=k) return true;
                i++;
            }
        }
        return false;

    }
}
