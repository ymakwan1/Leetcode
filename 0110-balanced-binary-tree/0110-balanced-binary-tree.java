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
    public boolean isBalanced(TreeNode root) {
        
        if(root == null){
            return true;
        }
        
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        
        if(Math.abs(left - right) <= 1 && isBalanced(root.left) && isBalanced(root.right)){
            return true;
        }
        
        return false;
        
    }
    
    public int getHeight(TreeNode node){
        if(node == null){
            return 0;
        }
        
        int lhs = getHeight(node.left);
        int rhs = getHeight(node.right);
        
        return Math.max(lhs, rhs) + 1;
    }
}