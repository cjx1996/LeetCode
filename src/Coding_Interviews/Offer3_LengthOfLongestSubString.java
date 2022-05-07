package Coding_Interviews;

import org.junit.Test;

/**
 * @ClassName Offer3_LengthOfLongestSubString
 * @Description
 * @Author cjx
 * @Date 2022/4/27 14:51
 * @Version 1.0
 */
public class Offer3_LengthOfLongestSubString {
    @Test
    public void test2(){
        for (int i = 0; i <=12800; i++) {
            System.out.print((char)i+" ");
            if(i%128==0) System.out.println("换行"+i);
        }
    }
    @Test
    public void test(){
        String s= " ";
        System.out.println(lengthOfLongestSubstring(s));
    }
    public int lengthOfLongestSubstring(String s){
        int n =s.length();
        if(n==0) return 0;
        int[] cnt =new int[256];
        char[] cs= s.toCharArray();
        int l =0,r=0;
        int ans = 0;
        while(r<n){
            while(r<n&&cnt[cs[r]]++==0)r++;
            ans = Math.max(ans,r-l);
            while(r<n&&cnt[cs[r]]>1){
                cnt[cs[l]]--;
                l++;
            }
            r++;
        }
        return ans;
    }

}
