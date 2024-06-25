

import static java.util.Collections.list;

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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        dfs(root1, list1);
        dfs(root2, list2);

        return list1.equals(list2);
    }

    private void dfs(TreeNode node, List<Integer> l){
        if (node == null) {
            return;
        }

        if(node.left == null && node.right == null){
            l.add(node.val);
        }
        dfs(node.left, l);
        dfs(node.right, l);
    }
}