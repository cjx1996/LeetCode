package All_Problems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName All_O_one_Data_Structure_432
 * @Description
 * @Author cjx
 * @Date 2022/3/16 9:30
 * @Version 1.0
 */
public class All_O_one_Data_Structure_432 {
    class AllOne {
        Map<String, Node> map;
        Node hh, tt;

        public AllOne() {
            map = new HashMap<>();
            hh = new Node();
            tt = new Node();
            hh.right = tt;
            tt.left = hh;
        }

        public void inc(String key) {
            Node cur = map.get(key);
            //该字符串目前在链表中不存在
            if (null == cur) {
                if (hh.right.val == 1) {
                    cur = hh.right;
                } else {
                    cur = new Node(1);
                    cur.inset(hh);
                }
                cur.set.add(key);
                map.put(key, cur);
            }
            //该字符串之前在链表中已经存在
            else {
                //当前结点下一个不是key将要进入的结点
                if (cur.right.val != cur.val + 1) {
                    Node next = new Node(cur.val + 1);
                    next.set.add(key);
                    next.inset(cur);
                }
                cur.set.remove(key);
                cur.right.set.add(key);
                map.put(key, cur.right);
                cur.clear();
            }
        }

        public void dec(String key) {
            Node cur = map.get(key);
            if (cur.val != 1) {
                if (cur.left.val == cur.val - 1) {
                    cur.left.set.add(key);
                } else {
                    Node before = new Node(cur.val - 1);
                    before.set.add(key);
                    before.inset(cur.left);
                }
                map.put(key, cur.left);
            }else{
                map.remove(key);
            }
            cur.set.remove(key);
            cur.clear();
        }

        public String getMaxKey() {
            Node cur = tt.left;
            for (String str : cur.set) return str;
            return "";
        }

        public String getMinKey() {
            Node cur = hh.right;
            for (String str : cur.set) return str;
            return "";
        }

        class Node {
            public Node() {

            }

            public Node(int val) {
                this.val = val;
            }

            void clear() {
                if (this.set.size() == 0) {
                    this.left.right = this.right;
                    this.right.left = this.left;
                }
            }

            void inset(Node target) {
                this.left = target;
                this.right = target.right;
                target.right = this;
                this.right.left = this;
            }

            int val = -1;
            Set<String> set = new HashSet<>();
            Node left;
            Node right;
        }
    }

}
