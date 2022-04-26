package All_Problems;

import jdk.jfr.StackTrace;
import org.junit.Test;

/**
 * @ClassName Reverse_Words_in_a_String_III_557
 * @Description
 * @Author cjx
 * @Date 2021/8/8 21:42
 * @Version 1.0
 */
public class Reverse_Words_in_a_String_III_557 {
    @Test
    public void test(){
    String s = "    Let's take LeetCode contest   ";
        System.out.println(reverseWords(s));
    }
    public String reverseWords(String s){
        char[] chars = s.toCharArray();
        int n = chars.length;
        int left =findLeft(chars,0);
        while(left<n){
                int right = findRight(chars,left);
                reverseWord(chars,left,right);
                left = findLeft(chars,right+1);
        }

        return String.valueOf(chars);
    }
    //将nums的[start,end]倒置
    void reverseWord(char[] chars,int start,int end){
        if(start>=end) return;
        while(start<end){
            char tem = chars[start];
            chars[start] = chars[end];
            chars[end] = tem;
            start++;
            end--;
        }
    }
    //从当前位置开始，找到第一个不为' '的索引
    int findLeft(char[] chars,int index){
        int n = chars.length;
        while(index<n&&chars[index]==' '){
            index++;
        }
        return index;
    }
    int findRight(char[] chars,int index){
        int n = chars.length;
        while(index<n-1&&chars[index+1]!=' '){
            index++;
        }
        return index;
    }

}
