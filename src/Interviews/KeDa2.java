package Interviews;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 * @ClassName KeDa2
 * @Description
 * @Author cjx
 * @Date 2022/9/17 20:26
 * @Version 1.0
 */
public class KeDa2 {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int M=scan.nextInt();
        int N=scan.nextInt();
        int[][] orign=new int[M][N],now=new int[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                orign[i][j]=scan.nextInt();
            }
        }
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                now[i][j]=scan.nextInt();
            }
        }
        int ans=0;
        int[][] dirs=new int[][]{
                {1,0},
                {-1,0},
                {0,1},
                {0,-1}
        };
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if(orign[i][j]==now[i][j]){
                    int cur=1;
                    Deque<int[]> q=new ArrayDeque<>();
                    q.add(new int[]{i,j});
                    now[i][j]=orign[i][j]+1;
                    while(!q.isEmpty()){
                        int[] po=q.poll();
                        for (int k = 0; k < 4; k++) {
                            int ni=po[0]+dirs[k][0],nj=po[1]+dirs[k][1];
                            if(ni<0||ni>=M||nj<0||nj>=N) continue;
                            if(orign[ni][nj]==now[ni][nj]){
                                cur++;
                                q.add(new int[]{ni,nj});
                                now[ni][nj]=orign[ni][nj]+1;
                            }
                        }
                    }
                    ans=Math.max(ans,cur);
                }
            }
        }
        System.out.println(ans);
    }

}
