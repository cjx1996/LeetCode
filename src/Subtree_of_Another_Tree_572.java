


/**
 * @ClassName Subtree_of_Another_Tree_572
 * @Description
 * @Author cjx
 * @Date 2021/7/22 23:22
 * @Version 1.0
 */
public class Subtree_of_Another_Tree_572 {

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) {
            return true;
        } else if (root == null || subRoot == null) {
            return false;
        }

        if (root.val == subRoot.val && isEqual(root.left, subRoot.left) && isEqual(root.right, subRoot.right)) {
            return true;
        }

        if (isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot)) {
            return true;
        }
        return false;
    }

    boolean isEqual(TreeNode root, TreeNode subRoot){
        if (root == null && subRoot == null) {
            return true;
        } else if (root == null || subRoot == null) {
            return false;
        }
        if(root.val==subRoot.val&&isEqual(root.left,subRoot.left)&&isEqual(root.right,subRoot.right)){
            return true;
        }
        return false;
    }



    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
