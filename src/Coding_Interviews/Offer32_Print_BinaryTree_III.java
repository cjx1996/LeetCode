package Coding_Interviews;


import All_Problems.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @ClassName Offer32_Print_BinaryTree
 * @Description
 * @Author cjx
 * @Date 2022/4/26 16:41
 * @Version 1.0
 */
public class Offer32_Print_BinaryTree_III {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root==null) return ans;
        Deque<TreeNode> queue= new ArrayDeque<>();
        Deque<TreeNode> stack=new ArrayDeque<>();
        queue.add(root);
        boolean flag = true;
        while(!queue.isEmpty()||!stack.isEmpty()){
            Deque<TreeNode> cur = flag?queue:stack;
            Deque<TreeNode> next= flag?stack:queue;
            next.clear();
            int size = cur.size();
            List<Integer> line = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = cur.pop();
                line.add(node.val);
                if(flag){
                    if(node.left!=null)  next.push(node.left);
                    if(node.right!=null)next.push(node.right);
                }else{
                    if(node.right!=null) next.push(node.right);
                    if(node.left!=null) next.push(node.left);
                }
            }
            flag=!flag;
            ans.add(line);
        }
        return ans;
    }
}
