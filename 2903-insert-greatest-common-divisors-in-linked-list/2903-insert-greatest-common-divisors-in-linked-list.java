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
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode current = head;

        while(current != null && current.next != null){
            int val1 = current.val;
            int val2 = current.next.val;

            int gcdValue = gcd(val1, val2);

            ListNode gcdNode = new ListNode(gcdValue);

            gcdNode.next = current.next;
            current.next = gcdNode;

            current = gcdNode.next;
        }

        return head;
    }

    private int gcd(int a, int b){
        if(b==0){
            return Math.abs(a);
        }

        return gcd(b, a % b);
    }
}