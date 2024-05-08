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
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode current = head;
        ListNode oddList = new ListNode(-1);    
        ListNode evenList = new ListNode(-1);
        ListNode odd = oddList;
        ListNode even = evenList;
        boolean isOdd = true;

        while(current != null){
            if(isOdd){
                odd.next = current;
                odd = odd.next;
            }else{
                even.next = current;
                even = even.next;
            }
            current = current.next;
            isOdd = !isOdd;
        }

        odd.next = evenList.next;
        even.next = null;

        return oddList.next;
    }
}