package All_Problems;

/**
 * @ClassName Circular_Array_Loop_457
 * @Description
 * @Author cjx
 * @Date 2021/8/7 21:54
 * @Version 1.0
 */
public class Circular_Array_Loop_457 {
    public boolean circularArrayLoop(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            //如果当前结点值为0，说明在其他某次循环中检查出该点所在的环不符合条件
            if (nums[i] == 0) continue;
            //定义快慢指针，由于图是单向图，必然存在一个环，也就是说必然能够使得slow和fast最终取得相同值
            int slow = i, fast = next(nums, i);
            //要求路径方向相同
            while (nums[slow] * nums[fast] > 0 && nums[slow] * nums[next(nums, fast)] > 0) {
                if (slow == fast) {
                    if (slow != next(nums, slow)) {
                        return true;
                    } else {
                        break;
                    }
                }
                //slow每次走一步，fast每次走两步
                slow = next(nums, slow);
                fast = next(nums, next(nums, fast));
            }

            //对于一个点，如果走到当前位置，说明该环路在当次循环中被检查出不符合条件，之间将该条路径所有点赋值0
            int add = i;
            while (nums[add] * nums[next(nums, add)] > 0) {
                nums[add] = 0;
                add = next(nums, add);
            }
        }
        return false;
    }

    int next(int[] nums, int i) {
        int n = nums.length;
        return (i + nums[i] % n + n) % n;
    }
}
