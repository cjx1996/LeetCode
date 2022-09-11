package Contest;

import org.junit.Test;

/**
 * @ClassName CheckDistances
 * @Description
 * @Author cjx
 * @Date 2022/9/4 10:45
 * @Version 1.0
 */
public class CheckDistances {
    @Test
    public void test(){
        String s="zz";
        int[] distance=new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1};
        System.out.println(checkDistances(s,distance));
    }
    public boolean checkDistances(String s, int[] distance) {
        int[] dis=new int[26];
        char[] cs=s.toCharArray();
        for(int i=0;i<cs.length;i++){
            char c=cs[i];
            dis[c-'a']=i-dis[c-'a'];
        }
        for(int i=0;i<dis.length;i++){

            if(dis[i]!=0&&dis[i]!=distance[i]+1){
                return false;
            }
        }
        return true;
    }

}
