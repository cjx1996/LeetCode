package Coding_Interviews;

import All_Problems.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Offer34_PathSum
 * @Description
 * @Author cjx
 * @Date 2022/4/28 14:09
 * @Version 1.0
 */
public class Offer34_PathSum {
    @Test
    public void test() {


    }

    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        if (root == null) return ans;
        backTrack(root, target, new ArrayList<>());
        return ans;
    }

    public void backTrack(TreeNode node, int target, List<Integer> list) {
        if (node == null) return;
        list.add(node.val);
        if (node.val == target && node.left == null && node.right == null) {
            List<Integer> newList = new ArrayList<>(list);
            ans.add(newList);
            list.remove(list.size() - 1);
            return;
        } else {
            if (node.left != null) {
                backTrack(node.left, target - node.val, list);
            }
            if (node.right != null) {
                backTrack(node.right, target - node.val, list);
            }
        }
        list.remove(list.size() - 1);
        return;
    }
}
