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
    public TreeNode searchBST(TreeNode root, int val) {
        TreeNode node = search(root, val);
        return node;
    }

    private TreeNode search(TreeNode root, int val){
        if(root == null){
            return null;
        }

        if(root.val == val){
            return root;
        }

        if(root.val > val){
            return search(root.left, val);
        }else{
            return search(root.right, val);
        }
    }
}