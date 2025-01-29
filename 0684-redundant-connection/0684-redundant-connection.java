import java.util.*;

class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];

            // Check if a cycle is formed before adding the edge
            if (hasPath(u, v, graph, new HashSet<>())) {
                return edge;  // This is the redundant edge
            }

            // Add the edge to the graph
            graph.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            graph.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
        }

        return new int[]{-1, -1};  // Should never reach here
    }

    private boolean hasPath(int u, int v, Map<Integer, List<Integer>> graph, Set<Integer> visited) {
        if (u == v) return true;  // Cycle detected
        if (!graph.containsKey(u) || !visited.add(u)) return false;

        for (int neighbor : graph.get(u)) {
            if (hasPath(neighbor, v, graph, visited)) {
                return true;
            }
        }

        return false;
    }
}
