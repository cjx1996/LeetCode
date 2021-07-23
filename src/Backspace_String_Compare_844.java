import javax.xml.stream.events.Characters;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @ClassName Backspace_String_Compare_844
 * @Description TODO
 * @Author cjx
 * @Date 2021/7/18 18:01
 * @Version 1.0
 */
public class Backspace_String_Compare_844 {
    public boolean backspaceCompare(String s, String t) {
        int sl = s.length() - 1;
        int tl = t.length() - 1;
        int skip1 = 0, skip2 = 0;
        while (sl > -1 || tl > -1) {
            while (sl > -1) {
                if (s.charAt(sl) == '#') {
                    sl--;
                    skip1++;
                } else if (skip1 > 0) {
                    skip1--;
                    sl--;
                } else {
                    break;
                }
            }
            while (tl > -1) {
                if (t.charAt(tl) == '#') {
                    tl--;
                    skip2++;
                } else if (skip2 > 0) {
                    skip2--;
                    tl--;
                } else {
                    break;
                }
            }

            if (sl >= 0 && tl >= 0) {
                if (s.charAt(sl) != t.charAt(tl)) {
                    return false;
                }
            } else {
                if (sl >= 0 || tl >= 0) {
                    return false;
                }
            }
            sl--;
            tl--;
        }
        return true;
    }
}
