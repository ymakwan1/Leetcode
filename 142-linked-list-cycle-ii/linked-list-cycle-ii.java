/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode temp = head;
        HashMap<ListNode, Integer> map = new HashMap<>();
        int pos = 1;
        while(temp != null){
            if(map.containsKey(temp)){
                return temp;
            }
            map.put(temp, pos);
            temp = temp.next;
            pos += 1;
        }

        return null;
    }
}