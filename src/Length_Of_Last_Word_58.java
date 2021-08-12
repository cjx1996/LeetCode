/**
 * @ClassName Length_Of_Last_Word_58
 * @Description
 * @Author cjx
 * @Date 2021/6/12 23:26
 * @Version 1.0
 */
public class Length_Of_Last_Word_58 {
    public int lengthOfLastWord(String s){

        int len = s.length();
        boolean count = false;
        int end = 0, sta =0;
        for(int i =len-1;i>=0;i--){
            if(s.charAt(i)!=' '&&!count){
                end = i+1;
                count = true;

            }

            if(s.charAt(i)==' '&&count){
                sta = i;
                return (end-sta-1);

            }

        }
        return end;
    }
}
