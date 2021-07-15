public class Reverse_Nodes_in_k_Group_25 {
    public ListNode reverseKGroup(ListNode head,int k){
        ListNode dummy = new ListNode();
        dummy.next=head;

        if(k==1) return head;
        int len =1;  //定义链表长度
        ListNode next=head;
        while(next.next!=null){
            next=next.next;
            len++;
        }
        int num = len/k;  //计算按照k个一组进行翻转，共需要进行多少次翻转

        ListNode node=dummy;
        while(num!=0){
            num--;
            node=reverseKNodes(node,k-1);
        }
        return dummy.next;


    }
    ListNode reverseKNodes(ListNode dummy,int k){
        ListNode head = dummy.next;
        while(k!=0){
            k--;
            ListNode next = head.next;
            head.next = next.next;
            next.next=dummy.next;
            dummy.next=next;
        }

        return head;
    }

}
