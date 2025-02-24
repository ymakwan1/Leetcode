class Solution {
    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        int n = amount.length;

        // Step 1: Build the graph (tree)
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        // Step 2: Find Bob's path to node 0 and record his arrival times
        int[] bobTime = new int[n];
        Arrays.fill(bobTime, Integer.MAX_VALUE);
        Map<Integer, Integer> bobPath = new HashMap<>();
        findBobPath(graph, bob, -1, 0, bobPath, bobTime);

        // Step 3: Find Alice's max profit path using DFS
        return dfs(graph, 0, -1, 0, 0, bobTime, amount);
    }

    // Helper function to compute Bob's path to node 0
    private boolean findBobPath(List<List<Integer>> graph, int node, int parent, int time, 
                                Map<Integer, Integer> bobPath, int[] bobTime) {
        bobTime[node] = time;
        if (node == 0) {
            return true;
        }
        
        for (int neighbor : graph.get(node)) {
            if (neighbor == parent) continue;
            if (findBobPath(graph, neighbor, node, time + 1, bobPath, bobTime)) {
                bobPath.put(node, neighbor);
                return true;
            }
        }
        bobTime[node] = Integer.MAX_VALUE; // Reset if not on Bob's path
        return false;
    }

    // DFS for Alice's path to compute max profit
    private int dfs(List<List<Integer>> graph, int node, int parent, int time, int currProfit, 
                    int[] bobTime, int[] amount) {
        // Determine profit based on Alice and Bob's arrival time
        if (time < bobTime[node]) {
            currProfit += amount[node]; // Alice reaches first
        } else if (time == bobTime[node]) {
            currProfit += amount[node] / 2; // Both reach at the same time
        } 

        // Leaf node check
        int maxProfit = Integer.MIN_VALUE;
        boolean isLeaf = true;
        for (int neighbor : graph.get(node)) {
            if (neighbor == parent) continue;
            isLeaf = false;
            maxProfit = Math.max(maxProfit, dfs(graph, neighbor, node, time + 1, currProfit, bobTime, amount));
        }

        return isLeaf ? currProfit : maxProfit; // Return profit at leaves or max profit of children
    }
}
