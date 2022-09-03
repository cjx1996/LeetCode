package Interviews;

import All_Problems.TreeNode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @ClassName Balances_SubTree
 * @Description
 * @Author cjx
 * @Date 2022/9/1 20:21
 * @Version 1.0
 */
public class Balances_SubTree {
    PriorityQueue<Object[]> q;
    public TreeNode[] balancesSubTrees(TreeNode root){
        q=new PriorityQueue<>(new Comparator<Object[]>() {
            @Override
            public int compare(Object[] o1, Object[] o2) {
                if((int)o1[0]!=(int)o2[0]){
                    return (int)o1[0]-(int)o2[0];
                }else return (int)o1[1]-(int)o2[1];
            }
        });
        int[] cur=getHeight(root);
        q.add(new Object[]{cur[1],root.val,root});
        int n =q.size();
        TreeNode[] ans=new TreeNode[n];
        for (int i = 0; i < n; i++) {
            ans[i]=(TreeNode)q.poll()[2];
        }
        return ans;
    }
    public int[] getHeight(TreeNode node){
        if(node==null) return new int[]{0,0};
        int[] l=getHeight(node.left);
        int[] r=getHeight(node.right);
        int lh=l[0];
        int rh=r[0];
        while(Math.abs(lh-rh)>1){
            if(lh>rh){
                q.add(new Object[]{l[1],node.left.val,node.left});
                l=new int[]{0,0};
                node.left=null;
                lh=0;
            }else{
                q.add(new Object[]{r[1],node.right.val,node.right});
                r=new int[]{0,0};
                node.right=null;
                rh=0;
            }
        }
        return new int[]{Math.max(lh,rh)+1,l[1]+r[1]+1};
    }

}
