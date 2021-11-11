import org.junit.Test;

import java.util.HashSet;

/**
 * @ClassName Reverse_Vowels_of_a_String_345
 * @Description
 * @Author cjx
 * @Date 2021/8/19 23:28
 * @Version 1.0
 */
public class Reverse_Vowels_of_a_String_345 {
    @Test
    public void test() {
        String s = "Leetcode";
        System.out.println(reverseVowels(s));
    }

    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        HashSet set = new HashSet<Character>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add("I");
        set.add('U');
        set.add('O');
        int left = 0;
        int right = chars.length - 1;
        while (left < right) {
            while (left<chars.length&&!set.contains(chars[left])) {
                left++;
            }
            while (right>=0&&!set.contains(chars[right])) {
                right--;
            }
            if (left < right) {
                char tem = chars[left];
                chars[left] = chars[right];
                chars[right] = tem;
                left++;
                right--;
            }
        }
        return String.valueOf(chars);
    }
}
