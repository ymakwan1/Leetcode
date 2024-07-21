import java.util.*;

class Solution {
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        List<Integer>[] rowGraph = buildGraph(rowConditions, k);
        List<Integer>[] colGraph = buildGraph(colConditions, k);
        
        List<Integer> rowOrder = topologicalSort(rowGraph, k);
        List<Integer> colOrder = topologicalSort(colGraph, k);
        
        if (rowOrder.isEmpty() || colOrder.isEmpty()) {
            return new int[0][0];
        }
        
        int[] rowPosition = new int[k + 1];
        int[] colPosition = new int[k + 1];
        
        for (int i = 0; i < k; i++) {
            rowPosition[rowOrder.get(i)] = i;
            colPosition[colOrder.get(i)] = i;
        }
        
        int[][] matrix = new int[k][k];
        
        for (int i = 1; i <= k; i++) {
            int row = rowPosition[i];
            int col = colPosition[i];
            matrix[row][col] = i;
        }
        
        return matrix;
    }
    
    private List<Integer>[] buildGraph(int[][] conditions, int k) {
        List<Integer>[] graph = new ArrayList[k + 1];
        for (int i = 0; i <= k; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int[] condition : conditions) {
            int u = condition[0];
            int v = condition[1];
            graph[u].add(v);
        }
        
        return graph;
    }
    
    private List<Integer> topologicalSort(List<Integer>[] graph, int k) {
        int[] inDegree = new int[k + 1];
        for (int i = 1; i <= k; i++) {
            for (int neighbor : graph[i]) {
                inDegree[neighbor]++;
            }
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= k; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }
        
        List<Integer> order = new ArrayList<>();
        while (!queue.isEmpty()) {
            int node = queue.poll();
            order.add(node);
            for (int neighbor : graph[node]) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }
        
        if (order.size() != k) {
            return new ArrayList<>();
        }
        
        return order;
    }
}
