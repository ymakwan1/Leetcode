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
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> result = new ArrayList<>();
        dfs(root, result);
        return twoSum(result, k);
    }

    private void dfs(TreeNode root, List<Integer> result){
        if(root == null){
            return;
        }

        dfs(root.left, result);
        result.add(root.val);
        dfs(root.right, result);
    }

    public boolean twoSum(List<Integer> nums, int target) {
        HashMap<Integer, Integer> twoSumIndices = new HashMap<Integer, Integer>();
        
        for(int i = 0; i < nums.size(); i++){
            int difference = target - nums.get(i);
            
            if(twoSumIndices.containsKey(difference)){
                return true;
            }
            
            twoSumIndices.put(nums.get(i), i);
        }
        return false;
    }
}