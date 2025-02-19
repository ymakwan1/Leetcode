class Pair {
    long node;
    long time;
    Pair(long node, long time) {
        this.node = node;
        this.time = time;
    }
}

class Solution {
    public int countPaths(int n, int[][] roads) {
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] road : roads) {
            adj.get(road[0]).add(new Pair(road[1], road[2]));
            adj.get(road[1]).add(new Pair(road[0], road[2]));
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Long.compare(a.time, b.time));
        long[] distance = new long[n];
        long[] ways = new long[n];

        Arrays.fill(distance, Long.MAX_VALUE);
        Arrays.fill(ways, 0);

        distance[0] = 0;
        ways[0] = 1;
        long mod = (int)(1e9 + 7);

        pq.offer(new Pair(0, 0));

        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            long dist = current.time;
            long node = current.node;

            if (dist > distance[(int)node]) continue;

            for (Pair p : adj.get((int)node)) {
                long adjNode = p.node;
                long edgeW = p.time;

                if (dist + edgeW < distance[(int)adjNode]) {
                    distance[(int)adjNode] = dist + edgeW;
                    pq.offer(new Pair(adjNode, distance[(int)adjNode]));
                    ways[(int)adjNode] = ways[(int)node]; 
                } else if (dist + edgeW == distance[(int)adjNode]) {
                    ways[(int)adjNode] = (ways[(int)adjNode] + ways[(int)node]) % mod;
                }
            }
        }
        return (int)ways[n - 1];
    }
}
