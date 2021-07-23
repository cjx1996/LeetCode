import org.junit.Test;

/**
 * @ClassName SearchInRotatedSortedArray_33
 * @Description TODO
 * @Author cjx
 * @Date 2021/4/7 16:44
 * @Version 1.0
 */
public class SearchInRotatedSortedArray_33 {

    /**
     * 数组中的值互不相同
     *
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {

        int n = nums.length;
        if(n==0) return -1;
        if(n==1) return (nums[0]==target)?0:-1;
        int l =0,r=n-1;
        while(l<=r){
            int mid = l+(r-l)/2+1;
            if(target==nums[mid]) return mid;
            if(nums[mid]>=nums[l]){
                if(target>=nums[l]&&target<nums[mid]) r=mid-1;
                else{
                    l = mid+1;
                }
            }else{
                if(target>nums[mid]&&target<=nums[r]){
                    l = mid+1;
                }else{
                    r=mid-1;
                }
            }
        }
        return -1;

    };



    @Test
    public void test() {
        int[] nums = {3,1};
        int target = 1;
        int index = search(nums, target);
        System.out.println(index);
    }

}
