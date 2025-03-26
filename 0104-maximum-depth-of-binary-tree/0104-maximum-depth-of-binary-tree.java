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
    public int maxDepth(TreeNode root) {
        // Recursion
        // if(root == null){
        //     return 0;
        // }
        
        // int lhs = maxDepth(root.left);
        // int rhs = maxDepth(root.right);
        
        // return Math.max(lhs, rhs) + 1;

        // Level Order
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        int level = 0;
        if(root == null){
            return 0;
        }
        
        queue.offer(root);
        
        while(!queue.isEmpty()){
            int levelSize = queue.size();

            for(int i = 0; i < levelSize; i++){
                TreeNode temp = queue.poll();
                if(temp.left != null){
                    queue.offer(temp.left);
                }
                
                if(temp.right != null){
                    queue.offer(temp.right);
                }
            }
            level++;
        }
        return level;
    }
}