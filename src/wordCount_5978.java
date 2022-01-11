import org.junit.Test;

import java.util.*;

/**
 * @ClassName wordCount_5978
 * @Description
 * @Author cjx
 * @Date 2022/1/9 11:22
 * @Version 1.0
 */
public class wordCount_5978 {
    @Test
    public void teest() {
        String[] startWords = new String[]{"ant", "act", "tack"};
        String[] targetWords = new String[]{"tack", "act", "acti"};
        System.out.println(wordCount(startWords, targetWords));
    }
    public int wordCount1(String[] startWords,String[] targetWords){
        Set<Integer> set = new HashSet<>();
        for (String startWord : startWords) {
            int num = 0;
            for (char c : startWord.toCharArray()) {
                num|=1<<(c-'a');
            }
            set.add(num);
        }
        int ans  = 0;
        for (String word : targetWords) {
            int num = 0;
            for (char c : word.toCharArray()) {
                num |=1<<(c-'a');
            }
            for (int i = 0; i < 26; i++) {
                if(((num>>i)&1)==1){
                    num-=1<<i;
                    if(set.contains(num)){
                        ans++;
                    }
                    num+=1<<i;
                }
            }
        }
        return ans;
    }

    public int wordCount(String[] startWords, String[] targetWords) {
        Map<Integer,Integer> map = new HashMap<>();
        for (String  targetWord: targetWords) {
            int key  =code(targetWord);
            map.put(key,map.getOrDefault(key,0)+1);
        }
        int ans = 0;
        for (String word : startWords) {
            int value = code(word);
            for (int i = 0; i < 26; i++) {
                int letter = 1<<i;
                int search = value^letter;
                if(((value&letter)==0)&&map.containsKey(search)){
                    ans+=map.get(search);
                    map.remove(search);
                }
            }
        }
        return ans;
    }
    int code(String s){
        int num = 0;
        for (char c : s.toCharArray()) {
            num|=1<<(c-'a');
        }
        return num;
    }
}
