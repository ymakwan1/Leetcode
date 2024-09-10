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
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] matrix = new int[m][n];
        for (int[] row : matrix) {
            Arrays.fill(row, -1);
        }
        
        int top = 0, bottom = m - 1, left = 0, right = n - 1;
        int direction = 0; // 0 = right, 1 = down, 2 = left, 3 = up
        
        while (top <= bottom && left <= right) {
            if (direction == 0) { 
                // Move right
                for (int i = left; i <= right; i++) {
                    if (head != null) {
                        matrix[top][i] = head.val;
                        head = head.next;
                    }
                }
                top++;
            } else if (direction == 1) { 
                // Move down
                for (int i = top; i <= bottom; i++) {
                    if (head != null) {
                        matrix[i][right] = head.val;
                        head = head.next;
                    }
                }
                right--;
            } else if (direction == 2) { 
                // Move left
                for (int i = right; i >= left; i--) {
                    if (head != null) {
                        matrix[bottom][i] = head.val;
                        head = head.next;
                    }
                }
                bottom--;
            } else if (direction == 3) { 
                // Move up
                for (int i = bottom; i >= top; i--) {
                    if (head != null) {
                        matrix[i][left] = head.val;
                        head = head.next;
                    }
                }
                left++;
            }
            
            direction = (direction + 1) % 4; // Move to the next direction
        }
        
        return matrix;
    }
}
