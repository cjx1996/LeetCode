package All_Problems;

import java.util.*;

/**
 * @ClassName Delete_Nodes_And_Return_Forest_1110
 * @Description
 * @Author cjx
 * @Date 2023/5/30 18:24
 * @Version 1.0
 */
public class Delete_Nodes_And_Return_Forest_1110 {

    List<TreeNode> ans;
    boolean[] exist=new boolean[1001];

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        ans = new ArrayList<>();
        Arrays.stream(to_delete).forEach(e->exist[e]=true);
        dfs(root, true);
        return ans;
    }

    void dfs(TreeNode node, boolean isRoot) {
        if (node == null) return;
        if(isRoot&&!exist[node.val]) ans.add(node);
        TreeNode left=node.left;
        TreeNode right=node.right;
        if(left!=null){
            if(exist[left.val]){
                node.left=null;
                dfs(left.left,true);
                dfs(left.right,true);
            }else{
                dfs(left,exist[node.val]);
            }
        }
        if(right!=null){
            if(exist[right.val]){
                node.right=null;
                dfs(right.right,true);
                dfs(right.left,true);
            }else{
                dfs(right,exist[node.val]);
            }
        }
    }
}
