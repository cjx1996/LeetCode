import org.junit.Test;

/**
 * @ClassName Reverse_String_II_541
 * @Description
 * @Author cjx
 * @Date 2021/8/20 11:12
 * @Version 1.0
 */
public class Reverse_String_II_541 {
    @Test
    public void test(){
        System.out.println(reverseStr("abcdefg", 2));
    }
    public String reverseStr(String s,int k){
        char[] chars = s.toCharArray();
        int start = 0;
        while(start<s.length()){
            reverseK(chars,start,k);
            start+=2*k;
        }
        return String.valueOf(chars);
    }
    void reverseK(char[] chars,int start,int k){
        int len = chars.length;
        if(start>=0){
            int end = Math.min(start+k-1,len-1);
            while(start<end){
                char tem = chars[start];
                chars[start] = chars[end];
                chars[end] = tem;
                start++;
                end--;
            }
        }
    }
}
