import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName Find_Good_Days_to_Rob_the_Bank_2100
 * @Description
 * @Author cjx
 * @Date 2022/3/6 12:58
 * @Version 1.0
 */
public class Find_Good_Days_to_Rob_the_Bank_2100 {
    public List<Integer> goodDaysToRobBank(int[] security, int time){
        if(time==0) return Arrays.stream(security).boxed().collect(Collectors.toList());
        int n = security.length;
        if(n<2*time+1) return null;
        int[] before = new int[n],after = new int[n];
        for (int i = 1; i < n; i++) {
            before[i] = security[i]<=security[i-1]?1:-1;
            after[i-1] = security[i-1]<=security[i]?1:-1;
        }
        int[] sum=new int[n];
        for (int i = 1; i <=time; i++) {
            sum[time] +=before[i];
            sum[time] +=after[i+time-1];
        }
        for(int i =time+1;i+time<=n-1;i++){
            sum[i] = sum[i-1]-after[i-1]+after[i+time-1]+before[i]-before[i-time];
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if(sum[i]==2*time) ans.add(i);
        }
        return ans;
    }
}
