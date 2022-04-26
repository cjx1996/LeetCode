package All_Problems;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Binary_Tree_Right_Side_View_199
 * @Description
 * @Author cjx
 * @Date 2022/4/15 9:52
 * @Version 1.0
 */
public class Binary_Tree_Right_Side_View_199 {
    public List<Integer> rightSideView(TreeNode root){
        List<Integer> ans = new ArrayList<>();
        ArrayDeque<TreeNode> q = new ArrayDeque<>();
        if(root!=null)q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            ans.add(q.peek().val);
            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                if(cur.right!=null) q.add(cur.right);
                if(cur.left!=null) q.add(cur.left);
            }
        }
        return ans;
    }
}
