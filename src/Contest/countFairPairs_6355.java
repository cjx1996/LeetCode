package Contest;

import org.junit.Test;

import java.util.Arrays;

/**
 * @ClassName countFairPairs_6355
 * @Description
 * @Author cjx
 * @Date 2023/2/12 11:04
 * @Version 1.0
 */
public class countFairPairs_6355 {
    @Test
    public void test(){
        int[] nums=new int[]{1,7,9,2,5};
        int lower=11;
        int upper=11;
        System.out.println(countFairPairs(nums,lower,upper));
    }
    public long countFairPairs(int[] nums, int lower, int upper) {
        long ans=0;
        Arrays.sort(nums);
        int n = nums.length;
        for(int i=0;i<n;i++){
            int num =nums[i];
            int l=findL(nums,lower-num,i);
            int r=findR(nums,upper-num,i);
            if(l!=-1&&r!=-1) ans+=r-l+1;
        }
        return ans;

    }
    int findL(int[] nums,int target,int start){
        int n = nums.length;
        int l=start+1,r=n-1;
        while(l<r){
            int mid=l+(r-l)/2;
            if(nums[mid]>=target)r=mid;
            else l=mid+1;
        }
        if(l<n&&nums[l]>=target) return l;
        else return -1;
    }
    int findR(int[] nums,int target,int start){
        int n = nums.length;
        int l=start+1,r=n-1;
        while(l<r){
            int mid=l+(r-l+1)/2;
            if(nums[mid]<=target)l=mid;
            else r=mid-1;
        }
        if(r<n&&nums[r]<=target) return r;
        else return -1;
    }
}
