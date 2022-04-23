import org.junit.Test;

/**
 * @ClassName Minimize_Result_6038
 * @Description
 * @Author cjx
 * @Date 2022/4/10 10:56
 * @Version 1.0
 */
public class Minimize_Result_6038 {
    @Test
    public void test() {
        String[] expressions = new String[]{"247+38",
                "12+34",
                "999+999"};
        for (String s : expressions) {
            System.out.println(minimizeResult(s));
        }
    }

    public String minimizeResult(String expression) {
        String[] nums = expression.split("\\+");
        int m = nums[0].length(), n = nums[1].length();
        int min = Integer.valueOf(nums[0]) + Integer.valueOf(nums[1]);
        int mMin = m - 1, nMin = n - 1;
        for (int i = 0; i < m ; i++) {
            int num1 =i==m-1?1: Integer.valueOf(nums[0].substring(0, m - 1 - i));
            int num2 = Integer.valueOf(nums[0].substring(m - 1 - i, m));
            for (int j = 0; j < n ; j++) {
                int num3 = Integer.valueOf(nums[1].substring(0,  j+1));
                int num4 =j==n-1?1:Integer.valueOf(nums[1].substring(j+1, n));
                if (num1 * (num2 + num3) * num4 < min) {
                    min = num1 * (num2 + num3) * num4;
                    mMin = i;
                    nMin = j;
                }
            }
        }
        StringBuilder sb = new StringBuilder(expression);
        sb.insert(m - mMin - 1, '(');
        sb.insert(m + 3 + nMin, ')');
        return sb.toString();

    }
}
