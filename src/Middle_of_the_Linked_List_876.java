/**
 * @ClassName Middle_of_the_Linked_List_876
 * @Description
 * @Author cjx
 * @Date 2021/8/9 16:53
 * @Version 1.0
 */
public class Middle_of_the_Linked_List_876 {
    public ListNode middleNode(ListNode head){
        ListNode dumb = new ListNode(0,head);
        ListNode slow = dumb,fast = dumb;
        while(fast.next!=null&&fast.next.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        slow = slow.next;
        return slow;
    }
}
