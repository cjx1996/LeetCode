package Models;
import All_Problems.TreeNode;

import java.util.ArrayDeque;
import java.util.LinkedList;

/**
 * @ClassName BT
 * @Description
 * @Author cjx
 * @Date 2022/8/6 14:43
 * @Version 1.0
 */
public class BT {
    public static void main(String[] args) {


        //表示这是一个二叉树
        TreeNode root=new TreeNode();
        //遍历过程
        LinkedList<Integer> ans=new LinkedList<>();
        ArrayDeque<TreeNode> stack=new ArrayDeque<>();
        if(root==null) return ;
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode cur=stack.pop();
            ans.addFirst(cur.val);
            if(cur.left!=null) stack.push(cur.left);
            if(cur.right!=null) stack.push(cur.right);
        }
        for (Integer val : ans) {
            System.out.println(val);
        }


        System.out.println("Hello world");
    }
    /*
    * 利用栈的后入先出的特性模拟二叉树的先序遍历，并通过数值的插入顺序调整为后序遍历的数值顺序
    *
    * */

}
