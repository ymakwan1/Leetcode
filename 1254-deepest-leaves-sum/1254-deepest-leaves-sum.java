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
    private int sum = 0;
    private int maxDepth = 0;
    
    public int deepestLeavesSum(TreeNode root) {
        maxDepth = maxDepthCalc(root);
        dfs(root, 1);
        return sum;
    }

    private int maxDepthCalc(TreeNode node){
        if(node == null){
            return 0;
        }

        int left = maxDepthCalc(node.left);
        int right = maxDepthCalc(node.right);

        return Math.max(left, right) + 1;
    }

    private void dfs(TreeNode node, int curr){
        if(node == null){
            return;
        }

        if(node.left == null && node.right == null && curr == maxDepth){
            sum += node.val;
        }

        dfs(node.left, curr+1);
        dfs(node.right, curr+1);
    }
}