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
    public boolean isUnivalTree(TreeNode root) {
        if(root == null){
            return false;
        }

        return dfs(root, -1);
    }

    private boolean dfs(TreeNode node, int parentValue){
        if(node == null){
            return true;
        }

        if(parentValue != -1 && node.val != parentValue){
            return false;
        }

        return dfs(node.left, node.val) && dfs(node.right, node.val);
    }
}