import java.util.*;

/**
 * @ClassName All_Nodes_Distance_K_in_Binary_Tree_863
 * @Description
 * @Author cjx
 * @Date 2021/7/28 22:05
 * @Version 1.0
 */
public class All_Nodes_Distance_K_in_Binary_Tree_863 {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, TreeNode> parents = new HashMap<>();
        mapParents(parents, root);
        List<Integer> ans = new ArrayList<>();
        Set<TreeNode> used = new HashSet<>();
        mapParents(parents, root);
        dfs(parents, used, target, ans, k);
        return ans;

    }

    //对二叉树建立由子节点可以查询父节点的Hash表
    void mapParents(Map<TreeNode, TreeNode> parents, TreeNode root) {
        if (root == null) return;
        if (root.left != null) {
            parents.put(root.left, root);
            mapParents(parents, root.left);
        }
        if (root.right != null) {
            parents.put(root.right, root);
            mapParents(parents, root.right);
        }
    }

    void dfs(Map<TreeNode, TreeNode> parents, Set<TreeNode> used, TreeNode root, List<Integer> ans, int distance) {
        if (root != null && !used.contains(root)) {
            used.add(root);
            if (distance == 0) {
                ans.add(root.val);
                return;
            }
            dfs(parents, used, root.left, ans, distance - 1);
            dfs(parents, used, root.right, ans, distance - 1);
            dfs(parents, used, parents.get(root), ans, distance - 1);
        }

    }
}
