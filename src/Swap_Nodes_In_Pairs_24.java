/**
 * @ClassName Swap_Nodes_In_Pairs_24
 * @Description TODO
 * @Author cjx
 * @Date 2021/4/9 16:16
 * @Version 1.0
 */
public class Swap_Nodes_In_Pairs_24 {
   public ListNode swapPairs(ListNode head){
      ListNode pre = new ListNode();
      pre.next=head;
      ListNode curr = new ListNode();
      curr=head;
      ListNode before = new ListNode();
      before=pre;
      while(curr!=null&&curr.next!=null){
         before.next=curr.next;
         curr.next=curr.next.next;
         before.next.next=curr;
         before=curr;
         curr=curr.next;

      }
      return pre.next;
   }
}


