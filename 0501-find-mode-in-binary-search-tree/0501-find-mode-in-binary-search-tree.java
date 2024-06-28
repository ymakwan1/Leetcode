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
    private List<Integer> res = new ArrayList<>();
    private int maxCount = 0;
    private int currentCount = 0;
    private Integer prevVal = null;

    public int[] findMode(TreeNode root) {
        dfs(root);

        int[] result = new int[res.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = res.get(i);
        }

        return result;
    }

    private void dfs(TreeNode node){
        if(node == null){
            return;
        }

        dfs(node.left);

        if(prevVal == null || prevVal != node.val){
            currentCount = 1;
        }else{
            currentCount++;
        }

        if (currentCount > maxCount) {
            maxCount = currentCount;
            res.clear();
            res.add(node.val);
        }else if(currentCount == maxCount){
            res.add(node.val);
        }

        prevVal = node.val;

        dfs(node.right);
    }
}