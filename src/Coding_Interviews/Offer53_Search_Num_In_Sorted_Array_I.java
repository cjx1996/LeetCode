package Coding_Interviews;

/**
 * @ClassName Offer53_Search_Num_In_Sorted_Array_I
 * @Description
 * @Author cjx
 * @Date 2022/4/26 14:55
 * @Version 1.0
 */
public class Offer53_Search_Num_In_Sorted_Array_I {
    public int search(int[] nums,int target){
        int n = nums.length;
        if(n==0||nums[0]>target||nums[n-1]<target) return 0;
        int start = -1,end =-1;
        int l  =0,r=n-1;
        while(l<r){
            int mid = l+(r-l)/2;
            if(nums[mid]>=target){
                r=mid;
            }else{
                l=mid+1;
            }
        }
        if(nums[l]!=target) return 0;
        else start = l;
        r=n-1;
        while(l<r){
            int mid = l+(r-l+1)/2;
            if(nums[mid]<=target){
                l=mid;
            }else{
                r=mid-1;
            }
        }
        end=l;
        return end-start+1;
    }

}
