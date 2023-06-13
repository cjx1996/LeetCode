package All_Problems;

/**
 * @ClassName EqualPairs_2352
 * @Description
 * 给你一个下标从 0 开始、大小为 n x n 的整数矩阵 grid ，返回满足 Ri 行和 Cj 列相等的行列对 (Ri, Cj) 的数目。
 *
 * 如果行和列以相同的顺序包含相同的元素（即相等的数组），则认为二者是相等的。
 * n == grid.length == grid[i].length
 * 1 <= n <= 200
 * 1 <= grid[i][j] <= 10^5
 * @Author 陈加兴
 * @Date 2023/6/6 17:13
 * @Version 1.0
 */
public class EqualPairs_2352 {
    public int equalPairs(int[][] grid){
        int ans= 0;
        int n =grid.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                boolean flag=true;
                for (int k = 0; k < n; k++) {
                    if(grid[i][k]!=grid[k][j]) {
                        flag=false;
                        break;
                    }
                }
                if(flag) ans++;
            }
        }
        return ans;
    }
}
