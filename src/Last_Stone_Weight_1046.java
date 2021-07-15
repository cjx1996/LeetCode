import org.junit.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @ClassName Last_Stone_Weight_1046
 * @Description TODO
 * @Author cjx
 * @Date 2021/6/8 19:38
 * @Version 1.0
 */
public class Last_Stone_Weight_1046 {
    @Test
    public void test(){
        int[] stones = {2, 7, 4, 1, 8, 1};
        System.out.println(lastStoneWeight(stones));
    }
    public int lastStoneWeight(int[] stones){
        PriorityQueue<Integer> heap = new PriorityQueue<>((a,b)->(b-a));
        for(int stone:stones){
            heap.offer(stone);
        }
        while(heap.size()>1){
            int a = heap.poll();
            int b = heap.poll();
            if(a>b){
                heap.offer(a-b);
            }else if(a<b){
                heap.offer(b-a);
            }

        }
        return heap.size()==0?0:heap.poll();
    }
}
