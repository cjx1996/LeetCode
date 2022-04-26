package All_Problems;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cjx
 * @description
 * @create 2021-01-08-14:59
 */
public class RemoveNthFromEnd_19 {

    //使用额外空间存储链表中的结点
    public ListNode removeNthFromEnd(ListNode head, int n) {

        List<ListNode> list = new ArrayList<>();
        ListNode dummy = new ListNode(0, head);
        list.add(dummy);
        ListNode curr = dummy;
        while (curr != null) {
            list.add(curr);
            curr = curr.next;
        }
        int len = list.size();
        list.get(len - n - 1).next = list.get(len - n - 1).next.next;
        return dummy.next;
//        if(len==1&&n==1){
//            return null;
//        }
//        if(len==n&&n>1){
//            return list.get(1);
//        }
//        if(n==1&&n>1){
//            list.get(len-2).next=null;
//            return head;
//        }
//        if(n<len&&n>1) {
//
//
//            ListNode pre = list.get(len - n-1 );
//            ListNode next = list.get(len-n+1);
//            pre.next=next;
//
//        }
//
//        return head;


    }

    /**
     * @param head
     * @param n
     * @return
     * @description 使用快慢指针解题
     */
    public ListNode RemoveNthFromEnd2(ListNode head, int n) {
        //创建头部结点的上一个结点，这样删除头部结点时，不具备特殊性，易于处理
        ListNode dummy = new ListNode(0, head);
        //初始化快慢指针
        ListNode low = dummy;
        ListNode fast = dummy;
        //快指针先走n步，结束后，慢指针指向索引：0，快指针指向索引：n
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        //不断后移快慢指针，当快指针指向最后一个结点时，假设此时索引为：len-1，
        // 那么慢结点索引为：len-1-n，恰好是倒数第（N+1）个结点，此时即可进行处理
        while (fast.next != null) {
            low = low.next;
            fast = fast.next;
        }
        low.next = low.next.next;
        //此时头结点为dummy的next结点
        return dummy.next;
    }


    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}
