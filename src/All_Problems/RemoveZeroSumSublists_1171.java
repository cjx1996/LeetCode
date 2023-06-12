package All_Problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName RemoveZeroSumSublists_1171
 * @Description
 * Given the head of a linked list, we repeatedly delete consecutive sequences of nodes that sum to 0 until there are no such sequences.
 * After doing so, return the head of the final linked list.  You may return any such answer.
 * (Note that in the examples below, all sequences are serializations of ListNode objects.)
 * @Author cjx
 * @Date 2023/6/11 13:31
 * @Version 1.0
 */
public class RemoveZeroSumSublists_1171 {
    //两次遍历，第一次遍历记录每个不同sum所对应的最后一个ListNode
    //第二次遍历，对于同一个sum，使用对应的第一个ListNode取代对应的最后一个ListNode
    public ListNode removeZeroSumSublists(ListNode head){
        ListNode dumb=new ListNode(0,head);
        Map<Integer,ListNode> map=new HashMap<>();
        int sum=0;
        for(ListNode cur=dumb;cur!=null;cur=cur.next){
            sum+=cur.val;
            map.put(sum,cur);
        }
        sum=0;
        for(ListNode cur=dumb;cur!=null;cur=cur.next){
            sum+=cur.val;
            cur.next=map.get(sum).next;
        }
        return dumb.next;

    }

}
