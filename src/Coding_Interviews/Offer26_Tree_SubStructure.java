package Coding_Interviews;

import All_Problems.TreeNode;

/**
 * @ClassName Offer26_Tree_SubStructure
 * @Description
 * @Author cjx
 * @Date 2022/4/26 18:05
 * @Version 1.0
 */
public class Offer26_Tree_SubStructure {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        boolean res = false;
        if(A!=null&&B!=null){
            if(A.val==B.val){
                res = isSub(A,B);
            }
            if(!res) res=isSubStructure(A.left,B);
            if(!res) res=isSubStructure(A.right,B);
        }
        return res;
    }

    public boolean isSub(TreeNode n1, TreeNode n2) {
        if (n2 == null) return true;
        if (n1 == null) return false;
        if (n1.val != n2.val) return false;
        return isSub(n1.left, n2.left) && isSub(n1.right, n2.right);
    }

}
