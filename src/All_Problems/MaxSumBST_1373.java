package All_Problems;

/**
 * @ClassName MaxSumBST_1373
 * @Description
 * @Author cjx
 * @Date 2023/5/20 11:20
 * @Version 1.0
 */
public class MaxSumBST_1373 {

    public static final int MIN = Integer.MIN_VALUE;
    public static final int MAX = Integer.MAX_VALUE;
    public int ans = 0;

    public int maxSumBST(TreeNode root) {
        dfs(root);
        return ans;
    }

    public Info dfs(TreeNode node) {
        Info res = new Info();
        if (node == null) {
            res.maxLeft = MIN;
            res.minRight = MAX;
            return res;
        }
        Info left = dfs(node.left);
        Info right = dfs(node.right);
        if (left.isBST == false || right.isBST == false) {
            res.isBST = false;
            return res;
        }
        if (node.val <= left.maxLeft || node.val >= right.minRight) {
            res.isBST = false;
            return res;
        }
        res.minRight = left.minRight==MAX?node.val:left.minRight;
        res.maxLeft = right.maxLeft==MIN?node.val:right.maxLeft;
        res.sum = left.sum + right.sum + node.val;
        ans = Math.max(ans, res.sum);
        return res;
    }

}

class Info {
    int sum;
    boolean isBST = true;
    int maxLeft;
    int minRight;
}
