package All_Problems;

/**
 * @ClassName Optimal_Division_553
 * @Description
 * @Author cjx
 * @Date 2022/2/27 10:26
 * @Version 1.0
 */
public class Optimal_Division_553 {
    public String optimalDivision(int[] nums) {
        int n = nums.length;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(nums[i]);
            if (i != n - 1) sb.append("/");
        }
        if (n > 2) {
            sb.insert(sb.indexOf("/") + 1, '(');
            sb.append(")");
        }
        return sb.toString();
    }
}
