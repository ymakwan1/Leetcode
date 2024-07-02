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
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        dfs(root1, list1);
        dfs(root2, list1);

        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < list1.size(); i++){
            result.add(list1.get(i));
        }

        Collections.sort(result);

        return result;

    }

    private void dfs(TreeNode node, List<Integer> resList){
        if(node == null){
            return;
        }

        dfs(node.left, resList);
        dfs(node.right, resList);

        resList.add(node.val);
    }
}