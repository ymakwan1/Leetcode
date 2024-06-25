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
    public TreeNode increasingBST(TreeNode root) {
        if (root == null) {
            return null;
        }

        return dfs(root, null);
    }

    private TreeNode dfs(TreeNode node, TreeNode tail){
        if (node == null) {
            return tail;
        }

        TreeNode result = dfs(node.left, node);
        node.left = null;
        node.right = dfs(node.right, tail);

        return result;
    }
}