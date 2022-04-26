package Coding_Interviews;

import org.junit.Test;

import java.util.HashMap;

/**
 * @ClassName Offer03_duplicated_number_in_array
 * @Description TODO
 * @Author cjx
 * @Date 2021/4/9 16:38
 * @Version 1.0
 */
public class Offer03_duplicated_number_in_array {
    public int findRepeatNumbe2(int[] nums){

        int temp;
        for (int i = 0; i < nums.length; i++) {
            while(i!=nums[i]){
                if(nums[i]==nums[nums[i]]){
                    return nums[i];
                }else{
                    temp=nums[i];
                    nums[i]=nums[temp];
                    nums[temp]=temp;
                }
            }
        }
        return -1;
    }
    public int findRepeatNumber1(int[] nums){


        HashMap<Integer, Integer> numCount = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer count = numCount.get(nums[i]);
            if(count==null){
                numCount.put(nums[i],1);
            }else{
                return nums[i];
            }
        }
        return -1;

    }

    @Test
    public void test(){
        int[] nums={2,3,1,0,2,5,3};
        int i = findRepeatNumbe2(nums);
        System.out.println(i);
    }
}
