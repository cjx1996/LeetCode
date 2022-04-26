package All_Problems;

/**
 * @ClassName Remove_Duplicates_from_Sorted_List_II_82
 * @Description
 * @Author cjx
 * @Date 2021/7/17 17:56
 * @Version 1.0
 */
public class Remove_Duplicates_from_Sorted_List_II_82 {
    public ListNode deleteDuplicates(ListNode head) {
        //定义哑结点
        ListNode pNode = new ListNode();
        pNode.next = head;


        ListNode curr = pNode, pre = pNode.next, next = pNode.next;
        while (next != null && next.next != null) {
            while (next.next != null && next.next.val == next.val) {
                next = next.next;
            }
            if (pre != next) {
                curr.next = next.next;

            } else {
                curr = pre;
            }
            pre = curr.next;
            next = curr.next;
        }
        return pNode.next;
    }
}
