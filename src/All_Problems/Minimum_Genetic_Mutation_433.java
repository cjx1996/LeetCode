package All_Problems;

import java.util.*;

/**
 * @ClassName Minimum_Genetic_Mutation_433
 * @Description
 * @Author cjx
 * @Date 2022/5/7 10:46
 * @Version 1.0
 */
public class Minimum_Genetic_Mutation_433 {

    public int minMutation(String start,String end,String[] bank){
        if(start.equals(end)) return 0;
        Map<Integer, List<Integer>> map=new HashMap<>();
        int n = bank.length;
        for (int i = 0; i < n; i++) {
            String s1=bank[i];
            List<Integer> li1 = map.getOrDefault(i, new ArrayList<>());
            for (int j = i+1; j < n; j++) {
                String s2=bank[j];
                if(isValid(s1,s2)){
                    List<Integer> li2 = map.getOrDefault(j, new ArrayList<>());
                    li1.add(j);
                    li2.add(i);
                    map.put(j,li2);
                }
            }
            map.put(i,li1);
        }
        int index=-1;
        for (int i = 0; i < n; i++) {
            if(bank[i].equals(end)) {
                index=i;
                break;
            }
        }
        if(index==-1||!map.containsKey(index)) return -1;
        Deque<Integer> q=new ArrayDeque<>();
        q.add(index);
        int level=0;
        boolean[] vis=new boolean[n];
        vis[index]=true;
        while(!q.isEmpty()){
            int size=q.size();
            for (int i = 0; i < size; i++) {
                int cur=q.poll();
                if(isValid(start,bank[cur])) return level+1;
                List<Integer> li = map.get(cur);
                for (Integer next : li) {
                    if(vis[next]) continue;
                    vis[next]=true;
                    q.add(next);
                }
            }
            level++;
        }
        return -1;
    }
    boolean isValid(String s1,String s2){
        char[] cs1 = s1.toCharArray();
        char[] cs2=s2.toCharArray();
        int n=  cs1.length;
        int cnt=0;
        for (int i = 0; i < n; i++) {
            if(cs1[i]==cs2[i]) cnt++;
        }
        return cnt==7;
    }
}
