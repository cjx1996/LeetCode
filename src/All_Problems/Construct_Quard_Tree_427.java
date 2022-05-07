package All_Problems;

/**
 * @ClassName Construct_Quard_Tree_427
 * @Description
 * @Author cjx
 * @Date 2022/4/29 10:39
 * @Version 1.0
 */
public class Construct_Quard_Tree_427 {
    private class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;


        public Node() {
            this.val = false;
            this.isLeaf = false;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = topLeft;
            this.topRight = topRight;
            this.bottomLeft = bottomLeft;
            this.bottomRight = bottomRight;
        }
    }
    int[][] grid;
    public Node construct(int[][] _grid){
        grid=_grid;
        Node ans;
        int n = grid.length;
        ans=modifyPart(0,0,n-1,n-1);
        return ans;
    }
    public Node modifyPart(int i1,int j1,int i2,int j2){
        Node node= new Node();
        int sum=0;
        for (int i = i1; i <= i2; i++) {
            for (int j = j1; j <= j2; j++) {
                sum+=grid[i][j];
            }
        }
        if(sum==0) {
            node.val=false;
            node.isLeaf=true;
            return node;
        }
        if(sum==(i2-i1+1)*(i2-i1+1)){
            node.val=true;
            node.isLeaf=true;
            return node;
        }
        int i=(i1+i2)/2;
        int j = (j1+j2)/2;
        node.topLeft=modifyPart(i1,j1,i,j);
        node.topRight=modifyPart(i1,j+1,i,j2);
        node.bottomLeft=modifyPart(i+1,j1,i2,j);
        node.bottomRight=modifyPart(i+1,j+1,i2,j2);
        return node;
    }

}
