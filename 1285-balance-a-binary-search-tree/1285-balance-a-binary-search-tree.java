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
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> l = new ArrayList<>();
        inorderTraversal(root, l);
        return buildBST(l, 0, l.size()-1);
    }

    private void inorderTraversal(TreeNode node, List<Integer> l){
        if (node == null) {
            return;
        }

        inorderTraversal(node.left, l);
        l.add(node.val);
        inorderTraversal(node.right, l);
    }

    private TreeNode buildBST(List<Integer> l, int start, int end){
        if (start > end) {
            return null;
        }

        int mid = (start + end) / 2;
        TreeNode node = new TreeNode(l.get(mid));

        node.left = buildBST(l, start, mid-1);
        node.right = buildBST(l, mid+1, end);

        return node;
    }
}