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
    public ListNode mergeNodes(ListNode head) {
        ListNode lastZero = head;
        ListNode pointer = head.next;
        int sum = 0;

        while(pointer != null){
            if(pointer.val == 0){
                lastZero.next = new ListNode(sum);
                sum = 0;
                lastZero = lastZero.next;
            }else{
                sum += pointer.val;
            }

            pointer = pointer.next;
        }

        //lastZero.next = null;

        return head.next;
    }
}