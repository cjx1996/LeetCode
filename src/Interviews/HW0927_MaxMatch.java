package Interviews;

import java.util.Scanner;
import java.util.Stack;

/**
 * @ClassName Solution
 * @Description
 * @Author cjx
 * @Date 2022/9/27 14:23
 * @Version 1.0
 */
public class HW0927_MaxMatch {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str1=sc.nextLine();
        String str2=sc.nextLine();
        Stack<Character> stack1=new Stack<>();
        Stack<Character> stack2=new Stack<>();
        for (int i = str1.length()-1; i >=0; i--) {
            stack1.push(str1.charAt(i));
        }
        for (int i = str2.length()-1; i >=0; i--) {
            stack2.push(str2.charAt(i));
        }
        int ans=0;
        int cnt1=0;
        int cnt2=0;
        char c1=0;
        char c2=0;

        while(!stack1.isEmpty()||!stack2.isEmpty()){
            int tem1=0;
            int tem2=0;
            if(cnt1>cnt2){
                while(!stack2.isEmpty()&&stack2.peek()>='0'&&stack2.peek()<='9')
                {
                    tem2=tem2*10+stack2.pop()-'0';
                }

                if(!stack2.isEmpty()){
                    c2=stack2.pop();
                }
                if(c1==c2){
                    ans+=Math.min(tem2,cnt1-cnt2);
                }
                cnt2+=tem2;
            }else{
                while(!stack1.isEmpty()&&stack1.peek()>='0'&&stack1.peek()<='9')
                {
                    tem1=tem1*10+stack1.pop()-'0';
                }
                if(!stack1.isEmpty()){
                    c1=stack1.pop();
                }
                if(c1==c2){
                    ans+=Math.min(tem1,cnt2-cnt1);
                }
                cnt1+=tem1;
            }

            if(tem1==0&&tem2==0) break;
        }
        System.out.println(ans);
    }

}
