package All_Problems;

import org.junit.Test;

/**
 * @ClassName Diagonal_Traverse_498
 * @Description
 * @Author cjx
 * @Date 2022/6/14 10:54
 * @Version 1.0
 */
public class Diagonal_Traverse_498 {
    @Test
    public void test(){
        int[][] mat=new int[][]{
                {1,2,3,5},
                {4,5,6,7},
                {7,8,9,8},

        };
        int[] ans=findDiagonalOrder(mat);
        for (int i : ans) {
            System.out.println(i);
        }
    }
    public int[] findDiagonalOrder(int[][] mat){
        int m = mat.length,n=mat[0].length;
        int[] ans= new int[m*n];
        int i =0,j=0,index=0;
        int d=1;
        for (int sum = 0; sum < m + n - 1; sum++) {
            while(i>=0&&i<m&&j>=0&&j<n){
                ans[index++]=mat[i][j];
                if(i==0&&j==n-1&&d==1){
                    i++;
                    break;
                }
                if(i==m-1&&j==0&&d==-1){
                    j++;
                    break;
                }
                if(j+d<0||j+d==n){
                    i++;
                    break;
                }
                if(i-d<0||i-d==m){
                    j++;
                    break;
                }
                i-=d;
                j+=d;
            }
            d*=-1;
        }
        return ans;
    }

}
