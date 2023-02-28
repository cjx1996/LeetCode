package Contest;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @ClassName FindCrossTime_6306
 * @Description
 * @Author cjx
 * @Date 2023/1/8 11:35
 * @Version 1.0
 */
public class FindCrossTime_6306 {
    public int findCrossingTime(int n,int k,int[][] time){
        ArrayList<int[]> lToB=new ArrayList<>();

        ArrayList<int[]> rToB=new ArrayList<>();
        PriorityQueue<int[]> lW=new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1]+o1[3]==o2[1]+o1[3])return o1[0]-o2[0];
                else if(o1[1]+o1[3]<o2[1]+o2[3]) return 1;
                else return -1;
            }
        });
        PriorityQueue<int[]> rW=new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1]+o1[3]==o2[1]+o1[3])return o1[0]-o2[0];
                else if(o1[1]+o1[3]<o2[1]+o2[3]) return 1;
                else return -1;
            }
        });
        int ans=0;
        for (int i = 0; i < k; i++) {
            lW.add(new int[]{i,time[i][0],time[i][1],time[i][2],time[i][3],0});
        }
        do{
            if(!rW.isEmpty()){
                int[] wk=rW.poll();
                ans+=wk[3];
                wk[4]=ans;
                lToB.add(wk);
            }else if(!lW.isEmpty()&&n>0){
                int[] wk=lW.poll();
                ans+=wk[3];
                wk[4]=ans;
                rToB.add(wk);
                n--;
            }else{
                ans++;
            }
            for (int[] wk : lToB) {
                if(wk[4]+wk[5]<=ans) lW.add(wk);
                lToB.remove(wk);
            }
        }while(n!=0|| lW.size()!=k);
        return ans;
    }

}
