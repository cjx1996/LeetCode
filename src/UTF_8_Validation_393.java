import org.junit.Test;

/**
 * @ClassName UTF_8_Validation_393
 * @Description
 * @Author cjx
 * @Date 2022/3/13 20:51
 * @Version 1.0
 */
public class UTF_8_Validation_393 {
    @Test
    public void test() {
        int[] data = new int[]{115,100,102,231,154,132,13,10};
        System.out.println(validUtf8(data));
    }

    public boolean validUtf8(int[] data) {
        int n = data.length;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (cnt <= 1) {
                cnt = getOnes(data[i]) ;
                if(cnt>4||cnt==1) return false;
                if (cnt == 0 && data[i] >> 7 != 0) return false;
            } else {
                cnt--;
                if (data[i] >> 6 != 2) return false;
            }
        }
        return cnt == 0 ? true : false;
    }

    int getOnes(int num) {
        int ans = 0;
        for (int i = 0; i < 8; i++) {
            if((num>>(7-i)&1)==1) ans++;
            else break;
        }
        return ans;
    }
}
