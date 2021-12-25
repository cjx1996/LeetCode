import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @ClassName K_th_Smallest_Prime_Fraction_786
 * @Description Heap(Priority Queue)
 * @Author cjx
 * @Date 2021/11/29 14:51
 * @Version 1.0
 */
public class K_th_Smallest_Prime_Fraction_786 {
    public int[] kthSmallestPrimeFraction(int[] arr,int k){
        int len = arr.length;
        Queue<int[]> sHeap = new PriorityQueue<>((a,b)->{
            double m = arr[a[0]]*1.0/arr[a[1]],n = arr[b[0]]*1.0/arr[b[1]];
            return Double.compare(m,n);
        });
        for (int i = 1; i < len; i++) {
            sHeap.add(new int[]{0,i});
        }
        while(k-->1){
            int[] curr = sHeap.poll();
            int i = curr[0],j = curr[1];
            if(i+1<j) sHeap.add(new int[]{i+1,j});
        }
        int[] poll = sHeap.poll();
        return new int[]{arr[poll[0]],arr[poll[1]]};
    }
}
