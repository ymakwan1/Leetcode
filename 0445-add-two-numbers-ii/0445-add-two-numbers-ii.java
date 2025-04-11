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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode list1 = reverseList(l1);
        ListNode list2 = reverseList(l2);

        ListNode dummy = new ListNode();
        ListNode temp = dummy;

        int carry = 0;
        while(list1 != null || list2 != null || carry == 1){
            int sum = 0;

            if(list1 != null){
                sum += list1.val;
                list1 = list1.next;
            }

            if(list2 != null){
                sum += list2.val;
                list2 = list2.next;
            }

            sum += carry;
            carry = sum / 10;

            ListNode node = new ListNode(sum % 10);
            temp.next = node;
            temp = temp.next;
        }

        return reverseList(dummy.next);
    }
    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        return prev;
    }
}