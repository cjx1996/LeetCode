package All_Problems;

import org.junit.Test;

import java.util.*;

/**
 * @ClassName Find_and_Replace_Pattern_890
 * @Description
 * @Author cjx
 * @Date 2022/6/12 19:30
 * @Version 1.0
 */
public class Find_and_Replace_Pattern_890 {
    @Test
    public void test() {

        String[] words = new String[]{"a","b","c"};
        String pattern = "a";
        List<String> list = findAndReplacePattern(words, pattern);
        for (String s : list) {
            System.out.println(s);
        }
    }

    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> ans = new ArrayList<>();
        int m = pattern.length();
        for (String word : words) {
            if (m != word.length()) continue;
            int[] keys=new int[30];
            int[] values=new int[30];
            Arrays.fill(keys,-1);
            Arrays.fill(values,-1);
            boolean flag = true;
            for (int i = 0; i < m; i++) {
                int key = word.charAt(i)-'a';
                int value = pattern.charAt(i)-'a';
                if(keys[key]==-1&&values[value]==-1) {
                    keys[key]=value;
                    values[value]=key;
                }else if(keys[key]==value&&values[value]==key){
                    continue;
                }else {
                    flag=false;
                    break;
                }
            }
            if (flag) ans.add(word);
        }
        return ans;
    }
}
