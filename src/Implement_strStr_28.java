import org.junit.Test;

/**
 * @ClassName Implement_strStr_28
 * @Description TODO
 * @Author cjx
 * @Date 2021/5/28 16:05
 * @Version 1.0
 */
public class Implement_strStr_28 {
    @Test
    public void test(){
        String haystack = "hello";
        String needle = "";
        System.out.println(strStr(haystack,needle));
    }
    public int strStr(String haystack, String needle){
        int index = haystack.indexOf(needle);
        return index;
    }

    /**
     * KMP算法
     * ss：原串（string） pp：匹配串（pattern）
     * @param ss
     * @param pp
     * @return
     */
    public int strStrKMP(String ss, String pp){
        if(pp.isEmpty()) return 0;

        //分别读取原串和匹配串的长度
        int n = ss.length(),m=pp.length();

        //原串和匹配串前面都加空格，使其下标从1开始
        ss = " " + ss;
        pp = " " + pp;

        char[] s = ss.toCharArray();
        char[] p = pp.toCharArray();

        //构建next数组，数组长度为匹配串的长度（next数组是和匹配串相关的）
        int[] next = new int[m + 1];
        //构造过程i=2,j=0开始，i小于等于匹配串长度【构造i从2开始】
        for (int i = 2,j = 0; i <= m; i++) {
            //匹配不成功的话，j=next(j)
            while(j>0&&p[i]!=p[j+1]) j = next[j];
            //匹配成功的话，先让j++
            if(p[i]==p[j+1]) j++;
            //更新next[i]，结束本次循环，i++
            next[i] = j;
        }

        //匹配过程，i=1，j=0开始，i小于等于原串长度【匹配i从1开始】
        for(int i = 1,j=0;i<=n;i++){
            //匹配不成功，j=next(j)
            while(j>0&&s[i]!=p[j+1]) j = next[j];
            //匹配成功的话，先让j++,结束本次循环后i++
            if(s[i]==p[j+1]) j++;
            //整一段匹配成功，直接返回下标
            if(j==m) return i-m;

        }
        return -1;
    }

}
