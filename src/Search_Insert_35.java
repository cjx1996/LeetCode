import org.junit.Test;

/**
 * @ClassName Search_Insert_35
 * @Description
 * @Author cjx
 * @Date 2021/6/8 23:18
 * @Version 1.0
 */
public class Search_Insert_35 {
    @Test
    public void test() {
        int[] nums = new int[]{1, 3, 5, 6};
        System.out.println(searchInsert(nums, 0));
    }

    public int searchInsert(int[] nums, int target) {
       int low = 0;
       int high = nums.length-1;
       while(low<=high){
           int mid = low+(high-low)/2;
           if(nums[mid]<target){
               low = mid+1;
           }else{
               high = mid-1;
           }
       }
       return low;
    }
}
