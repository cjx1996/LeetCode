package Interviews;

import All_Problems.ListNode;

/**
 * @ClassName ReverseListK
 * @Description
 * @Author cjx
 * @Date 2022/9/16 15:26
 * @Version 1.0
 */
public class ReverseListK {
    public static void main(String[] args) {
        ReverseListK test=new ReverseListK();
        ListNode head=new ListNode(1);
        head.next=new ListNode(2);
        head.next.next=new ListNode(3);
        head.next.next.next=new ListNode(4);
        ListNode res=test.reverseKGroup(head,2);
        while(res!=null){
            System.out.println(res.val);
            res=res.next;
        }
    }
    public ListNode reverseKGroup(ListNode head, int k){
        ListNode a,b;
        a=head;
        b=head;
        for (int i = 0; i < k; i++) {
            if(b==null) return head;
            b=b.next;
        }
        ListNode newNode=reverse(a,b);
        a.next=reverseKGroup(b,k);
        return newNode;
    }
    public ListNode reverse(ListNode a,ListNode b){
        ListNode cur,pre,next;
        cur=a;
        next=a;
        pre=null;
        while(cur!=b){
            next=cur.next;
            //断开cur和next的连接
            cur.next=pre;
            //让pre指向当前cur
            pre=cur;
            //cur指向下一个结点
            cur=next;
        }
        //返回变换后的头结点
        return pre;
    }


}
