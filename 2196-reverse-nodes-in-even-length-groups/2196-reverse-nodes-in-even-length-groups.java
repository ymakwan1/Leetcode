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
    public ListNode reverseEvenLengthGroups(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode prev = dummy;
        int groupSize = 1;

        while (head != null) {
            ListNode groupStart = head;
            int count = 0;

            while (count < groupSize && head != null) {
                head = head.next;
                count++;
            }

            if (count % 2 == 0) {
                prev.next = reverse(groupStart, count);
                while (count-- > 0) {
                    prev = prev.next;
                }
            } else {
                while (count-- > 0) {
                    prev = prev.next;
                }
            }

            groupSize++;
        }

        return dummy.next;
    }
    private ListNode reverse(ListNode head, int k) {
        ListNode prev = null, curr = head;
        while (k-- > 0) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        head.next = curr; 
        return prev;
    }
}
