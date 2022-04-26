package All_Problems;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Additive_Number_306
 * @Description
 * @Author cjx
 * @Date 2022/1/10 15:23
 * @Version 1.0
 */
public class Additive_Number_306 {
    @Test
    public void test() {
        System.out.println(isAdditiveNumber1("101"));
    }

    String num;
    int n;
    public boolean isAdditiveNumber1(String _num) {
        num=_num;
        n = num.length();
        List<Integer> a = new ArrayList<>();
        for (int i = 0; i < n / 2; i++) {
            a.add(0,num.charAt(i)-'0');
            int end1 = i;
            if(num.charAt(0)=='0'){
                i = n/2;
            }
            List<Integer> b= new ArrayList<>();
            for (int j = end1+1; j < 2*n/3+1; j++) {
                int end2 = j;
                b.add(0,num.charAt(j)-'0');
                if(num.charAt(end1+1)=='0'){
                    j = 2*n/3+1;
                }
                if(check( a,b,end2+1,2)) return true;
            }
        }
        return false;
    }
    boolean check(List<Integer> a,List<Integer> b,int start,int cnt){
        if(start==n) return cnt>=3;
        List<Integer> ans = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i < a.size() || i < b.size(); i++) {
            if (i < a.size()) sum += a.get(i);
            if (i < b.size()) sum += b.get(i);
            ans.add(sum % 10);
            sum /= 10;
        }
        if (sum > 0) ans.add(sum);
        int len = ans.size();
        if(start+len>n) return false;
        for (int i = 0; i <len; i++) {
            if(ans.get(i)!=num.charAt(start+len-i-1)-'0') return false;
        }

        return check(b,ans,start+len,cnt+1);
    }



    List<List<Integer>> list = new ArrayList<>();

    public boolean isAdditiveNumber(String num) {
        this.num = num;
        n = num.length();
        return dfs(0);
    }

    boolean dfs(int u) {
        if (u == n) return list.size() > 2;
        int max = num.charAt(u) == '0' ? u + 1 : n;
        List<Integer> tem = new ArrayList<>();
        for (int i = u; i < max; i++) {
            tem.add(0, num.charAt(i) - '0');
            int len = list.size();
            if (len > 0 && i - u + 1 < list.get(len - 1).size()) continue;
            if (len < 2 || check(list.get(len - 2), list.get(len - 1), tem)) {
                list.add(tem);
                if (dfs(i + 1)) return true;
                list.remove(len);
            }
        }
        return false;
    }

    boolean check(List<Integer> a, List<Integer> b, List<Integer> c) {
        List<Integer> ans = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i < a.size() || i < b.size(); i++) {
            if (i < a.size()) sum += a.get(i);
            if (i < b.size()) sum += b.get(i);
            ans.add(sum % 10);
            sum /= 10;
        }
        if (sum > 0) ans.add(sum);
        if (ans.size() != c.size()) return false;
        for (int i = 0; i < c.size(); i++) {
            if (ans.get(i) != c.get(i)) return false;
        }
        return true;
    }

}
