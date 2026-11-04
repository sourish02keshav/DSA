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

    public ListNode reverse(ListNode head)
    {
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
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        ListNode currH = null;
        ListNode currT = null;
        ListNode ansH = null;
        ListNode ansT = null;
        while(temp != null)
        {
            int i = 1;
            currH = temp;
            while(temp != null && i <= k)
            {
                i++;
                currT = temp;
                temp = temp.next;
            }
            if(i <= k)
            {
                if(ansH == null)
                {
                    return currH;
                }
                else
                {
                    ansT.next = currH;
                    return ansH;
                }
            }
            currT.next = null;
            ListNode reversedH = reverse(currH);
            if(ansH == null)
            {
                ansH = reversedH;
            }
            else
            {
                ansT.next = reversedH;
            }
            ansT = currH;
        }
        return ansH;
    }
}