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
    private int totalPairs = 0;

    public int countPairs(TreeNode root, int distance) {
        dfs(root, distance);
        return totalPairs;
    }

    private List<Integer> dfs(TreeNode node, int distance){
        if(node == null){
            return new ArrayList<>();
        }

        if(node.left == null && node.right == null){
            List<Integer> leafDistances = new ArrayList<>();
            leafDistances.add(1);
            return leafDistances;
        }

        List<Integer> leftDistances = dfs(node.left, distance);
        List<Integer> rightDistances = dfs(node.right, distance);

        for (int leftDist : leftDistances) {
            for (int rightDist : rightDistances) {
                if (leftDist + rightDist <= distance) {
                    totalPairs++;
                }
            }
        }

        List<Integer> currentDistances = new ArrayList<>();
        for (int dist : leftDistances) {
            if (dist + 1 < distance) {
                currentDistances.add(dist + 1);
            }
        }
        for (int dist : rightDistances) {
            if (dist + 1 < distance) {
                currentDistances.add(dist + 1);
            }
        }
        return currentDistances;
    }
}