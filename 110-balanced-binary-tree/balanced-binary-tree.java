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
        
        return getHeight(root) != -1;
    }
    
    public int getHeight(TreeNode node){
        if(node == null){
            return 0;
        }
        
        int lhs = getHeight(node.left);
        if(lhs == -1){
            return -1;
        }
        int rhs = getHeight(node.right);
        if(rhs == -1){
            return -1;
        }

        if(Math.abs(lhs - rhs) > 1){
            return -1;
        }
        
        return Math.max(lhs, rhs) + 1;
    }
}