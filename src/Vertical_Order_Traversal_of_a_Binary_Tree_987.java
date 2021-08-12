import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @ClassName Vertical_Order_Traversal_of_a_Binary_Tree_987
 * @Description
 * @Author cjx
 * @Date 2021/7/31 18:42
 * @Version 1.0
 */
public class Vertical_Order_Traversal_of_a_Binary_Tree_987 {
    public List<List<Integer>> verticalTraversal(TreeNode root){
        List<int[]> nodes = new ArrayList<>();
        dfs(nodes,root,0,0);
        nodes.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1]!=o2[1]){
                    return o1[1]-o2[1];
                }else if(o1[0]!=o2[0]){
                    return o1[0]-o2[0];
                }else return o1[2]-o2[2];
            }
        });
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());
        ans.get(0).add(nodes.get(0)[2]);
        for (int i = 1; i < nodes.size(); i++) {
           if(nodes.get(i)[1]!=nodes.get(i-1)[1]){
               ans.add(new ArrayList<>());
           }
           ans.get(ans.size()-1).add(nodes.get(i)[2]);
        }
        return ans;
    }

    void dfs(List<int[]> nodes,TreeNode root,int row,int col){
        if(root==null){
            return;
        }
        nodes.add(new int[]{row,col,root.val});
        dfs(nodes,root.left,row+1,col-1);
        dfs(nodes,root.right,row+1,col+1);
    }

}
