package All_Problems;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;




public class Merge_K_Sorted_Lists_23 {

    public ListNode mergeKLists(ListNode[] lists) {
        int length = lists.length;
        if(length==1){
            return lists[0];
        }
        if(length==2){
            return mergeTwoLists(lists[0], lists[1]);
        }
        if(length>2){
            int hLength =length/2;
            ListNode[] list1=new ListNode[hLength];
            ListNode[] list2=new ListNode[length-hLength];

            for (int i = 0; i < hLength; i++) {
                list1[i]=lists[i];
            }
            for (int i = hLength; i <length ; i++) {
                list2[i-hLength]=lists[i];
            }
            ListNode first = mergeKLists(list1);
            ListNode second = mergeKLists(list2);
            ListNode node = mergeTwoLists(first, second);
            return node;

        }
        return null;
    }
   ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

       ListNode prev = new ListNode();
      ListNode currNode = prev;

        while (l1 != null || l2!= null) {

            if (l1 == null) {
                currNode.next=l2;
                break;
            }
            if (l2 == null) {
                currNode.next=l1;
                break;
            }
            if (l1.val > l2.val) {
                currNode.next = l2;
                currNode=l2;
                l2 = l2.next;
            } else {
                currNode.next = l1;
                currNode=l1;
                l1 = l1.next;
            }
        }
        return prev.next;
    }

}
