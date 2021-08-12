


/**
 * @ClassName Second_Minimum_Ｎode_In_a_Binary_Tree
 * @Description
 * @Author cjx
 * @Date 2021/7/27 11:37
 * @Version 1.0
 */
public class Second_Minimum_Ｎode_In_a_Binary_Tree_671 {
    public int findSecondMinimumValue(TreeNode root) {
        if(root.left!=null&&root.right!=null){
                int left = (root.left.val>root.right.val)?root.left.val:findSecondMinimumValue(root.left);
                int right= (root.left.val<root.right.val)?root.right.val:findSecondMinimumValue(root.right);
                if(left==-1&&right==-1){
                    return -1;
                }else if(left==-1||right==-1){
                    return Math.max(left,right);
                }else{
                    return Math.min(left,right);
                }
        }else if(root.left!=null||root.right!=null){
            return findSecondMinimumValue(root.left==null?root.right:root.left);
        }else{
            return -1;
        }
    }
}


