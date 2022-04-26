package All_Problems;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @ClassName Map_of_Highest_Peak_1765
 * @Description
 * @Author cjx
 * @Date 2022/1/30 21:38
 * @Version 1.0
 */
public class Map_of_Highest_Peak_1765 {
    public int[][] highestPeak(int[][] isWater){
        int m = isWater.length,n=isWater[0].length;
        int[][] ans= new int[m][n];
        for (int[] s : ans) {
            Arrays.fill(s,-1);
        }
        int[][] dirs = new int[][]{
                {-1,0},
                {1,0},
                {0,1},
                {0,-1}
        };
        Deque<int[]> q = new ArrayDeque<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(isWater[m][n]==1){
                    q.add(new int[]{i,j});
                    ans[i][j] = 0;
                }
            }
        }
        int level = 1;
        while(!q.isEmpty()){
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] point = q.poll();
                int x= point[0], y=point[1];
                for (int[] dir : dirs) {
                    int dx = dir[0],dy = dir[1];
                    int nx = x+dx,ny=y+dy;
                    if(nx<0||nx>=m||ny<0||ny>=n||ans[nx][ny]!=-1){
                        continue;
                    }else {
                        ans[nx][ny] = level;
                        q.add(new int[]{nx,ny});
                    }
                }
            }
            level++;
        }
        return ans;
    }
}
