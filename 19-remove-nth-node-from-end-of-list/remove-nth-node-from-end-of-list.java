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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }

        int count = 0;
        ListNode curr = head;

        while(curr != null){
            count++;
            curr = curr.next;
        }

        System.out.println(count);
        if(count == n){
            ListNode newhead = head.next;
            head = null;
            return newhead;
        }
        int res = count - n;
        curr = head;

        while(curr != null){
            res--;
            if(res == 0){
                break;
            }
            curr = curr.next;
        }

        ListNode delNode = curr.next;
        curr.next = curr.next.next;
        delNode = null;
        return head;
    }
}