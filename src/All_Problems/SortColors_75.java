package All_Problems;

import org.junit.Test;

import java.util.Arrays;

/**
 * @ClassName SortColors_75
 * @Description
 * @Author cjx
 * @Date 2022/11/29 17:27
 * @Version 1.0
 */
public class SortColors_75 {
    @Test
    public void test(){
        int[] nums=new int[]{2,2,1,0,1,0};
        sortColors(nums);
        Arrays.stream(nums).forEach(System.out::println);
    }
    public void sortColors(int[] nums){
        int n = nums.length;
        int l=0,r=n-1,i=0;
/*        while(i<=r){
            if(nums[i]==0){
                nums[i]=nums[l];
                nums[l++]=0;
            }else if(nums[i]==2){
                nums[i]=nums[r];
                nums[r--]=2;
            }else i++;
            if(i<=l) i=l;
        }*/
        for(i=0;i<=r;i++){
            while(i<=r&&nums[i]==2){
                nums[i]=nums[r];
                nums[r--]=2;
            }
            if(nums[i]==0){
                nums[i]=nums[l];
                nums[l++]=0;
            }
        }
    }
}
