/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private int counter = 0;
    private int kSmall = -1;
    
    public int kthSmallest(TreeNode root, int k) {
        inorder(root, k);
        return kSmall;
    }

    private void inorder(TreeNode root, int k){
        if(root == null || counter >= k){
            return;
        }

        inorder(root.left, k);

        counter++;

        if(counter == k){
            kSmall = root.val;
            return;
        }

        inorder(root.right, k);
    }
}