package Coding_Interviews;

/**
 * @ClassName Offer11_Minimum_in_Rotated_Array
 * @Description 旋转数组，数组中有重复元素
 * @Author cjx
 * @Date 2022/4/26 15:50
 * @Version 1.0
 */
public class Offer11_Minimum_in_Rotated_Array {
    public int minArray(int[] nums){
        int l=0,r=nums.length-1;
        while(l<r){
            int mid = l+(r-l)/2;
            if(nums[l]<nums[r]) return nums[l];
            if(nums[mid]==nums[l]) l++;
            else if(nums[mid]>nums[l]){
                l =mid+1;
            }else r=mid;
        }
        return nums[l];
    }

}
