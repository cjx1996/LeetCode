package All_Problems;

/**
 * @ClassName Maximum_Good_People_Based_on_Statements_5992
 * @Description
 * @Author cjx
 * @Date 2022/1/23 12:11
 * @Version 1.0
 */
public class Maximum_Good_People_Based_on_Statements_5992 {
    public int maximumGood(int[][] statements) {
        int n = statements.length;
        int max = 1 << n;
        int ans = 0;
        //遍历所有数字，每一个数字代表一种假设，二进制形式下1代表此人是好人，0代表此人是好人
        for (int i = 1; i < max; i++) {
            int cnt = count(i);
            //剪枝，如果当前假设即使正确也不能使答案更大，则剪枝
            if (cnt <= ans) continue;
            boolean flag = true;
            //验证每个好人的话
            for (int j = 0; j < n && flag; j++) {
                //表示假设中第j个人是好人，我们需要验证他的话
                if (((i >> j) & 1) == 1) {
                    //验证每个好人对每个人的话与假设是否矛盾
                    for (int k = 0; k < n; k++) {
                        if (!(statements[j][k] == 1 - (i >> k & 1))) {
                            flag = false;
                            break;
                        }
                    }
                }
            }
            if (flag) ans = cnt;
        }
        return ans;
    }

    //计算每个数中有多少个1
    public int count(int num) {
        int ans = 0;
        for (; num > 0; num >>= 1) {
            ans += num & 1;
        }
        return ans;
    }
}
