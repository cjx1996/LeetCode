package All_Problems;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName MaxEqualRowsAfterFlips_1072
 * @Description
 * @Author cjx
 * @Date 2023/5/15 23:04
 * @Version 1.0
 */
public class MaxEqualRowsAfterFlips_1072 {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        int res=0;
        int m = matrix.length;
        int n= matrix[0].length;
        Map<String,Integer> map=new HashMap<>();
        for(int i=0;i<m;i++){
            char[] cs=new char[n];
            for (int j = 0; j < n; j++) {
                cs[j]=(char)('0'+matrix[i][j]^matrix[i][0]);
            }
            String key=String.valueOf(cs);
            map.put(key,map.getOrDefault(key,0)+1);
        }
        for (Integer value : map.values()) {
            res=Math.max(res,value);
        }
        return res;
    }

}
