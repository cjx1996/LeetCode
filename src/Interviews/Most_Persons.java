package Interviews;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @ClassName Most_Persons
 * @Description
 * @Author cjx
 * @Date 2022/8/31 22:09
 * @Version 1.0
 */
public class Most_Persons {
    static int[] seats;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        seats= new int[n+1];
        Arrays.fill(seats,1);
        seats[0]=0;
        PriorityQueue<int[]> q=new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1]!=o2[1]){
                    return o1[1]-o2[1];
                }else return o2[0]-o1[0];
            }
        });
        for (int i = 0; i < m; i++) {
            int l = scan.nextInt();
            int r=scan.nextInt();
            int x=scan.nextInt();
            q.add(new int[]{l,r,x});
        }
        while(!q.isEmpty()){
            int[] cur=q.poll();
            int num=getCount(seats,cur[0],cur[1]);
            if(num>cur[2]){
                int dif=num-cur[2];
                for (int i = cur[1]; i >= cur[0]; i--) {
                    if(seats[i]==1){
                        seats[i]=0;
                        dif--;
                    }
                    if(dif==0) break;
                }
            }
        }
        System.out.println(getCount(seats,0,n));
    }
    static int  getCount(int[] seats,int l,int r){
        int ans=0;
        for (int i = l; i <=r; i++) {
            if(seats[i]==1) ans++;
        }
        return ans;
    }

}
