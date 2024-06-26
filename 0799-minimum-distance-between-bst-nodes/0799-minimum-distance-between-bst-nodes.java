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
    public int minDiffInBST(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        dfs(root, result);
        int mindiff = Integer.MAX_VALUE;
        for (int i = 1; i < result.size(); i++) {
            int diff = Math.abs(result.get(i) - result.get(i-1));
            mindiff = Math.min(diff, mindiff);
        }

        return mindiff;
    }

    private void dfs(TreeNode root, List<Integer> result){
        if(root == null){
            return;
        }

        dfs(root.left, result);
        result.add(root.val);
        dfs(root.right, result);
    }
}