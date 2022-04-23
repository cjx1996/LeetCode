import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName N_ary_Tree_Level_Order_Traversal_429
 * @Description
 * @Author cjx
 * @Date 2022/4/8 9:35
 * @Version 1.0
 */
public class N_ary_Tree_Level_Order_Traversal_429 {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        ;

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        ArrayDeque<Node> q = new ArrayDeque<>();
        q.add(root);
        while (!q.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int n = q.size();
            for (int i = 0; i < n; i++) {
                Node node = q.poll();
                list.add(node.val);
                for (Node child : node.children) {
                    q.add(child);
                }
            }
            ans.add(list);
        }
        return ans;
    }
    @Test
    public void test(){
        int a = 0xfffffff;
        System.out.println(Integer.MAX_VALUE);
        System.out.println(a);
    }
}
