import org.junit.Test;

import java.util.*;
import java.util.function.Function;

/**
 * @author cjx
 * @description
 * @create 2021-01-21-16:01
 */
public class Generate_Parentheses_22 {

    public List<String> generateParenthesis3(int n) {
        List<String> ans=new ArrayList<>();
        backtrack(ans,new StringBuilder(),0,0,n);
        return ans;
    }
    public void backtrack(List<String> ans,StringBuilder cur,int open,int close,int n ){
        if(cur.length()==2*n){
            ans.add(cur.toString());
            return;
        }
        if(open<n){  //左括号数目小于n
            cur.append('(');
            backtrack(ans,cur,open+1,close,n);
            cur.deleteCharAt(cur.length()-1);
        }
        if(close<open){  //左括号数目大于右括号数目
            cur.append(')');
            backtrack(ans,cur,open,close+1,n);
            cur.deleteCharAt(cur.length()-1);
        }
    }






    public int bits(int n) {
        int res = 0;
        while (n != 0) {
            n &= n - 1;
            res++;
        }
        return res;

    }

    /**
     * 将左括号(看做1，右括号)看做0，依次判断所有的数是否符合规则
     * @param n
     * @return
     */
    public List<String> generateParenthesis2(int n) {

        List<String> ans = new ArrayList<>();

        for (int i = 0; i < (1 << 2 * n); i++) {
            String s = "";
            boolean flag = true;
            int count = 0;//定义多记录的"("个数
            int j = i;//代表当前循环使用的数值

            if (bits(j) == n) {
                while (flag&&(j!=0)) {
                    if (j % 2 == 0) {
                        s += "(";
                        count++;
                    } else {
                        if (count > 0) {
                            s += ")";
                            count--;
                        } else {
                            flag = false;
                        }
                    }
                    j/=2;
                }
                if (flag && s.length() == 2 * n) {

                    ans.add(s);
                }
            }
        }
        return ans;


    }

    //动态规划
    public List<String> generateParenthesis1(int n) {

        List<List<String>> ans = new ArrayList<>();
        ans.add(Arrays.asList(""));
        ans.add(Arrays.asList("()"));
        for (int i = 2; i <= n; i++) {
            List<String> listI = new ArrayList<>();
            for (int p = 0; p < i; p++) {
                for (String in : ans.get(p)) {
                    for (String out : ans.get(i - 1 - p)) {
                        listI.add("(" + in + ")" + out);
                    }
                }
            }
            ans.add(listI);
        }
        return ans.get(n);
    }

    @Test
    public void test() {
        List<String> result = generateParenthesis1(4);
        System.out.println(result.size());
        System.out.println(result);
    }
    @Test
    public void test2() {
        List<String> result = generateParenthesis2(4);
        System.out.println(result.size());
        System.out.println(result);
    }
    @Test
    public void test3() {
        List<String> result = generateParenthesis3(4);
        System.out.println(result.size());
        System.out.println(result);
    }

}
