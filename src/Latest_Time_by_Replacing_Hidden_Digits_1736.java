import org.junit.Test;

/**
 * @ClassName Latest_Time_by_Replacing_Hidden_Digits_1736
 * @Description
 * @Author cjx
 * @Date 2021/7/24 9:55
 * @Version 1.0
 */
public class Latest_Time_by_Replacing_Hidden_Digits_1736 {
    @Test
    public void test(){
        String time = "?4:03";
        String currTime = maximumTime(time);
        System.out.println(currTime);
    }
    public String maximumTime(String time) {
        char[] charTime = time.toCharArray();
        if (charTime[4] == '?') charTime[4] = '9';
        if (charTime[3] == '?') charTime[3] = '5';
        if (charTime[0] == '?') {
            if(charTime[1]=='?'||(charTime[1]-'0')<=3)
            {
                charTime[0] = '2';
            }else{
                charTime[0] ='1';
            }
        }
        if (charTime[1] == '?') {
            if (charTime[0] == '2') charTime[1] = '3';
            else charTime[1] = '9';
        }
        return String.valueOf(charTime);
    }
}
