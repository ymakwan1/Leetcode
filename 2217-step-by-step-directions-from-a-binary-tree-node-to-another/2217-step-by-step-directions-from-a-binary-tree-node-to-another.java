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
    public String getDirections(TreeNode root, int startValue, int destValue) {
        TreeNode lca = findLCA(root, startValue, destValue);
        StringBuilder pathToStart = new StringBuilder();
        StringBuilder pathToDest = new StringBuilder();
        
        findPath(lca, startValue, pathToStart);
        findPath(lca, destValue, pathToDest);
        
        for (int i = 0; i < pathToStart.length(); i++) {
            pathToStart.setCharAt(i, 'U');
        }

        pathToStart.reverse();
        pathToDest.reverse();
        
        return pathToStart.toString() + pathToDest.toString();
    }
    
    private TreeNode findLCA(TreeNode root, int p, int q) {
        if (root == null || root.val == p || root.val == q) {
            return root;
        }
        
        TreeNode left = findLCA(root.left, p, q);
        TreeNode right = findLCA(root.right, p, q);
        
        if (left != null && right != null) {
            return root;
        }
        
        return left != null ? left : right;
    }
    
    private boolean findPath(TreeNode root, int target, StringBuilder path) {
        if (root == null) {
            return false;
        }
        
        if (root.val == target) {
            return true;
        }
        
        if (findPath(root.left, target, path)) {
            path.append('L');
            return true;
        }
        
        if (findPath(root.right, target, path)) {
            path.append('R');
            return true;
        }
        
        return false;
    }
}
