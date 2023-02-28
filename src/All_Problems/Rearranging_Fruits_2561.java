package All_Problems;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @ClassName Rearranging_Fruits_2561
 * @Description
 * @Author cjx
 * @Date 2023/2/11 20:24
 * @Version 1.0
 */
public class Rearranging_Fruits_2561 {
    public long minCost(int[] basket1,int[] basket2){
        var map=new HashMap<Integer,Integer>();
        int n = basket1.length;
        int min=Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            map.merge(basket1[i],1,Integer::sum);
            map.merge(basket2[i],-1,Integer::sum);
        }
        var list=new ArrayList<Integer>();
        for(var e:map.entrySet()){
            int k=e.getKey(),v=e.getValue();
            if(v%2!=0) return -1;
            min=Math.min(min,k);
            for (int i = Math.abs(v)/2; i >0; i--) {
                list.add(k);
            }
        }
        long ans=0;
        list.sort((x,y)->x-y);
        for (int i = 0; i < list.size() / 2; i++) {
            ans+=Math.min(list.get(i),2*min);
        }
        return ans;
    }

}
