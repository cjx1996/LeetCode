package Coding_Interviews;

import All_Problems.TreeNode;

/**
 * @ClassName Offer55_II_Balanced_Binary_Tree
 * @Description
 * @Author cjx
 * @Date 2022/5/5 17:30
 * @Version 1.0
 */
public class Offer55_II_Balanced_Binary_Tree {
    boolean flag=true;
    public boolean isBalanced(TreeNode root){
        depth(root);
        return flag;
    }
    int depth(TreeNode node){
        if(node==null) return 0;
        int left=depth(node.left),right=depth(node.right);
        if(Math.abs(left-right)>1) flag=false;
        return Math.max(left,right)+1;
    }

}
