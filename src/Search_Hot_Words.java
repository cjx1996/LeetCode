import org.junit.Test;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @ClassName Search_Hot_Words
 * @Description
 * @Author cjx
 * @Date 2022/4/6 19:42
 * @Version 1.0
 */
public class Search_Hot_Words {
    @Test
    public void test() {
        int m = 3, n = 2;
        String str = "xinguan feiyan xinzeng bendi quezhen anli \n\rju baodao chengdu xinzeng xinguan feiyan bendi quezhen anli yili shenzhen xinzeng bendi quezhen anli liangli yiqing zhengti kongzhi lianghao\n\rxinguan yimiao linchuang shiyan\n\rwuzhong xingguan yimiao tongguo sanqi linchuang shiyan xiaoguo lianghao";
        System.out.println(searchHotWords(m, n, str));
    }

    public String searchHotWords(int m, int n, String str) {
        String[] lines = str.split("\n\r");
        int M = lines.length;
        Map<String, int[]> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            String[] words = lines[i].split(" ");
            int N = words.length;
            for (int j = 0; j < N; j++) {
                String word = words[j];
                int[] cnts = map.getOrDefault(word, new int[4]);
                if (i % 2 == 0) {
                    cnts[0] += 3;
                    cnts[1]++;
                    if (cnts[2] == 0) cnts[2] = i / 2 * 5000 + j + 1;
                } else {
                    cnts[0]++;
                    if (cnts[3] == 0) cnts[3] = i / 2 * 5000 + j + 1;
                }
                map.put(word,cnts);
            }
        }
        PriorityQueue<String> q = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int[] cnts1 = map.get(o1);
                int[] cnts2 = map.get(o2);
                if (cnts1[0] > cnts2[0]) return -1;
                else if (cnts1[0] < cnts2[0]) return 1;
                else if (cnts1[1] > cnts2[1]) return -1;
                else if (cnts1[1] < cnts2[1]) return 1;
                else if (cnts1[2] < cnts2[2]) return -1;
                else if (cnts1[2] > cnts2[2]) return 1;
                else return cnts1[3] - cnts2[3];
            }
        });
        for (String s : map.keySet()) {
            q.add(s);
        }
        sb.append(q.poll());
        int len = 1;
        while (len++ < m) {
            sb.append(" ");
            sb.append(q.poll());
        }
        return sb.toString();
    }
}
