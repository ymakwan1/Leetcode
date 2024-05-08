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
    public ListNode deleteMiddle(ListNode head) {
        if (head == null || head.next == null) {
            return null; // Edge case: Empty list or single node
        }

        int length = 0;
        ListNode curr = head;
        while (curr != null) {
            length++;
            curr = curr.next;
        }

        int mid = length / 2; // Index of the middle node
        curr = head;

        // Traverse to the node just before the middle node
        for (int i = 0; i < mid - 1; i++) {
            curr = curr.next;
        }

        // Delete the middle node
        curr.next = curr.next.next;

        return head;
    }
}
