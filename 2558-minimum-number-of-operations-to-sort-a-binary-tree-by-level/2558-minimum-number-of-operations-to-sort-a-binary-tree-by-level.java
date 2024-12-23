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
    public int minimumOperations(TreeNode root) {
        if(root == null){
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int totalSwaps = 0;

        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> level = new ArrayList<>();

            for(int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                level.add(node.val);

                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
            }

            totalSwaps += minSwapsToSort(level);
        }

        return totalSwaps;
    }

    private int minSwapsToSort(List<Integer> nums){
        int n = nums.size();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++){
            arr[i] = nums.get(i);
        }

        int[][] pairs = new int[n][2];
        for(int i = 0; i < n; i++){
            pairs[i][0] = arr[i];
            pairs[i][1] = i;
        }
        Arrays.sort(pairs, Comparator.comparingInt(a -> a[0]));

        boolean[] visited = new boolean[n];
        int swaps = 0;

        for(int i = 0; i < n; i++){
            if(visited[i] || pairs[i][1] == i){
                continue;
            }

            int cycleSize = 0;
            int j = i;

            while (!visited[j]) {
                visited[j] = true;
                j = pairs[j][1];
                cycleSize++;
            }

            if (cycleSize > 1) swaps += (cycleSize - 1);
        }

        return swaps;
    }
}