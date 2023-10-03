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
    public int goodNodes(TreeNode root) {
        return countGoodNodes(root, Integer.MIN_VALUE);
    }
    
    private int countGoodNodes(TreeNode node, int maxValue){
        int good = 0;
        if (node == null){
            return 0;
        }
        
        if(node.val >= maxValue){
            good++;
            maxValue = node.val;
        }
        
        good += countGoodNodes(node.left, maxValue);
        good += countGoodNodes(node.right, maxValue);
        
        return good;
    }
}