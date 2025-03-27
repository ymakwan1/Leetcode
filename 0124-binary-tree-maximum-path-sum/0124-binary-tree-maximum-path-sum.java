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
    private int max;
    public int maxPathSum(TreeNode root) {
        max = Integer.MIN_VALUE;
        maxPath(root);
        return max;
    }

    private int maxPath(TreeNode root){
        if(root == null){
            return 0;
        }

        int lSum = Math.max(0,maxPath(root.left));
        int rSum = Math.max(0, maxPath(root.right));

        max = Math.max(max, lSum + rSum + root.val);

        return ((root.val) + Math.max(lSum, rSum));
    }
}