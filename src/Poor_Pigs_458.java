/**
 * @ClassName Poor_Pigs_458
 * @Description
 * @Author cjx
 * @Date 2021/11/25 22:51
 * @Version 1.0
 */
public class Poor_Pigs_458 {
    public int poorPigs(int buckets, int minuteToDie,int minutesToTest){
        int k  = minutesToTest/minuteToDie;
        return (int)Math.ceil((Math.log(buckets)/Math.log(k+1)));
    }
}
