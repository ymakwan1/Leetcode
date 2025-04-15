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
        //Brute
        // Stack<Integer> stack = new Stack<>();
        // ListNode temp = head;
        // while(temp != null){
        //     stack.push(temp.val);
        //     temp = temp.next;
        // }
        // temp = head;
        // while(temp != null && !stack.isEmpty()){
        //     if(temp.val != stack.pop()){
        //         return false;
        //     }
        //     temp = temp.next;
        // }

        // return true;

        //Optimal
        if(head == null || head.next == null){
            return true;
        }

        ListNode slow = head, fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode newHead = reverseList(slow.next);
        ListNode first = head, second = newHead;
        while(second != null){
            if(first.val != second.val){
                reverseList(newHead);
                return false;
            }
            first = first.next;
            second = second.next;
        }
        reverseList(newHead);
        return true;
    }

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
}