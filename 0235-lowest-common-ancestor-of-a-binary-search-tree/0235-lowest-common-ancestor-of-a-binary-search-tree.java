/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while(root != null){
            if(p.val > root.val && q.val > root.val){
                //lowestCommonAncestor(root.right, p, q);
                root = root.right;
            } else if(p.val < root.val && q.val < root.val){
                //lowestCommonAncestor(root.left, p, q);
                root = root.left;
            }else {
                return root;
            }
        }
        
        return null;
    }
}