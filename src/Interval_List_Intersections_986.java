import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName Interval_List_Intersections_986
 * @Description
 * @Author cjx
 * @Date 2021/7/18 21:26
 * @Version 1.0
 */
public class Interval_List_Intersections_986 {
    @Test
    public void test(){
        int[][] firstList = new int[][]{{0,2},{5,10},{13,23},{24,25}};
        int[][] secondList = new int[][]{{1,5},{8,12},{15,24},{25,26}};
        int[][] res = intervalIntersection(firstList, secondList);
        for (int i = 0; i < res.length; i++) {
            for (int i1 = 0; i1 < res[i].length; i1++) {
                System.out.print(res[i][i1]+" ");
            }
            System.out.println();
        }
    }
    public int[][] intervalIntersection(int[][] firstList,int[][] secondList){
        List<int[]> res = new ArrayList<>();
        int fLen = firstList.length;
        int sLen = secondList.length;
        if(fLen==0||sLen==0) return new int[0][0];
        //定义两个指针
        int i = 0,j =0;
        while(i<fLen&&j<sLen){
            //得到可能交集的下界
            int lo = Math.max(firstList[i][0],secondList[j][0]);
            //得到可能交集的上界
            int hi = Math.min(firstList[i][1],secondList[j][1]);

            //如果上界，下界可以组成区间，加入结果集中
            if(lo<=hi){
                res.add(new int[]{lo,hi});
            }
            //哪个区间的上界靠后，就移动另一个指针
            if(firstList[i][1]>secondList[j][1]){
                j++;
            }else{
                i++;
            }
        }

        return res.toArray(new int[res.size()][]);

    }


}
