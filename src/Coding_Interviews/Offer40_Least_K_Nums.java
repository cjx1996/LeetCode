package Coding_Interviews;

import org.junit.Test;

import java.util.Arrays;

/**
 * @ClassName Offer40_Least_K_Nums
 * @Description
 * @Author cjx
 * @Date 2022/5/5 10:40
 * @Version 1.0
 */
public class Offer40_Least_K_Nums {
    @Test
    public void test(){
        int[] arr=new int[]{0,0,1,2,4,2,2,3,1,4};
        int k  =8;
        int[] ans = getLeastNumbers(arr,k);
        for (int i : ans) {
            System.out.println(i);
        }
    }
    public int[] getLeastNumbers(int[] arr, int k) {

        if(k==0) return new int[0];
        quickSort(arr,0,arr.length-1,k);
        return Arrays.copyOf(arr,k);
    }
    void quickSort(int[] nums,int l,int r,int k){
        if(r==k-1||l>=r) return;
        int key = nums[l];
        int i = l,j=r;
        while(i<j){
            while(i<j&&nums[j]>key)j--;
            while(i<j&&nums[i]<=key) i++;
            if(i<j){
                int tem=nums[i];
                nums[i]=nums[j];
                nums[j]=tem;
            }
        }
        nums[l]=nums[i];
        nums[i]=key;
        if(i==k-1) return;
        if(i<k-1) quickSort(nums,i+1,r,k);
        else quickSort(nums,l,i-1,k);
    }

}
