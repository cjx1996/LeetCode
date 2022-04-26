package All_Problems;

import org.junit.Test;

/**
 * @ClassName Maximum_Element_After_Decreasing_and_Rearranging_1846
 * @Description
 * @Author cjx
 * @Date 2021/7/15 12:42
 * @Version 1.0
 */
public class Maximum_Element_After_Decreasing_and_Rearranging_1846 {
    @Test
    public void test(){
        int[] arr = new int[]{100,1,1000};
        System.out.println(maximumElementAfterDecrementingAndRearranging(arr));
    }


    public int maximumElementAfterDecrementingAndRearranging(int[] arr){
        int n = arr.length;
        int miss = 0 ;
        int[] cnt = new int[n];
        for(int num:arr){
            cnt[Math.min(num,n)-1]++;
        }
        for (int i = 0; i < n; i++) {
            miss -=Math.min(miss,cnt[i]-1);
        }
        return n-miss;
    }
}
