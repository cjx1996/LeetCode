import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @ClassName Substring_
 * @Description
 * @Author cjx
 * @Date 2021/6/10 23:56
 * @Version 1.0
 */
public class Substring_With_Concatenation_Of_All_Words_30 {
    @Test
    public void test() {
        String[] words = new String[]{"foo", "bar"};
        String s = "barfoothefoobarman";
        List<Integer> result = findSubstring(s, words);
        for (Integer integer : result) {
            System.out.println(integer);
        }
    }


    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<Integer>();
        int one_word = words[0].length();
        int word_num = words.length;
        HashMap<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        for (int i = 0; i < one_word; i++) {
            int left = i, right = i;
            int num = 0;
            HashMap<String, Integer> tem_map = new HashMap<>();
            while (right <= s.length() - one_word) {

                String word = s.substring(right, right + one_word);
                num++;
                tem_map.put(word, tem_map.getOrDefault(word, 0) + 1);

                while (tem_map.getOrDefault(word, 0) > map.getOrDefault(word, 0)) {
                    left += one_word;
                    num--;
                    String word2 = s.substring(left - one_word, left);
                    tem_map.put(word2, tem_map.get(word2) - 1);
                }
                if (num == word_num) res.add(left);
                right += one_word;
            }

        }


        return res;
    }


}
