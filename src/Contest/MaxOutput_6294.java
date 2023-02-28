package Contest;

import org.junit.Test;

import java.util.*;

/**
 * @ClassName MaxOutput_6294
 * @Description
 * @Author cjx
 * @Date 2023/1/15 11:37
 * @Version 1.0
 */
public class MaxOutput_6294 {
    @Test
    public void test(){
        int n =6;
        int[][] edges=new int[][]{
                {0,1},
                {1,2},
                {1,3},
                {3,4},
                {3,5}
        };
        int[] price=new int[]{
                9,8,7,6,10,5
        };
        System.out.println(maxOutput(n,edges,price));
    }

    static long ans;
    Map<Integer, List<Integer>> map;
    int[] price;
    public long maxOutput(int n,int[][] edges,int[] _price){
        if(n<=1) return 0;
        else if(n==2) return Math.max(_price[0],_price[1]);
        ans=0;
        map=new HashMap<>();
        price=_price;
        for(int[] edge:edges){
            List<Integer> list0 = map.getOrDefault(edge[0], new ArrayList<>());
            list0.add(edge[1]);
            map.put(edge[0],list0);
            List<Integer> list1 = map.getOrDefault(edge[1], new ArrayList<>());
            list1.add(edge[0]);
            map.put(edge[1],list1);
        }
        for (int i = 0; i < n; i++) {
            if(map.getOrDefault(i, new ArrayList<>()).size()<2)continue;
            long max= dfs(i,new boolean[n]);
            ans=Math.max(max,ans);
        }
        return ans;
    }
    long dfs(int node,boolean[] used){
        used[node]=true;
        List<Integer> list = map.getOrDefault(node, new ArrayList<>());
        long max=0;
        for (Integer integer : list) {
            if(used[integer]) continue;
            used[integer]=true;
            max=Math.max(dfs(integer,used),max);
            used[integer]=false;
        }
        return max+price[node];
    }

}
