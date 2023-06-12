package All_Problems;

/**
 * @ClassName Kth_Ancestor_of_a_Tree_Node_1483
 * 给你一棵树，树上有 n 个节点，按从 0 到 n-1 编号。树以父节点数组的形式给出，其中 parent[i] 是节点 i 的父节点。树的根节点是编号为 0 的节点。
 *
 * 树节点的第 k 个祖先节点是从该节点到根节点路径上的第 k 个节点。
 *
 * 实现 TreeAncestor 类：
 *
 * TreeAncestor（int n， int[] parent） 对树和父数组中的节点数初始化对象。
 * getKthAncestor(int node, int k) 返回节点 node 的第 k 个祖先节点。如果不存在这样的祖先节点，返回 -1
 *
 * @Description
 * @Author cjx
 * @Date 2023/6/12 22:48
 * @Version 1.0
 */
public class Kth_Ancestor_of_a_Tree_Node_1483 {
    class TreeAncestor{
        int[][] dp;
        public TreeAncestor(int n, int[] parent) {
            dp=new int[n][16];
            for (int i = 0; i < n; i++) {
                dp[i][0]=parent[i];
            }
            for (int i = 1; i < 16; i++) {
                for (int j = 0; j < n; j++) {
                    int node=dp[j][i-1];
                    dp[j][i]=node==-1?-1:dp[node][i-1];
                }
            }
        }

        public int getKthAncestor(int node, int k) {
            int pow=0;
            while(node!=-1&&k!=0){
                if(k%2==1){
                    node=dp[node][pow];
                }
                pow++;
                k>>=1;
            }
            return node;
        }
    }

}
