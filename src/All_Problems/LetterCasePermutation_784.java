package All_Problems;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName LetterCasePermutation_784
 * @Description
 * @Author cjx
 * @Date 2023/1/14 16:27
 * @Version 1.0
 */
public class LetterCasePermutation_784 {
    @Test
    public void test(){
        String s="1a2B";
        List<String> ans=letterCasePermutation(s);
        ans.forEach(System.out::println);
    }
    public List<String> letterCasePermutation(String s){
        char cs[] =s.toCharArray();
        List<String> ans=new ArrayList<>();
        int n =cs.length;
        int len=s.length();
        int num=0;
        for (int i = 0; i < n; i++) {
            char c=cs[i];
           if(Character.isLetter(c)) num++;
        }
        for (int i = 0; i < (1<<num); i++) {
            StringBuilder sb=new StringBuilder();
            for (int j = 0,k=0; j < len; j++) {
                if(Character.isLetter(cs[j])&&((i>>k++)&1)==1){
                    sb.append(Character.toUpperCase(cs[j]));
                }else sb.append(Character.toLowerCase(cs[j]));
            }
            ans.add(sb.toString());
        }
        return ans;
    }

}
