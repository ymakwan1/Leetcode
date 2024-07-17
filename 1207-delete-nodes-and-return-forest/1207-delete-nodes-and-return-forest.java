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
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> result = new ArrayList<>();
        Set<Integer> toDeleteSet = new HashSet<>();
        for (int val : to_delete) {
            toDeleteSet.add(val);
        }
        dfs(root, true, toDeleteSet, result);
        return result;
    }

    private TreeNode dfs(TreeNode node, boolean isRoot, Set<Integer> toDeleteSet, List<TreeNode> result) {
        if (node == null) {
            return null;
        }
        
        boolean nodeToDelete = toDeleteSet.contains(node.val);
        
        if (isRoot && !nodeToDelete) {
            result.add(node);
        }
        
        node.left = dfs(node.left, nodeToDelete, toDeleteSet, result);
        node.right = dfs(node.right, nodeToDelete, toDeleteSet, result);
        
        return nodeToDelete ? null : node;
    }
}