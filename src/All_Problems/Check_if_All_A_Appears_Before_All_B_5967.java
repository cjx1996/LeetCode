package All_Problems;

/**
 * @ClassName Check_if_All_A_Appears_Before_All_B_5967
 * @Description
 * @Author cjx
 * @Date 2022/1/2 10:32
 * @Version 1.0
 */
public class Check_if_All_A_Appears_Before_All_B_5967 {
    public boolean checkString(String s){
        char[] cs = s.toCharArray();
        int a = -1,b=-1;
        for (int i = 0; i < cs.length; i++) {
            if(cs[i]=='b'){
                b=i;
            }else if(b!=-1){
                return false;
            }
        }return true;
    }
}
