/**
 * @ClassName Search_in_a_Binary_Search_Tree_700
 * @Description
 * @Author cjx
 * @Date 2021/11/26 15:45
 * @Version 1.0
 */
public class Search_in_a_Binary_Search_Tree_700 {
    public TreeNode searchBST(TreeNode root, int val){
        while(root!=null){
            if(root.val==val){
                return root;
            }else if(root.val>val){
                root = root.left;
            }else root = root.right;
        }
        return null;
    }
}
