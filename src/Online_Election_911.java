import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @ClassName Online_Election_911
 * @Description
 * @Author cjx
 * @Date 2021/12/11 22:50
 * @Version 1.0
 */
public class Online_Election_911 {

    @Test
    public void test() {
        int[] persons = new int[]{0, 1, 0, 1, 1};
        int[] times = new int[]{24, 29, 31, 76, 82};
        TopVotedCandidate t = new TopVotedCandidate(persons, times);
        int[] nums = new int[]{28, 24, 29, 77, 30, 25, 76, 75, 81, 80};
        for (int num : nums) {
            System.out.println(t.q(num));
        }
    }

    class TopVotedCandidate {

        int[] persons;
        int[] times;
        private int[] votes;

        public TopVotedCandidate(int[] persons, int[] times) {
            this.persons = persons;
            this.times = times;
            this.votes = new int[times.length];
            calVotes();
        }

        private void calVotes() {
            int max = 0, ans = 0;
            HashMap<Integer, Integer> cnt = new HashMap<>();
            for (int i = 0; i < votes.length; i++) {
                int vote = persons[i];
                cnt.put(vote, cnt.getOrDefault(vote, 0) + 1);
                if (cnt.get(vote) >= max) {
                    max = cnt.get(vote);
                    ans = vote;
                }
                votes[i] = ans;
            }
        }

        public int q(int t) {
            int index = searchIndex(t);
            return votes[index];
        }

        //在数组中查询<=目标值的最小索引
        private int searchIndex(int t) {
            int l = 0, r = times.length - 1;
            while (l < r) {
                int mid = l + ((r - l) >> 1) + 1;
                if (times[mid] > t) {
                    r = mid - 1;
                } else if (times[mid] < t) {
                    l = mid;
                } else {
                    return mid;
                }
            }
            return r;
        }
    }
}
