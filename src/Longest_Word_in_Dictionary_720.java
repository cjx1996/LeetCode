import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName Longest_Word_in_Dictionary_720
 * @Description
 * @Author cjx
 * @Date 2022/3/17 9:29
 * @Version 1.0
 */
public class Longest_Word_in_Dictionary_720 {
    @Test
    public void test() {
        String[] words = new String[]{
                "a", "banana", "app", "ap", "apply", "apple"
        };
        System.out.println(longestWord(words));
    }

    public String longestWord(String[] words) {
        int max = 0;
        String ans = "";
        Set<String> set= new HashSet<>();
        for (String word:words){
            set.add(word);
        }
        for (String word : words) {
            if(!isValid(set,word)) continue;
            if (word.length() > max) {
                ans = word;
                max=word.length();
            } else if (word.length() == max && (word.compareTo(ans) < 0)) {
                ans = word;
            }
        }
        return ans;
    }
    public boolean isValid(Set<String> set,String word){
        char[] cs = word.toCharArray();
        for (int i = 1; i < cs.length ; i++) {
            if(!set.contains(String.valueOf(cs,0,i))) return false;
        }
        return true;
    }
}
