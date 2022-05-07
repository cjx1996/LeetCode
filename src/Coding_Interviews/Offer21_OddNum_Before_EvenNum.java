package Coding_Interviews;

import org.junit.Test;

/**
 * @ClassName Offer21_OddNum_Before_EvenNum
 * @Description
 * @Author cjx
 * @Date 2022/4/27 22:07
 * @Version 1.0
 */
public class Offer21_OddNum_Before_EvenNum {
    @Test
    public void test(){
        int[] nums= new int[]{1,3,2,4};
        int[] res = exchange(nums);
        for (int i : res) {
            System.out.println(i);
        }
    }
    public int[] exchange(int[] nums){
        int n =nums.length;
        int l=0,r=n-1;
        while(l<r){
            while(l<n&&!isEven(nums[l]))l++;
            while(r>=0&&isEven(nums[r]))r--;
            if(l<r){
                int tem = nums[l];
                nums[l]=nums[r];
                nums[r]=tem;
                l++;
                r--;
            }
        }
        return nums;
    }
    boolean isEven(int n){
        return n%2==0;
    }

}
