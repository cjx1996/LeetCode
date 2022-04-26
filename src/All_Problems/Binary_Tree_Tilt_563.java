package All_Problems;

/**
 * @ClassName Binary_Tree_Tilt
 * @Description
 * @Author cjx
 * @Date 2021/11/19 11:35
 * @Version 1.0
 */
public class Binary_Tree_Tilt_563 {
    int sum = 0;
    public int findTilt(TreeNode root){
       dfs(root);
       return sum;
    }
    int dfs(TreeNode root){
        if(root==null) return 0;
        int left_sum = dfs(root.left);
        int right_sum = dfs(root.right);
        sum +=Math.abs(left_sum-right_sum);
        return left_sum+right_sum+root.val;
    }
}
