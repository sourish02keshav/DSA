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

    public ListNode mid(ListNode head)
    {
        ListNode slow = head;
        ListNode fast = head;

        while(fast.next != null && fast.next.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public ListNode mergeLists(ListNode left,ListNode right)
    {
        ListNode temp1 = left;
        ListNode temp2 = right;
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

    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null)
        {
            return head;
        }
        ListNode mid = mid(head);
        ListNode left = head;
        ListNode right = mid.next;
        mid.next = null;
        left = sortList(left);
        right = sortList(right);
        return mergeLists(left,right);
    }
}