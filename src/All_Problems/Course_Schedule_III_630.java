package All_Problems;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @ClassName Course_Schedule_III_630
 * @Description
 * @Author cjx
 * @Date 2021/12/14 18:06
 * @Version 1.0
 */
public class Course_Schedule_III_630 {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses,(a,b)->a[1]-b[1]);
        Queue<Integer> qD = new PriorityQueue<Integer>((a,b)->b-a);
        int ddl = 0;
        for (int i = 0; i < courses.length; i++) {
            int[] tem = courses[i];
            if (tem[0] + ddl <= tem[1]) {
                ddl += tem[0];
                qD.add(tem[0]);
            }else if(qD.size()>0&&qD.peek()>tem[0]){
                ddl-=qD.poll();
                qD.add(tem[0]);
                ddl+=tem[0];
            }
        }
        return qD.size();
    }
}
