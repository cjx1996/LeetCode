package All_Problems;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Exclusive_Time_of_Functions_636
 * @Description
 * @Author cjx
 * @Date 2022/8/7 11:24
 * @Version 1.0
 */
public class Exclusive_Time_of_Functions_636 {
    @Test
    public void test(){
        int n = 2;
        List<String> logs=new ArrayList<>();
        logs.add("0:start:0");
        logs.add("0:start:2");
        logs.add("0:end:5");
        logs.add("1:start:6");
        logs.add("1:end:6");
        logs.add("0:end:7");
        int[] ans=exclusiveTime(n,logs);
        for (int i : ans) {
            System.out.println(i);
        }
    }
    public int[] exclusiveTime(int n, List<String> logs){
        int[] ans=new int[n];
        ArrayDeque<Integer> stack=new ArrayDeque<>();
        int time=0;
        for (String log : logs) {
            String[] ss=log.split(":");
            int id=Integer.valueOf(ss[0]);
            int ddl=Integer.valueOf(ss[2]);
            if(ss[1].equals("start")){
                ddl--;
                if(!stack.isEmpty()){
                    ans[stack.peek()]+=ddl-time;
                }
                stack.push(id);
            }else{
                ans[stack.pop()]+=ddl-time;
            }
            time=ddl;
        }
        return ans;
    }
}
