import org.junit.Test;

/**
 * @ClassName Binary_Tree_Maximum_Path_Sum_124
 * @Description
 * @Author cjx
 * @Date 2022/4/15 11:35
 * @Version 1.0
 */
public class Binary_Tree_Maximum_Path_Sum_124 {

    int maxPath = -1001;

    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxPath;
    }

    int maxGain(TreeNode node) {
        if (node == null) return 0;
        int left = maxGain(node.left);
        int right = maxGain(node.right);
        int sum = node.val;
        if (left > 0) sum += left;
        if (right > 0) sum += right;
        maxPath = Math.max(maxPath, sum);
        return Math.max(node.val, node.val + Math.max(left, right));
    }

}
