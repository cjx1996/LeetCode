/**
 * @ClassName Student_Attendance_Record_I_551
 * @Description
 * @Author cjx
 * @Date 2021/8/17 9:57
 * @Version 1.0
 */
public class Student_Attendance_Record_I_551 {
    public boolean checkRecord(String s) {
        char[] chars = s.toCharArray();
        int aCount = 0;
        int lCont = 0;
        int lMax = 0;
        for (char c : chars) {
            if (c == 'P') {
                lCont = 0;
                continue;
            } else if (c == 'A') {
                lCont = 0;
                aCount++;
            } else {
                lCont++;
                lMax = Math.max(lMax, lCont);
            }
        }
        if (aCount >= 2 || lMax >= 3) return false;
        else return true;
    }
}
