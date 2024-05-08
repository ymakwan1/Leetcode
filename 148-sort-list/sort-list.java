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
    public ListNode sortList(ListNode head) {
        if(head == null){
            return null;
        }

        ArrayList<Integer> numlist= new ArrayList<>();
        ListNode curr = head;

        while(curr != null){
            numlist.add(curr.val);
            curr = curr.next;
        }

        Collections.sort(numlist);

        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        for(int i = 0; i < numlist.size(); i++){
            ListNode temp = new ListNode(numlist.get(i));
            p.next = temp;
            p = p.next;
        }

        return dummy.next;
    }
}