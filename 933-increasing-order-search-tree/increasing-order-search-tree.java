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
    public TreeNode increasingBST(TreeNode root) {
        return treeBuilder(root, null);
    }

    private TreeNode treeBuilder(TreeNode node, TreeNode tail){
        if(node == null){
            return tail;
        }

        TreeNode res = treeBuilder(node.left, node);
        node.left = null;
        node.right = treeBuilder(node.right, tail);

        return res;
    }
}