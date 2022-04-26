package All_Problems;

import java.util.*;

/**
 * @author cjx
 * @create 2021-01-04-10:07
 * @description
 */
public class LettersCombinations_17 {

    public static void main(String[] args) {
        String digits = "5546";
        List<String> result = lettersCombinations1(digits);
        System.out.println(result);
//        String result1 = result.toString();
//        System.out.println(result1);
    }

    public static List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<>();
        if (digits.length() == 0) {
            return combinations;
        }
        Map<Character, String> phoneMap = new HashMap<>() {
            {
                put('2', "abc");
                put('3', "def");
                put('4', "ghi");
                put('5', "jkl");
                put('6', "mno");
                put('7', "pqrs");
                put('8', "tuv");
                put('9', "wxyz");

            }
        };
        backtrack(combinations, phoneMap, digits, 0, new StringBuffer());
        return combinations;
    }


    public static void backtrack(List<String> combinations, Map<Character, String> phoneMap, String digits, int index, StringBuffer combination) {
        if (index == digits.length()) {
            combinations.add(combination.toString());
        } else {
            char digit = digits.charAt(index);
            String letters = phoneMap.get(digit);
            int lettersCount = letters.length();
            for (int i = 0; i < lettersCount; i++) {
                combination.append(letters.charAt(i));
                backtrack(combinations, phoneMap, digits, index + 1, combination);
                combination.deleteCharAt(index);
            }
        }
    }

    public static List<String>  lettersCombinations1(String digits) {
        List<String> combinations = new ArrayList<>();

        if(digits.length()==0){
            return combinations;
        }
        Map<Character, String> phoneMap = Map.of('2', "abc", '3', "def", '4', "ghi", '5', "jkl", '6', "mno", '7', "pqrs", '8', "tuv", '9', "wxyz");

        backtrack1(combinations, digits, phoneMap, 0, new StringBuilder());
        return combinations;


    }

    public static void  backtrack1(List<String> combinations, String digits, Map<Character, String> phoneMap, int index, StringBuilder combination) {
        if (index == digits.length()) {
            combinations.add(combination.toString());//如果有任何判断条件，就应该加在这里进行判断；当然本题没有判断，走到这里的所有结果都是满足的，直接加到结果集即可
        } else {
            char digit = digits.charAt(index);
            String letters = phoneMap.get(digit);
            int lettersCount = letters.length();
            for (int i = 0; i < lettersCount; i++) {//添加每个结果中索引为index的字符
                combination.append(letters.charAt(i));
                backtrack1(combinations, digits, phoneMap, index + 1, combination);
                combination.deleteCharAt(index);
            }
        }
    }


}
