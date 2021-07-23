import org.junit.Test;

import java.util.concurrent.ForkJoinPool;

/**
 * @ClassName Count_and_Say_38
 * @Description TODO 为什么同样的逻辑，迭代比递归用了更多的时间？
 * @Author cjx
 * @Date 2021/7/18 23:04
 * @Version 1.0
 */
public class Count_and_Say_38 {
    @Test
    public void test() {
        System.out.println(countAndSay(5));
    }

    public String countAndSay(int n) {
        if (n == 1) return "1";
        char[] res = countAndSay(n - 1).toCharArray();
        StringBuffer currStr = new StringBuffer();
        int len = res.length;
        int start = 0;
        for (int j = 1; j < len+1; j++) {

            if(j==len||res[j]!=res[start]){
                currStr.append(j-start).append(res[start]);
                start = j;
            }
        }
        return String.valueOf(currStr);
    }
}
