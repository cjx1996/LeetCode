package All_Problems;

import org.junit.Test;

import java.util.PriorityQueue;
import java.util.Queue;

public class LargestValuesFromLabels_1090 {
    @Test
    public void test(){
        int[] values=new int[]{5,4,3,2,1};
        int[] labels=new int[]{1,1,2,2,3};
        System.out.println(largestValsFromLabels(values,labels,3,1));
    }
    public int largestValsFromLabels(int[] values,int[] labels,int numWanted,int useLimit){
        int n = values.length;
        int[] cnt=new int[2*10000+1];
        int res=0;
        Queue<int[]> q=new PriorityQueue<>((a,b)->b[0]-a[0]);
        for (int i = 0; i < n; i++) {
            q.add(new int[]{values[i],labels[i]});
        }
        int cur=0;
        for (int i = 0; i < n; i++) {
            int[] arr=q.poll();
            if(cur==numWanted)return res;
            if(cnt[arr[1]]==useLimit)continue;
            cnt[arr[1]]++;
            cur++;
            res+=arr[0];
        }
        return res;
    }
}
