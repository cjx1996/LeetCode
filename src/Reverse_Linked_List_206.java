/**
 * @ClassName Reverse_Linked_List_206
 * @Description
 * @Author cjx
 * @Date 2021/8/15 20:26
 * @Version 1.0
 */
public class Reverse_Linked_List_206 {
    public ListNode reverseList(ListNode head){
        ListNode dummy = new ListNode();
        ListNode pCur = head;
        while(pCur!=null) {
            ListNode pNex = pCur.next;
            pCur.next= dummy.next;
            dummy.next=pCur;
            pCur=pNex;
        }
        return dummy.next;
    }
    public ListNode reverseList2(ListNode head){
        if(head==null) return null;
        //定义哑结点
        ListNode dummy =new ListNode(0,head);
        //定义prev指向原来的头结点head
        ListNode prev = head;
        //定义下一个将要反转的结点
        ListNode pCur = head.next;
        //只要pCur不为空，表示还有结点需要反转就继续循环
        while(pCur!=null){
            //指向下一个需要反转的结点
            prev.next= pCur.next;
            //将当前需要反转的结点指向反转后链表的头结点，自己成为头结点
            pCur.next= dummy.next;
            //更新哑结点，让哑结点指向当前的头结点
            dummy.next=pCur;
            //当前结点反转完成，更新pCur，指向下一个需要更新的结点
            pCur = prev.next;
        }
        return dummy.next;
    }
    public ListNode reverseList1(ListNode head){
        //寻找递归终止条件
            //1. head指向的结点是null，head的next是null，这两种情况下，反转后的头结点还是本身
        if(head==null||head.next==null) return head;
        //递归得到当前结点后面的链表反转后返回的头结点,就是原链表的最后一个结点
        //在递归函数的每一级调用中，curr变量都是原链表的最后一个结点
        ListNode curr = reverseList1(head.next);
        //已知head结点后面的链表都已经反转，下面将head结点加入到反转后的链表中
        //使head.next指向head,head加入链表
        head.next.next=head;
        //保证已经反转的链表的尾结点指向空，符合链表定义
        head.next=null;
        //返回已经反转好的链表的头结点，层层递归后最终返回的就是原链表的尾结点，并且原链表已经反转好
        return curr;
    }
}
