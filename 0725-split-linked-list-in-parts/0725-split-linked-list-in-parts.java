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
    public ListNode[] splitListToParts(ListNode head, int k) {
        // Find the length of the linked list
        int length = 0;
        ListNode current = head;
        while (current != null) {
            length++;
            current = current.next;
        }

        // Calculate the size of each part and the number of extra nodes
        int baseSize = length / k;
        int extraNodes = length % k;

        ListNode[] result = new ListNode[k];
        current = head;
        
        for (int i = 0; i < k; i++) {
            ListNode partHead = current;
            int partSize = baseSize + (extraNodes > 0 ? 1 : 0);
            extraNodes--;

            // Iterate through the current part
            for (int j = 1; j < partSize; j++) {
                if (current != null) {
                    current = current.next;
                }
            }
            
            // Disconnect the current part from the rest of the list
            if (current != null) {
                ListNode next = current.next;
                current.next = null;
                current = next;
            }
            
            result[i] = partHead;
        }
        
        return result;
    }
}
