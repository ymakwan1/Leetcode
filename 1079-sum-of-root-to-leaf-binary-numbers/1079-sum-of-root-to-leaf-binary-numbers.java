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
    private int totalSum = 0;
    public int sumRootToLeaf(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root, 0);
        return totalSum;
    }

    private void dfs(TreeNode node, int currentSum){
        if (node == null) {
            return;
        }

        currentSum = currentSum * 2 + node.val;

        if (node.left == null && node.right == null) {
            totalSum += currentSum;
            return;
        }

        dfs(node.left, currentSum);
        dfs(node.right, currentSum);
    }
}