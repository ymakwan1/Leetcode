import java.util.*;

class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        // Create an adjacency list for the reversed graph
        List<List<Integer>> reverseGraph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            reverseGraph.add(new ArrayList<>());
        }

        // Fill the reversed graph
        for (int[] edge : edges) {
            reverseGraph.get(edge[1]).add(edge[0]);
        }

        // List of sets to track ancestors of each node
        List<Set<Integer>> ancestors = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ancestors.add(new HashSet<>());
        }

        // Memoization array to store computed ancestors
        boolean[] computed = new boolean[n];

        // Perform DFS for each node
        for (int i = 0; i < n; i++) {
            if (!computed[i]) {
                dfs(i, reverseGraph, ancestors, computed);
            }
        }

        // Convert sets to lists and sort each list
        List<List<Integer>> result = new ArrayList<>();
        for (Set<Integer> set : ancestors) {
            List<Integer> sortedList = new ArrayList<>(set);
            Collections.sort(sortedList);
            result.add(sortedList);
        }

        return result;
    }

    private void dfs(int node, List<List<Integer>> graph, List<Set<Integer>> ancestors, boolean[] computed) {
        // Mark the current node as computed
        computed[node] = true;

        // Visit each ancestor of the current node
        for (int ancestor : graph.get(node)) {
            if (!computed[ancestor]) {
                dfs(ancestor, graph, ancestors, computed);
            }
            ancestors.get(node).add(ancestor);
            ancestors.get(node).addAll(ancestors.get(ancestor));
        }
    }
}
