package All_Problems;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @ClassName Maximum_Length_of_Pair_Chain_646
 * @Description
 * @Author cjx
 * @Date 2022/9/3 21:43
 * @Version 1.0
 */
public class Maximum_Length_of_Pair_Chain_646 {
    public int findLongestChain(int[][] pairs){
        Arrays.sort(pairs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1]!=o2[1]){
                    return o1[1]-o2[1];
                }else return o1[0]-o2[0];
            }
        });
        int bound=pairs[0][1];
        int n= pairs.length;
        int cnt=1;
        for (int i = 1; i <n ; i++) {
            int[] cur=pairs[i];
            if(bound<cur[0]) {
                cnt++;
                bound=cur[1];
            }
        }
        return cnt;
    }

}
