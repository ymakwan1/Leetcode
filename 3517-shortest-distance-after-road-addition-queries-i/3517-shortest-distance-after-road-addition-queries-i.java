class Solution {
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        
        //Each city i has a road to city i+1
        for (int i = 0; i < n - 1; i++) {
            graph.get(i).add(i + 1);
        }
        
        //Answer list to store the result after each query
        int[] answer = new int[queries.length];
        
        //Process each query
        for (int q = 0; q < queries.length; q++) {
            //Add the new road from query
            int u = queries[q][0];
            int v = queries[q][1];
            graph.get(u).add(v);
            
            //Use BFS to find the shortest path from city 0 to city n-1
            answer[q] = bfs(n, graph);
        }
        
        return answer;
    }

    private int bfs(int n, List<List<Integer>> graph){
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];
        int[] dist = new int[n];
        
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        queue.offer(0);
        visited[0] = true;
        dist[0] = 0;
        
        while (!queue.isEmpty()) {
            int city = queue.poll();
            
            //Explore the neighbors
            for (int neighbor : graph.get(city)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    dist[neighbor] = dist[city] + 1;
                    queue.offer(neighbor);
                }
            }
        }
        
        //Return the shortest distance to city n-1
        return dist[n - 1] == Integer.MAX_VALUE ? -1 : dist[n - 1];
    }
}