/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        while(list1 != null && list2 != null){
            int x = list1.val;
            int y = list2.val;
            ListNode newNode = new ListNode();

            if(x <= y){
                newNode.val = x;
                list1 = list1.next;
            } else {
                newNode.val = y;
                list2 = list2.next;
            }

            curr.next = newNode;
            curr = curr.next;
        }

        while(list1 != null){
            curr.next = list1;
            curr = curr.next; 
            list1 = list1.next;
        }

        while(list2 != null){
            curr.next = list2;
            curr = curr.next;
            list2 = list2.next;
        }

        return dummy.next;
    }
}