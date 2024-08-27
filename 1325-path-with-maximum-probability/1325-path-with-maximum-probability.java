class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        // graph using adjacency lists
        List<List<Pair>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            double prob = succProb[i];
            graph.get(u).add(new Pair(v, prob));
            graph.get(v).add(new Pair(u, prob));
        }

        // Max-heap to store nodes to explore
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Double.compare(b.prob, a.prob));
        pq.offer(new Pair(start_node, 1.0));

        // Probability array to keep track of the max probability to each node
        double[] maxProb = new double[n];
        maxProb[start_node] = 1.0;

        // exploration
        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            int node = current.node;
            double prob = current.prob;

            // reached the end node, return the probability
            if (node == end_node) {
                return prob;
            }

            // Explore the neighbors
            for (Pair neighbor : graph.get(node)) {
                int nextNode = neighbor.node;
                double nextProb = neighbor.prob;

                // higher probability path is found, update and push to the queue
                if (prob * nextProb > maxProb[nextNode]) {
                    maxProb[nextNode] = prob * nextProb;
                    pq.offer(new Pair(nextNode, maxProb[nextNode]));
                }
            }
        }

        // can't reach the end node, return 0
        return 0.0;
    }
}

// class to store node and probability pairs
class Pair {
    int node;
    double prob;

    Pair(int node, double prob) {
        this.node = node;
        this.prob = prob;
    }
}
