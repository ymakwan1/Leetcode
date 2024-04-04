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
        int carryFlag = 0;
        int carry = 0;
        int sum = 0 ;
        ListNode dummy = new ListNode(0);
        ListNode t = dummy;
        
        while(l1 != null && l2 != null){
            if(carryFlag == 1){
                sum = l1.val + l2.val + carry;
                carryFlag = (sum > 9) ? 1 : 0;
                carry = (sum > 9) ? sum / 10 : 0;
                sum = (sum > 9) ? sum % 10 : sum;
                dummy.next  = new ListNode(sum);
            } else{
                sum = l1.val + l2.val;
                carryFlag = (sum > 9) ? 1 : 0;
                carry = (sum > 9) ? sum / 10 : 0;
                sum = (sum > 9) ? sum % 10 : sum;
                dummy.next  = new ListNode(sum);
            }
            l1 = l1.next;
            l2 = l2.next;
            dummy = dummy.next;
        }
        
        while(l1 != null){
            sum = l1.val + carry;
                carryFlag = (sum > 9) ? 1 : 0;
                carry = (sum > 9) ? sum / 10 : 0;
                sum = (sum > 9) ? sum % 10 : sum;
            l1 = l1.next;
            dummy.next  = new ListNode(sum);
            dummy = dummy.next;
        }
        
        while(l2 != null){
            sum = l2.val + carry;
            carryFlag = (sum > 9) ? 1 : 0;
            carry = (sum > 9) ? sum / 10 : 0;
            sum = (sum > 9) ? sum % 10 : sum;
            l2 = l2.next;
            dummy.next  = new ListNode(sum);
            dummy = dummy.next;
        }
        if(carry != 0){
            dummy.next  = new ListNode(carry);
        }
        
        return t.next;
    }
}