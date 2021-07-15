/**
 * @author cjx
 * @description
 * @create 2021-01-21-15:07
 */
public class Merge_Two_Sorted_Lists_21 {


    class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

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


    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}

