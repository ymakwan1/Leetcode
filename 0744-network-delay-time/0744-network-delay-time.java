class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {

        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : times) {
            graph.get(edge[0]).add(new int[]{edge[1], edge[2]}); //neighbor, weight
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{0, k}); //weight, node

        int[] distance = new int[n+1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[k] = 0;

        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int dist = curr[0];
            int node = curr[1];

            if(dist > distance[node]){
                continue;
            }

            for(int[] nt : graph.get(node)){
                int adjNode = nt[0];
                int wt = nt[1];

                if(dist + wt < distance[adjNode]){
                    distance[adjNode] = dist + wt;
                    pq.offer(new int[]{distance[adjNode], adjNode});
                }
            }
        }

        int maxTime = 0;
        for(int i = 1; i <= n; i++){
            if(distance[i] == Integer.MAX_VALUE){
                return -1;
            }
            maxTime = Math.max(maxTime, distance[i]);
        }
        return maxTime;
    }
}