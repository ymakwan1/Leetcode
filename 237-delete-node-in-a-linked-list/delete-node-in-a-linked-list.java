/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        //Copy nect node value
        node.val = node.next.val;
        //connect node to node+2
        node.next = node.next.next;
    }
}