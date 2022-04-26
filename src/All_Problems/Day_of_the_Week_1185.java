package All_Problems;

import org.junit.Test;

/**
 * @ClassName Day_of_the_Week_1185
 * @Description
 * @Author cjx
 * @Date 2022/1/3 10:26
 * @Version 1.0
 */
public class Day_of_the_Week_1185 {
    @Test
    public void test() {
        System.out.println(dayOfTheWeek(31, 8, 2019));
    }

    public String dayOfTheWeek(int day, int month, int year) {
        int days = (year - 1971) * 365 + (year - 1969) / 4+4;
        int[] months = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        for (int i = 0; i < month-1; i++) {
            days += months[i];
        }
        if (year % 4 == 0&&month>2&&year!=2100) days++;
        days += day;
        String[] dd = new String[]{
                "Sunday",
                "Monday",
                "Tuesday",
                "Wednesday",
                "Thursday",
                "Friday",
                "Saturday"
        };
        return dd[days % 7];
    }
}
