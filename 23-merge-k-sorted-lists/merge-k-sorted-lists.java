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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val - b.val);
        for(ListNode node : lists)
        {
            if(node != null)
            {
                pq.add(node);
            }
        }
        ListNode dummyHead = new ListNode();
        ListNode temp = dummyHead;
        while(!pq.isEmpty())
        {
            ListNode topNode = pq.poll();
            temp.next = topNode;
            if(topNode.next != null)
            {
                pq.add(topNode.next);
            }
            temp = temp.next;
        }
        return dummyHead.next;
    }
}