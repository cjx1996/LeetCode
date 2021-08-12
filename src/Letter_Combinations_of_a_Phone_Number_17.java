import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName Letter_Combinations_of_a_Phone_Number_17
 * @Description
 * @Author cjx
 * @Date 2021/7/30 12:17
 * @Version 1.0
 */
public class Letter_Combinations_of_a_Phone_Number_17 {
    @Test
    public void test() {
        String digits = "2";
        List<String> ans = letterCombinations(digits);
        ans.forEach(System.out::println);
    }

    List<String> ans = new ArrayList<>();
    static final Map<Character, String> map = Map.of('2', "abc", '3', "def", '4', "ghi",
            '5', "jkl", '6', "mno", '7', "pqrs", '8', "tuv", '9', "wxyz");


    public List<String> letterCombinations(String digits) {
        char[] chars = digits.toCharArray();
        if (chars.length == 0) return ans;
        dfs(chars, 0, new StringBuilder());
        return ans;
    }

    void dfs(char[] chars, int index, StringBuilder curr) {
        if (index == chars.length) {
            ans.add(curr.toString());
            return;
        }
        char num = chars[index];
        String currChars = map.get(num);
        for (int i = 0; i < currChars.length(); i++) {
            char c = currChars.charAt(i);
            curr.append(c);
            dfs(chars, index + 1, curr );
            curr.deleteCharAt(curr.length()-1);
        }
    }
}
