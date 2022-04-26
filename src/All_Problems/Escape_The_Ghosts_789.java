package All_Problems;

/**
 * @ClassName Escape_The_Ghosts_789
 * @Description
 * @Author cjx
 * @Date 2021/8/22 9:45
 * @Version 1.0
 */
public class Escape_The_Ghosts_789 {
    public boolean escapeGhosts(int[][] ghosts,int[] target){
        int move = distance(new int[]{0,0}, target);
        for (int[] ghost : ghosts) {
            int dis = distance(ghost,target);
            if(dis<=move){
                return false;
            }
        }
        return true;
    }
    int distance(int[] p1,int[] p2){
        return Math.abs(p1[0]-p2[0])+Math.abs(p1[1]-p2[1]);
    }
}
