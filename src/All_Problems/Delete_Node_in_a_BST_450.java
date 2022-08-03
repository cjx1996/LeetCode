package All_Problems;

/**
 * @ClassName Delete_Node_in_a_BST_450
 * @Description
 * @Author cjx
 * @Date 2022/6/2 23:24
 * @Version 1.0
 */
public class Delete_Node_in_a_BST_450 {
    public TreeNode deleteNode(TreeNode root,int key){
        if(root==null) return null;
        if (root.val == key) {
            if(root.left==null) return root.right;
            if(root.right==null) return root.left;
            TreeNode t=root.left;
            while(t.right!=null) t=t.right;
            t.right=root.right;
            return root.left;
        } else if (root.val > key) {
            root.left=deleteNode(root.left,key);
        }else if(root.val<key){
            root.right=deleteNode(root.right,key);
        }
        return root;
    }

}
