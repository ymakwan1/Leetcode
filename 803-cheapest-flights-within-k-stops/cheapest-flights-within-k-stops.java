import java.util.*;

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // Adjacency list using HashMap
        Map<Integer, List<int[]>> adj = new HashMap<>();
        for (int[] flight : flights) {
            adj.computeIfAbsent(flight[0], x -> new ArrayList<>()).add(new int[]{flight[1], flight[2]});
        }

        // Queue for BFS traversal (stops, node, cost)
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, src, 0}); // {stops, node, cost}

        // Distance array to store the minimum cost to reach each node
        int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[src] = 0;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int stops = cur[0], node = cur[1], cost = cur[2];

            if (stops > k) continue;

            for (int[] neighbor : adj.getOrDefault(node, new ArrayList<>())) {
                int adjNode = neighbor[0], price = neighbor[1];
                int newCost = cost + price;

                // Only update if we find a cheaper way to reach adjNode
                if (newCost < distance[adjNode]) {
                    distance[adjNode] = newCost;
                    q.add(new int[]{stops + 1, adjNode, newCost});
                }
            }
        }

        return distance[dst] == Integer.MAX_VALUE ? -1 : distance[dst];
    }
}
