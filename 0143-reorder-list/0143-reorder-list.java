class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        ListNode slowPointer = head;
        ListNode fastPointer = head;

        while (fastPointer != null && fastPointer.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }

        ListNode prev = null;
        ListNode current = slowPointer.next;
        slowPointer.next = null;
        ListNode next;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        ListNode pointer1 = head;
        ListNode pointer2 = prev;

        while (pointer2 != null) {
            ListNode temp1 = pointer1.next;
            ListNode temp2 = pointer2.next;

            pointer1.next = pointer2;
            pointer2.next = temp1;

            pointer1 = temp1;
            pointer2 = temp2;
        }
    }
}
