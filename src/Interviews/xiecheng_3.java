package Interviews;

import org.junit.Test;

import java.util.Scanner;

/**
 * @ClassName Interviews.xiecheng_3
 * @Description
 * @Author cjx
 * @Date 2022/4/14 20:17
 * @Version 1.0
 */
public class xiecheng_3 {
    public static void main(String[] args) {

    }
    @Test
    public void test(){
        String str = "01011";
        solution(str);
    }
    public void solution(String str){

        int n  =str.length();
        char[] cs = str.toCharArray();
        if(n%2==0){
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                if(i%2==cs[i]-'0'){
                    cnt++;
                }
            }
            System.out.println(cnt>n/2?(n-cnt)/2:cnt/2);
        }
        else{
            int cnt1=0,cnt2=0;
            for (int i = 0; i <n ; i++) {
                if(i%2==cs[i]-'0') cnt1++;
                if(i%2!=(cs[i]-'0'))cnt2++;
            }
            System.out.println(cnt1>cnt2?cnt1/2:cnt2/2);
        }
    }

}
