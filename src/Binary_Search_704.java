/**
 * @ClassName Binary_Search_704
 * @Description
 * @Author cjx
 * @Date 2021/8/6 18:34
 * @Version 1.0
 */
public class Binary_Search_704 {
    public int search(int[] nums,int target){
        int low = 0;
        int high = nums.length-1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(nums[mid] == target) {
                return mid;
            }else if(nums[mid]<target){
                low = mid+1;
            }else if(nums[mid]>target){
                high = mid-1;
            }
        }
        return -1;
    }
}
