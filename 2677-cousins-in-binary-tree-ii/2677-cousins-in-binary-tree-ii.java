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
    public TreeNode replaceValueInTree(TreeNode root) {
        if(root == null){
            return null;
        }

        //BFS queue
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        //Root has no cousins, hence 0
        root.val = 0; 

        while(!q.isEmpty()){
            int size = q.size();
            int levelSum = 0;

            //Calculate sum of node values at current level
            List<TreeNode> currentLevel = new ArrayList<>();

            for(int i = 0; i < size; i++){
                TreeNode node = q.poll();
                currentLevel.add(node);

                if(node.left != null){
                    levelSum += node.left.val;
                    q.add(node.left);
                }

                if(node.right != null){
                    levelSum += node.right.val;
                    q.add(node.right);
                }
            }

            //Update values of nodes at current level
            for(TreeNode node : currentLevel){
                int childrenSum = 0;
                if (node.left != null) {
                    childrenSum += node.left.val;
                }
                if (node.right != null) {
                    childrenSum += node.right.val;
                }

                //Set the value of each child to the sum of cousin's values
                if (node.left != null) {
                    node.left.val = levelSum - childrenSum;
                }
                if (node.right != null) {
                    node.right.val = levelSum - childrenSum;
                }
            }
        }

        return root;
    }
}