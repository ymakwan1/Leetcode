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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode nthNodeRemovedList = new ListNode(0);
        nthNodeRemovedList.next = head;
        
        ListNode nthAheadPointer = nthNodeRemovedList;
        ListNode nthBehindPointer = nthNodeRemovedList;
        
        for(int i = 1; i <= n+1 ; i++){
            nthAheadPointer = nthAheadPointer.next;
        }
        
        if (nthAheadPointer == null) {
            return head.next;
        }
        while(nthAheadPointer != null){
            nthAheadPointer = nthAheadPointer.next;
            nthBehindPointer = nthBehindPointer.next;
        }
        
        nthBehindPointer.next = nthBehindPointer.next.next;
        
        return nthNodeRemovedList.next;
    }
}