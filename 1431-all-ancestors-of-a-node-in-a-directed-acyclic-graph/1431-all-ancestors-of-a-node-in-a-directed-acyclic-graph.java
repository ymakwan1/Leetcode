class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        // adjacency list for the graph
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        
        // in degrees array to keep track of the number of incoming edges for each node
        int[] inDegree = new int[n];
        
        // Fill the graph and in-degrees array
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            inDegree[edge[1]]++;
        }
        
        // topological sort 
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }
        
        // List of sets to track ancestors of each node
        List<Set<Integer>> ancestors = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ancestors.add(new HashSet<>());
        }
        
        // Process each node in topological order
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbor : graph.get(node)) {
                // Add current node to the ancestors of the neighbor
                ancestors.get(neighbor).add(node);
                // Add all ancestors of the current node to the ancestors of the neighbor
                ancestors.get(neighbor).addAll(ancestors.get(node));
                // Decrease in-degree and add to queue if it becomes zero
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
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
}
