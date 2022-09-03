package All_Problems;

import java.util.Arrays;

/**
 * @ClassName Maximum_Binary_Tree_654
 * @Description
 * @Author cjx
 * @Date 2022/8/20 14:42
 * @Version 1.0
 */
public class Maximum_Binary_Tree_654 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        int l = 0, r = nums.length;
        int max = -1, idx = -1;
        for (int i = 0; i < r; i++) {
            if (nums[i] > max) {
                max = nums[i];
                idx = i;
            }
        }
        TreeNode node = new TreeNode(max);
        TreeNode left = null;
        TreeNode right = null;
        if (idx > 0) {
            left = constructMaximumBinaryTree(Arrays.copyOf(nums, idx));
        }
        if (idx < r - 1) {
            right = constructMaximumBinaryTree(Arrays.copyOfRange(nums, idx + 1, r));
        }
        node.left = left;
        node.right = right;
        return node;
    }

}
