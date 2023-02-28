package Contest;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName CountGoodSubarrays_6293
 * @Description
 * @Author cjx
 * @Date 2023/1/15 10:57
 * @Version 1.0
 */
public class CountGoodSubarrays_6293 {
    @Test
    public void test(){
        int[] nums=new int[]{2,3,3,3,3,1,3,1,3,2};
        int k = 19;
        System.out.println(countGood(nums,k));
    }
    public long countGood(int[] nums,int k){
        long ans=0;
        int n = nums.length;
        int count=0;
        Map<Integer,Integer> map=new HashMap<>();
        for(int l=0,r=0;r<n||count>=k;l++){
            while(count<k&&r<n){
                int num = nums[r++];
                count+=map.getOrDefault(num,0);
                map.put(num,map.getOrDefault(num,0)+1);
            }
           if(count>=k) ans+=n-r+1;
            int num=nums[l];
            count-=map.get(num)-1;
            map.put(num,map.get(num)-1);
        }
        return ans;
    }

}
