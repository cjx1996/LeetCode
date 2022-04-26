package All_Problems;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName Map_Sum_Pairs_677
 * @Description
 * @Author cjx
 * @Date 2021/11/14 19:12
 * @Version 1.0
 */
public class Map_Sum_Pairs_677 {
    class MapSum {
        Map<String, Integer> map;

        public MapSum() {
            map = new HashMap<String, Integer>();
        }

        public void insert(String key, int val) {
            map.put(key, val);
        }

        public int sum(String prefix) {
            int sum = 0;
            Set<Map.Entry<String, Integer>> entries = map.entrySet();
            for (Map.Entry<String, Integer> entry : entries) {
                String str = entry.getKey();
                if (str.startsWith(prefix)) {
                    sum += entry.getValue();
                }
            }
            return sum;
        }
    }
/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */
}
