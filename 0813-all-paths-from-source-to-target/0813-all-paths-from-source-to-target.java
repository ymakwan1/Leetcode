class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();

        List<Integer> path = new ArrayList<>();
        path.add(0);
        dfs(graph, 0, path, result);
        return result;
    }

    public void dfs(int[][] graph, int node, List<Integer> path, List<List<Integer>> result){
        if(node == graph.length - 1){
            result.add(new ArrayList<>(path));
            return;
        }

        for(int n : graph[node]){
            path.add(n);
            dfs(graph, n, path, result);
            path.remove(path.size() - 1);
        }
    }
}