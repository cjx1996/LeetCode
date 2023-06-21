package All_Problems;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinPool;

/**
 * @ClassName Number_of_Unequal_Triplets_in_Array_2475
 * @Description
 * @Author cjx
 * @Date 2023/6/13 23:25
 * @Version 1.0
 */
public class Number_of_Unequal_Triplets_in_Array_2475 {
    @Test
    public void test(){
        int[] nums={4,4,2,4,3};
        System.out.println(unequalTriplets(nums));
    }
    public int unequalTriplets(int[] nums){
        int[] cnt=new int[1001];
        int sum=nums.length;
        Arrays.stream(nums).forEach(e->cnt[e]++);
        int ans=0;
        int pre=0;
        for (int i = 0; i < 1001; i++) {
            int cur=cnt[i];
            ans+=pre*cur*(sum-pre-cur);
            pre+=cur;
        }
        return ans;
    }

}
