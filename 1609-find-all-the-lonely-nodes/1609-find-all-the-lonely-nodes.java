/**
 * Definition for a binary tree node.
 * class TreeNode {
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
    public List<Integer> getLonelyNodes(TreeNode root) {
        List<Integer> lonelyNodes = new ArrayList<>();
        findLonelyNodes(root, lonelyNodes);
        return lonelyNodes;
    }

    private void findLonelyNodes(TreeNode node, List<Integer> lonelyNodes) {
        if (node == null) {
            return;
        }

        // if the node has only one child and add that child to the list
        if (node.left != null && node.right == null) {
            lonelyNodes.add(node.left.val);
        }
        if (node.right != null && node.left == null) {
            lonelyNodes.add(node.right.val);
        }

        findLonelyNodes(node.left, lonelyNodes);
        findLonelyNodes(node.right, lonelyNodes);
    }
}
