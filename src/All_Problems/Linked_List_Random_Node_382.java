package All_Problems;

import java.util.Random;

/**
 * @ClassName Linked_List_Random_Node_382
 * @Description
 * @Author cjx
 * @Date 2022/1/16 12:59
 * @Version 1.0
 */
public class Linked_List_Random_Node_382 {
    private class Solution1{
        private ListNode head;
        private Random random= new Random();
        public Solution1(ListNode _head){
            head = _head;
        }
        public int getRandom(){
            int ans = 0;
            ListNode tem = head;
            int lev = 0;
            while(tem!=null&&++lev>0){
                if(random.nextInt(lev)==0) ans = tem.val;
                tem = tem.next;
            }
            return ans;
        }
    }
    private class Solution{
        private int len;
        private ListNode head;
        public Solution(ListNode _head){
            head= _head;
            ListNode tem= head;
            while(tem!=null){
                len++;
                tem = tem.next;
            }
        }
        public int getRandom(){
            int num = new Random().nextInt(len);
            ListNode tem = head;
            for (int i = 0; i < num; i++) {
                tem = tem.next;
            }
            return tem.val;
        }
    }
}
