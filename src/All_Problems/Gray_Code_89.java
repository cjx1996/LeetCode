package All_Problems;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Gray_Code_89
 * @Description
 * @Author cjx
 * @Date 2022/1/8 10:48
 * @Version 1.0
 */
public class Gray_Code_89 {
    public List<Integer> grayCodee(int n){
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(0);
        while(n-->0){
            int len = ans.size();
            for(int i = len-1;i>=0;i--){
                ans.add(ans.get(i)+len);
            }
        }
        return ans;
    }
}
