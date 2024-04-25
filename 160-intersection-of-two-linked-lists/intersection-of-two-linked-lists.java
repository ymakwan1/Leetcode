/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode dummyA = headA;
        ListNode dummyB = headB;

        while(dummyA != dummyB){
            dummyA = (dummyA != null) ? dummyA.next : headB;
            dummyB = (dummyB != null) ? dummyB.next : headA;
        }

        return dummyA;
    }
}
