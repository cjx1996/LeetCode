package All_Problems;

/**
 * @ClassName Populating_Next_Right_Pointers_in_Each_Node_116
 * @Description
 * @Author cjx
 * @Date 2021/8/13 19:39
 * @Version 1.0
 */
public class Populating_Next_Right_Pointers_in_Each_Node_116 {

    public Node connect(Node root) {
        if (root == null) return root;
        if (root.left == null ) return root;
       if(root.left!=null){
           root.left.next=root.right;
       }
       if(root.right!=null&&root.next!=null){
           root.right.next=root.next.left;
       }
       if(root.left!=null){
           connect(root.left);
           connect(root.right);
       }
        return root;
    }


}
