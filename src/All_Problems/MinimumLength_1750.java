package All_Problems;

/**
 * @ClassName MinimumLength_1750
 * @Description
 * @Author cjx
 * @Date 2022/12/28 10:11
 * @Version 1.0
 */
public class MinimumLength_1750 {
    public int minimumLength(String s){
        int n =s.length();
        int l=0,r=n-1;
        while(l<r){
            char c=s.charAt(l);
            if(s.charAt(r)!=c) break;
            while(l<n&&s.charAt(l)==c&&l<=r)l++;
            while(r>-1&&s.charAt(r)==c&&l<=r)r--;
        }
        return r-l+1;
    }
}
