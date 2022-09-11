package All_Problems;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @ClassName Minimum_Cost_to_Hire_K_Workers_857
 * @Description
 * @Author cjx
 * @Date 2022/9/11 0:35
 * @Version 1.0
 */
public class Minimum_Cost_to_Hire_K_Workers_857 {
    public double mincostToHireWorkers(int[] quality,int[] wages,int k){
        int n =quality.length;
        Integer[] h=new Integer[n];
        for (int i = 0; i < n; i++) {
            h[i]=i;
        }
        Arrays.sort(h,(a,b)->quality[b]*wages[a]-quality[a]*wages[b]);

        PriorityQueue<Integer> q=new PriorityQueue<>((a,b)->b-a);
        double res=1e9;
        double totalq=0;
        for (int i = 0; i < k-1; i++) {
            q.add(quality[h[i]]);
            totalq+=quality[h[i]];
        }
        for (int i = k-1; i < n; i++) {
            totalq+= quality[h[i]];
            q.add(quality[h[i]]);
            double cur=(wages[h[i]]*totalq)/quality[h[i]];
            res=Math.min(res,cur);
            totalq-=q.poll();
        }
        return res;
    }

}
