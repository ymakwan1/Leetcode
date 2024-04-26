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

    public ListNode getKthNode(ListNode temp, int k){
        k-=1;
        while(k > 0 && temp != null){
            temp = temp.next;
            k--;
        }
        return temp;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode prev = null;
        ListNode temp = head;

        while(temp != null){
            ListNode kthNode = getKthNode(temp, k);

            if(kthNode == null){
                if(prev != null){
                    prev.next = temp;
                }
                break;
            }

            ListNode nextNode = kthNode.next;
            kthNode.next = null;
            
            reverseList(temp);

            if(temp == head){
                head = kthNode;
            }else {
                prev.next = kthNode;
            }

            prev = temp;
            temp = nextNode;
        }

        return head;
    }
}