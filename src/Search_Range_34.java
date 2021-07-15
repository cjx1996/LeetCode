import org.junit.Test;

/**
 * @ClassName Search_Range_34
 * @Description TODO
 * @Author cjx
 * @Date 2021/6/9 23:10
 * @Version 1.0
 */
public class Search_Range_34 {
    public int[] searchRange(int[] nums, int target) {

        int len = nums.length;

        if(len==0||target>nums[len-1]||target<nums[0]) return new int[]{-1,-1};

        int sta = -1, end = -1;

        int l = 0, r = len-1;
        while(l<r){
            int mid = (l+r)>>1;
            if(nums[mid]>=target){
                r = mid;
            }else{
                l = mid+1;
            }
        }
        if(l==r &&target==nums[l]) sta = l;


        l = 0;
        r=len-1;
        while (l < r) {
            int mid = (l + r +1) >> 1;
            if (nums[mid] <= target) {
                l = mid;
            } else {
                r = mid -1;
            }
        }
        if(l == r && target==nums[l]) end = l;

        return new int[]{sta,end};

    }
    @Test
    public void test(){
        int[] nums = new int[]{5,7,7,8,8,10};
        int target = 0;
        int[] result = searchRange(nums,target);
        for (int num : result) {
            System.out.println(num);
        }
    }
}
