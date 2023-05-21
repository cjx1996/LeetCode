package All_Problems;

import org.junit.Test;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class StoreWater_LCP33 {
    @Test
    public void test(){
        int[] bucket=new int[]{1,3};
        int[] vat=new int[]{6,8};
        System.out.println(storeWater(bucket,vat));
    }

    public int storeWater(int[] bucket,int[] vat){
        int n =bucket.length;
        Queue<int[]> q=new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1]*o1[0]-o2[0]*o1[1];
            }
        });
        int add=0;
        for (int i = 0; i < n; i++) {
            if(vat[i]==0) continue;
            if(bucket[i]==0){
                bucket[i]++;
                add++;
            }
            q.add(new int[]{bucket[i],vat[i]});
        }
        if(q.isEmpty()) return 0;
        int[] m=q.peek();
        int res=add+(int)Math.ceil(((double)(m[1]))/m[0]);
        while(add<res-1){
            /** 当前注释段是每次水桶容量加一，实际可以进行优化
            add++;
            m=q.poll();
            m[0]++;
            q.add(m);
            m=q.peek();
            int cur=add+(int)Math.ceil(((double)(m[1]))/m[0]);
            res=Math.min(res,cur);
             **/

            //优化后，每次水桶容量增加必须使得需要的蓄水次数减少1，否则从大的次数上来说是毫无意义的
            m=q.poll();
            int cur=(int)Math.ceil(((double)(m[1]))/m[0]);
            int diff=(int)Math.ceil((double)m[1]/(cur-1))-m[0];
            add+=diff;
            m[0]+=diff;
            q.add(m);
            m=q.peek();
            cur=add+(int)Math.ceil(((double)(m[1]))/m[0]);
            res=Math.min(res,cur);
        }
        return res;
    }
}
