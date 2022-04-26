package All_Problems;

/**
 * @ClassName Remove_Element_27
 * @Description
 * @Author cjx
 * @Date 2021/5/27 18:45
 * @Version 1.0
 */
public class Remove_Element_27 {
    public int removeElement(int[] nums,int val){
        int slow=0;
        for(int fast=0;fast<nums.length;fast++){
            if(nums[fast]!=val)
                nums[slow++]=nums[fast];
        }
        return slow;
    }
}
