class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < numCourses; i++) graph.put(i, new ArrayList<>());
        for (int[] prerequisite : prerequisites) {
            graph.get(prerequisite[0]).add(prerequisite[1]);
        }

        Boolean[][] memo = new Boolean[numCourses][numCourses];

        List<Boolean> result = new ArrayList<>();
        for (int[] query : queries) {
            result.add(dfs(query[0], query[1], memo, graph));
        }

        return result;
    }

    public boolean dfs(int source, int target, Boolean[][] memo, Map<Integer, List<Integer>> graph) {
        if (source == target) return true;
        if (memo[source][target] != null) return memo[source][target];

        for (int neighbor : graph.get(source)) {
            if (dfs(neighbor, target, memo, graph)) {
                return memo[source][target] = true;
            }
        }

        return memo[source][target] = false;
    }
}
