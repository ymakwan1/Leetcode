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
    public int[] nodesBetweenCriticalPoints(ListNode head) {

        if(head == null || head.next == null || head.next.next == null){
            return new int[]{-1, -1};
        }

        int firstCp = -1, lastCp = -1, minDistance = Integer.MAX_VALUE;
        int index = 1;
        int prevVal = head.val;
        ListNode current = head.next;
        int firstIndex = -1;
        int lastIndex = -1;

        while(current != null && current.next != null){
            if((current.val > prevVal && current.val > current.next.val) || (current.val < prevVal && current.val < current.next.val)){
                if(firstIndex == -1){
                    firstIndex = index;
                }else{
                    minDistance = Math.min(minDistance, index - lastIndex);
                }
                lastIndex = index;
            }

            prevVal = current.val;
            current = current.next;
            index++;
        }

        if(firstIndex == lastIndex){
            return new int[]{-1, -1};
        }

        return new int[] {minDistance, lastIndex - firstIndex};
    }
}