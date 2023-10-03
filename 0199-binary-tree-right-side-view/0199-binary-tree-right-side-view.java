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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        rightSideViewCalc(root, res, 0);
        return res;
    }
    
    public void rightSideViewCalc(TreeNode node, List<Integer> result, int depth){
        if(node == null){
            return;
        }
        
        if(depth == result.size()){
            result.add(node.val);
        }
        
        rightSideViewCalc(node.right, result, depth + 1);
        rightSideViewCalc(node.left, result, depth + 1);
    }
}