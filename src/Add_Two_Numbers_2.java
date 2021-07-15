import org.junit.Test;

/**
 * @ClassName Add_Two_Numbers_2
 * @Description TODO
 * @Author cjx
 * @Date 2021/6/2 23:26
 * @Version 1.0
 */
public class Add_Two_Numbers_2 {
    @Test
    public void test(){
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode result = addTwoNumbers(l1, l2);
        while(result!=null){
            System.out.println(result.val);
            result=  result.next;
        }


    }
    public ListNode addTwoNumbers(ListNode l1,ListNode l2){
       ListNode preNode = new ListNode();
       ListNode target = preNode;
       int carry = 0;
       while(l1!=null||l2!=null||carry!=0){
           target.next = new ListNode();
           target = target.next;
           int fir = l1==null?0:l1.val;
           int sec = l2==null?0:l2.val;
           int sum = fir+sec+carry;
           target.val= sum>9?(sum-10):sum;
           carry = sum>9?1:0;
           if(l1!=null) l1 = l1.next;
           if(l2!=null) l2 = l2.next;


       }
       return preNode.next;
    }
}
