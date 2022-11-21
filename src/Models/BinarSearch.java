package Models;

import org.junit.Test;

/**
 * @ClassName BinarSearch
 * @Description
 * @Author cjx
 * @Date 2022/9/24 20:39
 * @Version 1.0
 */

public class BinarSearch {
    @Test
    public void test(){
        int[] nums =new int[]{1,2,3};
        int target =4;
        System.out.println(search(nums,target));
    }
    public int search(int[] nums,int target){
        int n =nums.length;
        return binarySearch(nums,0,n-1,target);
    }
    static public int binarySearch(int[] nums,int left,int right,int target){
        if(left>right) return -1;
        int mid = left+((right-left)>>1);
        if(target>nums[mid]) return binarySearch(nums,mid+1,right,target);
        else if(target<nums[mid]) return binarySearch(nums,left,mid-1,target);
        else return mid;
    }
}
