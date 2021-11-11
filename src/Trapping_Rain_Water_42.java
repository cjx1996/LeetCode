import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Trapping_Rain_Water_42
 * @Description
 * @Author cjx
 * @Date 2021/8/20 15:59
 * @Version 1.0
 */
public class Trapping_Rain_Water_42 {
    public int trap(int[] height) {
        int ans=0;
        int len = height.length;
        int[] max_left= new int[len];
        int[] max_right= new int[len];
        max_left[0] = height[0];
        max_right[len-1] = height[len-1];
        for (int i = 1; i < len; i++) {
            max_left[i] = Math.max(height[i],max_left[i-1]);
            max_right[len-1-i] = Math.max(max_right[len-i],height[len-1-i]);
        }
        for (int i = 1; i < len - 1; i++) {
            ans +=Math.min(max_left[i],max_right[i])-height[i];
        }
        return ans;
    }
}
