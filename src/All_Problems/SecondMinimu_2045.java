package All_Problems;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @ClassName SecondMinimu_2045
 * @Description
 * @Author cjx
 * @Date 2022/1/24 10:44
 * @Version 1.0
 */
public class SecondMinimu_2045 {
    static int N = 10001, M = 4 * N, INF = 0x3f3f3f3f, idx = 0;
    static int[] he = new int[N], e = new int[M], ne = new int[M];
    static int[] dist1 = new int[N], dist2 = new int[N];

    //添加从a->b的路径
    void add(int a, int b) {
        e[idx] = b;
        ne[idx] = he[a];
        he[a] = idx;
        idx++;
    }

    public int secondMinimum(int n, int[][] edges, int time, int change) {
        Arrays.fill(he,-1);
        Arrays.fill(dist1,INF);
        Arrays.fill(dist2,INF);

       PriorityQueue<int[]> q= new PriorityQueue<>((a,b)->(a[1]-b[1]));
        for (int[] edge : edges) {
            add(edge[0],edge[1]);
            add(edge[1],edge[0]);
        }
        q.add(new int[]{1,0});
        dist1[1]=0;
        //定义边的权为1，求出次短路后再计算时间
        while(!q.isEmpty()){
            int[] situ = q.poll();
            int po = situ[0],currTime = situ[1];
            for(int i = he[po];i!=-1;i=ne[i]){
                int j = e[i];
                /*  求解时间的方法放在最后
                int a = currTime/change,b=currTime%change;
                int wait = a%2==0?0:change-b;
                int dis = currTime+time+wait;
                */
                int dis = currTime+1;
                if(dis<dist1[j]){
                    dist2[j] = dist1[j];
                    dist1[j] = dis;
                    q.add(new int[]{j,dist1[j]});
                    q.add(new int[]{j,dist2[j]});
                }else if(dis>dist1[j]&&dis<dist2[j]){
                    dist2[j] = dis;
                    q.add(new int[]{j,dist2[j]});
                }
            }
        }
        int ans =0;
        //根据次短路的步数计算时间
        for (int i = 0; i < dist2[n]; i++) {
            int a = ans/change,b=ans%change;
            int wait = a%2==0?0:change-b;
            ans += time+wait;
        }
        return ans;
        /*
        while(!q.isEmpty()){
            int[] situ = q.poll();
            int po = situ[0],currTime = situ[1];
            for(int i = he[po];i!=-1;i=ne[i]){
                int j = e[i];
                int a = currTime/change,b=currTime%change;
                int wait = a%2==0?0:change-b;
                int dis = currTime+time+wait;
                if(dis<dist1[j]){
                    dist2[j] = dist1[j];
                    dist1[j] = dis;
                    q.add(new int[]{j,dist1[j]});
                    q.add(new int[]{j,dist2[j]});
                }else if(dis>dist1[j]&&dis<dist2[j]){
                    dist2[j] = dis;
                    q.add(new int[]{j,dist2[j]});
                }
            }
        }
        return dist2[n];
        */
    }
}
