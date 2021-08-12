import org.junit.Test;

import java.util.Arrays;

/**
 * @ClassName Valid_Triangle_Number_611
 * @Description
 * @Author cjx
 * @Date 2021/8/4 17:24
 * @Version 1.0
 */
public class Valid_Triangle_Number_611 {

    @Test
    public void test(){
    int[] nums = new int[]{2,2,3,4};
        System.out.println(triangleNumber(nums));
    }
    public int triangleNumber(int[] nums){
        int ans = 0;
        Arrays.sort(nums);
        int len = nums.length;
        int i = 0;
        while(i<len&&nums[i]==0) i++;
        for (; i <len-2; i++) {
            int j = i+1,k=i+2;
            while(j<len-1){
                int target = nums[i]+nums[j];
                if(k==len||nums[k]>=target){
                    ans +=k-j-1;
                    j++;
                }else{
                    k++;
                }
            }

        }
        return ans;
    }
}
