package Coding_Interviews;

import All_Problems.TreeNode;

/**
 * @ClassName Offer27_MirrorTree
 * @Description
 * @Author cjx
 * @Date 2022/4/26 21:26
 * @Version 1.0
 */
public class Offer27_MirrorTree {
    public TreeNode mirrorTree(TreeNode root){
        if(root!=null) {
            TreeNode n2=root.left;
            TreeNode n1=root.right;
            root.right=n2;
            root.left=n1;
            mirrorTree(root.left);
            mirrorTree(root.right);
        }
        return root;
    }

}
