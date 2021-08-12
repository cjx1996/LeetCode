import org.junit.Test;

/**
 * @ClassName Excel_Sheet_Column_Number_171
 * @Description
 * @Author cjx
 * @Date 2021/7/30 10:02
 * @Version 1.0
 */
public class Excel_Sheet_Column_Number_171 {
    @Test
    public void test(){
        System.out.println(titleToNumber("ZY"));
    }
    public int titleToNumber(String columnTitle){
        int ans = 0;
        int len = columnTitle.length();
        for (int i = len-1; i >=0; i--) {
            int num = columnTitle.charAt(i)-'@';
            int weight = len-1-i;
            ans +=num*Math.pow(26,weight);
        }
        return ans;
    }
}
