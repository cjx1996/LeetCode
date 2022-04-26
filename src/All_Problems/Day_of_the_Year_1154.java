package All_Problems;

/**
 * @ClassName Day_of_the_Year_1154
 * @Description Math  String
 * @Author cjx
 * @Date 2021/12/21 19:08
 * @Version 1.0
 */
public class Day_of_the_Year_1154 {
    public int dayofYear(String date){
        int year = Integer.valueOf(date.substring(0,4));
        int month = Integer.valueOf(date.substring(5,7));
        int day = Integer.valueOf(date.substring(8,10));
        int[] days = new int[]{
                31,28,31,30,31,30,31,31,30,31,30,31
        };
        int sum  =0;
        for (int i = 0; i < month-1; i++) {
            sum +=days[i];
        }
        sum+=day;
        if((year%400==0||(year%100!=0&&year%4==0))&&month>2){
            sum++;
        }
        return sum;
    }
}
