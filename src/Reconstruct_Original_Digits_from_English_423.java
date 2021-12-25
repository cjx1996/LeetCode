import org.junit.Test;

import java.util.*;

/**
 * @ClassName Reconstruct_Original_Digits_from_English_423
 * @Description
 * @Author cjx
 * @Date 2021/11/24 15:05
 * @Version 1.0
 */
public class Reconstruct_Original_Digits_from_English_423 {
    @Test
    public void test() {
        System.out.println(originalDigits("owoztneoer"));
    }


    //定义数字与英文字符串的对应
    final String[] digits = new String[]{"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

    public String originalDigits(String s) {
        //定义每个数字的计算顺序
        int[] order = new int[]{0, 2, 4, 6, 5, 3, 1, 7, 8, 9};
        int[] cnts = new int[26];
        //定义最终结果变量
        StringBuilder ans = new StringBuilder();
        //计算每个字母的出现频数
        for (int i = 0; i < s.length(); i++) {
            cnts[s.charAt(i) - 'a']++;
        }
        //按照计算顺序计算最终结果
        for (int i = 0; i < order.length; i++) {
            getDigits(cnts, ans, order[i]);
        }
        //对list中的数字进行排序
        char[] res = ans.toString().toCharArray();
        Arrays.sort(res);
        return String.valueOf(res);
    }

    void getDigits(int[] cnts, StringBuilder ans, int digit) {
        //得到将要计算数字的英文字符串
        String str = digits[digit];
        //初始化数字变量的个数
        int cnt = Integer.MAX_VALUE;
        //得到每个字符串的唯一性的最小的那个字母的个数
        for (int i = 0; i < str.length(); i++) {
            cnt = Math.min(cnt, cnts[str.charAt(i) - 'a']);
        }
        //对于每个数字的个数进行处理
        //对于每个字符串的字母的数字减少cnt
        for (int i = 0; i < str.length(); i++) {
            cnts[str.charAt(i) - 'a'] -= cnt;
        }
        //在最终结果list上添加cnt个digit
        while (cnt-- > 0) {
            ans.append(digit);
        }
    }

}
