package Contest;

import org.junit.Test;

/**
 * @ClassName IsItPossible_6284
 * @Description
 * @Author cjx
 * @Date 2023/1/8 11:02
 * @Version 1.0
 */
public class IsItPossible_6284 {
    @Test
    public void test(){
        String word1="aa",word2="ab";
        System.out.println(isItPossible(word1,word2));
    }
    public boolean isItPossible(String word1, String word2) {
        int[] cnt1=new int[26],cnt2=new int[26];
        int n1=word1.length(),n2=word2.length();
        for(int i=0;i<n1;i++){
            cnt1[word1.charAt(i)-'a']++;
        }
        for(int i=0;i<n2;i++){
            cnt2[word2.charAt(i)-'a']++;
        }
        int num1=0,num2=0;
        for(int i=0;i<26;i++){
            if(cnt1[i]>0)num1++;
            if(cnt2[i]>0)num2++;
        }
        for(int i=0;i<26;i++){
            for(int j=0;j<26;j++){
                int a = cnt1[i],b=cnt2[i],c=cnt1[j],d=cnt2[j];
                int tem1=num1,tem2=num2;
                if(a==0||d==0) continue;
                if(i==j){
                    if(tem1==tem2) return true;
                    else continue;
                }
                if(a==1) tem1--;
                if(d==1)tem2--;
                if(c==0)tem1++;
                if(b==0)tem2++;
                if(tem1==tem2) return true;
            }
        }
        return false;
    }
}
