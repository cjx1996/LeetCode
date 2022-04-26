package All_Problems;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName Group_Anagrams_49
 * @Description
 * @Author cjx
 * @Date 2022/4/16 14:46
 * @Version 1.0
 */
public class Group_Anagrams_49 {
    @Test
    public void test(){
        char[] cs = new char[10];
        for (char c : cs) {
            System.out.println((int)c);
        }
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        Map<String,List<String>> map = new HashMap<>();
        for(String str:strs){
            char[] cnt = new char[26];
            char[] cs = str.toCharArray();
            for(char c:cs){
                cnt[c-'a']++;
            }
            String key = String.valueOf(cnt);
            List<String> list= map.getOrDefault(key,new ArrayList<String>());
            list.add(str);
            map.put(key,list);
        }
        for(List<String> list:map.values()){
            ans.add(list);
        }
        return ans;
    }

}
