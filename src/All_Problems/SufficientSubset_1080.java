package All_Problems;

public class SufficientSubset_1080 {
    public static final int MIN =Integer.MIN_VALUE;

    public TreeNode sufficientSubset(TreeNode root, int limit) {
        TreeNode dumb=new TreeNode();
        dumb.left=root;
        dfs(dumb,limit);
        return dumb.left;
    }
    public int dfs(TreeNode node,int min){
        int left=node.left==null?MIN:dfs(node.left,min-node.val);
        int right=node.right==null?MIN:dfs(node.right,min-node.val);
        if(left+node.val<min) node.left=null;
        if(right+node.val<min) node.right=null;
        return (left==MIN&&right==MIN?0:Math.max(left,right))+node.val;
    }
}
