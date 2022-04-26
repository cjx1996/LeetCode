package All_Problems;

import org.junit.Test;

/**
 * @ClassName Find_Peak_Element_162
 * @Description
 * @Author cjx
 * @Date 2021/7/17 12:08
 * @Version 1.0
 */
public class Find_Peak_Element_162 {
    @Test
    public void test(){
        int[] nums = new int[]{1,2,1};
        System.out.println(findPeakElement(nums));
    }
    public int findPeakElement(int[] nums){

        int l =0;
        int r= nums.length-1;
        if(r==0) return 0;
        if(r==1) return (nums[0]>nums[1])?0:1;
        while(l<r){
            int mid = l+(r-l)/2;
            if(mid==(nums.length-1)) return mid;

            //此处判断语句中的mid+1,与后面对l赋值mid+1存在对应关系
            //若判断语句中为mid-1，那后面赋值语句中也应该写mid-1，同时需要修改mid，后面应该+1
            if(nums[mid]>nums[mid+1]){
                r=mid;
            }else {
                l =mid+1;
            }
        }
        return l;
    }
}
