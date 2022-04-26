package All_Problems;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Largest_Integer_6037
 * @Description
 * @Author cjx
 * @Date 2022/4/10 10:39
 * @Version 1.0
 */
public class Largest_Integer_6037 {
    public int largestInteger(int num){
        List<Integer> odd = new ArrayList<>();
        List<Integer> even = new ArrayList<>();
        List<Integer> odd_num = new ArrayList<>();
        List<Integer> even_num = new ArrayList<>();
        int ans = 0;
        int i = 0;
        while(num!=0){
            int cur = num%10;
            if(cur%2==0){
                even.add(i);
                even_num.add(cur);
            }else{
                odd.add(i);
                odd_num.add(cur);
            }
            i++;
            num/=10;
        }
        odd.sort((o1,o2)->o2-o1);
        even.sort((o1,o2)->o2-o1);
        odd_num.sort((o1,o2)->o2-o1);
        even_num.sort((o1,o2)->o2-o1);
        for(i=0;i<odd.size();i++){
            ans+= odd_num.get(i) *Math.pow(10, odd.get(i));
        }
        for(i=0;i< even_num.size();i++){
            ans+=even_num.get(i)*Math.pow(10,even.get(i));
        }
        return ans;
    }
}
