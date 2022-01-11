import org.junit.Test;

/**
 * @ClassName modifyString_1576
 * @Description
 * @Author cjx
 * @Date 2022/1/5 11:30
 * @Version 1.0
 */
public class ModifyString_1576 {
    @Test
    public void test() {
        System.out.println(modifyString("?zs"));
    }

    public String modifyString(String s) {
        char[] cs = s.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            if (cs[i] == '?') {
                char left = i == 0 ? '.' : cs[i - 1];
                char right = i == cs.length - 1 ? '.' : cs[i + 1];
                cs[i] = 'a';
                while (cs[i] == left || cs[i] == right) {
                    cs[i]++;
                }
            }
        }
        return String.valueOf(cs);
    }
}
