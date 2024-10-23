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
    public long kthLargestLevelSum(TreeNode root, int k) {
        if(root == null){
            return -1;
        }

        //Minheap for k large sums
        PriorityQueue<Long> pq = new PriorityQueue<>();

        //Queue for BFS level order traversal
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        //BFS
        while(!queue.isEmpty()){
            int size = queue.size();
            long levelSum = 0;

            //Sum at current level
            for(int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                levelSum += node.val;

                if(node.left != null){
                    queue.offer(node.left);
                }

                if(node.right != null){
                    queue.offer(node.right);
                }
            }

            //Add level sum to heap to main k order
            pq.offer(levelSum);

            //Let PQ have only k sums
            if(pq.size() > k){
                pq.poll();
            }
        }

        return pq.size() == k ? pq.peek() : -1;
    }
}