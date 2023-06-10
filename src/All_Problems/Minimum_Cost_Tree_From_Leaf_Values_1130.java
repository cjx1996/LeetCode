package All_Problems;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @ClassName Minimum_Cost_Tree_From_Leaf_Values_1130
 * @Description TODO 单调栈的证明过程没有写完，后面记得分析一下
 * @Author cjx
 * @Date 2023/5/31 22:19
 * @Version 1.0
 */
public class Minimum_Cost_Tree_From_Leaf_Values_1130 {
    @Test
    public void test() {
        int[] arr = new int[]{4, 11};
        System.out.println(mctFromLeafValues(arr));
    }

    //单调栈算法
    //先进行一个简单证明，对于三个相邻元素x,y,z，如果x>y<z，那么考虑y的合并问题，无论对x/z如何处理，与y合并的值都不可能小于min(x,z)，
    //那么对于y来说，最小代价就是与x或者z进行合并。

    public int mctFromLeafValues(int[] arr) {
        int ans = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i : arr) {
            if (!stack.isEmpty() && stack.peek() <= i) {
                int x = stack.pop();
                while (!stack.isEmpty() && stack.peek() <= i) {
                    int y = stack.pop();
                    ans += x * y;
                    x = y;
                }
                if (x > i) {
                    stack.push(x);
                } else ans += x * i;
            }
            stack.push(i);
        }
        if (stack.size() < 2) return ans;
        else {
            int x = stack.pop();
            while (!stack.isEmpty()) {
                int y = stack.pop();
                ans += x * y;
                x = y;
            }
        }
        return ans;
    }



/*

    //dp算法，时间复杂地O(n^2)
    public int mctFromLeafValues(int[] arr){
        int n = arr.length;
        int[][] max=new int[n][n];
        for (int i = 0; i < n; i++) {
            max[i][i]=arr[i];
        }
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                max[i][j]=Math.max(max[i][j-1],arr[j]);
            }
        }
        int[][] dp=new int[n][n];
        for (int i = n-1; i >=0 ; i--) {
            for(int j=i+1;j<n;j++){
                dp[i][j]=dp[i][j-1]+arr[j]*max[i][j-1];
                for(int k=i;k<j;k++){
                    dp[i][j]=Math.min(dp[i][j],max[i][k]*max[k+1][j]+dp[i][k]+dp[k+1][j]);
                }
            }
        }
        return dp[0][n-1];
    }

*/
}
