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
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> nodes = new HashMap<>();
        Set<Integer> children = new HashSet<>();

        // Make nodes for each entry
        for(int[] desc : descriptions){
            int pVal = desc[0];
            int cVal = desc[1];
            int isLeft = desc[2];

            // Parent node check
            if(!nodes.containsKey(pVal)){
                nodes.put(pVal, new TreeNode(pVal));
            }

            TreeNode parent = nodes.get(pVal);
            
            // Child node check
            if(!nodes.containsKey(cVal)){
                nodes.put(cVal, new TreeNode(cVal));
            }

            TreeNode child = nodes.get(cVal);

            // Set left or right as per flag
            if(isLeft == 1){
                parent.left = child;
            } else{
                parent.right = child;
            }

            children.add(cVal);
        }

        // Root check
        for(int key : nodes.keySet()){
            if(!children.contains(key)){
                return nodes.get(key);
            }
        }

        // Empty descriptions
        return null;
    }
}