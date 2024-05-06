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
        ListNode prev = null;
        ListNode temp = head;

        while(temp != null){
            ListNode front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }

        return prev;
    }

    public ListNode removeNodes(ListNode head) {
        ListNode reversedList = reverseList(head);

        ListNode dummy = new ListNode(0);
        ListNode prev = dummy;
        ListNode curr = reversedList;

        int maxVal = Integer.MIN_VALUE;

        while(curr != null){
            if(curr.val >= maxVal){
                prev.next = curr;
                prev = curr;
                maxVal = curr.val;
            }
            curr = curr.next;
        }
        prev.next = null;

        ListNode modifiedList = reverseList(dummy.next);

        return modifiedList;
    }
}