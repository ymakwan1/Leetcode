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
    public ListNode doubleIt(ListNode head) {
        ListNode reversedHead = reverseList(head);
        ListNode curr = head;

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy; 

        int carry = 0;
        while (reversedHead != null) {
            int temp = reversedHead.val * 2 + carry;
            ListNode newNode = new ListNode(temp % 10);
            tail.next = newNode;
            tail = newNode; // Update the tail to the new node
            carry = temp / 10;
            reversedHead = reversedHead.next;
        }

        // If there is a carry after doubling, add a new node for it
        if (carry != 0) {
            tail.next = new ListNode(carry);
        }

        // Reverse the resulting linked list before returning
        return reverseList(dummy.next);
    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        return prev;
    }
}
