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
    public int pairSum(ListNode head) {
        //Brute
        // Stack<Integer> stack = new Stack<>();
        // ListNode temp = head;
        // while(temp != null){
        //     stack.push(temp.val);
        //     temp = temp.next;
        // }
        // temp = head;
        // int total = 0;
        // while(temp != null && !stack.isEmpty()){
        //     total = Math.max(total, temp.val + stack.pop());
        //     temp = temp.next;
        // }

        // return total;

        if(head == null || head.next == null){
            return head.val;
        }

        ListNode slow = head, fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode newHead = reverseList(slow.next);
        ListNode first = head, second = newHead;
        int total = 0;
        while(second != null){
            total = Math.max(total, first.val + second.val);
            first = first.next;
            second = second.next;
        }
        reverseList(newHead);
        return total;
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