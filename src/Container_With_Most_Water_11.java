import org.junit.Test;

/**
 * @ClassName Container_With_Most_Water_11
 * @Description
 * @Author cjx
 * @Date 2021/7/18 22:33
 * @Version 1.0
 */
public class Container_With_Most_Water_11 {
    @Test
    public void test(){
        int[] height= new int[]{1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }
    public int maxArea(int[] height){
        int len = height.length;
        int left = 0;
        int right = len-1;
        int ans=0;
        while(left<right){
            int curr = (right-left)*Math.min(height[left],height[right]);
            ans = Math.max(curr,ans);
            if(height[left]>height[right]){
                right--;
            }else if(height[left]<height[right]){
                left++;
            }else{
                left++;
                right--;
            }
        }
        return ans;
    }
}
