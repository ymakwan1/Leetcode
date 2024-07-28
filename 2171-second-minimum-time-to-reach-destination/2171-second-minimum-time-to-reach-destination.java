class Solution {
    public int secondMinimum(int n, int[][] edges, int time, int change) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        // Priority queue to store (current time, node, path count)
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{0, 1, 0});

        // Arrays to store the shortest and second shortest times to reach each node
        int[] shortestTime = new int[n + 1];
        int[] secondShortestTime = new int[n + 1];
        Arrays.fill(shortestTime, Integer.MAX_VALUE);
        Arrays.fill(secondShortestTime, Integer.MAX_VALUE);

        shortestTime[1] = 0;

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int currTime = curr[0];
            int node = curr[1];
            int count = curr[2];

            if (count > 2) continue;

            for (int neighbor : graph.get(node)) {
                int newTime = currTime + time;
                if ((currTime / change) % 2 == 1) {
                    newTime += change - (currTime % change);
                }

                if (newTime < shortestTime[neighbor]) {
                    secondShortestTime[neighbor] = shortestTime[neighbor];
                    shortestTime[neighbor] = newTime;
                    pq.offer(new int[]{newTime, neighbor, 1});
                } else if (newTime > shortestTime[neighbor] && newTime < secondShortestTime[neighbor]) {
                    secondShortestTime[neighbor] = newTime;
                    pq.offer(new int[]{newTime, neighbor, 2});
                }
            }
        }

        return secondShortestTime[n];
    }
}
