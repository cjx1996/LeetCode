package All_Problems;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Even_Odd_Tree_1609
 * @Description
 * @Author cjx
 * @Date 2021/12/25 14:51
 * @Version 1.0
 */
public class Even_Odd_Tree_1609 {
    public boolean isEvenOddTree(TreeNode root) {
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int level = -1;
        while (queue.size() != 0) {
            int len = queue.size();
            TreeNode preNode = queue.poll();
            int pre = preNode.val;
            if (-2 * (pre % 2) != (level - 1)) return false;
            if(preNode.left!=null) queue.add(preNode.left);
            if(preNode.right!=null) queue.add(preNode.right);
            for (int i = 1; i < len; i++) {
                TreeNode cur = queue.poll();
                if (-2 * (cur.val % 2) != (level - 1) || (level * (cur.val - pre) >= 0)) return false;

                if(cur.left!=null) queue.add(cur.left);
                if(cur.right!=null) queue.add(cur.right);
                pre= cur.val;
            }
            level *= -1;
        }
        return true;
    }
}
