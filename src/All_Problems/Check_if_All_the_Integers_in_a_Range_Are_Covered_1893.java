package All_Problems;

import org.junit.Test;

/**
 * @ClassName Check_if_All_the_Integers_in_a_Range_Are_Covered_1893
 * @Description
 * @Author cjx
 * @Date 2021/7/23 10:03
 * @Version 1.0
 */
public class Check_if_All_the_Integers_in_a_Range_Are_Covered_1893 {
    @Test
    public void test() {
        int[][] ranges = new int[][]{
                {1, 2},
                {3, 4},
                {5, 6}
        };
        System.out.println(isCovered(ranges, 21, 71));
    }
    public boolean isCovered(int[][] ranges,int left,int right){
        int[] counts= new int[50];
        int len = ranges.length;
        for (int i = 0; i < len; i++) {
            //对每个区间中包含在[left,right]中的数进行计数
            int start = Math.max(ranges[i][0],left);
            int end = Math.min(ranges[i][1],right);
            for(int j = start;j<end+1;j++){
                counts[j-1]=1;
            }
        }
        //遍历数组，如果数组存在为0，说明存在未被包含的数
        for(int i =left;i<right+1;i++){
            if(counts[i-1]==0) return false;
        }
        return true;
    }

    public boolean isCovered1(int[][] ranges, int left, int right) {

        int[] counts = new int[right - left + 1];
        for (int i = 0; i < (counts.length); i++) {
            for (int j = 0; j < ranges.length; j++) {
                int num = left + i;
                if (num >= ranges[j][0] && num <= ranges[j][1]) {
                    counts[i]++;
                }
            }
        }
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] == 0) return false;
        }
        return true;
    }

}
