package Interviews;

import java.util.Scanner;

/**
 * @ClassName KeDa1
 * @Description
 * @Author cjx
 * @Date 2022/9/17 19:56
 * @Version 1.0
 */
public class KeDa1 {
    static int[][] nums;
    static int[][] used;
    static int[][] ans;
    static int M,N,K,L;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        M = scan.nextInt();
        N = scan.nextInt();
        K = scan.nextInt();
        L = scan.nextInt();
        nums = new int[M][N];
        used = new int[K][L];
        ans=new int[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                nums[i][j]=scan.nextInt();
            }
        }
        for (int i = 0; i < K; i++) {
            for (int j = 0; j < L; j++) {
                used[i][j]=scan.nextInt();
            }
        }
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                int num =cal(i,j);
                num=Math.max(num,0);
                num=Math.min(num,255);
                System.out.print(num);
                if(j!=N-1) System.out.print(" ");
            }
            System.out.println();
        }

    }
    static int cal(int x,int y){
        int rd=K/2;
        int cd=L/2;
        int sum=0;
        for (int i = rd*-1; i <=rd; i++) {
            for (int j = cd*-1; j <=cd; j++) {
                int nx=x+i,ny=y+j;
                if(nx<0||nx>=M||ny<0||ny>=N) continue;
               sum+=nums[x+i][y+j]*used[i+rd][j+cd];
            }
        }
        return sum;
    }

}
