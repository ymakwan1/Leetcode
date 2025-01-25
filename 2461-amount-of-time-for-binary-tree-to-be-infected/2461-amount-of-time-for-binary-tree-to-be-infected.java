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
    public int amountOfTime(TreeNode root, int start) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        buildGraph(root, null, graph);
        return bfs(graph, start);
    }

    private void buildGraph(TreeNode node, TreeNode parent, Map<Integer, List<Integer>> graph){
        if(node == null){
            return;
        }

        graph.putIfAbsent(node.val, new ArrayList<>());
        if(parent != null){
            graph.get(node.val).add(parent.val);
            graph.get(parent.val).add(node.val);
        }

        buildGraph(node.left, node, graph);
        buildGraph(node.right, node, graph);
    }

    private int bfs(Map<Integer, List<Integer>> graph, int start){
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        q.offer(start);
        visited.add(start);

        int time = -1;

        while(!q.isEmpty()){
            int size = q.size();
            time++;

            for(int i = 0; i < size; i++){
                int curr = q.poll();

                for(int n : graph.get(curr)){
                    if(!visited.contains(n)){
                        visited.add(n);
                        q.offer(n);
                    }
                }
            }
        }

        return time;
    }
}