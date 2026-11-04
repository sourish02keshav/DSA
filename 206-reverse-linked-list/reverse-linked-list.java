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
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null)
        {
            return head;
        }
        ListNode curr = head;
        ListNode prev = null;

        while(curr != null)
        {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;

        // 1 2 3 4 5
        // if(head == null || head.next == null)
        // {
        //     return head;
        // }
        // ListNode tail = head.next;// 2
        // ListNode smallAns = reverseList(tail);// 5 
        // tail.next = head;// 5 -> 4 -> 3 -> 2 -> 1
        // head.next = null;// 5 -> 4 -> 3 -> 2 -> 1 -> null
        // return smallAns;// 5
    }
}