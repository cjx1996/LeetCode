package Coding_Interviews;

import org.junit.Test;

import java.util.Arrays;

/**
 * @ClassName Offer58_I_Reverse_Words
 * @Description
 * @Author cjx
 * @Date 2022/4/27 22:51
 * @Version 1.0
 */
public class Offer58_I_Reverse_Words {
    @Test
    public void test(){
        String s = " ";
        System.out.println(reverseWords(s));
    }
    public String reverseWords(String s){
        String[] ss= s.split(" ");
        int n = ss.length;
        if(n==0) return "";
        for (int i = 0; i < n; i++) {
            reverse(ss[i]);
        }
        StringBuilder sb= new StringBuilder(ss[n-1]);
        for (int i = 0; i < n-1; i++) {
            if(ss[n-2-i].equals("")) continue;
            sb.append(" "+ss[n-2-i]);
        }
        return sb.toString();

    }
    void reverse(String str){
        char[] cs= str.toCharArray();
        int l =0,r=cs.length-1;
        while(l<r){
            char tem= cs[l];
            cs[l]= cs[r];
            cs[r]=tem;
            l++;
            r--;
        }
        str=String.valueOf(cs);
    }

}
