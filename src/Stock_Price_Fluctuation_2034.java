import java.util.*;

/**
 * @ClassName Stock_Price_Fluctuation_2034
 * @Description
 * @Author cjx
 * @Date 2022/1/23 10:32
 * @Version 1.0
 */
public class Stock_Price_Fluctuation_2034 {
    private class StockPrice1{
        Map<Integer,Integer> map;
        TreeMap<Integer,Integer> tree = new TreeMap<>();
    }
    private class StockPrice {
        PriorityQueue<int[]> min;
        PriorityQueue<int[]> max;
        Map<Integer, Integer> map;
        int maxTime = 0;

        public StockPrice() {
            min = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
            max = new PriorityQueue<>((a, b) -> b[1] - a[1]);
            map = new HashMap<>();
        }

        public void update(int timestamp, int price) {
            maxTime = Math.max(maxTime, timestamp);
            map.put(timestamp, price);
            min.add(new int[]{timestamp, price});
            max.add(new int[]{timestamp, price});

        }

        public int current() {
            return map.get(maxTime);
        }

        public int maximum() {
            while (true) {
                int[] tem = max.peek();
                if (tem[1] == map.get(tem[0])) {
                    return tem[1];
                }
                max.poll();
            }
        }

        public int minimum() {
            while (true) {
                int[] tem = min.peek();
                if (tem[1] == map.get(tem[0])) {
                    return tem[1];
                }
                min.poll();
            }
        }

    }
}
