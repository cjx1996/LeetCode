package All_Problems;

import org.junit.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @ClassName Number_of_Orders_in_the_Backlog_1801
 * @Description
 * @Author cjx
 * @Date 2023/1/2 10:54
 * @Version 1.0
 */
public class Number_of_Orders_in_the_Backlog_1801 {
    @Test
    public void test(){
        int[][] orders=new int[][]{
                {10,5,0},
                {15,2,1},
                {25,1,1},
                {30,4,0}
        };
        System.out.println(getNumberOfBacklogOrders(orders));
    }
    public int getNumberOfBacklogOrders(int[][] orders) {
        int ans = 0;
        final int N = (int) 1e9 + 7;
        int n = orders.length;
        PriorityQueue<int[]> buy = new PriorityQueue<>((a, b) -> (b[0] - a[0]));
        PriorityQueue<int[]> sell = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        for (int i = 0; i < n; i++) {
            int[] order = orders[i];
            if (order[2] == 1) {
                while (!buy.isEmpty() && buy.peek()[0] >= order[0] && order[1] > 0) {
                    if (order[1] >= buy.peek()[1]) {
                        order[1] -= buy.peek()[1];
                        buy.poll();
                    } else {
                        buy.peek()[1] -= order[1];
                        order[1] = 0;
                    }
                }
                if (order[1] > 0) sell.add(order);
            } else {
                while (!sell.isEmpty() && sell.peek()[0] <= order[0] && order[1] > 0) {
                    if (order[1] >= sell.peek()[1]) {
                        order[1] -= sell.peek()[1];
                        sell.poll();
                    } else {
                        sell.peek()[1] -= order[1];
                        order[1] = 0;
                    }
                }
                if (order[1] > 0) buy.add(order);
            }

       }
        while(!sell.isEmpty()){
            ans=(ans+sell.poll()[1])%N;
        }
        while(!buy.isEmpty()){
            ans=(ans+buy.poll()[1])%N;
        }
        return ans;
    }
}
