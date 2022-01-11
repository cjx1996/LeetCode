import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Occurrences_After_Bigram_1078
 * @Description
 * @Author cjx
 * @Date 2021/12/26 8:03
 * @Version 1.0
 */
public class Occurrences_After_Bigram_1078 {
    @Test
    public void test() {
        String text = "alice is a good girl she is a good student";
        String first = "a";
        String second = "good";
        String[] ans = findOccurrences(text, first, second);
        for (String an : ans) {
            System.out.println(an);
        }
    }
    public String[] findOccurrences(String text, String first, String second) {
        String[] words= text.split(" ");
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < words.length-2; i++) {
            if(words[i].equals(first)&&words[i+1].equals(second)){
                ans.add(words[i+2]);
            }
        }
        return ans.toArray(new String[0]);
    }
}
