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
        ListNode temp1 = list1;
        ListNode temp2 = list2;
        ListNode dummyHead = new ListNode(-1);
        ListNode dummyTail = dummyHead;
        while(temp1 != null && temp2 != null)
        {
            if(temp1.val <= temp2.val)
            {
                dummyTail.next = temp1;
                temp1 = temp1.next;
                dummyTail = dummyTail.next;
            }
            else
            {
                dummyTail.next = temp2;
                temp2 = temp2.next;
                dummyTail = dummyTail.next;
            }
        }
        if(temp1 != null)
        {
            dummyTail.next = temp1;
        }
        if(temp2 != null)
        {
            dummyTail.next = temp2;
        }
        return dummyHead.next;
    }
}