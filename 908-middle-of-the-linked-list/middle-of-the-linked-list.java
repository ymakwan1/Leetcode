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
    public ListNode middleNode(ListNode head) {
        ListNode start = head;
        int count = 0;
        while(start.next != null){
            start = start.next;
            count++;
        }
        System.out.println(count + 1);
        int i = 0;
        ListNode mid = head;
        while(i < ((count+1)/2) && mid.next != null){
            i++;
            mid = mid.next;
        }
        return mid;
    }
}