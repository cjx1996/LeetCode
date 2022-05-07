package Coding_Interviews;


/**
 * @ClassName Offer36_BinarySearchTree_DequeLinkedList
 * @Description
 * @Author cjx
 * @Date 2022/4/28 16:08
 * @Version 1.0
 */
public class Offer36_BinarySearchTree_DequeLinkedList {
    Node head,pre;
    public Node treeToDoublyList(Node root){
        if(root==null) return null;
        dfs(root);
        head.left=pre;
        pre.right=head;
        return head;
    }
    public void dfs(Node node){
        if(node==null) return;
        dfs(node.left);
        if(pre==null) head=node;
        else pre.right=node;
        node.left=pre;
        pre=node;
        dfs(node.right);
        return;
    }
/*
    public Node treeToDoublyList(Node root) {
        if (root == null) return null;
        Node last=convertNode(root);
        Node first=last;
        while(first.left!=null) first=first.left;
        first.left=last;
        last.right=first;
        return first;
    }

    public Node convertNode(Node node) {
        if (node == null) return null;
        Node leftLast = convertNode(node.left);
        if(leftLast!=null){
            leftLast.right = node;
        }
        node.left = leftLast;
        Node rightLast = convertNode(node.right);
        Node rightFirst = rightLast;
        while (rightFirst!=null&&rightFirst.left != null) {
            rightFirst = rightFirst.left;
        }
        node.right = rightFirst;
        if(rightFirst!=null){
            rightFirst.left = node;
            return rightLast;
        }
        return node;
    }

*/
}
