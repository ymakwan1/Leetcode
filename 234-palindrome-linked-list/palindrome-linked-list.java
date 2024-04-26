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
    public boolean isPalindrome(ListNode head) {
        if (head == null){
            return true;
        }

        Stack<Integer> stack = new Stack<Integer>();

        ListNode temp = head;
        ListNode dummy = head;

        while(temp != null){
            stack.push(temp.val);
            temp = temp.next;
        }

        while(dummy != null){
            if(stack.pop() != dummy.val){
                return false;
            }
            dummy = dummy.next;
        }
        return true;
    }
}