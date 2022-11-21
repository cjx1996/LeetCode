package Interviews;

import All_Problems.ListNode;
import org.junit.Test;

/**
 * @ClassName ReverseList
 * @Description
 * @Author cjx
 * @Date 2022/9/16 15:18
 * @Version 1.0
 */
public class ReverseList {
    @Test
    public void test(){
        int[] arr=new int[]{2,3,5};
        ListNode cur,head = null;
        ListNode pre=null;
        for (int i : arr) {
            cur=new ListNode(i);
            if(pre==null) pre=cur;
            else {
                pre.next=cur;
                pre=cur;
            }
            if(head==null) head=cur;
        }
        head=reverseList(head);
        while(head!=null){
            System.out.println(head.val);
            head=head.next;
        }
    }
/*
//直接反转
    public ListNode reverseList(ListNode head) {
        if(head==null) return null;
        ListNode prev=null;
        ListNode cur=head;
        while(cur!=null){
            ListNode next=cur.next;
            cur.next=prev;
            prev=cur;
            cur=next;
        }
        return prev;
    }
*/
    //迭代
    public ListNode  reverseList(ListNode node){
        if(node.next==null) return node;
        ListNode head=reverseList(node.next);
        node.next.next=node;
        node.next=null;
        return head;
    }
    //头插法
 /*   public ListNode reverseList(ListNode node){
        ListNode dumb=new ListNode();
        ListNode cur=node;
        while(cur!=null){
            ListNode next=cur.next;
            cur.next=dumb.next;
            dumb.next=cur;
            cur=next;
        }
        return dumb.next;
    }
*/
}
