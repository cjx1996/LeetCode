import org.junit.Test;

import java.util.Arrays;

/**
 * @ClassName Frequency_of_the_Most_Frequent_Element_1838
 * @Description
 * @Author cjx
 * @Date 2021/7/19 17:41
 * @Version 1.0
 */
public class Frequency_of_the_Most_Frequent_Element_1838 {
    @Test
    public void test(){
        int[] nums= new int[]{1,4,8,13};
        System.out.println(maxFrequency(nums,5));
    }
    public int maxFrequency(int[] nums,int k){
        Arrays.sort(nums);
        int len = nums.length;
        int ans = 1;
        int l=0,r=1;
        int count=0;
        while(r<len){
            count +=(r-l)*(nums[r]-nums[r-1]);
            while(count>k){
                l++;
                count -=(nums[r]-nums[l-1]);
            }
            ans = Math.max(ans,r-l+1);
            r++;
        }
        return ans;
    }
}
