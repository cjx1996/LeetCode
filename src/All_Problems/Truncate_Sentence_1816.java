package All_Problems;

/**
 * @ClassName Truncate_Sentence_1816
 * @Description String
 * @Author cjx
 * @Date 2021/12/6 16:29
 * @Version 1.0
 */
public class Truncate_Sentence_1816 {
    public String truncateSentence(String s,int k){
        char[] sc = s.toCharArray();
        int len= sc.length;
        int r= 0;
        for (int i = 0; i < k; i++) {
            while(r<len&&sc[r]!=' ') r++;
            if(i==k-1) break;
            if(r<len) r++;
        }
        return s.substring(0,r);
    }
}
