package All_Problems;

/**
 * @ClassName Count_Vowel_Strings_in_Ranges_2559
 * @Description
 * @Author 陈加兴
 * @Date 2023/6/2 10:48
 * @Version 1.0
 */
public class Count_Vowel_Strings_in_Ranges_2559 {
    public int[] vowelStrings(String[] words,int[][] queries){
        boolean[] exist=new boolean[26];
        exist['a'-'a']=true;
        exist['i'-'a']=true;
        exist['e'-'a']=true;
        exist['u'-'a']=true;
        exist['o'-'a']=true;
        int n= words.length;
        int[] count=new int[n+1];
        for(int i=0;i<n;i++){
            String word = words[i];
            count[i+1]=count[i];
            char a=word.charAt(0);
            char b=word.charAt(word.length()-1);
            if(exist[a-'a']&&exist[b-'a'])count[i+1]++;
        }
        int m =queries.length;
        int[] ans=new int[m];
        for (int i = 0; i < m; i++) {
            int[] query=queries[i];
            ans[i]=count[query[1]+1]-count[query[0]];
        }
        return ans;
    }
}
