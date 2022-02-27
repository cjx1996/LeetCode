/**
 * @ClassName Longest_Nice_Substring_1763
 * @Description
 * @Author cjx
 * @Date 2022/2/1 10:47
 * @Version 1.0
 */

public class Longest_Nice_Substring_1763 {
    int maxPos = 0, maxLen = 0;

    public String longestNiceSubstring(String s) {
        dfs(s, 0, s.length() - 1);
        return s.substring(maxPos, maxPos + maxLen);
    }

    public void dfs(String s, int start, int end) {
        if (start >= end) return;
        int upper = 0;
        int lower = 0;
        char[] chars = s.substring(start, end + 1).toCharArray();
        for (char c : chars) {
            if (c >= 'A' && c <= 'Z') {
                upper |= 1 << (c - 'A');
            } else {
                lower |= 1 << (c - 'a');
            }
        }
        if (upper == lower) {
            if (maxLen < end - start + 1) {
                maxLen = end - start + 1;
                maxPos = start;
            }
            return;
        }
        int valid = lower & upper;
        int pos = start;
        while (pos <= end) {
            start = pos;
            while (pos <= end && ((valid & (1 << (Character.toLowerCase(s.charAt(pos)) - 'a'))) != 0)) {
                pos++;
            }
            dfs(s, start, pos - 1);
            pos++;
        }
    }
}
/*
    public String longestNiceSubstring(String s){
        int n = s.length();
        if(n==1) return "";
        for (int i = n; i >=1; i--) {
            for (int j = 0; j <=n-i; j++) {
                if(check(s.substring(j,j+i))){
                    return s.substring(j,j+i);
                }
            }
        }
       return "";
    }
    private boolean check(String s){
        int upper = 0;
        int lower=0;
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if(c>='A'&&c<='Z'){
                upper|=1<<(c-'A');
            }else{
                lower|=1<<(c-'a');
            }
        }
        if(lower==upper){
            return true;
        }else{
            return false;
        }
    }

*/


