package Models;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @ClassName ByteDance_TimeManage
 * @Description 给定一个数组，每个元素包含两个数值，分别表示需要花费的时间和能创造价值
 * 只能完成两个任务，且必须是在一定时间m内，输出能完成的最大任务价值总和
 * 输入：第一行包含两个整数 n,m,分别表示任务的数目、能支配的总时长
 * 接下来n行描述每个任务 每行包含两个整数a/b，分别表示完成任务需要花费的时间和价值
 * 任务按照升序排序给出
 * 输出：输出能完成的最大任务价值总和。如果无法完成，输出0
 * @Author cjx
 * @Date 2022/5/6 11:06
 * @Version 1.0
 */
public class ByteDance_TimeManage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        if (n == 0) {
            System.out.println(0);
            return;
        }
        int[][] tasks = new int[n][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                tasks[i][j] = scanner.nextInt();
            }
        }

        PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        int curTime = m;
        for (int i = 0; i < n; i++) {
            int[] task = tasks[i];
            if (curTime >= task[0] && q.size() < 2) {
                q.add(task);
                curTime -= task[0];
            }else if(q.size()==2&&q.peek()[1]<task[1]){
                if(q.peek()[0]+curTime>=task[0]){
                    curTime+=q.peek()[0]-task[0];
                    q.poll();
                    q.add(task);
                }
            }
        }
        if(q.size()!=2) {
            System.out.println(0);
        }else{
            System.out.println(q.poll()[1]+q.poll()[1]);
        }
    }
}
