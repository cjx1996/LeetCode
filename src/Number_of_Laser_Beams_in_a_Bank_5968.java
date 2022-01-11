/**
 * @ClassName Number_of_Laser_Beams_in_a_Bank_5968
 * @Description
 * @Author cjx
 * @Date 2022/1/2 10:38
 * @Version 1.0
 */
public class Number_of_Laser_Beams_in_a_Bank_5968 {
    public int numberOfBeams(String[] bank){
        int pre = 0,cur = 0;
        int ans = 0;
        for (int i = 0; i < bank.length; i++) {
            cur = num(bank[i]);
            if(cur==0) continue;
            if(pre!=0){
                ans+=pre*cur;
                pre = cur;
            }else{
                pre=cur;
            }
        }
        return ans;
    }
    int num(String row){
        char[] cs = row.toCharArray();
        int ans = 0;
        for (int i = 0; i < cs.length; i++) {
            if(cs[i]=='1') ans++;
        }return ans;
    }
}
