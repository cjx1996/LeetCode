package All_Problems;

/**
 * @ClassName Merge_Two_Binary_Trees_617
 * @Description
 * @Author cjx
 * @Date 2021/8/13 17:44
 * @Version 1.0
 */
public class Merge_Two_Binary_Trees_617 {
    public TreeNode mergeTrees(TreeNode root1,TreeNode root2){
        if(root1==null) return root2;
        if(null!=root1&&null!=root2){
            root1.val +=root2.val;
            root1.left=mergeTrees(root1.left,root2.left);
            root1.right=mergeTrees(root1.right,root2.right);
        }
        return root1;
    }
}
