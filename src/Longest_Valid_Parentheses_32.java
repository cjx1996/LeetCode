import org.junit.Test;

import java.util.Stack;

/**
 * @ClassName Longest_Valid_Parentheses_32
 * @Description TODO
 * @Author cjx
 * @Date 2021/7/15 17:57
 * @Version 1.0
 */
public class Longest_Valid_Parentheses_32 {
    @Test
    public void test(){
        String s = "((()";
        System.out.println(longestValidParentheses(s));
    }


    public int longestValidParentheses(String s ){
        int max = 0;
        int left=0,right =0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)=='('){
                left++;
            }else{
                right++;

            }
            if(right>left){
                left = 0;
                right =0;
            }
            if(left==right){
                max = Math.max(2*right,max);
            }
        }
        left =0;
        right =0;
        for (int i = s.length()-1; i >0 ;i--) {
            if(s.charAt(i)=='('){
                left++;
            }else{
                right++;

            }
            if(right<left){
                left = 0;
                right =0;
            }
            if(left==right){
                max = Math.max(2*left,max);
            }
        }


        return max;
    }


    public int longestValidParentheses2(String s ){
        Stack<Integer> sta = new Stack<>();
        sta.push(-1);
        int max =0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)=='(') sta.push(i);
            else{
                 sta.pop();
                if(sta.empty()){
                    sta.push(i);
                }else{
                    max = Math.max(max,i-sta.peek());
                }
            }
        }
        return max;

    }

    public int longestValidParentheses1(String s){
        int n = s.length();
        int max = 0;
        int[] dp = new int[n];

        for (int i = 1; i < n; i++) {
            if(s.charAt(i)==')'){

                if(s.charAt(i-1)=='(') {
                    dp[i] = (i>2?dp[i-2]:0)+2;
                }else if((i-1>=dp[i-1])&&s.charAt(i-1-dp[i-1])=='('){
                    dp[i] = dp[i-1]+2+(i-2>=dp[i-1]? dp[i-2-dp[i-1]]:0);
                }
            }

            max = Math.max(dp[i],max);
        }
        return max;
    }
}
