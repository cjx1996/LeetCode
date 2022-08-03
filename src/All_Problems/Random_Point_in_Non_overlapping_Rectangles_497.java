package All_Problems;

import java.util.Random;

/**
 * @ClassName Random_Point_in_Non_overlapping_Rectangles_497
 * @Description
 * @Author cjx
 * @Date 2022/6/9 19:53
 * @Version 1.0
 */
public class Random_Point_in_Non_overlapping_Rectangles_497 {
    private class Solution{
        int[][] rects;
        int[] index;
        int N=0;
        int sum=0;
        Random random=new Random();
        public Solution(int[][] _rects){
            rects=_rects;
            N=rects.length;
            index=new int[N];
            for (int i = 0; i < N; i++) {
                int[] rect=rects[i];
                sum+=(rect[2]-rect[0]+1)*(rect[3]-rect[1]+1);
                index[i]=sum;
            }
        }

        public int[] pick(){
            int tar =random.nextInt(sum)+1;
            int l =0,r=N-1;
            while(l<r){
                int mid = (l+r)>>1;
                if(index[mid]<tar)l=mid+1;
                else r=mid;
            }
            int dx=random.nextInt(rects[l][2]-rects[l][0]+1);
            int dy=random.nextInt(rects[l][3]-rects[l][1]+1);
            return new int[]{rects[l][0]+dx,rects[l][1]+dy};
        }
    }

}
