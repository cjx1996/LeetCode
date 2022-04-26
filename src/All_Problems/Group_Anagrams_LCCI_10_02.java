package All_Problems;

import java.util.*;

/**
 * @ClassName Group_Anagrams_LCCI_10_02
 * @Description
 * @Author cjx
 * @Date 2021/7/18 17:38
 * @Version 1.0
 */
public class Group_Anagrams_LCCI_10_02 {
    public List<List<String>> groupAnagrams(String[] strs){
        List<List<String>> res = new ArrayList<>();
        int len = strs.length;
        HashMap<String,List<String>> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            char[] array = strs[i].toCharArray();
            Arrays.sort(array);
            String str = String.valueOf(array);
            List<String> stringList = map.getOrDefault(str, new ArrayList<>());
            stringList.add(strs[i]);
            map.put(str,stringList);



        }
        Set<Map.Entry<String, List<String>>> entries = map.entrySet();
        for(Map.Entry entry:entries){
            res.add((List)entry.getValue());
        }
        return res;
    }
}
