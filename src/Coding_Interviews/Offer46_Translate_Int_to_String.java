package Coding_Interviews;

import org.junit.Test;

/**
 * @ClassName Offer46_Convert_Int_to_String
 * @Description
 * @Author cjx
 * @Date 2022/4/27 14:32
 * @Version 1.0
 */
public class Offer46_Translate_Int_to_String {
    @Test
    public void test(){
        System.out.println(translateNum(12258));
    }
    public int translateNum(int num){
        String str= String.valueOf(num);
        int n = str.length();
        int[] cs= new int[n];
        for(int i =0;i<n;i++){
            cs[i]=str.charAt(i)-'0';
        }
        int[] dp =new int[n+1];
        dp[0]=1;
        dp[1]=1;
        for(int i =1;i<n;i++){
            dp[i+1]=dp[i];
            int cur = cs[i-1]*10+cs[i];
            if(cur<=25&&cur>=10) dp[i+1]+=dp[i-1];
        }
        return dp[n];

    }

}
