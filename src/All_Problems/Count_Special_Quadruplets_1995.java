package All_Problems;

import org.junit.Test;

import java.util.Arrays;

/**
 * @ClassName Count_Special_Quadruplets_1995
 * @Description
 * @Author cjx
 * @Date 2021/12/29 11:55
 * @Version 1.0
 */
public class Count_Special_Quadruplets_1995 {
    @Test
    public void test() {
        int[] nums = new int[]{1, 2, 3, 6};
        System.out.println(countQuadruplets(nums));
    }

    public int countQuadruplets(int[] nums) {
      int len = nums.length;
      int[] cnt = new int[401];
      int ans= 0;
      for(int b=1;b<len-2;b++){
          for(int a=0;a<b;a++) cnt[nums[b]+nums[a]+200]++;
          for(int d= b+2;d<len;d++) ans+=cnt[nums[d]-nums[b+1]+200];
      }
      return ans;
    }
}
