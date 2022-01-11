import java.util.*;

/**
 * @ClassName Hands_of_Straights_846
 * @Description
 * @Author cjx
 * @Date 2021/12/30 10:03
 * @Version 1.0
 */
public class Hands_of_Straights_846 {
    public boolean isNStraightHand(int[] hand,int groupSize){
      if(groupSize==0||hand.length%groupSize!=0) return false;
      Arrays.sort(hand);
      int n = hand.length;
      boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if(!visited[i]){
                int key  = hand[i];
                int j = i;
                while(key<hand[i]+groupSize){
                    if(j>=n) return false;
                    if(!visited[j]&&hand[j]==key){
                        key++;
                        visited[j] = true;
                    }
                    j++;
                }
            }
        }
        return true;
    }
}
