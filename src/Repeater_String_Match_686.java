/**
 * @ClassName Repeater_String_Match_686
 * @Description
 * @Author cjx
 * @Date 2021/12/22 20:28
 * @Version 1.0
 */
public class Repeater_String_Match_686 {
    public int repeatedStringMatch(String a,String b){
        StringBuilder sb = new StringBuilder();
        int ans = 0;
        while(sb.length()<b.length()&&++ans>0) sb.append(a);
        sb.append(a);
        int index = sb.indexOf(b);
        if(index==-1) return -1;
        return index+b.length()<ans*a.length()?ans+1:ans;
    }
}
