package Interviews;

import All_Problems.TreeNode;

import java.util.ArrayDeque;

/**
 * @ClassName MaxValue
 * @Description
 * @Author cjx
 * @Date 2022/9/1 19:49
 * @Version 1.0
 */
public class MaxValue {
    public int maxValue(TreeNode root){
        int[] up =new int[100001];
        int[] down=new int[100001];
        int max=root.val;
        int maxLevel=0;
        int level=0;
        ArrayDeque<TreeNode> q=new ArrayDeque<>();
        q.add(root);
        while(!q.isEmpty()){
            int n =q.size();
            int big=0;
            int sl=0;
            int sum=0;
            for (int i = 0; i < n; i++) {
                TreeNode cur=q.poll();
                sum+=cur.val;
                if(cur.left!=null){
                    q.add(cur.left);
                    if(cur.left.val>cur.val){
                        sl= Math.max(sl,cur.left.val-cur.val);
                    }else {
                        big=Math.max(big,cur.val-cur.left.val);
                    }
                }
                if(cur.right !=null){
                    q.add(cur.right );
                    if(cur.right .val>cur.val){
                        sl= Math.max(sl,cur.right .val-cur.val);
                    }else {
                        big=Math.max(big,cur.val-cur.right .val);
                    }
                }
            }
            if(sum>max){
                max=sum;
                maxLevel=level;
            }
            up[level+1]= big;
            down[level]=sl;
            level++;
        }
        return max+Math.max(up[maxLevel],down[maxLevel]);
    }

}
