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
    int sum = 0;
    public int rangeSumBST(TreeNode root, int low, int high) {
        dfs(root, low, high);
        return sum;
    }

    private void dfs(TreeNode root, int low, int high){
        if(root == null){
            return;
        }

        dfs(root.left, low, high);
        if(inRange(root.val, low, high)){
            sum += root.val;
        }
        dfs(root.right, low, high);
    }

    private boolean inRange(int val, int low, int high){
        if(low <= val && val <= high){
            return true;
        }
        return false;
    }
}