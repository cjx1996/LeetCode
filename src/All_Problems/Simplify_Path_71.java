package All_Problems;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;

/**
 * @ClassName Simplify_Path_71
 * @Description
 * @Author cjx
 * @Date 2022/1/6 10:39
 * @Version 1.0
 */
public class Simplify_Path_71 {
    @Test
    public void test() {
        String path = "/a/./b/../../c/";
        System.out.println(simplifyPath(path));
    }

    public String simplifyPath(String path) {
        StringBuilder ans = new StringBuilder();
        int n = path.length();
        int pre = n;
        int remove = 0;
        for (int i = n - 1; i >= 0; i--) {
            char tem = path.charAt(i);
            if (tem == '/') {
                String mid = path.substring(i + 1, pre);
                if (mid.equals("..")) {
                    remove++;
                } else if (!mid.equals("") && !mid.equals(".")) {
                    if (remove == 0) {
                        ans.insert(0, '/' + mid);
                    } else {
                        remove--;
                    }

                }
                pre = i;
            }
        }
        return ans.length() == 0 ? "/" : String.valueOf(ans);
    }

}
