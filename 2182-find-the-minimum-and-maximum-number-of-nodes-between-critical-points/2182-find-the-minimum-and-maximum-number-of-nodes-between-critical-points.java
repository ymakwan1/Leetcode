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
        int firstCp = -1, lastCp = -1, minDistance = Integer.MAX_VALUE;
        int index = 1;
        int prevVal = head.val;
        ListNode current = head.next;
        List<Integer> criticalPoints = new ArrayList<>();

        while(current != null && current.next != null){
            if((current.val > prevVal && current.val > current.next.val) || (current.val < prevVal && current.val < current.next.val)){
                criticalPoints.add(index);
                if(firstCp == -1){
                    firstCp = index;
                }else{
                    minDistance = Math.min(minDistance, index - lastCp);
                }
                lastCp = index;
            }

            prevVal = current.val;
            current = current.next;
            index++;
        }

        if(criticalPoints.size() < 2){
            return new int[]{-1, -1};
        }

        return new int[] {minDistance, criticalPoints.get(criticalPoints.size()-1) - criticalPoints.get(0)};
    }
}