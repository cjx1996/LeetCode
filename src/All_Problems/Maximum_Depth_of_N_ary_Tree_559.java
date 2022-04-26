package All_Problems;

import java.util.List;

/**
 * @ClassName Maximum_Depth_of_N_ary_Tree_559
 * @Description
 * @Author cjx
 * @Date 2021/11/22 16:58
 * @Version 1.0
 */
public class Maximum_Depth_of_N_ary_Tree_559 {
    public int maxDepth(Node root){
        if(root==null) return 0;
        int depth =0;
        for(Node child:root.children){
            depth = Math.max(depth,maxDepth(child));
        }
        return depth+1;
    }
    private class Node{
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
