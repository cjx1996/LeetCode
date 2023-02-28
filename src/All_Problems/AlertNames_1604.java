package All_Problems;

import org.junit.Test;

import java.util.*;

/**
 * @ClassName AlertNames_1604
 * @Description
 * @Author cjx
 * @Date 2023/2/7 12:10
 * @Version 1.0
 */
public class AlertNames_1604 {
    @Test
    public void test() {
        String[] keyName = new String[]{"daniel", "daniel", "daniel", "luis", "luis", "luis", "luis"};
        String[] keyTime = new String[]{"10:00", "10:40", "11:00", "09:00", "11:00", "13:00", "15:00"};
        List<String> ans = alertNames(keyName, keyTime);
        ans.forEach(System.out::println);
    }

    public List<String> alertNames(String[] keyName, String[] keyTime) {
        Map<String, List<Integer>> map = new HashMap<>();
        int n = keyName.length;
        for (int i = 0; i < n; i++) {
            List<Integer> list = map.getOrDefault(keyName[i], new ArrayList<>());
            list.add(getTime(keyTime[i]));
            map.put(keyName[i], list);
        }
        List<String> ans = new ArrayList<>();
        for (Map.Entry<String, List<Integer>> entry : map.entrySet()) {
            List<Integer> list = entry.getValue();
            list.sort((a, b) -> a - b);
            int m = list.size();
            if (m <= 2) continue;
            for (int i = 0; i + 2 < m; i++) {
                if(list.get(i+2)-list.get(i)<=60){
                    ans.add(entry.getKey());
                    break;
                }
            }
        }
        ans.sort((a,b)->a.compareTo(b));
        return ans;
    }

    public int getTime(String time) {
        int hour = Integer.valueOf(time.substring(0, 2));
        int min = Integer.valueOf(time.substring(3, 5));
        return hour * 60 + min;
    }
/*  使用了堆，时间复杂度过高，考虑简单方案
    public List<String> alertNames(String[] keyName,String[] keyTime){
        PriorityQueue<String[]> q=new PriorityQueue<>((o1,o2)->o1[1].compareTo(o2[1]));
        Map<String,List<String>> map=new HashMap<>();
        int n= keyName.length;
        List<String> ans=new ArrayList<>();
        for (int i = 0; i < n; i++) {
            q.add(new String[]{keyName[i],keyTime[i]});
        }
        while(!q.isEmpty()){
            String[] act=q.poll();
            if(ans.contains(act[0])) continue;
            List<String> times = map.getOrDefault(act[0], new ArrayList<>());
            times.add(act[1]);
            map.put(act[0],times);
            if(times.size()>=3){
                String preTime=times.get(times.size()-3);
                if(oneHour(preTime,act[1])){
                    ans.add(act[0]);
                }
            }
        }
        ans.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });
        return ans;

    }
    public boolean oneHour(String s1,String s2){
        int diff=(Integer.valueOf(s2.substring(0,2))-Integer.valueOf(s1.substring(0,2)))*60+Integer.valueOf(s2.substring(3,5))-Integer.valueOf(s1.substring(3,5));
        return diff<=60;
    }
*/

}
