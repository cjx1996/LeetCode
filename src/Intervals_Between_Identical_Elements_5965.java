import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName Intervals_Between_Identical_Elements_5965
 * @Description
 * @Author cjx
 * @Date 2021/12/26 11:00
 * @Version 1.0
 */
public class Intervals_Between_Identical_Elements_5965 {
    @Test
    public void test(){
    int[] arr= new int[]{10,5,10,10};
        long[] ans = getDistances(arr);
        for (long an : ans) {
            System.out.println(an);
        }
    }
    public long[] getDistances(int[] arr){
        Map<Integer, ArrayList<Integer>> cnt= new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            ArrayList<Integer> indexs = cnt.getOrDefault(arr[i], new ArrayList<>());
            indexs.add(i);
            cnt.put(arr[i],indexs);
        }
        long[] ans = new long[arr.length];
        for (ArrayList<Integer> value : cnt.values()) {
            value.sort((a,b)->a-b);
            long sum =0;
            for (int i = 0; i < value.size(); i++) {
                sum+=value.get(i);
            }
            for (int i = 0; i < value.size(); i++) {
                if(i==0) ans[value.get(i)] = sum-value.size()*value.get(i);
                else {
                    ans[value.get(i)] = ans[value.get(i-1)]+(i*2-value.size())*(value.get(i)-value.get(i-1));
                }
            }
        }
        return ans;
    }
}
