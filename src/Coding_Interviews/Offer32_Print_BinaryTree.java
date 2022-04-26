package Coding_Interviews;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import All_Problems.TreeNode;

/**
 * @ClassName Offer32_Print_BinaryTree
 * @Description
 * @Author cjx
 * @Date 2022/4/26 16:41
 * @Version 1.0
 */
public class Offer32_Print_BinaryTree {
    public int[] levelOrder(TreeNode root) {
        if(root==null) return new int[0];
        List<Integer> list =new ArrayList<>();
        Deque<TreeNode> q= new ArrayDeque<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                list.add(node.val);
                if(node.left!=null) q.add(node.left);
                if(node.right!=null) q.add(node.right);
            }
        }
        return list.stream().mapToInt(Integer::valueOf).toArray();
    }
}
