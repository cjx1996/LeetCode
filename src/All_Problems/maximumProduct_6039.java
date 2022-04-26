package All_Problems;

import java.util.PriorityQueue;

/**
 * @ClassName maximumProduct_6039
 * @Description
 * @Author cjx
 * @Date 2022/4/10 11:32
 * @Version 1.0
 */
public class maximumProduct_6039 {
    public int maximumProduct(int[] nums,int k){
        int M = (int)1e9+7;
        PriorityQueue<Integer> q= new PriorityQueue<>((o1,o2)->o1-o2);
        for(int num:nums){
            q.add(num);
        }
        while(k-->0){
            q.add(q.poll()+1);
        }
        int ans = 1;
        while(!q.isEmpty()){
            ans =(int)((ans*(long)q.poll())%M);
        }
        return ans;
    }
}
