package All_Problems;

import java.util.Arrays;

/**
 * @ClassName Mice_and_Cheese_2611
 * @Description
 * @Author 陈加兴
 * @Date 2023/6/7 08:33
 * @Version 1.0
 */
public class Mice_and_Cheese_2611 {
    public int miceAndCheese(int[] reward1,int[] reward2,int k){
        int n =reward1.length;
        int[] arr=new int[n];
        for (int i = 0; i < n; i++) {
            arr[i]=reward2[i]-reward1[i];
        }
        int ans=0;
        for (int i = 0; i < n; i++) {
            ans+=reward2[i];
        }
        Arrays.sort(arr);
        for (int i = 0; i < k; i++) {
            ans-=arr[i];
        }
        return ans;
    }
}
